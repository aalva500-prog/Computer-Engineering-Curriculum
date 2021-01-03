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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Facultad;
import model.Rol;
import model.Usuario;
import utils.Encriptar;
import utils.UserInterfaceSuport;
import utils.Validate;
import Services.ServicioFacultad;
import Services.ServicioRol;
import Services.ServicioUsuario;



public class Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTableUser = null;
	private JTable jTableUser = null;
	private JTextField jTextFieldUser = null;
	private JTextField jTextFieldNomb = null;
	private JPasswordField jPasswordFieldPass = null;
	private JPasswordField jPasswordFieldConfirm = null;
	private JLabel jLabeluse = null;
	private JLabel jLabelNomb = null;
	private JLabel jLabelRol = null;
	private JLabel jLabelPas = null;
	private JLabel jLabelConfirmar = null;
	private JButton jButtonAgreg = null;
	private JButton jButtonCerrar = null;
	private JComboBox jComboBoxRol = null;	
	private JButton jButtonModificar = null;
	protected DefaultComboBoxModel defaultComboBoxModel = null;
	private JButton jButtonEliminar = null;
	protected String nuevo = "";  //  @jve:decl-index=0:
	private JLabel jLabelFacultad = null;
	private JComboBox jComboBoxFacultad = null;
	private JButton jButtonNuevo = null;
	/**
	 * This is the default constructor
	 */
	public Usuarios() {
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
		this.setTitle("Gestion de Usuarios");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				jButtonEliminar.setEnabled(false);
				jButtonAgreg.setEnabled(true);
				jButtonModificar.setEnabled(false);
				jButtonCerrar.setEnabled(true);
				jButtonNuevo.setEnabled(true);
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				LinkedList<Usuario> list = new LinkedList<Usuario>();
				try {
					list = ServicioUsuario.getUsuarios();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> columnDataUser = new ArrayList<Object>();
				ArrayList<Object> columnDataNombre = new ArrayList<Object>();
				ArrayList<Object> columnDataRol = new ArrayList<Object>();
				ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					columnDataUser.add(list.get(i).getUsername());
					columnDataNombre.add(list.get(i).getNombre());
					columnDataRol.add(list.get(i).getRol());
					columnDataFacultad.add(list.get(i).getFacultad());
					}
				defaultTableModel.setRowCount(list.size());
				defaultTableModel.addColumn("Usuario",columnDataUser.toArray());
				defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
				defaultTableModel.addColumn("Rol",columnDataRol.toArray());
				defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
				getJTableUser().setModel(defaultTableModel);
				
				jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int pos = jTableUser.getSelectedRow();
						try {
							jLabeluse.setText("Nuevo Usuario:");
							LinkedList<Usuario> users = ServicioUsuario.getUsuarios();
							Usuario u = users.get(pos);
							jTextFieldUser.setText(u.getUsername());
							jTextFieldNomb.setText(u.getNombre());
							jPasswordFieldPass.setText(u.getPassword());
							jPasswordFieldConfirm.setText(u.getPassword());
						//	Combobox Rol
							LinkedList<Rol> list2 = new LinkedList<Rol>();
							try {
								list2 = ServicioRol.getRoles();
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
							
							getJComboBoxRol().setModel(boxModel1);
							
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
							jTextFieldNomb.setEditable(false);
							jComboBoxFacultad.setEnabled(false);
							jComboBoxRol.setEnabled(false);
							jPasswordFieldPass.setEditable(false);
							jPasswordFieldConfirm.setEditable(false);
							
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
						
					}
				});
     			//Combobox Rol
				LinkedList<Rol> list2 = new LinkedList<Rol>();
				try {
					list2 = ServicioRol.getRoles();
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
				
				getJComboBoxRol().setModel(boxModel1);
				
//				Combobox Facultad
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
			jLabelFacultad.setBounds(new Rectangle(269, 73, 114, 19));
			jLabelFacultad.setText("Facultad:");
			jLabelConfirmar = new JLabel();
			jLabelConfirmar.setBounds(new Rectangle(139, 73, 114, 19));
			jLabelConfirmar.setText("Confirmar:");
			jLabelPas = new JLabel();
			jLabelPas.setBounds(new Rectangle(13, 73, 114, 19));
			jLabelPas.setText("Contraseña:");
			jLabelRol = new JLabel();
			jLabelRol.setBounds(new Rectangle(269, 11, 114, 19));
			jLabelRol.setText("Rol:");
			jLabelNomb = new JLabel();
			jLabelNomb.setBounds(new Rectangle(139, 11, 114, 19));
			jLabelNomb.setText("Nombre:");
			jLabeluse = new JLabel();
			jLabeluse.setBounds(new Rectangle(13, 11, 114, 19));
			jLabeluse.setText("Usuario:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneTableUser(), null);
			jContentPane.add(getJTextFieldUser(), null);
			jContentPane.add(getJTextFieldNomb(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
			jContentPane.add(getJPasswordFieldConfirm(), null);
			jContentPane.add(jLabeluse, null);
			jContentPane.add(jLabelNomb, null);
			jContentPane.add(jLabelRol, null);
			jContentPane.add(jLabelPas, null);
			jContentPane.add(jLabelConfirmar, null);
			jContentPane.add(getJButtonAgreg(), null);
			jContentPane.add(getJComboBoxRol(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(jLabelFacultad, null);
			jContentPane.add(getJComboBoxFacultad(), null);
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
	private JScrollPane getJScrollPaneTableUser() {
		if (jScrollPaneTableUser == null) {
			jScrollPaneTableUser = new JScrollPane();
			jScrollPaneTableUser.setBounds(new Rectangle(13, 139, 506, 103));
			jScrollPaneTableUser.setViewportView(getJTableUser());
		}
		return jScrollPaneTableUser;
	}

	/**
	 * This method initializes jTableUser	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTableUser() {
		if (jTableUser == null) {
			jTableUser = new JTable();
		}
		return jTableUser;
	}

	/**
	 * This method initializes jTextFieldUser	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldUser() {
		if (jTextFieldUser == null) {
			jTextFieldUser = new JTextField();
			jTextFieldUser.setBounds(new Rectangle(14, 37, 114, 19));
			Validate.validateLetter(jTextFieldUser);
		}
		return jTextFieldUser;
	}

	/**
	 * This method initializes jTextFieldNomb	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNomb() {
		if (jTextFieldNomb == null) {
			jTextFieldNomb = new JTextField();
			jTextFieldNomb.setBounds(new Rectangle(140, 37, 114, 19));
			Validate.validateLetter(jTextFieldNomb);
		}
		return jTextFieldNomb;
	}

	/**
	 * This method initializes jPasswordFieldPass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPass() {
		if (jPasswordFieldPass == null) {
			jPasswordFieldPass = new JPasswordField();
			jPasswordFieldPass.setBounds(new Rectangle(13, 97, 114, 19));
		}
		return jPasswordFieldPass;
	}

	/**
	 * This method initializes jPasswordFieldConfirm	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldConfirm() {
		if (jPasswordFieldConfirm == null) {
			jPasswordFieldConfirm = new JPasswordField();
			jPasswordFieldConfirm.setBounds(new Rectangle(139, 97, 114, 19));
		}
		return jPasswordFieldConfirm;
	}

	/**
	 * This method initializes jButtonAgreg	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgreg() {
		if (jButtonAgreg == null) {
			jButtonAgreg = new JButton();
			jButtonAgreg.setBounds(new Rectangle(13, 253, 91, 21));
			jButtonAgreg.setText("Insertar");
			jButtonAgreg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldNomb.getText().length() > 0 && jTextFieldUser.getText().length() > 0 && jPasswordFieldConfirm.getPassword().length > 0 
							&& jPasswordFieldPass.getPassword().length > 0 && !(jComboBoxFacultad.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")
							&& !(jComboBoxRol.getSelectedItem()).toString().equalsIgnoreCase("<Seleccione>")){
						try {
						if( Encriptar.getMd5(new String (getJPasswordFieldPass().getPassword())).equals(Encriptar.getMd5(new String(getJPasswordFieldConfirm().getPassword()))) ){
							ServicioUsuario.insertarUsuario(getJTextFieldUser().getText(), getJPasswordFieldPass().getPassword(), getJTextFieldNomb().getText(), ((Rol)getJComboBoxRol().getSelectedItem()).getRol(),((Facultad)getJComboBoxFacultad().getSelectedItem()).getIdFacultad());

							DefaultTableModel defaultTableModel = new DefaultTableModel();
							LinkedList<Usuario> list = new LinkedList<Usuario>();
							try {
								list = ServicioUsuario.getUsuarios();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
						        e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object> columnDataUser = new ArrayList<Object>();
							ArrayList<Object> columnDataNombre = new ArrayList<Object>();
							ArrayList<Object> columnDataRol = new ArrayList<Object>();
							ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataUser.add(list.get(i).getUsername());
								columnDataNombre.add(list.get(i).getNombre());
								columnDataRol.add(list.get(i).getRol());
								columnDataFacultad.add(list.get(i).getFacultad());
								}
							defaultTableModel.setRowCount(list.size());
							defaultTableModel.addColumn("Usuario",columnDataUser.toArray());
							defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
							defaultTableModel.addColumn("Rol",columnDataRol.toArray());
							defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
							getJTableUser().setModel(defaultTableModel);
							JOptionPane.showMessageDialog(Usuarios.this, "Usuario insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jContentPane);
							}
						else
							JOptionPane.showMessageDialog(returnThis(), "Las contrasenas deben ser iguales");
					
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Usuarios.this, "No se puede insertar dos Usuarios de igual Nombre de Usuario", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jLabeluse.setText("Usuario:");
					}
					else
						JOptionPane.showMessageDialog(Usuarios.this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
				
			});
		}
		return jButtonAgreg;
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
			jButtonCerrar.setBounds(new Rectangle(430, 253, 91, 21));
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}
	 private Usuarios returnThis(){
		 return this;
	 }

	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxRol() {
		if (jComboBoxRol == null) {
			jComboBoxRol = new JComboBox();
			jComboBoxRol.setBounds(new Rectangle(270, 37, 114, 19));
		}
		return jComboBoxRol;
	}

	


	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(113, 253, 91, 21));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Usuarios.this, "¿Está seguro que desea modificar el usuario?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableUser.getSelectedRow();
					try {
						LinkedList<Usuario> users = ServicioUsuario.getUsuarios();
						Usuario u = users.get(pos);
						ServicioUsuario.ModificarUsuario(jTextFieldUser.getText(),u.getNombre());
						JOptionPane.showMessageDialog(Usuarios.this, "Usuario Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Usuario> list = new LinkedList<Usuario>();
						try {
							list = ServicioUsuario.getUsuarios();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataUser = new ArrayList<Object>();
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataRol = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataUser.add(list.get(i).getUsername());
							columnDataNombre.add(list.get(i).getNombre());
							columnDataRol.add(list.get(i).getRol());
							columnDataFacultad.add(list.get(i).getFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Usuario",columnDataUser.toArray());
						defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
						defaultTableModel.addColumn("Rol",columnDataRol.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
						getJTableUser().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(Usuarios.this, "No se puede insertar dos Usuarios de igual Nombre de Usuario", "Error", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jLabeluse.setText("Usuario:");
					jButtonAgreg.setEnabled(true);
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jTextFieldNomb.setEditable(true);
					jComboBoxRol.setEnabled(true);
					jComboBoxFacultad.setEnabled(true);
					jPasswordFieldConfirm.setEditable(true);
					jPasswordFieldPass.setEditable(true);
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
			jButtonEliminar.setBounds(new Rectangle(216, 253, 91, 21));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(Usuarios.this, "¿Está seguro que desea eliminar el usuario?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTableUser.getSelectedRow();
					try {
						LinkedList<Usuario> users = ServicioUsuario.getUsuarios();
						Usuario u = users.get(pos);
						ServicioUsuario.EliminarUsuario(u.getUsername());
						JOptionPane.showMessageDialog(Usuarios.this, "Usuario Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						jButtonAgreg.setEnabled(true);
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						LinkedList<Usuario> list = new LinkedList<Usuario>();
						try {
							list = ServicioUsuario.getUsuarios();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataUser = new ArrayList<Object>();
						ArrayList<Object> columnDataNombre = new ArrayList<Object>();
						ArrayList<Object> columnDataRol = new ArrayList<Object>();
						ArrayList<Object> columnDataFacultad = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataUser.add(list.get(i).getUsername());
							columnDataNombre.add(list.get(i).getNombre());
							columnDataRol.add(list.get(i).getRol());
							columnDataFacultad.add(list.get(i).getFacultad());
							}
						defaultTableModel.setRowCount(list.size());
						defaultTableModel.addColumn("Usuario",columnDataUser.toArray());
						defaultTableModel.addColumn("Nombre",columnDataNombre.toArray());
						defaultTableModel.addColumn("Rol",columnDataRol.toArray());
						defaultTableModel.addColumn("Facultad",columnDataFacultad.toArray());
						getJTableUser().setModel(defaultTableModel);
						UserInterfaceSuport.clearComponents(getJContentPane());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jLabeluse.setText("Usuario:");
					jButtonAgreg.setEnabled(true);
					jButtonEliminar.setEnabled(false);
					jButtonModificar.setEnabled(false);
					jTextFieldNomb.setEditable(true);
					jComboBoxRol.setEnabled(true);
					jComboBoxFacultad.setEnabled(true);
					jPasswordFieldConfirm.setEditable(true);
					jPasswordFieldPass.setEditable(true);
				}
				}});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jComboBoxFacultad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxFacultad() {
		if (jComboBoxFacultad == null) {
			jComboBoxFacultad = new JComboBox();
			jComboBoxFacultad.setBounds(new Rectangle(269, 97, 114, 19));
		}
		return jComboBoxFacultad;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new Rectangle(322, 253, 91, 21));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldUser.setText("");
					jTextFieldNomb.setText("");
					jPasswordFieldPass.setText("");
					jPasswordFieldConfirm.setText("");
					jButtonAgreg.setEnabled(true);
					jButtonModificar.setEnabled(false);
					jButtonEliminar.setEnabled(false);
					jLabeluse.setText("Usuario:");
                    //Combobox Rol
					LinkedList<Rol> list2 = new LinkedList<Rol>();
					try {
						list2 = ServicioRol.getRoles();
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
					
					getJComboBoxRol().setModel(boxModel1);
					
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
					jTextFieldNomb.setEditable(true);
					jComboBoxRol.setEnabled(true);
					jComboBoxFacultad.setEnabled(true);
					jPasswordFieldConfirm.setEditable(true);
					jPasswordFieldPass.setEditable(true);
				}
			});
		}
		return jButtonNuevo;
	}

	

	
}  //  @jve:decl-index=0:visual-constraint="228,33"
 //  @jve:decl-index=0:visual-constraint="10,10"

