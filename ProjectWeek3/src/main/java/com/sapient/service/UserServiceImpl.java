package com.sapient.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.dao.HibernateDAOImpl;
import com.sapient.dao.UserDAO;
import com.sapient.model.Post;
import com.sapient.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO employeeDAO;

	public UserDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(UserDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public UserServiceImpl(UserDAO employeeDAO) {
		System.out.println("----------------------------------------------------------");
		System.out.println(employeeDAO);
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save user method of user service class ....");
		System.out.print(user.getName());
		employeeDAO.save(user);

	}

	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save update method of user service class ....");
		employeeDAO.update(user);

	}

	@Transactional
	public Post createPost(int id, Post post) {
		// TODO Auto-generated method stub
		System.out.println("Inside the create post employee method of user service class ....");
		return employeeDAO.createPost(id, post);
	}

	@Transactional
	public void deleteAllPostsById(int id) {
		System.out.println("Inside the save employee method of user service class ....");
		employeeDAO.deleteAllPostsById(id);
		// TODO Auto-generated method stub

	}

	@Transactional
	public List<Post> getAllPosts(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save employee method of user service class ....");
		return employeeDAO.getAllPosts(id);

	}

	@Transactional
	public void deletePostById(int id, int postid) {
		System.out.println("Inside the save employee method of user service class ....");
		employeeDAO.deletePostByid(id, postid);
		// TODO Auto-generated method stub

	}

	@Transactional
	public Post getPostById(int id, int postid) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save employee method of user service class ....");
		return employeeDAO.getPostByid(id, postid);

	}

	@Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside the deletye method of user service class ....");
		employeeDAO.delete(id);

	}

}
