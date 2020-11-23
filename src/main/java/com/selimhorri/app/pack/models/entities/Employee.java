package com.selimhorri.app.pack.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * @author Selim Horri
 */
@Entity(name = "employees")
@Table(name = "employees")
public final class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "empno", unique = true, nullable = false, precision = 10)
	private Integer empno;
	
	@Column(name = "ename", length = 100)
	private String ename;
	
	@Column(name = "job", length = 100)
	private String job;
	
	@Column(name = "mgr", precision = 10)
	private Integer mgr;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "hiredate")
	private LocalDateTime hireDate;
	
	@Column(name = "sal", precision = 7, scale = 2)
	private Double sal;
	
	@Column(name = "comm", precision = 7, scale = 2)
	private Double comm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptno", referencedColumnName = "deptno", nullable = true)
	private Department department;
	
	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
	private UserCredential userCredential;
	
	public Employee() {
		
	}
	
	public Employee(Integer empno, String ename, String job, Integer mgr, LocalDateTime hireDate, Double sal,
			Double comm, Department department) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + department.getDeptno()
				+ "]";
	}
	
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}
	
	
		
}











