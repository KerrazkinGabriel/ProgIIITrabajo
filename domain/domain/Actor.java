package domain;

public class Actor extends Persona {
	
	protected String codigoAct;

	public Actor(String codigoAct, String nombre, String apellidos) {
		super();
		this.codigoAct = codigoAct;
	}
	
	public String getCodigoAct() {
		return codigoAct;
	}

	@Override
	public String toString() {
		return "Actor [codigoAct=" + codigoAct + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
