package com.namoo.blog.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

public class PostDaoTest extends AbstractDbUnitTest{
	//
	private static final String DATASET_XML = "/com/namoo/blog/dao/PostDaoTest_dataset.xml";
	
	@Autowired
	private PostDao dao;
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreatePost() {
		//
		Post post = new Post();
		post.setContents("testContents");
		post.setSubject("testSubject");
		int postId = dao.createPost(1, post);
		
		//assertion
		post = dao.readPost(postId);
		assertThat(post.getContents(), is("testContents"));
		assertThat(post.getSubject(), is("testSubject"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadPost() {
		//
		Post post = dao.readPost(1);
		
		//assertion
		assertThat(post.getContents(), is("firstPostContents"));
		assertThat(post.getSubject(), is("firstPost"));
		assertThat(post.getComments().size(), is(3));
		assertThat(post.getComments().get(0).getCommenter().getName(), is("김현오"));
		assertThat(post.getComments().get(0).getComment(), is("첫번째코멘트"));
		
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllPosts() {   
		//
		PageInfo pageInfo = new PageInfo(2, 5);
		Page<Post> page = dao.readAllPosts(1, pageInfo);
		
		List<Post> posts = page.getResults();
		//assertion
		assertThat(posts.size(), is(1));
		assertThat(page.getTotalCount(), is(6));
		assertFalse(page.isNextPage());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdatePost() {
		//
		Post post = dao.readPost(1);
		post.setContents("testPost");
		post.setSubject("testSubject");
		dao.updatePost(post);
		
		//assertion
		post = dao.readPost(1);
		assertThat(post.getContents(), is("testPost"));
		assertThat(post.getSubject(), is("testSubject"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeletePost() {
		//
		dao.deletePost(1);
		
		//assertion
		assertNull(dao.readPost(1));
		//TODO
		//assertThat(dao.readAllPosts(1).size(), is(1));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateComment() {
		//
		Comment comment = new Comment();
		comment.setComment("testComment");
		comment.setCommenter(new Author("gdohong"));
		dao.createComment(1, comment);
		
		//assertion
		List<Comment> comments = dao.readPost(1).getComments();
		assertThat(comments.size(), is(4));
		assertThat(comments.get(3).getCommenter().getId(), is("gdohong"));
		assertThat(comments.get(3).getCommenter().getName(), is("홍길동"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteComment() {
		//
		dao.deleteComment(1);
		
		//assertion
		assertThat(dao.readPost(1).getComments().size(), is(2));
	}

}