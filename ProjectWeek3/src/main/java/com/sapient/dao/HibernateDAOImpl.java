package com.sapient.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sapient.model.Post;
import com.sapient.model.User;

@Repository
public class HibernateDAOImpl implements UserDAO{
	@Autowired
    private SessionFactory sessionFactory;
	

	public void save(User user) {
		System.out.print(user.getName());
		Session session = sessionFactory.getCurrentSession();
		
        session.saveOrUpdate(user);
      
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		System.out.print(user.getId());
        User user1 = session.byId(User.class).load(user.getId());
       
        user1.setName(user.getName());
      
        session.update(user1);
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
        System.out.println(id);
        session.delete(user1);
		
	}

	public Post getPostByid(int id, int postid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
       ListIterator<Post> li=posts.listIterator();
       while(li.hasNext())
       {
    	   Post p1=li.next();
    	   if(p1.getId()==postid)
    	   {
    		   return p1;
    	   }
    	   
       }
		return null;
	}

	public Post createPost(int id, Post post) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
        List<Post> posts=user1.getPosts();
        posts.add(post);
        user1.setPosts(posts);
        session.save(user1);
        return post;
	}

	public void deleteAllPostsById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
     posts.clear();
     user1.setPosts(posts);
     session.save(user1);
		
	}

	public List<Post> getAllPosts(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
      return posts;
       
	}

	public void deletePostByid(int id, int postid) {
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
      
       for(Post p:posts)
       {
    	   if(p.getId()==postid)
    	   {
    		   posts.remove(p);
    		   session.delete(p);
    		   break;
    	   }
       }
       user1.setPosts(posts);
       session.save(user1);
     
		
	}

}
