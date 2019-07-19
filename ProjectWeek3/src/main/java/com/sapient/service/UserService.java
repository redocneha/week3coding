package com.sapient.service;

import java.util.List;

import com.sapient.model.Post;
import com.sapient.model.User;

public interface UserService {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public Post createPost(int id,Post post);
	public Post getPostById(int id,int postid);
	public void deletePostById(int id,int postid);
	public void deleteAllPostsById(int id);
	public List<Post> getAllPosts(int id);

}
