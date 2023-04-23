package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Casillas extends JPanel {
	private int x, y, ancho, largo;
	
	Image image ;
    private boolean prendido;
    public Casillas(int x, int y, int ancho, int largo, boolean prendido) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.largo = largo;
        this.prendido = prendido;
    }
    public void imagen() {
    	try {
            // Carga la imagen desde un archivo (o desde otro origen como una URL o una base de datos)
            File file = new File("./data/luz.png");
            image = ImageIO.read(file);

        } catch (IOException e) {
            // Maneja la excepción si ocurre algún error al cargar la imagen
            System.out.println("Error al cargar la imagen.");
            e.printStackTrace();
        }
    	
    	
    	
    }

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        imagen();
        if(prendido) {
        	g2d.setColor(Color.YELLOW);
            g2d.fillRect(x, y, ancho, largo);
            g2d.drawImage(image, 0, 0, (ancho-50), (largo-50), null);
        	
        }
        else {
        	g2d.setColor(Color.GRAY);
            g2d.fillRect(x, y, ancho, largo);
            g2d.drawImage(image, 0, 0, (ancho-50), (largo-50), null);
        }
       
       
        
    }
	public void setPrendido(boolean prendido) {
		this.prendido = prendido;
	}
	

    
}