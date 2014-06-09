package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.domain.Author;

public class AuthorDaoTest {

	private AuthorDao authorDao;

	@Before
	public void setUp() throws Exception {
		//
		authorDao = new AuthorDaoImpl();
	}

	@Test
	public void testCRUD() {
		//
		Author author = new Author("hyunohkim");
		author.setName("김현오");
		author.setEmail("hyunohkim@nextree.co.kr");
		author.setPassword("qwer1234");
		
		// create
		authorDao.createAuthor(author);
		
		// read
		author = authorDao.readAuthor("hyunohkim");
		assertThat("김현오", is(author.getName()));
		assertThat("hyunohkim@nextree.co.kr", is(author.getEmail()));
		assertThat("qwer1234", is(author.getPassword()));
		
		// update
		author.setEmail("kimgisa@nextree.co.kr");
		authorDao.updateAuthor(author);
		
		author = authorDao.readAuthor("hyunohkim");
		assertThat("kimgisa@nextree.co.kr", is(author.getEmail()));
		
		// delete
		authorDao.deleteAuthor("hyunohkim");
		assertNull(authorDao.readAuthor("hyunohkim"));
	}
	
	@Test
	public void testReadAuthorsByName() {
		//
		String name = null;
		
		List<Author> authors = authorDao.readAuthorsByName(name);
		System.out.println(authors.size());
	}
	
	@Test
	public void testUpdateAuthor() {
		//
		Author author = new Author("haroldkim");
		author.setEmail("a@a.com");
		
		authorDao.updateAuthor(author);
	}
	
	@Test
	public void testReadAuthorsByIds() {
		//
		List<Author> authors = authorDao.readAuthorsByIds("haroldkim", "abc");
		System.out.println(authors.size());
	}
	
}
