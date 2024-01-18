package feedback.application.feedback.repository;


import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    void deleteByCreatedAtBefore(LocalDate date);
    Optional<Feedback> findByStudentAndCourse(Student student, Course course);
}
