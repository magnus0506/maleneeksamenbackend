package com.example.students.service;

import com.example.students.entity.Students;
import com.example.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentsService {

 @Autowired
    private StudentsRepository studentsRepository;



    public List<Students> readStudents(){
        return studentsRepository.findAll();
    }


    }
