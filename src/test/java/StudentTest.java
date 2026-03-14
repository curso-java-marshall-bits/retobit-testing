import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setup(){
        this.student = new Student("Jesús", "correo@prueba.com", 30);
    }

    @Test
    @DisplayName("Testea constructor y getters/setters")
    public void testConstructor(){
        //Constructor
        assertNotNull(this.student);

        //Getters
        assertEquals("Jesús", this.student.getName());
        assertEquals("correo@prueba.com", this.student.getEmail());
        assertEquals(30, this.student.getAge());

        //Setters
        this.student.setName("Nancy");
        assertEquals("Nancy", this.student.getName());
        this.student.setEmail("correo2@prueba.com");
        assertEquals("correo2@prueba.com", this.student.getEmail());
        this.student.setAge(25);
        assertEquals(25, this.student.getAge());
    }

    @Test
    @DisplayName("Testea validaciones de datos (nombre vacío, email inválido, edad inválida)")
    public void testInvalidData(){
        assertThrows(IllegalArgumentException.class, ()->this.student.setName(""));
        assertThrows(IllegalArgumentException.class, ()->this.student.setEmail("correoinvalido.com"));
        assertThrows(IllegalArgumentException.class, ()->this.student.setAge(-5));

    }

    @Test
    @DisplayName("Testea gestión de calificaciones (agregar calificaciones, calcular promedio)")
    public void testCalificaciones(){
        this.student.addGrade(10.0);
        this.student.addGrade(7.0);
        this.student.addGrade(9.0);
        this.student.addGrade(8.5);
        this.student.addGrade(9.2);
        assertArrayEquals(new Double[]{10.0,7.0, 9.0, 8.5, 9.2}, this.student.getGrades().toArray());

        assertEquals(8.74,this.student.calculateAverage());
    }

    @Test
    @DisplayName("Calculo de estado académico")
    public void testEstadoAcademico(){
        this.student.addGrade(10.0);
        assertEquals("Excellent", this.student.getAcademicStatus());
        this.student.addGrade(5.0);
        assertEquals("Good", this.student.getAcademicStatus());
        this.student.addGrade(3.0);
        assertEquals("Regular", this.student.getAcademicStatus());
        this.student.addGrade(1.0);
        assertEquals("Needs improvement", this.student.getAcademicStatus());
    }


}
