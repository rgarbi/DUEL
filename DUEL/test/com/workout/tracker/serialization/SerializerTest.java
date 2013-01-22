package com.workout.tracker.serialization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import com.workout.tracker.domain.WorkOutSession;
import com.workout.tracker.serialization.Serializer;

public class SerializerTest {

	@Test
	public void serializeToJSONTest() {
		WorkOutSession domainObj = new WorkOutSession();
		domainObj.setWorkOutName("Sounds Good!");
		domainObj.setWorkOutDescription("A Name");
		domainObj.setDatePerformed(new Date());
		
		String returnVal = Serializer.serializeToJSON(domainObj);
		
		System.out.println(returnVal);
		
	}
	
	@Test
	public void serializeFromJsonTest() {
		WorkOutSession domainObj = new WorkOutSession();
		domainObj.setWorkOutName("Sounds Good!");
		domainObj.setWorkOutDescription("A Name");
		domainObj.setDatePerformed(new Date());
		
		String returnVal = Serializer.serializeToJSON(domainObj);
		System.out.println(returnVal);
		
		WorkOutSession retItem = (WorkOutSession) Serializer.serializeFromJson(returnVal, WorkOutSession.class);
		
		System.out.println(retItem.getWorkOutDescription());
		System.out.println(retItem.getWorkOutName());
		System.out.println(retItem.getDatePerformed());
		
		//Assert.assertEquals(myItem.getItemName(), retItem.getItemName());
		//Assert.assertEquals(myItem.getItemDescription(), retItem.getItemDescription());
		//Assert.assertEquals(myItem.getItemPrice(), retItem.getItemPrice());
	}
	
	@Test
	public void serializeAList() {
		List<WorkOutSession> items = new ArrayList<WorkOutSession>();
		
		for(int i = 0; i < 200; ++i){
			WorkOutSession myItem = new WorkOutSession();
			myItem.setWorkOutDescription("Sounds Good! " + i);
			myItem.setWorkOutName("A Name " + i);
			myItem.setDatePerformed(new Date());
			items.add(myItem);
		}
		
		String json = Serializer.serializeToJSON(items);
		System.out.println(json);
		
	}

}
