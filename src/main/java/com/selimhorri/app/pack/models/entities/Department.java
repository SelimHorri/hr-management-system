package com.selimhorri.app.pack.models.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Selim Horri
 */
@Entity(name = "departments")
@Table(name = "departments")
public final class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "deptno", unique = true, nullable = false, precision = 10)
	private Integer deptno;
	
	@Column(name = "dname", length = 100)
	private String dname;
	
	@Column(name = "loc", length = 100)
	private String loc;
	
	@OneToMany(targetEntity = Employee.class, mappedBy = "department", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Employee> employees;
	
	public Department() {
		
	}
	
	public Department(Integer deptno, String dname, String loc, Set<Employee> employees) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Employee> getEmployees() {
		return Collections.unmodifiableSet(employees);
	}

	public void setEmployees(final Set<Employee> employees) {
		this.employees = employees;
	}
	
	
		
}









