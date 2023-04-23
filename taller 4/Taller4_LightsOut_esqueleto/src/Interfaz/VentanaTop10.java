package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaTop10 extends JDialog {
	
	VentanaTop10(Top10 top) {

		 
		JDialog dialog = new JDialog();
		
		dialog.setLayout(new BorderLayout());

		
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLUE);
		dialog.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(1,3));
		panelNorte.add(new JLabel("Posición"));
		panelNorte.add(new JLabel("Jugador"));
		panelNorte.add(new JLabel("Puntaje"));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.PINK);
		
		panelCentro.setLayout(new GridLayout(1,3));
		DefaultListModel<String> listModel1 = new DefaultListModel<>();
		for(int i =1; i<=10;i++) {
			listModel1.addElement(i+".");
		}
		JList<String> list1 = new JList<>(listModel1);
		list1.setCellRenderer(new PersonalizarFontJList());
		
		
		DefaultListModel<String> listModel2 = new DefaultListModel<>();
		Collection<RegistroTop10> registro= top.darRegistros();
		for(RegistroTop10 i: registro ) {
			
			listModel2.addElement(i.darNombre());
		}
		
		JList<String> list2 = new JList<>(listModel2);
		list2.setCellRenderer(new PersonalizarFontJList());
		
		DefaultListModel<String> listModel3 = new DefaultListModel<>();
		for(RegistroTop10 i: registro ) {
			
			listModel3.addElement(i.darPuntos()+" pts");
		}
		
		JList<String> list3 = new JList<>(listModel3);
		list3.setCellRenderer(new PersonalizarFontJList());
        
        
        
		dialog.setModal(true);
		panelCentro.add(list1);
		panelCentro.add(list2);
		panelCentro.add(list3);
		dialog.add(panelCentro);
        //dialog.add(new JLabel("hhh"));
		JScrollPane scrollPane = new JScrollPane(panelCentro);
		dialog.add(scrollPane);
        // Configura el diálogo
        dialog.setTitle("Ventana emergente con JScrollPane");
        dialog.setSize(new Dimension(400, 200));
        dialog.setLocationRelativeTo(null); // Centra el diálogo en la pantalla
        
        // Muestra el diálogo
        dialog.setVisible(true);
	
        
    }
}



