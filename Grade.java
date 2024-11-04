public class Grade {
    private Course course;
    private String grade;

    public Grade(Course course, String grade) {
        this.course = course;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course: " + course.getTitle() + " - Grade: " + grade;
    }
}
