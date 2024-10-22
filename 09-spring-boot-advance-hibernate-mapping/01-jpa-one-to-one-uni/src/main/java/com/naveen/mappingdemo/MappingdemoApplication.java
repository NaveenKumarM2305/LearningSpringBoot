package com.naveen.mappingdemo;

import com.naveen.mappingdemo.entity.Instructor;
import com.naveen.mappingdemo.entity.InstructorDetail;
import com.naveen.mappingdemo.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{

//				createInstructor(appDAO);

//				findInstructorById(appDAO);

				deleteInstructorById(appDAO);
		};
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId=2;
		appDAO.delete(theId);
		System.out.println("Deleted Insturctor: "+theId);
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId=2;
		Instructor instructor = appDAO.find(theId);
		System.out.println("Instructor : "+instructor);
		System.out.println("Instrucor Details: "+instructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		// Create instance of both instructor and instructordetail
		/*
		Instructor instructor = new Instructor("Naveen","Kumar","naveen@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("navee/yt.com","Graphite Potrait");
*/
		Instructor instructor = new Instructor("Praveen","Kumar","praveen@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("praveen/yt.com","Typing");

		// Make an association with the help of setters
		instructor.setInstructorDetail(instructorDetail);

		// save
		System.out.println("Saving Insturctor");
		appDAO.save(instructor);

		System.out.println("Done!!!");

	}
}
