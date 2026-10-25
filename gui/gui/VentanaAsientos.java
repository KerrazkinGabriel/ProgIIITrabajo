	package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Asiento;
import domain.Sala;

public class VentanaAsientos extends JFrame{
	private static final long serialVersionUID = 1L;
	private Sala sala;
	List<Asiento> asientos = sala.getAsientos();
	Integer nAsientos = asientos.size();
	Integer nColumnas = 0;
	Integer nFilas = 0;
	
	
	public VentanaAsientos(Sala sala) {
		for (Asiento asiento : asientos) {
			if(nColumnas<asiento.getColumna() || nFilas<asiento.getFila()) {
				nColumnas = asiento.getColumna();
				nFilas = asiento.getFila();
			} 
		}
	
		this.setTitle("Asientos");
		this.setSize(820,500);
		this.setLayout(new BorderLayout(10,10));
		
		JPanel panelAsientos = crearPanelAsiento();
		
		
		this.setVisible(true);
		
		
	}


	private JPanel crearPanelAsiento() {
		JPanel panel = new JPanel(new GridLayout(nFilas,nColumnas,7,7));
		JButton[][] botonesAsientos = new JButton[nFilas][nColumnas];
		
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < nColumnas; j++) {
				Asiento asiento = sala.obtenerAsFyC(i, j); //obtengo todos los asientos
				JButton b = new JButton();
				
				b.setText("F:"+asiento.getFila()+"C:"+ asiento.getColumna());
				
				panel.add(b);
			}
			
		}
		return panel;
	}
	

}
