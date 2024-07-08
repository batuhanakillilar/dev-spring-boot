package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {

			//createStudent(studentDao);

			createMultipleStudent(studentDao);

			//readStudent(studentDao);

			//queryForStudents(studentDao);

			//queryForStudentsByLastName(studentDao);

			//updateStudent(studentDao);

			//deleteStudent(studentDao);

			//deleteAllStuds(studentDao);




		};
	}

	private void deleteAllStuds(StudentDao studentDao) {

		System.out.println("Deleting all student data");
		int count = studentDao.deleteAll();
		System.out.println("Deleted " + count + " student data");
	}

	private void deleteStudent(StudentDao studentDao) {

		int studId = 3;
		System.out.println("Deleting student: " + studId);
		studentDao.delete(studId);
	}

	private void updateStudent(StudentDao studentDao) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student...");
		Student myStudent = studentDao.findById(studentId);

		// change first name to "Scooby"

		myStudent.setFirstName("Scooby");
		//update the student
		studentDao.update(myStudent);

		//display the updated student

		System.out.println("Updated Student: " + myStudent);


	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		//get a list of students
		List<Student> students = studentDao.findByLastName("Akillilar");

		//display the list
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		List<Student> theStudents = studentDao.findAll();

		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {

		// create a student object
		Student tempstudent1 = new Student("Berke","Ilknur","berke@gmail.com");

		//save the student
		System.out.println("Saving student: " + tempstudent1.getFirstName());
		//StudentDao.save(tempstudent1);

		// display the id

		int theId = tempstudent1.getId();
		System.out.println("Saving student: " + theId);

		//retrieve the student based on id: primary key

		//Student myStud = StudentDao.findById(theId);

		// display student
	}

	private void createMultipleStudent(StudentDao studentDao) {

		System.out.println("Creating multiple students");
		Student tempstudent1 = new Student("Berke","Ilknur","berke@gmail.com");
		Student tempstudent2 = new Student("Batuhan","Akillilar","batu@gmail.com");
		Student tempstudent3 = new Student("Eren","Muslu","eren@gmail.com");

		System.out.println("Saving the students...");
		studentDao.save(tempstudent1);
		studentDao.save(tempstudent2);
		studentDao.save(tempstudent3);


	}

	private void createStudent(StudentDao studentDao) {

		//Create the object
		System.out.println("Creating new student object");
		Student tempstudent = new Student("Paul","Doe","Paul@gmail.com");

		//Save the student object
		System.out.println("Student object saved");
		studentDao.save(tempstudent);

		//Display the Id of the saved student
		System.out.println("Saved student. Generated Id: " + tempstudent.getId());

	}


}
