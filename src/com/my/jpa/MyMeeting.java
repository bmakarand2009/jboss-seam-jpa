package com.my.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="CUST_MEETING")
//@SequenceGenerator(name="MEETINGIDSEQ", sequenceName="MEEET_ID_SEQ", allocationSize=1)
public class MyMeeting implements Serializable {
//	
//	Cust_meet_id            number          not nullable             unique sequence value
//	Cust_name               varchar2(100)           not nullable
//	Contract_id             number          not nullable
//	Profile_id              number          not nullable
//	Meet_timestamp  timestamp               not nullable
//	Location                varchar2(50)            not nullable
//	Attendees               varchar2(100)           not nullable
//	Reason                  varchar2                                               
//	Agenda          varchar2(100)           not nullable
//	Cust_note_id            number                                  Foreign key to Cust_note table
//	Cost                    number(12,4)
//	Meeting_type_cd varchar2(30)            not nullable   

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CUST_MEET_ID")
	private Long meetingId;

	@Column	(name ="CUST_NAME",length = 100)
	private String custName;
	
	@Column	(name ="CONTRACT_ID",nullable=false)
	private long contractId;

	@Column(name = "PROFILE_ID",nullable=false)
	private Long   profileId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MEET_TIMESTAMP")
	private Date meetingTime;
	
	@Column(name = "LOCATION" ,length=50)
	private String meetingLocation;
	
	//This is an extra field just added to support the table schema... needs to be deleted
	@Column(name="ATTENDEES",length=100)
	private String attendies;
	
	 @ManyToMany(fetch=FetchType.EAGER)
     @JoinTable(name="Meet_Attend_Map",
             joinColumns=
             @JoinColumn(name="CUST_MEET_ID", referencedColumnName="CUST_MEET_ID"),
       inverseJoinColumns=
             @JoinColumn(name="Attendee_id", referencedColumnName="Attendee_id")
     )
     private List<MyAttendee> bscAttendeeList;       


	@Column(name = "REASON")
	private String reason;

	@Column(name="AGENDA")
	private String agenda;
	
	@Column(name="CUST_NOTE_ID")
	private Long custNoteId;

	@Column(name = "COST", precision=12, scale=4)
	private BigDecimal meetingCost;
	
	
	@Column(name = "MEETING_TYPE_CD",length=30)
	private String meetingTypeCd;


	
	
	public String getAttendies() {
		return attendies;
	}


	public void setAttendies(String attendies) {
		this.attendies = attendies;
	}


	public Long getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public long getContractId() {
		return contractId;
	}


	public void setContractId(long contractId) {
		this.contractId = contractId;
	}


	public Long getProfileId() {
		return profileId;
	}


	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}


	public Date getMeetingTime() {
		return meetingTime;
	}


	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
	}


	public String getMeetingLocation() {
		return meetingLocation;
	}


	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}


	

	


	public List<MyAttendee> getBscAttendeeList() {
		return bscAttendeeList;
	}


	public void setBscAttendeeList(List<MyAttendee> bscAttendeeList) {
		this.bscAttendeeList = bscAttendeeList;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getAgenda() {
		return agenda;
	}


	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}


	public Long getCustNoteId() {
		return custNoteId;
	}


	public void setCustNoteId(Long custNoteId) {
		this.custNoteId = custNoteId;
	}


	public BigDecimal getMeetingCost() {
		return meetingCost;
	}


	public void setMeetingCost(BigDecimal meetingCost) {
		this.meetingCost = meetingCost;
	}


	public String getMeetingTypeCd() {
		return meetingTypeCd;
	}


	public void setMeetingTypeCd(String meetingTypeCd) {
		this.meetingTypeCd = meetingTypeCd;
	}

	
}
