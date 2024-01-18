package feedback.application.feedback.controller;
import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.CourseService;
import feedback.application.feedback.service.FeedbackService;
import feedback.application.feedback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FeedbackService feedbackService;


    @GetMapping("/{id}")
    public String viewCourseDetails(@PathVariable Long id, Model model) {
        // Retrieve the course by its ID
        Course course = courseService.findCourseById(id).orElse(null);

        if (course == null) {
            // Handle the case where the course is not found
            return "error"; // You can create an error page
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentService.findByEmail(email);
        model.addAttribute("student", student);
        // Add the course to the model to be displayed in the template
        model.addAttribute("course", course);
        if (student != null) {
            if (course.getEnrolledStudents().contains(student))
                model.addAttribute("isRegister", !feedbackService.hasStudentLeftFeedback(student, course));
        } else
            model.addAttribute("isRegister", false);
        // Return the course details template
        return "course-view";
    }
    @GetMapping("")
    public String listCourses(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        // Retrieve the student profile by email
        Student student = studentService.findByEmail(email);
        List<Course> availableCourses = courseService.findAllCourses();
        model.addAttribute("courses", availableCourses);
        model.addAttribute("student", student);
        return "course-list"; // Thymeleaf template for listing courses
    }
    @GetMapping("/join/{courseId}")
    public String joinCourse(@PathVariable Long courseId, Principal principal) {
        // Get the logged-in student based on the Principal
        Student student = studentService.findByEmail(principal.getName());

        // Find the course by courseId and add the student to it
        Optional<Course> course = courseService.findCourseById(courseId);
        course.get().getEnrolledStudents().add(student);
        courseService.saveCourse(course.get());

        return "redirect:/courses";
    }
    @GetMapping("/drop/{courseId}")
    public String dropCourse(@PathVariable Long courseId, Principal principal) {
        // Get the logged-in student based on the Principal
        Student student = studentService.findByEmail(principal.getName());

        // Find the course by courseId and remove the student from it
        Optional<Course> course = courseService.findCourseById(courseId);
        course.get().getEnrolledStudents().remove(student);
        courseService.saveCourse(course.get());

        return "redirect:/courses";
    }
    @GetMapping("/search")
    public String searchCourses(@RequestParam("searchQuery") String searchQuery, Model model) {
        List<Course> searchResults = courseService.searchCourses(searchQuery);

        // Retrieve the student profile by email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentService.findByEmail(email);

        model.addAttribute("courses", searchResults);
        model.addAttribute("student", student);
        return "course-list";
    }

    @GetMapping("/leave-feedback/{courseId}")
    public String showFeedbackForm(@PathVariable Long courseId, Model model) {
        // Check if the student is registered for the course
        Student student = getLoggedInStudent(); // Implement this method to get the logged-in student
        Optional<Course> course = courseService.findCourseById(courseId);

        model.addAttribute("course", course.get());
        return "feedback-form";
    }


    @PostMapping("/leave-feedback/{id}")
    public String submitFeedback(@PathVariable Long id, @RequestParam int rating, @RequestParam String content, Model model) {
        try {
            Student student = getLoggedInStudent(); // Implement this method to get the logged-in student
            Optional<Course> course = courseService.findCourseById(id);

            if (student != null && course.isPresent() && course.get().getEnrolledStudents().contains(student)) {
                Feedback feedback = new Feedback();
                feedback.setStudent(student);
                feedback.setCourse(course.get());
                feedback.setRating(rating);
                feedback.setContent(content);
                feedback.setCreatedAt(new Date());

                feedbackService.saveFeedback(feedback);
            }

            return "redirect:/courses";
        } catch (Exception e) {
            // Check if the student is registered for the course
            Optional<Course> course = courseService.findCourseById(id);
            model.addAttribute("course", course.get());
            model.addAttribute("errorMessage", "Feedback length can't be extend then 1000 character");
            return "feedback-form";
        }
    }
    private Student getLoggedInStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return studentService.findByEmail(email);
    }


}
