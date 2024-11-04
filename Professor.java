

import java.util.ArrayList;
import java.util.List;

public class Professor extends User implements IProfessor {
    private List<Course> courses = new ArrayList<>();

    public Student teachingAssistant;

    public Professor(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Professor(String email, String password) {
        super( email, password);
    }
    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    public Professor(String email, String password, List<Course> courses) {
        super(email, password);
        this.courses = courses;
    }

    public Student getTeachingAssistant() {
        return teachingAssistant;
    }

    public void setTeachingAssistant(Student teachingAssistant) {
        this.teachingAssistant = teachingAssistant;
    }

    public void manageCourse(Course course) {
        // Update course details such as syllabus, class timings, etc.
    }

    public void viewEnrolledStudents(Course course) {
        System.out.println("Students enrolled in " + course.getTitle() + ":");
        for (Student s : course.getEnrolledStudents()) {
            System.out.println(s.email);
        }
    }

    @Override
    public String toString() {
        return "Professor{" +
                "courses=" + courses +
                ", teachingAssistant=" + teachingAssistant +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
