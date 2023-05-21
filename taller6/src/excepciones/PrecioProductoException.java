package excepciones;

public class PrecioProductoException extends Exception{
	private float sumaPedido;

	public PrecioProductoException(float sumaPedido) {
		this.sumaPedido = sumaPedido;
	}

	@Override
	public String getMessage() {
		return "Error: Tu pedido esta en "+sumaPedido+" y superará los 150.000$ si agregas este producto";
	}

	public float getNombreProducto() {
		return sumaPedido;
	}

}
