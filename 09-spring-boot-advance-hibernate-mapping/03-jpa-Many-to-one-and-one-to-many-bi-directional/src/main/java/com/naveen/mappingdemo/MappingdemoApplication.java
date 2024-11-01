package com.naveen.mappingdemo;

import com.naveen.mappingdemo.entity.Course;
import com.naveen.mappingdemo.entity.Instructor;
import com.naveen.mappingdemo.entity.InstructorDetail;
import com.naveen.mappingdemo.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//				deleteInstructorById(appDAO);

//		findInstructorDetailById(appDAO);

//		deleteInstructorDetailById(appDAO);

//        saveInstructorWithCourses(appDAO);

//		findInstructorWithCourses(appDAO);

//			findCoursesByInstructorId(appDAO);

//			findInstructorWithCousesJoinFetch(appDAO);

//			updateInstructorLastName(appDAO);

//			updateCourseById(appDAO);

//			deleteInstructorForId(appDAO);

			deleteCourseForId(appDAO);


		};

	}

	private void deleteCourseForId(AppDAO appDAO) {
		int id=10;
		appDAO.deleteCourse(id);
		System.out.println("Deleted course");

	}


	private void deleteInstructorForId(AppDAO appDAO) {
		int id = 1;


		appDAO.deleteInstructor(id);
	}

	private void updateCourseById(AppDAO appDAO) {

		int courseId=10;
		// retrieve the course by courseId
		Course course= appDAO.findCourseById(courseId);

		// make changes to the course
		course.setTitle("Learing Java programming");

		//update to the database
		appDAO.updateCourse(course);

		//displaying
		System.out.println(course);

		System.out.println("Done!");
	}

	private void updateInstructorLastName(AppDAO appDAO) {

		int theId=1;
		// Retrievening the instructor
		Instructor instructor = appDAO.findInstructorById(theId);
		// changing the last name
		instructor.setLastName("Stiver");
		// Updating it to the database
		appDAO.updateInstructor(instructor);
		System.out.println("Udate Done!!");
		System.out.println("Updated Instructor");
		System.out.println(instructor);



	}


	private void findInstructorWithCousesJoinFetch(AppDAO appDAO) {
		int id=1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: "+instructor);

		System.out.println("Courses: "+instructor.getCourses());
		System.out.println("Done!!");

	}

	// Finding the course from instructor id using lazy initialization
	// WE dont need to change the fetch type here , it can be LAZY by default
	private void findCoursesByInstructorId(AppDAO appDAO) {
		int instructorId=1;
		// Find instructor using instructor id
		Instructor instructor = appDAO.find(instructorId);
		System.out.println("Instructor: "+instructor);

		// Finding the instructor's courses
		// Its a lazy loading by default , hence we are sepeartly findig the
		// courses implementing our logic
		List<Course> courseList = appDAO.findMyCoursesByInstructorId(instructorId);
		// associate the objects
		instructor.setCourses(courseList);
		System.out.println("Courses: "+instructor.getCourses());
//		System.out.println("Instructor Details: "+instructor.getInstructorDetail());
		System.out.println("done!!!");
	}

	// Finding the courses using instrucor id using eager initialization
	// Explicitly makeing OneToMany fetch type as EAGER
	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		Instructor instructor= appDAO.find(theId);
		System.out.println("Instructor: "+instructor);
		System.out.println("Courses: "+instructor.getCourses());


	}

	private void saveInstructorWithCourses(AppDAO appDAO) {
		// Creating one instructor
		Instructor instructor = new Instructor("Raj","Vikramaditya","stiver@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("stiver/yt.com","YT");
		instructor.setInstructorDetail(instructorDetail);
		// Creating multiple courses to map with singlle instructor
		Course course1 = new Course("Joy of computing Python");
		Course course2 = new Course("Stiver DSA Course");


		// adding courses to the insturctor
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("Saving the instructor");
		// This will automatically save the courses also due to cascading
		appDAO.save(instructor);


	}

	public void deleteInstructorDetailById(AppDAO appDAO){
		int theId=3;

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Instructor Detail deleted: "+theId);
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId=1;
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

		Instructor instructor = new Instructor("Naveen","Kumar","naveen@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("navee/yt.com","Graphite Potrait");
/*
		Instructor instructor = new Instructor("Praveen","Kumar","praveen@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("praveen/yt.com","Typing");
*/
		// Make an association with the help of setters
		instructor.setInstructorDetail(instructorDetail);

		// save
		System.out.println("Saving Insturctor");
		appDAO.save(instructor);

		System.out.println("Done!!!");

	}
	public InstructorDetail findInstructorDetailById(AppDAO appDAO){
			int theId= 1;
			InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor detail: "+instructorDetail);
		System.out.println("Instructor: "+instructorDetail.getInstructor());

			return instructorDetail;
	}
}