package com.anytime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anytime.entity.student;
import com.anytime.repository.studentRepository;

@RestController
public class studentController {

	@Autowired
	studentRepository repo;
	@GetMapping("/students")
	public List <student> getAllstudent(){
		
		List<student> students = repo.findAll();
		
		return students;
		
	}

	
	@GetMapping("/students/{id}")
	public student getstudent(@PathVariable int id) {
		student student=repo.findById(id).get();
		
		return student;
	}
	@PostMapping("/student/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createstudent(@RequestBody student student) {
		repo.save(student);
	}
	
	@PutMapping("/student/update/{id}")
	public student updatestudents(@PathVariable int id) {
		student student =repo.findById(id).get();
		student.setName("poonam");
		student.setPercentage(92);
		repo.save(student);
		return student;
		
	}
	@DeleteMapping("/student/delete/{id}")
	public void removestudent(@PathVariable int id) {
		student student= repo.findById(id).get();
		repo.delete(student);
	}
}
