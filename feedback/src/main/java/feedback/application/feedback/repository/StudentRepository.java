package feedback.application.feedback.repository;
import feedback.application.feedback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}

