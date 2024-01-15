package feedback.application.feedback.service;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        bCryptPasswordEncoder =
                new BCryptPasswordEncoder(); // password encryption from spring security
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Student registerStudent(Student student) {
        // Check if email is already in use
        Optional<Student> existingStudent = Optional.ofNullable(studentRepository.findByEmail(student.getEmail()));
        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        // Encrypt the password before saving (use a proper encryption mechanism)
        student.setPassword(encryptPassword(student.getPassword()));
        return studentRepository.save(student);
    }

    // Utility methods for password encryption
    private String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}


