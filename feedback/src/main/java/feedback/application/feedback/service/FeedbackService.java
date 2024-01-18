package feedback.application.feedback.service;

import feedback.application.feedback.model.Course;
import feedback.application.feedback.model.Feedback;
import feedback.application.feedback.model.Student;
import feedback.application.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;


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

    public boolean hasStudentLeftFeedback(Student student, Course course) {
        return feedbackRepository.findByStudentAndCourse(student, course).isPresent();
    }

    public List<Feedback> findAllByStudent(Student student) {
        List<Feedback> feedbacks = new ArrayList<>();
        for (Feedback feedback:findAllFeedbacks()){
            if(feedback.getStudent().equals(student)){
                feedbacks.add(feedback);
            }
        }
        return feedbacks;
    }

}

