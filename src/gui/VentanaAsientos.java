package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import domain.Asiento;
import domain.Sala;
import domain.TipoAsiento;

public class VentanaAsientos extends JFrame {
	private static final long serialVersionUID = 1L;
	private Sala sala;
	List<Asiento> asientos = sala.getAsientos();
	Integer nAsientos = asientos.size();
	Integer nColumnas = 0;
	Integer nFilas = 0;

	public VentanaAsientos(Sala sala) {
		for (Asiento asiento : asientos) {
			if (nColumnas < asiento.getColumna() || nFilas < asiento.getFila()) {
				nColumnas = asiento.getColumna();
				nFilas = asiento.getFila();
			}
		}

		this.setTitle("Asientos");
		this.setSize(820, 500);
		this.setLayout(new BorderLayout(10, 10));

		JPanel panelAsientos = crearPanelAsiento();

		this.setVisible(true);

	}

	private JPanel crearPanelAsiento() {
		JPanel panel = new JPanel(new GridLayout(nFilas, nColumnas, 7, 7));
		JButton[][] botonesAsientos = new JButton[nFilas][nColumnas];

		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < nColumnas; j++) {
				Asiento asiento = sala.obtenerAsFyC(i, j); // obtengo todos los asientos
				JButton b = new JButton();
				
				if (asiento.getTipoAsiento().equals(TipoAsiento.DISCAPACITADO)) {
					b.setBackground(Color.blue);
				} else if (asiento.getTipoAsiento().equals(TipoAsiento.VIP)) {
					b.setBackground(Color.red);
				} else {
					b.setBackground(Color.green);
				}

				b.setBorder(new Border() {
					
					@Override
					public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return null;
					}
				});
				
				//implementar acction listener para la funcionalidad del boton necesito que al pulsar un boton dependiendo de su tipo me lleve a las distintas
				//ventanas que me facilitan la compra de las sig --> discapacitados, vip y normales con su precio y creddeciales correspondientes
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				b.setText("F:" + asiento.getFila() + "C:" + asiento.getColumna());

				panel.add(b);
			}

		}
		return panel;
	}

}
