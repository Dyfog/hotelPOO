package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] estadoHabitaciones = new int[3][10];
        estadoHabitaciones = inicializarHabitaciones(estadoHabitaciones);
        menu(estadoHabitaciones);
    }

    public static void menu(int[][] estadoHabitaciones){
        Scanner in = new Scanner(System.in);
        opcionesMenu();
        int eleccion = ingresarSoloNumeroInt();
        while (!validarRangoNumero(eleccion,1,5)) {
            System.out.println("eleccion no valida, ingrese un numero entre 1 y 5");
            eleccion = ingresarSoloNumeroInt();
        }
        switch (eleccion) {
            case 1:
                if (!estadoHotel(estadoHabitaciones)){
                    System.out.println("no quedan habitaciones");
                    menu(estadoHabitaciones);
                }
                ingresarClienteOpciones();
                ingresarClienteMenu(estadoHabitaciones);
            case 2:
                checkOut(estadoHabitaciones);
                menu(estadoHabitaciones);

            case 3:
                vaciarHotel(estadoHabitaciones);
                menu(estadoHabitaciones);

            case 4:
                mostrarEstadoHotel(estadoHabitaciones);
                menu(estadoHabitaciones);
            case 5:
                System.out.println("salir");
                System.exit(0);
            default:
                System.out.println("no es un numero valido");
                menu(estadoHabitaciones);
        }
    }
    public static void opcionesMenu() {
        System.out.println("Tiene las sigueientes opciones:");
        System.out.println("1.-ingresar un cliente a una haabitacion");
        System.out.println("2.-Hacer checkout de un cliente");
        System.out.println("3.-Reseat sistema por cambio de temporada");
        System.out.println("4.-Mostrar estado de las habitaciones");
        System.out.println("5.-Salir");
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
        while (!validarRangoNumero(eleccion,1,5)) {
            System.out.println("eleccion no valida, ingrese un numero entre 1 y 5");
            eleccion = ingresarSoloNumeroInt();
        }
        switch (eleccion) {
            case 1:
                System.out.println("ha elegido alojarse sin comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                while (!validarMayorA0(cantNoches)) {
                    System.out.println("la cantidad de noches debe ser mayor a 0, ingrese nuevamente");
                    cantNoches = ingresarSoloNumeroInt();
                }
                estadoHabitaciones = ingresarClienteSnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu(estadoHabitaciones);
            case 2:
                System.out.println("ha elegido alojarse con comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                while (!validarMayorA0(cantNoches)) {
                    System.out.println("la cantidad de noches debe ser mayor a 0, ingrese nuevamente");
                    cantNoches = ingresarSoloNumeroInt();
                }
                estadoHabitaciones = ingresarClienteCnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu(estadoHabitaciones);
            case 3:
                System.out.println("Ha elegido reservar una habitacion sin comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                while (!validarMayorA0(cantNoches)) {
                    System.out.println("la cantidad de noches debe ser mayor a 0, ingrese nuevamente");
                    cantNoches = ingresarSoloNumeroInt();
                }
                estadoHabitaciones = ingresarClienteReservaSnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu(estadoHabitaciones);
            case 4:
                System.out.println("Ha elegido reservar una habitacion con comida");
                System.out.println("cuantas noches desea alojarse?");
                cantNoches = ingresarSoloNumeroInt();
                while (!validarMayorA0(cantNoches)) {
                    System.out.println("la cantidad de noches debe ser mayor a 0, ingrese nuevamente");
                    cantNoches = ingresarSoloNumeroInt();
                }
                estadoHabitaciones = ingresarClienteReservaCnComida(estadoHabitaciones, cantNoches);
                System.out.println("ingresado exitosamente");
                System.out.println("volviendo al menu");
                menu(estadoHabitaciones);
            case 5:
                System.out.println("Saliendo");
                menu(estadoHabitaciones);
            default:
                System.out.println("Opción no válida, por lo que se saldra al menu anterior");
                menu(estadoHabitaciones);


        }
    }

    public static int[][] inicializarHabitaciones(int[][] estadoHabitaciones) {
        for (int cont = 0; cont < 10; cont++) {
            estadoHabitaciones[0][cont] = 3;
            for (int cont2 = 1; cont2 < 3; cont2++) {
                estadoHabitaciones[cont2][cont] = 0;
            }
        }

        return estadoHabitaciones;
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

    public static void mostrarEstadoHotel(int[][] estadoHabitaciones) {
        for (int cont = 0; cont < 10; cont++) {
            if (estadoHabitaciones[0][cont] == 1 || estadoHabitaciones[0][cont] == 2) {
                System.out.println("la habitacion " + cont + " esta ocupada");
            }else {
                System.out.println("la habitacion " + cont + " esta vacia");
            }
        }
    }

    public static boolean estadoHotel(int[][] estadoHabitaciones) {
        boolean habitacionDisponible = false;
        for (int cont = 0; cont < 10; cont++) {
            if (estadoHabitaciones[0][cont] == 3) {
                habitacionDisponible = true;
            }
        }
        return habitacionDisponible;
    }
    public static void liberarHabitacion(int habitacion, int[][] habitaciones){
        habitaciones[0][habitacion] = 3;
    }
    public static int calcularCosto (int habitacion, int[][] habitaciones){
        int precio = 0;
        int cantNoches = habitaciones[2][habitacion];
        if (habitaciones[1][habitacion]==1){
            precio = cantNoches*30000;
        } else {
            precio = cantNoches*40000;
        }
        return precio;
    }

    public static void checkOut(int[][] estadoHabitaciones){
        System.out.println("Ingrese el número de la habitación para el CheckOut");
        int habitacion = ingresarSoloNumeroInt();
        while (!validarRangoNumero(habitacion,0,9)){
            System.out.println("El número de habitación debe ir entre 0 y 9, ingrese su habitacion nuevamente");
            habitacion = ingresarSoloNumeroInt();
        }
        if (estadoHabitaciones[0][habitacion]==3){
            System.out.println("no se puede hacer checkOut a la habitación ya que esta disponible");
            menu(estadoHabitaciones);
        }
        int precio = calcularCosto(habitacion,estadoHabitaciones);
        liberarHabitacion(habitacion,estadoHabitaciones);
        System.out.println("El costo a pagar es de: " + precio);
    }

    public static void vaciarHotel(int[][] estadoHabitaciones){
        System.out.println("Ingrese la clave: ");
        String clave=ingresarClave();
        if (validarClave(clave)==true){
            for (int i = 0; i < 10 ; i++) {
                estadoHabitaciones[0][i] = 3;
            }
        } else {
            System.out.println("La clave ingresada no es válida, se volverá al menú Principal");
            menu(estadoHabitaciones);
        }
    }
    public static String ingresarClave(){
        Scanner sc = new Scanner(System.in);
        String clave = sc.next();
        return clave;
    }
    public static boolean validarClave(String clave){
        if (clave.equals("1234")){
            return true;
        } else {
            return false;
        }
    }
}
