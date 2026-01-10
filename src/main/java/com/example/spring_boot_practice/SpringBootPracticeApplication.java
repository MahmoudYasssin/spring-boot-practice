package com.example.spring_boot_practice;

import com.example.spring_boot_practice.Entities.Student;
import com.example.spring_boot_practice.dao.StudentDao;
import com.example.spring_boot_practice.dao.StudentDaoImple;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);
	}


	//
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
		//	createStudent(studentDao);          		 //for Saving
			//retrieveStudent(studentDao) ;  			 //for Retrieving
			//findAllByName(studentDao);    			 //for Retrieving specific Student
			//findAllStudents(studentDao);  			 //for Retrieving All Students
			//updateFirstNameForOneStudent(studentDao);  //for Update First Name for specific student
			//updateAllEmails(studentDao);               //for Update First Name for all students
			//deleteStudent(studentDao);                //for Delete specific student
			//deleteAllStudents(studentDao);            //for Delete all students

		};

	}
	private void createStudent(StudentDao studentDao)
	{
		Student student=new Student("Mahmoud","Yssai","Mahmoud Yasin@gmail.com");
		studentDao.save(student);

	}
	private void retrieveStudent(StudentDao studentDao)
	{
		//Creat new Student
		Student student=new Student("Aa","Yai","Ay Yasin@gmail.com");
		studentDao.save(student);
		int studentid=student.getId();
		Student student1=studentDao.findById(studentid);
		System.out.println(student1);
	}
	private void findAllByName(StudentDao studentDao)
	{
		List<Student>studentList=studentDao.findByName("jj");
		for(Student student:studentList)
		{
			System.out.println(student);
		}
	}
	private void findAllStudents(StudentDao studentDao)
	{
		List<Student>studentList=studentDao.findAll();
		for (Student student:studentList)
		{
			System.out.println(student);
		}
	}
	private void updateFirstNameForOneStudent(StudentDao studentDao)
	{
		int id=4;
		Student student=studentDao.findById(id);
		student.setFirstName("Ahmed");
		Student updatedStudent=studentDao.updateFirstName(student);
		System.out.println(updatedStudent);
	}
	private void updateAllEmails(StudentDao studentDao)
	{
		studentDao.updateAllEmails();
	}
	private void deleteStudent(StudentDao studentDao)
	{
		int studentId=1;
		studentDao.deleteStudent(studentId);
	}
	private void deleteAllStudents(StudentDao studentDao)
	{
		studentDao.deleteAll();
	}


}
