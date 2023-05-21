package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.PrecioProductoException;
import logica.Pedido;
import logica.Producto;
import logica.ProductoMenu;

class PedidoTest {
	Pedido pedido1;
	Pedido pedido2;
	Pedido pedido3;
	ProductoMenu producto1;
    ProductoMenu producto2;
    

	@BeforeEach
	public void setUp() throws PrecioProductoException{
		 pedido1 = new Pedido("BadBunny", "uwu1", 1);
         pedido2 = new Pedido("Mora", "uwu2", 2);
         pedido3 = new Pedido("BadBunny", "uwu1", 1);
          producto1 = new ProductoMenu("Corralazo", 15000, 500);
          producto2 = new ProductoMenu("Papitas", 4000, 300);
          
          pedido1.agregarProducto(producto1);
          pedido1.agregarProducto(producto2);
          pedido3.agregarProducto(producto1);
          pedido3.agregarProducto(producto2);
		
	}
	@Test
    public void equalsTest() {
        
        Assertions.assertFalse(pedido1.equals(pedido2));
        Assertions.assertTrue(pedido1.equals(pedido3));
    }
	@Test
    public void getIdPedidoTest() {
        
        int idPedido = pedido2.getIdPedido();

        Assertions.assertEquals(2, idPedido);
    }
	@Test
    public void getNumeroPedidosTest() {
        // Arrange
        int numeroPedidosAntes = Pedido.getNumeroPedidos();
        Pedido pedidoN = new Pedido("Uva", "uwu", 11);

        // Act
        int numeroPedidosDespues = Pedido.getNumeroPedidos();

        // Assert
        Assertions.assertEquals(numeroPedidosAntes + 1, numeroPedidosDespues);
    }
	 @Test
	    public void getItemsTest() {
	        
	        ArrayList<Producto> items = pedido1.getItems();
	 
	        Assertions.assertEquals(2, items.size());
	        Assertions.assertEquals(producto1, items.get(0));
	        Assertions.assertEquals(producto2, items.get(1));
	    }
	@Test
    public void agregarProductoTest()  {
       
        ArrayList<Producto> items = pedido1.getItems();


        Assertions.assertEquals(2, items.size());
        Assertions.assertEquals(producto1, items.get(0));
        Assertions.assertEquals(producto2, items.get(1));
    }
	@Test
    public void agregarProductoPrecioExceptionTest() {
       
        ProductoMenu producto1 = new ProductoMenu("OroHamburguesa", 150000, 500);

        Assertions.assertThrows(PrecioProductoException.class, () -> {
            pedido1.agregarProducto(producto1);
        });
    }
	@Test
    public void getCaloriasTotalesTest() throws PrecioProductoException {
		
        pedido2.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);

        
        int caloriasTotales = pedido2.getCaloriasTotales();

       
        Assertions.assertEquals(800, caloriasTotales);
    }
	@Test
    public void getPrecioNetoPedidoTest() {
        
        int precioNetoPedido = pedido1.getPrecioNetoPedido();
        Assertions.assertEquals(19000, precioNetoPedido);
    }
	@Test
    public void getPrecioTotalPedidoTest() {
        
        int precioTotalPedido = pedido1.getPrecioTotalPedido();

        // Assert
        Assertions.assertEquals(22610, precioTotalPedido);
    }
	@Test
    public void getPrecioIVAPedidoTest() {
        
        int precioIVAPedido = pedido1.getPrecioIVAPedido();

        // Assert
        Assertions.assertEquals(3610, precioIVAPedido);
    }
	@Test
	public void generarTextoFacturaTest() {
        
        Assertions.assertDoesNotThrow(() -> {
            pedido3.generarTextoFactura();
            File archivo = new File("1.txt");
            Assertions.assertTrue(archivo.exists());
        });
    }
	

}
