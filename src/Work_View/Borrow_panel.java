package Work_View;
import java.awt.Button;
import java.awt.Color;
//借阅管理
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Identity;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.accessibility.AccessibleAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicRootPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument.BranchElement;

public class Borrow_panel extends JPanel{
	public Borrow_panel() {
		// TODO Auto-generated constructor stub
		showborrow();
	}
	public void showborrow() {
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 700, 600);
		add(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(700,600));
		JPanel panel_1 = new JPanel();//借书
		JPanel panel_2 = new JPanel();//还书
		JPanel panel_3 = new JPanel();//借书记录
		Dimension dimension = new Dimension(700, 500);
		Dimension broDimension = new Dimension(200,30);
		//开始装修 panel_1 借书 界面
		/*
		 * 1.将数据添加到 B_R 表中
		 * 2.从Books表中将bleave-1 
		 */
		JPanel panel_1_sum = new JPanel();
		panel_1_sum.setLayout(new GridLayout(4,1,0,0));
		JPanel panel_1_1 = new JPanel();
		JLabel bISBN_1 = new JLabel("bISBN：");
		bISBN_1.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bISBN_1Field = new JTextField();
		bISBN_1Field.setPreferredSize(broDimension);
		panel_1_1.add(bISBN_1);	
		panel_1_1.add(bISBN_1Field);	
		
		JPanel panel_1_2 = new JPanel();
		JLabel bname_1 = new JLabel("bname：");
		bname_1.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bname_1Field = new JTextField();
		bname_1Field.setPreferredSize(broDimension);
		panel_1_2.add(bname_1);	
		panel_1_2.add(bname_1Field);
		
		JPanel panel_1_3 = new JPanel();
		JLabel tip_1 = new JLabel("提示信息");
		tip_1.setForeground(Color.red);
		tip_1.setFont(new Font("宋体",Font.PLAIN,14));
		panel_1_3.add(tip_1);
		
		JPanel panel_1_4 = new JPanel();
		JButton button_1_1 = new JButton("确认借阅");
		JButton button_1_2 = new JButton("取消");
		panel_1_4.add(button_1_1);
		panel_1_4.add(button_1_2);
		
