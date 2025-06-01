package com.conversor.servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
	
	 private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
	    private static final String API_KEY = "e39981ce2f2849e98ea5ab54"; 
	    private static final String ENDPOINT = "/latest/";

	    public String obtenerDatosConversion(String monedaBase) {
	        String url = BASE_URL + API_KEY + ENDPOINT + monedaBase;

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .build();

	        try {
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            return response.body();
	        } catch (IOException | InterruptedException e) {
	            System.out.println("Error al hacer la solicitud HTTP: " + e.getMessage());
	            return null;
	        }
	    }

}
