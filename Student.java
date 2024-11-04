

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student extends User {
    public int semester = 1; // by default student will be in 1st semester
    public List<Course> courseList = new ArrayList<>();

    public String teachingAssistantProfessorEmail;

    public List<Complaint> complaintList = new ArrayList<>();

    public Student(String email, String password) {
        super(email, password);
    }

    public Student(String name,String email, String password) {
        super(name,email, password);
    }


    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public String getTeachingAssistantProfessorEmail() {
        return teachingAssistantProfessorEmail;
    }

    public void setTeachingAssistantProfessorEmail(String teachingAssistantProfessorEmail) {
        this.teachingAssistantProfessorEmail = teachingAssistantProfessorEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "semester=" + semester +
                ", courseList=" + courseList +
                ", teachingAssistantProfessorEmail='" + teachingAssistantProfessorEmail + '\'' +
                ", complaintList=" + complaintList +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
