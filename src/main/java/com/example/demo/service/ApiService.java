package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;


@Service
public class ApiService {
	@Autowired
	 ChildRepo r;
	public String add(Child m) {
		r.save(m);
		return "Added";
	}
	public List<Child> getDetails(){
		return r.findAll();
	}
	public 	List<Child> getSorted(String field){
		return r.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Child> getWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		Page<Child> page=r.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
}
