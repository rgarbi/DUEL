package com.workout.tracker.serialization;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serializer {
	
	public static String serializeToJSON(Object object) {
		Gson builder = new GsonBuilder().create();
		return builder.toJson(object);
	}
	
	public static <T> String serializeToJSON(List<T> domainObjects) {
		Gson builder = new GsonBuilder().create();
		return builder.toJson(domainObjects);
	}
	
	public static <T> Object serializeFromJson(String json, Class<T> t) {
		Gson builder = new GsonBuilder().create();
		return (t.cast(builder.fromJson(json, t)));
	
	}
	
	
	
}
