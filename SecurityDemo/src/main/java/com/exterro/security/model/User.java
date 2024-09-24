package com.exterro.security.model;


import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User implements UserDetails{
	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String email;
	private String password;
	
	private String roles;
	public User(int id, String email, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String role) {
		this.roles = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + roles + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Stream.of(getRoles()
				.split(","))
//				.map(SimpleGrantedAuthority::new)
				.map(role->new SimpleGrantedAuthority(role))
				.toList();
	}
	@Override
	public String getUsername() {

		return email;
	}
	
	
	
}
