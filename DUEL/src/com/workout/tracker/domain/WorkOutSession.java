package com.workout.tracker.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;

/*
 * http://something.com/workouts/{instance}/lifts/{lift}/sets/{set}
 */

@Entity(value="WorkOutSession", noClassnameStored=true)
public class WorkOutSession
{
	@Id
    private ObjectId id;
	
	@Indexed
	String workOutName = "";
	String workOutDescription = "";
	String username = "";
	Date datePerformed = null;
	List<SetInstance> liftsPerformed = new ArrayList<SetInstance>();
	
	public WorkOutSession(){
		//Default session
	}
	
	public String getId(){
		return id.toString();
	}
	
	public ObjectId getObjectId(){
		return id;
	}

	public String getWorkOutName() {
		return workOutName;
	}

	public void setWorkOutName(String workOutName) {
		this.workOutName = workOutName;
	}

	public String getWorkOutDescription() {
		return workOutDescription;
	}

	public void setWorkOutDescription(String workOutDescription) {
		this.workOutDescription = workOutDescription;
	}

	public Date getDatePerformed() {
		return datePerformed;
	}

	public void setDatePerformed(Date datePerformed) {
		this.datePerformed = datePerformed;
	}

	public List<SetInstance> getLiftsPerformed() {
		return liftsPerformed;
	}

	public void setLiftsPerformed(List<SetInstance> liftsPerformed) {
		this.liftsPerformed = liftsPerformed;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
