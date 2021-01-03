package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Curriculo;
import utils.ConnectionBD;

public class ServicioCurriculo {
	
	public static LinkedList<Curriculo> getCurriculos() throws SQLException, ClassNotFoundException{

		LinkedList<Curriculo> curriculos = new LinkedList<Curriculo>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"curriculo\".\"codcurriculo\",\"public\".\"curriculo\".\"tipocurriculo\" " +
		"FROM  \"public\".\"curriculo\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Curriculo c = new Curriculo();
			c.setCodCurriculo(resultado.getString(1));
			c.setTipoCurriculo(resultado.getString(2));
			curriculos.add(c);
		}
		return curriculos;
	}

}
