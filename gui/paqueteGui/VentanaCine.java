package paqueteGui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class VentanaCine extends JFrame {		
	private static final long serialVersionUID = 1L;
	
	private JButton izq;
	private JButton dch;
	private JLabel imagen;
	
	private int indiceActual = 0; //Indice para pasar las imagenes

	//Imagenes
	private String [] rutasImagenes = { 
			"/resource/dune3.png",
			"/resource/laBolaNegra.png",
			"/resource/sentidoYSensibilidad.png",
			"/resource/clayface.png"
	};
	
	public VentanaCine() {
		setTitle("CineDeusto");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		izq = new JButton("←"); //Boton para pasar imagenes a la izq 
		izq.setBounds(30, 300, 60, 40);
		
		izq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indiceActual --;
				if (indiceActual < 0) {
					indiceActual = rutasImagenes.length -1;
				}
				actualizarImagen();
			}
		});
		
		dch = new JButton("→"); //Boton para pasar imagenes a la dch 
		dch.setBounds(795, 300, 60, 40);
		
		dch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indiceActual ++;
				if (indiceActual >= rutasImagenes.length) {
					indiceActual = 0;
				}
				actualizarImagen();
			}
		}); 

		imagen = new JLabel();
		imagen.setBounds(120, 50, 650, 550);
		
		add(izq);
		add(dch);
		add(imagen);
		
		actualizarImagen();
		
		setVisible(true);
		
		}
		private void actualizarImagen() {
			ImageIcon ImagenOriginal = new ImageIcon(getClass().getResource(rutasImagenes[indiceActual]));
			Image ImageneEscala = ImagenOriginal.getImage().getScaledInstance(650, 550, Image.SCALE_SMOOTH);
			imagen.setIcon(new ImageIcon(ImageneEscala));
		
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new VentanaCine();

				}
			});
		}
	
	}



