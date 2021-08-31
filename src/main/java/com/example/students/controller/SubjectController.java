package com.example.students.controller;

import com.example.students.entity.Students;
import com.example.students.entity.Subjects;
import com.example.students.entity.Teacher;
import com.example.students.repository.StudentsRepository;
import com.example.students.repository.SubjectRepository;
import com.example.students.repository.TeacherRepository;
import com.example.students.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SubjectController {

    @Autowired
    SubjectsService subjectsService;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SubjectRepository subjectRepository;




@PutMapping("/{subjectId}/students/{studentId}")
    Subjects addStudentToSubjectService(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subjects subjects = subjectRepository.findById(subjectId).get();
        Students students = studentsRepository.findById(studentId).get();
//        subjects.enrolledStudents.add(students);
        return subjectRepository.save(subjects);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subjects assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        Subjects subjects = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subjects.setTeacherId(teacher);
        return subjectRepository.save(subjects);
    }
    @GetMapping("/subjects")
    public List<Subjects> findAllSubjects(){
    return subjectRepository.findAll();
    }


}
