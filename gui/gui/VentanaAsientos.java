package gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import domain.Asiento;
import domain.Sala;

public class VentanaAsientos extends JFrame{
	private static final long serialVersionUID = 1L;
	private Sala sala;
	
	
	public VentanaAsientos(Sala sala) {
		List<Asiento> asientos = sala.getAsientos();
		Integer nAsientos = asientos.size();
		Integer nColumnas = 0;
		Integer nFilas = 0;
		for (Asiento asiento : asientos) {
			if(nColumnas<asiento.getColumna() || nFilas<asiento.getFila()) {
				nColumnas = asiento.getColumna();
				nFilas = asiento.getFila();
			} 
		}
	
		this.setTitle("Asientos");
		this.setSize(820,500);
		
		this.setVisible(true);
		
		
	}

}
