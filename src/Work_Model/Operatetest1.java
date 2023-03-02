package Work_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operatetest1 {

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		String id = "LibraryAdmin";
		String pwd = "123456";
		String urlString = "jdbc:sqlserver://127.0.0.1:1433;databasesName=Library2";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(urlString,id,pwd);
			if(connection != null) {
				System.out.println("连接数据库成功！");
			} else {
				System.out.println("连接数据库失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void main(String[] args) {
		Connection connection = getConn();//调用连接数据库的函数
		PreparedStatement a = null;
		ResultSet resultSet = null;
		//编辑SQL语句
		String id = "b002";
		String sql = "select * from  Books where bISBN = 'b001'";
		try {
			a = connection.prepareStatement(sql);//预处理sql语句
			resultSet = a.executeQuery();//查询得到结果
			while(resultSet.next()) {
				String idString = resultSet.getString(1);
				String bnString = resultSet.getString(2);
				String pdaString = resultSet.getString(3);
//				System.out.println(idString);
				System.out.println(idString + " / " + bnString + " / " + pdaString);
				}
			System.out.println("从数据库中提取数据成功！");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
