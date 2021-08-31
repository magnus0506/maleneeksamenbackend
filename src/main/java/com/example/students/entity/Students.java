package com.example.students.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name="students")
@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    Long studentId;
    private String name;
    private String email;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




//  @JsonIgnore
//    @ManyToMany(mappedBy = "enrolledStudents")
//    private Set<Subjects> subjects = new HashSet<>();
//
//
//    public Set<Subjects> getSubjects() {
//        return subjects;
//    }
}



