package com.example.spring_boot_practice.service.serviceInterface;

import com.example.spring_boot_practice.Entities.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    List<Student>findAllStudents();
    Student findStudentById(int id);
    List<Student> findStudentsByName(String name);
    Student updateStudentsFirstName(Student student);
    void updateAllStudentsEmails();
    void deleteStudentById(int id);





}
