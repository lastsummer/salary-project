package com.e104.salary.service;
import com.e104.salary.router.model.Salary;


public interface SalaryService {
	public String getSingleSalary();
	
	public Salary save(Salary salary);
}
