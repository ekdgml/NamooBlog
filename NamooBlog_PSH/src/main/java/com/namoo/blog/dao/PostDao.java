package com.namoo.blog.dao;

import java.util.List;

import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;

public interface PostDao {
	//
	int createPost(int blogId, Post post);
	Post readPost(int postId);
	List<Post> readAllPosts(int blogId);
	void updatePost(Post post);
	void deletePost(int postId);
	void deleteAllPosts();
	
	//comment
	void createComment(int postId, Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int commentId);
	void deleteAllComments();
}
