package feedback.application.feedback.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/calendar")
public class CalenderController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String viewCourseDetails(Model model) {
        // Retrieve the student profile by email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentService.findByEmail(email);

        List<Course> courses = courseService.findAllCourses();
        List<Course> registerCourses = new ArrayList<>();
        courses.forEach(c -> {
            if(c.getEnrolledStudents().contains(student)){
                registerCourses.add(c);
            }
        });

        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the courses list to JSON
            String coursesJson = objectMapper.writeValueAsString(registerCourses);

            // Add the JSON data to the model
            model.addAttribute("courses", coursesJson);
            model.addAttribute("student", student);

        } catch (JsonProcessingException e) {
            // Handle any exceptions that may occur during JSON conversion
            e.printStackTrace();
        }

        return "calender-view";
    }
}

