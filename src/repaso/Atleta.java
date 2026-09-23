package repaso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Atleta {
	private int cod;
	private String nombre;
	private Genero genero;
	private String pais;
	private LocalDate naci;
	private float altura;
	private float peso;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public LocalDate getNaci() {
		return naci;
	}
	public void setNaci(LocalDate naci) {
		this.naci = naci;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Atleta(int cod, String nombre, Genero genero, String pais, LocalDate naci, float altura, float peso) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.genero = genero;
		this.pais = pais;
		this.naci = naci;
		this.altura = altura;
		this.peso = peso;
	}

	public Atleta() {
		super();
		this.cod = 0;
		this.nombre = "";
		this.genero = Genero.MASCULINO;
		this.pais = "España";
		this.naci = LocalDate.of(2000, 1, 1);
		this.altura = 180;
		this.peso = 75;
	}
	@Override
	public String toString() {
		return "Atleta [cod=" + cod + ", nombre=" + nombre + ", genero=" + genero + ", pais=" + pais + ", naci=" + naci
				+ ", altura=" + altura + ", peso=" + peso + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(altura, cod, genero, naci, nombre, pais, peso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Float.floatToIntBits(altura) == Float.floatToIntBits(other.altura) && cod == other.cod
				&& genero == other.genero && Objects.equals(naci, other.naci) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais, other.pais) && Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso);
	}
	
}
