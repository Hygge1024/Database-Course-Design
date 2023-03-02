package Work_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class Login_Demo3 {
	public static JTextField text_name;
	public static String identityString;
	public static void main(String[] args) {
		Login_Demo3 startDemo2 = new Login_Demo3();
		startDemo2.initUi();
	}
	public void initUi() {
		//主Frame
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出
		
		/*
		 *布局 
		 */
		BorderLayout b1BorderLayout = new BorderLayout();
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,10,10);
		GridLayout g1GridLayout = new GridLayout(5,1,0,0);
 		frame.setSize(700,400);
		
		//登录界面
		JPanel getinJPanel = new JPanel();
		getinJPanel.setLayout(g1GridLayout);
		
		JPanel p1JPanel = new JPanel();
		JLabel helloJLabel = new JLabel("欢迎使用图书馆资料检索系统");
		helloJLabel.setFont(new Font("宋体",Font.PLAIN,25));
		p1JPanel.add(helloJLabel);
		
		
		//账号
		JPanel p2JPanel = new JPanel();
		p2JPanel.setLayout(f1);//上面部分
		//实例化 JLabel 标签对象
		JLabel labname = new JLabel("账号：");
		labname.setFont(new Font("宋体",Font.PLAIN,14));
		p2JPanel.add(labname);
		//实例化JTextField标签对象化
		text_name = new JTextField();
		Dimension dim1 = new Dimension(300,30);//设置除顶级容器逐渐以外其他逐渐的大小
		text_name.setPreferredSize(dim1);//设置text_name 的大小
		//将text_name 可编辑文本 添加到窗体上
		p2JPanel.add(text_name);
		
		//密码
		JPanel p3JPanel = new JPanel();
		JLabel labpass = new JLabel("密码：");
		labpass.setFont(new Font("宋体",Font.PLAIN,14));
		//将labpass添加到窗体上
		p3JPanel.add(labpass);
		//实例化JPassWordField
		JPasswordField text_passField = new JPasswordField();
		text_passField.setEchoChar('*');//回文显示 形式‘*’
		//设置大小
		text_passField.setPreferredSize(dim1);
		p3JPanel.add(text_passField);
		
		//实例化 JButton组件
		JPanel p4JPanel = new JPanel();
		JButton button1 = new JButton("登录");
		Dimension dim2 = new Dimension(100,30);
		button1.setFont(new Font("宋体",Font.PLAIN,14));
		button1.setSize(dim2);//设置按键的大小
		JButton button2 = new JButton("注册");
		button2.setFont(new Font("宋体",Font.PLAIN,14));
		button2.setSize(dim2);
				
		p4JPanel.add(button1);
		p4JPanel.add(button2);	
		
		//登录身份模块
		JPanel identityJPanel_1 = new JPanel();
		JLabel label1 = new JLabel("登录身份：");
		label1.setFont(new Font("宋体", Font.BOLD, 12));
		identityJPanel_1.add(label1);
				
		JRadioButton jRadioButton1 = new JRadioButton("学生");
		jRadioButton1.setFont(new Font("宋体", Font.BOLD, 12));
		jRadioButton1.setSelected(true);
		identityJPanel_1.add(jRadioButton1);
				
		JRadioButton jRadioButton2 = new JRadioButton("管理员");
		jRadioButton2.setFont(new Font("宋体", Font.BOLD, 12));
		identityJPanel_1.add(jRadioButton2);
		
		JPanel identityJPanel_2 = new JPanel(new BorderLayout());
		//模块组
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioButton2);
		identityJPanel_2.add(identityJPanel_1,BorderLayout.NORTH);
		//添加提示信息
		JPanel tipJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel tipJLabel = new JLabel();
		tipJLabel.setForeground(Color.red);
		tipJLabel.setFont(new Font("宋体",Font.PLAIN,13));
		tipJLabel.setText("提示信息");
		tipJPanel.add(tipJLabel);
		identityJPanel_2.add(tipJPanel,BorderLayout.CENTER);
		//添加到getinJPanel中
		getinJPanel.add(p1JPanel);
		getinJPanel.add(p2JPanel);
		getinJPanel.add(p3JPanel);
		getinJPanel.add(identityJPanel_2);
//		getinJPanel.add(tipJPanel);
		getinJPanel.add(p4JPanel);
		
		//图片展示界面
		JPanel tupianJPanel = new JPanel();
		JLabel picJLabel = new JLabel(new ImageIcon("image/temp2.jpg"));
		tupianJPanel.add(picJLabel);
		picJLabel.setBounds(0, 150, 700, 500);
		
		
