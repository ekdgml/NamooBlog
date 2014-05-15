package com.namoo.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;

public interface PostMapper {
	//
	void insertPost(@Param("blogId") int blogId, @Param("post") Post post);
	Post selectPost(int postId);
	List<Post> selectAllPosts(int blogId);
	void updatePost(Post post);
	void deletePost(int postId);
	void deleteAllPosts();
	
	//comment
	void insertComment(@Param("postId") int postId, @Param("comment") Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int commentId);
	void deleteAllComments();
}
