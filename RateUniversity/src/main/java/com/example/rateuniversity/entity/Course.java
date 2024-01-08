package com.example.rateuniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity

@Table(name="course")
public class Course{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private int id ;
   @Column(name = "title")
    private String title;
   @Column(name="description")
   private String description;
    @Column(name="course_times")
    private String course_times;
    @Column(name="lecture_hall_location")
    private String lecture_hall_location;



   @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
   @JoinColumn(name = "instructor_id")
    private Instructor instructor;
   @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name = "course_id")
   private List<Review> reviews;

    public String getCourse_times() {
        return course_times;
    }

    public void setCourse_times(String course_times) {
        this.course_times = course_times;
    }

    public String getLecture_hall_location() {
        return lecture_hall_location;
    }

    public void setLecture_hall_location(String lecture_hall_location) {
        this.lecture_hall_location = lecture_hall_location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch=FetchType.LAZY,
            cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
   @JoinTable(
           name = "course_student",
           joinColumns = @JoinColumn(name = "course_id"),
           inverseJoinColumns=@JoinColumn(name = "student_id")
   )
    private List<Student> students;


    public Course(){

    };

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student theStudent){
        if(students==null){
            students=new ArrayList<>();
        }
        students.add(theStudent);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", course_times='" + course_times + '\'' +
                ", lecture_hall_location='" + lecture_hall_location + '\'' +



                '}';
    }
}

}
