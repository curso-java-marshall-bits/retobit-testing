import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp() {
        student = new Student("Ana", "ana@test.com", 20);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Ana", student.getName());
        assertEquals("ana@test.com", student.getEmail());
        assertEquals(20, student.getAge());
        assertTrue(student.getGrades().isEmpty());
    }

    @Test
    void testSettersValid() {
        student.setName("Luis");
        student.setEmail("luis@test.com");
        student.setAge(25);

        assertEquals("Luis", student.getName());
        assertEquals("luis@test.com", student.getEmail());
        assertEquals(25, student.getAge());
    }

    @Test
    void testSetNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> student.setName(""));
        assertThrows(IllegalArgumentException.class, () -> student.setName("   "));
        assertThrows(IllegalArgumentException.class, () -> student.setName(null));
    }

    @Test
    void testSetEmailInvalid() {
        assertThrows(IllegalArgumentException.class, () -> student.setEmail("correoSinArroba"));
        assertThrows(IllegalArgumentException.class, () -> student.setEmail(null));
    }

    @Test
    void testSetAgeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> student.setAge(-1));
        assertThrows(IllegalArgumentException.class, () -> student.setAge(150));
    }

    @Test
    void testAddGrades() {
        student.addGrade(8.0);
        student.addGrade(9.0);

        List<Double> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertTrue(grades.contains(8.0));
        assertTrue(grades.contains(9.0));
    }

    @Test
    void testAddGradeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(-1.0));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(11.0));
    }

    @Test
    void testCalculateAverage() {
        student.addGrade(8.0);
        student.addGrade(10.0);

        assertEquals(9.0, student.calculateAverage(), DELTA);
    }

    @Test
    void testAverageEmpty() {
        assertEquals(0.0, student.calculateAverage(), DELTA);
    }

    @Test
    void testAcademicStatusExcellent() {
        student.addGrade(9.5);
        student.addGrade(9.0);

        assertEquals("Excellent", student.getAcademicStatus());
    }

    @Test
    void testAcademicStatusGood() {
        student.addGrade(7.0);
        student.addGrade(8.0);

        assertEquals("Good", student.getAcademicStatus());
    }

    @Test
    void testAcademicStatusRegular() {
        student.addGrade(5.0);
        student.addGrade(6.0);

        assertEquals("Regular", student.getAcademicStatus());
    }

    @Test
    void testAcademicStatusNeedsImprovement() {
        student.addGrade(3.0);
        student.addGrade(4.0);

        assertEquals("Needs improvement", student.getAcademicStatus());
    }

    @Test
    void testIsAdult() {
        assertTrue(student.isAdult());

        student.setAge(17);
        assertFalse(student.isAdult());
    }
}
