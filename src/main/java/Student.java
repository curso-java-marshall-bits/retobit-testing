import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String email;
    private int age;
    private List<Double> grades;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must have a valid format");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120 years");
        }
        this.age = age;
    }

    public List<Double> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(double grade) {
        if (grade < 0.0 || grade > 10.0) {
            throw new IllegalArgumentException("Grade must be between 0.0 and 10.0");
        }
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getAcademicStatus() {
        double average = calculateAverage();
        if (average >= 9.0) {
            return "Excellent";
        } else if (average >= 7.0) {
            return "Good";
        } else if (average >= 5.0) {
            return "Regular";
        } else {
            return "Needs improvement";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                '}';
    }
}
