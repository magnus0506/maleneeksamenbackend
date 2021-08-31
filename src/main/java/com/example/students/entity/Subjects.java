package com.example.students.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="subjects")
@Entity
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    private Long subjectId;
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)

    private Teacher teacherId;


    public Long getSubjectId() {
        return subjectId;
    }

    public void setId(Long id) {
        this.subjectId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    @ManyToMany
//    @JsonBackReference
//    @JoinTable(
//            name = "student_enrolled",
//            joinColumns = @JoinColumn(name = "subject_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )

//    public Set<Students> enrolledStudents = new HashSet<>();

//    public Set<Students> getEnrolledStudents() {
//        return enrolledStudents;
//    }

//    public void setEnrolledStudents(Set<Students> enrolledStudents) {
//        this.enrolledStudents = enrolledStudents;
//    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacher) {
        this.teacherId = teacher;
    }
}

