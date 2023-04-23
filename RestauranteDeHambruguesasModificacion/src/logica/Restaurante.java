package logica;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Restaurante
{
	
	private Map<String, Combo> combos = new HashMap<>();
	private Map<String, Ingredientes> ingredientes = new HashMap<>();
	private Map<String, ProductoMenu> productosMenu = new HashMap<>();
	private Map<String, Bebida> bebidas = new HashMap<>();
	private Map<String, Pedido> pedidos= new HashMap<>();
	private int pedidosEnCurso=0;
	
	//Contructor:
	public Restaurante()
	{
	
	}
	//getters
	public ArrayList<Pedido> getPedidos() 
	{
		ArrayList<Pedido> values= pedidos.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return values;
	}
	public ArrayList<Combo> getCombos() 
	{
		ArrayList<Combo> values= combos.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return values;
	}
	
	public ArrayList<ProductoMenu> getMenuBase()	
	{
		ArrayList<ProductoMenu> values= productosMenu.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return values;
	}
	public ArrayList<Ingredientes> getIngredientes()
	{
		ArrayList<Ingredientes> values= ingredientes.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return values;
	}
	public ArrayList<Bebida> getBebidas()
	{
		ArrayList<Bebida> values= bebidas.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return values;
	}
	
	
	

	
	//Métodos:
	
	
	public void consultarPedido( String idPedido) 
	{
		Pedido elPedido=null;
		for (String clave:pedidos.keySet()) {
			if(clave.equals(clave)) {
		    elPedido = pedidos.get(clave);
			} 
		}
	System.out.println("El pedido con el id "+ String.valueOf(elPedido.getIdPedido())+ ":");
	elPedido.devolver();
	}
	public void iniciarPedido(String nombreCliente,String direccionCliente,int idPedido)
	{	
		
		pedidosEnCurso=1;
		Pedido elPedido= new Pedido(nombreCliente, direccionCliente, idPedido);
		
		while(pedidosEnCurso==1) {
			System.out.println("¿Que deseas ordenar");
			System.out.println("1. Combos");
			System.out.println("2. Productos");
			System.out.println("3. Bebidas");
			int dato=Integer.parseInt(input(" "));
			switch (dato) 
			{
				case 1: int combo=Integer.parseInt(input("Ingrese el numero del combo que desea ordenar: "));
						ArrayList<Combo> combos=getCombos();
						Combo x=combos.get(combo-1);
						elPedido.agregarProducto(x);
						break;
				case 2: int producto=Integer.parseInt(input("Ingrese el numero del producto que desea ordenar: "));
						ArrayList<ProductoMenu>  productos=getMenuBase();
						int modificar=Integer.parseInt(input("Desea modificar el producto. Ingrese 1 para si y 0 para no"));
						if(modificar==0) {
							Producto y=productos.get(producto-1);
							elPedido.agregarProducto(y);	
						}
						if(modificar==1) 
						{
							ArrayList<Ingredientes> eliminados=new ArrayList<Ingredientes>() ;
							ArrayList<Ingredientes> agregados= new ArrayList<Ingredientes>();
							Producto y=productos.get(producto-1);
							while(modificar==1) {			
								int ajuste=Integer.parseInt(input("Desea agregar(1) o eliminar(0) ingredientes de su producto"));
								
								if(ajuste==1)
								{
									int agr=Integer.parseInt(input("Ingrese el ingrediente para adicionar: "));
									Ingredientes agre=(getIngredientes().get(agr-1));
									agregados.add(agre);
								}
								else if( ajuste==0) 
								{
									int elim=Integer.parseInt(input("Ingrese el ingrediente para eliminar: "));
									Ingredientes eliminado=(getIngredientes().get(elim-1));
									eliminados.add(eliminado);
									
								}
								else 
								{
									System.out.println("Ingrese una opción valida");
								}
								modificar=Integer.parseInt(input("Desea seguir modificando el producto. Ingrese 1 para si y 0 para no: "));
								}
						
						ProductoAjustado yAjustado= new ProductoAjustado(y,  eliminados,  agregados);	
						elPedido.agregarProducto(yAjustado);
						}
						break;
				case 3: int bebida=Integer.parseInt(input("Ingrese el numero de bebida que desea ordenar: "));
						ArrayList<Bebida> bebidas =getBebidas();
						Bebida b=bebidas.get(bebida-1);
						elPedido.agregarProducto(b);
						break;
		
				default: System.out.println("Ingrese una opción valida");
			}
			pedidosEnCurso=Integer.parseInt(input("¿Desea ordenar algo más? SI(1) NO(0). Si elige no, se cerrará el pedido: "));
		}
		for (Pedido i: getPedidos()) {
			if (i.equals(elPedido)) {
				System.out.println("Este pedido es igual a uno ya ordenado.");
			}
		}
		pedidos.put(String.valueOf(idPedido), elPedido);
		cerrarYGuardarPedidoEnCurso(elPedido);
		
		}
	public void cerrarYGuardarPedidoEnCurso(Pedido elPedido)
	{
		elPedido.generarTextoFactura();
	}
	
	public void cargarInformacionRestaurante(File archivoBebidas, File archivoIngredientes, File archivoMenu, File archivoCombos)throws IOException
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarBebidas(archivoBebidas);
		cargarCombos(archivoCombos);
		
		
		List<Ingredientes> ingredientesLista =ingredientes.values().stream().collect(Collectors.toList());
		List<ProductoMenu> productosMenuLista =productosMenu.values().stream().collect(Collectors.toList());
		List<Combo> combosLista =combos.values().stream().collect(Collectors.toList());
		List<Bebida> bebidasLista =bebidas.values().stream().collect(Collectors.toList());
		int contp=1;
		int contc=1;
		int conti=1;
		int contadorBebdias=1;
		
		
		System.out.println("Productos: \n");
		for(ProductoMenu i : productosMenuLista) 
		{
			
            System.out.println(contp+ ". "+i.getNombre() + ". Precio: " + i.getPrecio());
            contp++;
        }
		System.out.println("\nCombos: \n");
		for(Combo i : combosLista) 
		{
            System.out.println(contc+ ". "+i.getNombre() + ". Precio: " + i.getPrecio());
            contc++;
		}
		System.out.println("\nIngredientes adicionales: \n");
		for(Ingredientes i : ingredientesLista) 
		{
			System.out.println(conti+ ". "+i.getNombre() + ". Precio: " + i.getCostoAdicional() );
			conti++;
		}
		System.out.println("\nBebidas: \n");
		for(Bebida i : bebidasLista) {
			System.out.println(contadorBebdias+ ". "+i.getNombre() + ". Precio: " + i.getPrecio() );
			contadorBebdias++;
			
		}
		
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException
	{
		
		FileReader archivo= new FileReader(archivoIngredientes);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int precioIngredinete=Integer.parseInt(partes[1]);
			int calorias=Integer.parseInt(partes[2]);
			Ingredientes elIngrediente=ingredientes.get(nombreIngrediente);
			if (elIngrediente == null)
			{
				elIngrediente= new Ingredientes (nombreIngrediente,precioIngredinete, calorias);
				ingredientes.put(nombreIngrediente,elIngrediente);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
	}
	private void cargarBebidas(File archivoBebidas) throws IOException
	{
		
		FileReader archivo= new FileReader(archivoBebidas);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(";");
			String nombreBeb = partes[0];
			int precioBeb=Integer.parseInt(partes[1]);
			int calorias=Integer.parseInt(partes[2]);
			Bebida laBebida=bebidas.get(nombreBeb);
			
			if (laBebida == null)
			{
				laBebida= new Bebida (nombreBeb,precioBeb,calorias);
				
				bebidas.put(nombreBeb,laBebida);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
	}
	private void cargarMenu(File archivoMenu)throws IOException
	{
		FileReader archivo= new FileReader(archivoMenu);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			
			int precioProducto=Integer.parseInt(partes[1]);
			int calorias=Integer.parseInt(partes[2]);
			ProductoMenu elProducto=productosMenu.get(nombreProducto);
			if (elProducto == null)
			{
				elProducto= new ProductoMenu (nombreProducto,precioProducto, calorias);
			
				productosMenu.put(nombreProducto,elProducto);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
	}
	
	private void cargarCombos(File archivoCombos)throws IOException
	{
		
		FileReader archivo= new FileReader(archivoCombos);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String desc=partes[1];
			String x=desc.replace("%","");
			double descuento =Double.parseDouble(x) ;
			ProductoMenu productoCombo1=productosMenu.get(partes[2]);
			ProductoMenu productoCombo2=productosMenu.get(partes[3]);
			Bebida productoCombo3=bebidas.get(partes[4]);
					
			Combo elCombo=combos.get(nombreCombo);
			if (elCombo == null)
			{
				elCombo= new Combo (descuento, nombreCombo);
				elCombo.agregarItemACombo(productoCombo1);
				
			
				elCombo.agregarItemACombo(productoCombo2);
				
				elCombo.agregarItemACombo(productoCombo3);
				
				combos.put(nombreCombo,elCombo);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
		
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	

}
