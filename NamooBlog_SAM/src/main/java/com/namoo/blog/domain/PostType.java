package com.namoo.blog.domain;

public enum PostType {
	Draft("D"),
	Private("P"),
	Open("O");
	
	private String code;
	
	private PostType(String code) {
		this.code = code;
	}
	
	public String code() { 
		return this.code;
	}
	
	public static PostType findBy(String code) {
		//
		for (PostType type : values()) {
			if (type.code.equals(code)) {
				return type;
			}
		}
		return null;
	}
}
