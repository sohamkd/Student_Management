package com.cws.student.management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="students")
public class Student {

    @Id
    private String id;

    @Column(name="student_name")
    private String name;

    @Column(name="student_address")
    private String address;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="student_subject",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id"))
    private Set<Subject> subjects=new HashSet<>();

}
