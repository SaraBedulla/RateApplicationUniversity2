package feedback.application.feedback.repository;


import feedback.application.feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    void deleteByCreatedAtBefore(LocalDate date);
}
