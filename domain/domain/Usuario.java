package domain;

import java.time.LocalDate;

public class Usuario {

	private String email;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNac;
	private String telefono;
	private String cinePreferido;
	private String dni;
	private String contrasena;

	public Usuario(String email, String nombre, String apellidos, LocalDate fechaNac, String telefono,
			String cinePreferido, String dni, String contrasena) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
		this.cinePreferido = cinePreferido;
		this.dni = dni;
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCinePreferido() {
		return cinePreferido;
	}

	public void setCinePreferido(String cinePreferido) {
		this.cinePreferido = cinePreferido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean contraseñaCorrecta(String intento) {
		return contrasena.equals(intento);
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
