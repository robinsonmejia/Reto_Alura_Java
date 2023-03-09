import javax.swing.JPanel;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Longitud extends JPanel {
	private JTextField txtEntrada;
	private JTextField txtResultado;

	/**
	 * Create the panel.
	 */
	public Longitud() {
		setBackground(new Color(135, 206, 235));
		setBorder(null);
		setAlignmentX(1.0f);
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
		txtEntrada.setBounds(77, 30, 171, 34);
		add(txtEntrada);
		
		JComboBox cmbLongitud = new JComboBox();
		cmbLongitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double entrada = Double.parseDouble(txtEntrada.getText());
				String repuesta = cmbLongitud.getSelectedItem().toString();
				double longitud;
				DecimalFormat df = new DecimalFormat("#.###");
				 
				 switch(repuesta) {
				 	case "Centimetro a Pulgada":
				 		longitud = GetCentimetro("pulgada", entrada);				 		
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " pulgada");
				 		break;
				 		
				 	case "Centimetro a Pie":
				 		longitud = GetCentimetro("pie", entrada);
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " pie");
				 		break;
				 		
				 	case "Pulgada a Centimetro":
				 		longitud = GetPulgada("centimetro", entrada);
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " centimetro");
				 		break;
				 		
				 	case "Pulgada a Pie":
				 		longitud = GetPulgada("pie", entrada);
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " pie");
				 		break;
				 		
				 	case "Pie a Centimetro":
				 		longitud = GetPie("centimetro", entrada);
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " centimetro");
				 		break;
				 		
				 	case "Pie a Pulgada":
				 		longitud = GetPie("pulgada", entrada);
				 		txtResultado.setText(String.valueOf(df.format(longitud)) + " pulgada");
				 		break;
				 		
				 } 
			}
		});
		cmbLongitud.setModel(new DefaultComboBoxModel(new String[] {"Centimetro a Pulgada", "Centimetro a Pie", "Pulgada a Centimetro", "Pulgada a Pie", "Pie a Centimetro", "Pie a Pulgada", ""}));
		cmbLongitud.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		cmbLongitud.setBounds(77, 96, 194, 34);
		add(cmbLongitud);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(77, 176, 171, 34);
		add(txtResultado);
		
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
	
	private double GetCentimetro(String datos, Double valor) {
		if(datos.equals("pulgada")) {
			return valor/2.54;
		}
		else {
			return valor/30.48;
		}
	}
	
	private double GetPulgada(String datos, Double valor) {
		if(datos.equals("centimetro")) {
			return valor*2.54;
		}
		else {
			return valor/12;
		}
	}
	
	private double GetPie(String datos, Double valor) {
		if(datos.equals("centimetro")) {
			return valor*30.48;
		}
		else {
			return valor*12;
		}
	}

}
