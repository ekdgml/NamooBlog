package com.namoo.blog.dao;

import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

public interface PostDao {
	//
	int createPost(int blogId, Post post);
	Post readPost(int postId);
	Page<Post> readAllPosts(int blogId, PageInfo pageInfo);
	void updatePost(Post post);
	void deletePost(int postId);
	
	// comment
	void createComment(int postId, Comment comment);
	void deleteComment(int commentId);
}
