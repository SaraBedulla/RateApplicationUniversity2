package feedback.application.feedback.config;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.CourseService;
import feedback.application.feedback.service.FeedbackService;
import feedback.application.feedback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class InitialDataConfig {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private FeedbackService feedbackService;

    @Bean
    CommandLineRunner initDatabase(StudentService studentService) {
        return args -> {
            // Create and save some Student entities
            studentService.registerStudent(new Student(null,
                    "John", "Doe", "john.doe@example.com", "1234"));
            studentService.registerStudent(new Student(null,
                    "Jane", "Smith", "jane.smith@example.com", "1234"));
            studentService.registerStudent(new Student(null,
                    "Jane", "Smith", "a@a.com", "a"));

            // Create and save 10 random Course entities
            for (int i = 1; i <= 10; i++) {

                // init random course
                Course course = new Course();
                course.setTitle("Course " + i);
                course.setCredits(3);
                course.setDescription("Description for Course " + i);
                course.setInstructor("Instructor " + i);
                course.setCourseCode(i + "" + i + "" + i);
                course.setStartDate(LocalDate.now().plusDays(i));
                course.setEndDate(LocalDate.now().plusDays(i + 30));
                course.setLocation("Location " + i);
                courseService.saveCourse(course);

                //init random feedback
                for (Student student : studentService.findAllStudents()) {
                    course.getEnrolledStudents().add(student);

                    Feedback feedback = new Feedback();
                    feedback.setStudent(student);
                    feedback.setContent("Demo feedback " + i + " : " + student.getEmail());
                    feedback.setCreatedAt(LocalDate.now().plusDays(i));
                    feedback.setCourse(course);
                    feedback.setRating(new Random().nextInt(6));
                    feedbackService.saveFeedback(feedback);
                }

                courseService.saveCourse(course);
            }

        };
    }
}
