package logica;

public class ProductoMenu implements Producto
{
	//Atributos
	private String nombre;
	private int precioBase;
	private int calorias;
	
	
	//Contructor
	public ProductoMenu(String nombre, int precioBase, int calorias) 
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.calorias=calorias;
	}
	//Método
	public int getCalorias() {
		return calorias;
		
	}
	public String getNombre() {
		return nombre;
	}


	public int getPrecio() {
		return precioBase;
		
	}
	public String generarTextoFactura()
	{
		return null;
		
	}
	

	
	

}
