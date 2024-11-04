


import java.util.List;

public class Administrator extends User implements IAdministrator {

    public Administrator(String email, String password) {
        super(email, password);
    }

    public void addCourse(List<Course> courseCatalog, Course course) {
        courseCatalog.add(course);
        System.out.println("Course added: " + course.getTitle());
    }

    public void removeCourse(List<Course> courseCatalog, Course course) {
        courseCatalog.remove(course);
        System.out.println("Course removed: " + course.getTitle());
    }

    public void assignProfessor(Course course, Professor professor) {
        course.setProfessor(professor);
        System.out.println("Professor " + professor.email + " assigned to course " + course.getTitle());
    }
}
