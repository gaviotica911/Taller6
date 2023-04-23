package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaLinda extends JFrame{
	private JPanel panel;
	private JLabel titulo;
	private JLabel saludo;
	private JTextField llenar;
	private JButton boton ;
	private JButton boton2 ;
	private JTextArea area;
	
	public VentanaLinda() 
	{
		setSize(500,500);
		setTitle("Eventos");
		setLocationRelativeTo(null);//ventana centrada
		setMinimumSize(new Dimension(200,200));
		
		panel();
		etiquetas();
		textField();
		button();
		oyentedeacc();
		oyenteRaton();
	}
	public void panel()
	{
		panel=new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
	}
	public void etiquetas()
	{
		titulo= new JLabel("Ingrese su nombre:");
		titulo.setBounds(30,10,250,30);
		titulo.setFont(new Font("Times New Roman", Font.BOLD,25));
		
		saludo=new JLabel();
		saludo.setBounds(50,200,300,40);
		saludo.setFont(new Font("Times New Roman",1, 20));
		panel.add(titulo);
		panel.add(saludo);
	}
	public void textField()
	{
		 llenar= new  JTextField();
		llenar.setBounds(30,50,300,30);
		panel.add(llenar);
		area=new JTextArea();
		area.setBounds(100,320,200,100);
		panel.add(area);
	}
	public void button()
	{
		 boton =new JButton("Done");
		boton.setBackground(Color.DARK_GRAY);
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Times New Roman", 0, 15));
		boton.setBounds(100,100,150,50);
		panel.add(boton);
		
		
		boton2=new JButton(new ImageIcon("./data/luz.png"));
		boton2.setBounds(100,200,100,100);
		
		panel.add(boton2);
		
		
	}
	
	public void oyentedeacc()
	{
		ActionListener oyente =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saludo.setText("Hola "+ llenar.getText());
				
			}
			
		};
		
		
		boton.addActionListener(oyente);
	}
	
	public void oyenteRaton()
	{
		
		MouseListener raton= new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				area.append("mouseClicked\n");
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				area.append("mouseReleased\n");	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				area.append("mouseEntered\n");	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				area.append("mouseExited\n");	
			}
		};
		
		
		
		boton2.addMouseListener(raton);
		
	}
	
	public void eventosteclado()
	{
		
	}
}
