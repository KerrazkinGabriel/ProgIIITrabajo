package domain;

public class ValidadorDatos {

    /**
     * Comprueba que el correo tenga formato estándar (usuario@dominio.extension).
     */
    public static boolean esEmailValido(String email) {
        if (email == null) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    /**
     * Comprueba que la contraseña tenga al menos 6 caracteres y al menos un dígito.
     */
    public static boolean esPasswordSegura(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        return password.matches(".*[0-9].*");
    }

    /**
     * Valida formato simple de DNI espanol (8 numeros y 1 letra).
     */
    public static boolean esDniValido(String dni) {
        if (dni == null) return false;
        return dni.trim().toUpperCase().matches("^[0-9]{8}[A-Z]$");
    }
}