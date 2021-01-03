package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Evaluacion;
import utils.ConnectionBD;

public class ServicioEvaluacion {
	public static LinkedList<Evaluacion> getEvaluaciones() throws SQLException, ClassNotFoundException{

		LinkedList<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"evaluacion\".\"codevaluacion\",\"public\".\"evaluacion\".\"tipoevaluacion\" " +
		"FROM  \"public\".\"evaluacion\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Evaluacion e = new Evaluacion();
			e.setCodEvaluacion(resultado.getString(1));
			e.setTipoEvluacion(resultado.getString(2));
			evaluaciones.add(e);
		}
		return evaluaciones;
	}
	
	public static Evaluacion getEvaluacionName (String name){
		Evaluacion d = new Evaluacion();
		String sentence = "SELECT * FROM \"evaluacion\" WHERE \"evaluacion\".\"tipoevaluacion\" = ?";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setString(1, name);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {
				d.setCodEvaluacion(result.getString(1));
				d.setTipoEvluacion(result.getString(2));
				d.setCancelado(result.getBoolean(3));
				
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
