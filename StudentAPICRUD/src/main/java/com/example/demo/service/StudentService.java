package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	public StudentRepository studRepo;

	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		studRepo.findAll().forEach(students::add);	
		return students;
	}
	
	public void addStudents(Student student) {
		studRepo.save(student);
	}
	
	
	public void updateStudents(String id , Student student) {
		studRepo.save(student);
	}
	
	public void deleteStudents(String id) {
		studRepo.deleteById(id);
	}
}
