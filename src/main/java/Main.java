import java.time.LocalDate;
import java.util.Scanner;

import dao.AttendanceDAO;
import dao.MarkDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import model.Attendance;
import model.Mark;
import model.Student;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        MarkDAO markDAO = new MarkDAO();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Mark Attendance");
            System.out.println("6. View Attendance");
            System.out.println("7. View Attendance Percentage");
            System.out.println("8. Add Marks");
            System.out.println("9. View Student Marks");
            System.out.println("10. View Subjects");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // =========================
                // 1. ADD STUDENT
                // =========================
                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter year of study: ");
                    int year = scanner.nextInt();

                    Student student =
                            new Student(
                                    name,
                                    email,
                                    department,
                                    year
                            );

                    studentDAO.addStudent(student);

                    break;


                // =========================
                // 2. VIEW STUDENTS
                // =========================
                case 2:

                    System.out.println("\n===== All Students =====");

                    studentDAO.getAllStudents();

                    break;


                // =========================
                // 3. UPDATE STUDENT
                // =========================
                case 3:

                    System.out.print("Enter student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter new year: ");
                    int newYear = scanner.nextInt();

                    studentDAO.updateStudent(
                            updateId,
                            newName,
                            newEmail,
                            newDepartment,
                            newYear
                    );

                    break;


                // =========================
                // 4. DELETE STUDENT
                // =========================
                case 4:

                    System.out.print("Enter student ID: ");
                    int deleteId = scanner.nextInt();

                    studentDAO.deleteStudent(deleteId);

                    break;


                // =========================
                // 5. MARK ATTENDANCE
                // =========================
                case 5:

                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print(
                            "Enter status (Present/Absent): "
                    );

                    String status = scanner.nextLine();

                    Attendance attendance =
                            new Attendance(
                                    studentId,
                                    LocalDate.now(),
                                    status
                            );

                    attendanceDAO.markAttendance(attendance);

                    break;


                // =========================
                // 6. VIEW ATTENDANCE
                // =========================
                case 6:

                    System.out.print("Enter student ID: ");
                    int attendanceStudentId = scanner.nextInt();

                    System.out.println(
                            "\n===== Attendance ====="
                    );

                    attendanceDAO.viewAttendance(
                            attendanceStudentId
                    );

                    break;


                // =========================
                // 7. ATTENDANCE PERCENTAGE
                // =========================
                case 7:

                    System.out.print("Enter student ID: ");
                    int percentageStudentId = scanner.nextInt();

                    System.out.println(
                            "\n===== Attendance Percentage ====="
                    );

                    attendanceDAO.getAttendancePercentage(
                            percentageStudentId
                    );

                    break;


                // =========================
                // 8. ADD MARKS
                // =========================
                case 8:

                    System.out.print("Enter student ID: ");
                    int markStudentId = scanner.nextInt();

                    System.out.print("Enter subject ID: ");
                    int subjectId = scanner.nextInt();

                    System.out.print("Enter marks: ");
                    int marks = scanner.nextInt();

                    // Validate marks
                    if (marks < 0 || marks > 100) {

                        System.out.println(
                                "Marks must be between 0 and 100."
                        );

                        break;
                    }

                    Mark mark =
                            new Mark(
                                    markStudentId,
                                    subjectId,
                                    marks
                            );

                    markDAO.addMark(mark);

                    break;


                // =========================
                // 9. VIEW STUDENT MARKS
                // =========================
                case 9:

                    System.out.print("Enter student ID: ");
                    int marksStudentId = scanner.nextInt();

                    System.out.println(
                            "\n===== Student Marks ====="
                    );

                    markDAO.viewStudentMarks(
                            marksStudentId
                    );

                    break;


                // =========================
                // 10. VIEW SUBJECTS
                // =========================
                case 10:

                    subjectDAO.getAllSubjects();

                    break;


                // =========================
                // 11. EXIT
                // =========================
                case 11:

                    System.out.println("Exiting...");

                    scanner.close();

                    return;


                // =========================
                // INVALID CHOICE
                // =========================
                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }
}