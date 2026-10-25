package domain;

public class Director {
	
	protected String codigoDir;
	protected String nombreDir;
	protected String apellidos;
	protected String pais;
	
	public Director(String codigoDir, String nombreDir, String apellidos, String pais) {
		super();
		this.codigoDir = codigoDir;
		this.nombreDir = nombreDir;
		this.apellidos = apellidos;
		this.pais = pais;
	}
	public String getCodigoDir() {
		return codigoDir;
	}
	public String getNombreDir() {
		return nombreDir;
	}
	public void setNombreDir(String nombreDir) {
		this.nombreDir = nombreDir;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
