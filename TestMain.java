package scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
	
	public static void main(String[] args) {
		
		//System.out.println("**Testing Student and Course Class**");
		//System.out.println();
		
		//create new course objects
//		Course preference1 = new Course("COMPSCI190D", 20);
//		Course preference2 = new Course("Clouseau", 1);
//		
//		//put the course objects in a course list
//		List<Course> CourseList = new ArrayList<Course>();
//		CourseList.add(preference1);
//		CourseList.add(preference2);
//		
//		//use the course list to instantiate a student object
//		Student student1 = new Student("Cato", 5, CourseList);
//		
//		System.out.println("Student 1's name: ");
//		
//		System.out.println(student1.getName());
//		
//		System.out.println("Student 1's max courses: ");
//		
//		System.out.println(student1.getMaxCourses());
//		
//		List<Course> displayPreference = student1.getPreferences();
//		
//		System.out.println("Display Course Preferences of Student 1: ");
//		
//		for (int i = 0 ; i < displayPreference.size(); i++) {
//			
//			System.out.println(displayPreference.get(i).getCourseNumber() + 
//							  "\tMax Capacity: " + displayPreference.get(i).getCapacity());
//		}
//		
//		System.out.println();
//		System.out.println();
		
//		System.out.println("**Testing Scheduler Class**");
//		System.out.println();
//		
//		Scheduler schedule = new Scheduler();
//		
//		System.out.println("The Starting Number of Students and Courses");
//		
//		System.out.println(schedule.getStudents().size() + " and " + schedule.getCourses().size());
//		
//		System.out.println();
//		System.out.println("Adding One Student");
//		schedule.addStudent(student1);
//		
//		System.out.println(schedule.getStudents().size() + " and " + schedule.getCourses().size());
//		
//		//we have two courses in our schedule that are identical to the two courses in the students preferences
//		schedule.addCourse(preference1);
//		schedule.addCourse(preference2);
//		
//		System.out.println("Adding Two Courses");
//		System.out.println(schedule.getStudents().size() + " and " + schedule.getCourses().size());
//		
//		System.out.println();
//		
//		schedule.displayStudent(student1);
		
		//course related variables
//		List<Course> courseList1 = new ArrayList<>();
//		List<Course> courseList2 = new ArrayList<>();
//		
//		Course course1 = new Course("Physics", 10);
//		Course course2 = new Course("French", 10);
//		Course course3 = new Course("Math", 10);
//		
//		Course course4 = new Course("English", 10);
//		Course course5 = new Course("Biology", 10);
//		Course course6 = new Course("Spanish", 10);
//		
//		courseList1.add(course1);
//		courseList1.add(course2);
//		courseList1.add(course3);
//		
//		courseList2.add(course4);
//		courseList2.add(course5);
//		courseList2.add(course6);
//		
//		//We need 2 students
//		Student student1 = new Student("Cato", 5, courseList1);
//		Student student2 = new Student("Clouseau", 5, courseList2);
//		
//		//Scheduler variables
//		Scheduler schedule = new Scheduler();
//		
//		schedule.addCourse(course1);
//		schedule.addCourse(course2);
//		schedule.addCourse(course3);
//		schedule.addCourse(course4);
//		schedule.addCourse(course5);
//		schedule.addCourse(course6);
		
//		schedule.addStudent(student1);
//		schedule.addStudent(student2);
//		
//		schedule.displayStudent(student1);
//		
//		System.out.println();
//		
//		schedule.displayStudent(student2);
//		
//		System.out.println("Assigning all \n");
//		schedule.assignAll();
//		
//		schedule.displayStudent(student1);
//		
//		System.out.println();
//		
//		schedule.displayStudent(student2);
//		System.out.println();
//		
//		System.out.println("Unenrolling Student 1");
//		schedule.unenroll(student1);
//		
//		schedule.displayStudent(student1);
//		
//		System.out.println();
//		
//		System.out.println("Renrolling Student 1");
//		
//		schedule.assignAll();
//		
//		schedule.displayStudent(student1);
		
		//course selection
		Course a = new Course("ANTHRO100", 2);
		Course b = new Course("BIO100", 2);
		Course c = new Course("COMM100", 1);
		Course d = new Course("DUTCH100", 2);
		Course e = new Course("ECON100", 3);
		
		//created student object with name, maxCourse, and preference
		Student s = new Student("s", 3, Arrays.asList(new Course[] {a, b, c, d, e}));
		Student t = new Student("t", 4, Arrays.asList(new Course[] {c, a, d, e, b}));
		Student u = new Student("u", 5, Arrays.asList(new Course[] {b, a, d, c, e}));
		
		Scheduler scheduler = new Scheduler();
		
		scheduler.addStudent(s);
		scheduler.addStudent(t);
		scheduler.addStudent(u);
		scheduler.addCourse(a);
		scheduler.addCourse(b);
		scheduler.addCourse(c);
		scheduler.addCourse(d);
		scheduler.addCourse(e);
		scheduler.assignAll();
		
		//System.out.println("Pre-Dutch Capacity: " + d.getCurrentCapacity());
		
		System.out.println("Before Unenrolling S");
		System.out.println();
		scheduler.displayStudent(s);
		System.out.println();
		
		scheduler.displayStudent(t);
		System.out.println();
		
		scheduler.displayStudent(u);
		System.out.println();
		
		
		//System.out.println("Unenrolling S");
		
		//System.out.println("Mid-Dutch Capacity: " + d.getCurrentCapacity());
		scheduler.unenroll(s);
		
		System.out.println();
		System.out.println();
		System.out.println("Unenrolling S, but not reassigning");
		System.out.println();
		scheduler.displayStudent(s);
		System.out.println();
		
		scheduler.displayStudent(t);
		System.out.println();
		
		scheduler.displayStudent(u);
		System.out.println();
		
		
		//System.out.println("Mid-Dutch Capacity: " + d.getCurrentCapacity());
		//System.out.println("Reenrolling S");
		scheduler.assignAll();
		//System.out.println("Post-Dutch Capacity: " + d.getCurrentCapacity());
		//scheduler.displayStudent(s);
		
		System.out.println();
		System.out.println();
		System.out.println("Re-Assigning");
		
		scheduler.displayStudent(s);
		System.out.println();
		
		scheduler.displayStudent(t);
		System.out.println();
		
		scheduler.displayStudent(u);
		System.out.println();
	}

}
