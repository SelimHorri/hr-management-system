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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "departments")
@Table(name = "departments")
public final class Department implements Serializable {
	
	private static final long serialVersionUID  =  1L;
	
	@Id
    @Column(name = "deptno", unique = true, nullable = false, precision = 10)
    private Integer deptno;
	
    @Column(name = "dname", length = 100)
    private String dname;
    
    @Column(name = "loc", length = 100)
    private String loc;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Employee> employees;
    
    @Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", employees=" + employees + "]";
	}
    
	public Department() {
    	
	}
	
	public Department(String dname, String loc, Set<Employee> employee) {
		super();
		this.dname = dname;
		this.loc = loc;
		this.employees = employee;
	}
	
	public Department(Integer deptno, String dname, String loc, Set<Employee> employee) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.employees = employee;
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
	
	public Set<Employee> getEmployee() {
		return Collections.unmodifiableSet(employees);
	}

	public void setEmployee(final Set<Employee> employee) {
		this.employees = employee;
	}
    
    
    
}












