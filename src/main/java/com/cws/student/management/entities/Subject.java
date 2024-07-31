package com.cws.student.management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="subjects")
public class Subject {

    @Id
    private String id;

    @Column(name="subject_name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students=new HashSet<>();
}
