package feedback.application.feedback.service;

import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

//    @Autowired
//    public FeedbackService(FeedbackRepository feedbackRepository) {
//        this.feedbackRepository = feedbackRepository;
//    }

    public List<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> findFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

}

