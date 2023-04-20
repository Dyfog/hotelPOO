package org.example;

import javax.management.MBeanRegistration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] estadoHabitaciones = new int[3][10];
        estadoHabitaciones = inicializarHabitaciones(estadoHabitaciones);
        menuPrincipal();

    }


    public static void menu(int[][] estadoHabitaciones){
        Scanner in = new Scanner(System.in);
        opcionesMenu();
        int eleccion = ingresarSoloNumeroInt();
        switch (eleccion) {
            case 1:
                ingresarClienteOpciones();
                ingresarClienteMenu(estadoHabitaciones);
            case 2:
                ingresarClienteMenu(estadoHabitaciones);
                break;
            case 3:
                ingresarClienteMenu(estadoHabitaciones);
                break;
            case 4:
                System.out.println("salir");
                break;
            default:
                System.out.println("no es un numero valido");
                break;
        }
    }
    public static void opcionesMenu() {
        System.out.println("Tiene las sigueientes opciones:");
        System.out.println("1.-ingresar un cliente a una haabitacion");
        System.out.println("2.-Hacer checkout de un cliente");
        System.out.println("3.-Reseat sistema por cambio de temporada");
        System.out.println("4.-Salir");
    }

    public static void ingresarClienteOpciones() {
        System.out.println("Tiene las siguientes opciones:");
        System.out.println("1.-Ingresar a un cliente con una habitacion (sin comida)");
        System.out.println("2.-Ingresar a un cliente con una habitacion con desayuno y cena incluida");
        System.out.println("3.-Reservar una habitacion sin comida");
        System.out.println("4.-Reservar una habitacion con comida");
        System.out.println("4.-Salir");
    }

    public static void ingresarClienteMenu(int[][] estadoHabitaciones) {
        int eleccion = ingresarSoloNumeroInt();
        int cantNoches;
        switch (eleccion) {
            case 1:
                    System.out.println("ha elegido alojarse sin comida");
                    System.out.println("cuantas noches desea alojarse?");
                    cantNoches = ingresarSoloNumeroInt();
                    estadoHabitaciones = ingresarClienteSnComida(estadoHabitaciones, cantNoches);
                    System.out.println("ingresado exitosamente");
                    System.out.println("volviendo al menu");
                    menu(estadoHabitaciones);
            case 2:
                System.out.println("ha elegido alojarse con comida");
                    System.out.println("cuantas noches desea alojarse?");
                    cantNoches = ingresarSoloNumeroInt();
                    estadoHabitaciones = ingresarClienteCnComida(estadoHabitaciones, cantNoches);
                    System.out.println("ingresado exitosamente");
                    System.out.println("volviendo al menu");
                    menu();
            case 3:
                System.out.println("Ha elegido reservar una habitacion sin comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                estadoHabitaciones = ingresarClienteReservaSnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu();
            case 4:
                System.out.println("Ha elegido reservar una habitacion con comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                estadoHabitaciones = ingresarClienteReservaCnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu();
            case 5:
                System.out.println("Saliendo");
                menu();
            default:
                System.out.println("Opción no válida, por lo que se saldra al menu anterior");
                menu();


        }
        //return solo para que la ide no de error
        return null;
    }

    public static int[][] inicializarHabitaciones(int[][] estadoHabitaciones) {
        for (int cont = 0; cont < 10; cont++) {
            for (int cont2 = 0; cont2 < 3; cont2++) {
                estadoHabitaciones[cont][cont2] = 0;
            }
        }
        return estadoHabitaciones;
    }

    public static boolean validarDistinto0(double numero) {
        if (numero == 0) {
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

    public static boolean validarMayorA0(int numero) {
        if (numero <= 0) {
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

    public static int encontrarProxHabitacionDisponible(int[][] estadoHabitaciones) {
        for (int cont = 0; cont < 10; cont++) {
            if (estadoHabitaciones[0][cont] == 3) {
                return cont;
            }
        }
        return -1;
    }

    public static int[][] ingresarClienteSnComida(int[][] estadoHabitaciones, int cantNoches) {
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[0][proxHabitacion] = 1;
        estadoHabitaciones[1][proxHabitacion] = 1;
        estadoHabitaciones[2][proxHabitacion] = cantNoches;
        return estadoHabitaciones;
    }

    public static int[][] ingresarClienteCnComida(int[][] estadoHabitaciones, int cantNoches) {
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[0][proxHabitacion] = 1;
        estadoHabitaciones[1][proxHabitacion] = 2;
        estadoHabitaciones[2][proxHabitacion] = cantNoches;
        return estadoHabitaciones;
    }

    public static int[][] ingresarClienteReservaCnComida(int[][] estadoHabitaciones, int cantNoches) {
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[0][proxHabitacion] = 2;
        estadoHabitaciones[1][proxHabitacion] = 2;
        estadoHabitaciones[2][proxHabitacion] = cantNoches;
        return estadoHabitaciones;
    }

    public static int[][] ingresarClienteReservaSnComida(int[][] estadoHabitaciones, int cantNoches) {
        int proxHabitacion = encontrarProxHabitacionDisponible(estadoHabitaciones);
        estadoHabitaciones[0][proxHabitacion] = 2;
        estadoHabitaciones[1][proxHabitacion] = 1;
        estadoHabitaciones[2][proxHabitacion] = cantNoches;
        return estadoHabitaciones;
    }
}
