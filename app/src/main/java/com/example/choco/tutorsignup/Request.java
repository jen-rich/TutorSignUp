package com.example.choco.tutorsignup;

public class Request {
    //All strings since they go into a document-based JSON file
    String teacherName;
    String subject;
    String room;
    String availability;
    String tutors;
    String startDate;
    String endDate;
    String time;
    String tutorsNeeded;

    public Request() { }
    public Request(String teacherName, String subject, String room, String availability, String startDate, String endDate, String time, String tutorsNeeded) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.room = room;
        this.availability = availability;
        this.tutors = tutors;
        this.startDate = startDate;
        this.time = time;
        this.tutorsNeeded = tutorsNeeded;
    }
}
