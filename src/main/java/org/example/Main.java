package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal(){
        int[][] habitaciones = new int[3][10];
        vaciarHotel(habitaciones);
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

    public static boolean validarRangoNumero(int numero, int min, int max) {
        if (numero < min || numero > max) {
            return false;
        }
        return true;
    }
    public static void arranque(){
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

    public static void checkOut(int[][] habitaciones){
        System.out.println("Ingrese el número de la habitación para el CheckOut");
        int habitacion = ingresarSoloNumeroInt();
        while (!validarRangoNumero(habitacion,0,9)){
            System.out.println("El número de habitación debe ir entre 0 y 9, ingrese su habitacion nuevamente");
            habitacion = ingresarSoloNumeroInt();
        }
        int precio = calcularCosto(habitacion,habitaciones);
        liberarHabitacion(habitacion,habitaciones);
        System.out.println("El costo a pagar es de: " + precio);
    }

    public static void vaciarHotel(int[][] habitaciones){
        System.out.println("Ingrese la clave: ");
        String clave=ingresarClave();
        if (validarClave(clave)==true){
            for (int i = 0; i < 10 ; i++) {
                habitaciones[0][i] = 3;
            }
        } else {
                System.out.println("La clave ingresada no es válida, se volverá al menú Principal");
                menuPrincipal();
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