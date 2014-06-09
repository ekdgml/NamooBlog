package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.PostDaoImpl;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.domain.PostType;

public class PostDaoTest {

	private PostDao postDao;
	
	@Before
	public void setUp() throws Exception {
		//
		postDao = new PostDaoImpl();
	}

	@Test
	public void testCRUD() {
		//
		int blogId = 1;
		String subject = "first post";
		String contents = "contents...";
		
		Post post = new Post();
		post.setSubject(subject);
		post.setContents(contents);
		
		int postId = postDao.createPost(blogId, post);
		
		// read
		post = postDao.readPost(postId);
		
		assertThat(subject, is(post.getSubject()));
		assertThat(contents, is(post.getContents()));
		
		// update
		
		// comment test
		Comment comment = new Comment();
		comment.setComment("comment1");
		comment.setCommenter(new Author("hyunohkim"));
		
		// add comment
		postDao.createComment(postId, comment);
		post = postDao.readPost(postId);
		
		assertThat(1, is(post.getComments().size()));
		assertThat("comment1", is(post.getComments().get(0).getComment()));
		
		// delete
		postDao.deletePost(postId);
		assertNull(postDao.readPost(postId));
	}
	
	@Test
	public void testCreatePost() {
		//
		Post post = new Post();
		post.setSubject("TypeHandler test");
		post.setContents("Very easy~!");
		post.setType(PostType.Open);
		
		// create
		int postId = postDao.createPost(1, post);
		
		// read
		post = postDao.readPost(postId);
		
		assertThat(PostType.Open, is(post.getType()));
		assertThat("TypeHandler test", is(post.getSubject()));
	}

}
