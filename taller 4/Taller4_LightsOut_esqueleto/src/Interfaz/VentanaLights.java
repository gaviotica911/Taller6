package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


public class VentanaLights extends JFrame{
	private Tablero logica ;
	public JLabel panelBotones;
	public JLabel panelConfiguracion;
	public JLabel panelSur;
	public JFrame pPrincipal=new JFrame() ;
	public JPanel panelCentro;
	public JButton nuevo;
	public JButton reiniciar;
	public JButton top10;
	public JButton cambiarj;
	public JTextField jugador=new JTextField();
	public JLabel jugadas= new JLabel();
	public ButtonGroup grupob;
	public JComboBox combob;
	public int dificultadNUM;
	public TableroLuces tablero;
	public Top10 top10Logica =new Top10();
	public String nombreJugador;
	
	
	
	
	//private Tablero logicaTab= new Tablero();
	
	
	public VentanaLights() 
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
		{
				try {
					salvarTop10();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					
					e1.printStackTrace();
				}
		}
		});
		
		pPrincipal.setSize(800,700);
		pPrincipal.setTitle("LightsOut");
		pPrincipal.setLocationRelativeTo(null);//ventana centrada
		pPrincipal.setMinimumSize(new Dimension(500,500));
		pPrincipal.setLayout(new BorderLayout());
		
		panelBotones=new JLabel();
		panelBotones.setOpaque(true);
		panelBotones.setPreferredSize(new Dimension(270, 700));
		
		panelConfiguracion= new JLabel();
		panelConfiguracion.setBackground(new Color(101,173,249)  );
		panelConfiguracion.setOpaque(true);
		panelConfiguracion.setPreferredSize(new Dimension(700, 40));
		
		panelSur= new JLabel();
		panelSur.setOpaque(true);
		panelSur.setPreferredSize(new Dimension(700, 40));
		
		
		
		panelCentro= new JPanel();
		pPrincipal.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setPreferredSize(new Dimension(720, 430));
		setVisible(true);
		logica=new Tablero(5);
	
		tablero= new TableroLuces(panelCentro,5,pPrincipal,this);
        pPrincipal.pack();
        pPrincipal.setVisible(true);
	
		pPrincipal.add(panelBotones, BorderLayout.EAST);
		pPrincipal.add(panelConfiguracion, BorderLayout.NORTH);
		pPrincipal.add(panelSur, BorderLayout.SOUTH);
		
		pPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gridSur();
		gridNorte();
		botones();
		oyenteRatonBotonNuevo();
		oyentedeaccNuevoJugador();
		oyenteRatonReiniciar();
		tablero.clickCasilla( panelCentro );
		oyenteTop10();
	   
		
	}
	
	public void gridSur() 
	{
		 panelSur.setLayout(new GridLayout(1,4,10,10));
		
		 panelSur.add(new JLabel("Jugadas:"));
		 jugadas.setText("0");
		 panelSur.add(jugadas);//Num de jugadas
		 panelSur.add(new JLabel("Jugador: "));
		 panelSur.add(jugador);//nombre de l jugador
		

		
	}
	public void botones( )
	{
		nuevo = new JButton("NUEVO");
		nuevo.setBounds(0,200,270,30);
		nuevo.setForeground(Color.WHITE);
		nuevo.setFont(new Font("Segoe UI",0,15));
		nuevo.setBackground(new Color(101,173,249));
		panelBotones.add(nuevo);
		
		 reiniciar= new JButton("REINICIAR");
		reiniciar.setBounds(0,250,270,30);
		reiniciar.setForeground(Color.WHITE);
		reiniciar.setFont(new Font("Segoe UI",0,15));
		reiniciar.setBackground(new Color(101,173,249));
		panelBotones.add(reiniciar);
		
		 top10= new JButton("TOP-10");
		top10.setBounds(0,300,270,30);
		top10.setForeground(Color.WHITE);
		top10.setFont(new Font("Segoe UI",0,15));
		top10.setBackground(new Color(101,181,249) );
		panelBotones.add(top10);
		
		cambiarj= new JButton("CAMBIAR JUGADOR");
		cambiarj.setBounds(0,350,270,30);

		cambiarj.setForeground(Color.WHITE);
		cambiarj.setFont(new Font("Segoe UI",0,15));
		cambiarj.setBackground(new Color(101,173,249));
		panelBotones.add(cambiarj);

	}
	
	
	public void gridNorte() 
	{
		panelConfiguracion.setLayout(new GridLayout(1,6,10,10));
		//Add controls to set up horizontal and vertical gaps
		
		String [] tamaños= {"5x5","6x6","7x7", "4x4"};
		 combob= new JComboBox(tamaños);
		
		JLabel tamaño =new JLabel("Tamaño: ");
		tamaño.setFont(new Font("Segoe UI",Font.BOLD,13));
		tamaño.setForeground(Color.WHITE);
		
		JLabel dificultad =new JLabel("Dificultad: ");
		dificultad.setFont(new Font("Segoe UI",Font.BOLD,13));
		dificultad.setForeground(Color.WHITE);
		
		JRadioButton rb1= new JRadioButton("Fácil",true);
		rb1.setActionCommand("Fácil");
		rb1.setOpaque(false);
		rb1.setFont(new Font("Segoe UI",0,13));
		rb1.setForeground(Color.WHITE);
		JRadioButton rb2= new JRadioButton("Medio",false);	
		rb2.setActionCommand("Medio");
		rb2.setOpaque(false);
		rb2.setFont(new Font("Segoe UI",0,13));
		rb2.setForeground(Color.WHITE);
		JRadioButton rb3= new JRadioButton("Dificil",false);
		rb3.setActionCommand("Dificil");
		rb3.setOpaque(false);
		rb3.setFont(new Font("Segoe UI",0,13));
		rb3.setForeground(Color.WHITE);
		grupob= new ButtonGroup();
		grupob.add(rb2);
		grupob.add(rb1);
		grupob.add(rb3);
		
				
		panelConfiguracion.add(tamaño);
		
		panelConfiguracion.add(combob );
		
		panelConfiguracion.add(dificultad );
		panelConfiguracion.add(rb1);
		panelConfiguracion.add(rb2);
		panelConfiguracion.add(rb3);
		//contarMovimientos();

	}
	public String [] obtenerValoresTamaño() {
		String tam="error";
		String dificultad= grupob.getSelection().getActionCommand();
        
        String tamaño = (String) combob.getSelectedItem();
        switch (tamaño) {
        case "5x5" -> tam = "5";
        case "6x6" -> tam = "6";
        case "7x7" -> tam = "7";
        case "4x4" -> tam = "4";
		}
		
		String [] retorno= {dificultad,tam};
		return retorno;
	}
	public void contarMovimientos(){
        int jugada = logica.darJugadas();
        jugadas.setText(String.valueOf(jugada));
    }
	public void oyenteRatonBotonNuevo()
	
	{
		VentanaLights VentanaLights = this;
		MouseListener raton= new MouseListener() {//ESPICHAR NUEVO
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] valores=obtenerValoresTamaño();
				String dificultad=valores[0];
				switch (dificultad) {
                case "Facil" -> dificultadNUM = 1;
                case "Medio" -> dificultadNUM = 2;
                case "Dificil" -> dificultadNUM = 5;
				}
				logica=new Tablero(Integer.parseInt(valores[1]));
				logica.desordenar(dificultadNUM);
				logica.salvar_tablero();
				boolean[][] matriz= logica.darTablero();
				panelCentro.removeAll();
				tablero=new TableroLuces(panelCentro,Integer.parseInt(valores[1]),pPrincipal,VentanaLights);
				pPrincipal.pack();
		        pPrincipal.setVisible(true);
				tablero.actualizar(Integer.parseInt(valores[1]), matriz) ;
				if (logica.tableroIluminado()) {
					JOptionPane.showMessageDialog(null, "Felicidades, ganó");
					int puntaje= logica.calcularPuntaje();
					RegistroTop10 regtop10= new RegistroTop10( nombreJugador,puntaje);
					if (top10Logica.esTop10(puntaje)) {
						top10Logica.agregarRegistro(regtop10.darNombre(), regtop10.darPuntos());
						try {
							salvarTop10();
						} catch (FileNotFoundException | UnsupportedEncodingException e1) {
							
							e1.printStackTrace();
						}
					}
					else
					{
						
					}

				}

			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
					
			}
		};
		
		nuevo.addMouseListener(raton);
		
	}
	public void oyenteRatonReiniciar()
	{
		
		MouseListener raton= new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logica.reiniciar();
				boolean[][] matriz= logica.darTablero();
				
				tablero.actualizar(matriz.length, matriz) ;

			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
					
			}
		};
		
		reiniciar.addMouseListener(raton);
		
	}
	
	public void oyentedeaccNuevoJugador()
	{
		ActionListener oyente =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 nombreJugador=jugador.getText();
				
				
			}
			
		};
		
		cambiarj.addActionListener(oyente);
	}
	
	  public void jugar(int fila, int columna ){
		
		  logica.jugar(fila,columna);
          boolean[][] tablero = logica.darTablero();
          int tam = tablero.length;
          Casillas[][] lascasillas = TableroLuces.getCasillas();
          for (int i = 0; i < tam; i++) {
              for (int j = 0; j < tam; j++) {
                  if (tablero[i][j]){
                	  lascasillas[i][j].setPrendido(false);
                	  lascasillas[i][j].repaint();
                  }else{
                	  lascasillas[i][j].setPrendido(true);
                	  lascasillas[i][j].repaint();
                  }
              }
          }
          contarMovimientos();
		  
		  
	  }
	  public void oyenteTop10()
		{
			
			MouseListener raton= new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					VentanaTop10 ventanatop10= new VentanaTop10(top10Logica);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
						
				}
			};
			
			top10.addMouseListener(raton);
			
		}
		
	  
	  
	  
	  
	  public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException {
		  File file = new File("./data/top10.csv");
		  top10Logica.salvarRecords(file);
	  }
	
	

}
