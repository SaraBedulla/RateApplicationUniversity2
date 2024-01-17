package feedback.application.feedback.controller;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.CourseService;
import feedback.application.feedback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public String home(Model model) {
        // Retrieve the currently logged-in student's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentService.findByEmail(email);

        // Pass the student profile data to the template
        model.addAttribute("student", student);

        // filter top-rated 8 courses
        model.addAttribute("courses", courseService.findTopRatedCourses());

        return "home";
    }
}
