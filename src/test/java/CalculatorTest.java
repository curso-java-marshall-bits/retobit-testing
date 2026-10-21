import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculadora;

    @BeforeEach // sirve para ejecutar un bloque de código automáticamente antes de cada una de tus pruebas.
    public void setup(){
        calculadora = new Calculator();
    }

    @Test
    @DisplayName("Verificar que la suma con números positivos se ejecuta correctamente")
    public void sumPositiveNumbers(){
        double result = calculadora.add(3.0,1.0);
        assertEquals(4.0, result);
    }

    @Test
    @DisplayName("Verificar que la suma con números negativos se ejecuta correctamente")
    public void sumNegativeNumbers(){
        double result = calculadora.add(-2.0,-2.0);
        assertEquals(-4.0, result);
    }

    @Test
    @DisplayName("Verificar que la suma con números negativos y 0 se ejecuta correctamente")
    public void sumNegativeNumbersWith0(){
        double result = calculadora.add(-4.0,0.0);
        assertEquals(-4.0, result);
    }

    @Test
    @DisplayName("Verificar que la suma con números 0 ejecuta correctamente")
    public void sumZeros(){
        double result = calculadora.add(-0.0,0.0);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Verificar que la resta con números positivos se ejecuta correctamente")
    public void subsPositiveNumbers(){
        double result = calculadora.subtract(5.0,3.0);
        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Verificar que la resta con números negativos se ejecuta correctamente")
    public void subsNegativeNumbers(){
        double result = calculadora.subtract(-5.0,-3.0);
        assertEquals(-2.0, result);
    }

    @Test
    @DisplayName("Verificar que la resta del mismo número, devuelve cero correctamente")
    public void subsSameNumbers(){
        double result = calculadora.subtract(5.0,5.0);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Verificar que la resta a un 0, devuelve resultado correctamente")
    public void subsFromZero(){
        double result = calculadora.subtract(0.0,5.0);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Verificar que restar el valor máximo a sí mismo da como resultado cero")
    public void
    subsMaximumBoundaryCondition(){
        double result = calculadora.subtract(Integer.MAX_VALUE,Integer.MAX_VALUE);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Verificar que restar el valor mínimo a sí mismo da como resultado cero")
    public void subsMinimumBoundaryCondition() {
        double result = calculadora.subtract(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Verificar que la multiplicación con números positivos se ejecuta correctamente")
    public void mulPositiveNumbers() {
        double result = calculadora.multiply(2.0, 3.0);
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("Verificar que la multiplicación con números negativos se ejecuta correctamente")
    public void mulNegativeNumbers() {
        double result = calculadora.multiply(-2.0, -3.0);
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("Verificar que la multiplicación de números con distintos signos se ejecuta correctamente")
    public void mulNumbersWithDifferentSigns() {
        double result = calculadora.multiply(5.0, -3.0);
        assertEquals(-15.0, result);
    }

    @Test
    @DisplayName("Verificar que la multiplicación por 0 se ejecuta correctamente")
    public void mulByZero() {
        double result = calculadora.multiply(5.0, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Verificar que la multiplicación por 1 se ejecuta correctamente")
    public void mulByOne() {
        double result = calculadora.multiply(7.0, 1.0);
        assertEquals(7.0, result);
    }

    @Test
    @DisplayName("Verificar que la división por 0, lanza la excepción esperada")
    public void DivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class,() -> calculadora.divide(2.0,0.0), "debería lanzar excepción ArithmeticException");
    }

    @Test
    @DisplayName("Verificar que la división de números positivos se ejecuta correctamente")
    public void DivPositiveNumbers() {
        double result = calculadora.divide(4.0,2.0);
        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Verificar que la división por un mismo número se ejecuta correctamente ")
    public void divOfANumberByItself() {
        double result = calculadora.divide(5.5, 5.5);
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Verificar que la división de números negativos, se ejecuta correctamente ")
    public void divNegativeNumbers() {
        double result = calculadora.divide(-10.0, -2.0);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Verificar que el 0, es número par ")
    public void esParZero() {
        boolean result = calculadora.isEven(0);
        assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que determinado número par se ejecuta correctamente ")
    public void esParPositive() {
        boolean result = calculadora.isEven(100);
        assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que determinado número impar se ejecuta correctamente ")
    public void esParFalse() {
        boolean result = calculadora.isEven(7);
        assertFalse(result);
    }

    @Test
    @DisplayName("Verificar que determinado número par negativo se ejecuta correctamente ")
    public void esParNegative() {
        boolean result = calculadora.isEven(-18);
        assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que el numero mínimo par se ejecuta correctamente ")
    public void esParMinimum() {
        boolean result = calculadora.isEven(Integer.MIN_VALUE);
        assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que el valor absoluto en un numero positivo, se ejecuta correctamente ")
    public void valorAbsolutoNumeroPositivo() {
        int result = calculadora.absoluteValue(10);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Verificar que el valor absoluto en un numero negativo, se ejecuta correctamente ")
    public void valorAbsolutoNumeroNegativo() {
        int result = calculadora.absoluteValue(-10);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Verificar que el valor absoluto en un 0, se ejecuta correctamente ")
    public void valorAbsolutoByZero() {
        int result = calculadora.absoluteValue(0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Verificar que el valor absoluto en un 0, se ejecuta correctamente ")
    public void valorAbsolutoLimiteMin() {
        int result = calculadora.absoluteValue(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    @DisplayName("Verificar que el promedio con una lista vacía lance la excepción")
    public void averageEmptyThrowsException() {
        assertThrows( IllegalArgumentException.class,() -> calculadora.average(List.of()), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el promedio con una lista null lance la excepción")
    public void averageNullThrowsException() {
        assertThrows(IllegalArgumentException.class,() -> calculadora.average(null), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el promedio con números positivos se ejecute correctamente")
    public void averagePositiveNumbers() {
        double result = calculadora.average(List.of(2.0, 4.0, 6.0));
        assertEquals(4.0, result);
    }

    @Test
    @DisplayName("Verificar que el promedio con un solo numero en la lista, se ejecute correctamente")
    public void averageUniqueNumber() {
        double result = calculadora.average(List.of(8.5));
        assertEquals(8.5, result);
    }

    @Test
    @DisplayName("Verificar que el promedio con una lista de número negativos, se ejecute correctamente")
    public void averageNegativeNumbers() {
        double result = calculadora.average(List.of(-3.0,-6.5,-2.5,-12.0));
        assertEquals(-6.0, result);
    }

    @Test
    @DisplayName("Verificar que el máximo con una lista vacía lance la excepción")
    public void maximumEmptyListThrowsException() {
        assertThrows( IllegalArgumentException.class,() -> calculadora.maximum(List.of()), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el máximo con una lista null lance la excepción")
    public void maximumNullListThrowsException() {
        assertThrows(IllegalArgumentException.class,() -> calculadora.maximum(null), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el máximo con una lista de números positivos se ejecute correctamente")
    public void maximumPositiveNumbers() {
        double result = calculadora.maximum(List.of(5.0, 12.0, 3.0, 8.0));
        assertEquals(12.0, result);
    }

    @Test
    @DisplayName("Verificar que el máximo con un solo número en la lista se ejecute correctamente")
    public void maximumUniqueNumber() {
        double result = calculadora.maximum(List.of(7.5));
        assertEquals(7.5, result);
    }

    @Test
    @DisplayName("Verificar que el máximo con una lista de números negativos se ejecute correctamente")
    public void maximumNegativeNumbers() {
        double result = calculadora.maximum(List.of(-5.0, -12.0, -3.0, -8.0));
        assertEquals(-3.0, result);
    }

    @Test
    @DisplayName("Verificar que el máximo ignore el número negativo si existe el mismo en positivo")
    public void maximumWithPositiveAndNegativeSameValue() {
        double result = calculadora.maximum(List.of(-9.0, 4.0, 9.0, -2.0));
        assertEquals(9.0, result);
    }

    @Test
    @DisplayName("Verificar que el mínimo con una lista vacía lance la excepción")
    public void minimumEmptyListThrowsException() {
        assertThrows( IllegalArgumentException.class,() -> calculadora.minimum(List.of()), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el mínimo con una lista null lance la excepción")
    public void minimumNullListThrowsException() {
        assertThrows(IllegalArgumentException.class,() -> calculadora.minimum(null), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("Verificar que el mínimo con una lista de números positivos se ejecute correctamente")
    public void minimumPositiveNumbers() {
        double result = calculadora.minimum(List.of(5.0, 12.0, 3.0, 8.0));
        assertEquals(3.0, result);
    }

    @Test
    @DisplayName("Verificar que el mínimo con un solo número en la lista se ejecute correctamente")
    public void minimumUniqueNumber() {
        double result = calculadora.minimum(List.of(7.5));
        assertEquals(7.5, result);
    }

    @Test
    @DisplayName("Verificar que el mínimo con una lista de números negativos se ejecute correctamente")
    public void minimumNegativeNumbers() {
        double result = calculadora.minimum(List.of(-5.0, -12.0, -3.0));
        assertEquals(-12.0, result);
    }

    @Test
    @DisplayName("Verificar que el mínimo elija el número negativo si existe el mismo en positivo")
    public void minimumWithPositiveAndNegativeSameValue() {
        double result = calculadora.minimum(List.of(9.0, 4.0, -9.0, 2.0));
        assertEquals(-9.0, result);
    }
}
