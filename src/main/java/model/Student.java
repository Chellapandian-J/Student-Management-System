package model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String department;
    private int yearOfStudy;

    public Student(int studentId, String name, String email,
                   String department, int yearOfStudy) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
    }

    public Student(String name, String email,
                   String department, int yearOfStudy) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
}