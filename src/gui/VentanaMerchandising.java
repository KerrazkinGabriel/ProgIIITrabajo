	package gui;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Cursor;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.util.ArrayList;
	import java.util.List;
	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.SwingConstants;
	import javax.swing.SwingUtilities;
	
	public class VentanaMerchandising extends JFrame {
	
	    /* Clase interna para representar los datos de cada producto */
	    public static class ArticuloMerch {
	        private String pelicula;
	        private String nombre;
	        private String descripcion;
	        private double precio;
	
	        public ArticuloMerch(String pelicula, String nombre, String descripcion, double precio) {
	            this.pelicula = pelicula;
	            this.nombre = nombre;
	            this.descripcion = descripcion;
	            this.precio = precio;
	        }
	
	        public String getPelicula() { return pelicula; }
	        public String getNombre() { return nombre; }
	        public String getDescripcion() { return descripcion; }
	        public double getPrecio() { return precio; }
	    }
	
	    private List<ArticuloMerch> listaMerch;
	
	    /* Colores base para la interfaz */
	    private final Color COLOR_FONDO = new Color(241, 243, 245);
	    private final Color COLOR_TARJETA = Color.WHITE;
	    private final Color COLOR_PRIMARIO = new Color(59, 91, 219);
	    private final Color COLOR_PRECIO = new Color(43, 138, 62);
	    private final Color COLOR_BORDE = new Color(222, 226, 230);
	
	    public VentanaMerchandising() {
	        setTitle("CineStore - Merchandising Oficial & Combos Exclusivos");
	        setSize(880, 620);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLayout(new BorderLayout());
	        getContentPane().setBackground(COLOR_FONDO);
	
	        inicializarArticulos();
	
	        /* Panel superior: navegacion, filtros y titulo */
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
	        filaNav2.add(crearBotonNav("Cubos & Vasos"));
	        filaNav2.add(crearBotonNav("Coleccionables"));
	        filaNav2.add(crearBotonNav("Combos de Estreno"));
	        panelNorte.add(filaNav2);
	
	        JLabel lblTitulo = new JLabel("CATÁLOGO OFICIAL DE MERCHANDISING Y PROMOCIONES", SwingConstants.CENTER);
	        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblTitulo.setForeground(new Color(33, 37, 41));
	        panelNorte.add(lblTitulo);
	
	        add(panelNorte, BorderLayout.NORTH);
	
	        /* Panel central: cuadricula con scroll para las tarjetas de productos */
	        int filas = (int) Math.ceil(listaMerch.size() / 3.0);
	        JPanel panelGrid = new JPanel(new GridLayout(filas, 3, 14, 14));
	        panelGrid.setBackground(COLOR_FONDO);
	        panelGrid.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
	
	        for (ArticuloMerch item : listaMerch) {
	            panelGrid.add(crearTarjetaMerch(item));
	        }
	
	        JScrollPane scrollPane = new JScrollPane(panelGrid);
	        scrollPane.getViewport().setBackground(COLOR_FONDO);
	        scrollPane.setBorder(BorderFactory.createEmptyBorder());
	        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	        add(scrollPane, BorderLayout.CENTER);
	    }
	
	    /* Carga datos de prueba */
	    private void inicializarArticulos() {
	        listaMerch = new ArrayList<>();
	        listaMerch.add(new ArticuloMerch("Dune 2", "Cubo Metálico Gusano", "Cubo metálico edición coleccionista + Palomitas", 14.50));
	        listaMerch.add(new ArticuloMerch("Dune 2", "Vaso Coleccionable 1L", "Vaso exclusivo con topper de personaje + Refresco", 8.00));
	        listaMerch.add(new ArticuloMerch("Deadpool 3", "Pack Dúo Palomitas", "Cubo temático + 2 Bebidas medianas + Merch", 18.00));
	        listaMerch.add(new ArticuloMerch("Gladiator II", "Copa Trofeo de Metal", "Copa metálica grabada edición limitada de estreno", 12.00));
	        listaMerch.add(new ArticuloMerch("Batman", "Figura Cabezón Funko", "Figura coleccionable oficial exclusiva de cine", 16.50));
	        listaMerch.add(new ArticuloMerch("Star Wars", "Cubo Casco Darth Vader", "Cubo 3D con relieve para palomitas gigantes", 15.00));
	        listaMerch.add(new ArticuloMerch("Universal", "Gorra Bordada de Estreno", "Gorra oficial ajustable con logo del film", 11.00));
	        listaMerch.add(new ArticuloMerch("Deluxe", "Mega Combo Coleccionista", "Cubo metal + Vaso topper + Palomitas XXL", 24.50));
	        listaMerch.add(new ArticuloMerch("Infantil", "Cubo Balde Animación", "Cubo con asa temática + Refresco + Regalo", 9.90));
	    }
	
	    /* Metodo auxiliar para crear botones con un estilo comun */
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
	
	    /* Crea la tarjeta visual de cada producto con su boton de compra */
	    private JPanel crearTarjetaMerch(ArticuloMerch item) {
	        JPanel tarjeta = new JPanel(new BorderLayout(0, 6));
	        tarjeta.setBackground(COLOR_TARJETA);
	        tarjeta.setPreferredSize(new Dimension(240, 210));
	        tarjeta.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(COLOR_BORDE, 1),
	            BorderFactory.createEmptyBorder(0, 0, 8, 0)
	        ));
	
	        // Cabecera con nombre de la pelicula y producto
	        JPanel panelHeader = new JPanel(new BorderLayout());
	        panelHeader.setBackground(new Color(237, 242, 255));
	        panelHeader.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
	
	        JLabel lblTit = new JLabel(item.getPelicula() + " • " + item.getNombre(), SwingConstants.CENTER);
	        lblTit.setFont(new Font("Segoe UI", Font.BOLD, 12));
	        lblTit.setForeground(COLOR_PRIMARIO);
	        panelHeader.add(lblTit, BorderLayout.CENTER);
	
	        tarjeta.add(panelHeader, BorderLayout.NORTH);
	
	        // Icono y descripcion (usa HTML para el salto de linea)
	        JPanel panelCentro = new JPanel(new GridLayout(2, 1, 2, 2));
	        panelCentro.setBackground(COLOR_TARJETA);
	
	        JLabel lblIcono = new JLabel("🍿", SwingConstants.CENTER);
	        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 36));
	        panelCentro.add(lblIcono);
	
	        JLabel lblDesc = new JLabel("<html><center style='color:#495057;'>" + item.getDescripcion() + "</center></html>", SwingConstants.CENTER);
	        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        panelCentro.add(lblDesc);
	
	        tarjeta.add(panelCentro, BorderLayout.CENTER);
	
	        // Precio y boton de seleccion con dialogo de confirmacion
	        JPanel panelSur = new JPanel(new GridLayout(2, 1, 5, 5));
	        panelSur.setBackground(COLOR_TARJETA);
	        panelSur.setBorder(BorderFactory.createEmptyBorder(0, 14, 4, 14));
	
	        JLabel lblPrecio = new JLabel(String.format("%.2f €", item.getPrecio()), SwingConstants.CENTER);
	        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblPrecio.setForeground(COLOR_PRECIO);
	        panelSur.add(lblPrecio);
	
	        JButton btnElegir = new JButton("Seleccionar");
	        btnElegir.setFont(new Font("Segoe UI", Font.BOLD, 12));
	        btnElegir.setBackground(COLOR_PRIMARIO);
	        btnElegir.setForeground(Color.WHITE);
	        btnElegir.setFocusPainted(false);
	        btnElegir.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btnElegir.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
	
	        btnElegir.addActionListener(e -> {
	            int respuesta = JOptionPane.showConfirmDialog(
	                this,
	                "¿Añadir al carrito:\n" + item.getNombre() + " (" + String.format("%.2f €", item.getPrecio()) + ")?",
	                "Confirmación de Pedido",
	                JOptionPane.YES_NO_OPTION
	            );
	            if (respuesta == JOptionPane.YES_OPTION) {
	                JOptionPane.showMessageDialog(this, "¡Artículo añadido al resumen!");
	            }
	        });
	        panelSur.add(btnElegir);
	
	        tarjeta.add(panelSur, BorderLayout.SOUTH);
	        return tarjeta;
	    }
	
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new VentanaMerchandising().setVisible(true));
	    }
	}