package org.jboss.seam.example.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.FacesMessages;


@Name("meetingCreateAction")
public class MeetingCreateAction implements Serializable 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@In
	   private EntityManager em;
	//variables for createmeeting
	   @In
	   private User user;

	 @In
	   private Meeting meeting;

	 private boolean created;

	 //events and meetingCreated variable communicates to update the list of meetings
	 @In
	   private Events events;
	   
		 
	 @In
	   private FacesMessages facesMessages;


	private MeetingDao meetingDao = new MeetingDao();
	 public void createMeeting()
	   {
		 meetingDao.setEntityManager(em);
		 boolean isCreated = meetingDao.createMeeting(meeting);
		 if(isCreated){
			   facesMessages.add("Successfully create as #{meeting.meetingId}");
		      events.raiseTransactionSuccessEvent("meetingCreated");

	            created = true;
		 }else{
			 created = false;
			 facesMessages.addToControl("meetingId", "Meeting #{meeting.meetingId} already exists");
		 }
		  
	   }

	 
	 public boolean isCreated()
	   {
	      return created;
	   }

	
	   
}
