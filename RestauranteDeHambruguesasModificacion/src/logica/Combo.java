package logica;

import java.util.ArrayList;

public class Combo implements Producto
{
	//Atributos
	private double descuento;
	private String nombre;
	private ArrayList<Producto> itemsCombo= new ArrayList<Producto> ();
	private int calorias;
	//Contructor
	public Combo(double descuento, String nombre) {
		
		this.descuento = descuento;
		this.nombre = nombre;
	}
	
	//Métodos
	
	public void agregarItemACombo(Producto itemCombo)
	{
		itemsCombo.add(itemCombo);
	}
	
	public double getDescuento() {
	
		return descuento;
	}

	public int getPrecio()
	{
		double precioTotal=0;
		double precioFinal=0;
		int x;
		
		for(Producto i: itemsCombo) 
		{
			int precio= i.getPrecio();
			precioTotal += precio;
		}
		double des=(descuento*precioTotal)/100;
		precioFinal= precioTotal-des;
		x=(int)precioFinal;
		
		return x;
		
	}
	public String generarTextoFactura()
	{
		return null;
		
	}
	public String getNombre()
	{
		return nombre;
		
	}
	public int getCalorias() {
		int caloriast=0;
		for(Producto i: itemsCombo)
		{
			caloriast+=i.getCalorias();
		}
		return caloriast;
	}
	
	
	

}
