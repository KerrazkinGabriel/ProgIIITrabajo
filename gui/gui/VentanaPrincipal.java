package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JButton izq;
	JButton dch;
	JLabel imagen;
	
	public VentanaPrincipal () {
		super("CinePrincipal");
		
		setLayout(null);
		
		izq = new JButton("←");
		izq.setBounds(10, 130, 60, 30); // Nos sirve para editar el tamaño del botón
		dch = new JButton("→");
		dch.setBounds(815, 130, 60, 30); 
		
		imagen = new JLabel();
		
		add(izq);
		add(dch);
	}
	
}
