package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="Person", noClassnameStored=true)
public class Person {

	@Id
    private ObjectId id;
	
	String username = "";
	String fName = "";
	String lName = "";
	
	
}
