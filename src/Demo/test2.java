package Demo;

import java.sql.*;

public class test2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ӳɹ�1");
		} catch (Exception e) {
			System.out.println("����ʧ��1");
		}
		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;" + "databaseName=EBook;" + "user=tao;"
				+ "password=123456;";
		Connection con;// �������ض����ݿ������

		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("���ӳɹ�2");
			con.close();
		} catch (SQLException e) {
			System.out.println("��������ȷ�ı���" + e);
			System.out.println("����ʧ��2");
		}
	}

}
