package br.edu.ifpb.calendarred.dao;



import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.calendarred.model.Note;

public class CalendarNotesDAO extends GenericDAOJPAImpl<Note, Long>{
	private static Logger logger = Logger.getLogger(CalendarNotesDAO.class);
	
	public CalendarNotesDAO(EntityManager instance){
		super(instance);
	}

	
}
