package com.my.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Post{
	

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	

	public Post() {
		
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
	

}
