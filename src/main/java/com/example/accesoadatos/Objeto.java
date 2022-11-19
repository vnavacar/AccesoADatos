package com.example.accesoadatos;

public class Objeto {
    private String nombre;
    private String Descripcion;
    private int id;
    private double valorDouble;
    private float valorFloat;


    public Objeto(String nombre, String Descripcion, int id, double valorDouble, float valorFloat) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.id = id;
        this.valorDouble = valorDouble;
        this.valorFloat = valorFloat;
    }


    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public int getId() {
        return id;
    }
    public double getValorDouble() {
        return valorDouble;
    }
    public float getValorFloat() {
        return valorFloat;
    }

}


