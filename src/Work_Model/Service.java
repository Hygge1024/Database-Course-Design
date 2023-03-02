package Work_Model;

import java.sql.Date;
import java.util.Vector;

import javax.swing.JTextField;

public class Service {
	private static DataOperator dataOperator = new DataOperator();
	
	//对用户要登录的一系列操作，返回用户名（学号）,参数 userName:用户名，password:密码
//	public static long login(String userName,String password) {
//		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序
//		dataOperator.connect();//连接数据库
//		
//		return dataOperator
//	}
	//登录
	public static String login(JTextField text_name,int index) {
		//此方法还需要 完善的
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序
		dataOperator.connect();//连接数据库
		String endpassword = "";
		endpassword = dataOperator.loginQuery(text_name,index);
		System.out.println("Service:应用登录成功");
		System.out.println("Service | endpassword = " + endpassword);
		return endpassword;
	}
	//注册——id
	public static int insert_id(String text_id_String,String identityString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:insert_id方法没问题");
		return dataOperator.insert_id_Query(text_id_String,identityString);
	}
	//注册——信息
	public static void insert_xinxi(String text_id_String,String text_name_String,String password_2_String,String sex_String
			,String email_String,String depart_String,String time_String,String identityString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:insert_xinxi_Query方法没问题");
		dataOperator.insert_xinxi_Update(text_id_String,text_name_String,password_2_String,sex_String,email_String,depart_String,time_String,identityString);
	}
	//查询——图书
	public static Vector<String> getBooks(String textinputString,int isselect){
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:getBooks方法没问题");
		return dataOperator.find_booksQuery(textinputString,isselect);
	}
	public static Vector<String> get_B_R(String ridString){
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:get_B_R方法没问题");
		return dataOperator.find_B_RQuery(ridString);
	}
	public static Vector<String> get_B_A(String ridString){
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:get_B_A方法没问题");
		return dataOperator.find_B_AQuery(ridString);
	}
	//查询——用户信息
	public static Vector<String> getUsers(String user_id,String user_identity){
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:getUsers方法没问题");
		return dataOperator.find_UsersQuery(user_id,user_identity);
	}
	//查询密码
	public static String find_password(String user_id,String identityString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:getUsers方法没问题");
		return dataOperator.find_passwordQuery(user_id,identityString);
	}
	//更新密码
	public static void update_password(String user_id,String password,String identity) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_password方法没问题");
		dataOperator.update_passwordUpdate(user_id,password,identity);
	}
	//查询 图书bISBN
	public static String find_bISBN(String bISBNString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_password方法没问题");
		return dataOperator.find_bISBNQuery(bISBNString);
	}
	//查找图书——根据bISBN，bname是否正确
	public static String find_bname(String bISBNString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:find_bname方法没问题");
		return dataOperator.find_bnameQuery(bISBNString);
	}
	//查询 图书书本
	public static int find_Books(String bISBNString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:find_Books方法没问题");
		return dataOperator.find_numbersQuery(bISBNString);
	}
	
	//更新图书——剩余
	public static void update_numbers(String bISBNString,int bleave) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_numbers方法没问题");
		dataOperator.update_numbersUpdate(bISBNString,bleave);
	}
	
	//插入 图书信息
	public static void update_books(String bISBNString,String bnameString,String bauthorString,
			String bhouseString,int bleave,String btimeString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_books方法没问题");
		dataOperator.update_BooksUpdate(bISBNString,bnameString,bauthorString,bhouseString,bleave,btimeString);
	}
	//删除 书本
	public static void delete_books(String bISBNString,String bnameString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:delete_books方法没问题");
		dataOperator.delete_booksDelete(bISBNString,bnameString);
	}
	//插入 借书记录
	public static void update_jie(String bISBNString,String useridString,String bnameString,String usernameString,String startTimeString,String identityString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_jie方法没问题");
		dataOperator.update_jie_Update(bISBNString,useridString,bnameString,usernameString,startTimeString,identityString);
	}
	//更新 借书记录——endtime
	public static void update_endtime(String endtimeString,String bISBNString,String user_idString,String identityString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_endtime方法没问题");
		dataOperator.update_endtimeUpdate(endtimeString,bISBNString,user_idString,identityString);
	}
	//添加B_A
	public static void updateB_A(String bISBN,String aidString,String addtimeString) {
		dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
		dataOperator.connect();//连接数据库
		System.out.println("Service:应用登录成功");
		System.out.println("Service:update_updateB_A方法没问题");
		dataOperator.updateB_AUpdate(bISBN,aidString,addtimeString);
	}
	//添加B_A 删除时间
		public static void updateB_A2(String bISBN,String aidString,String endtimeString) {
			dataOperator.loadDatabaseDriver();//加载数据库的JDBC驱动程序_____当最结束时，只需要在 login时连接数据库，其与时候就不需要再次连接数据库
			dataOperator.connect();//连接数据库
			System.out.println("Service:应用登录成功");
			System.out.println("Service:updateB_A2方法没问题");
			dataOperator.updateB_A2Update(bISBN,aidString,endtimeString);
		}
	//退出应用
	public static void quit() {
		dataOperator.disconnect();
		System.out.println("Service:应用退出成功");
	}
	
}
