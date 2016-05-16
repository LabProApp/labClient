package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PATIENT")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Patient")
public class Patient {
	

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName="
				+ patientName + ", age=" + age + ", gender=" + gender
				+ ", status=" + status + ", patientAddress=" + patientAddress
				+ ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + ", emailID="
				+ emailID + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PTNT_ID", unique = true)
	Long patientId;
	@Column(name = "PTNT_NAME")
	String patientName;
	@Column(name = "AGE")
	Integer age;
	@Column(name = "GENDER")
	String gender;
	@Column(name = "STATUS")
	Integer status;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address patientAddress=new Address();
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;
	@Column(name = "EMAIL_ID")
	String emailID;
	

	public Integer getAge() {

		return age;
	}

	@XmlElement
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientName() {
		return patientName;
	}

	@XmlElement
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Long getPatientId() {
		return patientId;
	}

	@XmlElement
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Address getPatientAddress() {
		return patientAddress;
	}

	@XmlElement
	public void setPatientAddress(Address patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	@XmlElement
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	public String getSecondaryMobileNo() {
		return secondaryMobileNo;
	}

	@XmlElement
	public void setSecondaryMobileNo(String secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	@XmlElement
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
