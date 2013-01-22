package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="Set", noClassnameStored=true)
public class Set {
	@Id
    private ObjectId id;

	int setNumber = 0;
	int repitetions = 0;
	int weight = 0;
	
}
