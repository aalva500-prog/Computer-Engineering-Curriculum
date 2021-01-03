package visuals;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;

import model.Usuario;

import utils.CurrentUser;


import Services.ServicioUsuario;



public class Autenticar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNombUsuario = null;
	private JLabel jLabelContrasenna = null;
	private JTextField jTextFieldUsuario = null;
	private JButton jButtonConectar = null;
	private JButton jButtonCancelar = null;
	private JPasswordField jPasswordFieldPass = null;
	

	/**
	 * @param owner
	 */
	public Autenticar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(209, 128);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Autenticacion");
		this.setContentPane(getJContentPane());
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowActivated(java.awt.event.WindowEvent e) {    
				jTextFieldUsuario.setText("");
				jPasswordFieldPass.setText("");
			}
			public void windowOpened(java.awt.event.WindowEvent e) {
				jTextFieldUsuario.setText("");
				jPasswordFieldPass.setText("");
				
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
			jLabelContrasenna = new JLabel();
			jLabelContrasenna.setBounds(new Rectangle(3, 31, 75, 14));
			jLabelContrasenna.setText("Contraseña :");
			jLabelNombUsuario = new JLabel();
			jLabelNombUsuario.setBounds(new Rectangle(27, 12, 50, 14));
			jLabelNombUsuario.setText("Usuario :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNombUsuario, null);
			jContentPane.add(jLabelContrasenna, null);
			jContentPane.add(getJTextFieldUsuario(), null);
			jContentPane.add(getJButtonConectar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldUsuario() {
		if (jTextFieldUsuario == null) {
			jTextFieldUsuario = new JTextField();
			jTextFieldUsuario.setBounds(new Rectangle(86, 11, 108, 16));
			jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode() == 10)
						getJButtonConectar().doClick();
				}
			});
		}
		return jTextFieldUsuario;
	}

	/**
	 * This method initializes jButtonConectar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonConectar() {
		if (jButtonConectar == null) {
			jButtonConectar = new JButton();
			jButtonConectar.setBounds(new Rectangle(7, 64, 93, 24));
			jButtonConectar.setText("Conectar");
			jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Obtener el rol del usuario que se está autenticando
					String rol = ServicioUsuario.getLoginUsuario(jTextFieldUsuario.getText(), jPasswordFieldPass.getPassword());
					if(rol.equals("")){
						JOptionPane.showMessageDialog(returnThis(), "Usuario y/o contraseña inválidos");
						//jTextFieldUsuario.setText("");
						jPasswordFieldPass.setText("");
					}else{
						//Creando una instancia de tipo usuario para actualizar la clase CurrentUser
						Usuario usuario = new Usuario(jTextFieldUsuario.getText(),rol);
						CurrentUser.getCurrentUser().setSessionUser(usuario);
						Principal frmPpal = new Principal(returnThis());
						returnThis().setVisible(false);
						frmPpal.setVisible(true);
					}
				}
			});
		}
		return jButtonConectar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(108, 64, 90, 24));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jPasswordFieldPass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPass() {
		if (jPasswordFieldPass == null) {
			jPasswordFieldPass = new JPasswordField();
			jPasswordFieldPass.setBounds(new Rectangle(86, 30, 108, 16));
			jPasswordFieldPass.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode() == 10)
						getJButtonConectar().doClick();
				}
			});
		}
		return jPasswordFieldPass;
	}
	public Autenticar returnThis(){
		return this;
	}

	public static void main(String[] args) {
		try {
			NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
			NimRODLookAndFeel.setCurrentTheme( new NimRODTheme(new Color(181,139,222),new Color(253,243,255)));
			UIManager.setLookAndFeel(NimRODLF);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		Autenticar autenticar = new Autenticar();
		autenticar.setVisible(true);
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
