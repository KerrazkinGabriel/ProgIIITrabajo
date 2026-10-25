package domain;

import java.util.List;

public class Sala {
    private Pelicula pelicula; 
    private String horaInicio;    
    private List<Asiento> asientos;

    public Sala(Pelicula pelicula, String hora) {
        this.pelicula = pelicula;
        this.horaInicio = hora;
        this.asientos = Asiento.crearAsientosCine();
    }
    
    public Pelicula getPelicula() {
		return pelicula;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public List<Asiento> getAsientos() {
		return asientos;
	}


	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}
	
	protected Sala(Pelicula pelicula, String horaInicio, List<Asiento> asientos) {
		super();
		this.pelicula = pelicula;
		this.horaInicio = horaInicio;
		this.asientos = asientos;
	}

	// Obtener un asiento por fila y columna
    public Asiento getAsiento(int fila, int columna) {
        return asientos.stream()
                .filter(a -> a.getFila() == fila && a.getColumna() == columna)
                .findFirst()
                .orElse(null);
    }
}
