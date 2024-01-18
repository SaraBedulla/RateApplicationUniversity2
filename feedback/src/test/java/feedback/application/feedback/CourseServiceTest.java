package feedback.application.feedback;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;
    private Course course;

    @BeforeEach
    public void before(){
        course = new Course();
        course.setTitle("Test Course");
        course.setCredits(3);
        course.setDescription("Test Description");
        course.setInstructor("Professor A");
        course.setCourseCode("B"+ new Random().nextInt(10000));
    }
    @Test
    public void testFindAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        assertThat(courses).isNotNull();
    }

    @Test
    public void testFindTopRatedCourses() {
        List<Course> topRatedCourses = courseService.findTopRatedCourses();
        assertThat(topRatedCourses).isNotNull();
    }

}
