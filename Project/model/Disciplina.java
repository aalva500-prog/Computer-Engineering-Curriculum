package model;

public class Disciplina {
	private String codDisplina;
	private String nombreDisciplina;
	private String jefeDisciplina;
	private int canthorsTotales;
	private boolean cancelado;
	
	
	public Disciplina() {
		super();
	}
	
public Disciplina(String nombreDisciplina){
	super();
	this.codDisplina = "";
	this.nombreDisciplina =nombreDisciplina;
	this.jefeDisciplina = "";
	this.canthorsTotales = 0;
	this.cancelado = false;
}

public boolean isCancelado() {
	return cancelado;
}

public void setCancelado(boolean cancelado) {
	this.cancelado = cancelado;
}

public int getCanthorsTotales() {
	return canthorsTotales;
}

public void setCanthorsTotales(int canthorsTotales) {
	this.canthorsTotales = canthorsTotales;
}

public String getCodDisplina() {
	return codDisplina;
}

public void setCodDisplina(String codDisplina) {
	this.codDisplina = codDisplina;
}

public String getJefeDisciplina() {
	return jefeDisciplina;
}

public void setJefeDisciplina(String jefeDisciplina) {
	this.jefeDisciplina = jefeDisciplina;
}

public String getNombreDisciplina() {
	return nombreDisciplina;
}

public void setNombreDisciplina(String nombreDisciplina) {
	this.nombreDisciplina = nombreDisciplina;
}

@Override
public String toString() {
	return this.nombreDisciplina;
}

}
