package org.bib.demo.model;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Singer implements Serializable {
// Constructors

// Public Methods
	public void afterPropertiesSet() throws Exception {
		logger.debug("afterPropertiesSet...");
		
		if(name == null) {
			logger.debug("Using default name...");
			name = DEFAULT_NAME;
		}
		
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
		}
	}
	
	@Override
	public String toString() {
		return "\tName: " + name + "\n\tAge: " + age;
	}

// Getters & Setters
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	

// Attributes
	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger
	 */
	private static final Logger logger = LogManager.getLogger(Singer.class);
	
	private String name;
	
	private static final String DEFAULT_NAME = "Eric Clapton";
	
	private int age = Integer.MIN_VALUE;
	
}
