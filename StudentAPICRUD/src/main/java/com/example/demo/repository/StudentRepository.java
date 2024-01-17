package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Student;

public interface StudentRepository extends CrudRepository<Student,String>{

}
