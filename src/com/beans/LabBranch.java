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
@Table(name = "LAB_BRANCH")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabBranch")
public class LabBranch {

	/* 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "LabBranch [labbranchCode=" + labbranchCode + ", labOfficeId="
				+ labOfficeId + ", labName=" + labName + ", status=" + status
				+ ", labBranchOwner=" + labBranchOwner + ", labAddress="
				+ labAddress + ", primaryMobileNo=" + primaryMobileNo
				+ ", emailID=" + emailID + ", img_path=" + img_path + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAB_BRANCH_CD", unique = true)
	Long labbranchCode;
	@Column(name = "LAB_OFFICE_ID")
	Long labOfficeId;
	@Column(name = "LAB_NAME")
	String labName;
	@Column(name = "STATUS")
	Integer status;
	@Column(name = "LAB_BR_OWNER")
	String labBranchOwner;
	@OneToOne(cascade = CascadeType.ALL)
	Address labAddress=new Address();
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	
	
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

	public String getLabBranchOwner() {
		return labBranchOwner;
	}

	/**
	 * @return the labbranchCode
	 */
	public Long getLabbranchCode() {
		return labbranchCode;
	}

	/**
	 * @param labbranchCode
	 *            the labbranchCode to set
	 */
	@XmlElement
	public void setLabbranchCode(Long labbranchCode) {
		this.labbranchCode = labbranchCode;
	}

	/**
	 * @return the primaryMobileNo3
	 */
	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	/**
	 * @param primaryMobileNo3
	 *            the primaryMobileNo3 to set
	 */
	@XmlElement
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	@XmlElement
	public void setLabBranchOwner(String labBranchOwner) {
		this.labBranchOwner = labBranchOwner;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	@XmlElement
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
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
