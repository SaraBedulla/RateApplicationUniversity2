package feedback.application.feedback.controller;
import feedback.application.feedback.model.Course;
import feedback.application.feedback.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/course/{id}")
    public String viewCourseDetails(@PathVariable Long id, Model model) {
        // Retrieve the course by its ID
        Course course = courseService.findCourseById(id).orElse(null);

        if (course == null) {
            // Handle the case where the course is not found
            return "error"; // You can create an error page
        }

        // Add the course to the model to be displayed in the template
        model.addAttribute("course", course);

        // Return the course details template
        return "course-view";
    }
}
