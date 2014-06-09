package com.namoo.blog.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namoo.blog.dao.BlogDao;
import com.namoo.blog.dao.mapper.BlogMapper;
import com.namoo.blog.dao.mapper.SessionFactory;
import com.namoo.blog.domain.Blog;

public class BlogDaoImpl implements BlogDao {

	@Override
	public int createBlog(Blog blog) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.insertBlog(blog);
		} finally {
			session.close();
		}		
		return blog.getBlogId();
	}

	@Override
	public Blog readBlog(int blogId) {
		// 
		SqlSession session = SessionFactory.createSession();
		Blog blog = null;
		try {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blog = blogMapper.selectBlog(blogId);
		} finally {
			session.close();
		}		
		return blog;
	}

	@Override
	public List<Blog> readAllBlogs() {
		//
		SqlSession session = SessionFactory.createSession();
		List<Blog> blogs = null;
		try {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogs = blogMapper.selectAllBlogs();
		} finally {
			session.close();
		}		
		return blogs;	
	}

	@Override
	public void updateBlog(Blog blog) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.updateBlog(blog);
		} finally {
			session.close();
		}		
	}

	@Override
	public void deleteBlog(int blogId) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.deleteBlog(blogId);
		} finally {
			session.close();
		}	
	}

}
