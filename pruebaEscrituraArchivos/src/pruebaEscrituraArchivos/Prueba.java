package pruebaEscrituraArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;  


public class Prueba {

	public static void main(String[] args) {
		File archivo =new File ("probando2.txt");
		PrintWriter pw = null;
		String nombre="yo";
		int a =34;
		try {
			pw= new PrintWriter(archivo);
			//escribir
			pw.println("vamos chavales");
			pw.println(nombre);
			pw.println(a);
		}catch(FileNotFoundException ex ) {
			ex.printStackTrace();
			
		}finally {
			if(pw !=null) {
				pw.close();
			}
		}
		
		
		
		
				
		

	}

}
