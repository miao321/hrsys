package com.hrsys.wage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_palv")
public class PaLV {
	private Long Id;
	private String parank;    //考评等级
	private String valueup;   //成绩上限
	private String valuedown;   //成绩下限
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return Id;
	}
	public String getParank() {
		return parank;
	}
	public String getValueup() {
		return valueup;
	}
	public String getValuedown() {
		return valuedown;
	}
	public void setId(Long id) {
		Id = id;
	}
	public void setParank(String parank) {
		this.parank = parank;
	}
	public void setValueup(String valueup) {
		this.valueup = valueup;
	}
	public void setValuedown(String valuedown) {
		this.valuedown = valuedown;
	}
	

}
