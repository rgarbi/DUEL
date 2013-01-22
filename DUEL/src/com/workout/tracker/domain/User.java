package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="User", noClassnameStored=true)
public class User {
	
	@Id
    private ObjectId id;
	String uid = "";
	
}
