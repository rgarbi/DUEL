package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="Lift", noClassnameStored=true)
public class Lift {
	@Id
    private ObjectId id;
	
	String name = "";
	String description = "";
	
}
