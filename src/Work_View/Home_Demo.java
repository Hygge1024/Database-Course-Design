package Work_View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import mssql.googlecode.concurrentlinkedhashmap.EntryWeigher;

public class Home_Demo {
	public static void main(String[] args) {
		Home_Demo home1Demo = new Home_Demo();
		home1Demo.show();
	}
	public void show() {
		JFrame frame = new JFrame("图书馆资料检索系统v1.0 by 软件2102刘涛");
		frame.setSize(800,600);
		frame.setFont(new Font("宋体",Font.PLAIN,14));
		
		//面板一：功能块
		JPanel workJPanel = new JPanel();
		workJPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		workJPanel.setBorder(BorderFactory.createTitledBorder("功能"));
		workJPanel.setLayout(new BoxLayout(workJPanel, BoxLayout.X_AXIS));
		
		JButton button1 = new JButton("信息查询");
		JButton button2 = new JButton("借阅管理");
		JButton button3 = new JButton("图书管理");
		JButton button4 = new JButton("账号管理");
		JButton button5 = new JButton("退出系统");
		
		workJPanel.add(button1);
		workJPanel.add(button2);
		workJPanel.add(button3);
		workJPanel.add(button4);
		workJPanel.add(button5);
		
		//面板二：内容块
		JPanel contentJPanel = new JPanel();
		contentJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		contentJPanel.setBorder(BorderFactory.createTitledBorder("系统模块设计"));
		CardLayout cardLayout = new CardLayout();
		contentJPanel.setLayout(cardLayout);//contentJPanel 设置为 卡片布局
		
		Find_panel find_panel = new Find_panel();
		contentJPanel.add("信息查询",find_panel);
		
		Borrow_panel borrow_panel = new Borrow_panel();
		contentJPanel.add("借阅管理",borrow_panel);
		
		BookM_panel bookM_panel = new BookM_panel();
		contentJPanel.add("图书管理",bookM_panel);
		
		Account_panel account_panel = new Account_panel();
		contentJPanel.add("账号管理",account_panel);
		
		//面板三：时间模块
		JPanel noteJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		JLabel timeJLabel = new JLabel(formattime.format(date));
		noteJPanel.add(timeJLabel);
		
		//添加事件
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String actionCommand = e.getActionCommand();
				switch (actionCommand) {
				case "信息查询":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "借阅管理":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "图书管理":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "账号管理":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				default:
					break;
				}
			}
		};
		button1.addActionListener(buttonListener);
		button2.addActionListener(buttonListener);
		button3.addActionListener(buttonListener);
		button4.addActionListener(buttonListener);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);//将主页设置为不可编辑
				// TODO Auto-generated method stub
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
				
				//为退出系统 b1 ， b2 添加事件
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						disposeFrame.dispose();
						Work_Model.Service.quit();
						frame.dispose();
						System.exit(0);//彻底关闭程序——》暴力结束！！！
					}
				});
				b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame.setEnabled(true);//将主页设置为可编辑
						disposeFrame.dispose();
					}
				});
				disposeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				disposeFrame.setLocationRelativeTo(null);//居中显示
				disposeFrame.setVisible(true);;
			}
		});
		String user_identity = Login_Demo3.identityString;//用户 身份
		//如何 identity == "Admin" "借阅管理"设置为不可编辑
		if(user_identity.equals("Admin")) {
			button2.setEnabled(false);
		}
		//如何 identity == "Readers" "图书管理"设置为不可编辑
		if(user_identity.equals("Readers")) {
			button3.setEnabled(false);
		}
		//添加板块一、二到frame中
		frame.add(workJPanel,BorderLayout.NORTH);
		frame.add(contentJPanel,BorderLayout.CENTER);
		frame.add(noteJPanel,BorderLayout.SOUTH);
		
		frame.setLocationRelativeTo(null);//显示在屏幕中央
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
