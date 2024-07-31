package com.cws.student.management.controller;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.dtos.SubjectDto;
import com.cws.student.management.entities.Student;
import com.cws.student.management.entities.Subject;
import com.cws.student.management.services.StudentService;
import com.cws.student.management.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto)
    {
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<StudentDto>> getAllStudents(
            @RequestParam(value="pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
    {

        return new ResponseEntity<>(studentService.getAllStudents(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }


    @PostMapping("/{studentId}/subjects/{subjectId}")
    public ResponseEntity<Student> assignSubjectTostudent(
            @PathVariable String studentId,
            @PathVariable String subjectId
    )
    {
         Student subjectsOfStudent = studentService.assignSubjectTostudent(studentId,subjectId);
        return new ResponseEntity<>(subjectsOfStudent,HttpStatus.CREATED);
    }



}
