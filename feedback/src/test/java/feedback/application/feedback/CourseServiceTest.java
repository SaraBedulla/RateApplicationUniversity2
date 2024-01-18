package feedback.application.feedback;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

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


}
