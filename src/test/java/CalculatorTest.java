import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
}
  