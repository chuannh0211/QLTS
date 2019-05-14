package com.aht.entities;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@Column(name = "fullname")
//	private String fullname;
	@Column(name = "username")
	private String username;
	@Column(name = "passwordd")
	private String password;
	@Column(name = "password_Confirm")
	private String passwordConfirm;
//	@Column(name = "email")
//	private String email;
//	@Column(name = "phone")
//	private String phone;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "roleuser", joinColumns = @JoinColumn(name = "iduser"), inverseJoinColumns = @JoinColumn(name = "idrole"))
	private Set<Roles> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

}
