package Work_Model;

import java.sql.Date;
import java.util.Vector;

import javax.swing.JTextField;

public class Service {
	private static DataOperator dataOperator = new DataOperator();
	
	//���û�Ҫ��¼��һϵ�в����������û�����ѧ�ţ�,���� userName:�û�����password:����
//	public static long login(String userName,String password) {
//		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������
//		dataOperator.connect();//�������ݿ�
//		
//		return dataOperator
//	}
	//��¼
	public static String login(JTextField text_name,int index) {
		//�˷�������Ҫ ���Ƶ�
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������
		dataOperator.connect();//�������ݿ�
		String endpassword = "";
		endpassword = dataOperator.loginQuery(text_name,index);
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service | endpassword = " + endpassword);
		return endpassword;
	}
	//ע�ᡪ��id
	public static int insert_id(String text_id_String,String identityString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:insert_id����û����");
		return dataOperator.insert_id_Query(text_id_String,identityString);
	}
	//ע�ᡪ����Ϣ
	public static void insert_xinxi(String text_id_String,String text_name_String,String password_2_String,String sex_String
			,String email_String,String depart_String,String time_String,String identityString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:insert_xinxi_Query����û����");
		dataOperator.insert_xinxi_Update(text_id_String,text_name_String,password_2_String,sex_String,email_String,depart_String,time_String,identityString);
	}
	//��ѯ����ͼ��
	public static Vector<String> getBooks(String textinputString,int isselect){
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:getBooks����û����");
		return dataOperator.find_booksQuery(textinputString,isselect);
	}
	public static Vector<String> get_B_R(String ridString){
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:get_B_R����û����");
		return dataOperator.find_B_RQuery(ridString);
	}
	public static Vector<String> get_B_A(String ridString){
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:get_B_A����û����");
		return dataOperator.find_B_AQuery(ridString);
	}
	//��ѯ�����û���Ϣ
	public static Vector<String> getUsers(String user_id,String user_identity){
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:getUsers����û����");
		return dataOperator.find_UsersQuery(user_id,user_identity);
	}
	//��ѯ����
	public static String find_password(String user_id,String identityString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:getUsers����û����");
		return dataOperator.find_passwordQuery(user_id,identityString);
	}
	//��������
	public static void update_password(String user_id,String password,String identity) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_password����û����");
		dataOperator.update_passwordUpdate(user_id,password,identity);
	}
	//��ѯ ͼ��bISBN
	public static String find_bISBN(String bISBNString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_password����û����");
		return dataOperator.find_bISBNQuery(bISBNString);
	}
	//����ͼ�顪������bISBN��bname�Ƿ���ȷ
	public static String find_bname(String bISBNString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:find_bname����û����");
		return dataOperator.find_bnameQuery(bISBNString);
	}
	//��ѯ ͼ���鱾
	public static int find_Books(String bISBNString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:find_Books����û����");
		return dataOperator.find_numbersQuery(bISBNString);
	}
	
	//����ͼ�顪��ʣ��
	public static void update_numbers(String bISBNString,int bleave) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_numbers����û����");
		dataOperator.update_numbersUpdate(bISBNString,bleave);
	}
	
	//���� ͼ����Ϣ
	public static void update_books(String bISBNString,String bnameString,String bauthorString,
			String bhouseString,int bleave,String btimeString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_books����û����");
		dataOperator.update_BooksUpdate(bISBNString,bnameString,bauthorString,bhouseString,bleave,btimeString);
	}
	//ɾ�� �鱾
	public static void delete_books(String bISBNString,String bnameString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:delete_books����û����");
		dataOperator.delete_booksDelete(bISBNString,bnameString);
	}
	//���� �����¼
	public static void update_jie(String bISBNString,String useridString,String bnameString,String usernameString,String startTimeString,String identityString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_jie����û����");
		dataOperator.update_jie_Update(bISBNString,useridString,bnameString,usernameString,startTimeString,identityString);
	}
	//���� �����¼����endtime
	public static void update_endtime(String endtimeString,String bISBNString,String user_idString,String identityString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_endtime����û����");
		dataOperator.update_endtimeUpdate(endtimeString,bISBNString,user_idString,identityString);
	}
	//���B_A
	public static void updateB_A(String bISBN,String aidString,String addtimeString) {
		dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
		dataOperator.connect();//�������ݿ�
		System.out.println("Service:Ӧ�õ�¼�ɹ�");
		System.out.println("Service:update_updateB_A����û����");
		dataOperator.updateB_AUpdate(bISBN,aidString,addtimeString);
	}
	//���B_A ɾ��ʱ��
		public static void updateB_A2(String bISBN,String aidString,String endtimeString) {
			dataOperator.loadDatabaseDriver();//�������ݿ��JDBC��������_____�������ʱ��ֻ��Ҫ�� loginʱ�������ݿ⣬����ʱ��Ͳ���Ҫ�ٴ��������ݿ�
			dataOperator.connect();//�������ݿ�
			System.out.println("Service:Ӧ�õ�¼�ɹ�");
			System.out.println("Service:updateB_A2����û����");
			dataOperator.updateB_A2Update(bISBN,aidString,endtimeString);
		}
	//�˳�Ӧ��
	public static void quit() {
		dataOperator.disconnect();
		System.out.println("Service:Ӧ���˳��ɹ�");
	}
	
}
