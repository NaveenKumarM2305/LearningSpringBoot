package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.Instructor;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor find(int id);

    public void delete(int id);
}
