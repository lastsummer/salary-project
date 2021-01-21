package com.e104.salary.router.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e104.salary.exception.CustomStatusException;
import com.e104.salary.service.salary.SalaryService;


@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@GetMapping()
	public String getSingleSalary(){
		return salaryService.getSingleSalary();
	}
	
	@GetMapping("/error/{statusCode}")
	public String getSingleSalary(@PathVariable int statusCode) throws Exception{
		if(statusCode==400) {
			throw new CustomStatusException("show stateCode 400", HttpStatus.BAD_REQUEST);
		}else if(statusCode==401) {
			throw new CustomStatusException("show stateCode 401", HttpStatus.UNAUTHORIZED);
		}else if(statusCode==403) {
			throw new CustomStatusException("show stateCode 403", HttpStatus.FORBIDDEN);
		}
		throw new Exception("other");
	}
}
