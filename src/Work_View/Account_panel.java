package Work_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Identity;
import java.security.cert.CertificateFactorySpi;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Account_panel extends JPanel{
	public  static JTextField user_nameField;
	public Account_panel() {
		// TODO Auto-generated constructor stub
		showaccount();
	}
	public void showaccount() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 700, 600);
		add(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(700,600));
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new GridLayout(6,1,0,0));
		Dimension dimension = new Dimension(700, 500);
		//panel_1——用户中心
		/*
		 * 根据 用户id来 标识用户身份信息 rid（学生） 或者 aid（管理员）
		 */
		String user_id = Login_Demo3.text_name.getText();//用户 id
		String user_identity = Login_Demo3.identityString;//用户 身份
		System.out.println("用户身份为："+user_identity);
		System.out.println("用户 id为："+user_id);//获取了 当前登录的user_id
		
		tabbedPane.addTab("用户中心", panel_1);
		tabbedPane.addTab("修改密码", panel_2);
		
		String user_name = "";
		String user_sex = "";
		String user_email = "";
		String user_depart = "";
		String user_time = "";
		
		//在panel_1 用户中心 面板中显示数据
		JLabel label_1 = new JLabel("未知");
		JLabel label_2 = new JLabel("未知");
		JLabel label_3 = new JLabel("未知");
		JLabel label_4 = new JLabel("未知");
		JLabel label_5 = new JLabel("未知");
		JLabel label_6 = new JLabel("未知");
		JLabel label_7 = new JLabel("未知");
		
		
		if(user_identity.equals("Readers")) {//学生界面
			Vector<String> find_Users_Result = new Vector<>();
			find_Users_Result = Work_Model.Service.getUsers(user_id, user_identity);
			if(find_Users_Result.isEmpty()) {
				System.out.println("错误：Account_panel.java 出错了");
			}else {
				user_name = find_Users_Result.get(0).equals("null")?"未知":find_Users_Result.get(0);
				user_sex = find_Users_Result.get(1).equals("null")?"未知":find_Users_Result.get(1);
				user_email = find_Users_Result.get(2).equals("null")?"未知":find_Users_Result.get(2);
				user_depart = find_Users_Result.get(3).equals("null")?"未知":find_Users_Result.get(3);
				user_time = find_Users_Result.get(4).equals("null")?"未知":find_Users_Result.get(4);
				System.out.println(user_name+" | "+user_sex+" | "+user_email+" | "+
						user_depart+" | "+user_time);
				label_1.setText(user_id);
				label_2.setText(user_name);
				label_3.setText(user_sex);
				label_4.setText(user_identity);
				label_5.setText(user_email);
				label_6.setText(user_time);
				label_7.setText(user_depart);
			}
		}
		if(user_identity.equals("Admin")) {//管理员界面
			Vector<String> find_Users_Result = new Vector<>();
			find_Users_Result = Work_Model.Service.getUsers(user_id, user_identity);
			if(find_Users_Result.isEmpty()) {
				System.out.println("错误：Account_panel.java 出错了");
			}else {
				user_name = find_Users_Result.get(0).equals("null")?"未知":find_Users_Result.get(0);
				user_sex = find_Users_Result.get(1).equals("null")?"未知":find_Users_Result.get(1);
				user_email = find_Users_Result.get(2).equals("null")?"未知":find_Users_Result.get(2);
//				user_depart = find_Users_Result.get(3);
//				user_time = find_Users_Result.get(4);
				System.out.println(user_name+" | "+user_sex+" | "+user_email);
				label_1.setText(user_id);
				label_2.setText(user_name);
				label_3.setText(user_sex);
				label_4.setText(user_identity);
				label_5.setText(user_email);
				label_6.setText(user_time);
				label_7.setText(user_depart);
			}
		}
		//需要显示的部分——排版显示——id,name,sex identity,email,time,depart
		Dimension finDimension = new Dimension(200,30);
		if(user_identity.equals("Readers")) {
			//panel_1 部分
			JPanel panel_1_1 = new JPanel();
			JLabel user_idJLabel = new JLabel("用户id ：");
			user_idJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_idField = new JTextField();
			user_idField.setPreferredSize(finDimension);
			user_idField.setText(user_id);
			user_idField.setEnabled(false);
			panel_1_1.add(user_idJLabel);
			panel_1_1.add(user_idField);
			
			JPanel panel_1_2 = new JPanel();
			JLabel user_nameJLabel = new JLabel("用户昵称：");
			user_nameJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			user_nameField = new JTextField();
			user_nameField.setPreferredSize(finDimension);
			user_nameField.setText(user_name);
			user_nameField.setEnabled(false);
			panel_1_2.add(user_nameJLabel);
			panel_1_2.add(user_nameField);
			
			JPanel panel_1_3 = new JPanel();
			JLabel user_sexJLabel = new JLabel("用户性别：");
			user_sexJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_sexField = new JTextField();
			user_sexField.setPreferredSize(finDimension);
			user_sexField.setText(user_sex);
			user_sexField.setEnabled(false);
			panel_1_3.add(user_sexJLabel);
			panel_1_3.add(user_sexField);
			
			JPanel panel_1_4 = new JPanel();
			JLabel user_identityJLabel = new JLabel("用户身份：");
			user_identityJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_identityField = new JTextField();
			user_identityField.setPreferredSize(finDimension);
			user_identityField.setText(user_identity);
			user_identityField.setEnabled(false);
			panel_1_4.add(user_identityJLabel);
			panel_1_4.add(user_identityField);
			
			JPanel panel_1_5 = new JPanel();
			JLabel user_emailJLabel = new JLabel("用户邮箱：");
			user_emailJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_emailField = new JTextField();
			user_emailField.setPreferredSize(finDimension);
			user_emailField.setText(user_email);
			user_emailField.setEnabled(false);
			panel_1_5.add(user_emailJLabel);
			panel_1_5.add(user_emailField);
			
			JPanel panel_1_6 = new JPanel();
			JLabel user_timeJLabel = new JLabel("注册时间：");
			user_timeJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_timeField = new JTextField();
			user_timeField.setPreferredSize(finDimension);
			user_timeField.setText(user_time);
			user_timeField.setEnabled(false);
			panel_1_6.add(user_timeJLabel);
			panel_1_6.add(user_timeField);
			
			JPanel panel_1_7 = new JPanel();
			JLabel user_departJLabel = new JLabel("用户学院：");
			user_departJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_deparField = new JTextField();
			user_deparField.setPreferredSize(finDimension);
			user_deparField.setText(user_depart);
			user_deparField.setEnabled(false);
			panel_1_7.add(user_departJLabel);
			panel_1_7.add(user_deparField);
			
			JPanel panel_1_lelf = new JPanel(new GridLayout(4,1,0,0));
			JPanel panel_1_right = new JPanel(new GridLayout(4,1,0,0));
			panel_1_lelf.add(panel_1_1);
			panel_1_lelf.add(panel_1_2);
			panel_1_lelf.add(panel_1_3);
			panel_1_lelf.add(panel_1_4);
			
			panel_1_right.add(panel_1_5);
			panel_1_right.add(panel_1_6);
			panel_1_right.add(panel_1_7);
			
			
			panel_1.add(panel_1_lelf,BorderLayout.WEST);
			panel_1.add(panel_1_right,BorderLayout.EAST);
		}else if(user_identity.equals("Admin")) {
			JPanel panel_1_1 = new JPanel();
			JLabel user_idJLabel = new JLabel("用户id ：");
			user_idJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_idField = new JTextField();
			user_idField.setPreferredSize(finDimension);
			user_idField.setText(user_id);
			user_idField.setEnabled(false);
			panel_1_1.add(user_idJLabel);
			panel_1_1.add(user_idField);
			
			JPanel panel_1_2 = new JPanel();
			JLabel user_nameJLabel = new JLabel("用户昵称：");
			user_nameJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			user_nameField = new JTextField();
			user_nameField.setPreferredSize(finDimension);
			user_nameField.setText(user_name);
			user_nameField.setEnabled(false);
			panel_1_2.add(user_nameJLabel);
			panel_1_2.add(user_nameField);
			
			JPanel panel_1_3 = new JPanel();
			JLabel user_sexJLabel = new JLabel("用户性别：");
			user_sexJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_sexField = new JTextField();
			user_sexField.setPreferredSize(finDimension);
			user_sexField.setText(user_sex);
			user_sexField.setEnabled(false);
			panel_1_3.add(user_sexJLabel);
			panel_1_3.add(user_sexField);
			
			JPanel panel_1_4 = new JPanel();
			JLabel user_identityJLabel = new JLabel("用户身份：");
			user_identityJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_identityField = new JTextField();
			user_identityField.setPreferredSize(finDimension);
			user_identityField.setText(user_identity);
			user_identityField.setEnabled(false);
			panel_1_4.add(user_identityJLabel);
			panel_1_4.add(user_identityField);
			
			JPanel panel_1_5 = new JPanel();
			JLabel user_emailJLabel = new JLabel("用户邮箱：");
			user_emailJLabel.setFont(new Font("宋体",Font.PLAIN,14));
			JTextField user_emailField = new JTextField();
			user_emailField.setPreferredSize(finDimension);
			user_emailField.setText(user_email);
			user_emailField.setEnabled(false);
			panel_1_5.add(user_emailJLabel);
			panel_1_5.add(user_emailField);
			
			
			
			JPanel panel_1_lelf = new JPanel(new GridLayout(4,1,0,0));
			JPanel panel_1_right = new JPanel(new GridLayout(4,1,0,0));
			panel_1_lelf.add(panel_1_1);
			panel_1_lelf.add(panel_1_2);
			panel_1_lelf.add(panel_1_3);
			
			
			panel_1_right.add(panel_1_4);
			panel_1_right.add(panel_1_5);
			panel_1.add(panel_1_lelf,BorderLayout.WEST);
			panel_1.add(panel_1_right,BorderLayout.EAST);
		}
		//第二部分——panel_2 修改密码
		/*
		 * 原密码：
		 * 修改密码：
		 * 再次输入：
		 * 确认（提交到数据库中）/取消（清除）
		 */
		JPanel panel_2_1 = new JPanel();
		JLabel password_1 = new JLabel("原始密码：");
		password_1.setFont(new Font("宋体",Font.PLAIN,14));
		JPasswordField password_1Field = new JPasswordField();
		password_1Field.setPreferredSize(finDimension);
		panel_2_1.add(password_1);	
		panel_2_1.add(password_1Field);	
		
		JPanel panel_2_2 = new JPanel();
		JLabel password_2 = new JLabel("修改密码：");
		password_2.setFont(new Font("宋体",Font.PLAIN,14));
		JPasswordField password_2Field = new JPasswordField();
		password_2Field.setPreferredSize(finDimension);
		panel_2_2.add(password_2);	
		panel_2_2.add(password_2Field);	
		
		JPanel panel_2_3 = new JPanel();
		JLabel password_3 = new JLabel("修改密码：");
		password_2.setFont(new Font("宋体",Font.PLAIN,14));
		JPasswordField password_3Field = new JPasswordField();
		password_3Field.setPreferredSize(finDimension);
		panel_2_3.add(password_3);	
		panel_2_3.add(password_3Field);	
		
		JPanel panel_2_4 = new JPanel();
		JButton button_1 = new JButton("确认修改");
		JButton button_2 = new JButton("取消");
		panel_2_4.add(button_1);
		panel_2_4.add(button_2);
		
		JPanel panel_2_5 = new JPanel();
		JLabel tips = new JLabel("提示信息");
		tips.setForeground(Color.red);
		tips.setFont(new Font("宋体",Font.PLAIN,14));
		panel_2_5.add(tips);
		
		panel_2.add(panel_2_1);
		panel_2.add(panel_2_2);
		panel_2.add(panel_2_3);
		panel_2.add(panel_2_5);
		panel_2.add(panel_2_4);
		//添加事件：
		button_1.addActionListener(new ActionListener() {//确定
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String p_w_1String = new String(password_1Field.getPassword());
				String p_w_2String = new String(password_2Field.getPassword());
				String p_w_3String = new String(password_3Field.getPassword());
				String oldp_wString = Work_Model.Service.find_password(user_id,user_identity);
				if(!oldp_wString.equals(p_w_1String)) {
					tips.setText("原始密码错误，请重新输入");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}
				else if(!p_w_2String.equals(p_w_3String)) {
					tips.setText("重置密码有误，请重新输入");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}else {
					tips.setText("修改密码成功");
					Work_Model.Service.update_password(user_id, p_w_3String, user_identity);
					System.out.println("修改密码成功");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}
			}
		});
		
		button_2.addActionListener(new ActionListener() {//取消
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				password_1Field.setText("");
				password_2Field.setText("");
				password_3Field.setText("");
				tips.setText("操作已取消");
			}
		});
		this.add(tabbedPane);
	}
	public static void main(String[] args) {
		JFrame  frame = new JFrame("账号管理 测试 Frame");
		frame.setSize(900,400);;
		frame.add(new Account_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
