package org.jboss.seam.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;

public class MeetingDao {
	EntityManager em ;
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	public boolean createMeeting(Meeting meeting){
		//All database Query should be a part of Dao
        List existing = em.createQuery("select m.meetingId from Meeting m where m.meetingId=#{meeting.meetingId}")
           .getResultList();
        if (existing.size()==0)
        {
           em.persist(meeting); 
           return true;
        }
        return false;
	}
	
	
	public List<Meeting> findAll(){
		 List<Meeting> meetingList = em.createQuery("select m from Meeting m ").getResultList();
		 return meetingList;
	}
	public List<Meeting> findMeetings(String meetingText){
		  List<Meeting> meetingList = em.createQuery("select m from Meeting m where m.meetingId like :meetingId " +
		 		"OR m.meetingLocation like :meetingText")
         .setParameter("meetingText", "%"+meetingText+"%")
         .getResultList();
		 return meetingList;
	}
	

}
