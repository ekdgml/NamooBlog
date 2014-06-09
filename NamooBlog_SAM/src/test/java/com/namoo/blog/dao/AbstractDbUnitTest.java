package com.namoo.blog.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.dbunit.DefaultDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.namoo.blog.dao.mapper.SessionFactory;

public abstract class AbstractDbUnitTest {
	//
	private IDatabaseTester dbTester;
	
	@BeforeClass //test가 실행될 때 딱 한번만 실행
	public static void initializaeDatabase() throws IOException, SQLException {
		//
		SessionFactory.overrideEnvironment("unit-test");
		
		Reader reader = Resources.getResourceAsReader("schema.sql");
		Connection connection = SessionFactory.createSession().getConnection();
		RunScript.execute(connection, reader);
	}
	
	@Before
	public void setup() throws Exception {
		//
		dbTester = createDatabaseTester();
		dbTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		
		dbTester.onSetup();
	}
	
	private IDatabaseTester createDatabaseTester() throws Exception {
		//
		Connection connection = SessionFactory.createSession().getConnection();
		IDatabaseConnection dbConnection = new DatabaseConnection(connection);
		
		InputStream in = Resources.getResourceAsStream(getDatasetXml());
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(in);
		
		dbTester = new DefaultDatabaseTester(dbConnection);
		dbTester.setDataSet(dataSet);
		
		return dbTester;
	}

	@After
	public void tearDown() throws Exception {
		//
		IDatabaseTester dbTester = createDatabaseTester();
		
		dbTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
		dbTester.onTearDown();
	}
	
	protected abstract String getDatasetXml();
}
