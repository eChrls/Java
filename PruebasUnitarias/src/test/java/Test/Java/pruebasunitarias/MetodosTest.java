/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.pruebasunitarias;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MetodosTest {
    Metodos met = new Metodos();

    @Test
    void testTallasXS() {
        assertEquals("Extra pequeña", met.Tallas("XS"));
    }

    @Test
    void testTallasS() {
        assertEquals("Pequeña", met.Tallas("S"));
    }

    @Test
    void testTallasM() {
        assertEquals("Mediana", met.Tallas("M"));
    }

    @Test
    void testTallasL() {
        assertEquals("Grande", met.Tallas("L"));
    }

    @Test
    void testTallasXL() {
        assertEquals("Muy grande", met.Tallas("XL"));
    }

    @Test
    void testTallasXXL() {
        assertEquals("Extra grande", met.Tallas("XXL"));
    }

    @Test
    void testTallasInvalida() {
        assertEquals("XS", met.Tallas("INVALIDA"));
    }

    @Test
    void testIvaCero() {
        assertEquals(0.0, met.iva(0), 0.01);
    }

    @Test
    void testIvaPrecioBajo() {
        assertEquals(12.1, met.iva(10), 0.01);
    }

    @Test
    void testIvaPrecioAlto() {
        assertEquals(121.0, met.iva(100), 0.01);
    }

    @Test
    void testIvaPrecioDecimal() {
        assertEquals(72.6, met.iva(60), 0.01);
    }

    @Test
    void testIvaPrecioNegativo() {
        assertEquals(-12.1, met.iva(-10), 0.01);
    }
}
