package com.aht.model;

public class DanhMucDTO {
	private long id;
	private String name;
	
	public DanhMucDTO() {
		// TODO Auto-generated constructor stub
	}

	public DanhMucDTO(long id, String name) {
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
