package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * 工具类
 * @author oracleOAEC
 *
 */
public class BaseDao {

//	private String driver="oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private String username = "student";
//	private String pwd = "orcl";
	Connection conn = null;
//	private static DataSource dataSource=null;
//	static{
//		dataSource=new ComboPooledDataSource("oracle");
//	}

	/**
	 * 连接数据库
	 * @return conn  连接对象
	 */
	public Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource val = (DataSource)context.lookup("java:comp/env/news1");
			conn = val.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn	连接对象
	 * @param ps	执行命令对象
	 * @param rs	结果集对象
	 */
	public void closeAll(Connection conn,PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
