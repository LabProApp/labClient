package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SCHEDULE")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Schedule")
public class Schedule {

	// Entity to Hold Working Schedule Days & Time Window for Any Doctor/Lab
	// Branch/Hospital

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCHDLE_ID", unique = true)
	Long scheduleId;
	@Column(name = "DOC_ID")
	Long docId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	@Column(name = "LAB_REP_CD")
	Long labRepId;
	@Column(name = "WORKING_DAYS")
	String working_days; // We can maintain a single row for each day since the
							// schedule can be different for different day,
							// If schedule is same for multiple days then we can
							// keep them as || Separated Values -
							// MON||TUE||WED||THURS||FRI||SAT||SUN

	@Column(name = "MRNG_START")
	Date morning_time_start; // Start Time of Morning Shift
	@Transient
	String morning_time_start_str; // Start Time of Morning Shift
	@Column(name = "MRNG_END")
	Date morning_time_end; // End Time of Morning Shift
	@Transient
	String morning_time_end_str; // End Time of Morning Shift
	@Column(name = "MRNG_TKNS_TOTAL")
	// Number of Patients that can be Served in Morning,
	Integer morning_tokens_total; // so that System can dynamically calculate
									// TimeSlot for each Patient

	@Column(name = "AFTRN_START")
	Date afternoon_time_start; // Start Time of AfterNoon Shift
	@Transient
	String afternoon_time_start_str; // Start Time of AfterNoon Shift
	@Column(name = "AFTRN_END")
	Date afternoon_time_end; // End Time of AfterNoon Shift
	@Transient
	String afternoon_time_end_str; // End Time of AfterNoon Shift
	@Column(name = "AFTRN_TKNS_TOTAL")
	Integer afternoon_tokens_total; // Number of Patients that can be Served in
									// Afternoon
									// so that System can dynamically calculate
									// TimeSlot for each Patient

	@Column(name = "EVNG_START")
	Date evening_time_start; // Start Time of Evening Shift
	@Transient
	String evening_time_start_str; // Start Time of Evening Shift
	@Column(name = "EVNG_END")
	Date evening_time_end; 	// End Time of Evening Shift
	@Transient
	String evening_time_end_str; // End Time of Evening Shift
	@Column(name = "EVNG_TKNS_TOTAL")
	Integer evening_tokens_total; // Number of Patients that can be Served in
									// Evening so that System can dynamically
									// calculate TimeSlot for each Patient

	@Column(name = "NIGHT_START")
	Date night_time_start; // Start Time of Night Shift 20:00
	@Transient
	String night_time_start_str; // Start Time of Night Shift 20:00
	@Column(name = "NIGHT_END")
	Date night_time_end; // End Time of Night Shift 08:00
	@Transient
	String night_time_end_str; // End Time of Night Shift 08:00
	@Column(name = "NIGHT_TKNS_TOTAL")
	Integer night_tokens_total; // Number of Patients that can be Served in
								// Night
								// so that System can dynamically calculate
								// TimeSlot for each Patient

	@Column(name = "STATUS")
	Integer status;

	public Long getScheduleId() {
		return scheduleId;
	}

	@XmlElement
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getDocId() {
		return docId;
	}

	@XmlElement
	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getBranchCode() {
		return branchCode;
	}

	@XmlElement
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	public Long getLabRepId() {
		return labRepId;
	}

	@XmlElement
	public void setLabRepId(Long labRepId) {
		this.labRepId = labRepId;
	}

	public String getWorking_days() {
		return working_days;
	}

	@XmlElement
	public void setWorking_days(String working_days) {
		this.working_days = working_days;
	}

	
	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getMorning_time_start() {
		return morning_time_start;
	}
	@XmlElement
	public void setMorning_time_start(Date morning_time_start) {
		this.morning_time_start = morning_time_start;
	}

	public String getMorning_time_start_str() {
		return morning_time_start_str;
	}
	@XmlElement
	public void setMorning_time_start_str(String morning_time_start_str) {
		this.morning_time_start_str = morning_time_start_str;
	}

