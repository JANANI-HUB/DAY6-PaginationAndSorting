package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	 @Autowired
     ApiService s;
	 @PostMapping("/post")
	 public String addDetails(@RequestBody Child m) {
		 s.add(m);
		 return "Added product ";
	 }
     
     @GetMapping("/get")
     public List<Child> showDetails(){
    	 return s.getDetails();
     }
     
     //sorting
     @GetMapping("/details/{field}")
     public List<Child> getWithSort(@PathVariable String field){
    	 return s.getSorted(field);
     }
     
     //pagination
     @GetMapping("/details/{offset}/{pageSize}")
     public List<Child> productsWithPagination(@PathVariable int offset,@PathVariable int pageSize){
    	 return s.getWithPagination(offset, pageSize);
     }
}
