package com.canwia.studentlist.converter;

import com.canwia.studentlist.dto.StudentDto;
import com.canwia.studentlist.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    //Entity to Dto query conversion process
    public StudentDto entityToDto(Student student){

        StudentDto dto = new StudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setUsername(student.getUserName());
        dto.setPassword(student.getPassword());

        return dto;
    }

    //EntityList to DtoList query conversion process
    public List<StudentDto> entityToDto(List<Student> student){
        return student.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    //Dto to Entity query conversion process
    public Student dtoToEntity(StudentDto studentDto){
        Student student = new Student();

        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUserName(studentDto.getUsername());
        student.setPassword(studentDto.getPassword());

        return student;
    }

    //DtoList to EntityList query conversation process
    public List<Student> dtoToEntity(List<StudentDto> studentDto){
      return   studentDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }

}
