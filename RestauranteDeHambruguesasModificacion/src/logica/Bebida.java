package logica;

public class Bebida implements Producto
{
	//Atributos
		private String nombre;
		private int Precio;
		private int calorias;
		
		//M�todo Constructor
		public Bebida(String nombre, int costo, int calorias) 
		{
			this.nombre = nombre;
			this.Precio = costo;
			this.calorias=calorias;
		}
		
		//M�todos
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
