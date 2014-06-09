package com.namoo.blog.service.facade;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.dao.AbstractDbUnitTest;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

public class BlogServiceTest extends AbstractDbUnitTest{
	//
	private static final String DATASET_XML = "/com/namoo/blog/service/facade/BlogServiceTest_dataset.xml";
	
	@Autowired
	private BlogService service;
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testGetBlog() {
		//
		Blog blog = service.getBlog(1);
		
		//assertion
		assertThat(blog.getName(), is("firstBlog"));
		assertThat(blog.getPosts().size(), is(2));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testGetPost() {
		//
		Post post = service.getPost(1);
		
		//assertion
		assertThat(post.getContents(), is("firstPostContents"));
		assertThat(post.getComments().size(), is(3));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRegisterBlog() {
		//
		Blog blog = new Blog();
		blog.setName("새로운 블로그");
		blog.setOwner(new Author("hyunohkim"));
		try {
			service.registerBlog(blog);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//assertion
		blog = service.getBlog(5);
		assertNotNull(blog);
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testGetPosts() {
		//
		PageInfo pageInfo = new PageInfo(1, 5);
		Page<Post> page = service.getPosts(1, pageInfo);
		
		List<Post> posts = page.getResults();
		
		//assertion
		assertThat(posts.size(), is(2));
		
	}

}
