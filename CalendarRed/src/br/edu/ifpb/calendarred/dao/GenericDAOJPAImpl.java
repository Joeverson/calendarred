package br.edu.ifpb.calendarred.dao;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

public class GenericDAOJPAImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> entityClass;

	protected EntityManager entityManager;
	
	
	public GenericDAOJPAImpl(EntityManager em) {
		this();
		this.entityManager = em;
	}

	public GenericDAOJPAImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T insert(T t) {
		try{
			this.beginTransaction();
			this.entityManager.persist(t);
			this.commit();
			return t;
		}catch(DAOException e){			
			System.out.println("nâo conseguiu inserir");
			this.rollback();
			e.getMessage();
		}
		return null;
	}

	@Override
	public T find(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		try{
			this.beginTransaction();
			t = this.entityManager.merge(t);
			this.entityManager.remove(t);
			this.commit();
		}catch(DAOException e){
			System.out.println("não conseguiu deletar");
			this.rollback();
			e.getMessage();
		}
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
		
	}

	@Override
	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	@Override
	public void rollback() {
		this.entityManager.getTransaction().rollback();		
	}
}
