package domain;

//Metodo dia del espectador (miercoles)!!
public class Entrada {

	// Descuento para usuarios registrados
	public static final double descuentoReg = 0.10; // static final, esta variable solo tiene un solo valor asignado, no
													// varía.

	private TipoEntrada tipo;
	private boolean userRegistraso;

	public Entrada(TipoEntrada tipo, boolean userRegistrado) {
		this.tipo = tipo;
		this.userRegistraso = userRegistrado;
	}

	public TipoEntrada getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntrada tipo) {
		this.tipo = tipo;
	}

	public boolean isUserRegistraso() {
		return userRegistraso;
	}

	public void setUserRegistraso(boolean userRegistraso) {
		this.userRegistraso = userRegistraso;
	}

	@Override
	public String toString() {
		return "Entrada [tipo=" + tipo + ", precio final: " + getPrecioFinal() + "," + " userRegistraso="
				+ userRegistraso + "]";
	}

	// Método precio base de las entradas
	public double getPrecioBase() {

		if (tipo == TipoEntrada.ADULTO) {
			return 8.00;
		} else if (tipo == TipoEntrada.JOVEN) {
			return 7.00;
		} else if (tipo == TipoEntrada.ESTUDIANTE) {
			return 6.00;
		} else if (tipo == TipoEntrada.NIÑO) {
			return 5.00;
		} else if (tipo == TipoEntrada.VIP) {
			return 9.50;
		}
		return 0;
	}

	// Método donde se suma el precio final y se aplica el descuento

	public double getPrecioFinal() {
		double precio = getPrecioBase();
		if (userRegistraso) {
			precio = precio * (1 - descuentoReg);
		}
		return precio;
	}
}
