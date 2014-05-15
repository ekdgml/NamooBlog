package com.namoo.blog.dao.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	//
	private static SessionFactory instance = new SessionFactory();
	
	private SqlSessionFactory sqlSessionFactory;
	
	private SessionFactory() {
		//
		//SqlSesscionFactory를 생성한다.
		Reader reader;
		try {
			String resource = "mybatis-config.xml";
			reader = Resources .getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static SessionFactory getInstance() {
		//
		return instance;
	}
	
	//------------------------------------------------------------------------
	
	public static SqlSession createSession() {
		//
		return instance.sqlSessionFactory.openSession(true);
	}
}
