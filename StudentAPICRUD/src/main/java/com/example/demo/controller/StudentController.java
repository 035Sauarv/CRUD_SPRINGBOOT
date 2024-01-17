package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	

	@Autowired
	private StudentService studService;
	
	@Autowired
	private StudentRepository studRepo;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents(){
	return studService.getAllStudents();
	}
	

	
	
	@RequestMapping(method=RequestMethod.POST,value="/students")
	public void addStudents(@RequestBody Student student) {
		studService.addStudents(student);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public ResponseEntity<String> updateStudents(@PathVariable String id, @RequestBody Student student) {
	    if (studRepo.existsById(id)) {
	        studService.updateStudents(id, student);
	        return ResponseEntity.ok("Student updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found");
	    }
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		studService.deleteStudents(id);
	}
}
