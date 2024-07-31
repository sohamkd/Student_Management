package com.cws.student.management.repositories;

import com.cws.student.management.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,String> {

}
