package br.edu.ifpb.calendarred.dao;


import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.calendarred.model.Holydays;

public class HolydaysDAO extends GenericDAOJPAImpl<Holydays, Long>{
	private static Logger logger = Logger.getLogger(HolydaysDAO.class);
	
	public HolydaysDAO(EntityManager instance){
		super(instance);
	}	
}
