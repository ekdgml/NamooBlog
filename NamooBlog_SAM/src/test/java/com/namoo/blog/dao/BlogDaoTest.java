package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.dao.impl.BlogDaoImpl;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Blog;

public class BlogDaoTest {

	private BlogDao blogDao;
	private AuthorDao authorDao;
	
	@Before
	public void setUp() throws Exception {
		//
		blogDao = new BlogDaoImpl();
		authorDao = new AuthorDaoImpl();
		
		createAuthor();
	}
	
	@After
	public void tearDown() throws Exception {
		deleteAuthor();
	}

	@Test
	public void testCRUD() {
		//
		String blogName = "나무소리 블로그";
		String ownerId = "hyunohkim";
		
		Blog blog = new Blog();
		blog.setName(blogName);
		blog.setOwner(new Author(ownerId));
		
		// create
		int blogId = blogDao.createBlog(blog);
		
		// read
		blog = blogDao.readBlog(blogId);
		
		assertThat(blogName, is(blog.getName()));
		assertThat(ownerId, is(blog.getOwner().getId()));

		// update
		blog.setName("나무소리 블로그 수정");
		blogDao.updateBlog(blog);
		
		blog = blogDao.readBlog(blogId);
		assertThat("나무소리 블로그 수정", is(blog.getName()));
	
		// delete
		blogDao.deleteBlog(blogId);
		assertNull(blogDao.readBlog(blogId));
	}
	
	//--------------------------------------------------------------------------
	
	private void createAuthor() {
		//
		authorDao.createAuthor(new Author("hyunohkim", "김현오", "hyunohkim@nextree.co.kr", "qwer1234"));
	}

	private void deleteAuthor() {
		//
		authorDao.deleteAuthor("hyunohkim");
	}
}
