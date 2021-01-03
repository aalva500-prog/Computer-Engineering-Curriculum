package model;

public class Curriculo {
	private String codCurriculo;
	private String tipoCurriculo;
	private boolean cancelado;
	
	public Curriculo(String tipoCurriculo){
		super();
		this.tipoCurriculo=tipoCurriculo;
		}

	public Curriculo(){
		super();
	}
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public String getCodCurriculo() {
		return codCurriculo;
	}

	public void setCodCurriculo(String codCurriculo) {
		this.codCurriculo = codCurriculo;
	}

	public String getTipoCurriculo() {
		return tipoCurriculo;
	}

	public void setTipoCurriculo(String tipoCurriculo) {
		this.tipoCurriculo = tipoCurriculo;
	}

	public String toString(){
		 return this.tipoCurriculo;
	}
}
