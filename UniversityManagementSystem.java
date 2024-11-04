import java.util.List;
import java.util.Scanner;

public class UniversityManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseRegistrationSystem crs = new CourseRegistrationSystem();

        int choice = 0;

        while (choice != 6) {
            System.out.println("IIIT-Delhi Management System");
            System.out.println("   ~Made By- AdityaRai~");

            System.out.println("\n1.Admin Login");
            System.out.println("2.Professor Register");
            System.out.println("3.Student Register");
            System.out.println("4.Professor Login");
            System.out.println("5.Student Login");
            System.out.println("6.Exit");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("Administrator Login");
                System.out.println("Enter User email : ");
                String email = sc.next();
                System.out.println("Enter Password : ");
                String password = sc.next();
                int validUser = crs.administratorLogin(new Administrator(email, password));
                if (validUser == 0) {
                    System.out.println("Invalid Credentials");
                    continue;
                }
                Administrator administrator = crs.getAdministrator(new Administrator(email, password));
                int administratorChoice = 0;

                while (administratorChoice != 10) {

                    System.out.println("1.View Course Catalog");
                    System.out.println("2.Add new Course");
                    System.out.println("3.View Student Records");
                    System.out.println("4.Assign credits to Student Course");
                    System.out.println("5.Update Course Credits");
                    System.out.println("6.Assign Professors to Courses");
                    System.out.println("7.View All Complaints");
                    System.out.println("8.View Pending Complaints");
                    System.out.println("9.Update Complaint Status");
                    System.out.println("10.Logout");
                    administratorChoice = sc.nextInt();
                    if (administratorChoice == 1) {
                        List<Course> courseList = crs.getCourseList();
                        System.out.printf("                     Course Catalog\n");
                        for (int i = 0; i < courseList.size(); i++) {
                            System.out.printf("%-5s %-10s %-35s %-5s %-20s %-20s \n",
                                    (i + 1),
                                    courseList.get(i).getCourseCode(),
                                    courseList.get(i).getTitle(),
                                    courseList.get(i).getCredits(),
                                    courseList.get(i).getProfessor() != null ? courseList.get(i).getProfessor().getName() : "",
                                    courseList.get(i).getSchedule() != null ? courseList.get(i).getSchedule() : ""
                            );
                        }

                    } else if (administratorChoice == 2) {

                        System.out.println("Adding New Course");

                        Course newCourse  = new Course();

                        System.out.println("Enter Course Code : ");
                        String newCourseCode = sc.next();
                        newCourse.setCourseCode(newCourseCode);

                        System.out.println("Enter New Course Title :");
                        String newCourseTitle = sc.next();
                        newCourse.setTitle(newCourseTitle);

                        System.out.println("Enter New Course Credits : ");
                        int newCourseCredits = sc.nextInt();
                        newCourse.setCredits(newCourseCredits);

                        System.out.println("Enter New Course Schedule : ");
                        String newCourseSchedule = sc.next();
                        newCourse.setSchedule(newCourseSchedule);

                        System.out.println("Enter Course Semester : ");
                        int newCourseSemester = sc.nextInt();
                        newCourse.setSemester(newCourseSemester);

                        System.out.println("Enter Course Location : ");
                        String newCourseLocation = sc.next();
                        newCourse.setLocation(newCourseLocation);

                        crs.addNewCourse(newCourse);
                        System.out.println("New Course Added");

                    } else if (administratorChoice == 3) {

                        List<Student> studentList = crs.getStudentList();
                        System.out.printf("                     Student Records \n");
                        for (int i = 0; i < studentList.size(); i++) {
                            System.out.printf("%-5s %-20s %-35s %-20s %-20s\n",
                                    (i + 1),
                                    studentList.get(i).getEmail(),
                                    studentList.get(i).getName(),
                                    studentList.get(i).getComplaintList().toString(),
                                    studentList.get(i).getCourseList().toString()
                            );
                        }

                    } else if (administratorChoice == 4) {

                        List<Student> studentList = crs.getStudentList();
                        System.out.printf("                     Student Records \n");
                        for (int i = 0; i < studentList.size(); i++) {
                            System.out.printf("%-5s %-20s %-35s %-20s %-20s\n",
                                    (i + 1),
                                    studentList.get(i).getEmail(),
                                    studentList.get(i).getName(),
                                    studentList.get(i).getComplaintList().toString(),
                                    studentList.get(i).getCourseList().toString()
                            );
                        }

                        System.out.println("Enter student email :");
                        String studentEmail = sc.next();
                        System.out.println("Enter course code : ");
                        String courseCode  = sc.next();
                        System.out.println("Enter credits student Scored : ");
                        int creditsScored = sc.nextInt();
                        crs.assignStudentCredits(studentEmail,courseCode,creditsScored);
                        System.out.println("Students course credits updated");

                    } else if (administratorChoice == 5) {

                        System.out.println("Enter Course Code to update Credits : ");
                        String courseCode = sc.next();
                        System.out.println("Enter updated Credits : ");
                        int updatedCredits = sc.nextInt();
                        crs.updateCourseCredits(courseCode,updatedCredits);
                        System.out.println("Updated Course Credits ");

                    } else if (administratorChoice == 6) {

                        System.out.println("All Professors Available  ");
                        for (int i = 0; i < crs.professorList.size(); i++) {
                            System.out.printf("%-5s %-20s %-20s %-20s \n",
                                    (i + 1),
                                    crs.professorList.get(i).getEmail(),
                                    crs.professorList.get(i).getName(),
                                    crs.professorList.get(i).getCourses() != null ?  crs.professorList.get(i).getCourses().toString() : ""
                            );
                        }

                        System.out.println();
                        System.out.println();

                        System.out.println("All Courses Available  ");
                        for (int i = 0; i < crs.courseList.size(); i++) {
                            System.out.printf("%-5s %-20s %-20s %-20s \n",
                                    (i + 1),
                                    crs.courseList.get(i).getCourseCode(),
                                    crs.courseList.get(i).getTitle(),
                                    crs.courseList.get(i).getProfessor() != null ? crs.courseList.get(i).getProfessor().getName() : ""
                            );
                        }
                        System.out.println("Enter Professor email : ");
                        String professorEmail = sc.next();
                        System.out.println("Enter Course code to assign : ");
                        String courseCode = sc.next();
                        crs.assignProfessorCourse(professorEmail,courseCode);
                        System.out.println("Course Assigned to Professor ");

                    } else if (administratorChoice == 7) {
                        List<Student> studentList = crs.getStudentList();
                        System.out.printf("                     Complaints Records \n");
                        for(Student student:studentList){
                            if(student.getComplaintList().isEmpty()){
                                continue;
                            }
                            for(Complaint complaint:student.getComplaintList()){
                                System.out.printf("%-10s %-20s %-20s\n",
                                        complaint.getComplaintId(),
                                        complaint.getDescription(),
                                        complaint.getStatus()
                                );
                            }
                        }
                    } else if (administratorChoice ==8 ) {

                        List<Student> studentList = crs.getStudentList();
                        System.out.printf("                     Pending Complaints Records \n");
                        for(Student student:studentList){
                            if(student.getComplaintList().isEmpty()){
                                continue;
                            }
                            for(Complaint complaint:student.getComplaintList()){
                                if(complaint.getStatus().equalsIgnoreCase("pending")){
                                    System.out.printf("%-10s %-20s %-20s\n",
                                            complaint.getComplaintId(),
                                            complaint.getDescription(),
                                            complaint.getStatus()
                                    );
                                }
                            }
                        }

                    } else if (administratorChoice == 9 ) {

                        System.out.println("Complaint Id to update Status : ");
                        int complaintID = sc.nextInt();
                        System.out.println("Enter 1 for Pending and 2 for Resolved");
                        int response = sc.nextInt();
                        crs.updateComplaint(complaintID,response);
                        System.out.println("Complaint Updated");

                    } else {
                        System.out.println("Enter Input to proceed");
                    }
                }
            } else if (choice == 2) {

                System.out.println("Professor Registration");
                System.out.println("Enter Professor Name :");
                String name = sc.next();
                System.out.println("Enter User email : ");
                String email = sc.next();
                System.out.println("Enter Password :: ");
                String password = sc.next();
                Professor professor = new Professor(email,password);
                professor.setName(name);
                crs.addProfessor(professor);

                System.out.println("Professor Registered");
            } else if (choice == 3) {

                System.out.println("Student Registration");
                System.out.println("Enter Student email : ");
                String email = sc.next();
                System.out.println("Enter Password :: ");
                String password = sc.next();
                Student student = new Student(email, password);
                int registerStatus = crs.addStudent(student);
                if (registerStatus == 1) {
                    System.out.println("Student Registered Successfully");
                } else {
                    System.out.println("Student Already Exists");
                }
            }else if (choice == 4){
                System.out.println("Professor Login");
                System.out.println("Enter User email : ");
                String email = sc.next();
                System.out.println("Enter Password : ");
                String password = sc.next();
                int validUser = crs.professorLogin(new Professor(email, password));
                if (validUser == 0) {
                    System.out.println("Invalid Credentials");
                    continue;
                }
                Professor professor = crs.getProfessor(new Professor(email, password));
                int professorChoice = 0;

                while (professorChoice != 12) {

                    System.out.println("1.View My Courses");
                    System.out.println("2.Update Course Title");
                    System.out.println("3.Update Course location");
                    System.out.println("4.Update Course Schedule");
                    System.out.println("5.Update Course Credits");
                    System.out.println("6.Update Enrollment Limit");
                    System.out.println("7.Add Course Prerequisite");
                    System.out.println("8.Remove Course Prerequisite");
                    System.out.println("9.View Enrolled Students");
                    System.out.println("10.View Feedback ");
                    System.out.println("11.Assign TA");
                    System.out.println("12.To Logout");
                    professorChoice = sc.nextInt();
                    if (professorChoice == 1) {

                        System.out.printf("                     Professor Course Catalog\n");
                        for (int i = 0; i < professor.getCourses().size(); i++) {
                            System.out.printf("%-5s %-10s %-10s %-35s %-5s %-10s %-20s %-10s %-30s\n",
                                    (i + 1),
                                    professor.getName(),
                                    professor.getCourses().get(i).getCourseCode(),
                                    professor.getCourses().get(i).getTitle(),
                                    professor.getCourses().get(i).getCredits(),
                                    professor.getCourses().get(i).getLocation(),
                                    professor.getCourses().get(i).getSchedule(),
                                    professor.getCourses().get(i).getEnrollmentLimit(),
                                    professor.getCourses().get(i).getPrerequisites() != null ? professor.getCourses().get(i).getPrerequisites().toString() : ""
                            );
                        }

                    } else if (professorChoice == 2) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter Title to update : ");
                        String courseTitle = sc.next();
                        crs.updateProfessorCourse(professor,courseCode,courseTitle,
                                null,null,null,null,null,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 3) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        String courseUpdate = sc.next();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                courseUpdate,null,null,null,null,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 4) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        String courseUpdate = sc.next();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                null,courseUpdate,null,null,null,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 5) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        Integer courseUpdate = sc.nextInt();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                null,null,courseUpdate,null,null,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 6) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        Integer courseUpdate = sc.nextInt();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                null,null,null,courseUpdate,null,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 7) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        String courseUpdate = sc.next();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                null,null,null,null,courseUpdate,null);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 8) {

                        System.out.println("Enter Course Code  : ");
                        String courseCode = sc.next();
                        System.out.println("Enter to update : ");
                        String courseUpdate = sc.next();
                        crs.updateProfessorCourse(professor,courseCode,null,
                                null,null,null,null,null,courseUpdate);
                        System.out.println("Professor Course updated");

                    } else if (professorChoice == 9) {

                        List<Student> studentList = crs.getProfessorStudents(professor);
                        System.out.printf("                     Professor Students\n");
                        for (int i = 0; i <studentList.size(); i++) {
                            System.out.printf("%-5s %-10s %-10s %-35s\n",
                                    (i + 1),
                                    studentList.get(i).getName(),
                                    studentList.get(i).getEmail(),
                                    studentList.get(i).getSemester()
                            );
                        }

                    } else if(professorChoice == 10){
                        System.out.printf("                     Professor Course Feedback \n");
                        for (int i = 0; i < professor.getCourses().size(); i++) {
                            System.out.printf("%-5s %-10s %-10s %-35s %-30s\n",
                                    (i + 1),
                                    professor.getName(),
                                    professor.getCourses().get(i).getCourseCode(),
                                    professor.getCourses().get(i).getTitle(),
                                    professor.getCourses().get(i).getFeedbackList() != null ? professor.getCourses().get(i).getFeedbackList().toString() : ""
                            );
                        }
                    } else if (professorChoice == 11) {
                        System.out.println("Enter Student Email :");
                        String studentEmail = sc.next();
                        crs.assignTA(professor,studentEmail);
                        System.out.println("TA assigned");
                    } else {
                        System.out.println("Enter Valid Input");
                    }
                }

            }else if (choice == 5) {

                System.out.println("Student Login");
                System.out.println("Enter User email : ");
                String email = sc.next();
                System.out.println("Enter Password : ");
                String password = sc.next();
                int validUser = crs.studentLogin(new Student(email, password));
                try {
                    validUser = crs.studentLogin2(new Student(email, password));
                } catch (InvalidLoginException e) {
                    System.out.println("Login Failed : " + e.getMessage());
                }
                if (validUser == 0) {
                    System.out.println("Inalid Credentials");
                    continue;
                }
                Student student = crs.getStudent(new Student(email, password));
                int studentChoice = 0;

                while (studentChoice != 11) {

                    System.out.println("1.View Available Courses");
                    System.out.println("2.Register For Courses");
                    System.out.println("3.View Schedule");
                    System.out.println("4.Track Academic Progress");
                    System.out.println("5.Drop Courses");
                    System.out.println("6.Submit Complaints");
                    System.out.println("7.View My Complaints");
                    System.out.println("8.Give Feedback");
                    System.out.println("9.View Professor Courses (TA)");
                    System.out.println("10.View Professor Complaints (TA)");
                    System.out.println("11.To Logout");
                    studentChoice = sc.nextInt();

                    if (studentChoice == 1) {

                        List<Course> courseList = crs.getCourseListForSemester(student.getSemester());
                        System.out.println("Available Course List");

                        System.out.printf("%-10s %-10s %-30s %-10s\n", "S.no", "Code", "Title", "Credits");
                        for (int i = 0; i < courseList.size(); i++) {
                            System.out.printf("%-10s %-10s %-30s %-10s\n", (i + 1), courseList.get(i).getCourseCode(),
                                    courseList.get(i).getTitle(), courseList.get(i).getCredits());
                        }

                    } else if (studentChoice == 2) {

                        System.out.println("Enter Course Code to Register : ");
                        String courseCode = sc.next();
                        if (crs.registerCourseForStudent(student, courseCode) == 0) {
                            System.out.println("Course Registered");
                        } else {
                            System.out.println("Failed to register");
                        }

                        try {
                            crs.registerCourseForStudent2(student, courseCode);
                        } catch (CourseFullException e) {
                            System.out.println("Course Full Exception :: " + e.getMessage());
                        }

                    } else if (studentChoice == 3) {

                        List<Course> studentRegisteredCourses = crs.getStudentRegisteredCourses(student);
                        if (studentRegisteredCourses == null || studentRegisteredCourses.isEmpty()) {
                            System.out.println("Register course to view schedule...");
                            continue;
                        }
                        System.out.printf("                     Course Schedule\n");
                        for (int i = 0; i < studentRegisteredCourses.size(); i++) {
                            System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", (i + 1),
                                    studentRegisteredCourses.get(i).getCourseCode(),
                                    studentRegisteredCourses.get(i).getTitle(),
                                    studentRegisteredCourses.get(i).getProfessor() != null ? studentRegisteredCourses.get(i).getProfessor().getName() : "NA",
                                    studentRegisteredCourses.get(i).getLocation(),
                                    studentRegisteredCourses.get(i).getSchedule()
                            );
                        }

                    } else if (studentChoice == 4) {
                        System.out.println("t");
                    } else if (studentChoice == 5) {
                        System.out.println("Enter Course Code you want to drop : ");
                          String droppingCourseCode = sc.next();
                          int status = crs.dropStudentCourse(student,droppingCourseCode);
                          if(status==1){
                            System.out.println("Course Dropped Successfully");
                          }else{
                            System.out.println("Unable to Drop Course");
                          }
                        try {
                            crs.dropStudentCourse2(student, droppingCourseCode);
                        } catch (DropDeadLinePassedException e) {
                            System.out.println("Exception while dropping Course : " + e.getMessage());
                        }
                    } else if (studentChoice == 6) {
                        System.out.println("Enter Complaint : ");
                        String complaint = sc.next();
                        crs.addStudentComplaint(student, complaint);
                        System.out.println("Complaint Submitted");
                    } else if (studentChoice == 7) {
                        List<Complaint> studentComplaintList = crs.getStudentComplaints(student);
                        System.out.printf("                     Student Complaints\n");
                        for (int i = 0; i < studentComplaintList.size(); i++) {
                            System.out.printf("%-5s %-20s %-10s \n",
                                    (i + 1),
                                    studentComplaintList.get(i).getDescription(),
                                    studentComplaintList.get(i).getStatus()
                            );
                        }
                    } else if (studentChoice == 8) {

                        System.out.println("  Student Course Feedback    ");
                        System.out.println("Enter course code to give feedback : ");
                        String courseCode = sc.next();
                        System.out.println("Numeric (1) or Textual (2) feedback? ");
                        int feedbackChoice = sc.nextInt();  // Read the user's choice

                        if (feedbackChoice == 1) {
                            System.out.print("Enter numeric feedback (1-10): ");
                            Integer numericFeedbackValue = sc.nextInt();  // Read numeric input
                            crs.addStudentCourseFeedback(student, courseCode, numericFeedbackValue, null);
                        } else if (feedbackChoice == 2) {
                            System.out.print("Enter textual feedback: ");
                            String textualFeedbackValue = sc.nextLine();  // Read textual input
                            crs.addStudentCourseFeedback(student, courseCode, null, textualFeedbackValue);
                        }
                        System.out.println("Feedback added successfully.");
                    } else if (studentChoice == 9) {

                        Professor professor = crs.getProfessorForTA(student);

                        System.out.printf("                     Professor Course Catalog\n");
                        for (int i = 0; i < professor.getCourses().size(); i++) {
                            System.out.printf("%-5s %-10s %-10s %-35s %-5s %-10s %-20s %-10s %-30s\n",
                                    (i + 1),
                                    professor.getName(),
                                    professor.getCourses().get(i).getCourseCode(),
                                    professor.getCourses().get(i).getTitle(),
                                    professor.getCourses().get(i).getCredits(),
                                    professor.getCourses().get(i).getLocation(),
                                    professor.getCourses().get(i).getSchedule(),
                                    professor.getCourses().get(i).getEnrollmentLimit(),
                                    professor.getCourses().get(i).getPrerequisites() != null ? professor.getCourses().get(i).getPrerequisites().toString() : ""
                            );
                        }

                    } else if (studentChoice == 10) {

                        Professor professor = crs.getProfessorForTA(student);

                        System.out.printf("                     Professor Course Feedback \n");
                        for (int i = 0; i < professor.getCourses().size(); i++) {
                            System.out.printf("%-5s %-10s %-10s %-35s %-30s\n",
                                    (i + 1),
                                    professor.getName(),
                                    professor.getCourses().get(i).getCourseCode(),
                                    professor.getCourses().get(i).getTitle(),
                                    professor.getCourses().get(i).getFeedbackList() != null ? professor.getCourses().get(i).getFeedbackList().toString() : ""
                            );
                        }

                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            }

        }

    }
}