//开始处理 事件了！！！！！！！！
		//给"登录"按钮添加事件
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(text_name.getText());//查看 账号
				//账号：text_name 密码：text_passField
				//主要 1、检查账号是否存在 2、密码是否对应正确
				Integer index = 0;
				if(jRadioButton1.isSelected()) {
					identityString = "Readers";
					index = 1;//学生
				}else if(jRadioButton2.isSelected()){
					identityString = "Admin";
					index = 2;//管理员
				}
				if(text_name.getText().equals("")) {
					tipJLabel.setText("账号为空，请输入您的账号");
					text_name.setText("");
					text_passField.setText("");
					System.out.println("Login_Demo3:账号为空");
				}else {
					String endpassword = Work_Model.Service.login(text_name, index);//数据库中的密码
					String yuanpassword = new String(text_passField.getPassword());//输入的密码提取
					System.out.println("Login_Demo3 | text_passField = "+yuanpassword);
					System.out.println("Login_Demo3 | endpassword = " + endpassword);
					if(endpassword.equals("null")) {
						tipJLabel.setText("用户名不存在，请重新输入");
						text_name.setText("");
						text_passField.setText("");
						System.out.println("Login_Demo3:用户名不存在");
					}
					else if(yuanpassword.equals(endpassword)) {
						Home_Demo home_Page = new Home_Demo();
						tipJLabel.setText("登录成功");
						frame.dispose();
						home_Page.show();
						System.out.println("Login_Demo3 | 登录成功！！！");
					}
					else {
						tipJLabel.setText("密码错误，请重新输入");
						text_name.setText("");
						text_passField.setText("");
						System.out.println("Login_Demo3:密码错误");
					}
				}
			}
		});
		//给"注册"按钮添加事件(现在还是 学生注册)
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				frame.setEnabled(false);//暂时还不启用
				JFrame rejisterJFrame = new JFrame("Rejister");
				rejisterJFrame.setSize(800,300);
				rejisterJFrame.setLayout(new GridLayout(1,2,0,0));
