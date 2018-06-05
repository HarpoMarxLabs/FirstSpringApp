package com.harpo.firstproject.module.security.dao;

import java.util.List;
import javax.sql.DataSource;

import com.harpo.firstproject.module.security.model.User;

/**
 * 
 * @author harpo
 * User class interface.
 */
public interface UserDAO {
	   /** 
	      * This is the method to be used to initialise
	      * database resources ie. connection.
	   */
	   public void setDataSource(DataSource ds);
	   
	   /** 
	      * This is the method to be used to list down
	      * all the records from the Student table.
	   */
	   public List<User> listUsers();
	   
	   public boolean deleteUser(User user);
	   public User updateUser(User user);
	   public User insertUser(String name, int age);
	}