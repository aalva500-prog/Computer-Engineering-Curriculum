package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

import model.Asignatura;
import utils.ConnectionBD;

public class ServicioAsignatura {
	public static void insertarAsignatura(String cod, String nombre, String jefe,int canthoras,int anno,int periodo, String PlanMetodologico,String Programa,String Secuencia,String evaluacion,String PlanEstudio,String AsigPre,String disciplina,String Curriculo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT \"public\".\"InsertarAsignatura\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, cod); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.setString(2, nombre);
		prepararCons.setString(3, jefe);
		prepararCons.setInt(4, canthoras);
		prepararCons.setInt(5,anno);
		prepararCons.setInt(6,periodo);
		prepararCons.setString(7,PlanMetodologico);
		prepararCons.setString(8,Programa);
		prepararCons.setString(9,Secuencia);
		prepararCons.setString(10,evaluacion);
		prepararCons.setString(11,PlanEstudio);
		prepararCons.setString(12,AsigPre);
		prepararCons.setString(13,disciplina);
		prepararCons.setString(14,Curriculo);		
		prepararCons.execute();
	}
	
	
	public static void EliminarAsignatura(String asignatura) throws SQLException, ClassNotFoundException{
		String sentence = "SELECT \"public\".\"EliminarAsignatura\"(?)";
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sentence);
		prepararCons.setString(1, asignatura);
		prepararCons.execute();
	}
	

		public static void ModificarAsignatura(String asignatura,String cod) throws SQLException, ClassNotFoundException{
			String sentence = "SELECT \"public\".\"ActualizarAsignatura\"(?,?)";
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			prepararCons.setString(1, asignatura);
			prepararCons.setString(2, cod);
			prepararCons.execute();
		}
	
	
	public static LinkedList<Asignatura> getAsignaturas() throws SQLException, ClassNotFoundException{
		LinkedList<Asignatura> listAsignaturas = new LinkedList<Asignatura>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"asignatura\".\"codasig\",\"public\".\"asignatura\".\"nombreasig\",\"public\".\"asignatura\".\"jefeasig\",\"public\".\"asignatura\".\"canthoras\",\"public\".\"asignatura\".\"anno\",\"public\".\"asignatura\".\"periodo\",\"public\".\"asignatura\".\"planmetodologico\",\"public\".\"asignatura\".\"programanalitico\",\"public\".\"asignatura\".\"secactividad\",\"public\".\"evaluacion\".\"tipoevaluacion\",\"public\".\"plandeestudio\".\"nombreplan\",\"public\".\"asignatura\".\"codasigpre\",\"public\".\"disciplina\".\"nombredisciplin\",\"public\".\"curriculo\".\"tipocurriculo\""+
				"FROM  \"public\".\"asignatura\",\"public\".\"evaluacion\",\"public\".\"plandeestudio\",\"public\".\"disciplina\",\"public\".\"curriculo\" " +
				"WHERE  \"public\".\"asignatura\".\"codevaluacion\" = \"public\".\"evaluacion\".\"codevaluacion\"and \"public\".\"asignatura\".\"codplanest\" = \"public\".\"plandeestudio\".\"codplanest\"and \"public\".\"asignatura\".\"coddisciplina\" = \"public\".\"disciplina\".\"coddisciplina\"and \"public\".\"asignatura\".\"codcurriculo\" = \"public\".\"curriculo\".\"codcurriculo\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Asignatura a = new Asignatura();
			a.setCodAsig(resultado.getString(1));
			a.setNombreAsig(resultado.getString(2));
			a.setJefeAsig(resultado.getString(3));
			a.setCanthoras(resultado.getInt(4));
			a.setAnno(resultado.getInt(5));
			a.setPeriodo(resultado.getInt(6));
			a.setPlanMetodologico(resultado.getString(7));
			a.setProgramaAnalitico(resultado.getString(8));
			a.setSecuenciaActividades(resultado.getString(9));
			a.setCodevaluacion(resultado.getString(10));
			a.setCodPlanEstudio(resultado.getString(11));
			a.setCodAsignaturaPre(resultado.getString(12));
			a.setCoddisciplina(resultado.getString(13));
			a.setCodcurriculo(resultado.getString(14));
			listAsignaturas.add(a);
		}
		return listAsignaturas;
	}
	
	
	public static void saveTxt(String dir, int ano) throws FileNotFoundException{
		File f = new File(dir + ".txt");
		PrintWriter pw = new PrintWriter(f);
		pw.println("Asignaturas de " + String.valueOf(ano) + " año.");
		pw.println("---------------------");
		LinkedList<Asignatura> list = new LinkedList<Asignatura>();
		try {
			list = getAsignaturas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Asignatura> it = list.iterator();
		while(it.hasNext()){
			Asignatura a = it.next();
			if(a.getAnno() == ano){
				pw.println(a.getNombreAsig());
				pw.println("---------------------");
			}
		}
		pw.flush();
		pw.close();
	}
}
