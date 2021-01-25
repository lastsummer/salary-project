package com.e104.salary.router.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="薪資報酬的詳細內容")
public class Salary {
	private Integer salary;
	@Size(min=10, max=10, message="格式不符合")
	@ApiModelProperty(notes="jobCat，有10個數字")
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
