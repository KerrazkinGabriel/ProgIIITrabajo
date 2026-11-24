package domain;

public class Actor extends Persona {
	
	private static int contadorAct = 0; // Empieza en 0 para genrar el código de los actores (del 1 al n)
	
	protected String codigoAct;
	protected String nombre;
	protected String apellidos;
	
	public Actor(String codigoAct, String nombre, String apellidos) {
		super(nombre, apellidos);
		this.codigoAct = generarCodigo();
	}

	public String getCodigoAct() {
		return codigoAct;
	}
	
	@Override
	public String toString() {
		return "Actor [codigoAct=" + codigoAct + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	@Override
	public String generarCodigo() {
		// TODO Auto-generated method stub
		return "A" + contadorAct++;
	}
	
}
