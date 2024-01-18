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
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Configuration
public class InitialDataConfig {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private FeedbackService feedbackService;


    private final String[] courseNames = {
            "Introduction to Computer Science",
            "Calculus I",
            "English Composition",
            "Introduction to Psychology",
            "World History",
            "Physics for Scientists and Engineers",
            "Principles of Marketing",
            "Organic Chemistry",
            "Microeconomics",
            "Introduction to Sociology",
            "Data Structures and Algorithms",
            "Principles of Accounting",
            "Art History",
            "Environmental Science",
            "Business Ethics"
    };

    private final String[] courseDescriptions = {
            "A comprehensive introduction to computer science principles and programming.",
            "Fundamental concepts of calculus including limits, derivatives, and integrals.",
            "Develop effective writing skills for academic and professional communication.",
            "Explore the basics of psychology and human behavior.",
            "Study major historical events and their impact on the world.",
            "Physics principles for students in science and engineering programs.",
            "Learn marketing concepts and strategies for businesses.",
            "In-depth study of organic chemistry compounds and reactions.",
            "Analyze microeconomic principles and decision-making.",
            "Introduction to sociological concepts and theories.",
            "Advanced data structures and algorithm design.",
            "Principles of financial accounting and reporting.",
            "Survey of art history from ancient civilizations to modern art movements.",
            "Examine environmental issues and sustainability.",
            "Ethical decision-making in the business world."
    };

//
//    @Bean
//    CommandLineRunner initDatabase(StudentService studentService) {
//        return args -> {
//            // Create and save some Student entities
//            studentService.registerStudent(new Student(null,
//                    "John", "Doe", "john.doe@example.com", "1234"));
//            studentService.registerStudent(new Student(null,
//                    "Jane", "Smith", "jane.smith@example.com", "1234"));
//            studentService.registerStudent(new Student(null,
//                    "Jane", "Smith", "a@a.com", "a"));
//
//            // Create and save 15 realistic Course entities
//            for (int i = 0; i < courseNames.length; i++) {
//
//                // Initialize realistic course
//                Course course = new Course();
//                course.setTitle(courseNames[i]);
//                course.setCredits(3);
//                course.setDescription(courseDescriptions[i]);
//                course.setInstructor("Professor " + (i + 1));
//                course.setCourseCode("COURSE-" + (i + 1));
//
//                Calendar startCalendar = Calendar.getInstance();
//                startCalendar.add(Calendar.DAY_OF_MONTH, (i * i) + 1);
//                course.setStartDate(startCalendar.getTime());
//
//                Calendar endCalendar = Calendar.getInstance();
//                endCalendar.add(Calendar.DAY_OF_MONTH, (i * i) + 10);
//                course.setEndDate(endCalendar.getTime());
//
//                course.setLocation("Campus " + (i + 1));
//                courseService.saveCourse(course);
//
//                // Initialize realistic feedback for enrolled students
//                List<Student> enrolledStudents = studentService.findAllStudents();
//
//                int count = 5;
//                for (Student student : enrolledStudents) {
//                    course.getEnrolledStudents().add(student);
//
//                    Feedback feedback = new Feedback();
//                    feedback.setStudent(student);
//                    feedback.setContent("I really enjoyed " + course.getTitle() + ". The content was engaging, and the instructor was knowledgeable.");
//
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.add(Calendar.DAY_OF_MONTH, (i * i) + (count--));
//                    feedback.setCreatedAt(calendar.getTime());
//
//                    feedback.setCourse(course);
//                    feedback.setRating(new Random().nextInt(3) + 3); // Random rating between 3 and 5
//                    feedbackService.saveFeedback(feedback);
//                }
//
//                courseService.saveCourse(course);
//            }
//        };
//    }
}
