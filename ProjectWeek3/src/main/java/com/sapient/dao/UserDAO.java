package com.sapient.dao;

import java.util.List;

import com.sapient.model.Post;
import com.sapient.model.User;

public interface UserDAO {


	void save(User user);

	void update(User user);

	void delete(int id);

	Post getPostByid(int id,int postid);

	

	Post createPost(int id, Post post);

	void deleteAllPostsById(int id);

	List<Post> getAllPosts(int id);

	void deletePostByid(int id, int postid);

}
