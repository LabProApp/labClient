package com.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "REVIEWS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Reviews")
public class Reviews {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", doctorId=" + doctorId
				+ ", labOfficeId=" + labOfficeId + ", branchCode=" + branchCode
				+ ", star_rating=" + star_rating + ", ratingDate=" + ratingDate
				+ ", reviewDescription=" + reviewDescription
				+ ", ratingCustomerId=" + ratingCustomerId + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "REVIEW_ID")
	Long reviewId;
	@Column(name = "PTNT_ID")
	Long ratingCustomerId;
	@Column(name = "DOCTOR_ID")
	Long doctorId;
	@Column(name = "LAB_OFFICE_ID")
	Long labOfficeId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	@Column(name = "RATING")
	Integer star_rating;
	@Column(name = "RATING_DT")
	Date ratingDate;
	@Transient
	String ratingDateStr;
	@Column(name = "REVIEW")
	String reviewDescription;

	/**
	 * @return the reviewId
	 */
	public Long getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId
	 *            the reviewId to set
	 */
	@XmlElement
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 *            the doctorId to set
	 */
	@XmlElement
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the labOfficeId
	 */
	public Long getLabOfficeId() {
		return labOfficeId;
	}

	/**
	 * @param labOfficeId
	 *            the labOfficeId to set
	 */
	@XmlElement
	public void setLabOfficeId(Long labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	/**
	 * @return the branchCode
	 */
	public Long getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	@XmlElement
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the star_rating
	 */
	public Integer getStar_rating() {
		return star_rating;
	}

	/**
	 * @param star_rating
	 *            the star_rating to set
	 */
	@XmlElement
	public void setStar_rating(Integer star_rating) {
		this.star_rating = star_rating;
	}

	/**
	 * @return the ratingDate
	 */
	public Date getRatingDate() {
		return ratingDate;
	}

	/**
	 * @param ratingDate
	 *            the ratingDate to set
	 */

	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	/**
	 * @return the reviewDescription
	 */
	public String getReviewDescription() {
		return reviewDescription;
	}

	/**
	 * @param reviewDescription
	 *            the reviewDescription to set
	 */
	@XmlElement
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	/**
	 * @return the ratingCustomerId
	 */
	public Long getRatingCustomerId() {
		return ratingCustomerId;
	}

	/**
	 * @param ratingCustomerId
	 *            the ratingCustomerId to set
	 */
	@XmlElement
	public void setRatingCustomerId(Long ratingCustomerId) {
		this.ratingCustomerId = ratingCustomerId;
	}

	public String getRatingDateStr() {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			return format.format(this.getRatingDate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ratingDateStr;
	}

	@XmlElement
	public void setRatingDateStr(String ratingDateStr) {
		this.ratingDateStr = ratingDateStr;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			this.setRatingDate(format.parse(this.ratingDateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
