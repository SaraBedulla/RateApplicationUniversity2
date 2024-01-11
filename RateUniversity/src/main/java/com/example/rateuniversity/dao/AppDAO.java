package com.project.rateuniapp.dao;

import com.project.rateuniapp.entity.*;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);


    void saveReview(Review review);

    Course findCourseAndStudentsByCourseId(int theId);

    Review findReviewById(int id);

    void deleteReviewById(int id);

    List<Course> getTopRatedCoursesForStudent(int studentId, int count);

    void joinCourse(int studentId, int courseId);

    void dropCourse(int studentId, int courseId);

    List<Course> getAllCourses();
    Course_details findCourseDetailById(int theId);

}