package com.example.accesoadatos;

import java.io.Serializable;

public class ListaDeObjetos implements Serializable {
    private Objeto[] lista;
    private int numObjetos;

    public ListaDeObjetos(int numObjetos) {
        this.lista = new Objeto[numObjetos];
        this.numObjetos = 0;
    }

    public void add(Objeto o){
        if(numObjetos < lista.length){
            lista[numObjetos] = o;
            numObjetos++;
        }
    }

    public void remove(int id){
        for(int i = 0; i < numObjetos; i++){
            if(lista[i].getId() == id){
                for(int j = i; j < numObjetos - 1; j++){
                    lista[j] = lista[j+1];
                }
                numObjetos--;
                break;
            }
        }
    }

    public Objeto get(int id){
        for(int i = 0; i < numObjetos; i++){
            if(lista[i].getId() == id){
                return lista[i];
            }
        }
        return null;
    }
    public int getNumObjetos() {
        return numObjetos;
    }

    public void update(Objeto o){
        for(int i = 0; i < numObjetos; i++){
            if(lista[i].getId() == o.getId()){
                lista[i] = o;
                break;
            }
        }
    }

    public void print(){
        for(int i = 0; i < numObjetos; i++){
            System.out.println(lista[i]);
        }
    }

}