//				rejisterJFrame.setResizable(false);//不可调整大小
				/*需要注册的信息有：
				 *  rid、rname、rpassword、rsex、remail、rdepartment、
				 *  registertime、violation_status、sumbooks
				 *  对于 rid 可以用button1中Work_Model.Service.login(text_name, index);
				 *  来判断 用户名是否已经存在了
				 */ 
				//1、干页面
				JPanel rejister_1 = new JPanel();//左边信息(账号，密码1，密码2，提示信息，注册
				
				GridLayout g2GridLayout = new GridLayout(6,1,0,0);
				rejister_1.setLayout(g2GridLayout);
				Dimension rejister_1Dimension = new Dimension(200,30);
					//账号
				JPanel rejister_1_1 = new JPanel();
				JLabel nameJLabel = new JLabel("用户账号：");
				nameJLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JTextField text_id = new JTextField();
				text_id.setPreferredSize(rejister_1Dimension);
				rejister_1_1.add(nameJLabel);
				rejister_1_1.add(text_id);
				
				JPanel rejister_1_2 = new JPanel();
				JLabel password_1_JLabel = new JLabel("用户密码：");
				password_1_JLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JPasswordField password_1 = new JPasswordField();
				password_1.setPreferredSize(rejister_1Dimension);
				rejister_1_2.add(password_1_JLabel);
				rejister_1_2.add(password_1);
				
				JPanel rejister_1_3 = new JPanel();
				JLabel password_2_JLabel = new JLabel("确认密码：");
				password_2_JLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JPasswordField password_2 = new JPasswordField();
				password_2.setPreferredSize(rejister_1Dimension);
				rejister_1_3.add(password_2_JLabel);
				rejister_1_3.add(password_2);
				
				JPanel rejister_1_6 = new JPanel();
				JLabel text_name2Label = new JLabel("用户昵称：");
				text_name2Label.setFont(new Font("宋体",Font.PLAIN,14));
				JTextField text_name2 = new JTextField();
				text_name2.setPreferredSize(rejister_1Dimension);
				rejister_1_6.add(text_name2Label);
				rejister_1_6.add(text_name2);
				
				JPanel rejister_1_4 = new JPanel();
				JLabel tip2JLabel = new JLabel("提示信息");
				tip2JLabel.setForeground(Color.red);
				tip2JLabel.setFont(new Font("宋体",Font.PLAIN,13));
				rejister_1_4.add(tip2JLabel);
				
				JPanel rejister_1_5 = new JPanel();
				JButton rejisterButton_1 = new JButton("确认注册");
				rejister_1_5.add(rejisterButton_1);
				
				rejister_1.add(rejister_1_1);
				rejister_1.add(rejister_1_2);
				rejister_1.add(rejister_1_3);
				rejister_1.add(rejister_1_6);//利于排版
				rejister_1.add(rejister_1_4);
				rejister_1.add(rejister_1_5);
				
				
				
				//2、干页面——右
				JPanel rejister_2 = new JPanel();//右边信息(性别，邮件，部门，注册时间，取消
				rejister_2.setLayout(g2GridLayout);
				//性别-
				JPanel rejister_2_1 = new JPanel();
				JLabel sexJLabel = new JLabel("性别");
				sexJLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JComboBox<String> c1 = new JComboBox<String>();
				c1.setSize(rejister_1Dimension);
				c1.addItem("男");
				c1.addItem("女");
				//getSelectedItem() 用于获取当前选中的数据项
				rejister_2_1.add(sexJLabel);
				rejister_2_1.add(c1);

	
				//邮件
				JPanel rejister_2_2 = new JPanel();
				JLabel emailJLabel = new JLabel("email： ");
				emailJLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JTextField text_email = new JTextField();
				text_email.setPreferredSize(rejister_1Dimension);
				rejister_2_2.add(emailJLabel);
				rejister_2_2.add(text_email);
				
				//部门
				JPanel rejister_2_3 = new JPanel();
				JLabel departJLabel = new JLabel("部门：  ");
				departJLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JTextField text_depart = new JTextField();
				text_depart.setPreferredSize(rejister_1Dimension);
				rejister_2_3.add(departJLabel);
				rejister_2_3.add(text_depart);
				
				//注册时间
				JPanel rejister_2_4 = new JPanel();
				JLabel timeJLabel = new JLabel("注册时间");
				timeJLabel.setFont(new Font("宋体",Font.PLAIN,14));
				JTextField text_time = new JTextField();
				text_time.setPreferredSize(rejister_1Dimension);
				//创建时间
				SimpleDateFormat formatiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
