package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Cine;
import domain.GestorCines;

public class VentanaCinesZona extends JFrame {

	private GestorCines gestor;

	private JComboBox<String> comboZonas = new JComboBox<String>();

	private JTable tabla = new JTable();
	private JButton botonCerrar = new JButton("Cerrar");

	public VentanaCinesZona(GestorCines gestor) {
		this.gestor = gestor;

		setTitle("Cine - Nuestros Cines");
		setSize(1300, 380);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		// FONDO NEGRO
		getContentPane().setBackground(RendererCineZona.NEGRO);

		// NORTE, el titulo y el desplegable de las zonas
		JLabel titulo = new JLabel("Nuestros cines", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setForeground(Color.WHITE);

		JLabel textoZona = new JLabel("Zona ");
		textoZona.setFont(new Font("Arial", Font.BOLD, 16));
		titulo.setForeground(RendererCineZona.ROJO);

		JPanel panelZona = new JPanel(new FlowLayout());
		panelZona.setBackground(RendererCineZona.NEGRO);
		panelZona.add(textoZona);
		panelZona.add(comboZonas);

		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.setBackground(RendererCineZona.NEGRO);
		panelNorte.add(titulo, BorderLayout.NORTH);
		panelNorte.add(panelZona, BorderLayout.CENTER);
		add(panelNorte, BorderLayout.NORTH);

		// CENTRO, la tabla
		// Celdas dibujadas con el Render
		tabla.setDefaultRenderer(Object.class, new RendererCineZona());
		tabla.setRowHeight(44); // alto de las filas
		tabla.setShowGrid(false); // no lineas

		// Cabecera, Colores
		tabla.getTableHeader().setBackground(RendererCineZona.ROJO);
		tabla.getTableHeader().setForeground(Color.WHITE);
		tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));

		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(RendererCineZona.NEGRO);
		panelCentro.add(new JLabel("             "), BorderLayout.WEST); // para que la tabla no ocupe toda la ventana
		panelCentro.add(new JLabel("             "), BorderLayout.EAST);
		panelCentro.add(new JScrollPane(tabla), BorderLayout.CENTER);
		add(panelCentro, BorderLayout.CENTER);

		// SUR: el botón cerrar

		// boton en rojo
		botonCerrar.setBackground(RendererCineZona.ROJO);
		botonCerrar.setForeground(Color.WHITE);
		botonCerrar.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel panelBoton = new JPanel(new FlowLayout());
		panelBoton.setBackground(RendererCineZona.NEGRO);
		panelBoton.add(botonCerrar);
		add(panelBoton, BorderLayout.SOUTH);

		// Rellenamos deplegable
		for (String zona : gestor.getZonas()) {
			comboZonas.addItem(zona);
		}

		// Recargamos la tabla cuando se escoge una zona diferente
		comboZonas.addActionListener(e -> cargarTabla());
		botonCerrar.addActionListener(e -> dispose());
		cargarTabla();
	}

	private void cargarTabla() {
		String zona = (String) comboZonas.getSelectedItem(); //preguntamos que zona esta seleccionada actualmente
		if (zona == null) {
			return;
		}

		ArrayList<Cine> cinesZona = gestor.cinePorZona(zona);

		tabla.setModel(new ModeloCines(cinesZona));
	}

	public static void main(String[] args) {
		new VentanaCinesZona(new GestorCines()).setVisible(true);
	}

}
