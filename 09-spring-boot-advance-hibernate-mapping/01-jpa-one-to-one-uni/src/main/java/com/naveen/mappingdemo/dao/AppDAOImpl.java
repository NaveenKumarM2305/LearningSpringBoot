package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDAOImpl implements  AppDAO{

    // define entity manager
    EntityManager entityManager;

    // inject the entity manager
    @Autowired
AppDAOImpl(EntityManager entityManager){
    this.entityManager=entityManager;
}
    // save the instructor

    @Override
    @Transactional
    public void save(Instructor instructor){
    entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public Instructor find(int id) {
    Instructor instructor= entityManager.find(Instructor.class,id);
    return instructor;
    }

    @Override
    @Transactional
    public void delete(int id) {

        Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);


    }
}
