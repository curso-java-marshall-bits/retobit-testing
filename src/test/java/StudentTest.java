import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Cris", "cristina.vegas88@gmail.com", 37);
    }

    @Test
    //nuevo estudiante
    @DisplayName("getters")
    public void testGetters() {
        assertEquals("Cris", student.getName());
        assertEquals("cristina.vegas88@gmail.com", student.getEmail());
        assertEquals(37, student.getAge());
    }

    @Test
    //cambio del estudiante
    @DisplayName("setters")
    public void testSetters(){
        assertEquals("Cris", student.getName());
        assertEquals("cristina.vegas88@gmail.com", student.getEmail());
        assertEquals(37, student.getAge());

        student.setName("Elena");
        student.setEmail("elena.vegas88@gmail.com");
        student.setAge(65);
    }

    @Test
    //lanza la excepcion de que el nombre no puede ir vacio IsEmpty
    @DisplayName("nombre mal")
    public void testNombreMal(){
        try{
            student.setName("");
        } catch (IllegalArgumentException exception){
            assertEquals("Name cannot be empty", exception.getMessage());
        }
    }

    @Test
    //lanza la excepcion de la edad entre 0 y 120
    @DisplayName("edad mal")
    public void testEdadMal(){
        try{
            student.setAge(130);
        } catch (IllegalArgumentException exception){
            assertEquals("Age must be between 0 and 120 years", exception.getMessage());
        }
    }

    @Test
    //lanza la excepcion de que el email no puede ir sin la @
    @DisplayName("email mal")
    public void testEmailMal(){
        try{
            student.setEmail("cristina.vegas88gmail.com");
        } catch (IllegalArgumentException exception){
            assertEquals("Email must have a valid format", exception.getMessage());
        }
        //aqui lanza otra porque no tiene el .com
        assertThrows(IllegalArgumentException.class, () ->{
            student.setEmail("cristina@gmail");
        });
    }

    @Test
    @DisplayName("grade")
    public void testAddGrade(){
        student.addGrade(8);
        assertFalse(student.getGrades().isEmpty());
        assertEquals(1, student.getGrades().size());
    }

    @Test
    //lanza la excepcion
    @DisplayName("grade negativo")
    public void testNegativoGrade(){
        assertThrows(IllegalArgumentException.class, () ->{
            student.addGrade(-8);
        });
    }

    @Test
    //se disparan los decimales
    @DisplayName("media")
    public void testMedia(){
        student.addGrade(8);
        student.addGrade(6);
        student.addGrade(0);
        assertEquals(4.6, student.calculateAverage());
    }

    @Test
    //falla el boolean
    @DisplayName("adulto")
    public void testAdulto(){
        assertTrue(student.isAdult(19));
        assertFalse(student.isAdult(16));
    }


    @Test
    //se disparan los decimales
    @DisplayName("status")
    public void testStatus(){
        student.addGrade(10);
        student.addGrade(5);
        student.addGrade(0);
        assertEquals("Regular", student.getAcademicStatus());
    }
}