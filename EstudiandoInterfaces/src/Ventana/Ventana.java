
package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Ventana extends JFrame {
	JPanel panel;
	
	public Ventana() {
		setSize(500,500);
		setTitle("Un Titulo chimba");
		
		//setLocation(100,200);
		//setBounds(100,200,500,500);
		setLocationRelativeTo(null);//ventana centrada
		setMinimumSize(new Dimension(200,200));
		//this.getContentPane().setBackground(Color.PINK);
		
		iniciarPanel();
		etiquetas();
		botonesyTxtField();
		colocarRadioBotones();
		listasdespegables();
		setDefaultCloseOperation(EXIT_ON_CLOSE);// que al cerrar la ventana se deje de ejecutar
	}
	private void iniciarPanel()
	{
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		this.getContentPane().add(panel);
		
		
				
	}
	private void etiquetas()
	{

		JLabel etiqueta = new JLabel("Hola que linda estas hoy mua te amo");
		etiqueta.setBounds(20,40,400,30);
		etiqueta.setForeground(new Color(218, 125, 223));
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.cyan);
		etiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		JLabel et2=new JLabel();
		et2.setText("Lindota");
		et2.setBounds(10,10,50,30);
		
		
		JLabel et3= new JLabel("siuuu", SwingConstants.CENTER);
		et3.setBounds(250,250,100,150);
		et3.setForeground(new Color(218, 125, 223));
		et3.setFont(new Font("chiller", Font.ITALIC, 40));
		
		JLabel luz=new JLabel(new ImageIcon("./data/luz.png"));
		luz.setBounds(10,80,100,100);
		
		
		panel.add(etiqueta);
		panel.add(et2);
		panel.add(et3);
		panel.add(luz);
	}
	
	private void botonesyTxtField()
	{
		JButton boton1= new JButton("Click",new ImageIcon("./data/luz.png"));//getScaledInstance(boton1.getWidtt....)
		boton1.setBounds(100,100,150,100);
		boton1.setMnemonic('a'); //dar click con tecla a
		boton1.setForeground(Color.CYAN);
		boton1.setFont(new Font("arial",Font.BOLD,20));
		boton1.setBackground(Color.BLACK);
		panel.add(boton1);
		
		JTextField cajaDeTexto= new JTextField("hola");
		cajaDeTexto.setBounds(50,200,100,30);
		//cajaDeTexto.setText("hola");//se le pasa un texto automatico
		//System.out.println("Texto en la caja: "+cajaDeTexto.getText());
		panel.add(cajaDeTexto);
		
		JTextArea jta=new JTextArea("xd");
		jta.append("\njaja");
		jta.setBounds(50,300,100,100);
		jta.setBackground(Color.GRAY);
		jta.setEditable(true);//puede ediar
		//System.out.println("Texto en el area: "+jta.getText());
		
		panel.add(jta);
		
	}
	
	private void colocarRadioBotones()
	{
		JRadioButton rb1= new JRadioButton("op 1",false);
		rb1.setBounds(200, 200, 100, 50);
		JRadioButton rb2= new JRadioButton("op 2",false);
		rb2.setBounds(200, 250, 100, 50);
		JRadioButton rb3= new JRadioButton("op 3",false);
		rb3.setBounds(200, 300, 100, 50);
		
		ButtonGroup grupob= new ButtonGroup();
		grupob.add(rb2);
		grupob.add(rb1);
		grupob.add(rb3);
		
		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);
	}
	private void listasdespegables()
	{
		String [] paises= {"Perú", "Colombia","Chile", "Mexico"};
		JComboBox listaD= new JComboBox(paises);
		listaD.setBounds(200, 400, 100, 50);
		listaD.addItem("Venezuela");//añadir objetos a la lista
		listaD.setSelectedItem("Mexico");//seleccionar el primer objeto visto
		panel.add(listaD);
	}

}
