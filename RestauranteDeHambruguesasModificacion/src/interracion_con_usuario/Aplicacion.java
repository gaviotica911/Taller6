package interracion_con_usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import logica.Combo;
import logica.Ingredientes;
import logica.Restaurante;


public class Aplicacion 

{
	Restaurante restauranteMenu= new Restaurante();
	
	public void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al Corral\n");

		boolean continuar = true;
		while (continuar)
		{
				mostrarMenu();
			
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					mostrarMenuRestaurante();
				else if (opcion_seleccionada == 2 )
					iniciarPedido();
				else if (opcion_seleccionada == 3 )
					consultarPedido();			
				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
		}
	}
	private void consultarPedido() {
		String idPedido= input("Ingrese el id del pedido que desea consultar:  ");
		restauranteMenu.consultarPedido(idPedido);
		
	}
	
	
	private void iniciarPedido() {
		
		double x;
		x=  Math.random()*10000;
		
		int idPedido=(int)x;
		
		//Tener en cuneta que para ordenar un pedido se usa la lsita ya creada y el indice del inpnut será +1
		String nombre= input("Ingrese su nombre: ");
		String direccion=input("Ingrese su dirección");
		restauranteMenu.iniciarPedido(nombre,direccion, idPedido);
		
	}
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar menu");
		System.out.println("2. Inicial nuevo pedido");
		System.out.println("3. Consultar la información de un pedido dado su id");
		System.out.println("4. Salir");
	}
	
	public void mostrarMenuRestaurante()
	{
		File archivoIngredientes = new File ("./data/ingredientes.txt");
		File archivoMenu = new File ("./data/menu.txt");
		File archivoCombos = new File ("./data/combos.txt");
		File archivoBebidas = new File ("./data/bebidas.txt");
		
		try
		{
			System.out.println("Nuetro menu tiene 4 secciones:\n \n");

			restauranteMenu.cargarInformacionRestaurante(archivoBebidas,archivoIngredientes, archivoMenu, archivoCombos);
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public static void main(String[]args) 
	{
		
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	
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
