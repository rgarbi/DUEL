package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="LiftCategory", noClassnameStored=true)
public class LiftCategory {
	@Id
    private ObjectId id;
	
	
}
