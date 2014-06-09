package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Blog;

public class BlogDaoTest extends AbstractDbUnitTest{
	//
	private static final String DATASET_XML = "/com/namoo/blog/dao/BlogDaoTest_dataset.xml";
	
	@Autowired
	private BlogDao dao;
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateBlog() {
		//
		Blog blog = new Blog();
		blog.setName("fifthBlog");
		blog.setOwner(new Author("gdohong"));
		int blogId = dao.createBlog(blog);
		
		//assertion
		blog = dao.readBlog(blogId);
		assertThat(blog.getName(), is("fifthBlog"));
		assertThat(blog.getOwner().getName(), is("홍길동"));
		assertThat(blog.getOwner().getEmail(), is("gdohong@a.co.kr"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadBlog() {
		//
		Blog blog = dao.readBlog(1);
		
		//assertion
		assertThat(blog.getName(), is("firstBlog"));
		assertThat(blog.getOwner().getName(), is("김현오"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllBlogs() {
		//
		List<Blog> blogs = dao.readAllBlogs();
		
		//assertion
		assertThat(blogs.size(), is(4));
		assertThat(blogs.get(0).getName(), is("firstBlog"));
		assertThat(blogs.get(0).getOwner().getName(), is("김현오"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdateBlog() {
		//
		Blog blog = dao.readBlog(2);
		blog.setName("testBlog");
		dao.updateBlog(blog);
		
		//assertion
		blog = dao.readBlog(2);
		assertThat(blog.getName(), is("testBlog"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteBlog() {
		//
		dao.deleteBlog(4);
		
		//assertion
		assertNull(dao.readBlog(4));
		assertThat(dao.readAllBlogs().size(), is(3));
	}

}