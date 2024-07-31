package com.cws.student.management.services.impl;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.dtos.SubjectDto;
import com.cws.student.management.entities.Student;
import com.cws.student.management.entities.Subject;
import com.cws.student.management.exception.ResourceNotFoundException;
import com.cws.student.management.helper.Helper;
import com.cws.student.management.repositories.StudentRepository;
import com.cws.student.management.repositories.SubjectRepository;
import com.cws.student.management.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {

        String subjectId = UUID.randomUUID().toString();
        subjectDto.setId(subjectId);

        Subject subject=modelMapper.map(subjectDto, Subject.class);
        subject.setName(subjectDto.getName());

        Subject savedSubject = subjectRepository.save(subject);
        return modelMapper.map(savedSubject,SubjectDto.class);
    }

    @Override
    public PageableResponse<SubjectDto> getAllSubjects(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort= (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        //Pagination
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Subject> page= subjectRepository.findAll(pageable);

        PageableResponse<SubjectDto> response= Helper.getPageableResponse(page,SubjectDto.class);

        return response;
    }




}