		panel_1_sum.add(panel_1_1);
		panel_1_sum.add(panel_1_2);
		panel_1_sum.add(panel_1_3);
		panel_1_sum.add(panel_1_4);
		panel_1.add(panel_1_sum);
		//——1添加事件
		button_1_1.addActionListener(new ActionListener() {//借书
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_id = Login_Demo3.text_name.getText();//用户 id
				String user_identity = Login_Demo3.identityString;//用户 身份
				System.out.println("获取user_name 有误");
				String user_name = Account_panel.user_nameField.getText();
				System.out.println("user_name"+user_name);
				// TODO Auto-generated method stub
				String bISBNString = bISBN_1Field.getText();
				//user_id
				String bnameString = bname_1Field.getText();
				//user_name
				SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
				String startTimeString = formattime.format(date);
				int bleaveInt = Work_Model.Service.find_Books(bISBNString);//剩余数量
				String ifinString = Work_Model.Service.find_bISBN(bISBNString);//判断 bISBN 是否存在
				String bnameString2 = Work_Model.Service.find_bname(bISBNString);
				System.out.println("bnameString2"+bnameString2);
				if(bISBNString.equals("") || bnameString.equals("")) {
					tip_1.setText("输入信息不完整，请输入完整信息");
					System.out.println("输入信息不完整，请输入完整信息");
				}
				else if(ifinString.equals("")) {
					tip_1.setText("输入 bISBN 错误，请重新输入");
					System.out.println("输入 bISBN 错误，请重新输入");
				}
				else if(!bnameString.equals(bnameString2)) {
					tip_1.setText("输入bname 错误，请重新输入");
					System.out.println("输入bname 错误，请重新输入");
					bname_1Field.setText("");
				}
				else if(bleaveInt <= 0) {
					tip_1.setText("数量不足，请通知管理员及时补充");
					System.out.println("数量不足，请通知管理员及时补充");
				}
				else {
					
					bleaveInt--;
					Work_Model.Service.update_numbers(bISBNString, bleaveInt);
					Work_Model.Service.update_jie(bISBNString, user_id, bnameString, user_name, startTimeString,user_identity);
					tip_1.setText("借阅成功");
					bname_1Field.setText("");
					bISBN_1Field.setText("");
				}
				
				
			}
		});
		
		button_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_1.setText("操作已取消");
				bname_1Field.setText("");
				bISBN_1Field.setText("");
				
			}
		});
		
		//开始装修 panel_2 还书 界面
		/*
		 * 1.将数据从 B_R 表中删除
		 * 2.从Books表中将bleave +1 
		 */
		JPanel panel_2_sum = new JPanel();
		panel_2_sum.setLayout(new GridLayout(4,1,0,0));
		JPanel panel_2_1 = new JPanel();
		JLabel bISBN_2 = new JLabel("bISBN：");
		bISBN_2.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bISBN_2Field = new JTextField();
		bISBN_2Field.setPreferredSize(broDimension);
		panel_2_1.add(bISBN_2);	
		panel_2_1.add(bISBN_2Field);
		
		JPanel panel_2_2 = new JPanel();
		JLabel bname_2 = new JLabel("bname：");
		bname_2.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bname_2Field = new JTextField();
		bname_2Field.setPreferredSize(broDimension);
		panel_2_2.add(bname_2);	
		panel_2_2.add(bname_2Field);
		
		JPanel panel_2_3 = new JPanel();
		JLabel tip_2 = new JLabel("提示信息");
		tip_2.setForeground(Color.red);
		tip_2.setFont(new Font("宋体",Font.PLAIN,14));
		panel_2_3.add(tip_2);
		
		JPanel panel_2_4 = new JPanel();
		JButton button_2_1 = new JButton("确认还书");
		JButton button_2_2 = new JButton("取消");
		panel_2_4.add(button_2_1);
		panel_2_4.add(button_2_2);
		
		panel_2_sum.add(panel_2_1);
		panel_2_sum.add(panel_2_2);
		panel_2_sum.add(panel_2_3);
		panel_2_sum.add(panel_2_4);
		panel_2.add(panel_2_sum);
		
		//——2添加事件
		button_2_1.addActionListener(new ActionListener() {//还书
			/*
			 * 1.只需要在 借书记录里面将endtime 加上去就可以了
			 * 2.Books中 bleave 数量加一
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user_id = Login_Demo3.text_name.getText();//用户 id
				String user_identity = Login_Demo3.identityString;//用户 身份
				
				String bISBNString = bISBN_2Field.getText();// bISBN
				String bnameString = bname_2Field.getText();// bname
				
				String ifinString = Work_Model.Service.find_bISBN(bISBNString);//判断 bISBN 是否存在
				String bnameString2 = Work_Model.Service.find_bname(bISBNString);//判断 输入bname是否正确
				System.out.println("bnameString2"+bnameString2);
				
				SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
				String endTimeString = formattime.format(date);
				int bleaveInt = Work_Model.Service.find_Books(bISBNString);//剩余数量
				if(bISBNString.equals("") || bnameString.equals("")) {
					tip_2.setText("输入信息不完整，请输入完整信息");
					System.out.println("输入信息不完整，请输入完整信息");
				}
				else if(ifinString.equals("")) {
					tip_2.setText("输入 bISBN 错误，请重新输入");
					System.out.println("输入 bISBN 错误，请重新输入");
					bname_2Field.setText("");
					bISBN_2Field.setText("");
				}
				else if(!bnameString.equals(bnameString2)) {
					tip_2.setText("输入bname 错误，请重新输入");
					System.out.println("输入bname 错误，请重新输入");
					bname_2Field.setText("");
				}else {
					bleaveInt++;
					Work_Model.Service.update_numbers(bISBNString,bleaveInt);
					Work_Model.Service.update_endtime(endTimeString, bISBNString, user_id, user_identity);
					tip_2.setText("还书成功");
					System.out.println("还书成功");
					bname_2Field.setText("");
					bISBN_2Field.setText("");
				}
			}
		});
		button_2_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_2.setText("操作已取消");
				bname_2Field.setText("");
				bISBN_2Field.setText("");
				
			}
		});
		//开始装修 panel_3 结束记录 界面
		/*
		 * 1.从B_R中找出 rid 或 aid 等于该用户的记录，显示出来
		 */
		
		//添加显示 借阅信息的面板
		String user_id = Login_Demo3.text_name.getText();//user_id
		String user_identity = Login_Demo3.identityString;//用户 身份
		
		if(user_identity.equals("Readers")) {
			JPanel tableJPanel = new JPanel();
			JScrollPane scrollPane_1_1 = new JScrollPane();//滚动条
	//		scrollPane_1_1.setBounds(0, 148, 685, 249);
			scrollPane_1_1.setBounds(0, 10,249,685 );
			tableJPanel.add(scrollPane_1_1);
//			scrollPane_1_1.setHorizontalScrollBarPolicy(                
//	                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//			scrollPane_1_1.setVerticalScrollBarPolicy(                
//	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//	
			
			Object[] headrObjects = new Object[] {"序号","bISBN","读者id","书名","用户名","借阅时间","归还时间"};
			Object[][] numObjects = {};
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(headrObjects);
			//添加内容
			
			JTable table_1 = new JTable();
			table_1.setModel(model);
			table_1.setPreferredScrollableViewportSize(new Dimension(600,300));
			scrollPane_1_1.setViewportView(table_1);
			scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
			Vector<String> findResult = new Vector<>();
			
			findResult = Work_Model.Service.get_B_R(user_id);//最终的数据集合
			
			Integer length = findResult.size();
			System.out.println("findResult的大小为："+ length);
			if(findResult.isEmpty()) {
				System.out.println("没有检索到符合条件的图书，请您重新输入！");
				JOptionPane.showMessageDialog(null, "没有检索到符合条件的图书，请您重新输入！");
			}else {	
				//对收到的数据进行7段的处理
				Vector<String> tempStrings = new Vector<>();
				for(int i = 0; i < length; i++) {
					if(i % 7 == 0 && i != 0) {
						tempStrings.clear();
					}
					tempStrings.add(findResult.get(i));
					if(tempStrings.size() == 7) {
						//添加到 Jpanel 面板上面
						model.addRow(new Object[] {tempStrings.get(0),tempStrings.get(1),tempStrings.get(2),tempStrings.get(3),tempStrings.get(4),tempStrings.get(5),tempStrings.get(6)});
						System.out.println("测试 "+tempStrings.get(0)+":"+tempStrings);
					}
				}
			}
			panel_3.add(tableJPanel);
		}
		//最终添加
		tabbedPane.addTab("借书", panel_1);
		tabbedPane.addTab("还书", panel_2);
		tabbedPane.add("借阅记录",panel_3);//里面后还书记录——还书时间
		
		
		this.add(tabbedPane);
	}
	public static void main(String[] args) {
		//方便 查看的frame
		JFrame  frame = new JFrame("借阅管理 测试 Frame");
		frame.setSize(800,600);
		frame.add(new Borrow_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
