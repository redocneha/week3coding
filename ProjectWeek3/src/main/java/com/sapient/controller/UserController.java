package com.sapient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.model.Post;
import com.sapient.model.User;
import com.sapient.service.UserService;

//@Controller
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	@ResponseStatus(HttpStatus.OK)
	public String saveUser(@RequestBody User user) {

		System.out.print(user.getName());
		System.out.print(user.getAdr());
		System.out.print(user.getPosts());
		userService.saveUser(user);

		return "success";
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@PathVariable("id") int id,@RequestBody User user) {
		System.out.println(user.getId());
		user.setId(id);
		userService.updateUser(user);

	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);

	}

	@PostMapping(value = "/{id}/post", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Post createPost(@PathVariable("id") int id, @Valid @RequestBody Post post) {
		return userService.createPost(id, post);

	}

	@GetMapping(value = "/{id}/post/{postid}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Post getPostById(@PathVariable("id") int id, @PathVariable("postid") int postid) {
		return (userService.getPostById(id, postid));

	}

	@GetMapping(value = "/{id}/posts", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public List getAllPosts(@PathVariable("id") int id) {
		List<Post> l = userService.getAllPosts(id);
		return l;

	}

	@DeleteMapping(value = "/{id}/delete/{postid}")
	@ResponseStatus(HttpStatus.OK)
	public void deletePostById(@PathVariable("id") int id, @PathVariable("postid") int postid) {
		userService.deletePostById(id, postid);

	}

	@DeleteMapping(value = "/{id}/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deletePostById(@PathVariable("id") int id) {
		userService.deleteAllPostsById(id);

	}

}
