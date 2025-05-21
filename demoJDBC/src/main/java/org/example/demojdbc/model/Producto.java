package org.example.demojdbc.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto() {
    }

/*    public Persona(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }*/

    public Producto(String nombre, double precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
    }
    public Producto(String nombre) {
        this.nombre=nombre;
    }

}
