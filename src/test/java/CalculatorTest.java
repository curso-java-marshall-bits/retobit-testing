import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class CalculatorTest {

    private Calculator calc;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calc.add(2.0, 3.0), DELTA);
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calc.subtract(3.0, 2.0), DELTA);
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calc.multiply(2.0, 3.0), DELTA);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calc.divide(6.0, 3.0), DELTA);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(5.0, 0.0);
        });
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-1.0, calc.add(-3.0, 2.0), DELTA);
        assertEquals(-5.0, calc.subtract(-3.0, 2.0), DELTA);
        assertEquals(-6.0, calc.multiply(-3.0, 2.0), DELTA);
        assertEquals(-2.0, calc.divide(-6.0, 3.0), DELTA);
    }

    @Test
    void testIsEven() {
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(5));
        assertTrue(calc.isEven(0)); // caso límite
    }

    @Test
    void testAbsoluteValue() {
        assertEquals(5, calc.absoluteValue(-5));
        assertEquals(5, calc.absoluteValue(5));
        assertEquals(0, calc.absoluteValue(0));
    }

    @Test
    void testAverage() {
        List<Double> nums = Arrays.asList(2.0, 4.0, 6.0);
        assertEquals(4.0, calc.average(nums), DELTA);
    }

    @Test
    void testAverageEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(Collections.emptyList());
        });
    }

    @Test
    void testAverageNullList() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(null);
        });
    }

    @Test
    void testMaximum() {
        List<Double> nums = Arrays.asList(1.0, 5.0, 3.0);
        assertEquals(5.0, calc.maximum(nums), DELTA);
    }

    @Test
    void testMaximumEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.maximum(Collections.emptyList());
        });
    }

    @Test
    void testMinimum() {
        List<Double> nums = Arrays.asList(1.0, -2.0, 3.0);
        assertEquals(-2.0, calc.minimum(nums), DELTA);
    }

    @Test
    void testMinimumEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.minimum(Collections.emptyList());
        });
    }
}
