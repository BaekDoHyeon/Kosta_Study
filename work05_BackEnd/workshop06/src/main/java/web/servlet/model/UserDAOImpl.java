package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {
	
	private DataSource ds;
	
	//싱글톤 
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() { 
		//Naming Service 작업을 진행...
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql"); 
			System.out.println("DataSource lookup...Success~~!!");
		} catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
		}
	}
	public static UserDAOImpl getInstance() { return dao; }

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비 연결 성공...");
		return ds.getConnection(); //Pool 에서 하나씩 꺼내오는 방식
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = getConnection();
			String query = "SELECT userId, password, name, email FROM userinfo WHERE userId = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User(userId, password, rs.getString("name"), rs.getString("email"));
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
	
		return user;
	}
}
