package com.cws.student.management.services;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.entities.Student;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    PageableResponse<StudentDto> getAllStudents(int pageNumber, int pageSize, String sortBy, String sortDir);

    Student assignSubjectTostudent(String studentId, String subjectId);


}
