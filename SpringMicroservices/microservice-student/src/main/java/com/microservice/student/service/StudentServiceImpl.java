package com.microservice.student.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {
    return (List<Student>) studentRepository.findAll();
  }

  @Override
  public Student findById(Long id) {
    return studentRepository.findById(id).orElseThrow();
  }

  @Override
  public void save(Student student) {
    studentRepository.save(student);
  }

  @Override
  public List<Student> findByIdCourse(Long courseId) {
    return studentRepository.findAllStudent(courseId);
  }

}
