package com.my.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Attendee")
public class MyAttendee implements Serializable {

//	Table Name: Attendee
//	Columns
//	Attendee_id             Number          not nullable
//	Title                   varchar2(4)             not nullable
//	First_name              varchar2                not nullable
//	Last_name               varchar2(50)            not nullable
//	Email                   varchar2(100)           not nullable
//	Mobile_num              number          nullable
//	Work_num                number          nullable       

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "Attendee_id")
	Long attendieId;
	
	@Column(name="Ttile",length=4)
	String title;
	
	@Column(name="First_name")
	String firstName;
	
	@Column(name="Last_name", length=50)
	String lastName;
	
	@Column(name="Email", length=100)
	String email;
	
	@Column(name="Mobile_num")
	Long mobileNumber;
	
	@Column(name="Work_num")
	Long workNumber;

    @ManyToMany(mappedBy="bscAttendeeList",fetch=FetchType.EAGER)
    private List<MyMeeting> bscMeetingList;       

	
	
	////////////////////////GETTERS AND SETTTERS

	public List<MyMeeting> getBscMeetingList() {
		return bscMeetingList;
	}

	public void setBscMeetingList(List<MyMeeting> bscMeetingList) {
		this.bscMeetingList = bscMeetingList;
	}

	public Long getAttendieId() {
		return attendieId;
	}

	public void setAttendieId(Long attendieId) {
		this.attendieId = attendieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(Long workNumber) {
		this.workNumber = workNumber;
	}
	
	
	
	
	
	
}
