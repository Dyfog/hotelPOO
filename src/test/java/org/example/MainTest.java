package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] habitaciones = new int[3][10];
    String claveTest1;
    String claveTest2;
    String claveTest3;

    @BeforeEach
    void setUp(){
        habitaciones[0][6]=3;
        habitaciones[1][1]=2;
        habitaciones[2][1]=2;

        claveTest1 = "1";
        claveTest2 = "a";
        claveTest3 = "1234";
    }
    @Test
    void testCalcularCosto(){
        assertEquals(80000,Main.calcularCosto(1,habitaciones));
    }
    @Test
    void testValidarClave(){
        assertFalse(Main.validarClave(claveTest1));
        assertFalse(Main.validarClave(claveTest2));
        assertTrue(Main.validarClave(claveTest3));
    }
    @Test
    void testestadoHotel(){
        assertTrue(Main.estadoHotel(habitaciones));
    }
    @Test
    void testencontrarHbitacionDisponible(){
        assertEquals(6,Main.encontrarProxHabitacionDisponible(habitaciones));
    }
}