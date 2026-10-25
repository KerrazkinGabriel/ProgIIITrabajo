package domain;

import java.time.LocalDate;

public class Pelicula extends Director {
	
	public enum Genero {
		ACCION, COMEDIA, TERROR, CIENCIA_FICCION, FANTASIA, ROMANCE, DRAMA, SUSPENSO,AVENTURA;
	}
	
	private int codigoPelicula;
	private String sinopsis;
	private String nombrePeli;
	private double duracion; // En horas
	private Genero genero;
	private LocalDate fecha;
	private Genero generoSecundario;
	private int rating; // Numero de estrellas
	protected Director director;
	protected Actor actor; 
	
	public Pelicula(String nombrePeli, double duracion, Genero genero, int rating) {
		super(int codigoDir, String nombreDir, String apellidos, String pais);
		this.nombrePeli = nombrePeli;
		this.duracion = duracion;
		this.genero = genero;
		this.rating = rating;
	}

	public String getNombre() {
		return nombrePeli;
	}

	public void setNombre(String nombrePeli) {
		this.nombrePeli = nombrePeli;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Pelicula [nombrePeli=" + nombrePeli  + ", duracion=" + duracion + ", genero=" + genero + ", rating=" + rating
				+ "]";
	}
	
	
	
	
}