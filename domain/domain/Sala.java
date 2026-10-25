package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Sala {
 
	private Integer numero;
	private TipoSala tipoSala;
    private HashMap<Pelicula, String> peli;
    private List<Asiento> asientos;
    
    public enum TipoSala {
    	Estandar,Vose,IMax,Vip,Infantiles,TresD
    }

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoSala getSala() {
		return tipoSala;
	}

	public void setSala(TipoSala sala) {
		this.tipoSala = sala;
	}

	public HashMap<Pelicula, String> getPeli() {
		return peli;
	}

	public void setPeli(HashMap<Pelicula, String> peli) {
		this.peli = peli;
	}
	
	public List<Asiento> getAsientos() {
		return asientos;
	}

	public Sala(Integer numero, TipoSala tipoSala, HashMap<Pelicula, String> peli,  List<Asiento> asientos) {
		super();
		this.numero = numero;
		this.tipoSala = tipoSala;
		this.peli = peli;
		this.asientos = asientos;
	}
    
	public Sala() {
		super();
		this.numero = 00;
		this.tipoSala = tipoSala.Estandar;
		this.peli = new HashMap<Pelicula, String>();
		this.asientos = new ArrayList<Asiento>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(asientos, numero, peli, tipoSala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(asientos, other.asientos) && Objects.equals(numero, other.numero)
				&& Objects.equals(peli, other.peli) && tipoSala == other.tipoSala;
	}

	@Override
	public String toString() {
		return "Sala [numero=" + numero + ", peli=" + peli + ", asientos=" + asientos + "]";
	}
    
	//obtener asiento por Fila y columna
	public Asiento obtenerAsiento (Integer fila, Integer columna) {
		Asiento asiento = null;
			for (Asiento a : asientos) {
				if(a.getColumna() == columna && a.getFila()== fila) {
					asiento = a;
				}
			}
		return asiento;
		
	}
	
	//obtener fila y columna de una asiento
	
	public String obtenerSitio(Asiento a) {
		String sitio = "No encontrado";
		Integer fila = obtenerFila(a);
		Integer columna = obtenerColumna(a);
		
		sitio = "Fila:"+ fila + "Columna:" + columna ; 
		
		return sitio;
		
	}
	public Integer obtenerFila (Asiento a) {
		Integer fila = a.getFila();
		return fila;
		
	}
	
	public Integer obtenerColumna(Asiento a) {
		Integer columna = a.getColumna();
		return columna;
		
	}
	public HashMap<TipoAsiento,Integer> asientosPorTipo(Asiento asientos){
		HashMap<TipoAsiento, Integer> result = new HashMap<TipoAsiento, Integer>();
		for (Asiento asiento : this.asientos) {
			if (!result.containsKey(asiento.getTipoAsiento())){
				result.put(asiento.getTipoAsiento(), 1);
			} else if (result.containsKey(asiento.getTipoAsiento())) {
				int valor = result.get(asiento.getTipoAsiento());
				result.put(asiento.getTipoAsiento(), valor +1);
				
			}
		}
		return result;
		
	}
	
	public Integer capMax(Asiento a) {
		int capMax = asientosPorTipo(a).size();
		return capMax;
		
	}

    
}
