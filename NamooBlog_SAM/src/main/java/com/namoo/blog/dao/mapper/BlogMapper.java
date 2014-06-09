package com.namoo.blog.dao.mapper;

import java.util.List;

import com.namoo.blog.domain.Blog;

public interface BlogMapper {
	//
	void insertBlog(Blog blog);
	Blog selectBlog(int blogId);
	List<Blog> selectAllBlogs();
	void updateBlog(Blog blog);
	void deleteBlog(int blogId);
}