//				System.out.println(date);
				text_time.setText(formatiem.format(date));
				text_time.setEditable(false);
				rejister_2_4.add(timeJLabel);
				rejister_2_4.add(text_time);
				
				//按钮
				JPanel rejister_2_5 = new JPanel();
				JButton rejisterButton_2 = new JButton("取消注册");
				rejister_2_5.add(rejisterButton_2);

				
				//身份登录
				JPanel rejister_2_6 = new JPanel();
				JLabel label12 = new JLabel("  登录身份：");
				label1.setFont(new Font("宋体", Font.BOLD, 12));
				rejister_2_6.add(label12);
						
				JRadioButton jRadioButton12 = new JRadioButton("学生");
				jRadioButton12.setFont(new Font("宋体", Font.BOLD, 12));
				jRadioButton12.setSelected(true);
				rejister_2_6.add(jRadioButton12);
						
				JRadioButton jRadioButton22 = new JRadioButton("管理员");
				jRadioButton22.setFont(new Font("宋体", Font.BOLD, 12));
				rejister_2_6.add(jRadioButton22);
				//给jRadioButton12-22 添加监听事件
				jRadioButton22.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						text_depart.setText("无需输入");
						text_depart.setFont(new Font("宋体",Font.PLAIN,14));
						text_depart.setEditable(false);
					}
				});	
				jRadioButton12.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						text_depart.setText("");
						
						text_depart.setEditable(true);
					}
				});	
				ButtonGroup buttonGroup2 = new ButtonGroup();
				buttonGroup2.add(jRadioButton12);
				buttonGroup2.add(jRadioButton22);
				
				
				rejister_2.add(rejister_2_2);
				rejister_2.add(rejister_2_3);
				rejister_2.add(rejister_2_4);
				rejister_2.add(rejister_2_1);//利于排版
				rejister_2.add(rejister_2_6);
				rejister_2.add(rejister_2_5);
				//frame面板添加内容
				rejisterJFrame.add(rejister_1);
				rejisterJFrame.add(rejister_2);
				rejisterJFrame.setLocationRelativeTo(null);//居中显示	
				rejisterJFrame.setVisible(true);
				//添加事件
				/*
				 *"确认注册"按钮：1.将 账号 与数据库中的（学生/管理员）账号对比，判断是否已存在
				 */
				rejisterButton_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String text_id_String = text_id.getText();
						String password_1_String = new String(password_1.getPassword());
						String password_2_String = new String(password_2.getPassword());
						String text_name_String = text_name2.getText();
						String email_String = text_email.getText();
						String depart_String = text_depart.getText();
						String time_String = text_time.getText();
						identityString = "";
						if(jRadioButton12.isSelected()) {
							identityString = "Readers";
						}else if(jRadioButton22.isSelected()) {
							identityString = "Admin";	
						}
						String sex_String = c1.getItemAt(0);
						//输出 结果
						System.out.println("用户账号:"+text_id_String+"、用户密码1:"+password_1_String+"用户密码2:"
								+password_2_String+"、email:"+email_String+"、部门:"+depart_String+"、时间:"+time_String
								+"、用户类型："+identityString+"、性别："+sex_String);
						int endid = Work_Model.Service.insert_id(text_id_String,identityString);//顺序可放在392行
						if(password_1_String.equals(password_2_String)){
							System.out.println("两次密码 相符"); 
							if(endid == 0) {
								System.out.println("输入id 正确");
								//开始将 信息插入到 数据库中
								if(text_id_String.equals("") || password_1_String.equals("") || password_2_String.equals("") || email_String.equals("") |
										 time_String.equals("") || identityString.equals("") || sex_String.equals("") || text_name_String.equals(""))
								{
									tip2JLabel.setText("错误：请填写完整信息");
									System.out.println("错误：请填写完整信息");
								}else {
									//执行插入语句函数
									Work_Model.Service.insert_xinxi(text_id_String,text_name_String,password_2_String,sex_String, email_String, depart_String, time_String,identityString);
									rejisterJFrame.dispose();
								}
							}
							else {
							System.out.println("输入id 已存在");
							//提示信息——“您创建的id已存在，请重新创建你的id”
							tip2JLabel.setText("您创建的id已存在，请重新创建你的id");
							text_id.setText("");
							password_1.setText("");
							password_2.setText("");
							text_email.setText("");
							text_depart.setText("");
							jRadioButton12.setSelected(true);
							}
						}else {
							System.out.println("两次密码错误");
							//提示信息——“您创建的id已存在，请重新创建你的id”
							tip2JLabel.setText("两次密码错误，请重新创建你的账号");
							text_id.setText("");
							password_1.setText("");
							password_2.setText("");
							text_email.setText("");
							text_depart.setText("");
							jRadioButton12.setSelected(true);
						}
					}
				});
				//"取消"按钮
				rejisterButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						rejisterJFrame.setEnabled(false);//将主页设置为不可编辑
						JFrame disposeFrame = new JFrame();
						disposeFrame.setSize(400,200);
						
						JPanel  p1 = new JPanel();
						p1.setLayout(new BorderLayout());
						
						JPanel p3 = new JPanel();
						p3.setSize(400, 100);
						JLabel l1 = new JLabel("你确定要退出吗？");
						l1.setFont(new Font("宋体",Font.BOLD,16));
						p3.add(l1);
						
						JPanel p2 = new JPanel();
						p2.setSize(400, 100);
						JButton b1 = new JButton("确定");
						JButton b2 = new JButton("取消");
						p2.add(b1);
						p2.add(b2);
						p1.add(p3,BorderLayout.NORTH);
						p1.add(p2,BorderLayout.SOUTH);
						disposeFrame.add(p1);
						b1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								rejisterJFrame.setEnabled(true);//将主页设置为可编辑
								rejisterJFrame.dispose();//将注册处界面关闭
								disposeFrame.dispose();
							}
						});
						b2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								rejisterJFrame.setEnabled(true);//将主页设置为可编辑
								disposeFrame.dispose();
							}
						});
						disposeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						disposeFrame.setLocationRelativeTo(null);//居中显示
						disposeFrame.setVisible(true);;
					}
				});
			}
		});		
		//添加到frame中
		frame.add(getinJPanel,BorderLayout.EAST);
		frame.add(tupianJPanel,BorderLayout.WEST);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);//居中显示
		frame.setVisible(true);
	}
}
/*
 * 界面处理好了，在解决button1和button2按钮事假
 */