	public Date getMorning_time_end() {
		return morning_time_end;
	}
	@XmlElement
	public void setMorning_time_end(Date morning_time_end) {
		this.morning_time_end = morning_time_end;
	}

	public String getMorning_time_end_str() {
		return morning_time_end_str;
	}
	@XmlElement
	public void setMorning_time_end_str(String morning_time_end_str) {
		this.morning_time_end_str = morning_time_end_str;
	}

	public Integer getMorning_tokens_total() {
		return morning_tokens_total;
	}
	@XmlElement
	public void setMorning_tokens_total(Integer morning_tokens_total) {
		this.morning_tokens_total = morning_tokens_total;
	}

	public Date getAfternoon_time_start() {
		return afternoon_time_start;
	}
	@XmlElement
	public void setAfternoon_time_start(Date afternoon_time_start) {
		this.afternoon_time_start = afternoon_time_start;
	}

	public String getAfternoon_time_start_str() {
		return afternoon_time_start_str;
	}
	@XmlElement
	public void setAfternoon_time_start_str(String afternoon_time_start_str) {
		this.afternoon_time_start_str = afternoon_time_start_str;
	}

	public Date getAfternoon_time_end() {
		return afternoon_time_end;
	}
	@XmlElement
	public void setAfternoon_time_end(Date afternoon_time_end) {
		this.afternoon_time_end = afternoon_time_end;
	}

	public String getAfternoon_time_end_str() {
		return afternoon_time_end_str;
	}
	@XmlElement
	public void setAfternoon_time_end_str(String afternoon_time_end_str) {
		this.afternoon_time_end_str = afternoon_time_end_str;
	}

	public Integer getAfternoon_tokens_total() {
		return afternoon_tokens_total;
	}
	@XmlElement
	public void setAfternoon_tokens_total(Integer afternoon_tokens_total) {
		this.afternoon_tokens_total = afternoon_tokens_total;
	}

	public Date getEvening_time_start() {
		return evening_time_start;
	}
	@XmlElement
	public void setEvening_time_start(Date evening_time_start) {
		this.evening_time_start = evening_time_start;
	}

	public String getEvening_time_start_str() {
		return evening_time_start_str;
	}
@XmlElement
	public void setEvening_time_start_str(String evening_time_start_str) {
		this.evening_time_start_str = evening_time_start_str;
	}

	public Date getEvening_time_end() {
		return evening_time_end;
	}
	@XmlElement
	public void setEvening_time_end(Date evening_time_end) {
		this.evening_time_end = evening_time_end;
	}

	public String getEvening_time_end_str() {
		return evening_time_end_str;
	}
	@XmlElement
	public void setEvening_time_end_str(String evening_time_end_str) {
		this.evening_time_end_str = evening_time_end_str;
	}

	public Integer getEvening_tokens_total() {
		return evening_tokens_total;
	}
	@XmlElement
	public void setEvening_tokens_total(Integer evening_tokens_total) {
		this.evening_tokens_total = evening_tokens_total;
	}

	public Date getNight_time_start() {
		return night_time_start;
	}
	@XmlElement
	public void setNight_time_start(Date night_time_start) {
		this.night_time_start = night_time_start;
	}

	public String getNight_time_start_str() {
		return night_time_start_str;
	}
	@XmlElement
	public void setNight_time_start_str(String night_time_start_str) {
		this.night_time_start_str = night_time_start_str;
	}

	public Date getNight_time_end() {
		return night_time_end;
	}
	@XmlElement
	public void setNight_time_end(Date night_time_end) {
		this.night_time_end = night_time_end;
	}

	public String getNight_time_end_str() {
		return night_time_end_str;
	}
	@XmlElement
	public void setNight_time_end_str(String night_time_end_str) {
		this.night_time_end_str = night_time_end_str;
	}

	public Integer getNight_tokens_total() {
		return night_tokens_total;
	}
	@XmlElement
	public void setNight_tokens_total(Integer night_tokens_total) {
		this.night_tokens_total = night_tokens_total;
	}

}
