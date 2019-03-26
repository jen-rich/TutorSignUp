package com.example.choco.tutorsignup;

public class StudentRequests {
    String studentName;
    String subjectName;
    public StudentRequests() {}
    public StudentRequests(String studentName, String subjectName) {
        this.subjectName = subjectName;
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getSubjectName() {
        return subjectName;
    }
}
