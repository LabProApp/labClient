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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "LAB_OFFICE")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabOffice")
public class LabOffice {

	@Override
	public String toString() {
		return "LabOffice [labOfficeId=" + labOfficeId + ", labName=" + labName
				+ ", status=" + status + ", labAddress=" + labAddress
				+ ", labOwner=" + labOwner + ", primaryMobileNo="
				+ primaryMobileNo + ", secondaryMobileNo=" + secondaryMobileNo
				+ ", emailID=" + emailID + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAB_OFFICE_ID", unique = true)
	Long labOfficeId;
	@Column(name = "LAB_NAME")
	String labName;
	@Column(name = "STATUS")
	Integer status;
	@OneToOne(cascade = CascadeType.ALL)
	Address labAddress = new Address();
	@Column(name = "LAB_OWNER")
	String labOwner;

	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo; 
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;
	@Column(name = "EMAIL_ID")
	String emailID;
	@Column(name = "IMG_PATH")
	String img_path;
	public String getLabName() {
		return labName;
	}

	@XmlElement
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public Long getLabOfficeId() {
		return labOfficeId;
	}

	@XmlElement
	public void setLabOfficeId(Long labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	@XmlElement
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	public String getLabOwner() {
		return labOwner;
	}

	@XmlElement
	public void setLabOwner(String labOwner) {
		this.labOwner = labOwner;
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

	public String getImg_path() {
		return img_path;
	}
	@XmlElement
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

}
