package com.microservice.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.dto.StudentDTO;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {


  @GetMapping("/search-by-course/{courseId}")
  List<StudentDTO> findAllStudentByCourse(@PathVariable Long courseId);

}
