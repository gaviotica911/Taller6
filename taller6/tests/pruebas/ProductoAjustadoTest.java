package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.HamburguesaException;
import logica.Ingredientes;
import logica.Producto;
import logica.ProductoAjustado;
import logica.ProductoMenu;
import logica.Restaurante;
import logica.Ingredientes;

class ProductoAjustadoTest {

	/*
	 *  Construya una clase llamada ProductoAjustadoTest donde implemente pruebas
	 *   para la clase
	ProductoAjustado. Asegúrese de que sus pruebas cubran el 100% de la clase, sin contar
	 el método
	getNombre. Fíjese que en este caso es muy importante probar el método getPrecio.
	 */
	Producto producto;
	@BeforeEach

	public void setup() 
	{
		Producto base = new ProductoMenu("Corralisima", 15000, 500);
		ArrayList<Ingredientes> eliminados = new ArrayList<>();
		eliminados.add(new Ingredientes("Tomate", 100,15));
		eliminados.add(new Ingredientes("Cebolla", 200,20));
		ArrayList<Ingredientes> agregados = new ArrayList<>();
		agregados.add(new Ingredientes("Piña", 900,65));
		agregados.add(new Ingredientes("Lechuga", 300,100));
		producto = new ProductoAjustado(base, eliminados, agregados);

	}
	@Test
	public void getCaloriasTest() {

		int calorias = producto.getCalorias();

		Assertions.assertEquals(630, calorias);
	}
	@Test
	public void getPrecioTest() {

		int precio = producto.getPrecio();

		// Assert
		Assertions.assertEquals(16200, precio);
	}
}
