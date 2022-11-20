package com.example.accesoadatos;


import java.awt.image.BufferedImage;

public class Objeto {
    private String nombre;
    private String Descripcion;
    private int id;

    private BufferedImage imagen;
    private float valorFloat;


    public Objeto(String nombre, String Descripcion, int id, BufferedImage imagen, float valorFloat) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.id = id;
        this.imagen = imagen;
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
    public BufferedImage getImagen() {
        return imagen;
    }
    public float getValorFloat() {
        return valorFloat;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    public void setValorFloat(float valorFloat) {
        this.valorFloat = valorFloat;
    }

    @Override
    public String toString() {
        return "Objeto [Descripcion=" + Descripcion + ", id=" + id + ", nombre=" + nombre + ", valorFloat=" + valorFloat + "]";
    }


}


