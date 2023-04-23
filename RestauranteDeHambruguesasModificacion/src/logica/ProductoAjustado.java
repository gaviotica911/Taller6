package logica;
import java.util.ArrayList;

public class ProductoAjustado implements Producto
{
	public Producto base;
	public ArrayList<Ingredientes> eliminados=new ArrayList<Ingredientes>();
	public ArrayList<Ingredientes> agregados= new ArrayList<Ingredientes>();
	//Contructor
	public ProductoAjustado(Producto base, ArrayList<Ingredientes> eliminados, ArrayList<Ingredientes> agregados) {
	
		this.base = base;
		if (eliminados!= null) {
		this.eliminados.addAll(eliminados);
		}
		if(agregados!= null) {
		this.agregados.addAll(agregados);
		}
		
	}
	
	//Métodos
	public int getCalorias() {
		int caloriast=base.getCalorias();
		if(eliminados!=null) {
			for(Ingredientes i: eliminados) {
				caloriast-=i.getCalorias();	
			}
		}
		if(agregados!=null) {
			for(Ingredientes i: agregados) {
				caloriast+=i.getCalorias();	
			}
		}
		return caloriast;
	}
	public String getNombre()
	{
		String nombre=base.getNombre();
		
		if(agregados.size() !=0) {
			nombre=nombre+" con adición de ";
			for(Ingredientes i: agregados) {
				nombre=nombre+i.getNombre()+" ";
			}
			
		}
		if(eliminados.size()!=0) {
			nombre=nombre+" Sin ";
			for(Ingredientes i: eliminados) {
				nombre=nombre+i.getNombre()+" ";
			}
			
		}
	return nombre;	
	}

	
	public int getPrecio()
	{
		int precioagregado=0;
		int preciobase=base.getPrecio();
		if (agregados!=null) {
			for(Ingredientes i: agregados) {
			precioagregado+=i.getCostoAdicional();
			}
		}
		int pfinal=precioagregado+preciobase;
		
		
		return pfinal ;
	}
	

}
