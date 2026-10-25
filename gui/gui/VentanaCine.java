package gui;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaCine {
		
		private static final long serialVersionUID = 1L;
		
		public static void main(String[] args) {
			
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			
			ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaPrincipal.setSize(900, 700);
			ventanaPrincipal.setTitle("CineDeusto");
			ventanaPrincipal.setLocationRelativeTo(null);
			ventanaPrincipal.setBackground(Color.WHITE);
			
			
			ventanaPrincipal.setVisible(true);
		}

}


