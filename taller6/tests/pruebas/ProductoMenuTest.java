package pruebas;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logica.ProductoMenu;
import logica.Restaurante;

public class ProductoMenuTest {
	Restaurante restaurante;

	/*
	Construya una clase llamada ProductoMenuTest donde implemente pruebas 
	para la clase ProductoMenú.
	Asegúrese de que sus pruebas cubran el 100% de la clase, sin contar 
	los métodos getNombre y getPrecio.
	 */
	ProductoMenu producto;

	@Test
	public void constructorTest() {
		// Arrange
		String nombre = "Papitas";
		int precioBase = 4000;
		int calorias = 100;


		ProductoMenu productotest = new ProductoMenu(nombre, precioBase, calorias);

		Assertions.assertEquals(nombre, productotest.getNombre());
		Assertions.assertEquals(precioBase, productotest.getPrecio());
		Assertions.assertEquals(calorias, productotest.getCalorias());
	}
	@BeforeEach
	public void setup()
	{
		producto = new ProductoMenu("Papitas", 4000, 100);

	}

	@Test
	public void getCaloriasTest() {


		int calorias = producto.getCalorias();

		// Assert

		Assertions.assertEquals(100, calorias);
	}



}
