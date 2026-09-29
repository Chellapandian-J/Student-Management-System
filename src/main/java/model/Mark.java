package model;

public class Mark {

    private int studentId;
    private int subjectId;
    private int marks;

    public Mark(int studentId, int subjectId, int marks) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getMarks() {
        return marks;
    }
}