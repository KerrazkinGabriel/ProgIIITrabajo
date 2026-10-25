package gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaCine extends JFrame {		
	private static final long serialVersionUID = 1L;
	
	private JButton izq;
	private JButton dch;
	private JLabel imagen;

	public VentanaCine() {
		setTitle("CineDeusto");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		izq = new JButton("←"); //Boton para pasar imagenes a la izq 
		izq.setBounds(30, 300, 60, 40);
		
		dch = new JButton("→"); //Boton para pasar imagenes a la dch 
		dch.setBounds(795, 300, 60, 40);
		
		imagen = new JLabel();
		imagen.setBounds(120, 50, 650, 550);
		
		//Imagenes
		String ruta1 = "/hero_banner_1940x960_sentido_y_sensibilidad.jpg";
		String ruta2 = "/hero_banner_1940x960-clayface.jpg";
		String ruta3 = "/hero-banner-dune-parte-tres-va.jpg";
		String ruta4 = "/hero-banner-la-bola-negra.jpg";
		
		ImageIcon bannerOriginal = new ImageIcon(getClass().getResource(ruta1));
		Image imgEscalada = bannerOriginal.getImage().getScaledInstance(650, 550, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(imgEscalada));

			add(izq);
			add(dch);
			add(imagen);
		}
	}



