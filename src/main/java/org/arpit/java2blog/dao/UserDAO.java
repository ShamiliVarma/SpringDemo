package org.arpit.java2blog.dao;

import org.arpit.java2blog.bean.User;
import org.arpit.java2blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User findByUsername(String username) {

		 String selectQuery = "select USERNAME, PASSWORD, ENABLED FROM USERS WHERE ENABLED =1 AND USERNAME=?";
		 return jdbcTemplate.queryForObject(selectQuery,new Object[] {username}, new UserMapper());
	}


}