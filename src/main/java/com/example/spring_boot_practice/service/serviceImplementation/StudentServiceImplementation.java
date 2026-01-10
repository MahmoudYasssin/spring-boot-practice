package com.example.spring_boot_practice.service.serviceImplementation;

import com.example.spring_boot_practice.Entities.Student;
import com.example.spring_boot_practice.dao.StudentDao;
import com.example.spring_boot_practice.service.serviceInterface.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    private StudentDao studentDao;
    public StudentServiceImplementation(StudentDao studentDao)
    {
        this.studentDao=studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public Student updateStudentsFirstName(Student student) {
        return studentDao.updateFirstName(student);
    }

    @Override
    public void updateAllStudentsEmails() {
        studentDao.updateAllEmails();
    }

    @Override

    public void deleteStudentById(int id) {
        studentDao.deleteStudent(id);
    }
}
