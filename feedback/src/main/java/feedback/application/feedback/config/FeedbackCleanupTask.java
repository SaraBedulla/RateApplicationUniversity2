package feedback.application.feedback.config;

import feedback.application.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class FeedbackCleanupTask {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Scheduled(cron = "0 0 */4 * * ?") // Run every 4 hours
    public void removeOldFeedback() {
        // Calculate the date 1 year ago from the current date
        LocalDate oneYearAgo = LocalDate.now().minus(1, ChronoUnit.YEARS);

        // Query and delete old feedback entries
        feedbackRepository.deleteByCreatedAtBefore(oneYearAgo);
    }
}
