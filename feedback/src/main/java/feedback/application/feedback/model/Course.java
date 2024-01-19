package feedback.application.feedback.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "credits")
    private Integer credits;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Feedback> feedbacks = new HashSet<>();


    public Course() {
    }


    public double getAverageRating() {
        double total = 0;
        for (Feedback feedback : feedbacks) {
            total += feedback.getRating();
        }

        if (feedbacks.isEmpty()) {
            return 0.00; // Handle the case where there are no feedbacks to avoid division by zero.
        }

        double average = total / feedbacks.size();
        BigDecimal roundedAverage = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);

        return roundedAverage.doubleValue();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Set<Feedback> getFeedbacks() {
        Set<Feedback> feedbacksSorted = new TreeSet<Feedback>(feedbacks);
        return feedbacksSorted;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                ", credits=" + credits +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}


