package com.gregashby.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	private int departmentId;
	
	@Column(name="NAME", length=20, nullable=true)
	private String name;
	
	@OneToMany(mappedBy="department")
	private Collection<Employee> employees = new ArrayList<Employee>();

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee){
		getEmployees().add(employee);
		employee.setDepartment(this);
	}
	
	
}
