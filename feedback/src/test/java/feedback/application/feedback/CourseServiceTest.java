package feedback.application.feedback;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
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
    @Test
    public void testFindCourseById() {
        Long courseId = 1L; // Replace with an existing course ID
        Optional<Course> course = courseService.findCourseById(courseId);
        assertThat(course).isPresent();
    }
    @Test
    public void testSaveCourse() {
        courseService.saveCourse(course);
        assertThat(course).isNotNull();
        assertThat(course.getId()).isNotNull();
    }
    @Test
    public void testDeleteCourse() {
        courseService.saveCourse(course);
        courseService.deleteCourse(course.getId());
        Optional<Course> deletedCourse = courseService.findCourseById(course.getId());
        assertThat(deletedCourse).isEmpty();
    }
    @Test
    public void testSearchCourses() {
        String searchQuery = "example";
        List<Course> matchingCourses = courseService.searchCourses(searchQuery);
        assertThat(matchingCourses).isNotNull();
    }
}
