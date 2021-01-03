package model;

public class Facultad {
	private String idFacultad;
	private String nombreFacultad;
	private String nombreDecano;
	
	public Facultad() {
		super();
			}
	
	public Facultad(String nombreFacultad) {
		super();
		this.idFacultad= "";
		this.nombreFacultad = nombreFacultad;
		this.nombreDecano = "";
	}
	
	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombreDecano() {
		return nombreDecano;
	}

	public void setNombreDecano(String nombreDecano) {
		this.nombreDecano = nombreDecano;
	}

	public String getNombreFacultad() {
		return nombreFacultad;
	}

	public void setNombreFacultad(String nombreFacultad) {
		this.nombreFacultad = nombreFacultad;
	}
	
	@Override
	public String toString() {
		return this.nombreFacultad;
	}
	

}
