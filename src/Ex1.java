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

public class Ex1 {
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		byte op=1;
		int dim=Ex1.pedirvalor(op, null);
		int[]array=Ex1.crear_rellenar(dim);
		Ex1.imprimir(array);
		op=2;
		int val=Ex1.pedirvalor(op, array);//demanar nou valor
		op=3;
		int pos=Ex1.pedirvalor(op,array);//demanr pos on anira el nou valor
		array=Ex1.modificar(array, val, pos);//modificar posar nou valor en la pos indicada
		Ex1.imprimir(array);
		Ex1.get_MaxMin(array);
		Ex1.get_media(array);
		
	}
	public static int pedirvalor(byte op, int[]array) throws NumberFormatException, IOException{
		/*
		 * Aquest metode el que fa es demanar valors al usuari.
		 * Depenent del valor de op demanara una cosa o una altre.
		 * Tambe rep el array per quan el usuari ha d'indicar una pos d'aquest array no es pasi de rang
		 */
		int valor=0;
		boolean correcto=true;
		switch (op){
		case 1:
			do{
				try{
				System.out.print("Dimension del array => ");
				valor=Integer.parseInt(stdin.readLine());
				correcto=true;
				}catch(Exception e){
					System.out.println("Dimension del array incorrecta.");
				}
			}while(valor<=0);
			break;
		case 2:
			correcto=true;
			do{
			try{
			System.out.print("Introduce un valor => ");
			valor=Integer.parseInt(stdin.readLine());
			correcto=true;
			}catch(Exception e){
				System.out.println("El valor debe ser numerico.");
				correcto=false;
			}
			}while(correcto==false);
			break;
		case 3:
			correcto=true;
			do{
			try{
			System.out.print("Introduce una posicion del array para meter el valor => ");
			valor=Integer.parseInt(stdin.readLine())-1;
			correcto=true;
			}catch(Exception e){
				System.out.println("La posicion del array es incorrecta");
				correcto=false;
			}
			}while(valor<0 || valor>=array.length || correcto==false);
			break;
		}
		return valor;
	}
	public static int[] crear_rellenar(int dim) throws NumberFormatException, IOException{
		/*
		 * Aquest metode el que fa es rebre la longitud que volem el array.
		 * Crear un array amb aquesta longitud.
		 * Recorre cada "casella" del array i omplirla amb un numero aleatori del 0 al 100
		 * retorna el array omplert.
		 */
	int [] array=new int[dim];
	for(int i=0; i<dim; i++){
		array[i]=(int)(Math.random()*101);//PQ 101? pq queremos valores del 0 al 100
	}
	return array;
	}
	public static int[] modificar(int[] array, int val, int pos){
		/*
		 * Aquest metode el que fa es rebre un array, un valor i una posició.
		 * Fica en la pos del array el valor.
		 * retorna el array modificat.
		 */
		array[pos]=val;
		return array;
	}
	public static void imprimir(int[] array){
		/*
		 * Aquest metode el que da es rebre un array.
		 * Amb l'ajuda d'un bucle recorre totes les "caselles" del array i les mostre per pantalla
		 */
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
	public static void get_MaxMin(int[] array){
		/*
		 * Aquest metode el que fa es rebre un array.
		 * Donem valors arbitraris a dos variables per aconseguir trobar el valor maxim i minim del array
		 * no retornara res imprimira el maxim i el minim per pantalla
		 */
		int min=100, max=0;
		for(int i=0; i<array.length; i++){
			if(array[i]<min){min=array[i];}
			else if(array[i]>max){max=array[i];}
		}
		System.out.println("Valor más grande => "+max);
		System.out.println("Valor más pequeño => "+min);
	}
	public static void get_media(int[] array){
		/*
		 * Aquest metode el que fa es rebre un array.
		 * Sumar tots els valors del array i dividils per la longitud d'aquest "Mitja"
		 * Un cop tenim la mitja
		 * recorre el array buscant els valors que son mes grans d'aquesta mitja i els imprimeix per pantalla.
		 */
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
