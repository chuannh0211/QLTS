package com.aht.model;

public class RolesDTO {
	private long id;
	private String name;
	
	public RolesDTO() {
		// TODO Auto-generated constructor stub
	}

	public RolesDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
