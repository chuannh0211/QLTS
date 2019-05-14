package com.aht.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "nhom")
public class Nhom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tennhom")
	private String name;
	@Column(name = "pm")
	private String pm;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhom")
	private Set<DieuChuyenTaiSan> listDieuchuyentaisan = new HashSet<>();

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

	public Set<DieuChuyenTaiSan> getListDieuchuyentaisan() {
		return listDieuchuyentaisan;
	}

	public void setListDieuchuyentaisan(Set<DieuChuyenTaiSan> listDieuchuyentaisan) {
		this.listDieuchuyentaisan = listDieuchuyentaisan;
	}

}
