import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Temperatura extends JPanel {
	private JTextField txtEntrada;
	private JTextField txtResultado;

	/**
	 * Create the panel.
	 */
	
	
	public Temperatura() {
		setBorder(null);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setBackground(new Color(0, 153, 153));
		setLayout(null);
		
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
		txtEntrada.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		txtEntrada.setColumns(10);
		txtEntrada.setBounds(99, 30, 171, 34);
		add(txtEntrada);
		
		JComboBox cmbTemperatura = new JComboBox();
		cmbTemperatura.setMaximumRowCount(3);
		cmbTemperatura.setToolTipText("");
		
		cmbTemperatura.setModel(new DefaultComboBoxModel(new String[] {"Celsius a Farenheit", "Farenheit a Celsius"}));
		cmbTemperatura.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		cmbTemperatura.setBounds(99, 96, 171, 34);
		add(cmbTemperatura);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(99, 176, 171, 34);
		add(txtResultado);		
		
		
		cmbTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double entrada = Double.parseDouble(txtEntrada.getText());
				String repuesta = cmbTemperatura.getSelectedItem().toString();
				double temperatura;
				
				 switch(repuesta) {
				 	case "Celsius a Farenheit":
				 		temperatura = Celsius(entrada);
				 		txtResultado.setText(String.valueOf(temperatura) + "°F");
				 		break;
				 	case "Farenheit a Celsius":
				 		temperatura = Farenheit(entrada);
				 		txtResultado.setText(String.valueOf(temperatura) + "°C");
				 		break;				 	
				 		
				 } 	 				 
				
			}
		});
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		btnSalir.setBounds(295, 174, 105, 34);
		add(btnSalir);

	}
	
	private double Celsius(double d) {
		return (d*(9/5))+32;
	}
	
	private double Farenheit(double d) {
		return (d-32)*9/5;
	}
}
