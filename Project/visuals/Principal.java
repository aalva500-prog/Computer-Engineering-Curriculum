package visuals;



import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import utils.CurrentUser;





public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBarMenuPpal = null;
	private JMenu jMenuConexion = null;
	private JMenuItem jMenuItemConectar = null;
	private JMenuItem jMenuItemDesconectar = null;
	private JMenu jMenuGestionUsuario = null;
	private JMenuItem jMenuItemUsuarios = null;
	private JMenu jMenuReportes = null;
	private Autenticar owner = null;
	private JLabel jLabel;
	protected JFrame frame;
	private JMenuItem jMenuItem1Materia = null;
	private JMenuItem jMenuItemCarrera = null;
	private JMenuItem jMenuItemDisciplina = null;
	private JMenuItem jMenuItemPlanes = null;
	private JMenuItem jMenuItemAsignaturas = null;
	private JMenuItem jMenuItemAsignaturasSuperiores= null;  //  @jve:decl-index=0:
	private JMenuItem jMenuItemFicheroTexto = null;
	private JMenuItem jMenuItemPrograma = null;
	private JMenuItem jMenuItemPlan = null;
	private JMenuItem jMenuItemSecAct = null;
	private JMenuItem jMenuItemEva = null;
	private JMenuItem jMenuItemPrecedente = null;
	private JMenuItem jMenuItemMalla = null;
	

	

	/**
	 * This is the default constructor
	 */
	public Principal(Autenticar parent) {
		super();
		this.owner = parent;
		initialize();
	}

	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(421, 141);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/pay.png")));
		this.setJMenuBar(getJJMenuBarMenuPpal());
		this.setContentPane(getJContentPane());
		this.setTitle("Principal");
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosed(java.awt.event.WindowEvent e) {    
				getOwner().dispose();
			}
			public void windowOpened(java.awt.event.WindowEvent e) {
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Profesor")){
					getJMenuGestion().setVisible(true);
				}
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Invitado")){
					getJMenuGestion().setVisible(false);
				}
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
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("/iconos/titi.jpg")));
			jLabel.setName("jLabel");
			jLabel.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(new CardLayout());
			jContentPane.add(jLabel, jLabel.getName());
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jJMenuBarMenuPpal	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBarMenuPpal() {
		if (jJMenuBarMenuPpal == null) {
			jJMenuBarMenuPpal = new JMenuBar();
			jJMenuBarMenuPpal.setPreferredSize(new Dimension(0, 25));
			jJMenuBarMenuPpal.add(getJMenuConexion());
			jJMenuBarMenuPpal.add(getJMenuGestion());
			jJMenuBarMenuPpal.add(getJMenuReportes());
		}
		return jJMenuBarMenuPpal;
	}

	/**
	 * This method initializes jMenuConexion	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuConexion() {
		if (jMenuConexion == null) {
			jMenuConexion = new JMenu();
			jMenuConexion.setText("Conexion");
			jMenuConexion.add(getJMenuItemConectar());
			jMenuConexion.add(getJMenuItemDesconectar());
			}
		return jMenuConexion;
	}

	/**
	 * This method initializes jMenuItemConectar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemConectar() {
		if (jMenuItemConectar == null) {
			jMenuItemConectar = new JMenuItem();
			jMenuItemConectar.setText("Cambiar Usuario");
			jMenuItemConectar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
					getOwner().setVisible(true);
				}
			});
		}
		return jMenuItemConectar;
	}

	/**
	 * This method initializes jMenuItemDesconectar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemDesconectar() {
		if (jMenuItemDesconectar == null) {
			jMenuItemDesconectar = new JMenuItem();
			jMenuItemDesconectar.setText("Desconectar");
			jMenuItemDesconectar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jMenuItemDesconectar;
	}

	/**
	 * This method initializes jMenuGestionUsuario	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	public JMenu getJMenuGestion() {
		if (jMenuGestionUsuario == null) {
			jMenuGestionUsuario = new JMenu();
			jMenuGestionUsuario.setText("Gestion");
			jMenuGestionUsuario.add(getJMenuItemUsuarios());
			jMenuGestionUsuario.add(getJMenuItem1Facultad());
			jMenuGestionUsuario.add(getJMenuItemCarrera());
			jMenuGestionUsuario.add(getJMenuItemDisciplina());
			jMenuGestionUsuario.add(getJMenuItemPlanes());
			jMenuGestionUsuario.add(getJMenuItemAsignaturas());
		}
		return jMenuGestionUsuario;
	}

	/**
	 * This method initializes jMenuItemUsuarios	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemUsuarios() {
		if (jMenuItemUsuarios == null) {
			jMenuItemUsuarios = new JMenuItem();
			jMenuItemUsuarios.setText("Usuarios");
			jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Usuarios f = new Usuarios();
					f.setVisible(true);
				}
			});
		}
		return jMenuItemUsuarios;
	}

	/**
	 * This method initializes jMenuReportes	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuReportes() {
		if (jMenuReportes == null) {
			jMenuReportes = new JMenu();
			jMenuReportes.setText("Reportes");
			jMenuReportes.add(getJMenuItemAsignaturasSuperiores());
			jMenuReportes.add(getJMenuItemFicheroTexto());
			jMenuReportes.add(getJMenuItemPrograma());
			jMenuReportes.add(getJMenuItemPlan());
			jMenuReportes.add(getJMenuItemSecAct());
			jMenuReportes.add(getJMenuItemEva());
			jMenuReportes.add(getJMenuItemPrecedente());
			jMenuReportes.add(getJMenuItemMalla());
			}
		return jMenuReportes;
	}

	
	
	public Autenticar getOwner() {
		return owner;
	}
	
	public Principal returnThis(){
		return this;
	}




	/**
	 * This method initializes jMenuItem1Materia	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1Facultad() {
		if (jMenuItem1Materia == null) {
			jMenuItem1Materia = new JMenuItem();
			jMenuItem1Materia.setText("Facultades");
			jMenuItem1Materia.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Facultades f = new Facultades();
					f.setVisible(true);
					
					
				}
			});
		}
		return jMenuItem1Materia;
	}


	/**
	 * This method initializes jMenuItemCarrera	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemCarrera() {
		if (jMenuItemCarrera == null) {
			jMenuItemCarrera = new JMenuItem();
			jMenuItemCarrera.setText("Carreras");
			jMenuItemCarrera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Carreras f = new Carreras();
					f.setVisible(true);
					
					
				}
			});
		}
		return jMenuItemCarrera;
	}


	/**
	 * This method initializes jMenuItemDisciplina	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemDisciplina() {
		if (jMenuItemDisciplina == null) {
			jMenuItemDisciplina = new JMenuItem();
			jMenuItemDisciplina.setText("Disciplinas");
			jMenuItemDisciplina.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Disciplinas f = new Disciplinas();
					f.setVisible(true);
					
					
				}
			});
		}
		return jMenuItemDisciplina;
	}


	/**
	 * This method initializes jMenuItemPlanes	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPlanes() {
		if (jMenuItemPlanes == null) {
			jMenuItemPlanes = new JMenuItem();
			jMenuItemPlanes.setText("Planes de Estudio");
			jMenuItemPlanes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Planes p = new Planes();
					p.setVisible(true);
					
					
				}
			});
		}
		return jMenuItemPlanes;
	}


	/**
	 * This method initializes jMenuItemAsignaturas	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAsignaturas() {
		if (jMenuItemAsignaturas == null) {
			jMenuItemAsignaturas = new JMenuItem();
			jMenuItemAsignaturas.setText("Asignaturas");
			jMenuItemAsignaturas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Asignaturas p = new Asignaturas();
					p.setVisible(true);
					
					
				}
			});
		}
		return jMenuItemAsignaturas;
	}


	/**
	 * This method initializes jMenuItemAsignaturasSuperiores	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAsignaturasSuperiores() {
		if (jMenuItemAsignaturasSuperiores == null) {
			jMenuItemAsignaturasSuperiores = new JMenuItem();
			jMenuItemAsignaturasSuperiores.setText("Asignaturas con horas");
			jMenuItemAsignaturasSuperiores.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteAsigValor p = new ReporteAsigValor(frame);
					p.setVisible(true);
					
					
				}
			});
		}
		return jMenuItemAsignaturasSuperiores;
	}


	/**
	 * This method initializes jMenuItemFicheroTexto	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemFicheroTexto() {
		if (jMenuItemFicheroTexto == null) {
			jMenuItemFicheroTexto = new JMenuItem();
			jMenuItemFicheroTexto.setText("Fichero Texto"); 
			jMenuItemFicheroTexto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ReporteAsignaturasAno p = new ReporteAsignaturasAno();
				p.setVisible(true);			
			}
		});
		}
		return jMenuItemFicheroTexto;
	}


	/**
	 * This method initializes jMenuItemPrograma	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPrograma() {
		if (jMenuItemPrograma == null) {
			jMenuItemPrograma = new JMenuItem();
			jMenuItemPrograma.setText("Programa Analitico");
			jMenuItemPrograma.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteProgAna p = new ReporteProgAna();
					p.setVisible(true);			
				}
			});
		}
		return jMenuItemPrograma;
	}


	/**
	 * This method initializes jMenuItemPlan	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPlan() {
		if (jMenuItemPlan == null) {
			jMenuItemPlan = new JMenuItem();
			jMenuItemPlan.setText("Plan Metodologico");
			jMenuItemPlan.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReportePlanMet p = new ReportePlanMet();
					p.setVisible(true);			
				}
			});
		}
		return jMenuItemPlan;
	}


	/**
	 * This method initializes jMenuItemSecAct	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSecAct() {
		if (jMenuItemSecAct == null) {
			jMenuItemSecAct = new JMenuItem();
			jMenuItemSecAct.setText("Secuencia de Actividades") ;
			jMenuItemSecAct.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteSecAna p = new ReporteSecAna();
					p.setVisible(true);			
				}
			});
		}
		return jMenuItemSecAct;
	}


	/**
	 * This method initializes jMenuItemEva	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemEva() {
		if (jMenuItemEva == null) {
			jMenuItemEva = new JMenuItem();
			jMenuItemEva.setText("Evaluacion") ;
			jMenuItemEva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteEvalc_de_Asig p = new ReporteEvalc_de_Asig();
					p.setVisible(true);			
				}
			});
		}
		return jMenuItemEva;
	}


	/**
	 * This method initializes jMenuItemPrecedente	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPrecedente() {
		if (jMenuItemPrecedente == null) {
			jMenuItemPrecedente = new JMenuItem();
			jMenuItemPrecedente.setText("Asignaturas Precedentes") ;
			jMenuItemPrecedente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteAsignaturaPrecedente p = new ReporteAsignaturaPrecedente();
					p.setVisible(true);			
				}
			});
		}
		return jMenuItemPrecedente;
	}


	/**
	 * This method initializes jMenuItemMalla	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemMalla() {
		if (jMenuItemMalla == null) {
			jMenuItemMalla = new JMenuItem();
			jMenuItemMalla.setText("Malla Curricular") ;
			jMenuItemMalla.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ReporteMalla r = new ReporteMalla();
					r.setVisible(true);
				}
			});
		}
		return jMenuItemMalla;
	}


	}  //  @jve:decl-index=0:visual-constraint="182,89"
