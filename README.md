# RetoBit: Testing con JUnit 🧪

En este RetoBit vamos a practicar el testing en Java usando JUnit. 
Nuestra empresa tiene un nuevo cliente que necesita una aplicación de gestión de estudiantes, el equipo de front ya ha empezado a desarrollar la interfaz y al equipo de back le toca implementar la lógica de negocio.
Tu Tech Lead te ha asignado la parte de testing. El problema que tienen es que cada dos por tres se rompen cosas y no saben por qué. Quieren seguir añadiendo nuevas funcionalidades, pero necesitan asegurarse de que todo funciona correctamente antes de hacer cambios. Para eso necesitan los tests.

Tu trabajo es crear tests que verifiquen que las funcionalidades principales funcionan como se espera. No debes modificar nada de la app, solo añadir los tests necesarios.

## ¿Qué practicarás?

- Testing con JUnit 5
- Assertions básicas
- Casos de prueba (happy path y edge cases)
- Organización de tests
- Buenas prácticas en testing

## Funcionalidades a testear

La aplicación tiene las siguientes clases:

### 🧑‍🎓 Clase `Student`
- Gestión de datos básicos del estudiante (nombre, email, edad)
- Validaciones de datos
- Cálculo de promedio de calificaciones

### ➕ Clase `Calculator`
- Operaciones matemáticas básicas
- Cálculos de estadísticas simples

## Tu misión 🎯

Debes crear tests unitarios para **todas** las funcionalidades de estas clases. Los tests deben cubrir:
- Casos normales (happy path 😁)
- Casos límite (edge cases 🫣)
- Validaciones de errores 

## Fork del repositorio:

Haz un fork del repo.

Pulsa el botón Fork en github:

![fork](public/img1.png)

Esto creará una copia del repositorio en tu perfil de Github.

## Clona el repo en tu computadora

Ahora hay que descargarse el proyecto en tu computadora.

### 1. Asegúrate de que estás en la URL de TU copia del repositorio

Si la URL es esta: https://github.com/curso-java-marshall-bits/retobit-testing **NO ES CORRECTO**.

Donde aparece 'curso-java-marshall-bits' debería aparecer tu nombre de usuario. Haz click en tu perfil y mira tus
repositorios para comprobar si hiciste el fork. En caso contrario vuelve al paso anterior.

### 2. Pulsa en "code" para ver la URL del repositorio y cópiala

![clone](public/img2.png)

Para ello deberás abrir una terminal y navegar a la carpeta donde quieras añadir este retoBit.

Utiliza el siguiente comando:

```commandline
git clone https://aqui.debes.pegar.la.url
```

**Nota: Después del 'git clone' debes pegar la url del repositorio. No pongas la que he puesto yo en el ejemplo 🤣**

Ahora se va a crear un nuevo directorio con el nombre del retoBit.

### 3. ¡Ya puedes abrir este reto en IntelliJ!


# Instrucciones

### Añade la dependencia de JUnit

Como este es un proyecto Maven, necesitas añadir la dependencia de JUnit a tu archivo `pom.xml`.

Añade la siguiente dependencia dentro de la etiqueta `<dependencies>`:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.11.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Después de añadir la dependencia, **recarga el proyecto Maven** haciendo click en el botón de refresh de Maven en IntelliJ o ejecutando:

```commandline
mvn clean compile
```

### Tarea 1: Explora las clases existentes

Examina las tres clases que ya están creadas:
- `Student.java` - Contiene información del estudiante y gestión de calificaciones
- `Calculator.java` - Contiene operaciones matemáticas básicas

### Tarea 2: Crea tus clases de test

Crea las clases de test en la carpeta `src/test/java`:
- `StudentTest.java` - Para testear la clase Student
- `CalculatorTest.java` - Para testear la clase Calculator

### Tarea 3: Escribe tests completos

Hay algunas assertions que posiblemente no habrás visto antes (qué malo soy eh 🙈). Para ello te dejo la [documentación oficial de JUnit 5](https://docs.junit.org/5.8.1/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

Para cada clase, escribe tests que cubran:

#### Tests de Calculator 
- Testea operaciones básicas: sumar, restar, multiplicar, dividir
- Testea división por cero (debe lanzar excepción). 🕵️‍♀️ Deberás usar `assertThrows()`.
- Testea casos límite como números negativos
- Testea funciones estadísticas con listas vacías

#### Tests de Student
- Testea constructor y getters/setters
- Testea validaciones de datos (nombre vacío, email inválido, edad inválida)
- Testea gestión de calificaciones (agregar calificaciones, calcular promedio)
- Testea cálculo de estado académico

### Estructura de ejemplo de test

Aquí tienes un ejemplo de cómo debería verse tu clase de test:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Suma de números positivos")
    void testAdd() {
        // inicialización de variables
        double a = 5.0;
        double b = 3.0;
        
        // acción: llamar al método add
        double result = calculator.add(a, b);
        
        // assertion: verificar el resultado (esta es la parte más importante)
        assertEquals(8.0, result);
    }
  
}
```

### Consejos para testing:

1. **Usa nombres descriptivos de tests**: `testAddPositiveNumbers()`, `testDivideByZeroThrowsException()`
2. **Testea tanto escenarios positivos como negativos**
3. **Usa assertions apropiadas**: `assertEquals()`, `assertTrue()`, `assertThrows()`, etc.
4. **Testea casos límite**: valores vacíos, valores nulos, condiciones de frontera

## Ejecutar Tests

Para ejecutar tus tests:
1. Haz click derecho en la carpeta `src/test/java` en IntelliJ
2. Selecciona "Run All Tests" o ejecuta clases de test individuales haciendo click derecho en ellas

¡Todos los tests deberían pasar cuando los hayas implementado correctamente!

## Entrega

Realiza un commit con los cambios desde la terminal:

1. Añade todos los cambios

````commandline
git add .
````

2. Haz el commit con el mensaje

````commandline
git commit -m "retobit completado"
````

3. Haz un push

````commandline
git push origin main
````

Debes realizar una pull request para entregar el ejercicio. Abre el link del repositorio en github y haz click en la
pestaña *pull requests*.

Selecciona *New pull request*, *Create pull request* y confírmala. Esto hará que yo pueda verlo y revisarlo en caso de
que haya fallado algún test para poder darte feedback.

Mucha suerte con el reto. Te mando un abrazo y ¡Sigamos desarrollando! 🫂

[marshall-bits.dev](http://marshall-bits.dev)

*Nota: Estos retos pertenecen al curso de Marcel Bosch de Java para desarrolladores junior. Cualquier uso fuera de este
contexto debe estar autorizado explícitamente. Si quieres usar estos ejercicios ponte en contacto conmigo a través de
mis redes sociales (visita mi página para [más información](http://marshall-bits.dev)).*
