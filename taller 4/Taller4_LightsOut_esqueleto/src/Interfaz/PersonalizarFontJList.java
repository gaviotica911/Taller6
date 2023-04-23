package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;

import uniandes.dpoo.taller4.modelo.Top10;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;

public class PersonalizarFontJList extends DefaultListCellRenderer {
	private final Font fontBold = new Font("Segoe UI", Font.BOLD, 14);
    private final Font fontNormal = new Font("Segoe UI", 0, 14);
    private final Color blue = new Color(60, 90, 200);
   

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

      
        if (index==0 || index==1|| index==2) {
            label.setFont(fontBold);
            label.setForeground(blue);
        } else {
            label.setFont(fontNormal);
        }

        return label;
    }
	

}
