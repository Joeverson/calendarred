package br.edu.ifpb.calendarred.model;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Holydays implements CalendarWars{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String type;
	@Column
	private String Descricao;	
	@Column
	private Calendar date;
	@ManyToOne
	private Holydays substituto;
	
	
	public Holydays(){}
	
	public Holydays(String type, String descricao, Calendar date) {		
		this.type = type;
		Descricao = descricao;		
		this.date = date;
		this.substituto = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Holydays getSubstituto() {
		return substituto;
	}

	public void setSubstituto(Holydays substituto) {
		this.substituto = substituto;
	}

	public String getType() {
		return type;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
}
