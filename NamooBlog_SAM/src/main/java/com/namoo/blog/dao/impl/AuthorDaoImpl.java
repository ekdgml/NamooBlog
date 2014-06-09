package com.namoo.blog.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namoo.blog.dao.AuthorDao;
import com.namoo.blog.dao.mapper.AuthorMapper;
import com.namoo.blog.dao.mapper.SessionFactory;
import com.namoo.blog.domain.Author;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public void createAuthor(Author author) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			authorMapper.insertAuthor(author);
		} finally {
			session.close();
		}
	}

	@Override
	public Author readAuthor(String authorId) {
		// 
		SqlSession session = SessionFactory.createSession();
		Author author = null;
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			author = authorMapper.selectAuthor(authorId);
		} finally {
			session.close();
		}
		return author;
	}

	@Override
	public List<Author> readAuthorsByName(String name) {
		// 
		SqlSession session = SessionFactory.createSession();
		List<Author> authors = null;
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			authors = authorMapper.selectAuthorsByName(name);
		} finally {
			session.close();
		}
		return authors;
	}
	
	@Override
	public List<Author> readAuthorsByIds(String ... authorIds) {
		// 
		SqlSession session = SessionFactory.createSession();
		List<Author> authors = null;
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			authors = authorMapper.selectAuthorsByIds(authorIds);
		} finally {
			session.close();
		}
		return authors;
	}

	@Override
	public void updateAuthor(Author author) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			authorMapper.updateAuthor(author);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteAuthor(String authorId) {
		// 
		SqlSession session = SessionFactory.createSession();
		try {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			authorMapper.deleteAuthor(authorId);
		} finally {
			session.close();
		}		
	}

}
