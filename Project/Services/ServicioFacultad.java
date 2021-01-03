package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Facultad;
import utils.ConnectionBD;


public class ServicioFacultad {
	
	
	public static LinkedList<Facultad> getFacultades() throws SQLException, ClassNotFoundException{

		LinkedList<Facultad> listFacultades = new LinkedList<Facultad>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"facultad\".\"idfacultad\",\"public\".\"facultad\".\"nombfacultad\",\"public\".\"facultad\".\"nombdecano\" " +
		"FROM  \"public\".\"facultad\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Facultad f = new Facultad();
			f.setIdFacultad(resultado.getString(1));
			f.setNombreFacultad(resultado.getString(2));
			f.setNombreDecano(resultado.getString(3));
			listFacultades.add(f);
		}
		return listFacultades;
	}
	public static void insertarFacultad(String cod,String facultad,String decano) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT \"public\".\"InsertarFacultad\" (?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, cod); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
	    prepararCons.setString(2, facultad);
		prepararCons.setString(3, decano);
		prepararCons.execute();
	}
	
public static void  EliminarFacultad(String facultad) throws SQLException, ClassNotFoundException { 
		
		String sqlSentenc = "SELECT \"public\".\"EliminarFacultad\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1,facultad ); 
		prepararCons.execute();
		
	}

public static Facultad getFacultadName (String name){
	Facultad d = new Facultad();
	String sentence = "SELECT * FROM \"facultad\" WHERE \"facultad\".\"nombfacultad\" = ?";
	try {
		PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
		stat.setString(1, name);
		stat.execute();
		ResultSet result = stat.getResultSet();
		while (result.next()) {
			d.setIdFacultad(result.getString(1));
			d.setNombreDecano(result.getString(2));
			d.setNombreFacultad(result.getString(3));
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

public static void  ModificarFacultad(String facultad,String id) throws SQLException, ClassNotFoundException { 
	
	String sqlSentenc = "SELECT \"public\".\"ActualizarFacultad\"(?,?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setString(1,facultad ); 
	prepararCons.setString(2,id ); 
	prepararCons.execute();
	
}



}
