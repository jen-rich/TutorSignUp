package com.example.choco.tutorsignup;

public class Request {
    //All strings since they go into a document-based JSON file
    String teacherName;
    String subject;
    String room;
    String availability;
    String tutors;
    String date;
    String time;
    String tutorsNeeded;

    public Request() { }
    public Request(String teacherName, String subject, String room, String availability, String date, String time, String tutorsNeeded) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.room = room;
        this.availability = availability;
        this.tutors = tutors;
        this.date = date;
        this.time = time;
        this.tutorsNeeded = tutorsNeeded;
    }
}
