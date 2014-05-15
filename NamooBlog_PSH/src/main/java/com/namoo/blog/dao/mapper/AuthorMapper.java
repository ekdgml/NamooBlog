package com.namoo.blog.dao.mapper;

import java.util.List;

import com.namoo.blog.domain.Author;

public interface AuthorMapper {
	//
	void insertAuthor(Author author);
	Author selectAuthor(String authorId);
	List<Author> selectAuthorsByName(String name);
	List<Author> selectAuthorsByIds(String ... authorIds);
	void updateAuthor(Author author);
	void deleteAuthor(String authorId);
	
}
