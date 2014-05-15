package com.namoo.blog.domain;

import java.util.List;

public class Post {
	//
	private int postId;
	private String subject;
	private String contents;
	private PostType type;
	
	private List<Comment> comments;
	
	//-----------------------------------------------------------------------
	//constructor
	
	public Post() {
		//
		this.type = PostType.Draft;
	}
	
	//-----------------------------------------------------------------------
	//getter, setter
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public PostType getType() {
		return type;
	}
	public void setType(PostType type) {
		this.type = type;
	}
}
