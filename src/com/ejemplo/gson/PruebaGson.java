package com.ejemplo.gson;

import com.google.gson.Gson;

public class PruebaGson {

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 25);
        Gson gson = new Gson();
        String json = gson.toJson(persona);
        System.out.println(json);
    }

    // Clase persona
    static class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
