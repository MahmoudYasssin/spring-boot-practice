package com.example.spring_boot_practice.Controllers;

import com.example.spring_boot_practice.Entities.Student;
import com.example.spring_boot_practice.ExceptionHandel.StudentNotFoundException;
import com.example.spring_boot_practice.dao.StudentDao;
import com.example.spring_boot_practice.dao.StudentDaoImple;
import com.example.spring_boot_practice.service.serviceInterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


   // private final StudentDao studentDao; //new studentImple()
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

   /* @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student)
    {
        studentService.saveStudent(student);
    }
    @GetMapping("/find/{id}")
    public Student findById(@PathVariable int id)
    {
        return studentService.findStudentById(id);
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents()
    {
        return studentService.findAllStudents();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable int id)
    {

        studentService.deleteStudentById(id);
    }

}
