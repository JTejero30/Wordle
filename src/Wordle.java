import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {
		//WORDLE HECHO POR MIGUEL Y JAVIER.
		//VERDE:SITIO CORRECTO AMARILLO: SE ENCUENTRA EN LA PALABRA ROJO:NO ESTÁ

		String palabraSecreta;
		String respuesta = "";
		char letraSecreta;
		char letraRespuesta;
		String verde = "\033[32m";
		String amarillo = "\033[33m";
		String rojo = "\033[31m";
		String blanco = "\033[37m";
		int intentos = 0;
		int aciertos = 0;
		boolean respuestaValida = false;

		Scanner lector = new Scanner(System.in);

		palabraSecreta = BancoPalabras();
		palabraSecreta = palabraSecreta.toUpperCase();

		do {
			do {
				System.out.println("Introduzca una palabra de 5 letras");
				respuesta = lector.nextLine();
				respuesta = respuesta.toUpperCase();

				if (respuesta.length() != 5) {
					System.out.println("La palabra ha de tener 5 letras");

				} else if (ContieneNumero(respuesta)) {
					System.out.println("No introduzcas numeros");
				} else {
					respuestaValida = true;
					intentos++;
				}
			} while (!respuestaValida);

			for (int i = 0; i < 5; i++) {

				letraSecreta = palabraSecreta.charAt(i);
				letraRespuesta = respuesta.charAt(i);
				if (letraSecreta == letraRespuesta) {
					System.out.print(verde + letraRespuesta);
					aciertos++;
				} else {
					if (palabraSecreta.indexOf(letraRespuesta) != -1) {
						System.out.print(amarillo + letraRespuesta);
						aciertos = 0;
					} else {
						System.out.print(rojo + letraRespuesta);
						aciertos = 0;
					}
				}
			}
			System.out.println(blanco + "");
		} while (intentos < 6 && aciertos < 5);
		;

		if (aciertos == 5) {
			System.out.println("Correcto");
		} else {
			System.out.println("Se acabo, la palabra era " + palabraSecreta);
		}
		lector.close();
	}

	public static boolean ContieneNumero(String cadena) {
		boolean verificador = false;
		String numeros = "1234567890";
		int posicion = 0;
		do {
			if (cadena.indexOf(numeros.charAt(posicion)) > 0) {
				verificador = true;
			}
			posicion++;
		} while (!verificador && posicion < numeros.length());

		return verificador;
	}
	
//	public static void meterPalabras(String cadena) {
//		String palabra;
//		int tamaño =cadena.length();
//		for (int i = 0; i <tamaño ; i+=5) {
//			palabra=cadena.substring(i,i+5);
//		}
//	}

	public static String BancoPalabras() {

		String resultado;

		ArrayList<String> banco = new ArrayList<String>();

		banco.add("botin");
		banco.add("jarra");
		banco.add("perla");
		banco.add("boton");
		banco.add("balon");
		banco.add("kebab");
		banco.add("talar");
		banco.add("poker");
		banco.add("salon");
		banco.add("norte");
		banco.add("remar");

		resultado = banco.get((int) (Math.random() * banco.size()));

		return resultado;
		
	}
	
}