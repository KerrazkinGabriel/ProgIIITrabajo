package domain;

import java.time.LocalDate;

public class Pelicula {
	
	public enum Genero {
		ACCION, COMEDIA, TERROR, CIENCIA_FICCION, FANTASIA, ROMANCE, DRAMA, SUSPENSO,AVENTURA;
	}
	
	private int codigoPeli;
	private String sinopsis;
	private String nombrePeli;
	private double duracion; // En horas
	private Genero genero;
	private Genero generoSecundario;
	private int dia;
	private int mes;
	private int anyo;
	private LocalDate fecha; // Utiliza los campos dia, mes y año
	private int rating; // Numero de estrellas
	protected Director director;
	protected Actor actor; 
	
	public Pelicula(int codigoPeli, String sinopsis, String nombrePeli, double duracion, Genero genero, Genero generoSecundario, int rating, LocalDate fecha, Director director, Actor actor) {
		super();
		this.codigoPeli = codigoPeli;
		this.sinopsis = sinopsis;
		this.nombrePeli = nombrePeli;
		this.duracion = duracion;
		this.genero = genero;
		this.generoSecundario = generoSecundario;
		this.rating = rating;
		this.actor = actor;
		this.director = director;
		this.fecha = fecha;
		if (fecha != null) {
			this.dia = fecha.getDayOfMonth();
			this.mes = fecha.getMonthValue();
			this.anyo = fecha.getYear();
		}
	}
	
	public int getCodigoPeli() {
		return codigoPeli;
	}

	public void setCodigoPelicula(int codigoPeli) {
		this.codigoPeli = codigoPeli;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Genero getGeneroSecundario() {
		return generoSecundario;
	}

	public void setGeneroSecundario(Genero generoSecundario) {
		this.generoSecundario = generoSecundario;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
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

	public String getNombrePeli() {
		return nombrePeli;
	}
	
	public void setNombrePeli(String nombrePeli) {
		this.nombrePeli = nombrePeli;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnyo() {
		return anyo;
	}

	@Override
	public String toString() {
		return "Pelicula [codigoPeli=" + codigoPeli + ", sinopsis=" + sinopsis + ", nombrePeli=" + nombrePeli
				+ ", duracion=" + duracion + ", genero=" + genero + ", generoSecundario=" + generoSecundario + ", dia="
				+ dia + ", mes=" + mes + ", anyo=" + anyo + ", fecha=" + fecha + ", rating=" + rating + ", director="
				+ director + ", actor=" + actor + "]";
	}	
	
	
}