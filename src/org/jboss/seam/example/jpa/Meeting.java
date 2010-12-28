package org.jboss.seam.example.jpa;

import static org.jboss.seam.ScopeType.SESSION;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Name("meeting")
@Scope(SESSION)
@Table(name="Meeting")
public class Meeting {
	@Id
	@Column(name = "MEETING_ID", nullable = false, precision = 22, scale = 0)
	private String meetingId;
	
	 @Basic @Temporal(TemporalType.DATE)
	 @NotNull
	 private Date meetingDate;

	@Column
	@NotNull
	@Length(min=5, max=15)
	private String meetingLocation;
	
	
	@Column(name = "Agenda",length = 2000)
	private String meetingAgenda;
	
	@Column(name = "meetingNotes",length = 2000)
	private String meetingNotes;
	
	@Column(name = "meetingCost",precision=6, scale=2)
	private BigDecimal meetingCost;
	
	public BigDecimal getMeetingCost() {
		return meetingCost;
	}


	public void setMeetingCost(BigDecimal meetingCost) {
		this.meetingCost = meetingCost;
	}


	@Column(name = "meetingReason",length = 2000)
	private String meetingReason;
	
	
	@OneToMany(cascade = { }, fetch = FetchType.LAZY, targetEntity=User.class) //mappedBy = "meetings"
	private Set<User> attendies;


	public String getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}


	public Date getMeetingDate() {
		return meetingDate;
	}


	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}


	public String getMeetingLocation() {
		return meetingLocation;
	}


	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}


	public String getMeetingAgenda() {
		return meetingAgenda;
	}


	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}


	public String getMeetingNotes() {
		return meetingNotes;
	}


	public void setMeetingNotes(String meetingNotes) {
		this.meetingNotes = meetingNotes;
	}


	public String getMeetingReason() {
		return meetingReason;
	}


	public void setMeetingReason(String meetingReason) {
		this.meetingReason = meetingReason;
	}


	public Set<User> getAttendies() {
		return attendies;
	}


	public void setAttendies(Set<User> attendies) {
		this.attendies = attendies;
	}

	///////////////////////////////
	

}
