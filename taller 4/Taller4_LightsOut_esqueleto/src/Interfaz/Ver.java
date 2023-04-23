package Interfaz;

import com.formdev.flatlaf.FlatLightLaf;

public class Ver {
	public static void main(String[] args) {
		FlatLightLaf.install();
		VentanaLights vv= new VentanaLights();
		vv.setVisible(true);
	}

}
