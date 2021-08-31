package com.example.students.service;


import com.example.students.entity.Students;
import com.example.students.entity.Subjects;
import com.example.students.entity.Teacher;
import com.example.students.repository.StudentsRepository;
import com.example.students.repository.SubjectRepository;
import com.example.students.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectsService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    TeacherRepository teacherRepository;


    public List<Subjects> readSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional
    public String updateSubject(Subjects subjects) {
        if (subjectRepository.existsById(subjects.getSubjectId())) {
            try {
                Optional<Subjects> subject = subjectRepository.findById(subjects.getSubjectId());
                subject.stream().forEach(s -> {
                    Subjects subjectToBeUpdate = subjectRepository.findById(s.getSubjectId()).get();
                    subjectToBeUpdate.setName(subjects.getName());
                    subjectToBeUpdate.setId(subjects.getSubjectId());
                    subjectRepository.save(subjectToBeUpdate);
                });
                return "Subject record updated.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Subject does not exists in the database.";
        }
    }

    @Transactional
    public String deleteSubject(Subjects subjects) {
        if (subjectRepository.existsById(subjects.getSubjectId())) {
            try {
                Optional<Subjects> subject = subjectRepository.findById(subjects.getSubjectId());
                subject.stream().forEach(s -> {
                    subjectRepository.delete(s);
                });
                return "Subject record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Subject does not exist";
        }
    }
}