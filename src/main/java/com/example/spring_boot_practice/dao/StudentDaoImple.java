package com.example.spring_boot_practice.dao;

import com.example.spring_boot_practice.Entities.Student;
import com.example.spring_boot_practice.ExceptionHandel.StudentNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImple implements StudentDao{

    EntityManager entityManager;

    @Autowired
    public StudentDaoImple(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    public StudentDaoImple()
    {}


    @Override
    @Transactional
    public void save(Student student)
    {
        entityManager.persist(student);

    }

    @Override
    public Student findById(int id)
    {
        Student student=entityManager.find(Student.class,id);
        if(student ==null)
        {
            throw new StudentNotFoundException("Id not found" + id);

        }
        return student;
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student>studentTypedQuery= entityManager.createQuery("FROM Student WHERE firstName=:thedate ",Student.class);
        studentTypedQuery.setParameter("thedate",name);
        List<Student>studentList=studentTypedQuery.getResultList();
        return studentList;


    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student>studentTypedQuery= entityManager.createQuery("FROM Student",Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public Student updateFirstName(Student student) {

        Student student1=entityManager.merge(student);
        return student1;
    }

    @Override
    @Transactional
    public void updateAllEmails() {
        entityManager.createQuery("UPDATE Student set email='@yahoo'").executeUpdate();
    }

    @Override
    @Transactional

    public void deleteStudent(int id) {

        Student student = findById(id);
        if(student==null) {
            throw new StudentNotFoundException("Id not found" + id);
        }
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
