package domain;

import java.util.HashMap;
import java.util.Map;

public class GestorUsuario {

	// Creamos un map para buscar por clave el email y por key el objeto
	// usuario, así evistamos dos usuarios con el correo repetido
	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	private String normCorreo(String email) {// Hacemos que el correo sea automaticamanete en mayusculas y sin espacios
												// para evitar confusiones
		return email.trim().toLowerCase();
	}

	public boolean registrar(Usuario usuario) {
		String clave = normCorreo(usuario.getEmail());

		if (usuarios.containsKey(clave)) {
			return false;
		} else {
			usuarios.put(clave, usuario);
			return true;
		}

	}

	public boolean existeEmail(String email) {
		return usuarios.containsKey(normCorreo(email));
	}

	public Usuario iniciarSesion(String email, String contrasena) { // Devolvemos el usuario si existe y si no null
		Usuario user = usuarios.get(normCorreo(email));

		if (user != null && user.contraseñaCorrecta(contrasena)) {
			return user;
		} else {
			return null;
		}
		
	}

}
