package visuals;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
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

import model.Disciplina;
import utils.UserInterfaceSuport;
import utils.Validate;
import Services.ServicioDisciplina;

public class Disciplinas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTableDisciplina = null;
	private JTable jTableDisciplina = null;
	private JTextField jTextFieldDisciplina = null;
	private JTextField jTextFieldJefe = null;
	private JLabel jLabelDisciplina = null;
	private JLabel jLabelJefe = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonModificar = null;
	private JLabel jLabelHoras = null;
	private JButton jButtonNuevo = null;
	private SpinnerNumberModel spinnerNumberModel = null;  //  @jve:decl-index=0:visual-constraint="808,457"
	private JSpinner jSpinner = null;
	
	

	/**
	 * This is the default constructor 
	 */
	public Disciplinas() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(533, 275);
		this.setContentPane(getjContentPane());
		this.setTitle("Gestion de Disciplinas");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonAgreg.setEnabled(true);
				jButtonEliminar.setEnabled(false);
				jButtonModificar.setEnabled(false);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				LinkedList<Disciplina> list = new LinkedList<Disciplina>();
				try {
					list = ServicioDisciplina.getDisciplinas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
				ArrayList<Object> columnDataJefe = new ArrayList<Object>();
				ArrayList<Object> columnDataHoras = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					columnDataDisciplina.add(list.get(i).getNombreDisciplina());
					columnDataJefe.add(list.get(i).getJefeDisciplina());
					columnDataHoras.add(list.get(i).getCanthorsTotales());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
				defaultTableModel.addColumn("Jefe Disciplina",columnDataJefe.toArray());
				defaultTableModel.addColumn("Horas Totales",columnDataHoras.toArray());
				getJTableDisciplina().setModel(defaultTableModel);
				
				jTableDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTableDisciplina.getSelectedRow();
						LinkedList<Disciplina> facultades = new LinkedList<Disciplina>();
						try {
							facultades = ServicioDisciplina.getDisciplinas();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Disciplina u = facultades.get(pos);
						jTextFieldDisciplina.setText(u.getNombreDisciplina());
						jTextFieldJefe.setText(u.getJefeDisciplina());
                        jTextFieldJefe.setEditable(false);
                        jSpinner.setEnabled(false);                
                       	jButtonEliminar.setEnabled(true);
						jButtonModificar.setEnabled(true);
						jButtonAgreg.setEnabled(false);
						jLabelDisciplina.setText("Nueva Disciplina:");
						jSpinner.setValue(u.getCanthorsTotales());
						
					}
				});
							
			}
				
		});
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));
	}
	
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getjContentPane() {
		if (jContentPane == null) {
			jLabelDisciplina = new JLabel();
			jLabelDisciplina.setText("Disciplina:");
			jLabelDisciplina.setBounds(new Rectangle(8, 23, 117, 16));
			jLabelJefe = new JLabel();
			jLabelJefe.setText("Jefe:");
			jLabelJefe.setBounds(new Rectangle(151, 23, 117, 16));
			jLabelHoras = new JLabel();
			jLabelHoras.setText("Total de Horas:");
			jLabelHoras.setBounds(new Rectangle(286, 23, 117, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelDisciplina, null);
			jContentPane.add(jLabelJefe, null);
			jContentPane.add(getJScrollPaneTableDisciplina(),null);
			jContentPane.add(getJTextFieldDisciplina(), null);
			jContentPane.add(jLabelDisciplina, null);
			jContentPane.add(jLabelJefe, null);			
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jLabelHoras, null);
			jContentPane.add(getJTextFieldJefe(), null);
			jContentPane.add(getJButtonNuevo(), null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(getJSpinner(), null);
			}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneTableUser	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTableDisciplina() {
		if (jScrollPaneTableDisciplina == null) {
			jScrollPaneTableDisciplina = new JScrollPane();
			jScrollPaneTableDisciplina.setBounds(new Rectangle(9, 84, 500, 103));
			jScrollPaneTableDisciplina.setViewportView(getJTableDisciplina());
		}
		return jScrollPaneTableDisciplina;
	}
	
	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTableDisciplina() {
		if (jTableDisciplina == null) {
			jTableDisciplina = new JTable();
		}
		return jTableDisciplina;
	}
	
	/**
	 * This method initializes jTextFieldUser	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDisciplina() {
		if (jTextFieldDisciplina == null) {
			jTextFieldDisciplina = new JTextField();
			jTextFieldDisciplina.setBounds(new Rectangle(8, 50, 117, 16));
			Validate.validateLetter(jTextFieldDisciplina);
		}
		return jTextFieldDisciplina;
	}
	
	
	/**
	 * This method initializes jTextFieldNomb	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldJefe() {
		if (jTextFieldJefe == null) {
			jTextFieldJefe = new JTextField();
			jTextFieldJefe.setBounds(new Rectangle(151, 50, 117, 16));
			Validate.validateLetter(jTextFieldJefe);
		}
		return jTextFieldJefe;
	}
	
	
	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(120, 198, 88, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Disciplinas.this, "¿Está seguro que desea modificar la disciplina?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableDisciplina.getSelectedRow();
					try {
						LinkedList<Disciplina> disciplinas = ServicioDisciplina.getDisciplinas();
						Disciplina u = disciplinas.get(pos);
						ServicioDisciplina.ModificarDisciplina(jTextFieldDisciplina.getText(),u.getCodDisplina());
						JOptionPane.showMessageDialog(Disciplinas.this, "Disciplina Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Disciplina> list = new LinkedList<Disciplina>();
						list = ServicioDisciplina.getDisciplinas();
						ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
						ArrayList<Object> columnDataJefe = new ArrayList<Object>();
						ArrayList<Object> columnDataHoras = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataDisciplina.add(list.get(i).getNombreDisciplina());
							columnDataJefe.add(list.get(i).getJefeDisciplina());
							columnDataHoras.add(list.get(i).getCanthorsTotales());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
						defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
						defaultTableModel.addColumn("Horas Totales",columnDataHoras.toArray());
				     	getJTableDisciplina().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getjContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Disciplinas.this, "No se puede insertar dos Disciplinas de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 jTextFieldJefe.setEditable(true);
                     jSpinner.setEnabled(true);     
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jLabelDisciplina.setText("Disciplina:");
					jSpinner.setValue(1);
				}
				}});
			}
		return jButtonModificar;
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
			jButtonCerrar.setBounds(new Rectangle(421, 198, 88, 21));
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}
	
	
	
	/**
	 * This method initializes jButtonAgreg	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgreg() {
		if (jButtonAgreg == null) {
			jButtonAgreg = new JButton();
			jButtonAgreg.setBounds(new Rectangle(21, 198, 88, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldDisciplina.getText().length() > 0 && jTextFieldJefe.getText().length() > 0 ){
					try {
						Disciplina d = new Disciplina();
						ServicioDisciplina.insertarDisciplina(d.getCodDisplina(),getJTextFieldDisciplina().getText(), getJTextFieldJefe().getText(),(Integer)jSpinner.getValue(),d.isCancelado());

							DefaultTableModel defaultTableModel = new DefaultTableModel();
							LinkedList<Disciplina> list = new LinkedList<Disciplina>();
							list = ServicioDisciplina.getDisciplinas();
							ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
							ArrayList<Object> columnDataJefe = new ArrayList<Object>();
							ArrayList<Object> columnDataHoras = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataDisciplina.add(list.get(i).getNombreDisciplina());
								columnDataJefe.add(list.get(i).getJefeDisciplina());
								columnDataHoras.add(list.get(i).getCanthorsTotales());
								}
							defaultTableModel.setRowCount(list.size());
							defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
							defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
							defaultTableModel.addColumn("Horas Totales",columnDataHoras.toArray());
							getJTableDisciplina().setModel(defaultTableModel);
							JOptionPane.showMessageDialog(Disciplinas.this, "Disciplina insertada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jContentPane);
																	
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Disciplinas.this, "No se puede insertar dos Disciplinas de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jSpinner.setValue(1);
						}
					else
						JOptionPane.showMessageDialog(Disciplinas.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			});
		}
		return jButtonAgreg;
	}
	
	

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(220, 198, 88, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Disciplinas.this, "¿Está seguro que desea eliminar la disciplina?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableDisciplina.getSelectedRow();
					try {
						LinkedList<Disciplina> disciplinas = ServicioDisciplina.getDisciplinas();
						Disciplina u = disciplinas.get(pos);
						ServicioDisciplina.EliminarDisciplina(u.getNombreDisciplina());
						JOptionPane.showMessageDialog(Disciplinas.this, "Disciplina Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Disciplina> list = new LinkedList<Disciplina>();
						list = ServicioDisciplina.getDisciplinas();
						ArrayList<Object> columnDataDisciplina = new ArrayList<Object>();
						ArrayList<Object> columnDataJefe = new ArrayList<Object>();
						ArrayList<Object> columnDataHoras = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataDisciplina.add(list.get(i).getNombreDisciplina());
							columnDataJefe.add(list.get(i).getJefeDisciplina());
							columnDataHoras.add(list.get(i).getCanthorsTotales());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Disciplina",columnDataDisciplina.toArray());
						defaultTableModel.addColumn("Jefe",columnDataJefe.toArray());
						defaultTableModel.addColumn("Horas Totales",columnDataHoras.toArray());
				     	getJTableDisciplina().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getjContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Disciplinas.this, "Existen relaciones con esta Disciplina", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 jTextFieldJefe.setEditable(true);
                     jSpinner.setEnabled(true);     
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jLabelDisciplina.setText("Disciplina:");
					jSpinner.setValue(1);
				}
				}});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new Rectangle(320, 198, 88, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldDisciplina.setText("");
					jTextFieldJefe.setText("");
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jTextFieldJefe.setEditable(true);
                    jSpinner.setEnabled(true);     
					jLabelDisciplina.setText("Disciplina:");
					jSpinner.setValue(1);
				}
			});
		}
		return jButtonNuevo;
	}

	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel() {
		if (spinnerNumberModel == null) {
			spinnerNumberModel = new SpinnerNumberModel(1,1,1000,1);
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
			jSpinner.setBounds(new Rectangle(286, 50, 117, 16));
		}
		return jSpinner;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"