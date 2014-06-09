package com.namoo.blog.dao;

import java.util.List;

import com.namoo.blog.domain.Author;

public interface AuthorDao {
	//
	void createAuthor(Author author);
	Author readAuthor(String authorId);
	void updateAuthor(Author author);
	void deleteAuthor(String authorId);
	
	List<Author> readAuthorsByName(String name);
	List<Author> readAuthorsByIds(String ... authorIds);
}
