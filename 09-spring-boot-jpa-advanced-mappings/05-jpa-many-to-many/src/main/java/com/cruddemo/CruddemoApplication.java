package com.cruddemo;

import com.cruddemo.dao.AppDAO;
import com.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {

			createCourseAndStudents(appDAO);

		};
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course tempCourse = new Course("Biology");

		Student tempStudent1 = new Student("Batuhan", "Akillilar" ,"bakillilar21@gmail.com");
		Student tempStudent2 = new Student("Emre", "Aydin" ,"eaydin17@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving course " + tempCourse);
		System.out.println("Saving students: " + tempCourse.getStudents());

		appDAO.save(tempCourse); //course'u save edince öğrenciler de kaydediliyor cascade sayesinde

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		//will delete reviews too because of cascade type
		int theId = 10;

		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		Course course = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(course);

		System.out.println(course.getReviews());



	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//create a course

		Course tempCourse = new Course("Pacman Course");
		//add some reviews

		tempCourse.addReview(new Review("Great course... loved it"));
		tempCourse.addReview(new Review("It was okay"));
		tempCourse.addReview(new Review("The instructor might be better"));

		//save the course... and leverage the cascade all

		System.out.println("Saving course: " + tempCourse);
		appDAO.save(tempCourse);

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 12;

		appDAO.deleteCourseById(theId);

		System.out.println("Course with id " + theId + " deleted");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 11;
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("Biology");
		appDAO.update(tempCourse);
		System.out.println("Course updated");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 2;

		Instructor tempInstructor = appDAO.findById(theId);

		tempInstructor.setLastName("Tester");
		appDAO.update(tempInstructor);
		System.out.println("Done updating instructor");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 2;
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Associated courses: " + tempInstructor.getCourses());


	}

	private void findCoursesForInstructor(AppDAO appDAO) { //lazy loaded

		int theId = 2;
		Instructor tempInstructor = appDAO.findById(theId);

		//find courses for instructor

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("Found courses: " + tempInstructor.getCourses());


	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 2;
		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("Associated courses with the instructor " + tempInstructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Ahsen","Akillilar","eakillilar16@ku.edu.tr");
		InstructorDetail temInstructorDetail = new InstructorDetail("http://youtube.com", "working");

		tempInstructor.setInstructorDetail(temInstructorDetail);

		//appDAO.save(tempInstructor);

		Course tempCourse = new Course("Guitar Class");
		Course tempCourse2 = new Course("Physic");

		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);


	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 5;
		System.out.println("Deleting the instructor with id " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {

		int theId = 2;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
		System.out.println("Done!!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;

		System.out.println("Delete instructor with id: " + theId);

		appDAO.deleteByID(theId);

		System.out.println("Done!!");

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Find Instructor by ID: " + theId);

		Instructor instructor = appDAO.findById(theId);
		System.out.println("Instructor: " + instructor.toString());
		System.out.println("Instructor Detail: " + instructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Batuhan","Akillilar","bakillilar21@ku.edu.tr");
		InstructorDetail temInstructorDetail = new InstructorDetail("http://", "gaming");

		//Associate the objects
		tempInstructor.setInstructorDetail(temInstructorDetail);

		//save the instructor
		//this will also save teh details object beacuse of cascadetype.all

		appDAO.save(tempInstructor);

		System.out.println("Instructor created");

	}
}
