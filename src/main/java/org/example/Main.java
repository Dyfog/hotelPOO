package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] estadoHabitaciones = new int[10][3];
        estadoHabitaciones = inicializarHabitaciones(estadoHabitaciones);
    }

    public static void opcionesMenu(){
        System.out.println("Tiene las sigueientes opciones:");
        System.out.println("1.-ingresar un cliente a una haabitacion");
        System.out.println("2.-Hacer checkout de un cliente");
        System.out.println("3.-Reseat sistema por cambio de temporada");
        System.out.println("4.-Salir");
    }

    public static void ingresarClienteOpciones(){
        System.out.println("Tiene las siguientes opciones:");
        System.out.println("1.-Ingresar a un cliente con una habitacion (sin comida)");
        System.out.println("2.-Ingresar a un cliente con una habitacion con desayuno y cena incluida");
        System.out.println("3.-Reservar una habitacion");
        System.out.println("4.-Salir");
    }
    public static int[][] ingresarClienteMenu(int[][] estadoHabitaciones){
        int eleccion = ingresarSoloNumeroInt();
        switch (eleccion){
            case 1:

            case 2:
                System.out.println("Ingresar a un cliente con una habitacion con desayuno y cena incluida");
                break;
            case 3:
                System.out.println("Reservar una habitacion");
                break;
            case 4:
                System.out.println("Salir");
                break;
            default:
                System.out.println("Opción no valida");

        }
        //return solo para que la ide no de error
        return null;
    }
    public static int[][] inicializarHabitaciones(int[][] estadoHabitaciones){
        for (int cont = 0; cont<10; cont++){
            for (int cont2 = 0; cont2<3; cont2++){
                estadoHabitaciones[cont][cont2] = 0;
            }
        }
        return estadoHabitaciones;
    }

    public static boolean validarDistinto0(double numero){
        if (numero == 0){
            return false;
        }
        return true;
    }

    public static boolean validarRangoNumero(int numero, int min, int max) {
        if (numero < min || numero > max) {
            return false;
        }
        return true;
    }

    public static int ingresarSoloNumeroInt() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.out.println("Entrada no válida. Ingrese un número: ");
            in.next();
        }
        int numero = in.nextInt();
        return numero;
    }

    public static int encontrarProxHabitacionDisponible(int[][] estadoHabitaciones){
    for (int cont = 0; cont<10; cont++){
        if (estadoHabitaciones[cont][0] == 3){
            return cont;
        }
    }
    return -1;
    }
    public static int[][] ingresarClienteSnComida(int[][] estadoHabitaciones,int cantNoches){
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[proxHabitacion][0] = 1;
        estadoHabitaciones[proxHabitacion][1] = 1;
        estadoHabitaciones[proxHabitacion][2] = cantNoches;
        return estadoHabitaciones;
    }

    public static int[][] ingresarClienteCnComida(int[][] estadoHabitaciones,int cantNoches){
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[proxHabitacion][0] = 1;
        estadoHabitaciones[proxHabitacion][1] = 2;
        estadoHabitaciones[proxHabitacion][2] = cantNoches;
        return estadoHabitaciones;
    }

}