package com.e104.salary.router.model;

import javax.validation.constraints.Size;

public class Salary {
	private Integer salary;
	@Size(min=10, max=10, message="格式不符合")
	private String jobCatCode;
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getJobCatCode() {
		return jobCatCode;
	}
	public void setJobCatCode(String jobCatCode) {
		this.jobCatCode = jobCatCode;
	}
}
