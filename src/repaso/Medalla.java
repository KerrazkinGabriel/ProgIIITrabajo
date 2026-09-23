package repaso;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class Medalla {
	private Metal metal ;
	private LocalDate fecha;
	private Atleta atleta;
	private String disciplina;
	
	public Metal getMetal() {
		return metal;
	}
	public void setMetal(Metal metal) {
		this.metal = metal;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public Medalla(Metal metal, LocalDate fecha, Atleta atleta, String disciplina) {
		super();
		this.metal = metal;
		this.fecha = fecha;
		this.atleta = atleta;
		this.disciplina = disciplina;
	}
	
	public Medalla() {
		super();
		this.metal = Metal.BRONCE;
		this.fecha = LocalDate.of(2000,1,1);
		this.atleta = new Atleta();
		this.disciplina = "";
	}
}
