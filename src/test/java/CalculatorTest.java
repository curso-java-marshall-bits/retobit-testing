import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    //error de punto flotante, lo mas efectivo es redondear para que haya menos decimales
    @DisplayName("Suma dos numeros con decimales")
    public void testSumaConDecimales() {
        double result = calculator.add(20.20, 40.20);

        assertEquals(60.40, result);
    }
    @Test
    //perfecto
    @DisplayName("Suma sin decimales")
    public void testSumaSinDecimales() {
        double result = calculator.add(20, 40);

        assertEquals(60, result);
    }

    @Test
    //falla como la suma anterior por decimales
    @DisplayName("resta con decimales")
    public void testRestaConDecimales() {
        double result = calculator.subtract(20.20, 40.20);

        assertEquals(-20.0, result);
    }

    @Test
    //perfecto
    @DisplayName("resta sin decimales")
    public void testRestaSinDecimales() {
        double result = calculator.subtract(40, 30);

        assertEquals(10, result);
    }

    @Test
    //error decimales
    @DisplayName("multiplica con decimales")
    public void testMultiplicaConDecimales() {
        double result = calculator.multiply(20.20, 40.20);

        assertEquals(812.04, result);
    }

    @Test
    //perfecto
    @DisplayName("multiplica sin decimales")
    public void testMultiplicaSinnDecimales() {
        double result = calculator.multiply(20, 40);

        assertEquals(800, result);
    }

    @Test
    //perfecto
    @DisplayName("multiplicar por cero")
    public void testMultiplicarCero() {
        double result = calculator.multiply(20, 0);

        assertEquals(0, result);
    }

    @Test
    //mismo fallo con los decimales
    @DisplayName("divide con decimales")
    public void testDivideConDecimales() {
        double result = calculator.divide(20.20, 40.20);

        assertEquals(0.50, result);
    }

    @Test
    //perfecto
    @DisplayName("dividir")
    public void testDividir() {
        double result = calculator.divide(20, 40);

        assertEquals(0.50, result);
    }

    @Test
    //perfecto lanza la excepcion
    @DisplayName("dividir por cero")
    public void testDividirPorCero(){
        assertThrows(ArithmeticException.class, () ->{
            calculator.divide(20, 0);
        });
    }

    @Test
    //perfecto el metodo booleano
    @DisplayName("numeros pares o impares")
    public void testNumeroParesOImpares() {
        assertFalse(calculator.isEven(1));
        assertTrue(calculator.isEven(2));
        assertFalse(calculator.isEven(3));
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(5));
    }

    @Test
    //perfecto con el valor 30
    @DisplayName("Valor absoluto")
    public void testValorAbsoluto() {
        int valor = calculator.absoluteValue(-30);
        System.out.println(valor);
    }

    @Test
    //perfecto
    @DisplayName("Media")
    public void testMedia() {
        List<Double> numeros = Arrays.asList(10.10, 20.20, 30.30);
        System.out.println(calculator.average(numeros));
    }

    @Test
    //perfecto 10.10
    @DisplayName("Minimo")
    public void testMinimo() {
        List<Double> numeros = Arrays.asList(10.10, 20.20, 30.30);
        System.out.println(calculator.minimum(numeros));
    }

    @Test
    //perfecto tambien saca el 30.30
    @DisplayName("Maximo")
    public void testMaximo() {
        List<Double> numeros = Arrays.asList(10.10, 20.20, 30.30);
        System.out.println(calculator.maximum(numeros));
    }

    @Test
    //perfecto lanza que la lista no puede estar vacia
    @DisplayName("excepcion lista vacia")
    public void testListaVacia(){
        List<Double> numeros = List.of();

        assertThrows(IllegalArgumentException.class, ()->{
            calculator.maximum(numeros);
        });
        try{
            calculator.maximum(numeros);
        }catch(IllegalArgumentException exception){
            assertEquals("List cannot be empty or null", exception.getMessage());
        }
    }
}