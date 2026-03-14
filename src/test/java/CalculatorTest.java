import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;
    private List<Double> listaNumerosPositivos;
    private List<Double> listaNumerosNegativos;
    private List<Double> listaVacia;


    @BeforeEach
    public void setup(){
        this.calculator = new Calculator();
        this.listaNumerosPositivos = new ArrayList<Double>();
        this.listaNumerosNegativos = new ArrayList<Double>();
        this.listaVacia = new ArrayList<Double>();

        this.listaNumerosPositivos.add(1.0);
        this.listaNumerosPositivos.add(5.6);
        this.listaNumerosPositivos.add(8.6);
        this.listaNumerosPositivos.add(3.0);
        this.listaNumerosPositivos.add(10.0);

        this.listaNumerosNegativos.add(-1.0);
        this.listaNumerosNegativos.add(-2.2);
        this.listaNumerosNegativos.add(-3.5);
        this.listaNumerosNegativos.add(-5.0);
    }

    @Test
    @DisplayName("Probar operaciones básicas valores positivos")
    public void testOperationsPositiveNumbers(){
        assertEquals(5, this.calculator.add(3,2));
        assertEquals(1, this.calculator.subtract(3,2));
        assertEquals(6, this.calculator.multiply(3,2));
        assertEquals(3, this.calculator.divide(6,2));
    }

    @Test
    @DisplayName("Probar operaciones básicas con negativos")
    public void testOperationsNegativeNumbers(){
        assertEquals(-5, this.calculator.add(-3,-2));
        assertEquals(-1, this.calculator.subtract(-3,-2));
        assertEquals(6, this.calculator.multiply(-3,-2));
        assertEquals(3, this.calculator.divide(-6,-2));
    }

    @Test
    @DisplayName("División por cero no permitida")
    public void testDivideByZeroThrowsException(){
        assertThrows(ArithmeticException.class, ()-> this.calculator.divide(6,0) );
    }

    @Test
    @DisplayName("Valida número máximo")
    public void testMaxNumberList(){
        assertEquals(10.0, calculator.maximum(this.listaNumerosPositivos));
        assertEquals(-1.0, calculator.maximum(this.listaNumerosNegativos));
        assertThrows(IllegalArgumentException.class, ()-> calculator.maximum(this.listaVacia));
    }

    @Test
    @DisplayName("Valida número mínimo")
    public void testMinNumberList(){
        assertEquals(1.0, calculator.minimum(this.listaNumerosPositivos));
        assertEquals(-5.0, calculator.minimum(this.listaNumerosNegativos));
        assertThrows(IllegalArgumentException.class, ()-> calculator.minimum(this.listaVacia));
    }

    @Test
    @DisplayName("Valida número Par")
    public void testEvenNumber(){
        assertTrue(calculator.isEven(2));
        assertTrue(calculator.isEven(10));
    }

    @Test
    @DisplayName("Valida Valor Absoluto")
    public void testAbsoluteValue(){
        assertEquals(5, calculator.absoluteValue(5));
        assertEquals(5, calculator.absoluteValue(-5));
    }

    @Test
    @DisplayName("Valida Promedio")
    public void testAverage(){
        assertEquals(5.64, calculator.average(this.listaNumerosPositivos));
        assertEquals(-2.925, calculator.average(this.listaNumerosNegativos));
        assertThrows(IllegalArgumentException.class, ()->calculator.average(this.listaVacia));
    }

}
