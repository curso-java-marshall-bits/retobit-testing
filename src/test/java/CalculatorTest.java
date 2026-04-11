import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Suma de números positivos")
    void testAdd() {
        // inicialización de variables

        // acción: llamar al método add
        double result = calculator.add(5.0, 3.0);

        // assertion: verificar el resultado (esta es la parte más importante)
        assertEquals(8.0, result);
    }

    @Test
    @DisplayName("Resta de numeros")
    void testSubtract(){

        double result = calculator.subtract(4.0,2.0);

        assertEquals(2.0, result);
    }


    @Test
    @DisplayName("Multiplicacion de numeros")
    void testMultiply(){

        double result = calculator.multiply(7.0,9.0);

        assertEquals(63.0, result);
    }


    @Test
    @DisplayName("División por cero debe lanzar excepción")
    void testDivideByZero() {
        // No llamamos a divide() aquí afuera, dejamos que assertThrows lo haga

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
    }

    @Test
    @DisplayName("División normal")
    void testDivide() {
        double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Verifica que el número sea par")
    void testIsEven(){
        boolean result = calculator.isEven(4);
        assertTrue(result);
    }

    @Test
    @DisplayName("El valor absoluto de -5 debe ser 5")
    void testAbsoluteValue(){
        int result = calculator.absoluteValue(-5);

        // FALTA: Verificar que cambió el signo
        assertEquals(5, result);
    }
    @Test
    @DisplayName("comprovando numeros pares")
    void TestAvarage(){
        List<Double> numbers = Arrays.asList(10.0, 20.0, 30.0);
        double result = calculator.average(numbers);
        assertEquals(20.0,result);
    }

    @Test
    @DisplayName("Debería lanzar excepción si la lista está vacía")
    void testAverageEmptyList(){
        List<Double> emptyList = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(emptyList);
        });
    }

    @Test
    @DisplayName("Debería lanzar excepción si la lista está vacía")
    void testAverageNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(null);
        });
    }

    @Test
    @DisplayName("Maximum: falla con lista nula")
    void testMaximumNull() {
        assertThrows(IllegalArgumentException.class, () -> calculator.maximum(null));
    }

    @Test
    @DisplayName("Maximum: falla con lista vacía")
    void testMaximumEmpty() {
        assertThrows(IllegalArgumentException.class, () -> calculator.maximum(Arrays.asList()));
    }

    @Test
    @DisplayName("deberia darme el numero maximo ")
    void TestMaximun(){
        List<Double> numbers = Arrays.asList(55.0, 20.0, 60.0);
        double result = calculator.maximum(numbers);
        assertEquals(60.0,result);

    }

    @Test
    @DisplayName("Minimum: falla con lista nula")
    void testMinimumNull() {
        assertThrows(IllegalArgumentException.class, () -> calculator.minimum(null));
    }

    @Test
    @DisplayName("Minimum: falla con lista vacía")
    void testMiniEmpty() {
        assertThrows(IllegalArgumentException.class, () -> calculator.minimum(Arrays.asList()));
    }

    @Test
    @DisplayName("deberia darme el numero minimo ")
    void TestMinimun(){
        List<Double> numbers = Arrays.asList(55.0, 20.0, 60.0);
        double result = calculator.minimum(numbers);
        assertEquals(20.0,result);

    }




}
  