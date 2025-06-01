package com.conversor.HistorialConversion;

import java.time.LocalDateTime;


public class HistorialConversion {
	
	private String monedaBase;
	private String monedaDestino;
	private double cantidad;
	private double resultado;
	private LocalDateTime fechaHora;

	
	public HistorialConversion(String base, String destino , double cantidad , double conversor ) {
		
		this.monedaBase = base;
		this.monedaDestino = destino;
		this.cantidad = cantidad;
		this.resultado = conversor;
		this.fechaHora = LocalDateTime.now();
		
	}	
	

	@Override
    public String toString() {
        return "💱 " + cantidad + " " + monedaBase + " → " + resultado + " " + monedaDestino + " (" + fechaHora + ")";
    }
	
	

}
