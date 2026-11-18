package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Entrada {
	// Descuento para usuarios registrados(SOCIOS)
	public static final double descuentoReg = 0.10; // static final, esta variable solo tiene un solo valor asignado, no
													// varía.

	public static final double descuentoPremium = 0.20; // PREMIUM

	// Descuento miercoles, día del espectador
	public static final double descuentoDiaEspectador = 0.20;

	private TipoEntrada tipo;
	private TipoUsuario tipoUser;
	private boolean userRegistraso;
	private LocalDate fecha;

	public Entrada(TipoEntrada tipo, TipoUsuario tipoUser, LocalDate fecha) {
		this.tipo = tipo;
		this.tipoUser = tipoUser;
		this.fecha = fecha;
	}

	public TipoEntrada getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntrada tipo) {
		this.tipo = tipo;
	}

	public TipoUsuario getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUsuario tipoUser) {
		this.tipoUser = tipoUser;
	}

	public boolean isUserRegistraso() {
		return tipoUser != null;
	}

	public void setUserRegistraso(boolean userRegistraso) {
		this.userRegistraso = userRegistraso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public boolean isDiaEspectador() {
		return fecha.getDayOfWeek() == DayOfWeek.WEDNESDAY;
	}

	@Override
	public String toString() {
		String quien = "invitado";
		if (tipoUser != null) {
			quien = tipoUser.toString();

		}
		return "Entrada[ tipo: " + tipo + ", usuario: " + quien + ", fecha: " + fecha + ", precio final: "
				+ getPrecioFinal() + "€" + "]";
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

	// Descuento
	public double getDescuentoUsuario() {
		if (tipoUser == TipoUsuario.PREMIUM) {
			return descuentoPremium;
		} else if (tipoUser == TipoUsuario.SOCIO) {
			return descuentoReg;
		}
		return 0;
	}

	// Método donde se suma el precio final y se aplica el descuento

	public double getPrecioFinal() {
		double precio = getPrecioBase();
		if (userRegistraso) {
			precio = precio * (1 - descuentoReg);
		}
		if (isDiaEspectador()) {
			precio = precio * (1 - descuentoDiaEspectador);
		}
		return precio;
	}

}
