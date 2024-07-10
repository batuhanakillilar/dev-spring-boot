package com.cruddemo.dao;

import com.cruddemo.entity.Instructor;
import com.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    //define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor); //save the instructor
    }

    @Override
    public Instructor findById(int theId) {

        return entityManager.find(Instructor.class, theId);

    }

    @Override
    @Transactional
    public void deleteByID(int theId) {

        entityManager.remove(entityManager.find(Instructor.class, theId));

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, theId);

       theInstructorDetail.getInstructor().setInstructorDetail(null);

        //remove the associated object reference

        entityManager.remove(theInstructorDetail);
    }

}
