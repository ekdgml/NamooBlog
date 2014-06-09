package com.namoo.blog.dao.mapper;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	//
	private static SessionFactory instance;
	
	private SqlSessionFactory sqlSessionFactory;
	
	private SessionFactory() {
		//
		initialize("development");
	}
	
	private SessionFactory(String environment) {
		//
		initialize(environment);
	}
	
	//--------------------------------------------------------------------------
	
	private void initialize(String environment) {
		//
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//--------------------------------------------------------------------------
	
	public static SqlSession createSession() {
		//
		if (instance == null) {
			instance = new SessionFactory();
		}
		
		return instance.sqlSessionFactory.openSession(true);
	}
	
	/**
	 * override singleton instance for unit test
	 * 
	 * @param environment
	 */
	public static void overrideEnvironment(String environment) {
		//
		instance = new SessionFactory(environment);
	}
}
