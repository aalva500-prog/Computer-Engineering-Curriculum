package model;

public class Asignatura {
    private String codAsig;
    private String nombreAsig;
    private String jefeAsig;
    private String coddisciplina;
    private String codevaluacion;
    private String codcurriculo;
    private String codAsignaturaPre;
    private int anno;
    private int periodo;
    private int canthoras;
    private String PlanMetodologico;
    private String ProgramaAnalitico;
    private String SecuenciaActividades;
    private String codPlanEstudio;
    
   
	
	public Asignatura(String codPlanEstudio,String nombreAsig,String coddisciplina,String codevaluacion, String codcurriculo,String codAsignaturaPre ) {
		super();
		this.codAsig = "";
		this.nombreAsig =  nombreAsig;
		this.jefeAsig = "";
		this.coddisciplina = coddisciplina;
		this.codevaluacion = codevaluacion;
		this.codcurriculo = codcurriculo;
		this.codAsignaturaPre =  codAsignaturaPre;
		this.anno = 0;
		this.periodo = 0;
		this.codPlanEstudio =  codPlanEstudio ;
		this.PlanMetodologico = "";
		this.ProgramaAnalitico = "";
		this.SecuenciaActividades = "";
		this.canthoras = 0;
	}
	
	public Asignatura(){
		super();
	}
	
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getCanthoras() {
		return canthoras;
	}
	public void setCanthoras(int canthoras) {
		this.canthoras = canthoras;
	}
	public String getCodAsig() {
		return codAsig;
	}
	public void setCodAsig(String codAsig) {
		this.codAsig = codAsig;
	}
	public String getCodAsignaturaPre() {
		return codAsignaturaPre;
	}
	public void setCodAsignaturaPre(String codAsignaturaPre) {
		this.codAsignaturaPre = codAsignaturaPre;
	}
	public String getCodcurriculo() {
		return codcurriculo;
	}
	public void setCodcurriculo(String codcurriculo) {
		this.codcurriculo = codcurriculo;
	}
	public String getCoddisciplina() {
		return coddisciplina;
	}
	public void setCoddisciplina(String coddisciplina) {
		this.coddisciplina = coddisciplina;
	}
	public String getCodevaluacion() {
		return codevaluacion;
	}
	public void setCodevaluacion(String codevaluacion) {
		this.codevaluacion = codevaluacion;
	}
	public String getCodPlanEstudio() {
		return codPlanEstudio;
	}
	public void setCodPlanEstudio(String codPlanEstudio) {
		this.codPlanEstudio = codPlanEstudio;
	}
	public String getJefeAsig() {
		return jefeAsig;
	}
	public void setJefeAsig(String jefeAsig) {
		this.jefeAsig = jefeAsig;
	}
	public String getNombreAsig() {
		return nombreAsig;
	}
	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public String getPlanMetodologico() {
		return PlanMetodologico;
	}
	public void setPlanMetodologico(String planMetodologico) {
		PlanMetodologico = planMetodologico;
	}
	public String getProgramaAnalitico() {
		return ProgramaAnalitico;
	}
	public void setProgramaAnalitico(String programaAnalitico) {
		ProgramaAnalitico = programaAnalitico;
	}
	public String getSecuenciaActividades() {
		return SecuenciaActividades;
	}
	public void setSecuenciaActividades(String secuenciaActividades) {
		SecuenciaActividades = secuenciaActividades;
	}
	
	@Override
	public String toString() {
		return this.nombreAsig;
	}
	
	
}
