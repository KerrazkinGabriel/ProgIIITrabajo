package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Asiento {
	
    private int fila;
    private int columna;
    private boolean ocupado;
    private TipoAsiento tipoAsiento;
    private boolean paraDiscapacitados;
    
    //getter/setters
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public TipoAsiento getClase() {
		return tipoAsiento;
	}
	public void setClase(TipoAsiento clase) {
		this.tipoAsiento = clase;
	}
	public boolean isParaDiscapacitados() {
		return paraDiscapacitados;
	}
	public void setParaDiscapacitados(boolean paraDiscapacitados) {
		this.paraDiscapacitados = paraDiscapacitados;
	}
	
	public TipoAsiento getTipoAsiento() {
		return tipoAsiento;
	}
	//hashCode/equals
	@Override
	public int hashCode() {
		return Objects.hash(tipoAsiento, columna, fila, ocupado, paraDiscapacitados);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asiento other = (Asiento) obj;
		return tipoAsiento == other.tipoAsiento && columna == other.columna && fila == other.fila && ocupado == other.ocupado
				&& paraDiscapacitados == other.paraDiscapacitados;
	}
	
	//constructores
	protected Asiento(int fila, int columna, boolean ocupado, TipoAsiento tipoAsiento, boolean paraDiscapacitados) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.ocupado = ocupado;
		this.tipoAsiento = tipoAsiento;
		this.paraDiscapacitados = paraDiscapacitados;
	}
		
		protected Asiento() {
			super();
			this.fila = 0;
			this.columna = 0;
			this.ocupado = false;
			this.tipoAsiento = TipoAsiento.NORMAL;
			this.paraDiscapacitados = false;
	}
	
		//crear asientos desocupados
	    public static List<Asiento> crearAsientosCine() {
	        List<Asiento> asientos = new ArrayList<>();
	        
	        for (int fila = 1; fila <= 8; fila++) {
	        	TipoAsiento clase = (fila <= 2) ? TipoAsiento.VIP : TipoAsiento.NORMAL;
	            
	            for (int columna = 1; columna <= 10; columna++) {
	                boolean discapacitados = (fila == 1 && (columna == 1 || columna == 2))||(fila == 8 && (columna == 1 || columna == 2));
	                
	                asientos.add(new Asiento(fila, columna, false, clase, discapacitados));
	            }
	        }
	        return asientos;
	    }
}
