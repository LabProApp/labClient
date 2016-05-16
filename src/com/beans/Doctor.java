package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR")
public class Doctor {

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", doctorName=" + doctorName
				+ ", branchCode=" + branchCode + ", status=" + status
				+ ", hospitalName=" + hospitalName + ", doctorDegrees="
				+ doctorDegrees + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorExperience="
				+ doctorExperience + ", docAddress=" + docAddress
				+ ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + ", emailID="
				+ emailID + ", img_path=" + img_path + ", fee=" + fee
				+ ", bookFlag=" + bookFlag + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID", unique = true)
	Long docId;
	@Column(name = "DOC_NAME")
	String doctorName;
	@Column(name = "DOC_BRANCH_CD")
	Long branchCode;
	@Column(name = "STATUS")
	Integer status;
	@Column(name = "HOSP_NAME")
	String hospitalName;
	@Column(name = "DOC_DEGREE")
	String doctorDegrees;
	@Column(name = "DOC_SPEC")
	String doctorSpecialization;
	@Column(name = "DOC_EXP")
	String doctorExperience;
	@OneToOne(cascade = CascadeType.ALL)
	Address docAddress = new Address();
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;
	@Column(name = "EMAIL_ID")
	String emailID;
	@Column(name = "IMG_PATH")
	String img_path;
	@Column(name = "FEE")
	Integer fee;
	@Column(name = "BOOK_FLAG")
	Integer bookFlag;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorDegrees() {
		return doctorDegrees;
	}

	public void setDoctorDegrees(String doctorDegree) {
		this.doctorDegrees = doctorDegree;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(String doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public Address getDocAddress() {
		return docAddress;
	}

	public void setDocAddress(Address docAddress) {
		this.docAddress = docAddress;
	}

	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	public String getSecondaryMobileNo() {
		return secondaryMobileNo;
	}

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

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(Integer bookFlag) {
		this.bookFlag = bookFlag;
	}

}
