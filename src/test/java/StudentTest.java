import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student student;

    @BeforeEach
    public void setup() {
        student = new Student("Melvin", "melvineugine@enclenque.com", 21);
    }

    @Test
    @DisplayName("Getters")
    public void testGetters() {
        assertEquals("Melvin", student.getName());
        assertEquals("melvineugine@enclenque.com", student.getEmail());
        assertEquals(21, student.getAge());
    }

    @Test
    @DisplayName("Setters")
    public void testSetters() {

        assertEquals("Melvin", student.getName());
        student.setName("Tifa");
        assertEquals("Tifa", student.getName());

        student.setEmail("tifa@ffvii.com");
        assertEquals("tifa@ffvii.com", student.getEmail());

        student.setAge(32);
        assertEquals(32, student.getAge());
    }

    @Test
    @DisplayName("Nombre incorrecto manda exception")
    public void testIncorrectName() {
        try {
            student.setName("");
        } catch (IllegalArgumentException exception) {
            assertEquals("Name cannot be empty", exception.getMessage());
        }

        assertThrows(IllegalArgumentException.class, () -> {
            student.setName("");
        });
    }

    @Test
    @DisplayName("Edad incorrecta manda exception")
    public void testIncorrectAge() {
        try {
            student.setAge(-20);
        } catch (IllegalArgumentException exception) {
            assertEquals("Age must be between 0 and 120 years", exception.getMessage());
        }

        try {
            student.setAge(220);
        } catch (IllegalArgumentException exception) {
            assertEquals("Age must be between 0 and 120 years", exception.getMessage());
        }

        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(-20);
        });
    }

    @Test
    @DisplayName("Email incorrecto manda exception")
    public void testIncorrectEmail() {
        try {
            student.setEmail("sdadasfdsagasga");
        } catch (IllegalArgumentException exception) {
            assertEquals("Email must have a valid format", exception.getMessage());
        }
        assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("sdadasfdsagasga");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("hola@");
        });
    }


    @Test
    @DisplayName("Añadimos un grade correctamente")
    public void testAddGrade() {
        student.addGrade(10);
        assertFalse(student.getGrades().isEmpty());
        assertEquals(1, student.getGrades().size());
    }

    @Test
    @DisplayName("Añadimos un grade negativo y lanza exception")
    public void testAddNegativeGrade() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(-10);
        });
    }

    @Test
    @DisplayName("Cálculo de la media correcto")
    public void testAverage() {
        student.addGrade(10);
        student.addGrade(10);
        student.addGrade(0);
        student.addGrade(0);

        assertEquals(5.0, student.calculateAverage());

    }

    @Test
    @DisplayName("Cálculo del status")
    public void testStatus() {
        student.addGrade(10);
        student.addGrade(10);
        student.addGrade(10);
        student.addGrade(10);

        assertEquals("Excellent", student.getAcademicStatus());

    }
}
