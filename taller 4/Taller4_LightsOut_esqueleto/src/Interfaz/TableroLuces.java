package Interfaz;

import javax.swing.*;


import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableroLuces extends JPanel {
	
	private VentanaLights ventanaLights;
	private static  Casillas[][] laCasilla;

	 public TableroLuces(JPanel panel, int tamano, JFrame frameprincipal,VentanaLights ventanaLights ) {
		 	this.ventanaLights = ventanaLights;
	        panel.setLayout(new GridLayout(tamano, tamano,7,7));
	
	        int ancho = 800 / tamano;
	        int alto = 700 / tamano;
	       
	        laCasilla = new Casillas[tamano][tamano];
	        for (int i = 0; i < tamano; i++) {
	            for (int j = 0; j < tamano; j++) {
	         
	            	laCasilla[i][j] = new Casillas(0, 0, ancho, alto, true);
	                panel.add(laCasilla[i][j]);
	            }
	        }
	        
	    }
	 public void actualizar(int tamano, boolean[][]  matriz) {
	        
		 for (int i = 0; i < tamano; i++) {
             for (int j = 0; j < tamano; j++) {
                 if (matriz[i][j]){
                	 laCasilla[i][j].setPrendido(true);
                	 laCasilla[i][j].repaint();
                 }else{
                	 laCasilla[i][j].setPrendido(false);
                	 laCasilla[i][j].repaint();
                 }
             }

         }
	        
	    }
	
	public static Casillas [][] getCasillas(){
		return laCasilla;
		
	}
	
	public void clickCasilla(JPanel panelcentro ) {

        MouseListener listener = new MouseListener() {
        	 public void mouseClicked(MouseEvent e) {
        		 
        	 }
        
			public void mousePressed(MouseEvent e)
			{
				int click_x = e.getX();
				int click_y = e.getY();
				int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
				int fila = casilla[0];
		        int columna = casilla[1];
		        ventanaLights.jugar(fila,columna );
		        ventanaLights.contarMovimientos();
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
        panelcentro.addMouseListener(listener);
    }
			
			
			
			
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int tamano = laCasilla.length;
	int ancho = 800 / tamano;
    int alto = 700 / tamano;
	int fila = (int) (y / alto);
	int columna = (int) (x / ancho);
	return new int[] { fila, columna };
	}
	
}
