package com.naveen.cruddemo;

import com.naveen.cruddemo.dao.StudentDao;
import com.naveen.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
	return runner ->{
//		createStudent(studentDao);
//		createMultipleStudents(studentDao);
//		readStudent(studentDao);
//		readAllStudents(studentDao);
//		readStudentByFirstName(studentDao);
//		updateStudent(studentDao);
//		deleteStudentById(studentDao);
		deleteAllStudents(studentDao);
	};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		int deletedRows= studentDao.deleteAll();
		System.out.println("Number of Deleted Records: "+deletedRows);
	}

	private void deleteStudentById(StudentDao studentDao) {

		int studentId=4;

		// delete the student
		studentDao.deleteById(studentId);


	}

	private void updateStudent(StudentDao studentDao) {
		int studentId=2;
		Student tempStudent = studentDao.findById(studentId);
		tempStudent.setFirstName("Praveen");
		studentDao.update(tempStudent);
		System.out.println(tempStudent);

	}

	private void readStudentByFirstName(StudentDao studentDao) {
		List<Student> students = studentDao.findByFirstName("Charan");
		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

	private void readAllStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		Student student = studentDao.findById(3);
		System.out.println("Id: "+student.getId()+" \n Name: "+student.getFirstName());
	}

	public void createMultipleStudents (StudentDao studentDao){
		// creating multiple objects
	System.out.println("Creating 3 objects");
	Student stu1= new Student("Arun","Kumar","arun@gmail.com");
	Student stu2= new Student("Varun","Kumar","Varun@gmail.com");
	Student stu3= new Student("Charan","Kumar","Charan@gmail.com");



	// Saving the created objects
	System.out.println("Saving the objects");
	studentDao.save(stu1);
	studentDao.save(stu2);
	studentDao.save(stu3);

	}

	private void createStudent(StudentDao studentDao){
		// create the object
		System.out.println("Creating the student");
		Student tempStudent = new Student("Naveen","Kumar","naveen@gmail.com");


		// save the object
		studentDao.save(tempStudent);

		// Display the student id
		System.out.println("Displaing the student information");
		System.out.println("Studend id: "+tempStudent.getId()+" and Name: "+tempStudent.getFirstName());





	}
}
