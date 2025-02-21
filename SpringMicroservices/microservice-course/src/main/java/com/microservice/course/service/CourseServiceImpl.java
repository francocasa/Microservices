package com.microservice.course.service;

import java.util.List;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;

public class CourseServiceImpl implements ICourseService{

  private ICourseRepository courseRepository;
  private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(new Course());
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(courseId);
        return StudentByCourseResponse.builder()
        .courseName(course.getName())
        .teacher(course.getTeacher())
        .StudentDTOList(studentDTOList)
        .build();
    }

}
