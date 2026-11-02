package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		this.setTitle("MenuPrincipal");
		this.setSize(1080, 920);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		//panel
		JPanel panelBotones = new JPanel(new GridLayout(3,3));
		panelBotones.setBackground(Color.GRAY);
		
		
		//Botones
		JButton botonCartelera = new JButton("Cartelera");
		
		//AddBotones
		panelBotones.add(botonCartelera);
		
		//AddPaneles
		add(panelBotones);

		// panel
		JPanel panel = new JPanel(new GridLayout(3, 3));

		setVisible(true);
	}
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}
