package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Evaluacion;
import utils.Reportes;
import Services.ServicioEvaluacion;

public class ReporteEvalc_de_Asig extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel EAjPanel = null;

	private JButton mostrarjButton = null;

	private DefaultComboBoxModel defaultComboBoxModel = null;  //  @jve:decl-index=0:visual-constraint="540,129"

	private JComboBox jComboBox = null;

	/**
	 * This is the default constructor
	 */
	public ReporteEvalc_de_Asig() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(284, 156);
		this.setContentPane(getJContentPane());
		this.setTitle("Evaluacion de Asignaturas");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getEAjPanel(), null);
			jContentPane.add(getMostrarjButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes EAjPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getEAjPanel() {
		if (EAjPanel == null) {
			EAjPanel = new JPanel();
			EAjPanel.setLayout(null);
			EAjPanel.setBounds(new Rectangle(20, 16, 230, 61));
			EAjPanel.setBorder(BorderFactory.createTitledBorder(null, "Seleccione el tipo de evaluacion", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			EAjPanel.add(getJComboBox(), null);
		}
		return EAjPanel;
	}

	/**
	 * This method initializes mostrarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMostrarjButton() {
		if (mostrarjButton == null) {
			mostrarjButton = new JButton();
			mostrarjButton.setBounds(new Rectangle(90, 89, 86, 19));
			mostrarjButton.setText("Mostrar");
			mostrarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jComboBox.getSelectedIndex();					
					LinkedList<Evaluacion> list = new LinkedList<Evaluacion>();
					try {
						list = ServicioEvaluacion.getEvaluaciones();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String cod = list.get(pos - 1).getCodEvaluacion();
					Reportes.getR().CargarReporteEval(cod);
					dispose();
						}
					});
		}
		return mostrarjButton;
	}
	
	
	/**
	 * This method initializes defaultComboBoxModel	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getDefaultComboBoxModel() {
		if (defaultComboBoxModel == null) {
			defaultComboBoxModel = new DefaultComboBoxModel();
		}
		return defaultComboBoxModel;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(16, 26, 114, 19));
			jComboBox.setModel(getDefaultComboBoxModel());
			defaultComboBoxModel.addElement(new String("<Selccione>"));
			LinkedList<Evaluacion> list = new LinkedList<Evaluacion>();
			try {
				list = ServicioEvaluacion.getEvaluaciones();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Evaluacion e : list) {
				defaultComboBoxModel.addElement(e.getTipoEvluacion());
			}
			}
		return jComboBox;
	}

}  //  @jve:decl-index=0:visual-constraint="189,182"
