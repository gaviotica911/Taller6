package logica;

public class Ingredientes 
{
	//Atributos
	private String nombre;
	private int costoAdicional;
	private int calorias;
	
	//M�todo Constructor
	public Ingredientes(String nombre, int costoAdicional, int calorias) 
	{
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
		this.calorias=calorias;
	}
	
	//M�todos
	public String getNombre() {
		return nombre;
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
	}
	public int getCalorias() {
		return calorias;
	}
	
		

}
