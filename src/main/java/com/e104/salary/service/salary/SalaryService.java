package com.e104.salary.service.salary;
import org.springframework.stereotype.Component;

import com.e104.salary.router.model.Salary;


@Component
public class SalaryService {
	public String getSingleSalary(){
		return "1000";
	}
	
	public Salary save(Salary salary){
		return salary;
	}
}
