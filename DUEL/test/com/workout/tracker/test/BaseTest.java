package com.workout.tracker.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import com.google.code.morphia.mapping.Mapper;
import com.workout.tracker.broker.DataBroker;
import com.workout.tracker.domain.WorkOutSession;

public class BaseTest {
	
	protected List<ObjectId> allCreatedIds = new ArrayList<ObjectId>();
	
	public void cleanUp() {
		
		System.out.println("Number of Objects to clean up ->" + allCreatedIds.size());
		
		for(ObjectId id : allCreatedIds) {
			DataBroker.deleteDomainObject(WorkOutSession.class, Mapper.ID_KEY, id);
		}
		
		List<WorkOutSession> allItems = DataBroker.getAllDomainObjects(WorkOutSession.class);
		System.out.println(allItems.size());
	}

}
