import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student student;

    @BeforeEach
    public void setup() {
        student = new Student("Melvin","correo@correo",35);
    }
    @Test

    @DisplayName("Getters")
    public void testGetters(){
        assertEquals("Melvin",student.getName());
        assertEquals("correo@correo",student.getEmail());
        assertEquals(35,student.getAge());
    }
    @DisplayName("Setters")
    public void testSetters(){
        student.setName("Alberto");
        student.setEmail("alberto@correo.com");
        student.setAge(35);

        assertEquals("Alberto",student.getName());
        assertEquals("alberto@correo.com",student.getEmail());
        assertEquals(35,student.getAge());
    }

    @Test
    @DisplayName("Nombre incorrecto")
    public void testIncorrectName(){
        try {
            student.setName("");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty",e.getMessage());
        }
        assertThrows(IllegalArgumentException.class, () -> {
            student.setName("");
        });



    }

    @Test
    @DisplayName("Edad incorrecto")
    public void testIncorrectAge(){
        try {
            student.setAge(121);
        } catch (IllegalArgumentException e) {
            assertEquals("Age must be between 0 and 120 years",e.getMessage());
        }

        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(121);
        });
    }

    @Test
    @DisplayName("Mail incorrecto")
    public void testIncorrectMail(){
        try {
            student.setEmail("asdasd");
        } catch (IllegalArgumentException e) {
            assertEquals("Email must have a valid format",e.getMessage());
        }
        assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("asdasd");
        });
    }


    @Test
    @DisplayName("Añadimos un grado correctamente")
    public void testAddGrade(){
        student.addGrade(10);
        assertEquals(1,student.getGrades().size());

    }

    @Test
    @DisplayName("Añadimos un grado negativo")
    public void testAddNegativeGrade(){

        student.addGrade(10);
    }



    @Test
    @DisplayName("Cálculo de la media")
    public void testAverage(){


            student.addGrade(10);
            student.addGrade(10);
            student.addGrade(0);
            student.addGrade(0);
            assertEquals(5.0,student.calculateAverage());


    }


    @Test
    @DisplayName("Cálculo del estatus")
    public void testStatus(){


        student.addGrade(10);
        student.addGrade(10);
        student.addGrade(0);
        student.addGrade(0);
        assertEquals("Regular",student.getAcademicStatus());


    }




}
