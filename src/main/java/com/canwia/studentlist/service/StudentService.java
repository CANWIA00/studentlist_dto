package com.canwia.studentlist.service;

import com.canwia.studentlist.converter.StudentConverter;
import com.canwia.studentlist.dto.StudentDto;
import com.canwia.studentlist.model.Student;
import com.canwia.studentlist.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepository studentRepository;
    private StudentConverter studentConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentDto> findAll() {

        List<Student> studentList = studentRepository.findAll();

        return studentConverter.entityToDto(studentList);

    }

    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        return studentConverter.entityToDto(student);
    }

    public StudentDto save(StudentDto studentDto) {

        Student student = studentConverter.dtoToEntity(studentDto);

        student =  studentRepository.save(student);

        return studentConverter.entityToDto(student);
    }
}
