package com.namoo.blog.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.namoo.blog.domain.PostType;

public class PostTypeToStringTypeHandler implements TypeHandler<PostType>{

	@Override
	public void setParameter(PreparedStatement ps, int i, PostType parameter,
			JdbcType jdbcType) throws SQLException {
		//
		ps.setString(i, parameter.code());
	}

	@Override
	public PostType getResult(ResultSet rs, String columnName) throws SQLException {
		// 
		String code = rs.getString(columnName);
		return PostType.findBy(code);
	}

	@Override
	public PostType getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		String code = rs.getString(columnIndex);
		return PostType.findBy(code);
	}

	@Override
	public PostType getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// 
		return null;
	}

}
