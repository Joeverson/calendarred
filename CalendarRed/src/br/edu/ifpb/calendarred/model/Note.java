package br.edu.ifpb.calendarred.model;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Note implements CalendarWars{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private Calendar date;
	@Column
	private String descricao;	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Note(Calendar date, String descricao, User user) {
		this.date = date;
		this.descricao = descricao;		
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getNote() {
		return descricao;
	}


	public void setNote(String note) {
		this.descricao = note;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
