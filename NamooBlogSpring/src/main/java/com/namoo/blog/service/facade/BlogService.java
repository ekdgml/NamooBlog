package com.namoo.blog.service.facade;

import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.Post;
import com.namoo.blog.shared.page.Page;
import com.namoo.blog.shared.page.PageInfo;

public interface BlogService {
	//
	Blog getBlog(int blogId); 
	Page<Post> getPosts(int blogId, PageInfo pageInfo);
	Post getPost(int postId); //comment까지
	
	int registerBlog(Blog blog);
}
