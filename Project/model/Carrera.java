package model;

public class Carrera {
	private String codCarrera;
	private String nombCarrera;
	private String idFacultad;
	
	
	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Carrera(String idfacultad,String nombCarrera){
		super();
		this.codCarrera = "";
		this.nombCarrera = nombCarrera;
		this.idFacultad = idfacultad;
		
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombCarrera() {
		return nombCarrera;
	}

	public void setNombCarrera(String nombCarrera) {
		this.nombCarrera = nombCarrera;
	}

	@Override
	public String toString() {
		return this.nombCarrera;
	}
}
