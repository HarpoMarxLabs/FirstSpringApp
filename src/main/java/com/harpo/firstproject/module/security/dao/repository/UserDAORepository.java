package com.harpo.firstproject.module.security.dao.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.harpo.firstproject.module.security.dao.UserDAO;
import com.harpo.firstproject.module.security.dao.mapper.UserMapper;
import com.harpo.firstproject.module.security.model.User;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDAORepository implements UserDAO {
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<User> listUsers() {
		String SQL = "select * from user";
		List<User> users = jdbcTemplate.query(SQL, new UserMapper());
		return users;
	}

	public User insertUser(String name, int age) {

		String sql = "INSERT INTO user (id, name, age) VALUES (?, ?, ?)";
		User transaction_user = new User();

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
				ps.setString(1, "id");
				return ps;
			}
		}, keyHolder);
		System.out.println(keyHolder.getKey());

		return transaction_user;
	}

	public User findById(int id) {

		String sql = "SELECT * FROM user WHERE id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}