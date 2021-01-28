package com.e104.salary.router.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e104.salary.exception.CustomStatusException;
import com.e104.salary.router.model.Salary;
import com.e104.salary.router.model.SomeBean;
import com.e104.salary.service.SalaryService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;


@Api(tags = "Salary")
@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@Operation(summary = "取得單一Salary")
	@GetMapping(value = "", produces = { "application/json" })
	public String getSingleSalary(){
		return salaryService.getSingleSalary();
	}
	@PostMapping()
	public ResponseEntity<Salary> createSalary(@Validated @RequestBody Salary salary){
		Salary newSalary = salaryService.save(salary);
		return new ResponseEntity<>(newSalary,HttpStatus.CREATED);
	}
	
	@Operation(summary = "過濾Bean properties")
	@GetMapping(value = "/someBean", produces = { "application/json" })
	public MappingJacksonValue filterSomeBean(){
		SomeBean someBean = new SomeBean("value1","value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/error/{statusCode}")
	public String getSingleSalary(@PathVariable int statusCode, @Value("${env}") String env) throws Exception{
		System.out.println("env-->"+env);
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
