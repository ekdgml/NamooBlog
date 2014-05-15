package com.namoo.blog.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.dao.impl.BlogDaoImpl;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Blog;

public class BlogDaoTest {
	//
	private BlogDao dao;
	private AuthorDao authorDao;
	private String authorId = "ekdgml";
	
	@Before
	public void setUp() throws Exception {
		//
		authorDao = new AuthorDaoImpl();
		dao = new BlogDaoImpl();
		
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId(authorId);
		author.setName("박상희");
		author.setPassword("asdf");
		
		authorDao.createAuthor(author);
	}

	@After
	public void tearDown() throws Exception {
		//
		dao.deleteBlog(1);
		authorDao.deleteAuthor("ekdgml");
	}

	@Test
	public void testCRUD() {
		//
		//create
		Blog blog = new Blog();
		blog.setName("firstBlog");
		Author author = authorDao.readAuthor(authorId);
		blog.setOwner(author);
		int blogId = dao.createBlog(blog);
		
		//assert
		blog = dao.readBlog(blogId);
		assertNotNull(blog);
		assertThat(blog.getName(), is("firstBlog"));
		assertThat(blog.getOwner().getId(), is("ekdgml"));
		assertThat(blog.getOwner().getName(), is("박상희"));
		
		//update
		blog.setName("updateBlog");
		dao.updateBlog(blog);
		
		//assert
		blog = dao.readBlog(blog.getBlogId());
		assertThat(blog.getName(), is("updateBlog"));
		
		//delete
		dao.deleteBlog(blog.getBlogId());
		assertNull(dao.readBlog(blog.getBlogId()));
		
	}

}
