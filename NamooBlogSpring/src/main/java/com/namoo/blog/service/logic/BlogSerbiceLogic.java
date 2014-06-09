package com.namoo.blog.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.namoo.blog.dao.BlogDao;
import com.namoo.blog.dao.PostDao;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.Post;
import com.namoo.blog.service.facade.BlogService;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

@Service
@Transactional  //실행중에 예외가 발생하면 rollback처리된다!
//transaction : 한번에 처리되는 단위! 모든 과정이 다 되면 sesseion에 commit()을 한번 한다!
public class BlogSerbiceLogic implements BlogService {
	//
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private PostDao postDao;
	
	@Override
	public Blog getBlog(int blogId) {
		//
		Blog blog = blogDao.readBlog(blogId);
		return blog;
	}

	@Override
	public Page<Post> getPosts(int blogId, PageInfo pageInfo) {
		//
		return postDao.readAllPosts(blogId, pageInfo);
	}

	@Override
	public Post getPost(int postId) {
		//
		return postDao.readPost(postId);
	}

	@Override
	public int registerBlog(Blog blog) {
		//
		int blogNo = blogDao.createBlog(blog); //추가된 blog가 만들어져 있으면 안됨
//		
//		//어떠한 사정으로 인해 예외가 발생함
//		String a = null;
//		a.toString();
		
		return blogNo;
	}
}
