package com.cws.student.management.controller;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.dtos.SubjectDto;
import com.cws.student.management.entities.Subject;
import com.cws.student.management.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto)
    {
        SubjectDto subject = subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<SubjectDto>> getAllSubjects(
            @RequestParam(value="pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
    {

        return new ResponseEntity<>(subjectService.getAllSubjects(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }
}
