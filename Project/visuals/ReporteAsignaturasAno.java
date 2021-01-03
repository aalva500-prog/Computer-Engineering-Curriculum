package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import utils.UserInterfaceSuport;
import Services.ServicioAsignatura;

public class ReporteAsignaturasAno extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel = null;

	private JComboBox jComboBox = null;

	private JButton jButton = null;
	
	/**
	 * This is the default constructor
	 */
	public ReporteAsignaturasAno() {
		super();
		initialize();
	   UserInterfaceSuport.centerComponent(ReporteAsignaturasAno.this);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 164);
		this.setContentPane(getJContentPane());
		this.setTitle("Asignaturas dado un año");
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
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
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
			jPanel.setBounds(new Rectangle(17, 14, 250, 72));
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "Seleccione un año", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.add(getJComboBox(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(25, 30, 126, 20));
			jComboBox.addItem("<Selecciones>");
			for(int i = 1 ; i < 7 ; i++){
				jComboBox.addItem(i);
			}
			jComboBox.setSelectedIndex(0);
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
			jButton.setBounds(new Rectangle(100, 99, 83, 19));
			jButton.setText("Mostrar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = new JFileChooser ();
					int value = fc.showSaveDialog(ReporteAsignaturasAno.this);
					if(value == JFileChooser.APPROVE_OPTION){
						File f = fc.getSelectedFile();
						int ano = jComboBox.getSelectedIndex();
						try {
							ServicioAsignatura.saveTxt(f.getPath(), ano);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					dispose();
				}
			});
		}
		return jButton;
	}
	
	

}  //  @jve:decl-index=0:visual-constraint="113,164"
