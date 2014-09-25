import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex2 {
/*
 * EJERCICIO 02
	Descripción del problema:
	Con base en una encuesta realizada a N estudiantes (N<=50) en una Universidad donde se solicitó la siguiente información:
	 SEXO, TRABAJA.
	Dónde:
	 SEXO (1 - Masculino 2 – Femenino)
	 TRABAJA (1 - Si trabaja 2 - No trabaja)
	Escribe una aplicación en Java que permita leer y almacenar en un vector los datos solicitados, luego, calcular e imprimir:
	 Porcentaje de hombres en la Universidad
	 Porcentaje de mujeres en la Universidad
	 Porcentaje de hombres que trabajan
	 Porcentaje de mujeres que trabajan
	Antes de comenzar a programar, define el pseudocode o flowchart de la aplicación. Requisitos no funcionales de la aplicación:
	 El programa sólo puede contener una Clase.
	 El programa debe ser modular
	 Cada módulo del programa debe disponer de una breve descripción funcionalcdel mismo
	 El programa debe respetar The Clean Coding Practices

 */
	private static BufferedReader stdin=new BufferedReader (new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] array=Ex2.crear_array();
		Ex2.rellenar_array(array);
		byte op=0;
		do{
		op=Ex2.preguntar();
		byte sexo=0; // 0  => Hombres 1 => Mujeres
		switch (op){
		case 1: //% hombres
			sexo=0;
			Ex2.cal_Por_H_M(array, sexo);
			break;
		case 2://% mujeres
			sexo=1;
			Ex2.cal_Por_H_M(array, sexo);
			break;
		case 3: // % hombres que trabajan
			sexo=0;
			Ex2.cal_Por_H_M_Trabajadores(array, sexo);
			break;
		case 4: // % mujeres que trabajan
			sexo=1;
			Ex2.cal_Por_H_M_Trabajadores(array, sexo);
			break;
		case 5:
			System.out.println("BYE");
			break;
		}
		}while(op!=5);
	
	}
	private static int[][] crear_array(){
		int [][] array=new int[50][2];
		return array;
	}
	private static void rellenar_array(int [][] array){
		System.out.println("Sexo\tTrabajo");
		for(int i=0; i<array.length; i++){
			for(int j=0; j<2; j++){
				array[i][j]=(int)(Math.random()*2);
				System.out.print(array[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	private static void cal_Por_H_M(int [][] array, byte sexo){
		byte cont=0;
		for(int i=0; i<array.length; i++){
			if(array[i][0]==sexo){cont++;}
		}
		float valor=0;
		valor=((float)(cont)/array.length)*100;
		if(sexo==0)System.out.println("El pocentaje de Hombres en la universidad es => "+valor+"%");
		else System.out.println("El pocentaje de Mujeres en la universidad es => "+valor+"%");
	}
	private static void cal_Por_H_M_Trabajadores(int[][]array, byte sexo){
		byte cont=0;
		for(int i=0; i<array.length; i++){
			if(array[i][0]==sexo && array[i][1]==sexo){cont++;}
		}
		float valor;
		valor=((float)(cont)/array.length)*100;
		if(sexo==0)System.out.println("El pocentaje de Hombres en la universidad que trabajan es => "+valor+"%");
		else System.out.println("El pocentaje de Mujeres en la universidad que trabajan es => "+valor+"%");
	}
	private static byte preguntar() throws NumberFormatException, IOException{
		System.out.println("1. Calcular porcentaje de Hombre");
		System.out.println("2. Calcular porcentaje de Mujeres");
		System.out.println("3. Calcular porcentaje de Hombres que trabajan");
		System.out.println("4. Calcular porcentaje de Mujeres que trabajan");
		System.out.println("5. Salir");
		byte op=0;
		do{
		System.out.print("Que quieres calcular => ");
		op=Byte.parseByte(stdin.readLine());
		}while(op<1 || op>5);
		return op;
	}
	

}
