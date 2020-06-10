package az.rest.service;

import az.rest.dto.LoginDto;
import az.rest.dto.RegisterDto;
import az.rest.dto.RegisterResponseDto;
import az.rest.dto.StudentDto;
import az.rest.dto.base.GenericResponse;
import az.rest.model.Registration;
import az.rest.model.Student;
import az.rest.repository.RegistrationRepository;
import az.rest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final RegistrationRepository registrationRepository;

    @Override
    public GenericResponse<Integer> saveRegisterInfo(RegisterDto request) {
        Registration registration = prepareRegistration(request);
        Registration savedRegistration = registrationRepository.save(registration);
        return GenericResponse.ok(savedRegistration.getId());
    }

    @Override
    public GenericResponse<Integer> save(StudentDto request) {
        Student student = prepareStudent(request);
        Student savedStudent = studentRepository.save(student);
        return GenericResponse.ok(savedStudent.getId());
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    @Override
    public GenericResponse<RegisterResponseDto> authenticate(LoginDto request) {
        Optional<Registration> registrationOptional = registrationRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (!registrationOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Registration registration=registrationOptional.get();
        RegisterResponseDto response = new RegisterResponseDto(registration.getName(), registration.getSurname(), registration.getRole());
        return GenericResponse.ok(response);
    }




    private Registration prepareRegistration(RegisterDto request) {
        Registration registration = new Registration();
        registration.setName(request.getName());
        registration.setSurname(request.getSurname());
        registration.setEmail(request.getEmail());
        registration.setPassword(request.getPassword());
        return registration;
    }

    private Student prepareStudent(StudentDto request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setSector(request.getSector());
        return student;
    }


}
