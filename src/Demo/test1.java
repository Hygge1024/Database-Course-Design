package Demo;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Templates;

public class test1 {

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		String id = "tao";
		String pwd = "123456";
		String urlString = "jdbc:sqlserver://127.0.0.1:1433;databasesName=EBook";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(urlString,id,pwd);
			if(connection != null) {
				System.out.println("�������ݿ�ɹ���");
			} else {
				System.out.println("�������ݿ�ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void main(String[] args) {
		Connection connection = getConn();//�����������ݿ�ĺ���
		PreparedStatement a = null;
		ResultSet resultSet = null;
		//�༭SQL���
		String id = "C007";
//		String sql = "insert into Buy values(?,?,?)";
//		String sql = "select Bno from Buy where Bno ='ISBN978-7-5612-2123-1 '";
		String sql = "select * from Buy ";

//		try {
//			a = connection.prepareStatement(sql);
//			//�����ʺŵ�ֵ
//			a.setString(1, id);
//			a.setString(2, "sdsdsdksdsd");
//			a.setString(3, "2022-12-19");
//			//ִ��sql ���
//			a.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			a = connection.prepareStatement(sql);
			resultSet = a.executeQuery();
			while(resultSet.next()) {
				String idString = resultSet.getString(1);
				String bnString = resultSet.getString(2);
				String pdaString = resultSet.getString(3);
//				System.out.println(idString);
				System.out.println(idString + " / " + bnString + " / " + pdaString);
				}
			System.out.println("�����ݿ�����ȡ���ݳɹ���");
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
