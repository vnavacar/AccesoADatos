package com.example.accesoadatos;

import org.springframework.boot.SpringApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Main {

    static ListaDeObjetos lista;
    //static ListaDeObjetos lista=new ListaDeObjetos(10);
    //lista = new ListaDeObjetos(10);
    public static void main(String[] args){

        //lista = new ListaDeObjetos(10);
        Leerlista();

        Scanner sc = new Scanner(System.in);

        menu(sc);
        sc.close();
    }

    public static void inicializarLista(ListaDeObjetos lista){
        //ListaDeObjetos lista = new ListaDeObjetos(10);

        Objeto o1 = new Objeto("Objeto 1", "Descripcion 1", 1, null, 1.0f);
        Objeto o2 = new Objeto("Objeto 2", "Descripcion 2", 2, null, 2.0f);
        Objeto o3 = new Objeto("Objeto 3", "Descripcion 3", 3, null, 3.0f);
        Objeto o4 = new Objeto("Objeto 4", "Descripcion 4", 4, null, 4.0f);
        Objeto o5 = new Objeto("Objeto 5", "Descripcion 5", 5, null, 5.0f);
        Objeto o6 = new Objeto("Objeto 6", "Descripcion 6", 6, null, 6.0f);
        Objeto o7 = new Objeto("Objeto 7", "Descripcion 7", 7, null, 7.0f);
        Objeto o8 = new Objeto("Objeto 8", "Descripcion 8", 8, null, 8.0f);
        Objeto o9 = new Objeto("Objeto 9", "Descripcion 9", 9, null, 9.0f);
        Objeto o10 = new Objeto("Objeto 10", "Descripcion 10", 10, null, 10.0f);
        lista.add(o1);
        lista.add(o2);
        lista.add(o3);
        lista.add(o4);
        lista.add(o5);
        lista.add(o6);
        lista.add(o7);
        lista.add(o8);
        lista.add(o9);
        lista.add(o10);
    }


    public static void printMenu(){
        System.out.println("1. Crear objeto");
        System.out.println("2. Leer objeto");
        System.out.println("3. Actualizar objeto");
        System.out.println("4. Borrar objeto");
        System.out.println("5. Listar objetos");
        System.out.println("6. Salir");
    }
    public static void menu(Scanner sc){
        int opcion = 0;
        do{
            printMenu();
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    //crearObjeto();
                    if(lista.getNumObjetos()<10){
                        lista.add(crearObjeto());
                        serializarObjeto(lista);
                    }else{
                        System.out.println("No se pueden crear mas objetos, borra alguno para reducir el tamaño de la lista bajo 10");
                    }
                    break;
                case 2:
                    //leerObjeto();
                    System.out.println("Introduce el id del objeto a leer");
                    int id = sc.nextInt();
                    Objeto o = lista.get(id);
                    System.out.println(o.toString());
                    break;
                case 3:
                    //actualizarObjeto();
                    modificarObjeto(sc);
                    break;
                case 4:
                    //borrarObjeto();
                    borrarObjeto();
                    serializarObjeto(lista);

                    break;
                case 5:
                    //imprimirLista();
                    lista.print();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                case 7:
                    //guardarLista();
                    serializarObjeto(lista);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opcion != 6);
    }
    public static void serializarObjeto(ListaDeObjetos lista){

        try{
            FileOutputStream fos = new FileOutputStream("lista.obj",false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.printf("Error al serializar el objeto");
        }


    }

    public static ListaDeObjetos deserializarObjeto(){
        ListaDeObjetos temp = null;
        try{
            FileInputStream fis = new FileInputStream("lista.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            temp = (ListaDeObjetos) ois.readObject();
            ois.close();
            fis.close();
            temp.print();
        }catch(Exception e){
            System.out.println(e);
            System.out.printf("Error al deserializar el objeto");
        }
        return temp;
    }
    public static void Leerlista(){
        lista = deserializarObjeto();
        if (lista == null){
            System.out.println("No hay lista, se creará una nueva");
            lista = new ListaDeObjetos(10);
            inicializarLista(lista);
            serializarObjeto(lista);
            System.out.println("Lista creada");
        }
    }
    public static Objeto crearObjeto(){
        Objeto o = new Objeto();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del objeto");
        o.setNombre(sc.nextLine());
        System.out.println("Introduce la descripción del objeto");
        o.setDescripcion(sc.nextLine());
        System.out.println("Introduce el id del objeto");
        o.setId(sc.nextInt());
        System.out.println("Introduce el float del objeto");
        o.setValorFloat(sc.nextFloat());
        return o;
    }
    public static void borrarObjeto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id del objeto a borrar");
        int id = sc.nextInt();
        lista.remove(id);
    }
    public static void modificarObjeto(Scanner scanner){

        System.out.println("Introduce el id del objeto a modificar");
        int id = scanner.nextInt();
        System.out.println(lista.get(id).toString());
        System.out.println("Elige el elemento a modificar");
        System.out.println("1. Nombre");
        System.out.println("2. Descripción");
        System.out.println("3. Id");
        System.out.println("4. Valor float");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Introduce el nuevo nombre");
                String nombre = scanner.nextLine();
                nombre = scanner.nextLine(); //Se salta el primer nextline
                lista.get(id).setNombre(nombre);
                break;
            case 2:
                System.out.println("Introduce la nueva descripción");
                String descripcion = scanner.nextLine();
                descripcion = scanner.nextLine(); //Se salta el primer nextline
                lista.get(id).setDescripcion(descripcion);
                break;
            case 3:
                System.out.println("Introduce el nuevo id");
                int id2 = scanner.nextInt();
                lista.get(id).setId(id2);
                break;
            case 4:
                System.out.println("Introduce el nuevo valor float");
                float valorFloat = scanner.nextFloat();
                lista.get(id).setValorFloat(valorFloat);
                break;
            default:
                System.out.println("Opción no válida");
        }
        //lista.get(id).setNombre("Objeto modificado");
        serializarObjeto(lista);



    }
}
