package com.sapient.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "post")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post implements Serializable{
	private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
	private int id;
   
    
    @Column(name="title")
	private String title;
   
    @Column(name="body")
	private String body;
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	public Post( String title, String body) {
		
		
		this.title = title;
		this.body = body;
	}
public Post() {}
}
