package com.aht.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tendanhmuc")
	private String name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "danhmuc", cascade = {CascadeType.REMOVE})
	private Set<TaiSan> listTaiSan = new HashSet<>();

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

	public Set<TaiSan> getListTaiSan() {
		return listTaiSan;
	}

	public void setListTaiSan(Set<TaiSan> listTaiSan) {
		this.listTaiSan = listTaiSan;
	}

}
