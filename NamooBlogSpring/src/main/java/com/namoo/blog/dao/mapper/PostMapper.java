package com.namoo.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.PageInfo;

public interface PostMapper {
	//
	void insertPost(@Param("blogId") int blogId, @Param("post") Post post);
	Post selectPost(int postId);
	List<Post> selectAllPosts(@Param("blogId") int blogId, @Param("pageInfo") PageInfo pageInfo);
	void updatePost(Post post);
	void deletePost(int postId);
	int countAllPosts(int blogId);
	
	// comment
	void insertComment(@Param("postId") int postId, @Param("comment") Comment comment);
	void deleteComment(int commentId);
	void deleteAllComments(int postId);
}
