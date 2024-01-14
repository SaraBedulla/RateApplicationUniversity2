package feedback.application.feedback.controller;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginStudent(Student student, Model model) {
        // Check if the student exists and the password is correct
        Student foundStudent = studentService.findByEmail(student.getEmail());
        if (foundStudent != null && foundStudent.getPassword().equals(student.getPassword())) {
            // Redirect to a different page upon successful login
            return "redirect:/somePage";
        } else {
            // If login fails, return back to the login page with an error message
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}


