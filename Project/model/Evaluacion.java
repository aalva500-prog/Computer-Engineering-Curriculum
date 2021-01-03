package model;

public class Evaluacion {
	private String codEvaluacion;
	private String tipoEvluacion;
	private boolean cancelado;
	
	

public Evaluacion(String tipoEvaluacion){
	super();
	this.tipoEvluacion = tipoEvaluacion;
	}

public Evaluacion(){
	super();
}
	public boolean isCancelado() {
		return cancelado;
	}


	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}


	public String getCodEvaluacion() {
		return codEvaluacion;
	}


	public void setCodEvaluacion(String codEvaluacion) {
		this.codEvaluacion = codEvaluacion;
	}


	public String getTipoEvluacion() {
		return tipoEvluacion;
	}


	public void setTipoEvluacion(String tipoEvluacion) {
		this.tipoEvluacion = tipoEvluacion;
	}
	
 public String toString(){
	 return this.tipoEvluacion;
 }
}
