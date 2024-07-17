package com.example.dev.exeption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExeption extends RuntimeException {

	
	String resourceName;
	String fieldeName;
	long fieldValue;
	public ResourceNotFoundExeption(String resourceName, String fieldeName, long fieldValue) {
		super(String.format( fieldeName, resourceName,fieldeName,"%s not found with %s : %1"));
		this.resourceName = resourceName;
		this.fieldeName = fieldeName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
