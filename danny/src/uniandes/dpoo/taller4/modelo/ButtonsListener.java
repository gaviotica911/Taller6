package uniandes.dpoo.taller4.modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ButtonsListener implements ActionListener {
    Tablero modelo;

    public ButtonsListener(Tablero modelo ) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String textoBoton = e.getActionCommand();

        if (textoBoton.equals("NUEVO")){
            int randomPlays = 1;
            String difficulty = e.getActionCommand();
            switch (difficulty) {
                case "Facil" -> randomPlays = 1;
                case "Medio" -> randomPlays = 2;
                case "Dificil" -> randomPlays = 5;
            }
            modelo.desordenar(randomPlays);
            boolean[][] tablero = modelo.darTablero();
            int tam = tablero.length;
            CreateRectangles[][] rectangles = PanelTablero.getRectangles();
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    if (tablero[i][j]){
                        rectangles[i][j].setIluminated(true);
                        rectangles[i][j].repaint();
                    }else{
                        rectangles[i][j].setIluminated(false);
                        rectangles[i][j].repaint();
                    }
                }
            }

        }else if(textoBoton.equals("REINICIAR")){
            modelo.reiniciar();

            boolean[][] tablero = modelo.darTablero();
            int tam = tablero.length;
            CreateRectangles[][] rectangles = PanelTablero.getRectangles();
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    if (tablero[i][j]){
                        rectangles[i][j].setIluminated(true);
                        rectangles[i][j].repaint();
                    }else{
                        rectangles[i][j].setIluminated(false);
                        rectangles[i][j].repaint();
                    }
                }

            }


        }else if(textoBoton.equals("TOP 10")){
            System.out.println("TOP 10 pa");
        }else if(textoBoton.equals("CAMBIAR JUGADOR")){
            System.out.println("CAMBIAR JUGADOR pa");
        }


    }
}
