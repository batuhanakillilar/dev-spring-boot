package com.cruddemo.dao;

import com.cruddemo.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        //delete only instructor not the associated courses
        Instructor theInstructor = entityManager.find(Instructor.class, theId);

        List<Course> theCourses = theInstructor.getCourses();

        for (Course theCourse : theCourses) {
            theCourse.setInstructor(null);
        }

        entityManager.remove(theInstructor);


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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                    "from Course where instructor.id = :data", Course.class);

        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        //join fetch kullanınca eager fetch kullanır gibi ikisini de alıyoruz
        //create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                    "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                            +"JOIN FETCH i.instructorDetail "
                            + "where i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();

        return instructor;

    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {

        entityManager.merge(theInstructor);


    }

    @Override
    @Transactional
    public void update(Course tempCourse) {

        entityManager.merge(tempCourse);

    }

    @Override
    public Course findCourseById(int theId) {

        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        entityManager.remove(entityManager.find(Course.class, theId));
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);

    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        //create the query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class);
        query.setParameter("data",theId);

        // execute query

        Course course = query.getSingleResult();
        return course;

    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);
        query.setParameter("data",theId);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {

        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class);
        query.setParameter("data",theId);

        Student stud = query.getSingleResult();

        return stud;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

}
