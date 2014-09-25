import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * /*
 * Escribe una aplicación modular en Java que solicite por consola al usuario el número
 * de elementos que tendrá un array unidimensional de enteros. El contenido del array será
 * calculando aleatoriamente por el programa siendo posibles valores enteros de 0 a 100.
 * 
 * A continuación el programa deberá ejecutar las siguientes acciones:
 * 
 *      a) Solicitar al usuario una posición y un valor. Insertar en el vector en la posición
 *          dada el valor dado. Mostrar por consola el contenido del Array.
 * 
 *      b) Calcular y mostrar el valor más alto y el valor más bajo de Array.
 * 
 *      c) Calcular la media de todos los valores y mostrar los valores del Array que se 
 *          encuentran por encima de esta media.
 *          
 *          Antes de comenzar a programar, define el pseudocode o flowchart de la aplicación. 
 *          Requisitos no funcionales de la aplicación:
				 El programa sólo puede contener una Clase.
				 El programa debe ser modular
				 Cada módulo del programa debe disponer de una breve descripción funcional del mismo
				 El programa debe respetar The Clean Coding Practices
				   
				   Fer
				   	Demanr una dimensió
				   Mentres dimensió sigui <=0
				   Recorre totes les pos de array
				   	Omplir el array aleatoriament (0-100)
				   Fer
				   	Demanar una pos i un nou valor (-1)
				   Mentres pos>dimensió array o pos<=0
				   Recorre totes les pos del array	
				   	Si pos=pos
				   	Cambiar la pos del array per el valor
				   Fi recorre
				   Recorre totes les pos del array
				   	si val pos < min min=valor_pos
				   	sino si val_pos>max max=val_pos
				   Fi recorre
				   Recorre totes les pos del array
				    suma=suma+val_pos
				   Fi recorre
				   Imprimir pantalla suma/dim_array

 */

public class Principal {
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		byte op=1;
		int dim=Principal.pedirvalor(op, null);
		int[]array=Principal.crear_rellenar(dim);
		Principal.imprimir(array);
		op=2;
		int val=Principal.pedirvalor(op, array);//demanar nou valor
		op=3;
		int pos=Principal.pedirvalor(op,array);//demanr pos on anira el nou valor
		array=Principal.modificar(array, val, pos);//modificar
		Principal.imprimir(array);
		Principal.get_MaxMin(array);
		Principal.get_media(array);
		
	}
	public static int pedirvalor(byte op, int[]array) throws NumberFormatException, IOException{
		int valor=0;
		switch (op){
		case 1:
			do{
				System.out.print("Dimension del array => ");
				valor=Integer.parseInt(stdin.readLine());
			}while(valor<=0);
			break;
		case 2:
			System.out.print("Introduce un valor => ");
			valor=Integer.parseInt(stdin.readLine());
			break;
		case 3:
			do{
			System.out.print("Introduce una posicion del array para meter el valor => ");
			valor=Integer.parseInt(stdin.readLine())-1;
			}while(valor<0 || valor>=array.length);
			break;
		}
		return valor;
	}
	public static int[] crear_rellenar(int dim) throws NumberFormatException, IOException{
	int [] array=new int[dim];
	for(int i=0; i<dim; i++){
		array[i]=(int)(Math.random()*101);
	}
	return array;
	}
	public static int[] modificar(int[] array, int val, int pos){
		array[pos]=val;
		return array;
	}
	public static void imprimir(int[] array){

		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
	public static void get_MaxMin(int[] array){
		int min=100, max=0;
		for(int i=0; i<array.length; i++){
			if(array[i]<min){min=array[i];}
			else if(array[i]>max){max=array[i];}
		}
		System.out.println("Valor más grande => "+max);
		System.out.println("Valor más pequeño => "+min);
	}
	public static void get_media(int[] array){
		int suma=0;
		for(int i=0; i<array.length; i++){
			suma=suma+array[i];
		}
		System.out.println("La media de los valores del array es => "+(suma/array.length));
		System.out.println("Los valores que se encuentran por encima de esta media son:");
		for(int i=0; i<array.length; i++){
			if(array[i]>(suma/array.length)){System.out.print(array[i]+"\t");}
		}
		System.out.println("");
	}
}
