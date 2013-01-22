package com.workout.tracker.endpoints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.workout.tracker.broker.DataBroker;
import com.workout.tracker.domain.SetInstance;
import com.workout.tracker.domain.WorkOutSession;
import com.workout.tracker.test.BaseTest;

public class MenuItemEndpointTest extends BaseTest {
	
	@After
	public void cleanUp() {
		super.cleanUp();
	}

	@Test
	public void getAllMenuItemsTest() throws ParseException {
		
		for(int ii = 1; ii < 20; ++ii){
		
			WorkOutSession session = new WorkOutSession();
			session.setWorkOutName("Chest Day");
			session.setWorkOutDescription("Good Chest work out");
			session.setDatePerformed(new SimpleDateFormat("MM/dd/yyyy").parse("05/" + ii + "/2012"));
			session.setUsername("Richard");
			
			List<SetInstance> allSets = new ArrayList<SetInstance>();
			
			for(int i = 1; i <= 5; ++i){
				SetInstance set = new SetInstance();
				set.setLiftName("Flat Bench");
				set.setSetNumber(i);
				set.setRepitetions(5);
				set.setWeight((250 + (ii * 5)) + (i * 10));
				allSets.add(set);
			}
			
			for(int i = 1; i <= 5; ++i){
				SetInstance set = new SetInstance();
				set.setLiftName("Incline Bench");
				set.setSetNumber(i);
				set.setRepitetions(5);
				set.setWeight((150 + (ii * 5)) + (i * 10));
				allSets.add(set);
			}
			
			for(int i = 1; i <= 5; ++i){
				SetInstance set = new SetInstance();
				set.setLiftName("DB Bench");
				set.setSetNumber(i);
				set.setRepitetions(5);
				set.setWeight((60 + (ii * 5)) + (i * 10));
				allSets.add(set);
			}
			
			for(int i = 1; i <= 5; ++i){
				SetInstance set = new SetInstance();
				set.setLiftName("Reverse Grip Bench");
				set.setSetNumber(i);
				set.setRepitetions(5);
				set.setWeight((170 + (ii * 5)) + (i * 10));
				allSets.add(set);
			}
			
			session.setLiftsPerformed(allSets);
	
			DataBroker.storeDomainObject(session);
			allCreatedIds.add(session.getObjectId());
			System.out.println(session.getId());
		}
		WorkOutSessionEndPoint workOut = new WorkOutSessionEndPoint();
		String json = workOut.getAllWorkOutSessions();
		
		System.out.println(json);
		
		Assert.assertEquals("", json);
	}
	
	@Test
	public void postItemTest(){
		String json = "{\"itemName\":\"A name\",\"itemDescription\":\"A Description\",\"itemPrice\":9999.99}";
		
		WorkOutSessionEndPoint menuItem = new WorkOutSessionEndPoint();
		String id = menuItem.postWorkOutSession(json);
		
		System.out.println(id);
		
		ObjectId objId = new ObjectId(id);
		super.allCreatedIds.add(objId);
		
	}

}
