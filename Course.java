


import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode; // unique course code
    private String title;
    private Professor professor;
    private int credits;
    private String schedule; // assumption that course is secheduled only once  per week
    private int semester;
    private List<String> prerequisites; // list of prerequisities course codes
    private String location;
    private List<Student> enrolledStudents = new ArrayList<>();
    private int enrollmentLimit = 100;
    private List<Feedback<?>> feedbackList = new ArrayList<>();

    public Course(String courseCode) {
        this.courseCode = courseCode;
    }

    public Course(String title, String courseCode, int credits, int semester, List<String> prerequisites) {
        this.title = title;
        this.courseCode = courseCode;
        this.credits = credits;
        this.semester = semester;
        this.prerequisites = prerequisites;
    }

    public Course(String title, String courseCode, int credits, int semester) {
        this.title = title;
        this.courseCode = courseCode;
        this.credits = credits;
        this.semester = semester;
    }

    public Course(String title, String courseCode, int credits, int semester, Professor professor, String location, String schedule) {
        this.title = title;
        this.courseCode = courseCode;
        this.credits = credits;
        this.semester = semester;
        this.professor = professor;
        this.location = location;
        this.schedule = schedule;
    }

    public Course(String courseCode, String title, Professor professor, int credits, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.schedule = schedule;
    }

    public  Course(String title, String courseCode, int credits, int semester, Professor professor, String location, String schedule, List<String> prerequisites) {
        this.title = title;
        this.courseCode = courseCode;
        this.credits = credits;
        this.semester = semester;
        this.professor = professor;
        this.location = location;
        this.schedule = schedule;
        this.prerequisites = prerequisites;
    }

    public Course() {

    }

    public List<Feedback<?>> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback<?>> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public String getTitle() {
        return title;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }


    public String getCourseCode() {
        return courseCode;
    }


    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return title + " (" + courseCode + ") - Credits: " + credits + ", Professor: " + (professor != null ? professor.email : "TBD");
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }
}
