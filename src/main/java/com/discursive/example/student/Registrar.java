package com.discursive.example.student;

/**
 * Created by gnavin on 5/31/16.
 */
public interface Registrar {
    public boolean checkStudentStatus( Integer studentId );
    public Student registerStudent( String name, Integer credits );
}
