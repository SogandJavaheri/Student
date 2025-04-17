package com.github.sogandjavaheri.StudentFile;



public class StudentFileTest {
    public static void main(String[] args) {
        StudentFileManager manager = new StudentFileManager();

        StudentFile s1 = new StudentFile("Anna", "Lee", 50);
        StudentFile s2 = new StudentFile("Tom", "White", 83);

        manager.writeStudent(s1);
        manager.writeStudent(s2);

        System.out.println("Students read from file:");
        manager.readStudents();
    }
}


