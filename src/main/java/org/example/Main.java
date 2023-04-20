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

    public static double ingresarSoloNumeroInt() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()) {
            System.out.println("Entrada no válida. Ingrese un número: ");
            in.next();
        }
        double numero = in.nextDouble();
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
    public static void compararClave(){
    }
    public static void liberarHabitacion(){

    }
    public static void ingresarOcupado(){
    }
    public static void ingresarReserva(){

    }
    public static boolean sinComida(){
        return true;
    }

    public static void vaciarHotel(int[][] habitaciones){
        System.out.println("Ingrese la clave: ");
        String clave=ingresarClave();
        if (validarClave(clave)==true){
            for (int i = 0; i < 10 ; i++) {
                habitaciones[0][i] = 3;
                System.out.println(habitaciones[0][i]);
            }
        } else {
                System.out.println("La clave ingresada no es válida");
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