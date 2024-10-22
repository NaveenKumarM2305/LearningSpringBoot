package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.Instructor;
import com.naveen.mappingdemo.entity.InstructorDetail;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor find(int id);

    public void delete(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);
}
