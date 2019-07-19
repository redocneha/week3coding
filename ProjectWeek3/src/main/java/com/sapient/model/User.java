package com.sapient.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)

public class User implements Serializable {

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address address) {
		this.adr = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final int serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")

	private List<Post> posts;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address adr;

	public User() {

	}

	public User( String name) {
		
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

}
