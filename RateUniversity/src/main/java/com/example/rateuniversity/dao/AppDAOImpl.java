package com.project.rateuniapp.dao;

import com.project.rateuniapp.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "where i.id=:data ", Instructor.class);
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);


    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id= :data", Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    @Transactional
    public void saveReview(Review review) {
        review.setDate(new Date()); // Set the current date
        entityManager.persist(review);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c "
                + "JOIN FETCH c.students "
                + "where c.id= :data", Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;

    }

    @Override
    public Review findReviewById(int id) {

        return entityManager.find(Review.class, id);
    }

    @Override
    @Transactional
    public void deleteReviewById(int reviewId) {
        Review reviewToDelete = entityManager.find(Review.class, reviewId);

        if (reviewToDelete != null) {
            entityManager.remove(reviewToDelete);

        }

        ;
    }

    @Override
    public List<Course> getTopRatedCoursesForStudent(int studentId, int count) {
        // Implement the logic to retrieve the top-rated courses for the student
        TypedQuery<Course> query = entityManager.createQuery(
                        "SELECT c FROM Course c JOIN c.reviews r JOIN r.student s " +
                                "WHERE s.id = :studentId " +
                                "ORDER BY AVG(r.rating) DESC", Course.class)
                .setParameter("studentId", studentId)
                .setMaxResults(count);

        return query.getResultList();


    }

    @Override
    @Transactional
    public void joinCourse(int studentId, int courseId) {
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);

        if (student != null && course != null) {
            student.addCourse(course);

        }}

        @Override
        @Transactional
        public void dropCourse ( int studentId, int courseId){
            Student student = entityManager.find(Student.class, studentId);
            Course course = entityManager.find(Course.class, courseId);

            if (student != null && course != null) {
                student.removeCourse(course);

        }}

        @Override
        public List<Course> getAllCourses () {
            TypedQuery<Course> query = entityManager.createQuery("FROM Course", Course.class);
            return query.getResultList();
        }

    @Override
    public Course_details findCourseDetailById(int theId) {
        return entityManager.find(Course_details.class, theId);
    }
}




