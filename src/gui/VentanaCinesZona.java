package gui;

import java.awt.BorderLayout;
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

		// NORTE, el titulo y el desplegable de las zonas
		JLabel titulo = new JLabel("Nuestros cines", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));

		JPanel panelZona = new JPanel(new FlowLayout());
		panelZona.add(new JLabel("Zona: "));
		panelZona.add(comboZonas);

		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.add(titulo, BorderLayout.NORTH);
		panelNorte.add(panelZona, BorderLayout.CENTER);
		add(panelNorte, BorderLayout.NORTH);

		// CENTRO, la tabla

		add(new JScrollPane(tabla), BorderLayout.CENTER); // JScrollPane para uwe salgan lass cabeceras de columna

		// SUR: el botón cerrar
		JPanel panelBoton = new JPanel(new FlowLayout());
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
		String zona = (String) comboZonas.getSelectedItem();
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
