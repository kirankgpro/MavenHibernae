package com.kiran.HibernateMaven.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Vehicle{
@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idd;
	private String vehicleName;

	@ManyToOne
	@JoinColumn(name="userinfoid")
	UserInfo userr;
	
    @Override
	public String toString() {
		return "Vehicle [idd=" + idd + ", vehicleName=" + vehicleName + ", userr=" + userr + "]";
	}
	public UserInfo getUserr() {
		return userr;
	}
	public void setUserr(UserInfo userr) {
		this.userr = userr;
	}
	public UserInfo getUser() {
		return userr;
	}
	public void setUser(UserInfo user) {
		this.userr = user;
	}
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}