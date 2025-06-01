package com.conversor.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.conversor.HistorialConversion.HistorialConversion;
import com.conversor.conversorDeMonedas.ConversorDeMonedas;
import com.conversor.servicio.ClienteHttp;

public class Principal {
	private static final Map<Integer, String> MONEDAS = new HashMap<>();

	static {
		MONEDAS.put(1, "USD");
		MONEDAS.put(2, "COP");
		MONEDAS.put(3, "EUR");
		MONEDAS.put(4, "GBP");
		MONEDAS.put(5, "JPY");
		MONEDAS.put(6, "KRW");
		MONEDAS.put(7, "BRL");
		MONEDAS.put(8, "MXN");
		MONEDAS.put(9, "CAD");
		MONEDAS.put(10, "CNY");
	}

	public static void main(String[] args) {

		List<HistorialConversion> historial = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("👋 ¡Bienvenido/a al conversor de monedas!");
		System.out.println("Aquí podrás convertir tu dinero a otra moneda de forma precisa y sencilla.\n");

		while (continuar) {
			mostrarOpciones();

			System.out.print("\n👉 Indica el número de la MONEDA BASE: ");
			int opcionBase = scanner.nextInt();
			String monedaBase = MONEDAS.get(opcionBase);

			String monedaDestino;
			int opcionDestino;

			while (true) {
				System.out.print("👉 Indica el número de la MONEDA DESTINO: ");
				opcionDestino = scanner.nextInt();
				monedaDestino = MONEDAS.get(opcionDestino);

				if (!monedaBase.equals(monedaDestino)) {
					break;
				}
				System.out.println("⚠️ La moneda destino debe ser diferente de la moneda base. Intenta de nuevo.");
			}

			System.out.print("💰 Ingresa la cantidad a convertir: ");
			double cantidad = scanner.nextDouble();

			
			ClienteHttp cliente = new ClienteHttp();
			String json = cliente.obtenerDatosConversion(monedaBase);

			ConversorDeMonedas conversor = new ConversorDeMonedas();
			double resultado = conversor.convertirMoneda(json, monedaBase, monedaDestino, cantidad);
			
			HistorialConversion registro = new HistorialConversion(monedaBase, monedaDestino, cantidad, resultado);
			historial.add(registro);

			System.out.print("\n🔁 ¿Deseas hacer otra conversión? (s/n): ");
			String respuesta = scanner.next();
			if (!respuesta.equalsIgnoreCase("s")) {
				continuar = false;
			}
		}

		System.out.println("👋 ¡Gracias por usar el conversor! Hasta la próxima.");
		scanner.close();
	}

	private static void mostrarOpciones() {
		System.out.println("Monedas disponibles:");
		for (Map.Entry<Integer, String> entry : MONEDAS.entrySet()) {
			System.out.println(entry.getKey() + ". " + entry.getValue());
		}
	}

}
