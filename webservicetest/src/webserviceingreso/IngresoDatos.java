package webserviceingreso;

import java.util.Scanner;

public class IngresoDatos {
	private static Scanner scanner;

	public String datoUsuario(String datos) {
		scanner = new Scanner(System.in);

		System.out.println("Ingresa el dato a webservicear: ");
		String dato = scanner.nextLine();

		System.out.println("Tu dato es: " + dato);
		return dato;
	}
}
