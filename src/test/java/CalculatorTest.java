import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Sumar")

    public void testAdd(){
        double a = 2.0;
        double b = 6.0;

        double result = calculator.add(a,b);
        assertEquals(8.0, result);
    }

    @Test
    @DisplayName("Sumar Negativos")

    public void testAddNegative(){
        double a = -2.0;
        double b = -6.0;

        double result = calculator.add(a,b);
        assertEquals(-8.0, result);
    }

    @Test
    @DisplayName("Sumar Negativo y Positivo")

    public void testAddNegativeandPositive(){
        double a = -2.0;
        double b = 6.0;

        double result = calculator.add(a,b);
        assertEquals(4.0, result);
    }

    @Test
    @DisplayName("Sumar Positivo y Negativo")

    public void testAddPositiveandNegative(){
        double a = 2.0;
        double b = -6.0;

        double result = calculator.add(a,b);
        assertEquals(-4.0, result);
    }

    @Test
    @DisplayName("Sumar con 0")

    public void testAddByZero(){
        double a = 2.0;
        double b = 0.0;

        double result = calculator.add(a,b);
        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Restar")

    public void testSubtract(){
        double a = 3.0;
        double b = 2.0;

        double result = calculator.subtract(a,b);
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Restar Negativos")

    public void testSubtractNegative(){
        double a = -3.0;
        double b = -2.0;

        double result = calculator.subtract(a,b);
        assertEquals(-1.0, result);
    }

    @Test
    @DisplayName("Restar Negativo y Positivo")

    public void testSubtractNegativeandPositive(){
        double a = -3.0;
        double b = 2.0;

        double result = calculator.subtract(a,b);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Restar Positivo y Negativo")

    public void testSubtractPositivenadNegative(){
        double a = 3.0;
        double b = -2.0;

        double result = calculator.subtract(a,b);
        assertEquals(5.0, result);
    }


    @Test
    @DisplayName("Multiplicar")

    public void testMultiply(){
        double a = 3.0;
        double b = 2.0;

        double result = calculator.multiply(a,b);
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("Multiplicar Negativos")

    public void testMultiplyNegativeNumbers(){
        double a = -3.0;
        double b = -2.0;

        double result = calculator.multiply(a,b);
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("Multiplicar Negativo con Positivo")

    public void testMultiplyNegativeandPositive(){
        double a = -3.0;
        double b = 2.0;

        double result = calculator.multiply(a,b);
        assertEquals(-6.0, result);
    }

    @Test
    @DisplayName("Multiplicar Positivo con Negativo")

    public void testMultiplyPositiveandNegative(){
        double a = 3.0;
        double b = -2.0;

        double result = calculator.multiply(a,b);
        assertEquals(-6.0, result);
    }

    @Test
    @DisplayName("Multiplicar por 0")

    public void testMultiplyNumberByZero(){
        double a = 3.0;
        double b = 0.0;

        double result = calculator.multiply(a,b);
        assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Dividir")

    public void testDivide(){
        double a = 15.0;
        double b = 3.0;

        double result = calculator.divide(a,b);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Dividir por 0")

    public void testDivideByZero(){
        double a = 10.0;
        double b = 0.0;

        assertThrows(ArithmeticException.class, ()->{
            calculator.divide(a,b); });
    }

    @Test
    @DisplayName("Comprobar si es par")

    public void testIsEven(){
        int number = 2;

        assertTrue(calculator.isEven(number));
    }

    @Test
    @DisplayName("Comprobar si es impar")

    public void testIsNotEven(){
        int number = 1;

        assertFalse(calculator.isEven(number));
    }

    @Test
    @DisplayName("Comprobar si es par (0)")

    public void testIsEvenZero(){
        int number = 0;

        assertTrue(calculator.isEven(number));
    }

    @Test
    @DisplayName("Comprobar número par negativo")
    public void testIsEvenNegative() {
        int number = -2;

        assertTrue(calculator.isEven(number));
    }

    @Test
    @DisplayName("Comprobar número impar negativo")
    public void testIsNotEvenNegative() {
        int number = -3;

        assertFalse(calculator.isEven(number));
    }

    @Test
    @DisplayName("Valor absoluto de numero positivo")
    public void testAbsoluteValuePositive(){
        int result = calculator.absoluteValue(5);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Valor absoluto de numero negativo")
    public void testAbsoluteValueNegative(){
        int result = calculator.absoluteValue(-5);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Valor absoluto de cero")
    public void testAbsoluteValueZero(){
        int result = calculator.absoluteValue(0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Promedio de lista normal")
    public void testAverage(){
        List<Double> numbers = List.of(2.0, 4.0, 6.0);
        double result = calculator.average(numbers);
        assertEquals(4.0, result);
    }

    @Test
    @DisplayName("Promedio con lista vacia lanza excepcion")
    public void testAverageEmptyList(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(List.of());
        });
    }

    @Test
    @DisplayName("Promedio con lista null lanza excepcion")
    public void testAverageNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(null);
        });
    }

    @Test
    @DisplayName("Maximo de lista normal")
    public void testMaximum(){
        List<Double> numbers = List.of(1.0, 5.0, 3.0);
        double result = calculator.maximum(numbers);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Maximo con lista vacia lanza excepcion")
    public void testMaximumEmpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.maximum(List.of());
        });
    }

    @Test
    @DisplayName("Maximo con lista null lanza excepcion")
    public void testMaximumNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.maximum(null);
        });
    }

    @Test
    @DisplayName("Minimo de lista normal")
    public void testMinimum(){
        List<Double> numbers = List.of(1.0, 5.0, 3.0);
        double result = calculator.minimum(numbers);
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Minimo con lista vacia lanza excepcion")
    public void testMinimumEmpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.minimum(List.of());
        });
    }

    @Test
    @DisplayName("Minimo con lista null lanza excepcion")
    public void testMinimumNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.minimum(null);
        });
    }


}
