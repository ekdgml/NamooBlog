package com.namoo.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.blog.dao.BlogDao;
import com.namoo.blog.dao.mapper.BlogMapper;
import com.namoo.blog.domain.Blog;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public int createBlog(Blog blog) {
		// 
		blogMapper.insertBlog(blog);
		return blog.getBlogId();
	}

	@Override
	public Blog readBlog(int blogId) {
		// 
		return blogMapper.selectBlog(blogId);
	}

	@Override
	public List<Blog> readAllBlogs() {
		//
		return blogMapper.selectAllBlogs();
	}

	@Override
	public void updateBlog(Blog blog) {
		//
		blogMapper.updateBlog(blog);
	}

	@Override
	public void deleteBlog(int blogId) {
		//
		blogMapper.deleteBlog(blogId);	
	}

}
