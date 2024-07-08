package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //Implement save method
    @Transactional //add this annotation since we are making an update on the database
    @Override
    public void save(Student theStudent) {

        entityManager.persist(theStudent); // saves the student to the database

    }

    @Override
    public Student findById(Integer Id) {

        return entityManager.find(Student.class, Id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        //return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastname) {

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);
        // set query parameter

        theQuery.setParameter("theData", lastname);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
        //delete the student

        entityManager.remove(theStudent);





    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRows;
    }
}
