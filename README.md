# University Management System

## Introduction
The University Management System is a comprehensive Java-based application built using Object-Oriented Programming (OOP) principles. It provides core university functions, including managing courses, student registration, grading, and feedback. The system supports multiple user roles:

- **Students**: Can view and register for courses, drop courses, track academic progress, and submit complaints.
- **Professors**: Manage course details, update course content, and view enrolled students.
- **Administrators**: Manage courses and student records, assign professors, and resolve complaints.
- **Teaching Assistants (TAs)**: Support professors with grade administration and have limited access to course management.

The project adheres to OOP principles, including encapsulation, inheritance, polymorphism, and abstraction, making the codebase modular and maintainable.

---

## How to Execute the Code
1. **Run the Main Class**: Right-click on the `UniversityManagementSystem` class (containing the `main` method) and select "Run" to launch the console-based interface.
2. **Login**: Use the default credentials provided below for demonstration purposes:

### Default Credentials
#### Admin
- Username: `aditya`
- Password: `aditya`

#### Professors
- Username: `prof1`, Password: `password1`
- Username: `prof2`, Password: `password2`

#### Students
- Username: `student1`, Password: `password1`
- Username: `student2`, Password: `password2`
- Username: `student3`, Password: `password3`

---

## System Functionalities

### Student Functionalities
- **View Available Courses**: Display all open courses with details like code, title, instructor, credits, prerequisites, and timings.
- **Add Courses**: Register for courses if prerequisites are met and within the 20-credit hour limit.
- **Drop Courses**: Remove a course from the current semester.
- **View Weekly Schedule**: Display the weekly schedule with timings and locations.
- **Track Academic Progress**: View completed courses, grades, and calculate SGPA/CGPA.
- **Raise Complaints**: Submit issues for admin resolution.

### Professor Functionalities
- **Course Management**: Update course information such as syllabus, timings, and prerequisites.
- **View Enrolled Students**: Access student lists, grades, and contact information.

### Admin Functionalities
- **Manage Course Catalog**: Add, delete, and update courses.
- **Manage Student Records**: Update student data and grades.
- **Assign Professors**: Assign professors to courses based on expertise.
- **Resolve Complaints**: Address and mark complaints as resolved.

### Teaching Assistant Functionalities
- **Course Enrollment**: Enroll in courses as a student.
- **Grade Administration**: Assist professors with grading.
- **Limited Privileges**: Cannot modify course details.

---

## Enhancements and New Features

### Generic Feedback System
- Allows students to provide numeric and textual feedback for completed courses.
- Implements type-safe generic programming for flexibility.

### Enhanced Role Management
- Introduces Teaching Assistants as a new role with hybrid student-professor functionality.

### Robust Exception Handling
- **InvalidLoginException**: Handles incorrect login attempts.
- **CourseFullException**: Prevents registration beyond course capacity.
- **DropDeadlinePassedException**: Blocks course drops after the deadline.

---

## OOP Concepts Demonstrated
1. **Encapsulation**: Private fields with public getters/setters for data protection.
2. **Inheritance**: 
   - `Student`, `Professor`, and `Admin` inherit from `User`.
   - `Teaching Assistant` inherits from `Student` with additional privileges.
3. **Polymorphism**: 
   - Overriding `login()` in `Student`, `Professor`, `Admin`, and `TA`.
   - Dynamic method dispatch for user-specific actions.
4. **Abstraction**: High-level user actions hide implementation details.
5. **Association**: Relationships between `Student` and `Course`.
6. **Aggregation**: `Course` references `Professor` and `Student` objects without owning them.
7. **Generic Programming**: Type-safe feedback system.

---

## Demonstration Instructions
1. **Admin Actions**:
   - Login with username: `aditya`, password: `aditya`.
   - Create professors (`prof1`, `prof2`) and students (`student1`, `student2`, `student3`).
   - Add courses (Mathematics, Physics, Computer Science, English, Chemistry).
   - Assign professors to courses and resolve complaints.

2. **Professor Actions**:
   - Login as `prof1`.
   - Update course details for assigned courses.
   - View enrolled students and assign grades.

3. **Student Actions**:
   - Login as `student1`.
   - Enroll in courses and view the weekly schedule.
   - Submit a complaint and view grades after professors have updated them.

---

## Conclusion
This advanced University Management System effectively demonstrates core and advanced OOP concepts, including generic programming and exception handling. The system is robust, user-friendly, and scalable for future enhancements.
