package com.project.rateuniapp;

import com.project.rateuniapp.dao.AppDAO;
import com.project.rateuniapp.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@EnableScheduling
@SpringBootApplication
public class RateuniappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateuniappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner ->
				//createInstructor(appDAO);
				//findInstructorById(appDAO);
				//deleteInstructor(appDAO);

				//createInstructorWithCourses(appDAO);
				//findInstructorWithCourses(appDAO);
				//findCoursesForInstructor(appDAO);
				//findInstructorWithCoursesJoinFetch(appDAO);
				//createCourseAndReviews(appDAO);
				//retrieveCourseAndReviews(appDAO);

				//deleteCourseAndReviews(appDAO);
				//deleteCourse(appDAO);
				//createCourseAndStudents(appDAO);
				//findCourseAndStudents(appDAO);
				findStudentAndCourses(appDAO);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());
		System.out.println("Done");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 2;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
		System.out.println("Done!!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course2 = new Course("Machine Learning");
		Student student3 = new Student("John", "Pinkman", "jdoe@gmail.com");
		Student student4 = new Student("Jane", "Smith", "janesmith@gmail.com");
		course2.addStudent(student3);
		course2.addStudent(student4);
		System.out.println("Saving the course: " + course2);
		System.out.println("Associated students: " + course2.getStudents());
		appDAO.save(course2);
		System.out.println("Done!");


		Course course3 = new Course("Computer Networks");
		Student student5 = new Student("Michael", "Johnson", "mjohnson@gmail.com");
		Student student6 = new Student("Emily", "Clark", "eclark@gmail.com");
		course3.addStudent(student5);
		course3.addStudent(student6);
		System.out.println("Saving the course: " + course3);
		System.out.println("Associated students: " + course3.getStudents());
		appDAO.save(course3);
		System.out.println("Done!");


		Course course4 = new Course("Web Development");
		Student student7 = new Student("David", "Williams", "dwilliams@gmail.com");
		Student student8 = new Student("Sophia", "Adams", "sadams@gmail.com");
		course4.addStudent(student7);
		course4.addStudent(student8);
		System.out.println("Saving the course: " + course4);
		System.out.println("Associated students: " + course4.getStudents());
		appDAO.save(course4);
		System.out.println("Done!");

		Course course5 = new Course("Database Management");
		Student student9 = new Student("Daniel", "Smith", "dsmith@gmail.com");
		Student student10 = new Student("Olivia", "Brown", "obrown@gmail.com");
		course5.addStudent(student9);
		course5.addStudent(student10);
		System.out.println("Saving the course: " + course5);
		System.out.println("Associated students: " + course5.getStudents());
		appDAO.save(course5);
		System.out.println("Done!\n");

		// Course 6
		Course course6 = new Course("Software Engineering");
		Student student11 = new Student("Ethan", "Davis", "edavis@gmail.com");
		Student student12 = new Student("Ava", "Moore", "amoore@gmail.com");
		course6.addStudent(student11);
		course6.addStudent(student12);
		System.out.println("Saving the course: " + course6);
		System.out.println("Associated students: " + course6.getStudents());
		appDAO.save(course6);
		System.out.println("Done!\n");

		Course course7 = new Course("Computer Graphics");
		Student student13 = new Student("Logan", "Martin", "lmartin@gmail.com");
		Student student14 = new Student("Chloe", "Wilson", "cwilson@gmail.com");
		course7.addStudent(student13);
		course7.addStudent(student14);
		System.out.println("Saving the course: " + course7);
		System.out.println("Associated students: " + course7.getStudents());
		appDAO.save(course7);
		System.out.println("Done!\n");

		// Course 8
		Course course8 = new Course("Art History");
		Student student15 = new Student("Christopher", "Clark", "cclark@gmail.com");
		Student student16 = new Student("Mia", "Anderson", "manderson@gmail.com");
		course8.addStudent(student15);
		course8.addStudent(student16);
		System.out.println("Saving the course: " + course8);
		System.out.println("Associated students: " + course8.getStudents());
		appDAO.save(course8);
		System.out.println("Done!\n");

		Course course9 = new Course("Psychology");
		Student student17 = new Student("Elijah", "White", "ewhite@gmail.com");
		Student student18 = new Student("Scarlett", "Taylor", "staylor@gmail.com");
		course9.addStudent(student17);
		course9.addStudent(student18);
		System.out.println("Saving the course: " + course9);
		System.out.println("Associated students: " + course9.getStudents());
		appDAO.save(course9);
		System.out.println("Done!\n");

		// Course 10
		Course course10 = new Course("Environmental Science");
		Student student19 = new Student("Jackson", "Hill", "jhill@gmail.com");
		Student student20 = new Student("Penelope", "Moore", "pmoore@gmail.com");
		course10.addStudent(student19);
		course10.addStudent(student20);
		System.out.println("Saving the course: " + course10);
		System.out.println("Associated students: " + course10.getStudents());
		appDAO.save(course10);
		System.out.println("Done!\n");

		Course course11 = new Course("Chemistry");
		Student student21 = new Student("Caleb", "Davis", "cdavis@gmail.com");
		Student student22 = new Student("Hazel", "Wilson", "hwilson@gmail.com");
		course11.addStudent(student21);
		course11.addStudent(student22);
		System.out.println("Saving the course: " + course11);
		System.out.println("Associated students: " + course11.getStudents());
		appDAO.save(course11);
		System.out.println("Done!\n");

		// Course 12
		Course course12 = new Course("Mathematics");
		Student student23 = new Student("Lucas", "Thomas", "lthomas@gmail.com");
		Student student24 = new Student("Lily", "Anderson", "landerson@gmail.com");
		course12.addStudent(student23);
		course12.addStudent(student24);
		System.out.println("Saving the course: " + course12);
		System.out.println("Associated students: " + course12.getStudents());
		appDAO.save(course12);
		System.out.println("Done!\n");

		Course course13 = new Course("Literature");
		Student student25 = new Student("Owen", "Williams", "owilliams@gmail.com");
		Student student26 = new Student("Eva", "Moore", "emoore@gmail.com");
		course13.addStudent(student25);
		course13.addStudent(student26);
		System.out.println("Saving the course: " + course13);
		System.out.println("Associated students: " + course13.getStudents());
		appDAO.save(course13);
		System.out.println("Done!\n");

		// Course 14
		Course course14 = new Course("Music Theory");
		Student student27 = new Student("Carter", "Brown", "cbrown@gmail.com");
		Student student28 = new Student("Zara", "Taylor", "ztaylor@gmail.com");
		course14.addStudent(student27);
		course14.addStudent(student28);
		System.out.println("Saving the course: " + course14);
		System.out.println("Associated students: " + course14.getStudents());
		appDAO.save(course14);
		System.out.println("Done!\n");

		// Course 15
		Course course15 = new Course("Data Science");
		Student student29 = new Student("Robert", "Johnson", "rjohnson@gmail.com");
		Student student30 = new Student("Alice", "White", "awhite@gmail.com");
		course15.addStudent(student29);
		course15.addStudent(student30);
		System.out.println("Saving the course: " + course15);
		System.out.println("Associated students: " + course15.getStudents());
		appDAO.save(course15);
		System.out.println("Done!");

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theID = 10;
		System.out.println("Deleting course id " + theID);
		appDAO.deleteCourseById(theID);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 2;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId)
		;
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Cybersecurity");

		tempCourse.addReview(new Review("Loved it!"));
		tempCourse.addReview(new Review("It was great!"));
		tempCourse.addReview(new Review("hmm!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);

		System.out.println("Done!");


		Course dataScienceCourse = new Course("Data Science");

		dataScienceCourse.addReview(new Review("Amazing content!"));
		dataScienceCourse.addReview(new Review("Very informative."));
		dataScienceCourse.addReview(new Review("I learned a lot!"));

		System.out.println("Saving the course");
		System.out.println(dataScienceCourse);
		System.out.println(dataScienceCourse.getReviews());
		appDAO.save(dataScienceCourse);
		System.out.println("Done!");


		Course tempCourse1 = new Course("Web Development Basics");

		tempCourse1.addReview(new Review("Excellent introductory course!"));
		tempCourse1.addReview(new Review("Practical exercises were very helpful."));
		tempCourse1.addReview(new Review("Loved the hands-on approach!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse1);
		System.out.println(tempCourse1.getReviews());
		appDAO.save(tempCourse1);

		System.out.println("Done!");


		Course tempCourse2 = new Course("Data Science Essentials");

		tempCourse2.addReview(new Review("Top-notch material!"));
		tempCourse2.addReview(new Review("Great balance between theory and application."));
		tempCourse2.addReview(new Review("Very informative, loved it!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse2);
		System.out.println(tempCourse2.getReviews());
		appDAO.save(tempCourse2);
		System.out.println("Done!");


		Course tempCourse3 = new Course("Mobile App Development Mastery");
		tempCourse3.addReview(new Review("Fantastic course content!"));
		tempCourse3.addReview(new Review("Helped me enhance my mobile app skills."));
		tempCourse3.addReview(new Review("Highly recommended!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse3);
		System.out.println(tempCourse3.getReviews());
		appDAO.save(tempCourse3);
		System.out.println("Done!");

		Course tempCourse4 = new Course("Cloud Computing Basics");

		tempCourse4.addReview(new Review("Very informative and well-structured."));
		tempCourse4.addReview(new Review("Helped me grasp cloud concepts easily."));
		tempCourse4.addReview(new Review("Thoroughly enjoyed it!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse4);
		System.out.println(tempCourse4.getReviews());
		appDAO.save(tempCourse4);

		System.out.println("Done!");


		Course tempCourse5 = new Course("Music");

		tempCourse5.addReview(new Review("Insightful course!"));
		tempCourse5.addReview(new Review("Well-explained concepts and examples."));
		tempCourse5.addReview(new Review("Great learning experience!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse5);
		System.out.println(tempCourse5.getReviews());
		appDAO.save(tempCourse5);
		System.out.println("Done!");


		Course tempCourse6 = new Course("Machine Learning Applications");

		tempCourse6.addReview(new Review("Practical insights into ML applications!"));
		tempCourse6.addReview(new Review("Well-structured course with real-world examples."));
		tempCourse6.addReview(new Review("Highly recommended for ML enthusiasts!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse6);
		System.out.println(tempCourse6.getReviews());
		appDAO.save(tempCourse6);
		System.out.println("Done!");


		Course tempCourse7 = new Course("UX Design Principles");

		tempCourse7.addReview(new Review("Excellent course for UX enthusiasts!"));
		tempCourse7.addReview(new Review("Practical insights into designing user-friendly interfaces."));
		tempCourse7.addReview(new Review("Loved the case studies!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse7);
		System.out.println(tempCourse7.getReviews());
		appDAO.save(tempCourse7);

		System.out.println("Done!");


		Course tempCourse8 = new Course("Python Programming Basics");
		tempCourse8.addReview(new Review("Great introduction to Python!"));
		tempCourse8.addReview(new Review("Helped me build a solid foundation in programming."));
		tempCourse8.addReview(new Review("Fantastic exercises!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse8);
		System.out.println(tempCourse8.getReviews());
		appDAO.save(tempCourse8);
		System.out.println("Done!");


		Course tempCourse9 = new Course("DevOps Essentials");

		tempCourse9.addReview(new Review("Great insights into DevOps practices!"));
		tempCourse9.addReview(new Review("Practical exercises were beneficial."));
		tempCourse9.addReview(new Review("Highly recommended for IT professionals!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse9);
		System.out.println(tempCourse9.getReviews());
		appDAO.save(tempCourse9);

		System.out.println("Done!");


		Course tempCourse10 = new Course("Art");

		tempCourse10.addReview(new Review("Invaluable insights!"));
		tempCourse10.addReview(new Review("Practical."));
		tempCourse10.addReview(new Review("Loved the hands-on design projects!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse10);
		System.out.println(tempCourse10.getReviews());
		appDAO.save(tempCourse10);

		System.out.println("Done!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor " + tempInstructor);
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done");


	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor1 = new Instructor("Sally", "Baker", "sally.com");

		Course tempcourse1 = new Course("Piano");
		Course tempcourse2 = new Course("Video games");

		tempInstructor1.add(tempcourse1);
		tempInstructor1.add(tempcourse2);

		System.out.println("Saving instructor " + tempInstructor1);
		System.out.println("The courses: " + tempInstructor1.getCourses());
		appDAO.save(tempInstructor1);
		System.out.println("Done");


		Instructor instructor1 = new Instructor("Doris", "Kole", "doris.kole@yahoo.com");
		Course course1_1 = new Course("Maths");
		Course course1_2 = new Course("English");
		instructor1.add(course1_1);
		instructor1.add(course1_2);
		System.out.println("Saving instructor " + instructor1);
		System.out.println("The courses: " + instructor1.getCourses());
		appDAO.save(instructor1);
		System.out.println("Done");

		// Instructor 2
		Instructor instructor2 = new Instructor("John", "Pinkman", "john@gmail.com");
		Course course2_1 = new Course("Programming");
		Course course2_2 = new Course("Web Development");
		instructor2.add(course2_1);
		instructor2.add(course2_2);
		System.out.println("Saving instructor " + instructor2);
		System.out.println("The courses: " + instructor2.getCourses());
		appDAO.save(instructor2);
		System.out.println("Done");

		Instructor instructor3 = new Instructor("Alice", "Johnson", "alice@yahoo.com");
		Course course3_1 = new Course("Photography");
		Course course3_2 = new Course("Graphic Design");
		instructor3.add(course3_1);
		instructor3.add(course3_2);
		System.out.println("Saving instructor " + instructor3);
		System.out.println("The courses: " + instructor3.getCourses());
		appDAO.save(instructor3);
		System.out.println("Done");


		Instructor instructor4 = new Instructor("Robert", "Williams", "robert@yahoo.com");
		Course course4_1 = new Course("Art History");
		instructor4.add(course4_1);
		System.out.println("Saving instructor " + instructor4);
		System.out.println("The courses: " + instructor4.getCourses());
		appDAO.save(instructor4);
		System.out.println("Done");


		Instructor instructor5 = new Instructor("Emma", "Davis", "emma@gmail.com");
		Course course5_1 = new Course("Marketing");
		Course course5_2 = new Course("Business Strategy");
		instructor5.add(course5_1);
		instructor5.add(course5_2);
		System.out.println("Saving instructor " + instructor5);
		System.out.println("The courses: " + instructor5.getCourses());
		appDAO.save(instructor5);
		System.out.println("Done");


		Instructor instructor6 = new Instructor("Daniel", "Clark", "daniel@gmail.com");
		Course course6_1 = new Course("Physics");
		Course course6_2 = new Course("Chemistry");
		instructor6.add(course6_1);
		instructor6.add(course6_2);
		System.out.println("Saving instructor " + instructor6);
		System.out.println("The courses: " + instructor6.getCourses());
		appDAO.save(instructor6);
		System.out.println("Done");


		Instructor instructor7 = new Instructor("Olivia", "Moore", "olivia@gmail.com");
		Course course7_1 = new Course("Dance");
		Course course7_2 = new Course("Theater");
		instructor7.add(course7_1);
		instructor7.add(course7_2);
		System.out.println("Saving instructor " + instructor7);
		System.out.println("The courses: " + instructor7.getCourses());
		appDAO.save(instructor7);
		System.out.println("Done");


		Instructor instructor8 = new Instructor("Liam", "Anderson", "liam@gmail.com");
		Course course8_1 = new Course("History");
		Course course8_2 = new Course("Political Science");
		instructor8.add(course8_1);
		instructor8.add(course8_2);
		System.out.println("Saving instructor " + instructor8);
		System.out.println("The courses: " + instructor8.getCourses());
		appDAO.save(instructor8);
		System.out.println("Done");


		Instructor instructor9 = new Instructor("Ava", "Harris", "ava@yahoo.com");
		Course course9_1 = new Course("Biology");
		Course course9_2 = new Course("Ecology");
		instructor9.add(course9_1);
		instructor9.add(course9_2);
		System.out.println("Saving instructor " + instructor9);
		System.out.println("The courses: " + instructor9.getCourses());
		appDAO.save(instructor9);
		System.out.println("Done");

		Instructor instructor10 = new Instructor("Robert", "Potter", "rob@gmail.com");
		Course course10_1 = new Course("Geometry");
		Course course10_2 = new Course("Algebra");
		instructor10.add(course10_1);
		instructor10.add(course10_2);
		System.out.println("Saving instructor " + instructor10);
		System.out.println("The courses: " + instructor10.getCourses());
		appDAO.save(instructor9);
		System.out.println("Done");


		private void deleteInstructor(AppDAO appDAO) {
			int theId = 1;
			System.out.println("Deleting instructor id: " + theId);
			appDAO.deleteInstructorById(theId);
			System.out.println("Done");
		}

		private void findInstructorById(AppDAO appDAO) {
			int theId = 1;
			System.out.println("Finding instructor id " + theId);
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			System.out.println("tempInstructor: " + tempInstructor);
		}


		;


	}
}
