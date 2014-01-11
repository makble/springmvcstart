package com.makble.springmvcstart.config.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "user_table" )
public class User {
	private String username;
	
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
	}
	private String password;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	
}