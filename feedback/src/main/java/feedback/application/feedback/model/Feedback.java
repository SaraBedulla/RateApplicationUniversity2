package feedback.application.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "feedback")
public class Feedback implements Comparable<Feedback>, Comparator<Feedback> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Course course;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "rating")
    private int rating;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public Feedback() {
    }

    public Feedback(Long id, Course course, Student student, String content, int rating, Date createdAt) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.content = content;
        this.rating = rating;
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compare(Feedback o1, Feedback o2) {
        return o1.getCreatedAt().compareTo(o2.createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public int compareTo(Feedback o) {
        return compare(this, o);
    }

}

