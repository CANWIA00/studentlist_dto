package com.canwia.studentlist.controller;

import com.canwia.studentlist.converter.StudentConverter;
import com.canwia.studentlist.dto.StudentDto;
import com.canwia.studentlist.repository.StudentRepository;
import com.canwia.studentlist.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private StudentRepository studentRepository;
    private StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/findAll")
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/find{id}")
    public StudentDto findById(@PathVariable(value = "id") Long id){
        return studentService.findById(id);
    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }
}
