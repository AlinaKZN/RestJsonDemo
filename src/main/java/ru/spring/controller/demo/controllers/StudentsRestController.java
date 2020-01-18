package ru.spring.controller.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.controller.demo.entity.Student;
import ru.spring.controller.demo.entity.StudentException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {
    private List<Student> students;

    @PostConstruct
    public void generateStudents(){
        students = new ArrayList<Student>();
        students.add(new Student("Mary", "cury"));
        students.add(new Student("John", "Smith"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        if ((id < 0) || (id > students.size() - 1)){
            throw new StudentNotFoundException("Student not found - "+ id);
        }
        return students.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<StudentException> handleException(StudentNotFoundException exception){
        StudentException studentException = new StudentException();
        studentException.setMessage(exception.getMessage());
        studentException.setStatus(HttpStatus.NOT_FOUND.value());
        studentException.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<StudentException>(studentException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentException> handleException(Exception exception){
        StudentException studentException = new StudentException();
        studentException.setMessage(exception.getMessage());
        studentException.setStatus(HttpStatus.BAD_REQUEST.value());
        studentException.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<StudentException>(studentException, HttpStatus.BAD_REQUEST);

    }
}
