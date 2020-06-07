package az.rest.service;


import az.rest.dto.LoginDto;
import az.rest.dto.RegisterDto;
import az.rest.dto.RegisterResponseDto;
import az.rest.dto.StudentDto;
import az.rest.dto.base.GenericResponse;
import az.rest.model.Student;

import java.util.List;


public interface StudentService {

    GenericResponse<Integer> saveRegisterInfo(RegisterDto request);

    GenericResponse<Integer> save(StudentDto request);

    List<Student> getStudents();

    GenericResponse<RegisterResponseDto> authenticate(LoginDto request);
}
