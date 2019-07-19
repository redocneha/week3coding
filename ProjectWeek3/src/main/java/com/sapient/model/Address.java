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
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {
	private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private  int id;
	
	  @Column(name="street")
 private String street;
	
	 
	    @Column(name="city")
 private String city;

	    
	    @Column(name="pin")
 private int pin;
 public Address() {}

@Override
public String toString() {
	return "Address [id=" + id + ", street=" + street + ", city=" + city + ", pin=" + pin + "]";
}

public Address( String street, String city, int pin) {

	this.street = street;
	this.city = city;
	this.pin = pin;
}

 
}
