package az.rest.controller;


import az.rest.dto.LoginDto;
import az.rest.dto.RegisterDto;
import az.rest.dto.RegisterResponseDto;
import az.rest.dto.StudentDto;
import az.rest.dto.base.GenericResponse;
import az.rest.model.Student;
import az.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "/services")
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping(value = "save", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse<Integer> saveRegisterInfo(@RequestBody RegisterDto request) {
        return studentService.saveRegisterInfo(request);
    }


    @PostMapping(value = "students", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse<Integer> saveStudent(@RequestBody StudentDto request) {
        return studentService.save(request);
    }


    @PostMapping("authenticate")
    public GenericResponse<RegisterResponseDto> authenticate(@RequestBody @Validated LoginDto request){
        return studentService.authenticate(request);

    }







}
