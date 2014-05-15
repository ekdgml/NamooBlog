package com.namoo.blog.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.impl.AuthorDaoImpl;
import com.namoo.blog.dao.impl.BlogDaoImpl;
import com.namoo.blog.dao.impl.PostDaoImpl;
import com.namoo.blog.domain.Author;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.Comment;
import com.namoo.blog.domain.Post;
import com.namoo.blog.domain.PostType;

public class PostDaoTest {
	//
	private AuthorDao authorDao;
	private BlogDao blogDao;
	private PostDao dao;
	
	private String authorId = "ekdgml";
	private int blogId;
	
	
	@Before
	public void setUp() throws Exception {
		//
		authorDao = new AuthorDaoImpl();
		blogDao = new BlogDaoImpl();
		
		Author author = new Author();
		author.setEmail("ekdgml@naver.com");
		author.setId(authorId);
		author.setName("박상희");
		author.setPassword("asdf");
		
		authorDao.createAuthor(author);
		
		Blog blog = new Blog();
		blog.setName("testBlog");
		blog.setOwner(author);

		blogId = blogDao.createBlog(blog);
		
		dao = new PostDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		//
		dao.deleteAllComments();
		dao.deleteAllPosts();
		blogDao.deleteBlog(blogId);
		authorDao.deleteAuthor(authorId);
	}

	@Test
	public void testCRUD() {
		//
		//create
//		Post post = new Post();
//		post.setContents("firstContents");
//		post.setSubject("firstSubject");
//		dao.createPost(blogId, post);
//		
//		//assert
//		post = dao.readPost(post.getPostId());
//		assertThat(post.getContents(), is("firstContents"));
//		assertThat(post.getSubject(), is("firstSubject"));
		
		int blogId = 1;
	      String subject = "first post";
	      String contents = "contents...";
	      
	      Post post = new Post();
	      post.setSubject(subject);
	      post.setContents(contents);
	      
	      int postId = dao.createPost(blogId, post);
	      
	      // read
	      post = dao.readPost(postId);
	      
	      assertThat(subject, is(post.getSubject()));
	      assertThat(contents, is(post.getContents()));
	      
	      // update
	      
	      // comment test
	      Comment comment = new Comment();
	      comment.setComment("comment1");
	      comment.setCommenter(new Author("hyunohkim"));
	      
	      // add comment
	      dao.createComment(postId, comment);
	      post = dao.readPost(postId);
	      
	      assertThat(1, is(post.getComments().size()));
	      assertThat("comment1", is(post.getComments().get(0).getComment()));
	      
	      // delete
	      dao.deletePost(postId);
	      assertNull(dao.readPost(postId));
		
	}
	
	@Test
	public void testCreatePost() {
		//
		Post post = new Post();
		post.setSubject("TypeHandlerTest");
		post.setContents("Yeah~~!");
		post.setType(PostType.Open);
		int postId = dao.createPost(blogId, post);
		
		post = dao.readPost(postId);
		System.out.println(post.getType());
		
	}

}
