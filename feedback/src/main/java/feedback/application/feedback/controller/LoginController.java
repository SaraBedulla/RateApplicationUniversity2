package feedback.application.feedback.controller;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.StudentService;
import feedback.application.feedback.service.UserDetail;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String login(Model model) {

        // Retrieve the currently logged-in student's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentService.findByEmail(email);

        model.addAttribute("student", student);
        return "login";
    }

}


