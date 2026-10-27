import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;      // una propiedad, como en una clase normal

    @BeforeEach
    void setUp() {
        calculator = new Calculator();  // se crea uno nuevo antes de cada test
    }

    @Test
    @DisplayName("suma de dos números con error de flotantes")
    public void testAddFloatingPoint(){
        double result = calculator.add(20.20,40.20);
        assertEquals(60.40,result);

    }

    @Test
    @DisplayName("suma de dos números sin decimales")
    public void testAddSimple(){
        double result = calculator.add(20.0,40.0);
        assertEquals(60.0,result);

    }

    @Test
    @DisplayName("suma de dos números sin decimales")
    public void testSubSimple(){
        double result = calculator.subtract(20.0,40.0);
        assertEquals(-20.0,result);

    }

    @Test
    @DisplayName("resta de dos números con error de flotantes")
    public void testSubFloatingPoint(){
        double result = calculator.subtract(20.20,40.20);
        assertEquals(-20.20,result);

    }

    @Test
    @DisplayName("Multiplicación de dos números con error de flotantes")
    public void testMulFloatingPoint(){
        double result = calculator.multiply(20.20,40.20);
        assertEquals(812.04,result);

    }

    @Test
    @DisplayName("Multiplica dos números sin decimales")
    public void testMulSimple(){
        double result = calculator.multiply(20.0,40.0);
        assertEquals(800.0,result);

    }

    @Test
    @DisplayName("Multiplica dos números sin decimales")
    public void testMulZero(){
        double result = calculator.multiply(20.0,0.0);
        assertEquals(0.0,result);

    }

    @Test
    @DisplayName("Divide por cero")
    public void testDivZero(){
       // double result = calculator.divide(20.0,0.0);
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

    }

    @Test
    @DisplayName("Numeros pares")
    public void testPares(){
       assertTrue(calculator.isEven(4));

    }

    @Test
    @DisplayName("Valor absoluto")
    public void testAbsoluteVal(){
        int  number = calculator.absoluteValue(-20);
        assertEquals(20,number);
        System.out.println(number);


    }

    @Test
    @DisplayName("Average")
    public void testAbsoluteAvg(){
        List <Double> numbers = Arrays.asList(50.0,60.0,80.0);


      //  System.out.println(calculator.average(numbers));
        assertEquals(63.333333333333336,calculator.average(numbers));

    }

    @Test
    @DisplayName("Mínimo")
    public void testMinimum(){
        List <Double> numbers = Arrays.asList(50.0,60.0,80.0);


        //  System.out.println(calculator.average(numbers));
        assertEquals(50.0,calculator.minimum(numbers));

    }

    @Test
    @DisplayName("Maxímo")
    public void testMaximum(){
        List <Double> numbers = Arrays.asList(50.0,60.0,80.0);


        //  System.out.println(calculator.average(numbers));
        assertEquals(80.0,calculator.maximum(numbers));

    }


    @Test
    @DisplayName("Lista vacía")
    public void testEmptyList(){
        // double result = calculator.divide(20.0,0.0);
        List <Double> numbers = List.of();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.maximum(numbers);
        });

    }





    @Test
    void testAddPositiveNumbers() {
        Calculator calculator = new Calculator();      // preparar: el objeto

        double result = calculator.add( 5 , 3 );   // actuar: dos números

        assertEquals( 8 , result );                  // comprobar: lo esperado
    }

    @Test
    void testSubtractPositiveNumbers() {
        double result = calculator.subtract( 2 , 1 );
        assertEquals( 1 , result );
    }

    @Test
    void testMultiplyPositiveNumbers() {
        double result = calculator.multiply( 5, 2 );
        assertEquals( 10 , result );
    }

    @Test
    void testDividePositiveNumbers() {
        double result = calculator.divide( 10, 2 );
        assertEquals( 5 , result );
    }

    @Test

    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    void testAddNegativeNumbers() {
        double result = calculator.add( -1, -5 );
        assertEquals( -6 , result );
    }

}
