package com.map1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@Column(name="pid")
	private int pId;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> employees;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

	public Project(int pId, String projectName, List<Emp> employees) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", projectName=" + projectName + ", employees=" + employees + "]";
	}
}
