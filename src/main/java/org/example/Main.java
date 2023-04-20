package org.example;

public class Main {
    public static void main(String[] args) {

    }

    public static void opcionesMenu(){
        System.out.println("Tiene las sigueientes opciones:");
        System.out.println("1.-ingresar un cliente a una haabitacion");
        System.out.println("2.-Hacer checkout de un cliente");
        System.out.println("3.-Reseat sistema por cambio de temporada");
        System.out.println("4.-Salir");
    }
    public static int[][] ingresarCliente(int[][] estadoHabitaciones){
        System.out.println("Tiene las siguientes opciones:");
        System.out.println("1.-Ingresar a un cliente con una habitacion (sin comida)");
        System.out.println("2.-Ingresar a un cliente con una habitacion con desayuno y cena incluida");
        System.out.println("3.-Reservar una habitacion");
        System.out.println("4.-Salir");
        switch (eleccion){
            case 1:
                break;
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
                menu();
        }
    }
}