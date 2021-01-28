package com.e104.salary.service.impl;

import org.springframework.stereotype.Service;

import com.e104.salary.router.model.Salary;
import com.e104.salary.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService{

	@Override
	public String getSingleSalary(){
		return "1000";
	}
	
	@Override
	public Salary save(Salary salary){
		return salary;
	}
}
