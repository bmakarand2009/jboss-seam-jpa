package org.jboss.seam.example.jpa;

import static org.jboss.seam.ScopeType.SESSION;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;

@Scope(SESSION)
@Name("meetingListAction")
public class MeetingListAction {
	private static final long serialVersionUID = 1L;
	
	private MeetingDao meetingDao = new MeetingDao();

	@In
	   private EntityManager em;
	//variables for getAllMeetings	
	@DataModel
	   private List<Meeting> meetings;
	 //variables for SearchMeeting
	 private String meetingText;
	 
   @DataModelSelection 
   private Meeting meeting;

   
	 
	 public Meeting getMeeting() {
		return meeting;
	}


	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}


	public String getMeetingText() {
		return meetingText;
	}


	public void setMeetingText(String meetingText) {
		this.meetingText = meetingText;
	}

	   
	 @Factory
	 @Observer("meetingCreated") //updates the meetingList when a new meeting is created
	 @Transactional
   public void findMeetings()
   {
	 meetingDao.setEntityManager(em);
	 if(meetingText==null || meetingText.trim().equals("")) meetings = meetingDao.findAll();
	 else meetings =  meetingDao.findMeetings(meetingText);
   }
 
}
