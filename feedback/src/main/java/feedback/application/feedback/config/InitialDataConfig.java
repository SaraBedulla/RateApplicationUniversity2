package feedback.application.feedback.config;

import feedback.application.feedback.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataConfig {

    @Bean
    CommandLineRunner initDatabase(StudentService studentService) {
        return args -> {
//             Create and save some Student entities
//            studentService.registerStudent(new Student(null, "John", "Doe", "john.doe@gmail.com", "password123"));
//            studentService.registerStudent(new Student(null, "Jane", "Smith", "jane.smith@gmail.com", "password123"));
        };
    }
}
