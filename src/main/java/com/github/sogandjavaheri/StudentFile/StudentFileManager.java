package com.github.sogandjavaheri.StudentFile;


import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StudentFileManager {
    private static final String fileName = "student.dat";

    public void writeStudent(StudentFile s) {
        try (FileOutputStream out = new FileOutputStream(fileName, true)) {
            writeString(out, s.firstName);
            writeString(out, s.lastName);
            out.write(s.grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readStudents() {
        try (FileInputStream in = new FileInputStream(fileName)) {
            while (in.available() > 0) {
                String firstName = readString(in);
                String lastName = readString(in);
                int grade = in.read();
                System.out.println(firstName + " " + lastName + " - Grade: " + grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeString(FileOutputStream out, String str) throws Exception {
        byte[] bytes = str.getBytes();
        out.write(bytes.length); // write length
        out.write(bytes);        // write string
    }

    private String readString(FileInputStream in) throws Exception {
        int length = in.read();
        byte[] bytes = new byte[length];
        in.read(bytes);
        return new String(bytes);
    }

}

