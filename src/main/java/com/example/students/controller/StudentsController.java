package com.example.students.controller;

import com.example.students.entity.Students;
import com.example.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.students.service.StudentsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping
    List<Students> getStudents() {
        return studentsRepository.findAll();
    }

    @Autowired
    private StudentsService studentsService;

    @GetMapping(value = "/info")
    public String info() {
        return "Testing";

    }
    @PostMapping(value = "/createstudent")
    public Students createStudent(@RequestBody Students students) {
        return studentsRepository.save(students);
    }

    @PutMapping(value = "updatestudent")
    public Students updateStudent(@RequestBody Students students){
        return studentsRepository.save(students);

    }

    //    @GetMapping(value = "readstudents")
//    public List<Students> readStudents()
//    {
//        return studentsRepository.findAll();
//    }
//    @DeleteMapping(value = "deletestudent")
//    public void deleteStudent(@RequestBody Long studentId ){
//        studentsRepository.deleteById(studentId);
//    }

    @DeleteMapping(value = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentsRepository.deleteById(studentId);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Students> findStudentById(@PathVariable Long studentId) {
        Optional<Students> student = studentsRepository.findById(studentId);
        if (student.isPresent()) {
            Students existingStudent = student.get();
            return new ResponseEntity<>(existingStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}