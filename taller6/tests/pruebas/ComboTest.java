package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logica.Combo;
import logica.Producto;
import logica.ProductoMenu;

class ComboTest {
	Combo combo ;
	ProductoMenu producto;


	@BeforeEach
	public void setUp(){
		combo = new Combo(15.0, "Cajita Feliz");
		producto = new ProductoMenu("AlpiLitro", 5000, 500);
		combo.agregarItemACombo(producto);
	}

	@Test
	public void getDescuentoTest() {

		double descuento = combo.getDescuento();

		// Assert
		Assertions.assertEquals(15.0, descuento);
	}
	@Test
	public void agregarItemAComboTest() {

		
		ArrayList<Producto> itemsCombo = combo.getItemsCombo();


		Assertions.assertEquals(1, itemsCombo.size());
		Assertions.assertEquals(producto, itemsCombo.get(0));
	}
	@Test
	public void getCaloriasTest() {

		int caloriasCombo = combo.getCalorias();

		// Assert
		Assertions.assertEquals(500, caloriasCombo);
	}

}
