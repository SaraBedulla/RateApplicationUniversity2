package feedback.application.feedback;
import feedback.application.feedback.controller.CourseController;
import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.CourseService;
import feedback.application.feedback.service.FeedbackService;
import feedback.application.feedback.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class CourseControllerTest {
    @Mock
    private CourseService courseService;

    @Mock
    private StudentService studentService;

    @Mock
    private FeedbackService feedbackService;

    @Mock
    private Model model;

    @Mock
    private Principal principal;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testViewCourseDetails() {
        // Mock data
        Long courseId = 1L;
        Course course = new Course();
        course.setId(courseId);
        when(courseService.findCourseById(courseId)).thenReturn(Optional.of(course));

        // Mock authentication
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("test@example.com");

        // Mock student
        Student student = new Student();
        student.setEmail("test@example.com");
        when(studentService.findByEmail("test@example.com")).thenReturn(student);

        // Mock feedback
        when(feedbackService.hasStudentLeftFeedback(student, course)).thenReturn(false);

        // Test
        String result = courseController.viewCourseDetails(courseId, model);

        // Assertions
        assertEquals("course-view", result);
        verify(model).addAttribute("course", course);
        verify(model).addAttribute("student", student);
        verify(model).addAttribute("isRegister", true);
    }
    @Test
    void testListCourses() {
        // Mock authentication
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("test@example.com");

        // Mock student
        Student student = new Student();
        student.setEmail("test@example.com");
        when(studentService.findByEmail("test@example.com")).thenReturn(student);

        // Mock available courses
        List<Course> availableCourses = new ArrayList<>();
        when(courseService.findAllCourses()).thenReturn(availableCourses);

        // Test
        String result = courseController.listCourses(model);

        // Assertions
        assertEquals("course-list", result);
        verify(model).addAttribute("courses", availableCourses);
        verify(model).addAttribute("student", student);
    }

    @Test
    void testJoinCourse() {
        // Mock principal
        when(principal.getName()).thenReturn("test@example.com");

        // Mock student
        Student student = new Student();
        student.setEmail("test@example.com");
        when(studentService.findByEmail("test@example.com")).thenReturn(student);

        // Mock course
        Long courseId = 1L;
        Course course = new Course();
        when(courseService.findCourseById(courseId)).thenReturn(Optional.of(course));

        // Test
        String result = courseController.joinCourse(courseId, principal);

        // Assertions
        assertEquals("redirect:/courses", result);
        verify(course).getEnrolledStudents().add(student);
        verify(courseService).saveCourse(course);
    }

    @Test
    void testDropCourse() {
        // Mock principal
        when(principal.getName()).thenReturn("sara@yahoo.com");

        // Mock student
        Student student = new Student();
        student.setEmail("sara@yahoo.com");
        when(studentService.findByEmail("sara@yahoo.com")).thenReturn(student);

        // Mock course
        Long courseId = 1L;
        Course course = new Course();
        when(courseService.findCourseById(courseId)).thenReturn(Optional.of(course));

        // Test
        String result = courseController.dropCourse(courseId, principal);

        // Assertions
        assertEquals("redirect:/courses", result);
        verify(course).getEnrolledStudents().remove(student);
        verify(courseService).saveCourse(course);
    }

    @Test
    void testSearchCourses() {
        // Mock authentication
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("sara@yahoo.com");

        // Mock student
        Student student = new Student();
        student.setEmail("sara@yahoo.com");
        when(studentService.findByEmail("sara@yahoo.com")).thenReturn(student);

        // Mock search results
        List<Course> searchResults = new ArrayList<>();
        when(courseService.searchCourses("searchQuery")).thenReturn(searchResults);

        // Test
        String result = courseController.searchCourses("searchQuery", model);

        // Assertions
        assertEquals("course-list", result);
        verify(model).addAttribute("courses", searchResults);
        verify(model).addAttribute("student", student);
    }

    @Test
    void testShowFeedbackForm() {
        // Mock logged-in student
        Student student = new Student();
        when(courseController.getLoggedInStudent()).thenReturn(student);

        // Mock course
        Long courseId = 1L;
        Course course = new Course();
        when(courseService.findCourseById(courseId)).thenReturn(Optional.of(course));

        // Test
        String result = courseController.showFeedbackForm(courseId, model);

        // Assertions
        assertEquals("feedback-form", result);
        verify(model).addAttribute("course", course);
    }

    @Test
    void testSubmitFeedback() {
        // Mock logged-in student
        Student student = new Student();
        when(courseController.getLoggedInStudent()).thenReturn(student);

        // Mock course
        Long courseId = 1L;
        Course course = new Course();
        when(courseService.findCourseById(courseId)).thenReturn(Optional.of(course));

        // Mock request parameters
        int rating = 5;
        String content = "Great course!";

        // Test
        String result = courseController.submitFeedback(courseId, rating, content, model);

        // Assertions
        assertEquals("redirect:/courses", result);
        verify(feedbackService).saveFeedback(any());
}
}