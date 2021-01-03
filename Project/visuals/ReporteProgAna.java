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
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Asignatura;
import utils.Reportes;
import Services.ServicioAsignatura;

public class ReporteProgAna extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JComboBox jComboBox = null;

	private JButton jButton = null;

	private JPanel jPanel = null;

	private DefaultComboBoxModel defaultComboBoxModel = null;  //  @jve:decl-index=0:visual-constraint="540,81"

	/**
	 * This is the default constructor
	 */
	public ReporteProgAna() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(283, 156);
		this.setContentPane(getJContentPane());
		this.setTitle("Mostrar Programa Analitico");
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
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(28, 25, 155, 19));
			jComboBox.setModel(getDefaultComboBoxModel());
			defaultComboBoxModel.addElement(new String ("<Selccione>"));
			LinkedList<Asignatura> list = new LinkedList<Asignatura>();
			try {
				list = ServicioAsignatura.getAsignaturas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Asignatura asignatura : list) {
				defaultComboBoxModel.addElement(asignatura.getNombreAsig());
			}
		}
		return jComboBox;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(83, 88, 89, 19));
			jButton.setText("Mostrar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jComboBox.getSelectedIndex();
					LinkedList<Asignatura> list = new LinkedList<Asignatura>();
					try {
						list = ServicioAsignatura.getAsignaturas();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String cod = list.get(pos - 1).getCodAsig();
					Reportes.getR().CargarReporteProgramaAnalitico(cod);
					dispose();
					
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(16, 16, 234, 60));
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "Seleccione la asignatura", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.add(getJComboBox(), null);
		}
		return jPanel;
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

}  //  @jve:decl-index=0:visual-constraint="125,121"
