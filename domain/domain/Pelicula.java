package domain;

public class Pelicula extends Director {
	
	public enum Genero {
		ACCION, COMEDIA, TERROR, CIENCIA_FICCION, FANTASIA, ROMANCE, DRAMA, SUSPENSO,AVENTURA;
	}
	
	private String nombre;
	private double duracion; // En horas
	private Genero genero;
	private int rating; // Numero de estrellas
	private Director director;
	
	public Pelicula(String nombre, double duracion, Genero genero, int rating) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.genero = genero;
		this.rating = rating;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Pelicula [nombre=" + nombre + ", duracion=" + duracion + ", genero=" + genero + ", rating=" + rating
				+ "]";
	}
	
	
	
	
}