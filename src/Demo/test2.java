package Demo;

import java.sql.*;

public class test2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("连接成功1");
		} catch (Exception e) {
			System.out.println("连接失败1");
		}
		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;" + "databaseName=EBook;" + "user=tao;"
				+ "password=123456;";
		Connection con;// 处理与特定数据库的连接

		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("连接成功2");
			con.close();
		} catch (SQLException e) {
			System.out.println("请输入正确的表名" + e);
			System.out.println("连接失败2");
		}
	}

}
