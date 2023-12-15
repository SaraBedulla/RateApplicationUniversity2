

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService{
    @Autowired
    CourseRepository repository;

    public List<Course> getAllCourses(){
        return repository.findAll();
    }
    public Course addNewCourse(Course course){
        return repository.save(course);
    }