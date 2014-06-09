package com.namoo.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.blog.dao.AuthorDao;
import com.namoo.blog.dao.mapper.AuthorMapper;
import com.namoo.blog.domain.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private AuthorMapper authorMapper;
	
	@Override
	public void createAuthor(Author author) {
		// 
		authorMapper.insertAuthor(author);
	}

	@Override
	public Author readAuthor(String authorId) {
		// 
		return authorMapper.selectAuthor(authorId);
	}

	@Override
	public List<Author> readAuthorsByName(String name) {
		// 
		return authorMapper.selectAuthorsByName(name);
	}
	
	@Override
	public List<Author> readAuthorsByIds(String ... authorIds) {
		// 
		return authorMapper.selectAuthorsByIds(authorIds);
	}

	@Override
	public void updateAuthor(Author author) {
		// 
		authorMapper.updateAuthor(author);
	}

	@Override
	public void deleteAuthor(String authorId) {
		// 
		authorMapper.deleteAuthor(authorId);
	}

}
