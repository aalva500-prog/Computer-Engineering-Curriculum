package visuals;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.PlandeEstudio;
import utils.UserInterfaceSuport;
import Services.ServicioCarrera;
import Services.ServicioPlandeEstudio;

public class Planes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTablePlan = null;
	private JTable jTablePlan = null;
	private JTextField jTextFieldNomb = null;
	private JLabel jLabelNomb = null;
	private JLabel jLabelAnnos = null;
	private JLabel jLabelPeriodos = null;
	private JLabel jLabelCarrera = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JComboBox jComboBoxCarrera = null;	
	private JButton jButtonModificar = null;
	protected DefaultComboBoxModel defaultComboBoxModel = null;
	private JButton jButtonEliminar = null;
	protected String nuevo = "";  //  @jve:decl-index=0:
	private SpinnerNumberModel spinnerNumberModel = null;  //  @jve:decl-index=0:visual-constraint="553,264"
	private JSpinner jSpinner = null;
	private SpinnerNumberModel spinnerNumberModel1 = null;  //  @jve:decl-index=0:visual-constraint="553,264"
	private JSpinner jSpinner1 = null;
	private JButton jButtonNuevo = null;

	/**
	 * This is the default constructor
	 */
	public Planes() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * @return 
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(544, 321);
		this.setContentPane(getJContentPane());
		this.setTitle("Gestion de Planes de Estudio");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonAgreg.setEnabled(true);
				jButtonEliminar.setEnabled(false);
				jButtonModificar.setEnabled(false);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				LinkedList<PlandeEstudio> list = new LinkedList<PlandeEstudio>();
				try {
					list = ServicioPlandeEstudio.getPlanes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> columnDataNombre = new ArrayList<Object>();
				ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
				ArrayList<Object> columnDataAnno = new ArrayList<Object>();
				ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					columnDataNombre.add(list.get(i).getNombrePlan());
					columnDataPeriodo.add(list.get(i).getCantPeriodos());
					columnDataAnno.add(list.get(i).getCantAnnos());
					columnDataCarrera.add(list.get(i).getCodCarrera());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Plan de Estudio",columnDataNombre.toArray());
				defaultTableModel.addColumn("Cantidad Periodos",columnDataPeriodo.toArray());
				defaultTableModel.addColumn("Cantidad Anos",columnDataAnno.toArray());
				defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
				getJTablePlan().setModel(defaultTableModel);
				
				jTablePlan.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTablePlan.getSelectedRow();
						try {
							LinkedList<PlandeEstudio> planes = ServicioPlandeEstudio.getPlanes();
							PlandeEstudio u = planes.get(pos);
							jTextFieldNomb.setText(u.getNombrePlan());
							jSpinner.setValue(u.getCantPeriodos());
							jSpinner1.setValue(u.getCantAnnos());
							jSpinner.setEnabled(false);
							jSpinner1.setEnabled(false);
							jComboBoxCarrera.setEnabled(false);
                             //Combobox Carrera
							LinkedList<Carrera> carreras = new LinkedList<Carrera>();
							try {
								carreras = ServicioCarrera.getCarreras();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
							boxModelC.addElement(new String("<Seleccione>"));
							for (int i = 0; i < carreras.size(); i++) {
								boxModelC.addElement(carreras.get(i));
							}
							
							getJComboBoxCarrera().setModel(boxModelC);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						jButtonEliminar.setEnabled(true);
						jButtonModificar.setEnabled(true);
						jButtonAgreg.setEnabled(false);
						jLabelNomb.setText("Nuevo Plan:");						
					}
				});
     							
                //Combobox Carrera
				LinkedList<Carrera> carreras = new LinkedList<Carrera>();
				try {
					carreras = ServicioCarrera.getCarreras();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
				boxModelC.addElement(new String("<Seleccione>"));
				for (int i = 0; i < carreras.size(); i++) {
					boxModelC.addElement(carreras.get(i));
				}
				
				getJComboBoxCarrera().setModel(boxModelC);
			}
