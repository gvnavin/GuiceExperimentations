package com.discursive.example.student.store;

import com.discursive.example.student.Student;
import com.discursive.example.student.StudentStore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnavin on 5/31/16.
 */
public class DummyStudentStore implements StudentStore {
    private final Map<Integer,Student> studentMap;

    public DummyStudentStore() {
        studentMap = new HashMap<Integer, Student>();
    }

    public boolean exists(Integer id) {
        return studentMap.containsKey( id );
    }

    public Student load(Integer id) {
        Student s = studentMap.get(id);
        return s;
    }

    public Student save(Student p) {
        if( p.getId() == null ) {
            p.setId( studentMap.size() + 1 );
        }
        studentMap.put( p.getId(), p );
        return p;
    }

}
