package feedback.application.feedback;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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
    public void testGetterSetterMethods() {
        // Create a new Course instance
        Course course = new Course();

        // Set values using setter methods
        course.setId(1L);
        course.setCourseCode("CS101");
        course.setTitle("Introduction to Computer Science");
        course.setDescription("This is a sample course description.");
        course.setLocation("Online");
        course.setInstructor("John Doe");
        course.setCredits(3);
        course.setStartDate(new Date());
        course.setEndDate(new Date());

        // Verify getter methods return expected values
        assertThat(course.getId()).isEqualTo(1L);
        assertThat(course.getCourseCode()).isEqualTo("CS101");
        assertThat(course.getTitle()).isEqualTo("Introduction to Computer Science");
        assertThat(course.getDescription()).isEqualTo("This is a sample course description.");
        assertThat(course.getLocation()).isEqualTo("Online");
        assertThat(course.getInstructor()).isEqualTo("John Doe");
        assertThat(course.getCredits()).isEqualTo(3);
        assertThat(course.getStartDate()).isNotNull();
        assertThat(course.getEndDate()).isNotNull();
    }


    @Test
    public void testSearchCourses() {
        String searchQuery = "example";
        List<Course> matchingCourses = courseService.searchCourses(searchQuery);
        assertThat(matchingCourses).isNotNull();
    }
}