//			
		});
		
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
			jLabelNomb = new JLabel();
			jLabelNomb.setBounds(new Rectangle(10, 16, 131, 19));
			jLabelNomb.setText("Plan de Estudio:");
			jLabelPeriodos = new JLabel();
			jLabelPeriodos.setBounds(new Rectangle(10, 76, 131, 19));
			jLabelPeriodos.setText("Cantidad de Periodos:");
			jLabelAnnos = new JLabel();
			jLabelAnnos.setBounds(new Rectangle(177, 76, 131, 19));
			jLabelAnnos.setText("Cantidad de Años:");
			jLabelCarrera = new JLabel();
			jLabelCarrera.setBounds(new Rectangle(177, 16, 131, 19));
			jLabelCarrera.setText("Carrera:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneTablePlan(), null);
			jContentPane.add(getJTextFieldNombre(), null);
			jContentPane.add(jLabelCarrera, null);
			jContentPane.add(jLabelNomb, null);
			jContentPane.add(jLabelAnnos, null);
			jContentPane.add(jLabelPeriodos, null);
			jContentPane.add(jLabelNomb, null);
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJComboBoxCarrera(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(getJSpinner(), null);
			jContentPane.add(getJSpinner1(), null);
			jContentPane.add(getJButtonNuevo(), null);
			}
		return jContentPane;
	}
	
	/**
	 * This method initializes jScrollPaneTableUser	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTablePlan() {
		if (jScrollPaneTablePlan == null) {
			jScrollPaneTablePlan = new JScrollPane();
			jScrollPaneTablePlan.setBounds(new Rectangle(10, 139, 506, 103));
			jScrollPaneTablePlan.setViewportView(getJTablePlan());
			jScrollPaneTablePlan.setViewportView(getJTablePlan());
		}
		return jScrollPaneTablePlan;
	}
	
	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTablePlan() {
		if (jTablePlan == null) {
			jTablePlan = new JTable();
		}
		return jTablePlan;
	}

	/**
	 * This method initializes jTextFieldNomb	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNomb == null) {
			jTextFieldNomb = new JTextField();
			jTextFieldNomb.setBounds(new Rectangle(10, 38, 131, 19));
			}
		return jTextFieldNomb;
	}
	
	/**
	 * This method initializes jButtonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setText("Cerrar");
			jButtonCerrar.setBounds(new Rectangle(429, 252, 88, 21));
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}
	

	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxCarrera() {
		if (jComboBoxCarrera == null) {
			jComboBoxCarrera = new JComboBox();
			jComboBoxCarrera.setBounds(new Rectangle(177, 38, 131, 19));
		}
		return jComboBoxCarrera;
	}

	


	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(113, 252, 88, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Planes.this, "¿Está seguro que desea modificar el plan de estudio?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTablePlan.getSelectedRow();
					try {
						LinkedList<PlandeEstudio> planes = ServicioPlandeEstudio.getPlanes();
						PlandeEstudio p = planes.get(pos);
						ServicioPlandeEstudio.ModificarPlan(p.getCodPlan(),jTextFieldNomb.getText());
						JOptionPane.showMessageDialog(Planes.this, "Plan de Estudio Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<PlandeEstudio> list = new LinkedList<PlandeEstudio>();
						try {
							list = ServicioPlandeEstudio.getPlanes();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombrePlan());
							columnDataPeriodo.add(list.get(i).getCantPeriodos());
							columnDataAnno.add(list.get(i).getCantAnnos());
							columnDataCarrera.add(list.get(i).getCodCarrera());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Plan de Estudio",columnDataNombre.toArray());
						defaultTableModel.addColumn("Cantidad Periodos",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Cantidad Años",columnDataAnno.toArray());
						defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
						getJTablePlan().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Planes.this, "No se puede insertar dos Planes de Estudio de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jComboBoxCarrera.setEnabled(true);
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jLabelNomb.setText("Plan de Estudio:");
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
				}
				}});
			}
		return jButtonModificar;
	}

	
	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(216, 252, 88, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Planes.this, "¿Está seguro que desea eliminar el plan de estudio?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTablePlan.getSelectedRow();
					try {
						LinkedList<PlandeEstudio> planes = ServicioPlandeEstudio.getPlanes();
						PlandeEstudio p = planes.get(pos);
						ServicioPlandeEstudio.EliminarPlan(p.getNombrePlan());
						JOptionPane.showMessageDialog(Planes.this, "Plan de Estudio Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<PlandeEstudio> list = new LinkedList<PlandeEstudio>();
						try {
							list = ServicioPlandeEstudio.getPlanes();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombrePlan());
							columnDataPeriodo.add(list.get(i).getCantPeriodos());
							columnDataAnno.add(list.get(i).getCantAnnos());
							columnDataCarrera.add(list.get(i).getCodCarrera());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Plan de Estudio",columnDataNombre.toArray());
						defaultTableModel.addColumn("Cantidad Periodos",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Cantidad Años",columnDataAnno.toArray());
						defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
						getJTablePlan().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Planes.this, "Existen relaciones con este Plan de Estudio", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jComboBoxCarrera.setEnabled(true);
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jLabelNomb.setText("Plan de Estudio:");
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
				}
				}});
		}
		return jButtonEliminar;
	}
	
	
	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel() {
		if (spinnerNumberModel == null) {
			spinnerNumberModel = new SpinnerNumberModel(1,1,3,1);
		}
		return spinnerNumberModel;
	}

	/**
	 * This method initializes jSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner() {
		if (jSpinner == null) {
			jSpinner = new JSpinner(getSpinnerNumberModel());
			jSpinner.setBounds(new Rectangle(10, 101, 131, 19));
		}
		return jSpinner;
	}


	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel1() {
		if (spinnerNumberModel1 == null) {
			spinnerNumberModel1 = new SpinnerNumberModel(1,1,6,1);
		}
		return spinnerNumberModel1;
	}

	/**
	 * This method initializes jSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner1() {
		if (jSpinner1 == null) {
			jSpinner1 = new JSpinner(getSpinnerNumberModel1());
			jSpinner1.setBounds(new Rectangle(177, 101, 131, 19));
		}
		return jSpinner1;
	}
	
	/**
	 * This method initializes jButtonAgreg	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgreg() {
		if (jButtonAgreg == null) {
			jButtonAgreg = new JButton();
			jButtonAgreg.setBounds(new Rectangle(15, 252, 88, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldNomb.getText().length() > 0 && !(jComboBoxCarrera.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")){
					try {
						PlandeEstudio p = new PlandeEstudio(); 
						ServicioPlandeEstudio.insertarPlan(p.getCodPlan(),jTextFieldNomb.getText(),(Integer)jSpinner.getValue(),(Integer)jSpinner1.getValue(),((Carrera)getJComboBoxCarrera().getSelectedItem()).getCodCarrera());
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<PlandeEstudio> list = new LinkedList<PlandeEstudio>();
						try {
							list = ServicioPlandeEstudio.getPlanes();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombrePlan());
							columnDataPeriodo.add(list.get(i).getCantPeriodos());
							columnDataAnno.add(list.get(i).getCantAnnos());
							columnDataCarrera.add(list.get(i).getCodCarrera());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Plan de Estudio",columnDataNombre.toArray());
						defaultTableModel.addColumn("Cantidad Periodos",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Cantidad Anos",columnDataAnno.toArray());
						defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
						getJTablePlan().setModel(defaultTableModel);
							JOptionPane.showMessageDialog(Planes.this, "Plan de Estudio insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jContentPane);
							jSpinner.setValue(1);
							jSpinner1.setValue(1);
							jButtonEliminar.setEnabled(false);
							jButtonModificar.setEnabled(false);
							jLabelNomb.setText("Plan de Estudio:");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Planes.this, "No se puede insertar dos Planes de Estudio de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					else
					     JOptionPane.showMessageDialog(Planes.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			});
		}
		return jButtonAgreg;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new Rectangle(325, 252, 88, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldNomb.setText("");
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jComboBoxCarrera.setEnabled(true);
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jLabelNomb.setText("Plan de Estudio:");
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
					
//					Combobox Carrera
					LinkedList<Carrera> carreras = new LinkedList<Carrera>();
					try {
						carreras = ServicioCarrera.getCarreras();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
					boxModelC.addElement(new String("<Seleccione>"));
					for (int i = 0; i < carreras.size(); i++) {
						boxModelC.addElement(carreras.get(i));
					}
					
					getJComboBoxCarrera().setModel(boxModelC);
				}
			});
		}
		return jButtonNuevo;
	}
	
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
