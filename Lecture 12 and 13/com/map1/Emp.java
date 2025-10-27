package com.map1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	@Column(name="eid")
	private int eId;
	
	@Column(name="ename")
	private String eName;
	
	@ManyToMany
	@JoinTable(
			name="emp_project_record",
			joinColumns = {@JoinColumn(name="eid")},
			inverseJoinColumns = {@JoinColumn(name="pid")}
			)
	private List<Project> projects;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Emp(int eId, String eName, List<Project> projects) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.projects = projects;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + ", projects=" + projects + "]";
	}
	
	
	
}
