package com.namoo.blog.domain;

import java.util.List;

public class Blog {
	//
	private int blogId;
	private String name;
	private Author owner;
	private List<Post> posts;

	//--------------------------------------------------------------------------
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author getOwner() {
		return owner;
	}
	public void setOwner(Author owner) {
		this.owner = owner;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
