package com.example.hqtqlsv.Model;

public class StudentForShow {
    private static Student student;

    public static void setStudent(Student student) {
        StudentForShow.student = student;
    }

    public static Student getStudent() {
        return student;
    }
}
