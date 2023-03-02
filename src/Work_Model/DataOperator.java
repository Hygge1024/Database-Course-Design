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
	Connection con = null;//与特定数据库的连接（回话）。在连接上下文中执行sql语句并返回结果
	private PreparedStatement pstmt;//表示预编译的sql语句的对象。使数据库操作效率较高效
	private String sql;//存储SQL语句
	public void loadDatabaseDriver() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("DataOperator:数据库驱动加载失败！");
			System.out.println(e);
		}
	}
	
	//连接数据库
	public void connect() {
		String id = "LibraryAdmin";
		String pwd = "123456";
		String urlString = "jdbc:sqlserver://127.0.0.1:1433;databasesName=Library2";
		try {
			con = DriverManager.getConnection(urlString,id,pwd);
			if(con != null) {
				System.out.println("DataOperator:数据库连接成功！");
			} else {
				System.out.println("DataOperator:数据库连接失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//登录
	public String loginQuery(JTextField text_name,int index){
		String endpasswordString = "";
		HashMap<String, String> loginInfo = new  HashMap<>();
		if(index == 1) {//查询对象是 学生
			sql = "select * from Readers where rid = ?";
		}else if(index == 2) {//查询对象是 管理员
			sql = "select * from Admin where aid = ?";
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text_name.getText());//将其转换成 字符串String
//			System.out.println(text_name+"输入");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("循环前：正常");
			endpasswordString = "null";
			while(rs.next()) {
				if(index == 1) {
					endpasswordString = rs.getString(3).trim();
					System.out.println("DataOperator | 查询学生的密码是："+endpasswordString);
				}else if(index == 2) {
					endpasswordString = rs.getString(2).trim();
					System.out.println("DataOperator | 查询管理员的密码是："+endpasswordString);
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endpasswordString;
	}
	//注册——id
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
			System.out.println("测试点");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("循环前：正常");
			while(rs.next()) {
				end = 1;
				System.out.println("DataOperator | 该id已被使用");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return end;
	}
	//注册——插入信息
	public void insert_xinxi_Update(String text_id_String,String text_name_String,String password_2_String,String sex_String
			,String email_String,String depart_String,String time_String,String identityString) {
		try {
			if(identityString.equals("Readers")) {
				sql = "insert into Readers(rid,rname,rpassword,rsex,remail,rdepartment,registertime) VALUES(?,?,?,?,?,?,?)";//插入的是学生信息
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, text_id_String);
				pstmt.setString(2, text_name_String);
				pstmt.setString(3,password_2_String);
				pstmt.setString(4, sex_String);
				pstmt.setString(5,email_String);
				pstmt.setString(6, depart_String);
				pstmt.setString(7,time_String);
				int a = pstmt.executeUpdate();
				System.out.println("Readers:插入信息成功");
			}else if(identityString.equals("Admin")) {
				sql = "insert into Admin(aid,apassword,aname,asex,aemail) VALUES(?,?,?,?,?)";//插入的是管理员信息
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, text_id_String);
				pstmt.setString(2, password_2_String);
				pstmt.setString(3,text_name_String);
				pstmt.setString(4, sex_String);
				pstmt.setString(5,email_String);
				int a = pstmt.executeUpdate();
				System.out.println("Admin:插入信息成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//信息查询——图书信息
	public Vector<String> find_booksQuery(String textinputString,int isselect){
		int index = 0;
		System.out.println("DataOperator:信息查询:数据操作 第一步没问题");
		Vector<String> find_booksInfo = new Vector<>();
		
		if(isselect == 1) {
			sql = "select * from  Books where bISBN = ?";
			System.out.println("DataOperator:此次查询方式是：bISBN");
		}else if(isselect == 2) {
			sql = "select * from  Books where bname = ?";
			System.out.println("DataOperator:此次查询方式是：书名");
		}else if(isselect == 3) {
			sql = "select * from  Books";
			System.out.println("DataOperator:此次查询方式是：全部");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			if(isselect != 3) {
				pstmt.setString(1, textinputString);
			}
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			System.out.println("DataOperator:循环开始前：正常");
			while(rs.next()) {
				index = (i-1) * 7;
				find_booksInfo.add(index,i+"");
				System.out.println("DataOperator:正常读取数据：" + i++);
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
			System.out.println("DataOperator:查询数据库出错了");
			e.printStackTrace();
		}
		System.out.println("find_booksInfo的大小为："+find_booksInfo.size());
		return find_booksInfo;
	}
	
	//信息查询——借阅信息
	public Vector<String> find_B_RQuery(String ridString){
		int index = 0;
		System.out.println("DataOperator:信息查询:数据操作 第一步没问题");
		Vector<String> find_booksInfo = new Vector<>();
		sql = "select * from  B_R where rid = ?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ridString);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			System.out.println("DataOperator:循环开始前：正常");
			while(rs.next()) {
				index = (i-1) * 7;
				find_booksInfo.add(index,i+"");
				System.out.println("DataOperator:正常读取数据：" + i++);
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
			System.out.println("DataOperator:查询数据库出错了");
			e.printStackTrace();
		}
		System.out.println("find_booksInfo的大小为："+find_booksInfo.size());
		return find_booksInfo;
	}
	//信息查询——管理信息
		public Vector<String> find_B_AQuery(String ridString){
			int index = 0;
			System.out.println("DataOperator:信息查询:数据操作 第一步没问题");
			Vector<String> find_booksInfo = new Vector<>();

			sql = "select * from  B_A where aid = ?";
				
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ridString);
				ResultSet rs = pstmt.executeQuery();
				int i = 1;
				System.out.println("DataOperator:循环开始前：正常");
				while(rs.next()) {
					index = (i-1) * 5;
					find_booksInfo.add(index,i+"");
					System.out.println("DataOperator:正常读取数据：" + i++);
					find_booksInfo.add(rs.getString(1).trim());
					find_booksInfo.add(rs.getString(2).trim());
					find_booksInfo.add(rs.getDate(3)+"");
					find_booksInfo.add(rs.getDate(4)+"");
//					System.out.println(find_booksInfo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DataOperator:查询数据库出错了");
				e.printStackTrace();
			}
			System.out.println("find_booksInfo的大小为："+find_booksInfo.size());
			return find_booksInfo;
		}
	//查询信息——用户信息
	public Vector<String> find_UsersQuery(String user_id,String user_identity){
		System.out.println("DataOperator:信息查询——用户信息，数据操作 第一步没问题");
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
			System.out.println("DataOperator:循环开始前：正常");
			System.out.println(rs);
			while(rs.next()) {
				if(index == 1) {
					System.out.println("Readers");//对于 null值 .trim()会报错的
					find_UsersInfo.add(rs.getString(2).trim());//rname
					find_UsersInfo.add(rs.getString(4).trim());//rsex
//					find_UsersInfo.add(rs.getString(5).trim());//remail
					//允许 null 时，需要提出来解决
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
					
//					find_UsersInfo.add(rs.getString(5).isEmpty()?"":rs.getString(5).trim());//remail ——解决null 情况trim()报错
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
//					find_UsersInfo.add(rs.getString(5).trim());//remail 允许空值
//					find_UsersInfo.add(rs.getString(6).trim());//rdepartment 这些是 不需要的
//					find_UsersInfo.add(rs.getString(7).trim());//registertime
				}
//				System.out.println(find_UsersInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("find_UsersInfo的大小为："+find_UsersInfo.size());
		return find_UsersInfo;
	}
	//查询密码
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
			System.out.println("DataOperator:查找正常");
			while(rs.next()) {
				passwordend = rs.getString(1).trim();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwordend;
	}
	//修改密码
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
			System.out.println("DataOperator: 修改密码成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查找图书——bISBN是否存在
	public String find_bISBNQuery(String bISBNString) {
		String bISBN = "";
		sql = "select bISBN from Books where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:查找正常");
			while(rs.next()) {
				bISBN = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bISBN;
	}
	//查找图书——根据bISBN，bname是否正确
		public String find_bnameQuery(String bISBNString) {
			String bname = "";
			sql = "select bname from Books where bISBN = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bISBNString);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("DataOperator:查找正常");
				while(rs.next()) {
					bname = rs.getString(1).trim();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bname;
		}
	//查找图书——剩余
	public int find_numbersQuery(String bISBNString) {
		int leave = 0;
		sql = "select bleave from Books where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("DataOperator:查找正常");
			while(rs.next()) {
				leave = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leave;
	}
	//更新图书——剩余
	public void update_numbersUpdate(String bISBNString,int bleave) {
		sql = "update Books set bleave = ? where bISBN = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bleave);
			pstmt.setString(2, bISBNString);
			int a = pstmt.executeUpdate();
			System.out.println("Books:更新 剩余数成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//添加图书
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
			System.out.println("Books:插入信息成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//删除 书本
	public void delete_booksDelete(String bISBNString,String bnameString) {
		sql = "DELETE FROM Books where bISBN = ? and bname = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			pstmt.setString(2, bnameString);
			
			int a = pstmt.executeUpdate();
			System.out.println("Books:删除信息成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新 借书记录
	public void update_jie_Update(String bISBNString,String useridString,String bnameString,String usernameString,String startTimeString,String identityString) {
		if(identityString.equals("Readers")) {
			sql = "insert into B_R(bISBN,rid,bname,rname,starttime) values(?,?,?,?,?)";
		}else if(identityString.equals("Admin")) {
			sql = "insert into B_A(bISBN,aid,bname,a‘name,addtime) values(?,?,?,?,?)";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBNString);
			pstmt.setString(2, useridString);
			pstmt.setString(3, bnameString);
			pstmt.setString(4, usernameString);
			pstmt.setString(5, startTimeString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:借书成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新 借书记录——endtime
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
			System.out.println("DataOperator:还书成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//添加B_A
	public void updateB_AUpdate(String bISBN,String aidString,String addtimeString) {
		sql = "insert into B_A(bISBN,aid,addtime) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bISBN);
			pstmt.setString(2, aidString);
			pstmt.setString(3, addtimeString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:添加 B_A成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//添加B_A 删除时间
	public void updateB_A2Update(String bISBN,String aidString,String endtimeString) {
		sql = "update B_A set deletetime = ? where bISBN = ? and aid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, endtimeString);
			pstmt.setString(2, bISBN);
			pstmt.setString(3, aidString);
			int a = pstmt.executeUpdate();
			System.out.println("DataOperator:添加B_A 删除时间成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//关闭数据库的连接
	public void disconnect() {
		try {
			if (con != null) {
				con.close();
				System.out.println("DataOperator:数据库关闭成功！");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
