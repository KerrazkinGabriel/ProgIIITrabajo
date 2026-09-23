package repaso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Paris2024 {
	private List<Atleta> atletas;
	private List<Medalla> medallas;

	protected void addAtleta(Atleta a) {
		this.atletas.add(a);
	}
	
	protected void addMedalla(Medalla m) {
		this.medallas.add(m);
		medallas.sort(porFecha);
	}

	public HashMap<String, List<Atleta>> obtenerAtletasPorPais() {
		HashMap<String,List<Atleta>> atletasPais = new HashMap<String,List<Atleta>>();
		for (Atleta atleta : atletas) {
			if(!(atletasPais.containsKey(atleta.getPais()))) {
				List<Atleta> valor = new ArrayList<Atleta>();
				valor.add(atleta);
				atletasPais.put(atleta.getPais(),valor);
			} else {
				String pais = atleta.getPais();
				List<Atleta> valor = atletasPais.get(pais);
				valor.add(atleta);
				atletasPais.put(pais, valor);
				}
		}
		return atletasPais;
	}

	
	public ArrayList<Medalla> voidobtenerMedallas(Metal m) {
		ArrayList<Medalla> medallas = new ArrayList<Medalla>();
		for (Medalla medalla : medallas) {
			if(medalla.getMetal().equals(m)) {
				medallas.add(medalla);
			}
			}
		medallas.sort(porNombreAtleta);
		return medallas;	
		}
	
	Comparator<Medalla> porFecha = Comparator.comparing(Medalla::getFecha);
	Comparator<Medalla> porNombreAtleta = Comparator.comparing(p -> p.getAtleta().getNombre());
}


