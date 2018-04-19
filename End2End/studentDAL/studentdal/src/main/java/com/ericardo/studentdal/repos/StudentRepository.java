package com.ericardo.studentdal.repos;

import org.springframework.data.repository.CrudRepository;

import com.ericardo.studentdal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
