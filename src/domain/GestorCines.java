package domain;

import java.util.ArrayList;

public class GestorCines {

	private ArrayList<Cine> cines = new ArrayList<Cine>();

	public GestorCines() {
		cines.add(new Cine("Cine Deusto", "Bilbao", "Avenida Universidades 6", "Miercoles 2x1"));
		cines.add(new Cine("Cine Zubiarte", "Bilbao", "Plaza Euskadi", "Estudiantes -20%"));
		cines.add(new Cine("Cine Donosti", "Donosti", "Paseo de la concha 2", "Jueves entradas a 5€"));
		cines.add(new Cine("Cine Gran Vía", "Bilbao", "Gran Vía 2",
				"Si vienes acompañado de 5 personas te llevas unas palomitas gratis"));
	}

	public ArrayList<Cine> getCines() {
		return cines;
	}

	// Devolvemos la lista de zonas sin repetirlas
	public ArrayList<String> getZonas() {
		ArrayList<String> zonas = new ArrayList<String>();
		for (Cine c : cines) {
			if (!zonas.contains(c.getZona())) {
				zonas.add(c.getZona());
			}
		}
		return zonas;
	}

	// Devolvemos solo los cines de una zona:

	public ArrayList<Cine> cinePorZona(String zona) {
		ArrayList<Cine> resultado = new ArrayList<Cine>();
		for (Cine c : cines) {
			if (c.getZona().equals(zona)) {
				resultado.add(c);
			}
		}
		return resultado;
	}
	
	
	
}
