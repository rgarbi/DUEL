package com.workout.tracker.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="Set", noClassnameStored=true)
public class SetInstance {
	@Id
    private ObjectId id;

	String liftName = "";
	int setNumber = 0;
	int repitetions = 0;
	int weight = 0;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getLiftName() {
		return liftName;
	}
	public void setLiftName(String liftName) {
		this.liftName = liftName;
	}
	public int getSetNumber() {
		return setNumber;
	}
	public void setSetNumber(int setNumber) {
		this.setNumber = setNumber;
	}
	public int getRepitetions() {
		return repitetions;
	}
	public void setRepitetions(int repitetions) {
		this.repitetions = repitetions;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
