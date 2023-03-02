package Work_Model;

import java.net.ConnectException;
import java.nio.channels.SelectableChannel;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextField;

public class DataOperator {
	Connection con = null;//���ض����ݿ�����ӣ��ػ�������������������ִ��sql��䲢���ؽ��
	private PreparedStatement pstmt;//��ʾԤ�����sql���Ķ���ʹ���ݿ����Ч�ʽϸ�Ч
	private String sql;//�洢SQL���
	public void loadDatabaseDriver() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("DataOperator:���ݿ���������ʧ�ܣ�");
			System.out.println(e);
		}
	}
	
	//�������ݿ�
	public void connect() {
		String id = "LibraryAdmin";
		String pwd = "123456";
		String urlString = "jdbc:sqlserver://127.0.0.1:1433;databasesName=Library2";
		try {
			con = DriverManager.getConnection(urlString,id,pwd);
			if(con != null) {
				System.out.println("DataOperator:���ݿ����ӳɹ���");
			} else {
				System.out.println("DataOperator:���ݿ�����ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��¼
	public String loginQuery(JTextField text_name,int index){
		String endpasswordString = "";
		HashMap<String, String> loginInfo = new  HashMap<>();
		if(index == 1) {//��ѯ������ ѧ��
			sql = "select * from Readers where rid = ?";
		}else if(index == 2) {//��ѯ������ ����Ա
			sql = "select * from Admin where aid = ?";
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text_name.getText());//����ת���� �ַ���String
//			System.out.println(text_name+"����");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ѭ��ǰ������");
			endpasswordString = "null";
			while(rs.next()) {
				if(index == 1) {
					endpasswordString = rs.getString(3).trim();
					System.out.println("DataOperator | ��ѯѧ���������ǣ�"+endpasswordString);
				}else if(index == 2) {
					endpasswordString = rs.getString(2).trim();
					System.out.println("DataOperator | ��ѯ����Ա�������ǣ�"+endpasswordString);
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endpasswordString;
	}
	//ע�ᡪ��id
	public int insert_id_Query(String text_id_String,String identityString) {
		int end = 0;
		System.out.println("DataOperator | " + identityString);
		if(identityString.equals("Readers")) {
			sql = "select * from Readers where rid = ?";
		}else if(identityString.equals("Admin")) {
			sql = "select * from Admin where aid = ?";
		}
		try {
			
			pstmt = con.prepareStatement(sql);
			System.out.println("text_id_String:"+text_id_String);
			pstmt.setString(1,text_id_String);
			System.out.println("���Ե�");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ѭ��ǰ������");
			while(rs.next()) {
				end = 1;
				System.out.println("DataOperator | ��id�ѱ�ʹ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return end;
	}
	//ע�ᡪ��������Ϣ
	public void insert_xinxi_Update(String text_id_String,String text_name_String,String password_2_String,String sex_String
			,String email_String,String depart_String,String time_String,String identityString) {
		try {
			if(identityString.equals("Readers")) {
				sql = "insert into Readers(rid,rname,rpassword,rsex,remail,rdepartment,registertime) VALUES(?,?,?,?,?,?,?)";//�������ѧ����Ϣ
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, text_id_String);
				pstmt.setString(2, text_name_String);
				pstmt.setString(3,password_2_String);
				pstmt.setString(4, sex_String);
				pstmt.setString(5,email_String);
				pstmt.setString(6, depart_String);
				pstmt.setString(7,time_String);
				int a = pstmt.executeUpdate();
				System.out.println("Readers:������Ϣ�ɹ�");
			}else if(identityString.equals("Admin")) {
				sql = "insert into Admin(aid,apassword,aname,asex,aemail) VALUES(?,?,?,?,?)";//������ǹ���Ա��Ϣ
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, text_id_String);
				pstmt.setString(2, password_2_String);
				pstmt.setString(3,text_name_String);
				pstmt.setString(4, sex_String);
				pstmt.setString(5,email_String);
				int a = pstmt.executeUpdate();
				System.out.println("Admin:������Ϣ�ɹ�");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//��Ϣ��ѯ����ͼ����Ϣ
	public Vector<String> find_booksQuery(String textinputString,int isselect){
		int index = 0;
		System.out.println("DataOperator:��Ϣ��ѯ:���ݲ��� ��һ��û����");
		Vector<String> find_booksInfo = new Vector<>();
		
		if(isselect == 1) {
			sql = "select * from  Books where bISBN = ?";
			System.out.println("DataOperator:�˴β�ѯ��ʽ�ǣ�bISBN");
		}else if(isselect == 2) {
			sql = "select * from  Books where bname = ?";
			System.out.println("DataOperator:�˴β�ѯ��ʽ�ǣ�����");
		}else if(isselect == 3) {
			sql = "select * from  Books";
			System.out.println("DataOperator:�˴β�ѯ��ʽ�ǣ�ȫ��");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			if(isselect != 3) {
				pstmt.setString(1, textinputString);
			}
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			System.out.println("DataOperator:ѭ����ʼǰ������");
			while(rs.next()) {
				index = (i-1) * 7;
				find_booksInfo.add(index,i+"");
				System.out.println("DataOperator:������ȡ���ݣ�" + i++);
				find_booksInfo.add(rs.getString(1).trim());
				find_booksInfo.add(rs.getString(2).trim());
				find_booksInfo.add(rs.getString(3).trim());
				find_booksInfo.add(rs.getString(4).trim());
				find_booksInfo.add(rs.getInt(5)+"");
				find_booksInfo.add(rs.getDate(6)+"");
//				System.out.println(find_booksInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DataOperator:��ѯ���ݿ������");
			e.printStackTrace();
		}
		System.out.println("find_booksInfo�Ĵ�СΪ��"+find_booksInfo.size());
		return find_booksInfo;
	}
	
	//��Ϣ��ѯ����������Ϣ
	public Vector<String> find_B_RQuery(String ridString){
		int index = 0;
		System.out.println("DataOperator:��Ϣ��ѯ:���ݲ��� ��һ��û����");
		Vector<String> find_booksInfo = new Vector<>();
		sql = "select * from  B_R where rid = ?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ridString);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			System.out.println("DataOperator:ѭ����ʼǰ������");
			while(rs.next()) {
				index = (i-1) * 7;
				find_booksInfo.add(index,i+"");
				System.out.println("DataOperator:������ȡ���ݣ�" + i++);
				find_booksInfo.add(rs.getString(1).trim());
				find_booksInfo.add(rs.getString(2).trim());
				find_booksInfo.add(rs.getString(3).trim());
				find_booksInfo.add(rs.getString(4).trim());
				find_booksInfo.add(rs.getDate(5)+"");
				find_booksInfo.add(rs.getDate(6)+"");
//				System.out.println(find_booksInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DataOperator:��ѯ���ݿ������");
			e.printStackTrace();
		}
		System.out.println("find_booksInfo�Ĵ�СΪ��"+find_booksInfo.size());
		return find_booksInfo;
	}
	//��Ϣ��ѯ����������Ϣ
		public Vector<String> find_B_AQuery(String ridString){
			int index = 0;
			System.out.println("DataOperator:��Ϣ��ѯ:���ݲ��� ��һ��û����");
			Vector<String> find_booksInfo = new Vector<>();

			sql = "select * from  B_A where aid = ?";
				
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ridString);
				ResultSet rs = pstmt.executeQuery();
				int i = 1;
				System.out.println("DataOperator:ѭ����ʼǰ������");
				while(rs.next()) {
					index = (i-1) * 5;
					find_booksInfo.add(index,i+"");
					System.out.println("DataOperator:������ȡ���ݣ�" + i++);
					find_booksInfo.add(rs.getString(1).trim());
					find_booksInfo.add(rs.getString(2).trim());
					find_booksInfo.add(rs.getDate(3)+"");
					find_booksInfo.add(rs.getDate(4)+"");
//					System.out.println(find_booksInfo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DataOperator:��ѯ���ݿ������");
				e.printStackTrace();
			}
			System.out.println("find_booksInfo�Ĵ�СΪ��"+find_booksInfo.size());
			return find_booksInfo;
		}
	//��ѯ��Ϣ�����û���Ϣ
	public Vector<String> find_UsersQuery(String user_id,String user_identity){
		System.out.println("DataOperator:��Ϣ��ѯ�����û���Ϣ�����ݲ��� ��һ��û����");
		Vector<String> find_UsersInfo = new Vector<>();
		int index = 0;
		if(user_identity.equals("Readers")) {
			sql = "select * from Readers where rid = ?";
			index = 1;
		}else if(user_identity.equals("Admin")) {
			sql = "select * from Admin where aid = ?";
			index = 2;
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:ѭ����ʼǰ������");
			System.out.println(rs);
			while(rs.next()) {
				if(index == 1) {
					System.out.println("Readers");//���� nullֵ .trim()�ᱨ���
					find_UsersInfo.add(rs.getString(2).trim());//rname
					find_UsersInfo.add(rs.getString(4).trim());//rsex
//					find_UsersInfo.add(rs.getString(5).trim());//remail
					//���� null ʱ����Ҫ��������
					String temp_remail = rs.getString(5)+"";
					if(temp_remail.equals("")) {
						find_UsersInfo.add("");
					}else {
						find_UsersInfo.add(temp_remail.trim());
					}
					String temp_department = rs.getString(6)+"";
					if(temp_department.equals("")) {
						find_UsersInfo.add("");
					}else {
						find_UsersInfo.add(temp_department.trim());
					}
					
//					find_UsersInfo.add(rs.getString(5).isEmpty()?"":rs.getString(5).trim());//remail �������null ���trim()����
//					find_UsersInfo.add(rs.getString(6).isEmpty()?"":rs.getString(6).trim());//rdepartment
					find_UsersInfo.add(rs.getString(7).trim()+"");//registertime
				}
				else if(index == 2) {
					System.out.println("Admin");
					find_UsersInfo.add(rs.getString(3).trim());//rname
					find_UsersInfo.add(rs.getString(4).trim());//rsex
					String temp_remail = rs.getString(5)+"";
					if(temp_remail.equals("")) {
						find_UsersInfo.add("");
					}else {
						find_UsersInfo.add(temp_remail.trim());
					}
//					find_UsersInfo.add(rs.getString(5).trim());//remail �����ֵ
//					find_UsersInfo.add(rs.getString(6).trim());//rdepartment ��Щ�� ����Ҫ��
//					find_UsersInfo.add(rs.getString(7).trim());//registertime
				}
//				System.out.println(find_UsersInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("find_UsersInfo�Ĵ�СΪ��"+find_UsersInfo.size());
		return find_UsersInfo;
	}
	//��ѯ����
	public String find_passwordQuery(String user_id,String identityString) {
		String passwordend ="";
		if(identityString.equals("Readers")) {
			sql = "select rpassword from Readers where rid = ?";
		}else if(identityString.equals("Admin")) {
			sql = "select apassword from Admin where aid = ?";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:��������");
			while(rs.next()) {
				passwordend = rs.getString(1).trim();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwordend;
	}
	//�޸�����
	public void update_passwordUpdate(String user_id,String password,String identity) {
		if(identity.equals("Readers")) {
			sql = "update Readers set rpassword = ? where rid = ?";
		}else if(identity.equals("Admin")) {
			sql = "update Admin set apassword = ? where aid = ?";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, user_id);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator: �޸�����ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ͼ�顪��bISBN�Ƿ����
	public String find_bISBNQuery(String bISBNString) {
		String bISBN = "";
		sql = "select bISBN from Books where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:��������");
			while(rs.next()) {
				bISBN = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bISBN;
	}
	//����ͼ�顪������bISBN��bname�Ƿ���ȷ
		public String find_bnameQuery(String bISBNString) {
			String bname = "";
			sql = "select bname from Books where bISBN = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bISBNString);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("DataOperator:��������");
				while(rs.next()) {
					bname = rs.getString(1).trim();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bname;
		}
	//����ͼ�顪��ʣ��
	public int find_numbersQuery(String bISBNString) {
		int leave = 0;
		sql = "select bleave from Books where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:��������");
			while(rs.next()) {
				leave = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leave;
	}
	//����ͼ�顪��ʣ��
	public void update_numbersUpdate(String bISBNString,int bleave) {
		sql = "update Books set bleave = ? where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bleave);
			pstmt.setString(2, bISBNString);
			int a = pstmt.executeUpdate();
			System.out.println("Books:���� ʣ�����ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���ͼ��
	public void update_BooksUpdate(String bISBNString,String bnameString,String bauthorString,
			String bhouseString,int bleave,String btimeString) {
		sql = "insert into Books(bISBN,bname,bauthor,bhouse,bleave,btime) values(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			pstmt.setString(2, bnameString);
			pstmt.setString(3,bauthorString);
			pstmt.setString(4, bhouseString);
			pstmt.setInt(5,bleave);
			pstmt.setString(6,btimeString);
			int a = pstmt.executeUpdate();
			System.out.println("Books:������Ϣ�ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//ɾ�� �鱾
	public void delete_booksDelete(String bISBNString,String bnameString) {
		sql = "DELETE FROM Books where bISBN = ? and bname = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			pstmt.setString(2, bnameString);
			
			int a = pstmt.executeUpdate();
			System.out.println("Books:ɾ����Ϣ�ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���� �����¼
	public void update_jie_Update(String bISBNString,String useridString,String bnameString,String usernameString,String startTimeString,String identityString) {
		if(identityString.equals("Readers")) {
			sql = "insert into B_R(bISBN,rid,bname,rname,starttime) values(?,?,?,?,?)";
		}else if(identityString.equals("Admin")) {
			sql = "insert into B_A(bISBN,aid,bname,a��name,addtime) values(?,?,?,?,?)";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			pstmt.setString(2, useridString);
			pstmt.setString(3, bnameString);
			pstmt.setString(4, usernameString);
			pstmt.setString(5, startTimeString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:����ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���� �����¼����endtime
	public void update_endtimeUpdate(String endtimeString,String bISBNString,String user_idString,String identityString) {
		if(identityString.equals("Readers")) {
			sql = "update B_R set endtime = ? where bISBN = ? and rid = ?";
		}else if(identityString.equals("Admin")) {
			sql = "update B_A set deletetime = ? where bISBN = ? and aid = ?";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, endtimeString);
			pstmt.setString(2, bISBNString);
			pstmt.setString(3, user_idString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:����ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���B_A
	public void updateB_AUpdate(String bISBN,String aidString,String addtimeString) {
		sql = "insert into B_A(bISBN,aid,addtime) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBN);
			pstmt.setString(2, aidString);
			pstmt.setString(3, addtimeString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:��� B_A�ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���B_A ɾ��ʱ��
	public void updateB_A2Update(String bISBN,String aidString,String endtimeString) {
		sql = "update B_A set deletetime = ? where bISBN = ? and aid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, endtimeString);
			pstmt.setString(2, bISBN);
			pstmt.setString(3, aidString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:���B_A ɾ��ʱ��ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�ر����ݿ������
	public void disconnect() {
		try {
			if (con != null) {
				con.close();
				System.out.println("DataOperator:���ݿ�رճɹ���");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
