package com.conversor.conversorDeMonedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorDeMonedas {
	
	public void convertirMoneda(String json, String monedaBase, String monedaDestino, double cantidad ) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
		
		double tasa = jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
		
		double resultado = cantidad * tasa ; 
		
		System.out.println(cantidad + " " + monedaBase + " son " + resultado + "" + monedaDestino );
	}

}
