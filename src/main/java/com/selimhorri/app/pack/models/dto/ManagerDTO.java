package com.selimhorri.app.pack.models.dto;

import java.io.Serializable;

/**
 * @author Selim Horri
 */
public class ManagerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer empno;
	private String ename;
	private Integer mgr;
	
	@Override
	public String toString() {
		return "ManagerDTO [empno=" + empno + ", ename=" + ename + ", mgr=" + mgr + "]";
	}
	
	public ManagerDTO() {
		
	}
	
	public ManagerDTO(Integer empno, String ename, Integer mgr) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.mgr = mgr;
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

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	
	
	
}










