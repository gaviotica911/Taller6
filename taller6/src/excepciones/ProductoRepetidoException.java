package excepciones;

import java.util.Map;

import logica.ProductoMenu;

public class ProductoRepetidoException extends HamburguesaException {
	private String nombreProducto;

	public ProductoRepetidoException(String nombre) {
		this.nombreProducto = nombre;
	}

	@Override
	public String getMessage() {
		return "El producto " + nombreProducto + " esta repetido";
	}

	public String getNombreProducto() {
		return nombreProducto;
	}
//
//	private ProductoMenu productoRep;
//
//	public ProductoRepetidoException productoRepetido(ProductoMenu productoNuevo,
//			Map<String, ProductoMenu> productosMenu) throws Exception {
//		String nombre = productoNuevo.getNombre();
//		ProductoMenu elProduto = productosMenu.get(nombre);
//		this.productoRep = elProduto;
//
//		throw new Exception("El producto" + nombre + " a ingresar ya esta en el Menu");
//
//	}

}
