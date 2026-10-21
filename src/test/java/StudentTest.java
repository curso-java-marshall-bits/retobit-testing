import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student student1;

    @BeforeEach
    public void setup(){
        student1 = new Student("Matías","m.munoz@gmail.com",11);
    }

    //comprobar que el estudiante se crea correctamente
    @Test
    @DisplayName("Verificar que el estudiante se crea correctamente")
    public void createStudent(){
        assertInstanceOf(Student.class,student1);
        assertNotNull(student1);

        String nameResult = student1.getName();
        assertEquals("Matías", nameResult);

        String emailResult = student1.getEmail();
        assertEquals("m.munoz@gmail.com", emailResult);

        int ageResult = student1.getAge();
        assertEquals(11, ageResult);

        boolean gradesEmptyResult = student1.getGrades().isEmpty();
        assertTrue(gradesEmptyResult);
    }

    @Test
    @DisplayName("verifica que el nombre en vacío, lance la excepción del nombre")
    public void nameEmptyThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setName(""), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que el nombre en nulo, lance la excepción del nombre")
    public void nameNullThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setName(null), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que cambiar el nombre, funcione correctamente")
    public void changeNameSuccessfully(){
        student1.setName("Alonso");
        String result = student1.getName();
        assertEquals("Alonso", result);
    }

    @Test
    @DisplayName("verifica que el correo en nulo, lance la excepción correctamente")
    public void emailNullThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setEmail(null), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que el correo con formato invalido , lance la excepción correctamente")
    public void emailInvalidThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setEmail("alonso.com"), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que cambiar el email, funcione correctamente")
    public void changeEmailSuccessfully(){
        student1.setEmail("matias.munoz@gmail.com");
        String result = student1.getEmail();
        assertEquals("matias.munoz@gmail.com", result);
    }

    @Test
    @DisplayName("verifica que la edad con un número negativo , lance la excepción correctamente")
    public void ageInvalidNegativeNumberThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setAge(-1), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que la edad mayor al permitido , lance la excepción correctamente")
    public void ageMaximumNumberThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.setAge(121), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que cambiar la edad, funcione correctamente")
    public void changeAgeMinimumSuccessfully(){
        student1.setAge(0);
        int result = student1.getAge();
        assertEquals(0, result);
    }

    @Test
    @DisplayName("verifica que cambiar la edad, funcione correctamente")
    public void changeAgeMaximumSuccessfully(){
        student1.setAge(120);
        int result = student1.getAge();
        assertEquals(120, result);
    }

    @Test
    @DisplayName("verifica que las notas con un número negativo , lance la excepción correctamente")
    public void gradeNegativeNumberThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.addGrade(-1.0), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que las notas con un número mayor al permitido , lance la excepción correctamente")
    public void gradeInvalidMaximumThrowsException(){
        assertThrows( IllegalArgumentException.class,() -> student1.addGrade(10.1), " Debe lanzar excepción IllegalArgumentException");
    }

    @Test
    @DisplayName("verifica que se pueden agregar notas permitidas y la lista crece,correctamente")
    public void addGradesSuccessfully(){
        student1.addGrade(7.0);
        student1.addGrade(8.5);

        int sizeResult = student1.getGrades().size();
        assertEquals(2, sizeResult);

        Double gradesResult = student1.getGrades().getFirst();
        assertEquals(7.0, gradesResult);
    }

    @Test
    @DisplayName("Verifica que el cálculo del promedio con notas válidas sea correcto")
    public void calculateAverageSuccessfully() {
        student1.addGrade(5.0);
        student1.addGrade(7.0);
        student1.addGrade(9.0);
        double result = student1.calculateAverage();
        assertEquals(7.0, result);
    }

    @Test
    @DisplayName("Verifica que el cálculo del promedio con una lista de notas vacía funciona de forma correcta")
    public void calculateAverageWhenNoGradesReturnsZero() {
        double result = student1.calculateAverage();
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Verificar que el promedio con un solo numero en la lista, se ejecute correctamente")
    public void calculateAverageWithSingleGrade() {
        student1.addGrade(6.5);
        double result = student1.calculateAverage();
        assertEquals(6.5, result);
    }

    @Test
    @DisplayName("Verificar que el status académico devuelve el status excelente, de forma correcta")
    public void academicStatusExcellent() {
        student1.addGrade(8.0);
        student1.addGrade(10.0);
        String statusResult = student1.getAcademicStatus();
        assertEquals("Excellent", statusResult);
    }

    @Test
    @DisplayName("Verificar que el status académico devuelve el status Good, de forma correcta")
    public void academicStatusGood() {
        student1.addGrade(6.0);
        student1.addGrade(8.0);
        String statusResult = student1.getAcademicStatus();
        assertEquals("Good", statusResult);
    }

    @Test
    @DisplayName("Verificar que el status académico devuelve el status Regular, de forma correcta")
    public void academicStatusRegular() {
        student1.addGrade(4.0);
        student1.addGrade(6.0);
        String statusResult = student1.getAcademicStatus();
        assertEquals("Regular", statusResult);
    }

    @Test
    @DisplayName("Verificar que el status académico devuelve el status Needs improvement, de forma correcta")
    public void academicStatusNeedsImprovement() {
        student1.addGrade(4.5);
        student1.addGrade(3.5);
        String statusResult = student1.getAcademicStatus();
        assertEquals("Needs improvement", statusResult);
    }

    @Test
    @DisplayName("Verificar que el status académico con notas perfectas. Devuelve el status excelente, de forma correcta")
    public void academicStatusPerfectScoreReturnsExcellent() {
        student1.addGrade(10.0);
        student1.addGrade(10.0);
        String statusResult = student1.getAcademicStatus();
        assertEquals("Excellent", statusResult);
    }

    @Test
    @DisplayName("Verificar que el status académico sin notas. Devuelve el status Needs improvement, de forma correcta")
    public void academicStatusNoGradesReturnsNeedsImprovement() {
        String statusResult = student1.getAcademicStatus();
        assertEquals("Needs improvement", statusResult);
    }

    @Test
    @DisplayName("Verificar que el estudiante con edad sobre 18 ,se ejecuta correctamente ")
    public void isAdultWhenAgeIsOver18ReturnsTrue() {
        student1.setAge(25);
        boolean result = student1.isAdult();
        assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que el estudiante con edad bajo 18 ,se ejecuta correctamente ")
    public void isAdultWhenAgeIsUnder18ReturnsFalse() {
        boolean result = student1.isAdult();
        assertFalse(result);
    }

    @Test
    @DisplayName("Verificar que un estudiante con 18 años sea considerado adulto")
    public void isAdultWhenAgeIsExactly18ReturnsTrue() {
        student1.setAge(18);
        boolean result = student1.isAdult();
        assertTrue(result);
    }
}
