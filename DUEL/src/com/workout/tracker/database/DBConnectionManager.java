package com.workout.tracker.database;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.workout.tracker.domain.Lift;
import com.workout.tracker.domain.LiftCategory;
import com.workout.tracker.domain.Person;
import com.workout.tracker.domain.Set;
import com.workout.tracker.domain.SetInstance;
import com.workout.tracker.domain.User;
import com.workout.tracker.domain.WorkOutSession;

public class DBConnectionManager {
	
	
	private static String mongoHost = "localhost";
	private static int mongoPort = 27017;
	private static Mongo myMongoConn = null;
	private static String dbName = "workoutTrackerDB";
	
	private static Morphia morphia = null;
	private static Datastore ds = null;
	
	public static Datastore getDbConnection() {
		
		if(myMongoConn == null){
			try
			{
				myMongoConn = new Mongo( mongoHost , mongoPort );
				myMongoConn.setWriteConcern(WriteConcern.SAFE);
				
				morphia = new Morphia();
				morphia.map(WorkOutSession.class);
				morphia.map(Lift.class);
				morphia.map(LiftCategory.class);
				morphia.map(Person.class);
				morphia.map(Set.class);
				morphia.map(SetInstance.class);
				morphia.map(User.class);
				
				
				ds = morphia.createDatastore(myMongoConn, dbName);
				ds.ensureIndexes();
				
				return ds;
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return ds;
		}
	}

}
