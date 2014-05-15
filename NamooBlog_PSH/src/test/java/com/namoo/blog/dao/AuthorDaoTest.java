package com.namoo.blog.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.domain.Author;

public class AuthorDaoTest {
	//
	private AuthorDao dao;
	
	@Before
	public void setUp() throws Exception {
		//
		dao = new AuthorDaoImpl();
	}
	@After
	public void tearDown() throws Exception {
		//
		dao.deleteAuthor("ekdgml");
		dao.deleteAuthor("wntjd");
	}

	@Test
	public void testCRUD() {
		//
		//create
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId("ekdgml");
		author.setName("박상희");
		author.setPassword("asdf");
		dao.createAuthor(author);
		
		//assert
		author = dao.readAuthor("ekdgml");
		assertNotNull(author);
		assertThat(author.getEmail(), is("ekdgml@naver.com"));
		assertThat(author.getName(), is("박상희"));
		assertThat(author.getPassword(), is("asdf"));
		
		//update
		author.setEmail("ekdgml@test.com");
		author.setName("상희");
		author.setPassword("aaaa");
		dao.updateAuthor(author);
		
		//assert
		author = dao.readAuthor("ekdgml");
		assertThat(author.getEmail(), is("ekdgml@test.com"));
		assertThat(author.getName(), is("상희"));
		assertThat(author.getPassword(), is("aaaa"));
	}
	
	@Test
	public void testReadAuthorsByName() {
		//
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId("ekdgml");
		author.setName("박상희");
		author.setPassword("asdf");
		dao.createAuthor(author);
		
		String name = null;
		
		List<Author> authors = dao.readAuthorsByName(name);
		System.out.println(authors.size());
	}
	
	@Test
	public void testUpdateAuthor() {
		//
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId("ekdgml");
		author.setName("박상희");
		author.setPassword("asdf");
		dao.createAuthor(author);
		
		author = new Author("ekdgml");
		author.setPassword("aaaa");
		dao.updateAuthor(author);
		author = dao.readAuthor("ekdgml");
		System.out.println(author.getPassword());
	}
	
	@Test
	public void testReadAuthorsByIds() {
		//
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId("ekdgml");
		author.setName("박상희");
		author.setPassword("asdf");
		dao.createAuthor(author);
		
		Author author2 = new Author();
		author2.setEmail("wntjd@nate.com");
		author2.setId("wntjd");
		author2.setName("이주성");
		author2.setPassword("aaaa");
		dao.createAuthor(author2);
		
		List<Author> authors = dao.readAuthorsByIds("ekdgml", "wntjd");
		System.out.println(authors.size());
	}
}
