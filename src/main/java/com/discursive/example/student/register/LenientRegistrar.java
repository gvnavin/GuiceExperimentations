package com.discursive.example.student.register;

import com.discursive.example.student.Registrar;
import com.discursive.example.student.Student;
import com.discursive.example.student.StudentStore;
import com.google.inject.Inject;

/**
 * Created by gnavin on 5/31/16.
 */
public class LenientRegistrar implements Registrar {
    private final StudentStore studentStore;

    @Inject
    public LenientRegistrar(StudentStore studentStore) {
        this.studentStore = studentStore;
    }

    public boolean checkStudentStatus(Integer studentId) {
        boolean status = false;

        Student student = studentStore.load( studentId );

        if( student != null && student.getCredits() != null ) {
            status = student.getCredits() >= 10.0;
        }
        return status;

    }

    public Student registerStudent(String name, Integer credits) {
        Student s = new Student();
        s.setName( name );
        s.setCredits( credits );
        return studentStore.save( s );
    }
}
