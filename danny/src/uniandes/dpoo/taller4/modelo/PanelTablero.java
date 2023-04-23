package uniandes.dpoo.taller4.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class PanelTablero {

    static Ventana ventana;

    private static CreateRectangles[][] rectangles;

    public PanelTablero(Container container, int tam, JFrame padre, Ventana ventana) {
        this.ventana = ventana;
        container.setLayout(new GridLayout(tam, tam,7,7));
        BorderLayout layout = (BorderLayout) padre.getLayout();
        Dimension cellSize = layout.preferredLayoutSize(padre);
        int cellWidth = cellSize.width / tam;
        int cellHeight = cellSize.height / tam;
        System.out.println(cellWidth+cellHeight  );
        rectangles = new CreateRectangles[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                rectangles[i][j] = new CreateRectangles(0, 0, cellWidth, cellHeight, true);
                container.add(rectangles[i][j]);
            }
        }
    }

    public static void actualizar(Container grid, JFrame padre, int tam, JTextField movements ) {

        MouseListener listener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int[] casilla= coorToRow(grid,tam,x,y, padre);
                int fila = casilla[0];
                int columna = casilla[1];
                ventana.jugar(fila,columna );
                ventana.countMovements(movements);
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
        grid.addMouseListener(listener);
    }

    private static int[] coorToRow(Container grid, int tam, int x, int y, JFrame padre){

        BorderLayout layout = (BorderLayout) padre.getLayout();
        Dimension cellSize = layout.preferredLayoutSize(padre);
        int cellWidth = cellSize.width / tam;
        int cellHeight = cellSize.height / tam;
        double divColumna = (double) x / cellWidth;
        int columna = (int) Math.round(divColumna);
        double divFila = (double) y / cellHeight;
        int fila = (int) Math.round(divFila);
        return new int[] {fila,columna};
    }

    public static CreateRectangles[][] getRectangles() {
        return rectangles;
    }



}
