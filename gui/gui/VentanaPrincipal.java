package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal() {
		this.setTitle("MenuPrincipal");
		this.setSize(1080,920);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel
		JPanel panel = new JPanel(new GridLayout(3,3));
		
		setVisible(true);
	}
	
}
