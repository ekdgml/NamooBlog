package com.namoo.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.blog.dao.PostDao;
import com.namoo.blog.dao.mapper.PostMapper;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private PostMapper postMapper;
	
	@Override
	public int createPost(int blogId, Post post) {
		// 
		postMapper.insertPost(blogId, post);
		return post.getPostId();
	}

	@Override
	public Post readPost(int postId) {
		// 
		return postMapper.selectPost(postId);
	}

	@Override
	public Page<Post> readAllPosts(int blogId, PageInfo pageInfo) {
		// 
		List<Post> posts =  postMapper.selectAllPosts(blogId, pageInfo);
		int totalCount = postMapper.countAllPosts(blogId);
		
		return new Page<Post>(pageInfo, totalCount, posts);
	}

	@Override
	public void updatePost(Post post) {
		// 
		postMapper.updatePost(post);
	}

	@Override
	public void deletePost(int postId) {
		//
		postMapper.deleteAllComments(postId);
		postMapper.deletePost(postId);
	}

	@Override
	public void createComment(int postId, Comment comment) {
		// 
		postMapper.insertComment(postId, comment);
	}

	@Override
	public void deleteComment(int commentId) {
		// 
		postMapper.deleteComment(commentId);
	}
}
