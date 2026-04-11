import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        // Un estudiante base para cada test
        student = new Student("Juan", "juan@mail.com", 19);
    }

    @Test
    @DisplayName("Debería lanzar error si el email no tiene @")
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("email_sin_arroba.com");
        });
    }

    @Test
    @DisplayName("Deberia lanzar error si la edad es negativa")
    void testNegativeAge(){
        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(-1);
        });
    }

    @Test
    @DisplayName("tu edad excede lo permitido")
    void testOldAge(){
        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(121);
        });
    }

    @Test
    @DisplayName("verificacion de si eres adulto")
    void TestIsAdult(){
        assertTrue(student.isAdult());
    }

    @Test
    @DisplayName("Deberia dar error si el nombre esta en blanco")
    void testNameWithOnlySpaces(){
        assertThrows(IllegalArgumentException.class, () -> {
            student.setName("     ");
        });
    }

    @Test
    @DisplayName("Debería retornar Excellent cuando el promedio es >= 9")
    void testAcademicStatusExcellent() {
        // 1. Añadimos notas para que el promedio sea alto
        student.addGrade(10.0);
        student.addGrade(9.0);
        student.addGrade(8.0); // El promedio aquí es 9.0

        // 2. Verificamos que el estado sea el esperado
        assertEquals("Excellent", student.getAcademicStatus(), "El estado debería ser Excellent");
    }

    @Test
    @DisplayName("Debería retornar Good cuando el promedio es >= 7 y < 9")
    void testAcademicStatusGood() {
        student.addGrade(7.0);
        student.addGrade(8.0);
        assertEquals("Good", student.getAcademicStatus());
    }

    @Test
    @DisplayName("Debería retornar Regular cuando el promedio es >= 5 y < 7")
    void testAcademicStatusRegular() {
        student.addGrade(5.0);
        student.addGrade(6.0);
        assertEquals("Regular", student.getAcademicStatus());
    }

    @Test
    @DisplayName("Debería retornar Needs improvement cuando el promedio es < 5")
    void testAcademicStatusLow() {
        student.addGrade(2.0);
        student.addGrade(4.0);
        assertEquals("Needs improvement", student.getAcademicStatus());
    }

    @Test
    @DisplayName("verificacion nota rango correcto")
    void testValidNegativeGrade(){
        assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(-1.0);
        });
    }

    @Test
    @DisplayName("verificacion nota rango correcto")
    void testValidGrade(){
        assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(11.0);
        });
    }

    @Test
    @DisplayName("Verificacion pasando solo el promedio directo")
    void testAverageWithSingleGrade(){
        student.addGrade(7.5);
        assertEquals(7.5,student.calculateAverage());
    }

    @Test
    @DisplayName("Promedio debe ser 0 si no hay notas")
    void testAverageWithNoGrades() {
        assertEquals(0.0, student.calculateAverage());
    }
}