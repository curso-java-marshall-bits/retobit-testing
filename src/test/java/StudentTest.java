import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StudentTest {

    private Student student1;
    @BeforeEach
    void setUp(){
        student1 = new Student("Alain","alain.toledo.g@gmail.com",31);
    }

    @Test
    @DisplayName("Constructor Name")
    public void testConstructorName(){
        assertEquals("Alain",student1.getName());
    }

    @Test
    @DisplayName("Constructor Email")
    public void testConstructorEmail(){
        assertEquals("alain.toledo.g@gmail.com",student1.getEmail());
    }

    @Test
    @DisplayName("Constructor Age")
    public void testConstructorAge(){
        assertEquals(31,student1.getAge());
    }

    @Test
    @DisplayName("Constructor Grades Empty")
    public void testConstructorGrade(){
        assertTrue(student1.getGrades().isEmpty());
    }

    //------------------------------------------------------------------------

    @Test
    @DisplayName("Set Name Valid")
    public void testSetNameValid(){
        student1.setName("Alen");
        assertEquals("Alen", student1.getName());
    }

    @Test
    @DisplayName("Set Name null throw exception")
    public void testSetNameNull(){
        assertThrows(IllegalArgumentException.class, ()->{
            student1.setName(null);
        });
    }

    @Test
    @DisplayName("Set Name empty throw exception")
    public void testSetNameEmpty(){
        assertThrows(IllegalArgumentException.class, ()->{
            student1.setName("");
        });
    }

    @Test
    @DisplayName("Set Name empty spaces exception")
    public void testSetNameBlank(){
        assertThrows(IllegalArgumentException.class, ()->{
            student1.setName(" ");
        });
    }

    //-------------------------------------------------------------------------------

    @Test
    @DisplayName("Set Email Valid")
    public void testSetEmailValid(){
        student1.setEmail("misfits-txc@hotmail.com");
        assertEquals("misfits-txc@hotmail.com", student1.getEmail());
    }

    @Test
    @DisplayName("Set Email Null")
    public void testSetEmailNull(){
        assertThrows(IllegalArgumentException.class, ()->{
           student1.setEmail(null);
        });
    }

    @Test
    @DisplayName("Set invalid format email")
    public void testSetEmailInvalidFormat(){
        assertThrows(IllegalArgumentException.class, ()->{
           student1.setEmail("invalid_email");
        });
    }

    @Test
    @DisplayName("Set Age")
    public void testSetAgeValid(){
        student1.setAge(25);
        assertEquals(25,student1.getAge());
    }

    @Test
    @DisplayName("Set Age Zero")
    public void testSetAgeZero(){
        student1.setAge(0);
        assertEquals(0,student1.getAge());
    }

    @Test
    @DisplayName("Set Age Max Limit")
    public void testSetAgeMaxLimit(){
        student1.setAge(120);
        assertEquals(120,student1.getAge());
    }

    @Test
    @DisplayName("Set Age Negative")
    public void testSetAgeNegative(){


        assertThrows(IllegalArgumentException.class, ()->{
           student1.setAge(-15);
        });

        assertEquals(31, student1.getAge());
    }

    @Test
    @DisplayName("Set Age Above Limit")
    public void testSetAgeAboveLimit(){
        assertThrows(IllegalArgumentException.class, ()->{
            student1.setAge(121);
        });
    }

    //-------------------------------------

    @Test
    @DisplayName("AddGrade agrega nota valida")
    public void testAddGradeValid(){
        student1.addGrade(8.5);
        assertEquals(1, student1.getGrades().size());
    }

    @Test
    @DisplayName("AddGrade acepta 0.0")
    public void testAddGradeZero(){
        student1.addGrade(0.0);
        assertEquals(1, student1.getGrades().size());
    }

    @Test
    @DisplayName("AddGrade acepta 10.0")
    public void testAddGradeMax(){
        student1.addGrade(10.0);
        assertEquals(1, student1.getGrades().size());
    }

    @Test
    @DisplayName("AddGrade menor que 0 lanza excepcion")
    public void testAddGradeNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            student1.addGrade(-1.0);
        });
    }

    @Test
    @DisplayName("AddGrade mayor que 10 lanza excepcion")
    public void testAddGradeAboveMax(){
        assertThrows(IllegalArgumentException.class, () -> {
            student1.addGrade(11.0);
        });
    }

    //-------------------------

    @Test
    @DisplayName("Promedio sin notas es 0")
    public void testCalculateAverageEmpty(){
        assertEquals(0.0, student1.calculateAverage());
    }

    @Test
    @DisplayName("Promedio con una nota")
    public void testCalculateAverageSingle(){
        student1.addGrade(8.0);
        assertEquals(8.0, student1.calculateAverage());
    }

    @Test
    @DisplayName("Promedio con varias notas")
    public void testCalculateAverageMultiple(){
        student1.addGrade(6.0);
        student1.addGrade(8.0);
        student1.addGrade(10.0);
        assertEquals(8.0, student1.calculateAverage());
    }

    //---------------------------

    @Test
    @DisplayName("Menor de edad devuelve false")
    public void testIsAdultFalse(){
        student1.setAge(17);
        assertFalse(student1.isAdult());
    }

    @Test
    @DisplayName("Mayor de edad devuelve true")
    public void testIsAdultTrue(){
        student1.setAge(20);
        assertTrue(student1.isAdult());
    }

    @Test
    @DisplayName("Edad 18 es adulto")
    public void testIsAdultBoundary(){
        student1.setAge(18);
        assertTrue(student1.isAdult());
    }

    //-------------

    @Test
    @DisplayName("Estado academico Excellent")
    public void testAcademicStatusExcellent(){
        student1.addGrade(9.5);
        student1.addGrade(9.0);
        assertEquals("Excellent", student1.getAcademicStatus());
    }

    @Test
    @DisplayName("Estado academico Good")
    public void testAcademicStatusGood(){
        student1.addGrade(7.5);
        student1.addGrade(7.0);
        assertEquals("Good", student1.getAcademicStatus());
    }

    @Test
    @DisplayName("Estado academico Regular")
    public void testAcademicStatusRegular(){
        student1.addGrade(5.5);
        student1.addGrade(5.0);
        assertEquals("Regular", student1.getAcademicStatus());
    }

    @Test
    @DisplayName("Estado academico Needs improvement")
    public void testAcademicStatusNeedsImprovement(){
        student1.addGrade(4.0);
        student1.addGrade(3.5);
        assertEquals("Needs improvement", student1.getAcademicStatus());
    }

}
