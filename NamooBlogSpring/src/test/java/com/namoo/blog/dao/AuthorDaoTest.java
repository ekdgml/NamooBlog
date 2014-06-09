package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.domain.Author;

public class AuthorDaoTest extends AbstractDbUnitTest {
	//
	private static final String DATASET_XML = "/com/namoo/blog/dao/AuthorDaoTest_dataset.xml";
	
	@Autowired
	private AuthorDao authorDao;
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateAuthor() {
		//
		Author author = new Author("test");
		author.setName("추가");
		author.setEmail("add@test.com");
		author.setPassword("add1234");
		
		authorDao.createAuthor(author);
		
		author = authorDao.readAuthor("test");
		assertThat("추가", is(author.getName()));
		assertThat("add@test.com", is(author.getEmail()));
		assertThat("add1234", is(author.getPassword()));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAuthor() {
		//
		Author author = authorDao.readAuthor("hyunohkim");
		
		// assertion
		assertThat("김현오", is(author.getName()));
		assertThat("hyunohkim@a.co.kr", is(author.getEmail()));
		assertThat("1234", is(author.getPassword()));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdateAuthor() {
		//
		Author author = authorDao.readAuthor("hyunohkim");
		author.setName("김기사");

		// update
		authorDao.updateAuthor(author);
		
		author = authorDao.readAuthor("hyunohkim");
		assertThat("김기사", is(author.getName()));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteAuthor() {
		//
		authorDao.deleteAuthor("hyunohkim");
		
		assertNull(authorDao.readAuthor("hyunohkim"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAuthorsByName() {
		//
		List<Author> authors = authorDao.readAuthorsByName("김현오");
		assertThat(1, is(authors.size()));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAuthorsByIds() {
		//
		List<Author> authors = authorDao.readAuthorsByIds("hyunohkim", "haroldkim");
		assertThat(2, is(authors.size()));
	}

}
