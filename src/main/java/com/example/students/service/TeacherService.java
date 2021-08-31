package com.example.students.service;

import com.example.students.entity.Teacher;
import com.example.students.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;



    public List<Teacher> readTeacher(){
        return teacherRepository.findAll();
    }

    @Transactional
    public String updateTeacher(Teacher teacher){
        if (teacherRepository.existsById(teacher.getTeacherId())){
            try {
                Optional<Teacher> teacher1 = teacherRepository.findById(teacher.getTeacherId());
                teacher1.stream().forEach(s -> {
                    Teacher subjectToBeUpdate = teacherRepository.findById(teacher.getTeacherId()).get();
                    subjectToBeUpdate.setName(teacher.getName());
                    subjectToBeUpdate.setId(teacher.getTeacherId());
                    teacherRepository.save(subjectToBeUpdate);
                });
                return "Teacher record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Teacher does not exists in the database.";
        }
    }

    @Transactional
    public String deleteTeacher(Teacher subjects){
        if (teacherRepository.existsById(subjects.getTeacherId())){
            try {
                Optional<Teacher> teacher1 = teacherRepository.findById(subjects.getTeacherId());
                teacher1.stream().forEach(s -> {
                    teacherRepository.delete(s);
                });
                return "teacher record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "teacher does not exist";
        }

    }
}




