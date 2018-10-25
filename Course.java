/*
 * Copyright 2017 Marc Liberatore.
 */

package scheduler;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a Course.
 * 
 * @author liberato
 *
 */
public class Course {
	
	private String courseNumber;
	private int maxCapacity;
	private int currCapacity;
	List<Student> roster;

	/**
	 * Instantiates a new Course object. The course number must be non-empty, and the 
	 * capacity must be greater than zero.
	 * @param courseNumber a course number, like "COMPSCI190D"
	 * @param capacity     the maximum number of students that can be in the class
	 * @throws IllegalArgumentException thrown if the courseNumber or capacity are invalid
	 */
	public Course(String courseNumber, int capacity) throws IllegalArgumentException {
		
		//check is courseNumber of capacity are invalid
		if (capacity <= 0 || courseNumber == "") {
			
			throw new IllegalArgumentException();
		}
		
		this.courseNumber = courseNumber;
		this.maxCapacity = capacity;
		this.currCapacity = 0;
		this.roster = new ArrayList<Student>();
	}
	
	/**
	 * 
	 * @return the capacity of the course
	 */
	public int getCapacity() {
		
		return this.maxCapacity;
	}
	
	/*
	 * @rreturn the current capacity of the course
	 */
	public int getCurrentCapacity() {
		
		return this.currCapacity;
	}
	
	/**
	 * 
	 * @return the course number
	 */
	public String getCourseNumber() {
		
		return this.courseNumber;
	}
	
	/*
	 * This method helps us update the amount of students in particular class
	 * 
	 * @param student: a student object that has all its important information
	 */
	public void addToRoster(Student student) {
		
		//pushback the student object to the list of student objects
		this.roster.add(student);
		
		//update the capacity of the class
		this.currCapacity++;
	}
	
	/*
	 * Removes student from roster
	 */
	
	public void removeFromRoster(Student student) {
		
		this.roster.remove(student);
		this.currCapacity--;
	}

	/**
	 * Returns the list of students enrolled in the course. 
	 * 
	 * This returned object does not share state with the internal state of the Course.
	 * 
	 * @return the list of students currently in the course
	 */
	
	//we need to add a method that will keep track of how many students are  
	//enrolled in the class
	public List<Student> getRoster() {
		
		//copy over the old roster
		List<Student> newRoster = new ArrayList<Student>(roster);
		
		return newRoster;
	}
}
