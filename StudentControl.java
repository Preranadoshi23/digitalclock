package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentControl {
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping("login{username}")
	public int login(@PathVariable String username, @RequestBody String password)
	{
		int count=userrepo.countByUsername(username);
		if(count==0)
			return 2; // wrong username
		else if(count>1)
			return 3; //multiple accounts with same username
		else 
		{
			User user=userrepo.findByUsername(username);
			if(user.password.equals(password))
				return 1;
			else
				return 4;
					
		}
	}
	
//	@RequestMapping("cntMax")
//	public int cntMax() {
//		return studentRepo.countByMarksGreaterThan(40);
//	}
//	
//	@RequestMapping("notMatch")
//	public List<Student> notMatch(){
//		return studentRepo.findByMarksNot(88);
//	}
//	
//	@RequestMapping("findByMark")
//	public List<Student> findByMark(){
//		return studentRepo.findByMarks(88);
//	}
//	
//	@RequestMapping("findByGreaterMark")
//	public List<Student> findByGreaterMark(){
//		return studentRepo.findByMarksGreaterThan(80);
//	}
//	
//	@RequestMapping("findByLessMark")
//	public List<Student> findByLessMark(){
//		return studentRepo.findByMarksLessThan(80);
//	}
//	
//	@RequestMapping("noNull")
//	public List<Student> noNull(){
//		return studentRepo.findByMarksIsNotNull();
//	}
//	
//	@RequestMapping("findNull")
//	public List<Student> findNull(){
//		return studentRepo.findByMarksIsNull();
//	}
//	
//	@RequestMapping("cntBetweenMinabdMax")
//	public int cntBetweenMinabdMax() {
//		return studentRepo.countByMarksGreaterThanAndMarksLessThan(70,80);
//	}
//	
//	@RequestMapping("idNotEqual")
//	public List<Student> idNotEqual(){
//		return studentRepo.findByIdNot(1);
//	}
//	
//	@RequestMapping("greaterId")
//	public List<Student> greaterId(){
//		return studentRepo.findByIdGreaterThan(6);
//	}
//	
	@RequestMapping("add")
	public Student add(@RequestBody Student student)
	{
		try
		{
			Student studentdb =studentRepo.save(student);
			return studentdb;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("get")
	public List<Student> get()
	{
		try {
			return studentRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("delete{id}")
	public int delete(@PathVariable int id)
	{
		try
		{
			studentRepo.deleteById(id);
			return 1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

}
