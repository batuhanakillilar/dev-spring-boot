package com.cruddemo.dao;

import com.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteByID(int theId);
}
