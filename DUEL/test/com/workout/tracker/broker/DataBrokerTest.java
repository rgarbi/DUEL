package com.workout.tracker.broker;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.workout.tracker.broker.DataBroker;
import com.workout.tracker.domain.WorkOutSession;
import com.workout.tracker.test.BaseTest;

public class DataBrokerTest extends BaseTest {
	
	@After
	public void cleanUp() {
		super.cleanUp();
	}

	@Test
	public void storeDomainObjectTest() {
		WorkOutSession session = new WorkOutSession();
		session.setWorkOutName("Test Name");
		session.setWorkOutDescription("Description");
		session.setDatePerformed(new Date());

		DataBroker.storeDomainObject(session);
		
		allCreatedIds.add(session.getObjectId());
		System.out.println(session.getId());
		
	}
	
	@Test
	public void getDomainObjectTest() {
		WorkOutSession session = new WorkOutSession();
		session.setWorkOutName("Test Name");
		session.setWorkOutDescription("Description");
		session.setDatePerformed(new Date());
		DataBroker.storeDomainObject(session);
		allCreatedIds.add(session.getObjectId());
		System.out.println(session.getId());
		
		WorkOutSession myFoundItem = (WorkOutSession) DataBroker.getDomainObject(WorkOutSession.class, "workOutName", "Test Name");
		
		System.out.println(myFoundItem.getWorkOutName());
		System.out.println(myFoundItem.getWorkOutDescription());	
	}
	
	@Test
	public void getAllDomainObjectsTest() {
		
		for(int i = 0; i < 1000000; ++i){
			WorkOutSession session = new WorkOutSession();
			session.setWorkOutName("Test Name");
			session.setWorkOutDescription("Description");
			session.setDatePerformed(new Date());
			DataBroker.storeDomainObject(session);
			allCreatedIds.add(session.getObjectId());
			System.out.println(session.getId());
		}
		
		List<WorkOutSession> allItems = DataBroker.getAllDomainObjects(WorkOutSession.class);
		System.out.println(allItems.size());
		
		for(WorkOutSession wos : allItems){
			System.out.println(wos.getWorkOutName());
			System.out.println(wos.getWorkOutDescription());
			System.out.println(wos.getDatePerformed());
			System.out.println(wos.getId());
		}
		
	}
	
	@Test
	public void deleteDomainObjectTest() {
		WorkOutSession session = new WorkOutSession();
		session.setWorkOutName("Test Name");
		session.setWorkOutDescription("Description");
		session.setDatePerformed(new Date());
		DataBroker.storeDomainObject(session);
		allCreatedIds.add(session.getObjectId());
		System.out.println(session.getId());
		
		List<WorkOutSession> allItems = DataBroker.getAllDomainObjects(WorkOutSession.class);
		System.out.println(allItems.size());
		
		DataBroker.deleteDomainObject(WorkOutSession.class, "workOutName", "Test Name");
		
		allItems = DataBroker.getAllDomainObjects(WorkOutSession.class);
		System.out.println(allItems.size());	
	}
	
	@Test
	public void updateDomainObjectTest() {
		WorkOutSession session = new WorkOutSession();
		session.setWorkOutName("Test Name");
		session.setWorkOutDescription("Description");
		session.setDatePerformed(new Date());
		DataBroker.storeDomainObject(session);
		allCreatedIds.add(session.getObjectId());
		System.out.println(session.getId());
		DataBroker.updateDomainObject(WorkOutSession.class, "workOutName", "Some better workout name", session.getObjectId());
		
		WorkOutSession updated = (WorkOutSession) DataBroker.getDomainObject(WorkOutSession.class, "workOutName", "Some better workout name");
		allCreatedIds.add(updated.getObjectId());
		Assert.assertEquals("Some better workout name", updated.getWorkOutName());

		
	}
	
	
	
	

}
