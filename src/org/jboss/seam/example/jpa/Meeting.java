package org.jboss.seam.example.jpa;

import static org.jboss.seam.ScopeType.SESSION;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Name("meeting")
@Scope(SESSION)
@Table(name="Meeting")
public class Meeting {
	@Id
	@Column(name = "MEETING_ID", nullable = false, precision = 22, scale = 0)
	private Long meetingId;
	
//	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 7)
	private Date meetingDate;

	@Column(name = "Location")
	private String meetingLocation;
	
	@Column(name = "Agenda",length = 2000)
	private String meetingAgenda;
	
	@Column(name = "meetingNotes",length = 2000)
	private String meetingNotes;
	
	@Column(name = "meetingReason",length = 2000)
	private String meetingReason;
	
	
	@OneToMany(cascade = { }, fetch = FetchType.LAZY, targetEntity=User.class) //mappedBy = "meetings"
	private Set<User> attendies;


	public Long getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(Long meetingId) {
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
