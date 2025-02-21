package com.microservice.course.service;

import java.util.List;

import com.microservice.course.entities.Course;

public interface  ICourseService {

  List<Course> findAll();
  Course findById(Long id);
  void save(Course course);
}
