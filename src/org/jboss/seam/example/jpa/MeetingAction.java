package org.jboss.seam.example.jpa;

import static org.jboss.seam.ScopeType.SESSION;

import java.io.Serializable;
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
import org.jboss.seam.faces.FacesMessages;


@Scope(SESSION)
@Name("meetingAction")
public class MeetingAction implements Serializable 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@In
	   private EntityManager em;
	 @DataModel
	   private List<Meeting> meetingList;
	 @DataModelSelection 
	   private Meeting meetingSelection;
	 
	   @In
	   private User user;

	 @In
	   private Meeting meeting;
	 
	 @In
	   private FacesMessages facesMessages;
	   
	 private boolean created;

	 public void createMeeting()
	   {
		 //All database Query should be a part of Dao
	         List existing = em.createQuery("select u.username from User u where u.username=#{user.username}")
	            .getResultList();
	         if (existing.size()==0)
	         {
	            em.persist(meeting); 
	            facesMessages.add("Successfully registered as #{user.username}");
	            created = true;
	         }
	         else
	         {
	            facesMessages.addToControl("meetingId", "Meeting #{meeting.meetingId} already exists");
	         }
	      
	   }

	 public boolean isCreated()
	   {
	      return created;
	   }

	   
	 @Factory
//	 @Observer("bookingConfirmed")
	 @Transactional
	   public void getAllMeetings()
	   {
		 meetingList = em.createQuery("select m from Meeting m where m.user.username = :username")
	            .setParameter("username", user.getUsername())
	            .getResultList();
	   }
	   
}
