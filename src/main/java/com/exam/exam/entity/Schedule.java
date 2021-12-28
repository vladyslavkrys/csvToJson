package com.exam.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;

public class Schedule {

    @CsvBindByName
    private String subject;
    @CsvDate(value = "dd.MM.yyyy HH:mm")
    @CsvBindByName
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime startTime;
    @CsvDate(value = "dd.MM.yyyy HH:mm")
    @CsvBindByName
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime endTime;
    @CsvBindByName
    private int classRoom;
    @CsvBindByName
    private String teacher;

    public Schedule() {
    }

    public Schedule(String subject, LocalDateTime startDate, LocalDateTime endTime, int classRoom, String teacher) {
        this.subject = subject;
        this.startTime = startDate;
        this.endTime = endTime;
        this.classRoom = classRoom;
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "subject='" + subject + '\'' +
                ", startDate=" + startTime +
                ", endTime=" + endTime +
                ", classRoom=" + classRoom +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}