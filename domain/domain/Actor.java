package domain;

public class Actor {
	
	protected String codigoAct;
	protected String nombre;
	protected String apellidos;
	
	public Actor(String codigoAct, String nombre, String apellidos) {
		super();
		this.codigoAct = codigoAct;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public String getCodigoAct() {
		return codigoAct;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Actor [codigoAct=" + codigoAct + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
