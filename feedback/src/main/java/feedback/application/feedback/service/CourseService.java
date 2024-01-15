package feedback.application.feedback.service;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;




    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findTopRatedCourses() {
        List<Course> all = courseRepository.findAll();
        all.sort((o1, o2) -> (int) (o2.getAverageRating() - o1.getAverageRating()));
        return all.subList(0, 8);
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }



}

