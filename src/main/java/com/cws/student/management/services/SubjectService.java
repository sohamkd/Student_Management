package com.cws.student.management.services;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.dtos.SubjectDto;
import com.cws.student.management.entities.Student;
import com.cws.student.management.entities.Subject;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject(SubjectDto subjectDto);

    PageableResponse<SubjectDto> getAllSubjects(int pageNumber, int pageSize, String sortBy, String sortDir);

}
