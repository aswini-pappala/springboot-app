package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private final CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	@GetMapping("/all")
	public List<Map<String,Object>> allCustomer(){
		return customerService.allCustomer();
	}
	@GetMapping("/byId/{id}")
	public Map<String,Object> customerById(@PathVariable("id")Long id){
		return customerService.customerById(id);
	}
	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Map<String,Object> cust){
		return customerService.insertCustomer(cust);
	}
	@PutMapping("/update")
	public String updateCustomer(@RequestBody Map<String,Object> cust){
		return customerService.updateCustomer(cust);
	}
	@DeleteMapping("/delete/{id}")
	public String delCustomer(@PathVariable("id")Long id){
		return customerService.delCustomer(id);
	}
}
