package com.kiran.HibernateMaven.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String LastName;
	String firstName;

	@OneToMany(mappedBy="userr",cascade=CascadeType.ALL)	
	Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", LastName=" + LastName + ", firstName=" + firstName + ", vehicle=" + vehicle
				+ "]";
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	



}
