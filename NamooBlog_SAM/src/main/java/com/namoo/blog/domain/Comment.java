package com.namoo.blog.domain;

public class Comment {
	//
	private int commentId;
	private String comment;
	private Author commenter;
	
	//--------------------------------------------------------------------------
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Author getCommenter() {
		return commenter;
	}
	public void setCommenter(Author commenter) {
		this.commenter = commenter;
	}
	
}
