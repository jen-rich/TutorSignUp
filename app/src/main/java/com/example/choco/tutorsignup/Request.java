package com.example.choco.tutorsignup;

public class Request {
    //All strings since they go into a document-based JSON file
    String teacherName;
    String studentName;
    String subject;
    String room;
    String date;
    String time;

    public Request(String studentName, String subject) {
        this.studentName = studentName;
        this.subject = subject;
    }
    public Request(String teacherName, String subject, String room, String date, String time) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.room = room;
        this.date = date;
        this.time = time;
    }
}
