import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Instancia clase Calculator")
    public void testInstanceOfCalculator(){
        assertInstanceOf(Calculator.class, calculator);
    }

    //inicio est funcion Add
    @Test
    @DisplayName("Suma de numeros positivos")
    public void testAddPositiveNumbers(){
        double a = 3.0;
        double b = 5.0;

        double result = calculator.add(a, b);

        assertEquals(8, result);
    }

    @Test
    @DisplayName("Suma de numeros negativos")
    public void testAddNegativeNumbers(){
        double a = -4.0;
        double b = -3.0;

        double result = calculator.add(a, b);

        assertEquals(-7.0, result);
    }

    @Test
    @DisplayName("Suma de numeros positivos y negativos / negativos y positivos")
    public void testAddPositiveAndNegativeNumbers(){
        double a = 4.0;
        double b = -3.0;

        double resultPositiveAndNegative = calculator.add(a, b);
        double resultNegativeAndPositive = calculator.add(b, a);

        assertEquals(1.0, resultPositiveAndNegative);
        assertEquals(1.0, resultNegativeAndPositive);
    }

    @Test
    @DisplayName("Suma Casos Limite")
    public void testAddEdgeCases(){
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MIN_VALUE, 0));
    }
    //fin test funcion add

    // inicio test funcion subtract
    @Test
    @DisplayName("Resta con numero positivos")
    public void testSubtractPositiveNumbers(){
        double a = 7.0;
        double b = 5.0;

        double result = calculator.subtract(a, b);

        assertEquals(2, result);
    }
    @Test
    @DisplayName("Resta de numeros negativos")
    public void testSubtractNegativeNumbers(){
        double a = -4.0;
        double b = -3.0;

        double result = calculator.subtract(a, b);

        assertEquals(-1.0, result);
    }

    @Test
    @DisplayName("Resta de numeros positivos y negativos / negativos y positivos")
    public void testSubtractPositiveAndNegativeNumbers(){
        double a = 4.0;
        double b = -3.0;

        double resultPositiveAndNegative = calculator.subtract(a, b);
        double resultNegativeAndPositive = calculator.subtract(b, a);

        assertEquals(7.0, resultPositiveAndNegative);
        assertEquals(-7.0, resultNegativeAndPositive);
    }

    @Test
    @DisplayName("Resta casos limite")
    public void testSubtractEdgeCases(){
        assertEquals(Integer.MIN_VALUE, calculator.subtract(Integer.MIN_VALUE, 0));
    }
    // fin test funcion subtract

    //Inicio test funcion multiply
    @Test
    @DisplayName("Multiplicacion entre numeros positivos")
    public void testMultiplyPositiveNumbers(){
        double a = 4.0;
        double b = 5.0;

        double result = calculator.multiply(a, b);

        assertEquals(20.0, result);
    }
    @Test
    @DisplayName("Multiplicacion entre numeros negativos")
    public void testMultiplyNegativeNumbers(){
        double a = -3.0;
        double b = -5.0;

        double result = calculator.multiply(a, b);

        assertEquals(15.0, result);
    }
    @Test
    @DisplayName("Multiplicacion entre numeros positivos y negativos / negativos y positivos")
    public void testMultiplyPositiveAndNegativeNumbers(){
        double a = 6.0;
        double b = -12.0;

        assertEquals(-72.0, calculator.multiply(a, b));
        assertEquals(-72.0, calculator.multiply(b, a));
    }
    @Test
    @DisplayName("Multiplicacion casos limite")
    public void testMultiplyEdgeCases(){
        assertEquals(0, calculator.multiply(Integer.MAX_VALUE, 0));
        assertEquals(0, calculator.multiply(0, Integer.MAX_VALUE));
    }
    // fin test funcion multiply

    // Inicio test funcion divide
    @Test
    @DisplayName("Division entre numeros positivos")
    public void testDividePositiveNumbers(){
        double a = 6.0;
        double b = 3.0;

        assertEquals(2.0, calculator.divide(a, b));
        assertEquals(0.5, calculator.divide(b, a));
    }
    @Test
    @DisplayName("Division entre numeros negativos")
    public void testDivideNegativeNumbers(){
        double a = -10.0;
        double b = -2.0;

        assertEquals(5.0, calculator.divide(a, b));
        assertEquals(0.2, calculator.divide(b, a));
    }
    @Test
    @DisplayName("Division entre numeros positivos y negativos / negativos y positivos")
    public void testDividePositiveAndNegativeNumbers() {
        double a = -30.0;
        double b = 3.0;

        assertEquals(-10.0, calculator.divide(a, b));
        assertEquals(-0.1, calculator.divide(b, a));
    }
    @Test
    @DisplayName("Division casos limite")
    public void testDivideEdgeCases(){
        assertEquals(Integer.MAX_VALUE, calculator.divide(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MIN_VALUE, calculator.divide(Integer.MIN_VALUE, 1));
    }
    @Test
    @DisplayName("Division con validacion de errores")
    public void testDivideErrorValidation(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(Integer.MAX_VALUE, 0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(Integer.MIN_VALUE, 0));
    }
    // fin test funcion divide
}
