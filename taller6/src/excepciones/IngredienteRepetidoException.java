package excepciones;

public class IngredienteRepetidoException extends HamburguesaException {
	private String nombreProducto;

	public IngredienteRepetidoException(String nombre) {
		this.nombreProducto = nombre;
	}

	@Override
	public String getMessage() {
		return "El ingrediente " + nombreProducto + " esta repetido";
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

}
