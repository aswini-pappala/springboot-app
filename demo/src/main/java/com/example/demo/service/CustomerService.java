package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private final CustomerRepo customerRepo;
	public CustomerService(CustomerRepo customerRepo) {
		this.customerRepo=customerRepo;
	}
	public List<Map<String,Object>> allCustomer(){
		return customerRepo.allCustomer();
	}
	public Map<String,Object> customerById(Long id){
		return customerRepo.customerById(id);
	}
	public String insertCustomer(Map<String,Object> cust){
		customerRepo.insertCustomer(cust);
		return "Insertion Successful";
	}
	public String updateCustomer(Map<String,Object> cust){
		customerRepo.updateCustomer(cust);
		return "Updation Successful";
	}
	public String delCustomer(Long id){
		customerRepo.delCustomer(id);
		return "Deletion Successful";
	}
}
