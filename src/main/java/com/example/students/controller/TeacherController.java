package com.example.students.controller;


import com.example.students.entity.Teacher;
import com.example.students.repository.TeacherRepository;
import com.example.students.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.students.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/createteacher")
    Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}

/*
import com.example.students.entity.Teacher;
import com.example.students.repository.TeacherRepository;
import com.example.students.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers", method = RequestMethod.GET)
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Autowired
    private TeacherService teacherService;

   @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Testing";

    }

    @RequestMapping(value = "createteacher", method = RequestMethod.POST)
    public String createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);

    }

    @RequestMapping(value = "readteachers", method = RequestMethod.GET)
    public List<Teacher> readTeacher() {
        return teacherService.readTeacher();
    }


    @RequestMapping(value = "updateteacher", method = RequestMethod.PUT)
    public String updateTeachert(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);

    }

    @RequestMapping(value = "deleteteacher", method = RequestMethod.DELETE)
    public String deleteTeacher(@RequestBody Teacher teacher) {
        return teacherService.deleteTeacher(teacher);

    }

}
*/