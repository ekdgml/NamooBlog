package com.namoo.blog.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namoo.blog.dao.PostDao;
import com.namoo.blog.dao.mapper.PostMapper;
import com.namoo.blog.dao.mapper.SessionFactory;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;

public class PostDaoImpl implements PostDao {

	@Override
	public int createPost(int blogId, Post post) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			postMapper.insertPost(blogId, post);
		} finally {
			session.close();
		}		
		return post.getPostId();
	}

	@Override
	public Post readPost(int postId) {
		// 
		SqlSession session = SessionFactory.createSession();
		Post post = null;
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			post = postMapper.selectPost(postId);
		} finally {
			session.close();
		}		
		return post;	
	}

	@Override
	public List<Post> readAllPosts(int blogId) {
		// 
		SqlSession session = SessionFactory.createSession();
		List<Post> posts = null;
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			posts = postMapper.selectAllPosts(blogId);
		} finally {
			session.close();
		}		
		return posts;	
	}

	@Override
	public void updatePost(Post post) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			postMapper.updatePost(post);
		} finally {
			session.close();
		}		
	}

	@Override
	public void deletePost(int postId) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			postMapper.deleteAllComments(postId);
			postMapper.deletePost(postId);
		} finally {
			session.close();
		}		
	}

	@Override
	public void createComment(int postId, Comment comment) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			postMapper.insertComment(postId, comment);
		} finally {
			session.close();
		}			
	}

	@Override
	public void deleteComment(int commentId) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper postMapper = session.getMapper(PostMapper.class);
			postMapper.deleteComment(commentId);
		} finally {
			session.close();
		}		
	}
}
