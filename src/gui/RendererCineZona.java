package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererCineZona extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	// inicializacion de colores
	public static final Color ROJO = new Color(200, 16, 46); // STATIC FINAL para que nunca cambien y puedan ser
																// utlizados en otras clases
	public static final Color NEGRO = new Color(12, 12, 12);
	public static final Color GRIS = new Color(244, 244, 244);

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		setHorizontalAlignment(JLabel.CENTER);// Centramos el texto en las celdas

		if (!isSelected) {
			if (row % 2 == 0) { // par o impar
				setBackground(Color.WHITE);
			} else {
				setBackground(GRIS);
			}
			setForeground(NEGRO);
		}
		if (column == 0) {
			setFont(new Font("Arial", Font.BOLD, 16));
		} else if (column == 1) {
			setFont(new Font("Arial", Font.PLAIN, 16));
		} else {
			setFont(new Font("Arial", Font.BOLD, 16));
			setToolTipText(String.valueOf(value));
			if (!isSelected) {
				setForeground(ROJO);
			}
		}
		return this;
	}
}
