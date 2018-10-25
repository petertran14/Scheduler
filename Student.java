/*
 * Copyright 2017 Marc Liberatore.
 */

package scheduler;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a student.
 * 
 * @author liberato
 *
 */
public class Student {
	
	private String name;
	private int maxCourses;
	private int currCourses;
	private List<Course> preferences;
	private List<Course> schedule;
	
	/**
	 * 
	 * Instantiates a new Student object. The student's maximum course load must be greater
	 * than zero, and the preferences list must contain at least one course.
	 * 
	 * The preference list is copied into this Student object.
	 * 
	 * @param name        the student's name
	 * @param maxCourses  the maximum number of courses that can be on this student's schedule
	 * @param preferences the student's ordered list of preferred courses
	 * @throws IllegalArgumentException thrown if the maxCourses or preferences are invalid
	 */
	public Student(String name, int maxCourses, List<Course> preferences) throws IllegalArgumentException {
		
		//check for valid maxCourses and preference value
		if (maxCourses < 1 || preferences.size() < 1) {
			
			throw new IllegalArgumentException();
		}
		
		//store the values passed in the constructor to the class
		this.name = name;
		this.maxCourses = maxCourses;
		this.currCourses = 0;
		this.preferences = preferences;
		this.schedule = new ArrayList<Course>();
	}
	
	/**
	 * 
	 * @return the student's name
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * 
	 * @return the student's max course load
	 */
	public int getMaxCourses() {
		
		return this.maxCourses;
	}
	
	/*
	 * @return the students current course load
	 */
	public int getCurrentNumCourses() {
		
		return this.currCourses;
	}
	
	/**
	 * Returns the student's list of course preferences, ordered from most- to least-desired.
	 * 
	 * This returned object does not share state with the internal state of the Student.
	 * 
	 * @return the student's preference list
	 */
	public List<Course> getPreferences() {
		
		List<Course> copy = new ArrayList<Course>(preferences);
		
		return copy;
	}
	
	/*
	 * Adds a students preferred course to their schedule
	 * 
	 * @param course: an object of the Course class. Contains important information about the course.
	 */
	public void addToSchedule(Course course) {
		
		this.schedule.add(course);
		this.currCourses++;
	}
	
	/**
	 * Returns the student's current schedule.
	 * 
	 * This returned object does not share state with the internal state of the Student.
     *
	 * @return the student's schedule
	 */
	
	//the assign all method in Scheduler will adjust the student's schedule
	public List<Course> getSchedule() {
		
		List<Course> copy = new ArrayList<Course>(this.schedule);
		
		return copy;
	}
	
	/*
	 * Student drops a class
	 * 
	 * - we need to figure out if this class was actually in the students schedule
	 * - if so, we need to get rid of the course object
	 */
	public void dropFromSchedule(Course courseToDrop) {
		
		//search for that course in the schedule list
		for (int i = 0; i < this.schedule.size(); i++) {
			
			//if we have found to course-to-drop
			if (this.schedule.get(i).equals(courseToDrop)) {
				
				//drop it 
				this.schedule.remove(i);
			}
		}
		
		this.currCourses--;
	}
	
	/*
	 * Drops all the classes from the current Student's schedule
	 */
	public void dropAllFromSchedule() {
		
		//removes the student from each course roster
		for (int i = 0; i < this.schedule.size(); i++) {
			
			schedule.get(i).removeFromRoster(this);
			this.currCourses--;
		}
		
		//removes all the Course objects from the Schedule list
		this.schedule.clear();
	}
	
	public void display() {
		
		System.out.println("Displaying the Student's name, maxCourses, preference, and schedule.");
		
		System.out.println("Name: " + this.getName());
		System.out.println("Max Courses: " + this.getMaxCourses());
		
		for (int i = 0; i < this.getPreferences().size(); i++) {
			
			System.out.println("Course Number: " + this.getPreferences().get(i).getCourseNumber() + "\t\tCourse Capacity: " + this.getPreferences().get(i).getCapacity());
		}
		
		System.out.println();
		
		if (this.schedule.isEmpty()) {
			
			System.out.println("The student schedule is empty right now");
		}
		
		else {
			
			System.out.println("Schedule: ");
			
			for (int i = 0; i < this.schedule.size(); i++) {
				
				System.out.println(this.schedule.get(i).getCourseNumber());
			}
		}
	}
}
