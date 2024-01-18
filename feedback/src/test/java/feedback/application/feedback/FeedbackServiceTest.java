package feedback.application.feedback;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.repository.FeedbackRepository;
import feedback.application.feedback.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    private Student student;
    private Course course;
    private Feedback feedback;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("johndoe@example.com");

        course = new Course();
        course.setId(1L);
        course.setTitle("Test Course");

        feedback = new Feedback();
        feedback.setId(1L);
        feedback.setStudent(student);
        feedback.setCourse(course);
        feedback.setRating(4);
        feedback.setContent("Test feedback content");
    }





}
