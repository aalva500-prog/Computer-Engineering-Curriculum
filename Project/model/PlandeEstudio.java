package model;

public class PlandeEstudio {
	private String codPlan;
	private String nombrePlan;
	private int cantPeriodos;
	private int cantAnnos;
	private String codCarrera;
	
	public PlandeEstudio(String nombrePlan,String codcarrera){
		super();
		this.codPlan="";
		this.nombrePlan=nombrePlan;
		this.codCarrera=codcarrera;
		this.cantPeriodos=0;
		this.cantAnnos=0;
	}
	public PlandeEstudio() {
		super();
	}

	public int getCantAnnos() {
		return cantAnnos;
	}

	public void setCantAnnos(int cantAnnos) {
		this.cantAnnos = cantAnnos;
	}

	public int getCantPeriodos() {
		return cantPeriodos;
	}

	public void setCantPeriodos(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCodPlan() {
		return codPlan;
	}

	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	
	@Override
	public String toString(){
		return this.getNombrePlan();
				}

	}
