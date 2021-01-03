package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Disciplina;
import utils.ConnectionBD;

public class ServicioDisciplina {
	public static LinkedList<Disciplina> getDisciplinas() throws SQLException, ClassNotFoundException{

		LinkedList<Disciplina> listDisciplinas = new LinkedList<Disciplina>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"disciplina\".\"coddisciplina\",\"public\".\"disciplina\".\"nombredisciplin\",\"public\".\"disciplina\".\"jefedisciplin\",\"public\".\"disciplina\".\"canthorastotales\" " +
		"FROM  \"public\".\"disciplina\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Disciplina d = new Disciplina();
			d.setCodDisplina(resultado.getString(1));
			d.setNombreDisciplina(resultado.getString(2));
			d.setJefeDisciplina(resultado.getString(3));
			d.setCanthorsTotales(resultado.getInt(4));
			listDisciplinas.add(d);
		}
		return listDisciplinas;
	}
	
	public static void insertarDisciplina(String cod,String disciplina,String jefe,int horas,boolean canc) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT \"public\".\"InsertarDisciplina\" (?,?,?,?,?) "; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, cod); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
	    prepararCons.setString(2, disciplina);
		prepararCons.setString(3, jefe);
		prepararCons.setInt(4, horas);
		prepararCons.setBoolean(5, canc);
		prepararCons.execute();
	}
	
public static void  EliminarDisciplina(String disciplina) throws SQLException, ClassNotFoundException { 
		
		String sqlSentenc = "SELECT \"public\".\"EliminarDisciplina\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1,disciplina ); 
		prepararCons.execute();
		
	}
	
	public static void ModificarDisciplina(String nomb, String cod) throws SQLException, ClassNotFoundException{
		
		String sqlSentenc = "SELECT \"public\".\"ActualizarDisciplina\"(?,?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1,nomb ); 
		prepararCons.setString(2,cod );
		prepararCons.execute();
	}

	public static Disciplina getDisciplinaName (String name){
		Disciplina d = new Disciplina();
		String sentence = "SELECT * FROM \"disciplina\" WHERE \"disciplina\".\"nombredisciplin\" = ?";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setString(1, name);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {
				d.setCodDisplina(result.getString(1));
				d.setNombreDisciplina(result.getString(2));
				d.setJefeDisciplina(result.getString(3));
				d.setCanthorsTotales(result.getInt(4));
				d.setCancelado(result.getBoolean(5));
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
	
	public static Disciplina getDisciplinaCod (int cod){
		Disciplina d = new Disciplina();
		String sentence = "SELECT * FROM \"disciplina\" WHERE \"disciplina\".\"coddisciplina\" = ?";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, cod);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {
				d.setCodDisplina(result.getString(1));
				d.setNombreDisciplina(result.getString(2));
				d.setJefeDisciplina(result.getString(3));
				d.setCanthorsTotales(result.getInt(4));
				d.setCancelado(result.getBoolean(5));
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
	
	
	
}
