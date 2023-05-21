package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import excepciones.IngredienteRepetidoException;
import excepciones.PrecioProductoException;

public class Pedido {
	//Atributos
	private static int numeroPedidos;
	private int idPedido; 
	private String nombreClientes;
	private String direccionCliente;
	private ArrayList<Producto> productosPedido= new ArrayList<Producto>();
	private float sumadeprecios=0;
	
	//Contructorl
	public Pedido(String nombreClientes, String direccionCliente, int idPedido) {
		
		this.nombreClientes = nombreClientes;
		this.direccionCliente = direccionCliente;
		this.idPedido=idPedido;
		numeroPedidos++;
	}
	//M�todos
	 public boolean equals(Pedido elPedido) {
		 boolean rta=true;
		 ArrayList<Producto> x=this.getItems();
		 if(x.equals(elPedido.getItems()))
			 rta=true;
		 else {
			 rta=false;
		 }
			
			 
	        return rta;
	    }
	 public ArrayList<Producto>  getItems()
		{
			return productosPedido;
			
		}
	 
	public int  getIdPedido()
	{
		return idPedido;
		
	}
	public static int getNumeroPedidos() {
		return numeroPedidos;
	}
	public int getCaloriasTotales()
	{
		int caloriast=0;
		for(Producto i: productosPedido) {
			caloriast+=i.getCalorias();
		}
		return caloriast;		
	}
	public void agregarProducto(Producto nuevoItem) throws PrecioProductoException 
	{
		sumadeprecios+=nuevoItem.getPrecio();
		if (sumadeprecios>=150000)
		{
		
			PrecioProductoException ex = new PrecioProductoException(sumadeprecios-nuevoItem.getPrecio());
			throw ex;
		}
		else {
			productosPedido.add(nuevoItem);
		}
		
	}
	public int getPrecioNetoPedido()
	{
		int precio=0;
		for(Producto i: productosPedido) {
			precio+=i.getPrecio();
		}
		return precio;		
	}
	public int getPrecioTotalPedido()
	{
		int precio=getPrecioNetoPedido();
		
		int iva=getPrecioIVAPedido();	
		
		int pp= iva+precio;
		
				
		
		
		return pp;
		
		
	}
	public int getPrecioIVAPedido()
	{
		int precio=getPrecioNetoPedido();
		
		int iva=(int)(precio*0.19);	
		
		
		return iva;
		
	}
	public void devolver()
	{
		System.out.println("Nombre: "+nombreClientes);
		System.out.println("Direcci�n: "+direccionCliente);
		System.out.println("Producto   ---   Precio");
		for(Producto i: productosPedido) {
		
			System.out.println(i.getNombre()+"   ---   " + i.getPrecio());
		}
		System.out.println("Calorias totales del Pedido: "+getCaloriasTotales());
		System.out.println("Precio neto: "+ getPrecioNetoPedido() );
		System.out.println("valor del IVA: "+ getPrecioIVAPedido());
		System.out.println("Valor total pedido: "+ getPrecioTotalPedido());
	}
	public void generarTextoFactura()
	{
		
		File archivo =new File (Integer.toString(idPedido)+".txt");
		PrintWriter pw = null;

		try {
			pw= new PrintWriter(archivo);
			//escribir
			pw.println("Nombre: "+nombreClientes);
			pw.println("Direcci�n: "+direccionCliente);
			pw.println("Id Pedido: "+ idPedido);
			pw.println("Producto   ---   Precio");
			for(Producto i: productosPedido) {
			
			pw.println(i.getNombre()+"   ---   " + i.getPrecio());
			}
			pw.println("Calorias totales del Pedido: "+getCaloriasTotales());
			pw.println("Precio neto: "+ getPrecioNetoPedido() );
			pw.println("valor del IVA: "+ getPrecioIVAPedido());
			pw.println("Valor total pedido: "+ getPrecioTotalPedido());
			
		
		}catch(FileNotFoundException ex ) {
			ex.printStackTrace();
			
		}finally {
			if(pw !=null) {
				pw.close();
			}
		}
		
	}
	
}
