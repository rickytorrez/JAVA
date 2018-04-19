package com.ericardo.studentdal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ericardo.studentdal.entities.Student;
import com.ericardo.studentdal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository _sR;
	
	// Creates a student
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("Wil");
		student.setCourse("Java Web Services");
		student.setFee(30d);
		
		_sR.save(student);
	}
	
	// Reads a student
	@Test
	public void testfindStudentById() {
		
		Student student = _sR.findOne(1l);
		System.out.println(student);
	}
	
	// Updates a student
	@Test
	public void testUpdateStudent() {
		
		Student student = _sR.findOne(1l);
		student.setFee(40d);
		
		_sR.save(student);
	}
	
	// Deletes a student
	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(1l);
		
		_sR.delete(student);
		// or _sR.delete(1l);
	}
	
}
