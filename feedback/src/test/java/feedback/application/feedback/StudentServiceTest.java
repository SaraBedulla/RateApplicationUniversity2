package feedback.application.feedback;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    private Student student;

    @BeforeEach
    public void beforeEach() {
        student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("johndoe@example.com");
        student.setPassword("password");
    }

    @Test
    public void testFindAllStudents() {
        List<Student> students = studentService.findAllStudents();
        assertThat(students).isNotNull();
    }

    @Test
    public void testFindStudentByIdAndEmailSaveDelete() {
        Student registeredStudent = studentService.registerStudent(student);
        assertThat(registeredStudent).isNotNull();
        assertThat(registeredStudent.getId()).isNotNull();

        // Assuming you have an existing student with email "johndoe@example.com"
        String emailToFind = "johndoe@example.com";
        Student foundStudent1 = studentService.findByEmail(emailToFind);
        assertThat(foundStudent1).isNotNull();

        Optional<Student> foundStudent = studentService.findStudentById(registeredStudent.getId());
        assertThat(foundStudent).isPresent();

        studentService.deleteStudent(registeredStudent.getId());
        Optional<Student> deletedStudent = studentService.findStudentById(registeredStudent.getId());
        assertThat(deletedStudent).isEmpty();
    }

}

