

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CourseRegistrationSystem {

    public List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student("student1","student1","password1"),
                    new Student("student2","student2","password2")
            )
    );

    public List<Professor> professorList = new ArrayList<>(

            Arrays.asList(
                    new Professor("prof1","prof1","password1"),
                    new Professor("prof2","prof2","password2"),
                    new Professor("prof3","prof3","password3")));

    public Administrator administrator = new Administrator("aditya","aditya");

    public List<Course> courseList = new ArrayList<>(Arrays.asList(

            new Course("LA","MTH100",4,1,
                    professorList.get(0),"Building 1","Monday 10:00AM to 11:00AM"),
            new Course("DC","ECE100",4,1,
                    professorList.get(1),"Building 1","Tuesday 02:00PM to 04:00PM"),
            new Course("HCI","DES100",4,1,
                    professorList.get(2),"Building 1","Tuesday 02:00PM to 04:00PM"),
            new Course("IP","CSE101",4,1,
                    professorList.get(0),"Building 1","Tuesday 02:00PM to 04:00PM"),
            new Course("AP","CSE201",4,3,
                    professorList.get(0),"Building 1","Tuesday 02:00PM to 04:00PM",
                    Arrays.asList("CSE101","CSE102")),
            new Course("BE","ECE201",4,1),
            new Course("DSA","CSE102",4,2, List.of("CSE101")))

    );


    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int addStudent(Student registerStudent){
        for (Student student:studentList){
            if(student.getEmail().equals(registerStudent.getEmail())){
                return 0;
            }
        }
        this.studentList.add(registerStudent);
        return 1;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addProfessor(Professor professor){
        this.professorList.add(professor);
    }
    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public int studentLogin(Student loggingStudent) {

        for(Student student : studentList){
            if (student.getEmail().equals(loggingStudent.getEmail()) && student.getPassword().equals(loggingStudent.getPassword())) {
                return 1;
            }
        }
        return 0;

    }

    public int studentLogin2(Student loggingStudent) throws InvalidLoginException {

        for(Student student : studentList){
            if (student.getEmail().equals(loggingStudent.getEmail()) && student.getPassword().equals(loggingStudent.getPassword())) {
                return 1;
            }
        }
        throw new InvalidLoginException("Invalid User Credentials");
    }

    public boolean checkStudentLogin(Student loggingStudent) throws InvalidLoginException {
        for(Student student : studentList){
            if (student.getEmail().equals(loggingStudent.getEmail()) && student.getPassword().equals(loggingStudent.getPassword())) {
                return true;
            }
        }
        throw new InvalidLoginException("Invalid User Credentials");
    }
    public Student getStudent(Student loggingStudent) {

        for(Student student : studentList){
            if (student.getEmail().equals(loggingStudent.getEmail()) && student.getPassword().equals(loggingStudent.getPassword())) {
                return student;
            }
        }
        return null;

    }


    public List<Course> getCourseListForSemester(int semester){

        List<Course> courses = new ArrayList<>();
        for(Course course:courseList){
            if(course.getSemester() == semester){
                courses.add(course);
            }
        }
        return courses;
    }

    public Course getCourseByCourseCode(String courseCode){

        for(Course course:courseList){
            if(course.getCourseCode().equalsIgnoreCase(courseCode)){
                return course;
            }
        }
        return null;

    }
    public int registerCourseForStudent(Student student,String courseCode){

        // check whether course is in the current student semester or not
        // check if student has passed all previous semesters to register for this course
        // check for prerequisites course completion
        if(getCourseByCourseCode(courseCode) == null){
            return -1;
        }
        Course course = getCourseByCourseCode(courseCode);
        if(student.getSemester() != course.getSemester()){
            return -1;
        }

        Course registerCourse = new Course();
        registerCourse.setCourseCode(course.getCourseCode());
        registerCourse.setTitle(course.getTitle());
        registerCourse.setSemester(course.getSemester());

        if(course.getProfessor() != null){
            registerCourse.setProfessor(course.getProfessor());
        }

        student.getCourseList().add(registerCourse);

        return 0;

    }

    public void registerCourseForStudent2(Student student,String courseCode) throws CourseFullException{
        Course course = getCourseByCourseCode(courseCode);
        int enrolledStudents = 0;
        for(Student student1:studentList){
            for(Course course1:student.getCourseList()){
                if(course1.getCourseCode().equalsIgnoreCase(courseCode)){
                    enrolledStudents++;
                }
            }
        }
        if(enrolledStudents >= course.getEnrollmentLimit()){
            throw new CourseFullException("Course got Fulled.");
        }
        registerCourseForStudent(student,courseCode);
    }

    public List<Course> getStudentRegisteredCourses(Student student){

        return student.getCourseList();
    }

    public int dropStudentCourse(Student student,String droppingCourseCode){

        List<Course> updatedCourses = new ArrayList<>();
        int isDroppedCourse = 0;
        for(Course course:student.getCourseList()){
            if(course.getCourseCode().equalsIgnoreCase(droppingCourseCode)){
                isDroppedCourse = 1;
            }else{
                updatedCourses.add(course);
            }
        }
        student.setCourseList(updatedCourses);
        return isDroppedCourse;
    }

    public void dropStudentCourse2(Student student,String droppingCourseCode) throws DropDeadLinePassedException {

        List<Course> updatedCourses = new ArrayList<>();
        int isDroppedCourse = 0;
        for(Course course:student.getCourseList()){
            if(course.getCourseCode().equalsIgnoreCase(droppingCourseCode)){
                isDroppedCourse = 1;
            }else{
                updatedCourses.add(course);
            }
        }
        student.setCourseList(updatedCourses);
        if(isDroppedCourse==0){
            throw  new DropDeadLinePassedException("Course drop exception");
        }
    }

    public void addStudentComplaint(Student student,String complaintDescription){

        List<Complaint> complaintList = student.getComplaintList();
        complaintList.add(new Complaint(complaintDescription));
        student.setComplaintList(complaintList);

    }

    public List<Complaint> getStudentComplaints(Student student){
        return student.getComplaintList();
    }

    public int professorLogin(Professor professorLogin){

        for(Professor professor: professorList){
            if (professor.getEmail().equalsIgnoreCase(professorLogin.getEmail()) && professorLogin.getPassword().equals(professorLogin.getPassword())) {
                return 1;
            }
        }
        return 0;
    }


    public Professor getProfessor(Professor loggingProfessor) {

        for(Professor professor: professorList){
            if (professor.getEmail().equals(loggingProfessor.getEmail()) && professor.getPassword().equals(loggingProfessor.getPassword())) {
                return professor;
            }
        }
        return null;
    }

    public int administratorLogin(Administrator administrator){
        if(this.administrator.getEmail().equalsIgnoreCase(administrator.getEmail()) && this.administrator.getPassword().equals(administrator.getPassword())){
            return 1;
        }
        return 0;
    }

    public Administrator getAdministrator(Administrator administrator) {
        if(this.administrator.getEmail().equalsIgnoreCase(administrator.getEmail()) && this.administrator.getPassword().equals(administrator.getPassword())){
            return administrator;
        }
        return null;
    }

    public void addNewCourse(Course course){
        courseList.add(course);
    }

    public void updateComplaint(int complaintID,int response){
        for(Student student:studentList){
            if(student.getComplaintList().isEmpty()){
                continue;
            }
            for(Complaint complaint:student.getComplaintList()){
                if(complaint.getComplaintId() == complaintID){
                    if(response == 1){
                        complaint.setStatus("Pending");
                    } else if (response == 2) {
                        complaint.setStatus("Resolved");
                    }
                }
            }
        }
    }

    public void updateCourseCredits(String courseCode,int updatedCredits){
        for(Course course:courseList){
            if(course.getCourseCode().equalsIgnoreCase(courseCode)){
                course.setCredits(updatedCredits);
            }
        }
    }
    public void assignStudentCredits(String studentEmail,String courseCode,int scoredCredits){
        for(Student student:studentList){
            if(student.getCourseList().isEmpty()){
                continue;
            }
            for(Course course : student.getCourseList()){
                if(course.getCourseCode().equalsIgnoreCase(courseCode)){
                    course.setCredits(scoredCredits);
                    return;
                }
            }
        }
    }
    public  void assignProfessorCourse(String professorEmail,String courseCode){

        Professor professor = null;
        Course course = null;

        for(Professor professorIterator:professorList){
            if(professorIterator.getEmail().equalsIgnoreCase(professorEmail)){
                professor = professorIterator;
                break;
            }
        }

        for(Course courseIterator : courseList){
            if(courseIterator.getCourseCode().equalsIgnoreCase(courseCode)){
                course = courseIterator;
                break;
            }
        }

        if(professor != null && professor.getCourses() == null){
            professor.setCourses(Collections.singletonList(course));
        }else{
            List<Course> existingCourse = null;
            if(professor.getCourses() == null){
                existingCourse = new ArrayList<>();
            }else{
                existingCourse = professor.getCourses();
            }
            existingCourse.add(course);
            professor.setCourses(existingCourse);
        }

        if(course!= null){
            course.setProfessor(professor);
        }
    }

    public List<Student> getProfessorStudents(Professor professor){
        if(professor== null){
            return  new ArrayList<>();
        }
        List<Student> professorStudentList = new ArrayList<>();
        for(Course course:professor.getCourses()){
            professorStudentList.addAll(course.getEnrolledStudents());
        }
        return professorStudentList;
    }

    public  void updateProfessorCourse(Professor professor,String courseCode,String courseTitle,String courseLocation,
                                       String courseSchedule,Integer courseCredits,Integer courseEnrollmentLimit,
                                       String addCoursePrerequisite,String removeCoursePrerequisite){

        Course course = getCourseByCourseCode(courseCode);

        if(course == null){
            return;
        }

        if(courseTitle != null){
            course.setTitle(courseTitle);
        }

        if(courseLocation != null){
            course.setLocation(courseLocation);
        }

        if(courseSchedule!= null){
            course.setSchedule(courseSchedule);
        }

        if(courseCredits != null){
            course.setCredits(courseCredits);
        }

        if(courseEnrollmentLimit != null){
            course.setEnrollmentLimit(courseEnrollmentLimit);
        }

        if(addCoursePrerequisite != null && getCourseByCourseCode(addCoursePrerequisite) != null){

            if(course.getPrerequisites() == null){
                List<String> courses  = new ArrayList<>();
                courses.add(addCoursePrerequisite);
                course.setPrerequisites(courses);
            } else if(course.getPrerequisites() != null &&  !course.getPrerequisites().contains(courseCode)){
                List<String> pre = new ArrayList<>();
                pre = course.getPrerequisites();
                pre.add(courseCode);
                course.setPrerequisites(pre);
            }
        }

        if(removeCoursePrerequisite != null && getCourseByCourseCode(removeCoursePrerequisite) != null){

            if(course.getPrerequisites() != null){
                course.getPrerequisites().remove(courseCode);
            }
        }
    }

    public void assignTA(Professor professor,String studentEmail){

        for(Professor professor1: professorList){
            if(professor.getEmail().equalsIgnoreCase(professor1.getEmail())){
                for(Student student:studentList){
                    if(student.getEmail().equalsIgnoreCase(studentEmail)){
                        professor1.setTeachingAssistant(student);
                        student.setTeachingAssistantProfessorEmail(professor1.getEmail());
                    }
                }
            }
        }
    }

    public void addStudentCourseFeedback(Student student,String courseCode,Integer numericFeedbackValue,String textualFeedbackValue){

        for(Course course:student.getCourseList()){
            if(course.getCourseCode().equalsIgnoreCase(courseCode)){

                if(numericFeedbackValue!= null){

                    Feedback<?> feedback = new Feedback<>(numericFeedbackValue);
                    List<Feedback<?>> feedbackList = course.getFeedbackList();
                    feedbackList.add(feedback);
                    course.setFeedbackList(feedbackList);
                } else if (textualFeedbackValue != null) {

                    Feedback<?> feedback = new Feedback<>(textualFeedbackValue);
                    List<Feedback<?>> feedbackList = course.getFeedbackList();
                    feedbackList.add(feedback);
                    course.setFeedbackList(feedbackList);
                }
            }
        }
    }

    public Professor getProfessorByMail(String mail){
        for(Professor professor:professorList){
            if(professor.getEmail().equalsIgnoreCase(mail)){
                return professor;
            }
        }
        return null;
    }

    public Student getStudentByMail(String mail){
        for(Student student:studentList){
            if(student.getEmail().equalsIgnoreCase(mail)){
                return student;
            }
        }
        return null;
    }

    public Professor getProfessorForTA(Student student){

        return getProfessorByMail(student.getTeachingAssistantProfessorEmail());

    }
}
