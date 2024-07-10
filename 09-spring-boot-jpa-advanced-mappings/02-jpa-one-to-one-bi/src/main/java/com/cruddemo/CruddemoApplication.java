package com.cruddemo;

import com.cruddemo.dao.AppDAO;
import com.cruddemo.entity.Instructor;
import com.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetailById(appDAO);
			deleteInstructorDetail(appDAO);


		};
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

		int theId = 1;

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
