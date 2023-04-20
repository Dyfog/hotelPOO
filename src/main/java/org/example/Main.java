package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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


        public static void menuPrincipal(){

    }
    public static void arranque(){

    }
    public static void compararClave(){
    }
    public static int liberarHabitacion(){

    }
    public static int ingresarOcupado(){
    }
    public static int ingresarReserva(){

    }
    public static boolean sinComida(){
        return true;
    }
}

