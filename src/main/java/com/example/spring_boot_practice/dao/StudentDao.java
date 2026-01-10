package com.example.spring_boot_practice.dao;

import com.example.spring_boot_practice.Entities.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);  //
    Student findById(int id);  //
    List<Student> findByName(String name); //
    List<Student>findAll();   //
    Student updateFirstName(Student student); //
    void updateAllEmails(); //
    void deleteStudent(int id);
    void deleteAll();



}
