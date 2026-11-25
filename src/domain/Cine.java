package domain;

public class Cine {
	private String nombre;
	private String zona;
	private String direccion;
	private String oferta;

	public Cine(String nombre, String zona, String direccion, String oferta) {
		super();
		this.nombre = nombre;
		this.zona = zona;
		this.direccion = direccion;
		this.oferta = oferta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getZona() {
		return zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getOferta() {
		return oferta;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		return "Cine: " + nombre + " se situa en: " + zona + " |dir:  " + direccion + " ofrece: " + oferta;
	}

}
