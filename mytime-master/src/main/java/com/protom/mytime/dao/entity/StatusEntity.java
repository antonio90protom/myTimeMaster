package com.protom.mytime.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "mp_status")
@ApiIgnore
public class StatusEntity implements Serializable {

	private static final long serialVersionUID = 389808207124987656L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "state_pos")
	private Integer position;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
	private List<TimeStatusEntity> states;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public List<TimeStatusEntity> getStates() {
		return states;
	}
	public void setStates(List<TimeStatusEntity> states) {
		this.states = states;
	}

}
