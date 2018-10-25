/*
 * Copyright 2017 Marc Liberatore.
 */

package scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	
	//These instance variables start off empty
	
	//When we add courses objects to the scheduler, it keeps them in a list
	List<Course> courses;
	
	//When we add student objects to the scheduler, it keeps them in a list
	List<Student> students;
	
	/**
	 * Instantiates a new, empty scheduler.
	 */
	public Scheduler() {
		
		//both lists are currently empty
		this.courses = new ArrayList<>();
		this.students = new ArrayList<>();
	}
	
	/**
	 * Adds a course to the scheduler.
	 * 
	 * @param course  the course to be added
	 */
	public void addCourse(Course course) {
		
		//adds once course object to the list, the course object has already
		//been instantiated to appropriate values.
		this.courses.add(course);
	}
	
	/** 
	 * Returns the list of courses that this scheduler knows about.
	 * 
	 * This returned object does not share state with the internal state of the Scheduler.
	 *
	 * @return the list of courses
	 */
	public List<Course> getCourses() {
		
		List<Course> copy = new ArrayList<>(this.courses);
		
		return copy;
	}
	
	/**
	 * Adds a student to the scheduler.
	 * 
	 * @param student the student to add
	 */
	public void addStudent(Student student) {
		
		this.students.add(student);
	}
	
	/**
	 * Returns a list of the students this scheduler knows about.
	 * 
	 * This returned object does not share state with the internal state of the Scheduler.
	 * @return
	 */
	public List<Student> getStudents() {
		
		List<Student> copy = new ArrayList<>(this.students);
		
		return copy;
	}
	
	/**
	 * Assigns all students to courses in the following manner:
	 * 
	 * For a given student, check their list of preferred courses. Add them to the course that:
	 * 	 - exists in the scheduler's list of courses
	 *   - the student most prefers (that is, comes first in their preference list)
	 *   - the student is not already enrolled in
	 *   - and is not full (in other words, at capacity)
	 * Adds courses to the *end* of the student's current list of classes. Adds students to 
	 * the *end* of the course's roster.
	 *   
	 * Repeat this process for each student, one-by-one; each student will now have one course,
	 * usually (but not always) their most preferred course.
	 * 
	 * Then repeat this whole process (adding one course per student, when possible, proceeding
	 * round-robin among students), until there is nothing left to do: Students might 
	 * all be at their maximum number of courses, or there may be no available seats in courses 
	 * that students want.
	 */
	public void assignAll() {
		
		boolean assign = false;
		int taskDone = 1;
		int i;
		
		//while we are still able to make an assignment. If taskDone > 0 it means that
		//there is still a chance either the student has not reached max classes, or 
		//the classes still have space to hold a student.
		//if taskDone == 0, that means we were unable to assign anymore so we are finished
		while(taskDone > 0) {
			
			//reassigns i = 0;
			i = 0;
			
			//reassigns taskDone = 0;
			taskDone = 0;
		
			//loop through each student, each student receives one class per turn
			//In other words, this loop gives each student at least one class
			for (i = 0; i < this.students.size(); i++) {
				
				//reset the flag
				assign = false;
				
				//check if the student is at their maxCourse, if so do not assign this poor student more than he/she wants
				if (this.students.get(i).getMaxCourses() != this.students.get(i).getCurrentNumCourses()) {
			
					//loop through their preference list to make sure it is valid to assign, && !assign
					//assign one class for the student, if we can, then break from the loop
					for (int j = 0; j < this.students.get(i).getPreferences().size() && !assign; j++) {
						
						//if it exists within our list
						if (this.courses.contains(this.students.get(i).getPreferences().get(j)) && 
							
							//if they don't already have this class in their schedule
							!(this.students.get(i).getSchedule().contains(this.students.get(i).getPreferences().get(j))) &&
							
							//if the class still has space to add one more student
							this.students.get(i).getPreferences().get(j).getCurrentCapacity() != this.students.get(i).getPreferences().get(j).getCapacity()) {
				
							//assign that them the class, also need to update the roster of the class
							this.students.get(i).addToSchedule(this.students.get(i).getPreferences().get(j));
							this.students.get(i).getPreferences().get(j).addToRoster(this.students.get(i));
							
							//provides a condition to exit the loop
							assign = true;
							
							//we have done an assignment
							taskDone++;
						}
					}
				}
			}
		}
	}

	/**
	 * Drops a student from a course.
	 * 
	 * @param student
	 * @param course 
	 * @throws IllegalArgumentException  if either the student or the course are not known to this scheduler
	 */
	
	//this only works if we have assigned students at least one class in the schedule
	public void drop(Student student, Course course) throws IllegalArgumentException {
		
		//if the student or course objects are not known to this class
		if (!(this.students.contains(student)) || !(this.courses.contains(course))) {
			
			throw new IllegalArgumentException();
		}
		
		//call the method in Student that will drop the course
		student.dropFromSchedule(course);
		course.removeFromRoster(student);
	}
	
	/**
	 * Drops a student from all of their courses.
	 * 
	 * @param student
	 * @throws IllegalArgumentException  if the student is not known to this scheduler
	 */
	public void unenroll(Student student) throws IllegalArgumentException {
		
		//if the list of students does not contain the the Student object passed
		if (!this.students.contains(student)) {
			
			//throw exception
			throw new IllegalArgumentException();
		}
		
		//the student drops all the classes from schedule
		student.dropAllFromSchedule();
	}
	
	/*
	 * Helps display the student data from within the student class. For testing purposes.
	 */
	public void displayStudent(Student student) {
		
		student.display();
	}
}

