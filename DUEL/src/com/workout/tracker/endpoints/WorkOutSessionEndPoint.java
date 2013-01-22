package com.workout.tracker.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.workout.tracker.broker.DataBroker;
import com.workout.tracker.domain.*;
import com.workout.tracker.serialization.Serializer;

@Path("/workout")
public class WorkOutSessionEndPoint {
	
	@GET
	@Produces("text/json")
	public String getAllWorkOutSessions(){
		List<WorkOutSession> workOuts = DataBroker.getAllDomainObjects(WorkOutSession.class);
		return Serializer.serializeToJSON(workOuts);
	}
	
	@GET
	@Produces("text/json")
	@Path("{id}")
	public String getAWorkOutSession(@PathParam("id") String id){
		WorkOutSession aSession = (WorkOutSession) DataBroker.getDomainObjectById(WorkOutSession.class, id);
		
		return Serializer.serializeToJSON(aSession);
	}
	
	@POST
	@Produces("text/json")
	@Consumes("text/json")
	public String postWorkOutSession(String json) {
		WorkOutSession createSession = (WorkOutSession) Serializer.serializeFromJson(json, WorkOutSession.class);
		DataBroker.storeDomainObject(createSession);
		
		return createSession.getId().toString();
		
	}
}
