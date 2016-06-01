package com.discursive.example.student;

/**
 * Created by gnavin on 5/31/16.
 */
public interface StudentStore {
    public boolean exists(Integer id);
    public Student load(Integer id);
    public Student save(Student p);
}
