package com.example.demo.repo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//This indicates that this class is a Data Access Object
@Repository

//Repository class will access the database and perform database operations 
public class CustomerRepo {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	public CustomerRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	//Method to get all customer details
	public List<Map<String,Object>> allCustomer(){
		return jdbcTemplate.queryForList("select* from customer");
	}
	//Method to get a customer details by using id
	public Map<String,Object> customerById(Long id){
		return jdbcTemplate.queryForMap("select* from customer where id=?",id);
	}
	//Method to insert data in table customer
	public void insertCustomer(Map<String,Object> cust){
		jdbcTemplate.update("insert into customer values(?,?,?,?)",cust.get("id"),cust.get("name"),cust.get("phno"),cust.get("bill"));
	}
	//Method to update customer records
	public void updateCustomer(Map<String,Object> cust){
		jdbcTemplate.update("update customer set name=?,phno=?,bill=? where id=?",cust.get("name"),cust.get("phno"),cust.get("bill"),cust.get("id"));
	}
	//Method to delete customer records by using id
	public void delCustomer(Long id){
		jdbcTemplate.update("delete from customer where id=?",id);
	}
}
