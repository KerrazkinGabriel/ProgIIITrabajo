package domain;

public class Director extends Persona {
	
	protected String codigoDir;
	protected String pais;
	
	public Director(String codigoDir, String nombre, String apellidos, String pais) {
		super();
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
		return "Director [codigoDir=" + codigoDir + ", nombreDir=" + nombreDir + ", apellidos=" + apellidos + ", pais="
				+ pais + "]";
	}


}
