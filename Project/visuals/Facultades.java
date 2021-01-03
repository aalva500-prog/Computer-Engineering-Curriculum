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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Facultad;
import utils.UserInterfaceSuport;
import utils.Validate;
import Services.ServicioFacultad;

public class Facultades extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTableFacultad = null;
	private JTable jTableFacultad = null;
	private JTextField jTextFieldFacultad = null;
	private JTextField jTextFieldDecano = null;
	private JLabel jLabelFacultad = null;
	private JLabel jLabelDecano = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonModificar = null;
	protected int cod=0;
	protected String nuevo = "";  //  @jve:decl-index=0:
	private JButton jButtonNuevo = null;


	/**
	 * This is the default constructor
	 */
	public Facultades() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(522, 275);
		this.setContentPane(getjContentPane());
		this.setTitle("Gestion de Facultades");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonEliminar.setEnabled(false);
				jButtonModificar.setEnabled(false);
				jButtonAgreg.setEnabled(true);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				LinkedList<Facultad> list = new LinkedList<Facultad>();
				try {
					list = ServicioFacultad.getFacultades();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> columnDataDecano = new ArrayList<Object>();
				ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
				
				for (int i = 0; i < list.size(); i++) {
					columnDataDecano.add(list.get(i).getNombreDecano());
					columnDataFacultad.add(list.get(i).getNombreFacultad());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Decano",columnDataDecano.toArray());
				defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				getJTableFacultad().setModel(defaultTableModel);
				
				jTableFacultad.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTableFacultad.getSelectedRow();
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
						Facultad u = facultades.get(pos);
						jTextFieldFacultad.setText(u.getNombreFacultad());
                        jTextFieldDecano.setText(u.getNombreDecano());
                        jTextFieldDecano.setEditable(false);
						jButtonEliminar.setEnabled(true);
						jButtonModificar.setEnabled(true);
						jButtonAgreg.setEnabled(false);
						jLabelFacultad.setText("Nueva Facultad:");
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
			jLabelFacultad = new JLabel();
			jLabelFacultad.setText("Facultad:");
			jLabelFacultad.setBounds(new Rectangle(15, 28, 109, 16));
			jLabelDecano = new JLabel();
			jLabelDecano.setText("Decano:");
			jLabelDecano.setBounds(new Rectangle(165, 28, 109, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelFacultad, null);
			jContentPane.add(jLabelDecano, null);
			jContentPane.add(getJScrollPaneTableFacultad(), null);
			jContentPane.add(getJTextFieldFacultad(), null);
			jContentPane.add(getJTextFieldDecano(), null);
			jContentPane.add(jLabelFacultad, null);
			jContentPane.add(jLabelDecano, null);			
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonNuevo(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jButtonAgreg, null);
			jContentPane.add(jButtonAgreg, null);
			}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneTableUser	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTableFacultad() {
		if (jScrollPaneTableFacultad == null) {
			jScrollPaneTableFacultad = new JScrollPane();
			jScrollPaneTableFacultad.setBounds(new Rectangle(15, 84, 481, 103));
			jScrollPaneTableFacultad.setViewportView(getJTableFacultad());
		}
		return jScrollPaneTableFacultad;
	}
	
	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTableFacultad() {
		if (jTableFacultad == null) {
			jTableFacultad = new JTable();
		}
		return jTableFacultad;
	}
	
	/**
	 * This method initializes jTextFieldUser	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDecano() {
		if (jTextFieldDecano == null) {
			jTextFieldDecano = new JTextField();
			jTextFieldDecano.setBounds(new Rectangle(165, 56, 109, 16));
			Validate.validateLetter(jTextFieldDecano);
		}
		return jTextFieldDecano;
	}
	
	
	/**
	 * This method initializes jTextFieldNomb	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFacultad() {
		if (jTextFieldFacultad == null) {
			jTextFieldFacultad = new JTextField();
			jTextFieldFacultad.setBounds(new Rectangle(15, 56, 109, 16));
			Validate.validateLetter(jTextFieldFacultad);
		}
		return jTextFieldFacultad;
	}
	
	
	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(113, 197, 88, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Facultades.this, "¿Está seguro que desea modificar la facultad?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableFacultad.getSelectedRow();
					try {
						LinkedList<Facultad> facultades = ServicioFacultad.getFacultades();
						Facultad u = facultades.get(pos);
						ServicioFacultad.ModificarFacultad(jTextFieldFacultad.getText(),u.getIdFacultad());
						JOptionPane.showMessageDialog(Facultades.this, "Facultad Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Facultad> list = new LinkedList<Facultad>();
						list = ServicioFacultad.getFacultades();
						ArrayList<Object> columnDataDecano = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataDecano.add(list.get(i).getNombreDecano());
							columnDataFacultad.add(list.get(i).getNombreFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Decano",columnDataDecano.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				     	getJTableFacultad().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getjContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Facultades.this, "No se puede insertar dos Facultades de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jTextFieldDecano.setEditable(true);
					jButtonEliminar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jLabelFacultad.setText("Facultad:");
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
			jButtonCerrar.setBounds(new Rectangle(410, 197, 88, 21));
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
			jButtonAgreg.setBounds(new Rectangle(15, 197, 88, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldDecano.getText().length() > 0 && jTextFieldFacultad.getText().length() > 0 ){
					try {
						Facultad f = new Facultad();
						ServicioFacultad.insertarFacultad(f.getIdFacultad(), getJTextFieldDecano().getText(),getJTextFieldFacultad().getText());

						JOptionPane.showMessageDialog(Facultades.this, "Facultad Insertada", "Información", JOptionPane.INFORMATION_MESSAGE);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Facultad> list = new LinkedList<Facultad>();
						list = ServicioFacultad.getFacultades();
						ArrayList<Object> columnDataDecano = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataDecano.add(list.get(i).getNombreDecano());
							columnDataFacultad.add(list.get(i).getNombreFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Decano",columnDataDecano.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				     	getJTableFacultad().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getjContentPane());
																	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Facultades.this, "No se puede insertar dos Facultades de igual nombre", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jButtonEliminar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jLabelFacultad.setText("Facultad:");
					}
					else
						JOptionPane.showMessageDialog(Facultades.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
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
			jButtonEliminar.setBounds(new Rectangle(213, 197, 88, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Facultades.this, "¿Está seguro que desea eliminar la facultad?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableFacultad.getSelectedRow();
					try {
						LinkedList<Facultad> facultades = ServicioFacultad.getFacultades();
						Facultad u = facultades.get(pos);
						ServicioFacultad.EliminarFacultad(u.getNombreFacultad());
						JOptionPane.showMessageDialog(Facultades.this, "Facultad Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Facultad> list = new LinkedList<Facultad>();
						list = ServicioFacultad.getFacultades();
						ArrayList<Object> columnDataDecano = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataDecano.add(list.get(i).getNombreDecano());
							columnDataFacultad.add(list.get(i).getNombreFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Decano",columnDataDecano.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				     	getJTableFacultad().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getjContentPane());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Facultades.this, "Existen relaciones con esta Facultad", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jTextFieldDecano.setEditable(true);
					jButtonEliminar.setEnabled(false);
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jLabelFacultad.setText("Facultad:");
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
			jButtonNuevo.setBounds(new Rectangle(309, 197, 88, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldDecano.setEditable(true);
					jTextFieldDecano.setText("");
					jTextFieldFacultad.setText("");
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jLabelFacultad.setText("Facultad:");
				}
			});
		}
		return jButtonNuevo;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
