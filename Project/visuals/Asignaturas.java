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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import model.Asignatura;
import model.Curriculo;
import model.Disciplina;
import model.Evaluacion;
import model.PlandeEstudio;
import utils.UserInterfaceSuport;
import utils.Validate;
import Services.ServicioAsignatura;
import Services.ServicioCurriculo;
import Services.ServicioDisciplina;
import Services.ServicioEvaluacion;
import Services.ServicioPlandeEstudio;


public class Asignaturas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTableAsignatura = null;
	private JTable jTableAsignatura = null;
	private JTextField jTextFieldAsignatura = null;
    private SpinnerNumberModel spinnerNumberModel = null;  //  @jve:decl-index=0:visual-constraint="733,526"
	private JSpinner jSpinner = null;
	private SpinnerNumberModel spinnerNumberModel2 = null;  //  @jve:decl-index=0:visual-constraint="550,515"
	private JSpinner jSpinner2 = null;
	private SpinnerNumberModel spinnerNumberModel1 = null;  //  @jve:decl-index=0:visual-constraint="973,514"
	private JSpinner jSpinner1 = null;
	private JLabel jLabelAsignatura = null;
	private JLabel jLabelJefe = null;
	private JLabel jLabelAnno = null;
	private JLabel jLabelPeriodo = null;
	private JLabel jLabelHoras = null;
	private JLabel jLabelPlanMetodologico = null;
	private JLabel jLabelSecuencia = null;
	private JLabel jLabelPrograma = null;
	private JLabel jLabelEvaluacion = null;
	private JLabel jLabelAsignaturaPre = null;
	private JLabel jLabelDisciplina = null;
	private JLabel jLabelCurriculo = null;
	private JLabel jLabelPlandeEstudio = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JComboBox jComboBoxEvaluacion = null;	
	private JButton jButtonModificar = null;
	protected DefaultComboBoxModel defaultComboBoxModel = null;
	private JButton jButtonEliminar = null;
	protected String nuevo = "";  //  @jve:decl-index=0:
	private JComboBox jComboBoxAsignaturaPre = null;
	private JComboBox jComboBoxDisciplina = null;
	private JComboBox jComboBoxCurriculo = null;
	private JComboBox jComboBoxPlandeEstudio = null;
	private JTextField jTextFieldJefe1 = null;
	private JButton jButtonNuevo = null;
	private JTextArea jTextAreaPrograma = null;
	private JTextArea jTextAreaSecuencia = null;
	private JTextArea jTextAreaPlan = null;
	/**
	 * This is the default constructor
	 */
	public Asignaturas() {
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
		this.setSize(849, 421);
		this.setContentPane(getJContentPane());
		this.setContentPane(getJContentPane());
		this.setTitle("Gestion de Asignaturas");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonAgreg.setEnabled(true);
				jButtonEliminar.setEnabled(false);
				jButtonModificar.setEnabled(false);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
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
				ArrayList<Object> columnDataNombre = new ArrayList<Object>();
				ArrayList<Object> columnDataJefe = new ArrayList<Object>();
				ArrayList<Object> columnDataAnno = new ArrayList<Object>();
				ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
				ArrayList<Object> columnDataHoras = new ArrayList<Object>();
				ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
				ArrayList<Object> columnDataCurriculo = new ArrayList<Object>();
				ArrayList<Object> columnDataPlanEstudio = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					columnDataNombre.add(list.get(i).getNombreAsig());
					columnDataJefe.add(list.get(i).getJefeAsig());
					columnDataAnno.add(list.get(i).getAnno());
					columnDataPeriodo.add(list.get(i).getPeriodo());
					columnDataHoras.add(list.get(i).getCanthoras());
					columnDataDisciplina.add(list.get(i).getCoddisciplina());
					columnDataCurriculo.add(list.get(i).getCodcurriculo());
					columnDataPlanEstudio.add(list.get(i).getCodPlanEstudio());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
				defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
				defaultTableModel.addColumn("Año",columnDataAnno.toArray());
				defaultTableModel.addColumn("Periodo",columnDataPeriodo.toArray());
				defaultTableModel.addColumn("Horas",columnDataHoras.toArray());
				defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
				defaultTableModel.addColumn("Curriculo",columnDataCurriculo.toArray());
				defaultTableModel.addColumn("Plan de Estudio",columnDataPlanEstudio.toArray());
				getJTableAsignatura().setModel(defaultTableModel);
				
				jTableAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTableAsignatura.getSelectedRow();
						try {
							LinkedList<Asignatura> asignaturas = ServicioAsignatura.getAsignaturas();
							Asignatura a = asignaturas.get(pos);
						    jLabelAsignatura.setText("Nuevo Nombre:");
							jTextFieldAsignatura.setText(a.getNombreAsig());
							jTextFieldJefe1.setText(a.getJefeAsig());
						    jTextAreaPlan.setText(a.getPlanMetodologico());
							jTextAreaSecuencia.setText(a.getSecuenciaActividades());
							jTextAreaPrograma.setText(a.getProgramaAnalitico());
							jSpinner.setValue(a.getAnno());
							jSpinner1.setValue(a.getPeriodo());
							jSpinner2.setValue(a.getCanthoras());
							jTextFieldJefe1.setEditable(false);
						    jTextAreaPlan.setEditable(false);
							jTextAreaSecuencia.setEditable(false);
							jTextAreaPrograma.setEditable(false);
							jComboBoxEvaluacion.setEnabled(false);
							jComboBoxAsignaturaPre.setEnabled(false);
							jComboBoxDisciplina.setEnabled(false) ;
							jComboBoxCurriculo.setEnabled(false);
							jComboBoxPlandeEstudio.setEnabled(false);
							jSpinner.setEnabled(false);
							jSpinner1.setEnabled(false);
							jSpinner2.setEnabled(false);
							jButtonEliminar.setEnabled(true);
							jButtonModificar.setEnabled(true);
							jButtonAgreg.setEnabled(false);
							 //Combobox AsignaturaPre 
							LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
							try {
								list2 = ServicioAsignatura.getAsignaturas();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
							boxModel1.addElement(new String("<Seleccione>"));
							for (int i = 0; i < list2.size(); i++) {
								boxModel1.addElement(list2.get(i));
							}
							
							getJComboBoxAsignaturaPre().setModel(boxModel1);
							
			               //Combobox Evaluacion
							LinkedList<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
							try {
								evaluaciones = ServicioEvaluacion.getEvaluaciones();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
							boxModelF.addElement(new String("<Seleccione>"));
							for (int i = 0; i < evaluaciones.size(); i++) {
								boxModelF.addElement(evaluaciones.get(i));
							}
							
							getJComboBoxEvaluacion().setModel(boxModelF);
							
		                     //Combobox Disciplina
							LinkedList<Disciplina> disciplinas = new LinkedList<Disciplina>();
							try {
								disciplinas = ServicioDisciplina.getDisciplinas();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModelD = new DefaultComboBoxModel();
							boxModelD.addElement(new String("<Seleccione>"));
							for (int i = 0; i < disciplinas.size(); i++) {
								boxModelD.addElement(disciplinas.get(i));
							}
							
							getJComboBoxDisciplina().setModel(boxModelD);
							
		                      //Combobox Curriculo
							LinkedList<Curriculo> curriculos = new LinkedList<Curriculo>();
							try {
								curriculos = ServicioCurriculo.getCurriculos();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
							boxModelC.addElement(new String("<Seleccione>"));
							for (int i = 0; i < curriculos.size(); i++) {
								boxModelC.addElement(curriculos.get(i));
							}
							
							getJComboBoxCurriculo().setModel(boxModelC);
							
							//Combobox Plan de Estudio
							LinkedList<PlandeEstudio> planes = new LinkedList<PlandeEstudio>();
							try {
								planes = ServicioPlandeEstudio.getPlanes();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							DefaultComboBoxModel boxModelP = new DefaultComboBoxModel();
							boxModelP.addElement(new String("<Seleccione>"));
							for (int i = 0; i < planes.size(); i++) {
								boxModelP.addElement(planes.get(i));
							}
							
							getJComboBoxPlandeEstudio().setModel(boxModelP);
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
				});
     			//Combobox AsignaturaPre 
				LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
				try {
					list2 = ServicioAsignatura.getAsignaturas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
				boxModel1.addElement(new String("<Seleccione>"));
				for (int i = 0; i < list2.size(); i++) {
					boxModel1.addElement(list2.get(i));
				}
				
				getJComboBoxAsignaturaPre().setModel(boxModel1);
				
               //Combobox Evaluacion
				LinkedList<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
				try {
					evaluaciones = ServicioEvaluacion.getEvaluaciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
				boxModelF.addElement(new String("<Seleccione>"));
				for (int i = 0; i < evaluaciones.size(); i++) {
					boxModelF.addElement(evaluaciones.get(i));
				}
				
				getJComboBoxEvaluacion().setModel(boxModelF);
				
//				Combobox Disciplina
				LinkedList<Disciplina> disciplinas = new LinkedList<Disciplina>();
				try {
					disciplinas = ServicioDisciplina.getDisciplinas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelD = new DefaultComboBoxModel();
				boxModelD.addElement(new String("<Seleccione>"));
				for (int i = 0; i < disciplinas.size(); i++) {
					boxModelD.addElement(disciplinas.get(i));
				}
				
				getJComboBoxDisciplina().setModel(boxModelD);
				
//				Combobox Curriculo
				LinkedList<Curriculo> curriculos = new LinkedList<Curriculo>();
				try {
					curriculos = ServicioCurriculo.getCurriculos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
				boxModelC.addElement(new String("<Seleccione>"));
				for (int i = 0; i < curriculos.size(); i++) {
					boxModelC.addElement(curriculos.get(i));
				}
				
				getJComboBoxCurriculo().setModel(boxModelC);
				
				//Combobox Paln de Estudio
				LinkedList<PlandeEstudio> planes = new LinkedList<PlandeEstudio>();
				try {
					planes = ServicioPlandeEstudio.getPlanes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelP = new DefaultComboBoxModel();
				boxModelP.addElement(new String("<Seleccione>"));
				for (int i = 0; i < planes.size(); i++) {
					boxModelP.addElement(planes.get(i));
				}
				
				getJComboBoxPlandeEstudio().setModel(boxModelP);
				
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
			jLabelPlanMetodologico = new JLabel();
			jLabelPlanMetodologico.setBounds(new Rectangle(507, 79, 144, 18));
			jLabelPlanMetodologico.setText("Plan Metodologico:");
			jLabelAnno = new JLabel();
			jLabelAnno.setBounds(new Rectangle(673, 13, 144, 18));
			jLabelAnno.setText("Año:");
			jLabelHoras = new JLabel();
			jLabelHoras.setBounds(new Rectangle(507, 13, 144, 18));
			jLabelHoras.setText("Cantidad de Horas:");
			jLabelAsignatura = new JLabel();
			jLabelAsignatura.setBounds(new Rectangle(14, 13, 144, 18));
			jLabelAsignatura.setText("Nombre:");
			jLabelJefe = new JLabel();
			jLabelJefe.setBounds(new Rectangle(178, 13, 144, 18));
			jLabelJefe.setText("Jefe:");
			jLabelAsignaturaPre = new JLabel();
			jLabelAsignaturaPre.setText("Asignatura Precedente:");
			jLabelAsignaturaPre.setBounds(new Rectangle(178, 79, 144, 18));
			jLabelPeriodo = new JLabel();
			jLabelPeriodo.setText("Periodo:");
			jLabelPeriodo.setBounds(new Rectangle(341, 13, 144, 18));
			jLabelPrograma = new JLabel();
			jLabelPrograma.setText("Programa Analitico:");
			jLabelPrograma.setBounds(new Rectangle(673, 79, 144, 18));
			jLabelDisciplina = new JLabel();
			jLabelDisciplina.setText("Disciplina:");
			jLabelDisciplina.setBounds(new Rectangle(14, 79, 144, 18));
			jLabelSecuencia = new JLabel();
			jLabelSecuencia.setText("Secuencia de Actividad:");
			jLabelSecuencia.setBounds(new Rectangle(341, 79, 144, 18));
			jLabelEvaluacion = new JLabel();
			jLabelEvaluacion.setText("Evaluacion:");
			jLabelEvaluacion.setBounds(new Rectangle(14, 179, 144, 18));
			jLabelCurriculo = new JLabel();
			jLabelCurriculo.setText("Currículo:");
			jLabelCurriculo.setBounds(new Rectangle(178, 179, 144, 18));
			jLabelPlandeEstudio = new JLabel();
			jLabelPlandeEstudio.setText("Plan de Estudio:");
			jLabelPlandeEstudio.setBounds(new Rectangle(341, 179, 144, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneTableAsignatura(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(jLabelJefe, null);
			jContentPane.add(jLabelAsignatura, null);
			jContentPane.add(jLabelHoras, null);
			jContentPane.add(jLabelAnno, null);
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jLabelPlanMetodologico, null);
			jContentPane.add(jLabelAsignaturaPre, null);
			jContentPane.add(jLabelPrograma, null);
			jContentPane.add(jLabelDisciplina, null);
			jContentPane.add(jLabelSecuencia, null);
			jContentPane.add(jLabelEvaluacion, null);
			jContentPane.add(jLabelCurriculo, null);
			jContentPane.add(jLabelPeriodo, null);
			jContentPane.add(jLabelPlandeEstudio, null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJTextFieldJefe1(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJComboBoxCurriculo(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJTextFieldAsignatura(), null);
			jContentPane.add(getJComboBoxEvaluacion(), null);
			jContentPane.add(getJComboBoxAsignaturaPre(), null);
			jContentPane.add(getJComboBoxDisciplina(), null);
			jContentPane.add(getJComboBoxCurriculo(), null);
			jContentPane.add(getJComboBoxPlandeEstudio(), null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(getJSpinner(), null);
			jContentPane.add(getJSpinner1(), null);
			jContentPane.add(getJSpinner2(),null);
			jContentPane.add(getJButtonNuevo(), null);
			jContentPane.add(jSpinner2, null);
			jContentPane.add(getJTextAreaPrograma(), null);
			jContentPane.add(getJTextAreaSecuencia(), null);
			jContentPane.add(getJTextAreaPlan(), null);
			}
		return jContentPane;
	}
	/**
	 * This method initializes jScrollPaneTableUser	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTableAsignatura() {
		if (jScrollPaneTableAsignatura == null) {
			jScrollPaneTableAsignatura = new JScrollPane();
			jScrollPaneTableAsignatura.setBounds(new Rectangle(12, 242, 805, 103));
			jScrollPaneTableAsignatura.setViewportView(getJTableAsignatura());
		}
		return jScrollPaneTableAsignatura;
	}

	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTableAsignatura() {
		if (jTableAsignatura == null) {
			jTableAsignatura = new JTable();
		}
		return jTableAsignatura;
	}

	/**
	 * This method initializes jTextFieldUser	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAsignatura() {
		if (jTextFieldAsignatura == null) {
			jTextFieldAsignatura = new JTextField();
			jTextFieldAsignatura.setBounds(new Rectangle(14, 41, 144, 18));
			Validate.validateLetter(jTextFieldAsignatura);
		}
		return jTextFieldAsignatura;
	}

	/**
	 * This method initializes jTextFieldJefe1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldJefe1() {
		if (jTextFieldJefe1 == null) {
			jTextFieldJefe1 = new JTextField();
			jTextFieldJefe1.setBounds(new Rectangle(178, 41, 144, 18));
			Validate.validateLetter(jTextFieldJefe1);
		}
		return jTextFieldJefe1;
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
			jButtonCerrar.setBounds(new Rectangle(579, 355, 91, 21));
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
	private JComboBox getJComboBoxCurriculo() {
		if (jComboBoxCurriculo == null) {
			jComboBoxCurriculo = new JComboBox();
			jComboBoxCurriculo.setBounds(new Rectangle(178, 206, 144, 18));
		}
		return jComboBoxCurriculo;
	}

	
	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxAsignaturaPre() {
		if (jComboBoxAsignaturaPre == null) {
			jComboBoxAsignaturaPre = new JComboBox();
			jComboBoxAsignaturaPre.setBounds(new Rectangle(178, 107, 144, 18));
		}
		return jComboBoxAsignaturaPre;
	}

	
	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxDisciplina() {
		if (jComboBoxDisciplina == null) {
			jComboBoxDisciplina = new JComboBox();
			jComboBoxDisciplina.setBounds(new Rectangle(14, 107, 144, 18));
		}
		return jComboBoxDisciplina;
	}
	
	
	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxEvaluacion() {
		if (jComboBoxEvaluacion == null) {
			jComboBoxEvaluacion = new JComboBox();
			jComboBoxEvaluacion.setBounds(new Rectangle(14, 206, 144, 18));
		}
		return jComboBoxEvaluacion;
	}
	
	
	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPlandeEstudio() {
		if (jComboBoxPlandeEstudio == null) {
			jComboBoxPlandeEstudio = new JComboBox();
			jComboBoxPlandeEstudio.setBounds(new Rectangle(341, 206, 144, 18));
		}
		return jComboBoxPlandeEstudio;
	}
	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(264, 355, 91, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Asignaturas.this, "¿Está seguro que desea modificar la asignatura?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableAsignatura.getSelectedRow();
					try {
						LinkedList<Asignatura> asignaturas = ServicioAsignatura.getAsignaturas();
						Asignatura a = asignaturas.get(pos);
						ServicioAsignatura.ModificarAsignatura(jTextFieldAsignatura.getText(),a.getCodAsig());
						JOptionPane.showMessageDialog(Asignaturas.this, "Asignatura Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
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
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataJefe = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataHoras = new ArrayList<Object>();
						ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
						ArrayList<Object> columnDataCurriculo = new ArrayList<Object>();
						ArrayList<Object> columnDataPlanEstudio = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombreAsig());
							columnDataJefe.add(list.get(i).getJefeAsig());
							columnDataAnno.add(list.get(i).getAnno());
							columnDataPeriodo.add(list.get(i).getPeriodo());
							columnDataHoras.add(list.get(i).getCanthoras());
							columnDataDisciplina.add(list.get(i).getCoddisciplina());
							columnDataCurriculo.add(list.get(i).getCodcurriculo());
							columnDataPlanEstudio.add(list.get(i).getCodPlanEstudio());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
						defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
						defaultTableModel.addColumn("Año",columnDataAnno.toArray());
						defaultTableModel.addColumn("Periodo",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Horas",columnDataHoras.toArray());
						defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
						defaultTableModel.addColumn("Curriculo",columnDataCurriculo.toArray());
						defaultTableModel.addColumn("Plan de Estudio",columnDataPlanEstudio.toArray());
						getJTableAsignatura().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					//	Combobox AsignaturaPre
						LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
						try {
							list2 = ServicioAsignatura.getAsignaturas();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
						boxModel1.addElement(new String("<Seleccione>"));
						for (int i = 0; i < list2.size(); i++) {
							boxModel1.addElement(list2.get(i));
						}
						
						getJComboBoxAsignaturaPre().setModel(boxModel1);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Asignaturas.this, "No se puede insertar dos Asignaturas de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jLabelAsignatura.setText("Nombre:");
					jTextFieldJefe1.setEditable(true);
				    jTextAreaPlan.setEditable(true);
					jTextAreaSecuencia.setEditable(true);
					jTextAreaPrograma.setEditable(true);
					jComboBoxEvaluacion.setEnabled(true);
					jComboBoxAsignaturaPre.setEnabled(true);
					jComboBoxDisciplina.setEnabled(true);
					jComboBoxCurriculo.setEnabled(true);
					jComboBoxPlandeEstudio.setEnabled(true);
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jSpinner2.setEnabled(true);
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
					jSpinner2.setValue(1);
				}
				}});
			}
		return jButtonModificar;
	}
	
	
	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel1() {
		if (spinnerNumberModel1 == null) {
			spinnerNumberModel1 = new SpinnerNumberModel(1,1,3,1);
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
			jSpinner1.setBounds(new Rectangle(341, 41, 144, 18));
		}
		return jSpinner1;
	}
	
	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel2() {
		if (spinnerNumberModel2 == null) {
			spinnerNumberModel2 = new SpinnerNumberModel(1,1,1000,1);
		}
		return spinnerNumberModel2;
	}

	/**
	 * This method initializes jSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner2() {
		if (jSpinner2 == null) {
			jSpinner2 = new JSpinner(getSpinnerNumberModel2());
			jSpinner2.setBounds(new Rectangle(507, 41, 144, 18));
		}
		return jSpinner1;
	}
	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel() {
		if (spinnerNumberModel == null) {
			spinnerNumberModel = new SpinnerNumberModel(1,1,6,1);
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
			jSpinner.setBounds(new Rectangle(673, 41, 144, 18));
		}
		return jSpinner;
	}
	
	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(369, 355, 91, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Asignaturas.this, "¿Está seguro que desea eliminar la asignatura?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableAsignatura.getSelectedRow();
					try {
						LinkedList<Asignatura> asignaturas = ServicioAsignatura.getAsignaturas();
						Asignatura a = asignaturas.get(pos);
						ServicioAsignatura.EliminarAsignatura(a.getNombreAsig());
						JOptionPane.showMessageDialog(Asignaturas.this, "Asignatura Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
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
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataJefe = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataHoras = new ArrayList<Object>();
						ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
						ArrayList<Object> columnDataCurriculo = new ArrayList<Object>();
						ArrayList<Object> columnDataPlanEstudio = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombreAsig());
							columnDataJefe.add(list.get(i).getJefeAsig());
							columnDataAnno.add(list.get(i).getAnno());
							columnDataPeriodo.add(list.get(i).getPeriodo());
							columnDataHoras.add(list.get(i).getCanthoras());
							columnDataDisciplina.add(list.get(i).getCoddisciplina());
							columnDataCurriculo.add(list.get(i).getCodcurriculo());
							columnDataPlanEstudio.add(list.get(i).getCodPlanEstudio());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
						defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
						defaultTableModel.addColumn("Año",columnDataAnno.toArray());
						defaultTableModel.addColumn("Periodo",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Horas",columnDataHoras.toArray());
						defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
						defaultTableModel.addColumn("Curriculo",columnDataCurriculo.toArray());
						defaultTableModel.addColumn("Plan de Estudio",columnDataPlanEstudio.toArray());
						getJTableAsignatura().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
						//Combobox AsignaturaPre 
						LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
						try {
							list2 = ServicioAsignatura.getAsignaturas();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
						boxModel1.addElement(new String("<Seleccione>"));
						for (int i = 0; i < list2.size(); i++) {
							boxModel1.addElement(list2.get(i));
						}
						
						getJComboBoxAsignaturaPre().setModel(boxModel1);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Asignaturas.this, "Existen relaciones con esta asignatura", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jLabelAsignatura.setText("Nombre:");
					jTextFieldJefe1.setEditable(true);
				    jTextAreaPlan.setEditable(true);
					jTextAreaSecuencia.setEditable(true);
					jTextAreaPrograma.setEditable(true);
					jComboBoxEvaluacion.setEnabled(true);
					jComboBoxAsignaturaPre.setEnabled(true);
					jComboBoxDisciplina.setEnabled(true);
					jComboBoxCurriculo.setEnabled(true);
					jComboBoxPlandeEstudio.setEnabled(true);
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jSpinner2.setEnabled(true);
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
					jSpinner2.setValue(1);
				}
				}});
		}
		return jButtonEliminar;
	}
	
	
	/**
	 * This method initializes jButtonAgreg	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgreg() {
		if (jButtonAgreg == null) {
			jButtonAgreg = new JButton();
			jButtonAgreg.setBounds(new Rectangle(159, 355, 91, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldAsignatura.getText().length() > 0 && jTextAreaPlan.getText().length()>0 && jTextFieldJefe1.getText().length()>0
							&& jTextAreaPrograma.getText().length()>0 && jTextAreaSecuencia.getText().length()>0 && !(jComboBoxDisciplina.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")
							&& !(jComboBoxEvaluacion.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>") && !(jComboBoxCurriculo.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")
							&& !(jComboBoxPlandeEstudio.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")){
					try {
						if(jComboBoxAsignaturaPre.getSelectedIndex()!=0){
							Asignatura a = new Asignatura();
						ServicioAsignatura.insertarAsignatura(a.getCodAsig(), jTextFieldAsignatura.getText(), jTextFieldJefe1.getText(),(Integer)jSpinner2.getValue(), (Integer)jSpinner.getValue(),(Integer)jSpinner1.getValue(), jTextAreaPlan.getText(), jTextAreaPrograma.getText(), jTextAreaSecuencia.getText(), ((Evaluacion)getJComboBoxEvaluacion().getSelectedItem()).getCodEvaluacion(), ((PlandeEstudio)getJComboBoxPlandeEstudio().getSelectedItem()).getCodPlan(), ((Asignatura)getJComboBoxAsignaturaPre().getSelectedItem()).getCodAsig(), ((Disciplina)getJComboBoxDisciplina().getSelectedItem()).getCodDisplina(), ((Curriculo)getJComboBoxCurriculo().getSelectedItem()).getCodCurriculo());
						DefaultTableModel defaultTableModel = new DefaultTableModel();
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
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataJefe = new ArrayList<Object>();
						ArrayList<Object> columnDataAnno = new ArrayList<Object>();
						ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
						ArrayList<Object> columnDataHoras = new ArrayList<Object>();
						ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
						ArrayList<Object> columnDataCurriculo = new ArrayList<Object>();
						ArrayList<Object> columnDataPlanEstudio = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataNombre.add(list.get(i).getNombreAsig());
							columnDataJefe.add(list.get(i).getJefeAsig());
							columnDataAnno.add(list.get(i).getAnno());
							columnDataPeriodo.add(list.get(i).getPeriodo());
							columnDataHoras.add(list.get(i).getCanthoras());
							columnDataDisciplina.add(list.get(i).getCoddisciplina());
							columnDataCurriculo.add(list.get(i).getCodcurriculo());
							columnDataPlanEstudio.add(list.get(i).getCodPlanEstudio());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
						defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
						defaultTableModel.addColumn("Año",columnDataAnno.toArray());
						defaultTableModel.addColumn("Periodo",columnDataPeriodo.toArray());
						defaultTableModel.addColumn("Horas",columnDataHoras.toArray());
						defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
						defaultTableModel.addColumn("Curriculo",columnDataCurriculo.toArray());
						defaultTableModel.addColumn("Plan de Estudio",columnDataPlanEstudio.toArray());
						getJTableAsignatura().setModel(defaultTableModel);
							JOptionPane.showMessageDialog(Asignaturas.this, "Asignatura insertada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jContentPane);
							jSpinner.setValue(1);
							jSpinner1.setValue(1);
						}
						else{
							Asignatura a = new Asignatura();
							ServicioAsignatura.insertarAsignatura(a.getCodAsig(), jTextFieldAsignatura.getText(), jTextFieldJefe1.getText(), (Integer)jSpinner2.getValue(), (Integer)jSpinner.getValue(),(Integer)jSpinner1.getValue(), jTextAreaPlan.getText(), jTextAreaPrograma.getText(), jTextAreaSecuencia.getText(), ((Evaluacion)getJComboBoxEvaluacion().getSelectedItem()).getCodEvaluacion(), ((PlandeEstudio)getJComboBoxPlandeEstudio().getSelectedItem()).getCodPlan(), null, ((Disciplina)getJComboBoxDisciplina().getSelectedItem()).getCodDisplina(), ((Curriculo)getJComboBoxCurriculo().getSelectedItem()).getCodCurriculo());
							DefaultTableModel defaultTableModel = new DefaultTableModel();
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
							ArrayList<Object> columnDataNombre = new ArrayList<Object>();
							ArrayList<Object> columnDataJefe = new ArrayList<Object>();
							ArrayList<Object> columnDataAnno = new ArrayList<Object>();
							ArrayList<Object> columnDataPeriodo = new ArrayList<Object>();
							ArrayList<Object> columnDataHoras = new ArrayList<Object>();
							ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
							ArrayList<Object> columnDataCurriculo = new ArrayList<Object>();
							ArrayList<Object> columnDataPlanEstudio = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataNombre.add(list.get(i).getNombreAsig());
								columnDataJefe.add(list.get(i).getJefeAsig());
								columnDataAnno.add(list.get(i).getAnno());
								columnDataPeriodo.add(list.get(i).getPeriodo());
								columnDataHoras.add(list.get(i).getCanthoras());
								columnDataDisciplina.add(list.get(i).getCoddisciplina());
								columnDataCurriculo.add(list.get(i).getCodcurriculo());
								columnDataPlanEstudio.add(list.get(i).getCodPlanEstudio());
								}
							defaultTableModel.setRowCount(list.size());
							defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
							defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
							defaultTableModel.addColumn("Año",columnDataAnno.toArray());
							defaultTableModel.addColumn("Periodo",columnDataPeriodo.toArray());
							defaultTableModel.addColumn("Horas",columnDataHoras.toArray());
							defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
							defaultTableModel.addColumn("Curriculo",columnDataCurriculo.toArray());
							defaultTableModel.addColumn("Plan de Estudio",columnDataPlanEstudio.toArray());
							getJTableAsignatura().setModel(defaultTableModel);
								JOptionPane.showMessageDialog(Asignaturas.this, "Asignatura insertada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								UserInterfaceSuport.clearComponents(jContentPane);
								jSpinner.setValue(1);
								jSpinner1.setValue(1);
							
						}
//						Combobox AsignaturaPre 
						LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
						try {
							list2 = ServicioAsignatura.getAsignaturas();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
						boxModel1.addElement(new String("<Seleccione>"));
						for (int i = 0; i < list2.size(); i++) {
							boxModel1.addElement(list2.get(i));
						}
						
						getJComboBoxAsignaturaPre().setModel(boxModel1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Asignaturas.this, "Imposible insertar  esta asignatura, ya existe o las horas exceden el total de horas de la disciplina correspondiente  ", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jLabelAsignatura.setText("Nombre:");
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
					jSpinner2.setValue(1);
					}
					else
						JOptionPane.showMessageDialog(Asignaturas.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
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
			jButtonNuevo.setBounds(new Rectangle(475, 355, 91, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldAsignatura.setText("");
					jTextFieldJefe1.setText("");
					jTextAreaSecuencia.setText("");
					jTextAreaPlan.setText("");
					jTextAreaPrograma.setText("");
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jLabelAsignatura.setText("Nombre:");
					jTextFieldJefe1.setEditable(true);
				    jTextAreaPlan.setEditable(true);
					jTextAreaSecuencia.setEditable(true);
					jTextAreaPrograma.setEditable(true);
					jComboBoxEvaluacion.setEnabled(true);
					jComboBoxAsignaturaPre.setEnabled(true);
					jComboBoxDisciplina.setEnabled(true);
					jComboBoxCurriculo.setEnabled(true);
					jComboBoxPlandeEstudio.setEnabled(true);
					jSpinner.setEnabled(true);
					jSpinner1.setEnabled(true);
					jSpinner2.setEnabled(true);
					jSpinner.setValue(1);
					jSpinner1.setValue(1);
					jSpinner2.setValue(1);
                    //Combobox AsignaturaPre 
					LinkedList<Asignatura> list2 = new LinkedList<Asignatura>();
					try {
						list2 = ServicioAsignatura.getAsignaturas();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
					boxModel1.addElement(new String("<Seleccione>"));
					for (int i = 0; i < list2.size(); i++) {
						boxModel1.addElement(list2.get(i));
					}
					
					getJComboBoxAsignaturaPre().setModel(boxModel1);
					
	               //Combobox Evaluacion
					LinkedList<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
					try {
						evaluaciones = ServicioEvaluacion.getEvaluaciones();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
					boxModelF.addElement(new String("<Seleccione>"));
					for (int i = 0; i < evaluaciones.size(); i++) {
						boxModelF.addElement(evaluaciones.get(i));
					}
					
					getJComboBoxEvaluacion().setModel(boxModelF);
					
                     //Combobox Disciplina
					LinkedList<Disciplina> disciplinas = new LinkedList<Disciplina>();
					try {
						disciplinas = ServicioDisciplina.getDisciplinas();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelD = new DefaultComboBoxModel();
					boxModelD.addElement(new String("<Seleccione>"));
					for (int i = 0; i < disciplinas.size(); i++) {
						boxModelD.addElement(disciplinas.get(i));
					}
					
					getJComboBoxDisciplina().setModel(boxModelD);
					
                      //Combobox Curriculo
					LinkedList<Curriculo> curriculos = new LinkedList<Curriculo>();
					try {
						curriculos = ServicioCurriculo.getCurriculos();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelC = new DefaultComboBoxModel();
					boxModelC.addElement(new String("<Seleccione>"));
					for (int i = 0; i < curriculos.size(); i++) {
						boxModelC.addElement(curriculos.get(i));
					}
					
					getJComboBoxCurriculo().setModel(boxModelC);
					
					//Combobox Paln de Estudio
					LinkedList<PlandeEstudio> planes = new LinkedList<PlandeEstudio>();
					try {
						planes = ServicioPlandeEstudio.getPlanes();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelP = new DefaultComboBoxModel();
					boxModelP.addElement(new String("<Seleccione>"));
					for (int i = 0; i < planes.size(); i++) {
						boxModelP.addElement(planes.get(i));
					}
					
					getJComboBoxPlandeEstudio().setModel(boxModelP);
				}
			});
		}
		return jButtonNuevo;
	}

	/**
	 * This method initializes jTextAreaPrograma	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaPrograma() {
		if (jTextAreaPrograma == null) {
			jTextAreaPrograma = new JTextArea();
			jTextAreaPrograma.setBounds(new Rectangle(673, 107, 144, 49));
		}
		return jTextAreaPrograma;
	}

	/**
	 * This method initializes jTextAreaSecuencia	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaSecuencia() {
		if (jTextAreaSecuencia == null) {
			jTextAreaSecuencia = new JTextArea();
			jTextAreaSecuencia.setBounds(new Rectangle(341, 107, 144, 49));
		}
		return jTextAreaSecuencia;
	}

	/**
	 * This method initializes jTextAreaPlan	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaPlan() {
		if (jTextAreaPlan == null) {
			jTextAreaPlan = new JTextArea();
			jTextAreaPlan.setBounds(new Rectangle(507, 107, 144, 49));
		}
		return jTextAreaPlan;
	}
	
}  //  @jve:decl-index=0:visual-constraint="25,10"
