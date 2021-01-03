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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.Facultad;
import utils.UserInterfaceSuport;
import utils.Validate;
import Services.ServicioCarrera;
import Services.ServicioFacultad;

public class Carreras extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTableCarrera = null;
	private JTable jTableCarrera = null;
	private JLabel jLabelCarrera = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JButton jButtonModificar = null;
	protected DefaultComboBoxModel defaultComboBoxModel = null;
	private JButton jButtonEliminar = null;
	private JLabel jLabelFacultad = null;
	private JComboBox jComboBoxFacultad = null;
	private JTextField jTextFieldCarrera = null;
	private JButton jButtonNuevo = null;
	
	/**
	 * This is the default constructor
	 */
	public Carreras() {
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
		this.setSize(523, 269);
		this.setContentPane(getJContentPane());
		this.setTitle("Gestion de Carreras");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonAgreg.setEnabled(true);
				jButtonEliminar.setEnabled(false);
				jButtonModificar.setEnabled(false);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				LinkedList<Carrera> list = new LinkedList<Carrera>();
				try {
					list = ServicioCarrera.getCarreras();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
				ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					columnDataCarrera.add(list.get(i).getNombCarrera());
					columnDataFacultad.add(list.get(i).getIdFacultad());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
				defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				getJTableCarrera().setModel(defaultTableModel);
				
				jTableCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTableCarrera.getSelectedRow();
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
						Carrera c = carreras.get(pos);
						jTextFieldCarrera.setText(c.getNombCarrera());						
						jButtonEliminar.setEnabled(true);
						jButtonModificar.setEnabled(true);
						jButtonAgreg.setEnabled(false);
						jComboBoxFacultad.setEnabled(false);
						jLabelCarrera.setText("Nueva Carrera:");
                         //Combobox Facultad
						LinkedList<Facultad> facultades = new LinkedList<Facultad>();
						try {
							facultades = ServicioFacultad.getFacultades();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
						boxModelF.addElement(new String("<Seleccione>"));
						for (int i = 0; i < facultades.size(); i++) {
							boxModelF.addElement(facultades.get(i));
						}
						
						getJComboBoxFacultad().setModel(boxModelF);
					
						}
				});
     			//Combobox Facultad
				LinkedList<Facultad> facultades = new LinkedList<Facultad>();
				try {
					facultades = ServicioFacultad.getFacultades();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
				boxModelF.addElement(new String("<Seleccione>"));
				for (int i = 0; i < facultades.size(); i++) {
					boxModelF.addElement(facultades.get(i));
				}
				
				getJComboBoxFacultad().setModel(boxModelF);
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
			jLabelFacultad = new JLabel();
			jLabelFacultad.setBounds(new Rectangle(136, 18, 114, 19));
			jLabelFacultad.setText("Facultad:");
			jLabelCarrera = new JLabel();
			jLabelCarrera.setBounds(new Rectangle(7, 18, 114, 19));
			jLabelCarrera.setText("Carrera:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneTableCarrera(), null);
			jContentPane.add(jLabelCarrera, null);
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jLabelFacultad, null);
			jContentPane.add(getJComboBoxFacultad(), null);
			jContentPane.add(getJTextFieldCarrera(), null);
			jContentPane.add(getJButtonNuevo(), null);
			jContentPane.add(jButtonAgreg, null);
			}
		return jContentPane;
	}
	

	/**
	 * This method initializes jScrollPaneTableUser	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTableCarrera() {
		if (jScrollPaneTableCarrera == null) {
			jScrollPaneTableCarrera = new JScrollPane();
			jScrollPaneTableCarrera.setBounds(new Rectangle(7, 78, 489, 103));
			jScrollPaneTableCarrera.setViewportView(getJTableCarrera());
			}
		return jScrollPaneTableCarrera;
	}
	
	
	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTableCarrera() {
		if (jTableCarrera == null) {
			jTableCarrera = new JTable();
		}
		return jTableCarrera;
	}

	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxFacultad() {
		if (jComboBoxFacultad == null) {
			jComboBoxFacultad = new JComboBox();
			jComboBoxFacultad.setBounds(new Rectangle(136, 43, 114, 19));
		}
		return jComboBoxFacultad;
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
			jButtonCerrar.setBounds(new Rectangle(405, 191, 91, 21));
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(110, 191, 91, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Carreras.this, "¿Está seguro que desea modificar la carrera?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableCarrera.getSelectedRow();
					try {
						LinkedList<Carrera> carreras = ServicioCarrera.getCarreras();
						Carrera c = carreras.get(pos);
						ServicioCarrera.ModificarCarrera(jTextFieldCarrera.getText(),c.getCodCarrera());
						JOptionPane.showMessageDialog(Carreras.this, "Carrera Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Carrera> list = new LinkedList<Carrera>();
						try {
							list = ServicioCarrera.getCarreras();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataCarrera.add(list.get(i).getNombCarrera());
							columnDataFacultad.add(list.get(i).getIdFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
						getJTableCarrera().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Carreras.this, "No se puede insertar dos Carreras de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jComboBoxFacultad.setEnabled(true);
					jLabelCarrera.setText("Carrera:");
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
			jButtonEliminar.setBounds(new Rectangle(208, 191, 91, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Carreras.this, "¿Está seguro que desea eliminar la carrera?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableCarrera.getSelectedRow();
					try {
						LinkedList<Carrera> carreras = ServicioCarrera.getCarreras();
						Carrera c = carreras.get(pos);
						ServicioCarrera.EliminarCarrera(c.getNombCarrera());
						JOptionPane.showMessageDialog(Carreras.this, "Carrera Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Carrera> list = new LinkedList<Carrera>();
						try {
							list = ServicioCarrera.getCarreras();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataCarrera.add(list.get(i).getNombCarrera());
							columnDataFacultad.add(list.get(i).getIdFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
						getJTableCarrera().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Carreras.this, "Existen relaciones con esta Carrera", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jComboBoxFacultad.setEnabled(true);
					jLabelCarrera.setText("Carrera:");
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
			jButtonAgreg.setBounds(new Rectangle(11, 191, 91, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldCarrera.getText().length() > 0 && !(jComboBoxFacultad.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")){
					try {
						Carrera c = new Carrera();
						ServicioCarrera.insertarCarrera(c.getCodCarrera(), getJTextFieldCarrera().getText(),((Facultad)getJComboBoxFacultad().getSelectedItem()).getIdFacultad());

							DefaultTableModel defaultTableModel = new DefaultTableModel();
							LinkedList<Carrera> list = new LinkedList<Carrera>();
							try {
								list = ServicioCarrera.getCarreras();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object> columnDataCarrera = new ArrayList<Object>();
							ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataCarrera.add(list.get(i).getNombCarrera());
								columnDataFacultad.add(list.get(i).getIdFacultad());
								}
							defaultTableModel.setRowCount(list.size());
							defaultTableModel.addColumn("Carrera",columnDataCarrera.toArray());
							defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
							getJTableCarrera().setModel(defaultTableModel);
							JOptionPane.showMessageDialog(Carreras.this, "Carrera insertada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jContentPane);
																		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Carreras.this, "No se puede insertar dos Carreras de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jLabelCarrera.setText("Carrera:");
					}
					else
						JOptionPane.showMessageDialog(Carreras.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			});
		}
		return jButtonAgreg;
	}


	/**
	 * This method initializes jTextFieldCarrera	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCarrera() {
		if (jTextFieldCarrera == null) {
			jTextFieldCarrera = new JTextField();
			jTextFieldCarrera.setBounds(new Rectangle(7, 43, 114, 19));
			Validate.validateLetter(jTextFieldCarrera);
		}
		return jTextFieldCarrera;
	}


	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new Rectangle(307, 191, 91, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldCarrera.setText("");
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jComboBoxFacultad.setEnabled(true);
					jLabelCarrera.setText("Carrera:");
//					Combobox Facultad
					LinkedList<Facultad> facultades = new LinkedList<Facultad>();
					try {
						facultades = ServicioFacultad.getFacultades();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultComboBoxModel boxModelF = new DefaultComboBoxModel();
					boxModelF.addElement(new String("<Seleccione>"));
					for (int i = 0; i < facultades.size(); i++) {
						boxModelF.addElement(facultades.get(i));
					}
					
					getJComboBoxFacultad().setModel(boxModelF);
				}
			});
		}
		return jButtonNuevo;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
