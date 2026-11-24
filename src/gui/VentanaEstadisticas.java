package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*
 * El runnable se usa debido a que estamos ejecutando un segundo hilo para las ventas cada 3 segundos.
 * Por ello implementamos la interfaz runnable para obligar a la clase a tener un metodo run()
 */
public class VentanaEstadisticas extends JFrame implements Runnable { 

    private JLabel lblEntradas;
    private JLabel lblRecaudacion;
    private JLabel lblFidelizados;
    private JLabel lblOcupacion;
    private JLabel lblHoraUltima;
    private JLabel lblPromedio;
    private JTextArea txtHistorialLog;

    // Variables acumuladoras para las metricas
    private int totalVentas = 0;
    private double dineroTotal = 0.0;
    private final double PRECIO_ENTRADA = 8.50;

    // Control del hilo en segundo plano
    private Thread hiloMonitor;
    private boolean enEjecucion = true;
    private boolean enPausa = false;
    private JButton btnPausar;

    private static final String FICHERO_LOG = "registro_ventas.txt";

    // Colores de la interfaz
    private final Color COLOR_FONDO = new Color(241, 243, 245);
    private final Color COLOR_TARJETA = Color.WHITE;
    private final Color COLOR_PRIMARIO = new Color(59, 91, 219);
    private final Color COLOR_VALOR = new Color(43, 138, 62);
    private final Color COLOR_BORDE = new Color(222, 226, 230);

