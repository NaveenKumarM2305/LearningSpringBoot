package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.Course;
import com.naveen.mappingdemo.entity.Instructor;
import com.naveen.mappingdemo.entity.InstructorDetail;
import com.naveen.mappingdemo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.element.TypeElement;
import java.util.List;

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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
       InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
       return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);

        // set instructor_detail_id in the Instructor to null before deleting the
        // instructorDetail because its a  foreign key
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findMyCoursesByInstructorId(int id){
        // Custom query to find the course from instructor id
        //Without using joins
        TypedQuery<Course> query= entityManager.createQuery("from Course where instructor.id =:data",Course.class);

        // setting the place holder to id
        query.setParameter("data",id);

         List<Course> course= query.getResultList();
         return course;



    }

    // Using joins to fetch both instructor and courses
    //Alternate soltion to retrieve instructor with courses which
    // acts like e EAGER loading even though the fetchType in LAZY
    @Override
    public Instructor findInstructorById(int theId){
        TypedQuery<Instructor> query= entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:data ",Instructor.class);

        query.setParameter("data",theId);

        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
   Course course = entityManager.find(Course.class,id);
   return course;
    }


    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);



        //Retrieveing the courses and setting the instructor to null
        // This is done to avoid integrityConstraint Voilation
        List<Course> courses = instructor.getCourses();
        for(Course temp: courses){
            temp.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
            Course course = entityManager.find(Course.class,id);
            entityManager.remove(course);
    }


    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
       TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id=:data",Course.class);

       query.setParameter("data",id);

       Course course = query.getSingleResult();

       return course;


    }

}
