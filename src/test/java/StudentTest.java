import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp(){
        student = new Student("Benjamin", "benja123@gmail.com", 16);
    }

    @Test
    @DisplayName("Instancia clase Student")
    public void testInstanceOfStudent(){
        assertInstanceOf(Student.class, student);
    }

    // inicio test funcion getName
    @Test
    @DisplayName("Validacion de nombre")
    public void testGetName(){
        assertEquals("Benjamin", student.getName());
        //assertEquals(student.getName().trim(), student.getName());
    }
    // fin test funcion getName

    //Inicio test funcion setName
    @Test
    @DisplayName("Modificacion de nombre")
    public void testSetName(){
        String name = "Juan";
        student.setName(name);
        assertEquals(name, student.getName());
    }
    // fin test funcion setName

    // inciio test funcion getEmail
    @Test
    @DisplayName("Validacion email")
    public void testGetEmail(){
        String email = "benja123@gmail.com";
        assertEquals(email, student.getEmail());
    }
    // fin test funcion getEmail

    // inicio test funcion setEmail
    @Test
    @DisplayName("Moficacion email")
    public void testSetEmail(){
        String email = "benjamin3456@gmail.com";
        student.setEmail(email);
        assertEquals(email, student.getEmail());
    }
    // fin test funcion setEmail

    // Inicio test funcion getAge
    @Test
    @DisplayName("Validacion edad")
    public void testGetAge(){
        int age = 16;
        assertEquals(age, student.getAge());
    }
    // fin test funcion getAge

    // Inicio test funcion setAge
    @Test
    @DisplayName("Modificacion edad")
    public void testSetAge(){
        int age = 17;
        student.setAge(age);
        assertEquals(age, student.getAge());
    }
    // fin test funcion setAge
}
