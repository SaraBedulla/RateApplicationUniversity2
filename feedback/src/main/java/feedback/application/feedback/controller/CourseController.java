package feedback.application.feedback.controller;
import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.CourseService;
import feedback.application.feedback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @Autowired
    private StudentService studentService;
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
        // Add the course to the model to be displayed in the template
        model.addAttribute("course", course);

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

}
