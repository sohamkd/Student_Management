package com.cws.student.management.services.impl;

import com.cws.student.management.dtos.PageableResponse;
import com.cws.student.management.dtos.StudentDto;
import com.cws.student.management.entities.Student;
import com.cws.student.management.entities.Subject;
import com.cws.student.management.exception.ResourceNotFoundException;
import com.cws.student.management.helper.Helper;
import com.cws.student.management.repositories.StudentRepository;
import com.cws.student.management.repositories.SubjectRepository;
import com.cws.student.management.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        String studentId = UUID.randomUUID().toString();
        studentDto.setId(studentId);

       Student student=modelMapper.map(studentDto,Student.class);
       student.setAddress(studentDto.getAddress());
       student.setName(studentDto.getName());

        Student savedStudent= studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }

    @Override
    public PageableResponse<StudentDto> getAllStudents(int pageNumber,int pageSize,String sortBy,String sortDir) {

        Sort sort= (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        //Pagination
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Student> page= studentRepository.findAll(pageable);

        PageableResponse<StudentDto> response= Helper.getPageableResponse(page,StudentDto.class);

        return response;
    }

    @Override
    public Student assignSubjectTostudent(String studentId,String subjectId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with given id"));
        Subject subject=subjectRepository.findById(subjectId).orElseThrow(()->new ResourceNotFoundException("Subject not found with given id"));

        if(student!=null && subject!=null)
        {
            student.getSubjects().add(subject);
            Student savedStudent = studentRepository.save(student);
            return savedStudent;
        }
        return null;

    }

}
