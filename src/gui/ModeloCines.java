package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domain.Cine;

public class ModeloCines extends AbstractTableModel {

//Creacion de la tabla donde van a ir los cines por zona!

	private static final long serialVersionUID = 1L;

	private ArrayList<Cine> cines;

	private String[] columnas = { "Cine", "Dirección", "Oferta" };

	public ModeloCines(ArrayList<Cine> cines) {
		this.cines = cines;
	}

	@Override
	public int getRowCount() {
		return cines.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public String getColumnName(int columna) {
		return columnas[columna];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Cine c = cines.get(fila);
		if (columna == 0) {
			return c.getNombre();
		} else if (columna == 1) {
			return c.getDireccion();
		} else {
			return c.getOferta();
		}
	}

}
