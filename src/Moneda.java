import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Moneda extends JPanel {
	private JTextField txtResultado;
	private JTextField txtEntrada;
	private double dollar= 55.15;
	private double euro = 58.18;
	private double libraEsterlina=65.23;
	private double yenJapones = 0.40;
	private double wonSurcoreano = 0.042;
	private double pesoDominicano;

	/**
	 * Create the panel.
	 */
	public Moneda() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JComboBox cmbMoneda = new JComboBox();
		cmbMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double entrada = Double.parseDouble(txtEntrada.getText());
				String repuesta = cmbMoneda.getSelectedItem().toString();
				double moneda;
				DecimalFormat df = new DecimalFormat("#.##");
				 
				 switch(repuesta) {
				 	case "Dop a Dollar":
				 		moneda = entrada / dollar;
				 		txtResultado.setText(String.valueOf(df.format(moneda)) + " USD");
				 		break;
				 	case "Dop a Euro":
				 		moneda = entrada / euro;
				 		txtResultado.setText(String.valueOf(df.format(moneda)) + " e");
				 		break;
				 	case "Dop a Libras Esterlinas":
				 		moneda = entrada / libraEsterlina;
				 		txtResultado.setText(String.valueOf(df.format(moneda)) + " esterlinas");
				 		break;	
				 	case "Dop a Yen Japones":
				 		moneda = entrada / yenJapones;
				 		txtResultado.setText(String.valueOf(df.format(moneda)) + " Yen japones");
				 		break;	
				 	case "Dop a Won Sur-Coreano":
				 		moneda = entrada / wonSurcoreano;
				 		txtResultado.setText(String.valueOf(df.format(moneda)) + " Won Surcoreano");
				 		break;	
				 	case "Dollar a Dop":
				 		moneda = entrada * dollar;
				 		txtResultado.setText(String.valueOf(moneda) + " $RD");
				 		break;	
				 	case "Euro a Dop":
				 		moneda = entrada * euro;
				 		txtResultado.setText(String.valueOf(moneda) + " $RD");
				 		break;	
				 	case "Libras Esterlinas a Dop":
				 		moneda = entrada * libraEsterlina;
				 		txtResultado.setText(String.valueOf(moneda) + " $RD");
				 		break;	
				 	case "Yen Japones a Dop":
				 		moneda = entrada * yenJapones;
				 		txtResultado.setText(String.valueOf(moneda) + " $RD");
				 		break;	
				 	case "Won Sur-Coreano a Dop":
				 		moneda = entrada * wonSurcoreano;
				 		txtResultado.setText(String.valueOf(moneda) + " $RD");
				 		break;	
				 		
				 } 
			}
		});
		cmbMoneda.setBounds(122, 102, 171, 34);
		cmbMoneda.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		cmbMoneda.setModel(new DefaultComboBoxModel(new String[] {"Dop a Dollar", "Dop a Euro", "Dop a Libras Esterlinas", "Dop a Yen Japones", "Dop a Won Sur-Coreano", "Dollar a Dop", "Euro a Dop", "Libras Esterlinas a Dop", "Yen Japones a Dop", "Won Sur-Coreano a Dop"}));
		add(cmbMoneda);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(122, 182, 171, 34);
		txtResultado.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		add(txtResultado);
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setBounds(320, 180, 105, 34);
		add(btnSalir);
		btnSalir.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		
		txtEntrada = new JTextField();
		txtEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != '.') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se permiten numeros y un solo punto","Error",JOptionPane.ERROR_MESSAGE);
				}
				if(c =='.' && txtEntrada.getText().contains(".")) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se permite un solo punto","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtEntrada.setBounds(122, 36, 171, 34);
		txtEntrada.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		txtEntrada.setColumns(10);
		add(txtEntrada);

	}

}