    public VentanaEstadisticas() {
        setTitle("Panel de Estadísticas y Control de Ventas - Cine");
        setSize(880, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COLOR_FONDO);

        // Barra superior con botones y titulo
        JPanel panelNorte = new JPanel(new GridLayout(3, 1, 6, 6));
        panelNorte.setBackground(COLOR_FONDO);
        panelNorte.setBorder(BorderFactory.createEmptyBorder(12, 10, 6, 10));

        JPanel filaNav1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 2));
        filaNav1.setBackground(COLOR_FONDO);
        filaNav1.add(crearBotonNav("Películas"));
        filaNav1.add(crearBotonNav("Promociones"));
        filaNav1.add(crearBotonNav("Bonos"));
        filaNav1.add(crearBotonNav("Mi Cuenta"));
        panelNorte.add(filaNav1);

        JPanel filaNav2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 2));
        filaNav2.setBackground(COLOR_FONDO);
        filaNav2.add(crearBotonNav("Resumen Diario"));
        filaNav2.add(crearBotonNav("Por Sala"));
        filaNav2.add(crearBotonNav("Auditoría"));
        panelNorte.add(filaNav2);

        JLabel lblTitulo = new JLabel("PANEL DE AUDITORÍA Y VENTAS EN TIEMPO REAL", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTitulo.setForeground(new Color(33, 37, 41));
        panelNorte.add(lblTitulo);

        add(panelNorte, BorderLayout.NORTH);

        // Panel central con tarjetas de metricas y area de texto para el historial
        JPanel panelContenedorCentro = new JPanel(new BorderLayout(12, 12));
        panelContenedorCentro.setBackground(COLOR_FONDO);
        panelContenedorCentro.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));

        JPanel panelGrid = new JPanel(new GridLayout(2, 3, 14, 14));
        panelGrid.setBackground(COLOR_FONDO);

        lblEntradas = new JLabel("0", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Entradas Emitidas", "🎫", "Total tickets expedidos hoy", lblEntradas, "Inspeccionar"));

        lblRecaudacion = new JLabel("0.00 €", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Recaudación en Caja", "💰", "Facturación bruta registrada", lblRecaudacion, "Arqueo"));

        lblOcupacion = new JLabel("0 %", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Ocupación de Butacas", "💺", "Aforo completado en salas", lblOcupacion, "Detalle"));

        lblFidelizados = new JLabel("0 %", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Clientes Fidelizados", "⭐", "Ventas a usuarios con carnet", lblFidelizados, "Socios"));

        lblPromedio = new JLabel("8.50 €", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Ticket Promedio", "🏷️", "Ingreso estimado por cliente", lblPromedio, "Análisis"));

        lblHoraUltima = new JLabel("--:--:--", SwingConstants.CENTER);
        panelGrid.add(crearTarjetaMetrica("Última Transacción", "⏱️", "Hora del último registro", lblHoraUltima, "Histórico"));

        panelContenedorCentro.add(panelGrid, BorderLayout.NORTH);

        // Cuadro de texto para ver las ventas registradas
        JPanel panelLog = new JPanel(new BorderLayout(5, 5));
        panelLog.setBackground(COLOR_TARJETA);
        panelLog.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        JLabel lblTitLog = new JLabel("Historial de Transacciones en Disco (registro_ventas.txt):");
        lblTitLog.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitLog.setForeground(new Color(73, 80, 87));
        panelLog.add(lblTitLog, BorderLayout.NORTH);

        txtHistorialLog = new JTextArea(5, 40);
        txtHistorialLog.setEditable(false);
        txtHistorialLog.setFont(new Font("Consolas", Font.PLAIN, 11));
        txtHistorialLog.setBackground(new Color(248, 249, 250));
        txtHistorialLog.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        panelLog.add(new JScrollPane(txtHistorialLog), BorderLayout.CENTER);

        panelContenedorCentro.add(panelLog, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(panelContenedorCentro);
        scrollPane.getViewport().setBackground(COLOR_FONDO);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Boton inferior de control
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));
        panelSur.setBackground(COLOR_FONDO);

        btnPausar = new JButton("Pausar Monitor");
        btnPausar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPausar.setBackground(Color.WHITE);
        btnPausar.setForeground(new Color(73, 80, 87));
        btnPausar.setFocusPainted(false);
        btnPausar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 1),
            BorderFactory.createEmptyBorder(6, 14, 6, 14)
        ));
        btnPausar.addActionListener(e -> alternarPausa());
        panelSur.add(btnPausar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCerrar.setBackground(new Color(224, 49, 49));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(e -> {
            enEjecucion = false; // Detiene el bucle del hilo antes de cerrar
            dispose();
        });
        panelSur.add(btnCerrar);

        add(panelSur, BorderLayout.SOUTH);

        // Recupera datos previos si el archivo ya existia
        cargarHistorialPrevio();

        // Arranca el hilo de simulacion
        hiloMonitor = new Thread(this);
        hiloMonitor.start();
    }

    private JButton crearBotonNav(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(73, 80, 87));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 1),
            BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JPanel crearTarjetaMetrica(String titulo, String emoji, String descripcion, JLabel lblValor, String textoBoton) {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 6));
        tarjeta.setBackground(COLOR_TARJETA);
        tarjeta.setPreferredSize(new Dimension(240, 200));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 1),
            BorderFactory.createEmptyBorder(0, 0, 8, 0)
        ));

        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(new Color(237, 242, 255));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        JLabel lblTit = new JLabel(titulo, SwingConstants.CENTER);
        lblTit.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTit.setForeground(COLOR_PRIMARIO);
        panelHeader.add(lblTit, BorderLayout.CENTER);
        tarjeta.add(panelHeader, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(2, 1, 2, 2));
        panelCentro.setBackground(COLOR_TARJETA);

        JLabel lblIcono = new JLabel(emoji, SwingConstants.CENTER);
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        panelCentro.add(lblIcono);

        JLabel lblDesc = new JLabel("<html><center style='color:#495057;'>" + descripcion + "</center></html>", SwingConstants.CENTER);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        panelCentro.add(lblDesc);
        tarjeta.add(panelCentro, BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new GridLayout(2, 1, 5, 5));
        panelSur.setBackground(COLOR_TARJETA);
        panelSur.setBorder(BorderFactory.createEmptyBorder(0, 14, 4, 14));

        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblValor.setForeground(COLOR_VALOR);
        panelSur.add(lblValor);

        JButton btnAccion = new JButton(textoBoton);
        btnAccion.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnAccion.setBackground(COLOR_PRIMARIO);
        btnAccion.setForeground(Color.WHITE);
        btnAccion.setFocusPainted(false);
        btnAccion.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        btnAccion.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnAccion.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Métrica: " + titulo + "\nValor actual: " + lblValor.getText(), 
                "Información", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        panelSur.add(btnAccion);

        tarjeta.add(panelSur, BorderLayout.SOUTH);
        return tarjeta;
    }

    /* Lee el archivo para restaurar ventas y dinero acumulado de sesiones anteriores */
    private void cargarHistorialPrevio() {
        File archivo = new File(FICHERO_LOG);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                txtHistorialLog.append(linea + "\n");
                
                // Si la linea es una venta, suma una entrada y su importe al total
                if (linea.contains("Entrada #")) {
                    totalVentas++;
                    dineroTotal += PRECIO_ENTRADA;
                }
            }
            actualizarValoresUI("--:--:--");
        } catch (Exception e) {
            txtHistorialLog.append("[Aviso] No se pudieron cargar registros previos.\n");
        }
    }

    /* Guarda cada registro en disco en modo append (true para no sobreescribir) */
    private void guardarLineaEnDisco(String linea) {
        try (FileWriter fw = new FileWriter(FICHERO_LOG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(linea);
        } catch (Exception e) {
            System.err.println("Error al guardar en log: " + e.getMessage());
        }
    }

    /* Alterna el estado del monitor entre pausa y activo usando un booleano */
    private void alternarPausa() {
        enPausa = !enPausa;
        if (enPausa) {
            btnPausar.setText("Reanudar Monitor");
            txtHistorialLog.append("[PAUSA] Monitor pausado manualmente.\n");
        } else {
            btnPausar.setText("Pausar Monitor");
            txtHistorialLog.append("[ACTIVO] Monitor reanudado.\n");
        }
    }

    /* Calcula porcentajes y refresca las etiquetas en pantalla */
    private void actualizarValoresUI(String hora) {
        lblEntradas.setText(String.valueOf(totalVentas));
        lblRecaudacion.setText(String.format("%.2f €", dineroTotal));

        // Calculo de aforo sobre una capacidad maxima de 50 butacas (tope 100%)
        int porcentajeAforo = Math.min(100, (int) ((totalVentas / 50.0) * 100));
        lblOcupacion.setText(porcentajeAforo + " %");

        // Estimacion de socios segun el volumen de ventas
        double porcentajeSocios = (totalVentas == 0) ? 0.0 : ((totalVentas % 3 == 0) ? 35.0 : 42.5);
        lblFidelizados.setText(String.format("%.1f %%", porcentajeSocios));

        // Muestra la hora local de la transaccion
        lblHoraUltima.setText(hora);
    }

    /* Hilo en segundo plano: simula ventas recurrentes cada 3 segundos */
    @Override
    public void run() {
        // Formato para extraer la hora local del sistema
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        while (enEjecucion) {
            try {
                Thread.sleep(3000);

                // Si no esta pausado, registra una nueva venta
                if (!enPausa) {
                    // Suma una entrada y acumula el precio en la caja
                    totalVentas++;
                    dineroTotal += PRECIO_ENTRADA;

                    // Obtiene la hora actual del equipo y arma el texto del log
                    String hora = sdf.format(new Date());
                    String registro = "[" + hora + "] Entrada #" + totalVentas + " emitida | +8.50 €";

                    // Guarda en el archivo de texto
                    guardarLineaEnDisco(registro);

                    // Pasa la actualizacion visual al hilo de eventos de Swing (EDT)
                    SwingUtilities.invokeLater(() -> {
                        actualizarValoresUI(hora);
                        txtHistorialLog.append(registro + "\n");
                        txtHistorialLog.setCaretPosition(txtHistorialLog.getDocument().getLength()); // Auto-scroll
                    });
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaEstadisticas().setVisible(true));
    }
}

/*
 * Y para que se conecte a la hora local lo que hacemos es que cada 3 segundos, cuando el hilo procesa una nueva venta 
 * simulada (ficticia), toma la marca o punto de guardado del tiempo actual del sistema con new Date(). 
 * Para que no aparezca un número en milisegundos imposible de entender a primera vista, usamos SimpleDateFormat 
 * con el patrón horas/minutos/segundos
 */

/*
 * Lo que hacemos para que el monitor se pause o se reanude usamos un patrón de bandera booleana (enPausa). 
 * Cuando el usuario pulsa el botón, el valor se invierte y la interfaz se adapta ofreciendo 'Reanudar' o 'Pausar'. 
 * Mientras enPausa es verdadero, el ciclo de 3 segundos del hilo sigue corriendo en segundo plano pero descarta la 
 * lógica de facturación y escritura hasta que vuelva a activarse. Hacemos esto dado que en Java detener un hilo de 
 * manera brusca es perjudicial.
 */