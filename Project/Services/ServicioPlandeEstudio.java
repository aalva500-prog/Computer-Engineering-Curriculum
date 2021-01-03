package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.PlandeEstudio;
import utils.ConnectionBD;

public class ServicioPlandeEstudio {
	public static LinkedList<PlandeEstudio> getPlanes() throws SQLException, ClassNotFoundException{

		LinkedList<PlandeEstudio> planes = new LinkedList<PlandeEstudio>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"plandeestudio\".\"codplanest\",\"public\".\"plandeestudio\".\"nombreplan\",\"public\".\"plandeestudio\".\"cantperiodos\",\"public\".\"plandeestudio\".\"cantannos\",\"public\".\"carrera\".\"nombcarrera\" " +
		"FROM  \"public\".\"plandeestudio\",\"public\".\"carrera\""+
		"WHERE  \"public\".\"plandeestudio\".\"codcarrera\" = \"public\".\"carrera\".\"codcarrera\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			PlandeEstudio p = new PlandeEstudio();
			p.setCodPlan(resultado.getString(1));
			p.setNombrePlan(resultado.getString(2));
			p.setCantPeriodos(resultado.getInt(3));
			p.setCantAnnos(resultado.getInt(4));
			p.setCodCarrera(resultado.getString(5));
			planes.add(p);
		}
		return planes;
	}

	public static PlandeEstudio getPlanName (String name){
		PlandeEstudio d = new PlandeEstudio();
		String sentence = "SELECT * FROM \"plandeestudio\" WHERE \"plandeestudio\".\"nombreplan\" = ?";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setString(1, name);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {
				d.setCodPlan(result.getString(1));
				d.setNombrePlan(result.getString(2));
				d.setCantAnnos(result.getInt(3));
				d.setCantPeriodos(result.getInt(4));
				d.setCodCarrera(result.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static PlandeEstudio getPlanCod (int cod){
		PlandeEstudio d = new PlandeEstudio();
		String sentence = "SELECT * FROM \"plandeestudio\" WHERE \"plandeestudio\".\"codplanest\" = ?";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, cod);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {
				d.setCodPlan(result.getString(1));
				d.setNombrePlan(result.getString(2));
				d.setCantAnnos(result.getInt(3));
				d.setCantPeriodos(result.getInt(4));
				d.setCodCarrera(result.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	
	public static void insertarPlan(String cod,String plan,int periodos,int annos,String carrera) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT \"public\".\"InsertarPlan\" (?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, cod); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
	    prepararCons.setString(2, plan);
		prepararCons.setInt(3, periodos);
		prepararCons.setInt(4, annos);
		prepararCons.setString(5, carrera);
		prepararCons.execute();
	}
	
public static void  EliminarPlan(String plan) throws SQLException, ClassNotFoundException { 
		
		String sqlSentenc = "SELECT \"public\".\"EliminarPlan\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1,plan); 
		prepararCons.execute();
		
	}

public static void  ModificarPlan(String cod,String plan) throws SQLException, ClassNotFoundException { 
	
	String sqlSentenc = "SELECT \"public\".\"ActualizarPlan\"(?,?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setString(1,cod); 
	prepararCons.setString(2,plan);
	prepararCons.execute();
	
}
}

