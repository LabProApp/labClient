package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ADDRESS")

public class Address {

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", addressType=" + addressType + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID", unique = true)
	Long addressId;
	@Column(name = "ADD_LINE1")
	String addressLine1;
	@Column(name = "ADD_LINE2")
	String addressLine2;
	@Column(name = "ADD_LINE3")
	String addressLine3;
	@Column(name = "CITY")
	String city;
	@Column(name = "STATE")
	String state;
	@Column(name = "ZIP")
	String zip;
	@Column(name = "COUNTRY")
	String country;
	@Column(name = "ADD_TYPE")
	String addressType;

	/**
	 * @return the addressId
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
}
