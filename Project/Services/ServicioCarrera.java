package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Carrera;
import utils.ConnectionBD;

public class ServicioCarrera {
	public static LinkedList<Carrera> getCarreras() throws SQLException, ClassNotFoundException{
		LinkedList<Carrera> carreras = new LinkedList<Carrera>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"carrera\".\"codcarrera\",\"public\".\"carrera\".\"nombcarrera\",\"public\".\"facultad\".\"nombfacultad\"" +
				"FROM  \"public\".\"carrera\",\"public\".\"facultad\" " +
				"WHERE  \"public\".\"carrera\".\"idfacultad\" = \"public\".\"facultad\".\"idfacultad\" ";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Carrera c = new Carrera();
			c.setCodCarrera(resultado.getString(1));
			c.setNombCarrera(resultado.getString(2));
			c.setIdFacultad(resultado.getString(3));
			carreras.add(c);
		}
		return carreras;
	}
	
	public static void insertarCarrera(String cod, String nombre, String f) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarCarrera\" (?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, cod); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.setString(2, nombre);
		prepararCons.setString(3, f);
		prepararCons.execute();
	}
	
	
public static void  EliminarCarrera(String carrera) throws SQLException, ClassNotFoundException { 
		
		String sqlSentenc = "SELECT \"public\".\"EliminarCarrera\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1,carrera ); 
		prepararCons.execute();
		
	}

public static void  ModificarCarrera(String carrera,String cod) throws SQLException, ClassNotFoundException { 
	
	String sqlSentenc = "SELECT \"public\".\"ActualizarCarrera\"(?,?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setString(1,carrera ); 
	prepararCons.setString(2,cod ); 
	prepararCons.execute();
	
}
}
