package logica;

public class Bebida implements Producto
{
	//Atributos
		private String nombre;
		private int Precio;
		private int calorias;
		
		//Método Constructor
		public Bebida(String nombre, int costo, int calorias) 
		{
			this.nombre = nombre;
			this.Precio = costo;
			this.calorias=calorias;
		}
		
		//Métodos
		public String getNombre() {
			return nombre;
		}
		
		public int getPrecio() {
			return Precio;
		}
		public int getCalorias() {
			return calorias;
		}
		
			

}
