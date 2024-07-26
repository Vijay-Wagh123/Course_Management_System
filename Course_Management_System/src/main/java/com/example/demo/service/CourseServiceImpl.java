package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepo repo;

	@Override
	public String upsert(Course course) {
		repo.save(course);
		return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById=repo.findById(cid);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return repo.findAll();
		
	}

	@Override
	public String deleteById(Integer cid) {
		if(repo.existsById(cid)) {
			repo.deleteById(cid);
			return "Deleted Entity";
		}
		return "No Entity found";
	}

}
