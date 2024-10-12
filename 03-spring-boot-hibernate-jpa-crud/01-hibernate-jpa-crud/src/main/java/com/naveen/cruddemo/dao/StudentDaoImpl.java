package com.naveen.cruddemo.dao;

import com.naveen.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    // define entitiy manager filed
    private EntityManager entityManager;

    // create a constructor injection and make it available to Spring
@Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Override save method
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
    @Transactional
    public Student findById(int stuId){
    Student student = entityManager.find(Student.class,stuId);
    return student;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theStudents = entityManager.createQuery("From Student order by firstName desc", Student.class);
        return theStudents.getResultList();

    }

    @Override
    public List<Student> findByFirstName(String firstName) {

            TypedQuery<Student> theQuery= entityManager.createQuery("From Student where firstName=:theData", Student.class);
            theQuery.setParameter("theData",firstName);
            return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student student) {
 entityManager.merge(student);



    }

    @Override
    @Transactional
    public void deleteById(int studentId) {
    //find the student Id
        // You can also find the Student Id by
        //    Student student = findById(studentId);

        Student student =entityManager.find(Student.class,studentId);

    // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedRecords = entityManager.createQuery("Delete from Student").executeUpdate();
        return deletedRecords;
    }


}
