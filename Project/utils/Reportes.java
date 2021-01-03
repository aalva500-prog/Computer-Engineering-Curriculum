package utils;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes {

	
	
	private java.sql.Connection myConnection = null;
       static  Reportes report;
	
	public Reportes() {
		super();
		try {
			this.myConnection = ConnectionBD.connect.getConnection();
			Class.forName("org.postgresql.Driver");
			 myConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/malla", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static Reportes getR()
	{
		if(report == null)
		{
			report = new Reportes();
		}
		return report;
			
	}
	
	public void CargarPlanMet(String cod){
		try {
			//Class.forName("org.postgresql.Driver");
			//java.sql.Connection myConnection = ConnectionBD.connect.getConnection();
			HashMap<String, String> mypara = new HashMap <String, String> ();
			mypara.put("codAsig", cod);
			JasperFillManager.fillReportToFile("reportes/plan.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/plan.jrprint", false,false);
		} catch (JRException e2) {
						e2.printStackTrace();
		}
	}
	
	
	public void CargarReporteProgramaAnalitico(String codasig){
		try {
			//Class.forName("org.postgresql.Driver");
			HashMap<String, String> mypara = new HashMap <String, String> ();
			mypara.put("codAsig", codasig);
			JasperFillManager.fillReportToFile("reportes/programaAnalitico.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/programaAnalitico.jrprint", false,false);
			
		}catch (JRException e2) {
			e2.printStackTrace();
		}
	}
	
	public void CargarReporteSecAct(String codasig){
		HashMap<String, String> mypara = new HashMap <String, String> ();
		mypara.put("codAsig", codasig);
		try {
			JasperFillManager.fillReportToFile("reportes/SecAct.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/SecAct.jrprint", false,false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void CargarReporteEval(String codevaluacion){
		HashMap<String,String> mypara = new HashMap <String, String> ();
		mypara.put("eva", codevaluacion);
		try {
			JasperFillManager.fillReportToFile("reportes/Eval.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/Eval.jrprint", false,false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ReporteMalla(String cod){
		HashMap<String,String> mypara = new HashMap <String, String> ();
		mypara.put("codcarr", cod);
		try {
			JasperFillManager.fillReportToFile("reportes/mallaCu.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/mallaCu.jrprint", false,false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CargarReporteAsignaturaPrecedente(String cod){
		 
		HashMap<String,String> mypara = new HashMap <String, String> ();
		mypara.put("codPre", cod);
		try {
			JasperFillManager.fillReportToFile("reportes/Precedente.jasper", mypara, myConnection);
     		JasperViewer.viewReport("reportes/Precedente.jrprint", false,false);
		 } catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Horas(int h){
		try {
			//Class.forName("org.postgresql.Driver");
			//java.sql.Connection myConnection = ConnectionBD.connect.getConnection();
			HashMap<String, Integer> mypara = new HashMap <String, Integer> ();
			mypara.put("horas", h);
			JasperFillManager.fillReportToFile("reportes/Horas.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/Horas.jrprint", false,false);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}
	
	}
