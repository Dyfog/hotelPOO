package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] habitaciones = new int[3][10];

    @BeforeEach
    void setUp(){
        habitaciones[1][1]=2;
        habitaciones[2][1]=2;
    }
    @Test
    void testCalcularCosto(){
        assertEquals(80000,Main.calcularCosto(1,habitaciones));
    }
    @Test
    void testIngresarClave(){

    }
    @Test
    void testValidarClave(){

    }

}