package com.namoo.blog.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.domain.Author;

public class AuthorDaoTest2 extends AbstractDbUnitTest{
	//
	private AuthorDao dao;
	
	@Override
	protected String getDatasetXml() {
		//
		return "com/namoo/blog/dao/AuthorDaoTest2_dataset.xml";
	}
	
	@Before
	public void setUp() throws Exception {
		//
		super.setup();
		
		dao = new AuthorDaoImpl();
	}

	@Test
	public void testCreateAuthor() {
		//
		Author author = new Author("test", "testName", "testEmail@a.com", "qwer");
		dao.createAuthor(author);
		
		//assertion
		author = dao.readAuthor("test");
		assertThat(author.getEmail(), is("testEmail@a.com"));
		assertThat(author.getName(), is("testName"));
		assertThat(author.getPassword(), is("qwer"));
		
	}

	@Test
	public void testReadAuthor() {
		//
		Author author = dao.readAuthor("ekdgml");
		
		//assertion
		assertThat("박상희", is(author.getName()));
		assertThat("ekdgml@naver.com", is(author.getEmail()));
		assertThat("asdf", is(author.getPassword()));
	}

	@Test
	public void testUpdateAuthor() {
		//
		Author author = dao.readAuthor("ekdgml");
		author.setEmail("ekdgml@a.com");
		author.setPassword("qwer");
		dao.updateAuthor(author);
		
		//assertion
		author = dao.readAuthor("ekdgml");
		assertThat(author.getEmail(), is("ekdgml@a.com"));
		assertThat(author.getPassword(), is("qwer"));
	}

	@Test
	public void testDeleteAuthor() {
		//
		dao.deleteAuthor("ekdgml");
		
		//assertion
		assertNull(dao.readAuthor("ekdgml"));
	}

	@Test
	public void testReadAuthorsByName() {
		//
		List<Author> authors = dao.readAuthorsByName("박");
		
		//assertion
		assertThat(authors.size(), is(1));
		assertThat(authors.get(0).getEmail(), is("ekdgml@naver.com"));
		assertThat(authors.get(0).getName(), is("박상희"));
		assertThat(authors.get(0).getPassword(), is("asdf"));
	}

	@Test
	public void testReadAuthorsByIds() {
		//
		List<Author> authors = dao.readAuthorsByIds("ekdgml", "wntjd");
		
		//assertion
		assertThat(authors.size(), is(2));
		assertThat(authors.get(0).getName(), is("박상희"));
		assertThat(authors.get(0).getEmail(), is("ekdgml@naver.com"));
		assertThat(authors.get(1).getName(), is("이주성"));
		assertThat(authors.get(1).getEmail(), is("wntjd@nate.com"));
	}
}
