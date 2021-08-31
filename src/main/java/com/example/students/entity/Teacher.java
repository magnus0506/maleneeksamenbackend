package com.example.students.entity;



import javax.persistence.*;

@Table(name="teacher")
@Entity
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id")
    private Long teacherId;

    private String name;


    public Long getTeacherId() {
        return teacherId;
    }

    public void setId(Long teacherId){
        this.teacherId=teacherId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


