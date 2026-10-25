package domain;

public class Director extends Persona {
	
	private static int contadorDir = 0;
	
	protected String codigoDir;
	protected String pais;
	
	public Director(String codigoDir, String nombre, String apellidos, String pais) {
		super(nombre,apellidos);
		this.codigoDir = codigoDir;
		this.pais = pais;
	}
	public String getCodigoDir() {
		return codigoDir;
	}

	public String getPais() {
		return pais;
	}
	@Override
	public String toString() {
		return "Director [codigoDir=" + codigoDir + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pais="
				+ pais + "]";
	}
	@Override
	public String generarCodigo() {
		// TODO Auto-generated method stub
		return "D" + contadorDir++;
	}


}
