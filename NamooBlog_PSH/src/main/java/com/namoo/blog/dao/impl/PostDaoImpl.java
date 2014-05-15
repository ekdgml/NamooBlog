package com.namoo.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namoo.blog.dao.PostDao;
import com.namoo.blog.dao.mapper.PostMapper;
import com.namoo.blog.dao.mapper.SessionFactory;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;

public class PostDaoImpl implements PostDao {
	//
	@Override
	public int createPost(int blogId, Post post) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.insertPost(blogId, post);
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
			PostMapper mapper = session.getMapper(PostMapper.class);
			post = mapper.selectPost(postId);
		} finally {
			session.close();
		}
		return post;
	}

	@Override
	public List<Post> readAllPosts(int blogId) {
		//
		SqlSession session = SessionFactory.createSession();
		List<Post> posts = new ArrayList<Post>();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			posts = mapper.selectAllPosts(blogId);
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
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.updatePost(post);
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePost(int postId) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.deletePost(postId);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteAllPosts() {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.deleteAllPosts();
		} finally {
			session.close();
		}
	}

	@Override
	public void createComment(int postId, Comment comment) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.insertComment(postId, comment);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateComment(Comment comment) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.updateComment(comment);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteComment(int commentId) {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.deleteComment(commentId);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteAllComments() {
		//
		SqlSession session = SessionFactory.createSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			mapper.deleteAllComments();
		} finally {
			session.close();
		}
	}
}
