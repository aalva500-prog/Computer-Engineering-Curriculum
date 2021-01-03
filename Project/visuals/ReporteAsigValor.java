package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import utils.Reportes;

public class ReporteAsigValor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private SpinnerNumberModel spinnerNumberModel1 = null;  //  @jve:decl-index=0:
	private JSpinner jSpinner1 = null;
	private JPanel jPanel = null;

	/**
	 * This is the default constructor
	 */
	public ReporteAsigValor(JFrame frame) {
		super();
		initialize();
		}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(240, 155);
		this.setContentPane(getJContentPane());
		this.setTitle("Entrar valor");
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
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(61, 87, 100, 20));
			jButton.setText("Mostrar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int valor = (Integer)jSpinner1.getValue();
					Reportes.getR().Horas(valor);
						dispose();
				}
				});
		}
		return jButton;
	}

	
	/**
	 * This method initializes spinnerNumberModel	
	 * 	
	 * @return javax.swing.SpinnerNumberModel	
	 */
	private SpinnerNumberModel getSpinnerNumberModel1() {
		if (spinnerNumberModel1 == null) {
			spinnerNumberModel1 = new SpinnerNumberModel(1,1,1000,1);
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
			}
		return jSpinner1;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setBounds(new Rectangle(18, 15, 189, 63));
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "Entre el valor", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.add(getJSpinner1(), null);
		}
		return jPanel;
	}
}  //  @jve:decl-index=0:visual-constraint="126,155"
