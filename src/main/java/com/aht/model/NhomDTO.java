package com.aht.model;

public class NhomDTO {
	private long id;
	private String name;
	private String pm;

	public NhomDTO() {
		// TODO Auto-generated constructor stub
	}

	public NhomDTO(long id, String name, String pm) {
		this.id = id;
		this.name = name;
		this.pm = pm;
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

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

}
