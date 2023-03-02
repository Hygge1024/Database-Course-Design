package Work_View;
import java.awt.BorderLayout;
import java.awt.Color;
//图书管理
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class BookM_panel extends JPanel{
	public BookM_panel() {
		showM();
	}
	public void showM() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 700, 600);
		add(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(700,600));
		JPanel panel_1 = new JPanel();//添加图书
		JPanel panel_2 = new JPanel();//删除图书
		JPanel panel_3 = new JPanel();//管理记录
		Dimension dimension = new Dimension(700, 500);
		//panel_1
		Dimension addDimension = new Dimension(200,30);
		
		JPanel panel_1_1 = new JPanel();
		JLabel bISBN = new JLabel("bISBN：");
		bISBN.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bISBNField = new JTextField();
		bISBNField.setPreferredSize(addDimension);
		panel_1_1.add(bISBN);	
		panel_1_1.add(bISBNField);	
		
		JPanel panel_1_2 = new JPanel();
		JLabel bname = new JLabel("bname：");
		bname.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bnameField = new JTextField();
		bnameField.setPreferredSize(addDimension);
		panel_1_2.add(bname);	
		panel_1_2.add(bnameField);	
		
		JPanel panel_1_3 = new JPanel();
		JLabel bauthor = new JLabel("bauthor：");
		bauthor.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bauthorField = new JTextField();
		bauthorField.setPreferredSize(addDimension);
		panel_1_3.add(bauthor);	
		panel_1_3.add(bauthorField);	
		
		JPanel panel_1_4 = new JPanel();
		JLabel bhouse = new JLabel("bhouse：");
		bhouse.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bhouseField = new JTextField();
		bhouseField.setPreferredSize(addDimension);
		panel_1_4.add(bhouse);	
		panel_1_4.add(bhouseField);
		
		JPanel panel_1_5 = new JPanel();//对于剩余数 在数据操作时再添加 减小
		JLabel btime = new JLabel("btime：");
		btime.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField btimeField = new JTextField();
//		btimeField.addFocusListener(new JTextFieldHintListener(btimeField, "提示内容"));
		btimeField.setPreferredSize(addDimension);
		panel_1_5.add(btime);	
		panel_1_5.add(btimeField);
		
		JPanel panel_1_6 = new JPanel();
		JLabel tips = new JLabel("提示信息");
		tips.setForeground(Color.red);
		tips.setFont(new Font("宋体",Font.PLAIN,14));
		panel_1_6.add(tips);
		
		JPanel panel_1_7 = new JPanel();
		JButton button_1 = new JButton("确认添加");
		JButton button_2 = new JButton("取消");
		panel_1_7.add(button_1);
		panel_1_7.add(button_2);
		
		JPanel panel_1_8 = new JPanel();
		JLabel bleaveJLabel = new JLabel("书籍数量：");
		bleaveJLabel.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bleaveField = new JTextField();
		bleaveField.setPreferredSize(addDimension);
		panel_1_8.add(bleaveJLabel);	
		panel_1_8.add(bleaveField);
		
		
		JPanel panel_1_left = new JPanel();
		panel_1_left.setLayout(new GridLayout(3,1,0,0));
		JPanel panel_1_rigth = new JPanel();
		panel_1_rigth.setLayout(new GridLayout(3,1,0,0));
		
		panel_1_left.add(panel_1_1);
		panel_1_left.add(panel_1_2);
		panel_1_left.add(panel_1_3);
		panel_1_rigth.add(panel_1_4);
		panel_1_rigth.add(panel_1_5);
		panel_1_rigth.add(panel_1_8);
		
		
		JPanel endJPanel = new JPanel(new BorderLayout());
		endJPanel.add(panel_1_6,BorderLayout.CENTER);
		endJPanel.add(panel_1_7,BorderLayout.SOUTH);
		
		panel_1.add(panel_1_left,BorderLayout.WEST);
		panel_1.add(panel_1_rigth,BorderLayout.EAST);
		panel_1.add(endJPanel,BorderLayout.CENTER);
		
		
		//panel_2
		JPanel panel_2_1 = new JPanel();
		JLabel bISBN_2 = new JLabel("bISBN：");
		bISBN_2.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bISBN_2Field = new JTextField();
		bISBN_2Field.setPreferredSize(addDimension);
		panel_2_1.add(bISBN_2);	
		panel_2_1.add(bISBN_2Field);	
		
		JPanel panel_2_2 = new JPanel();
		JLabel bname_2 = new JLabel("bname：");
		bname_2.setFont(new Font("宋体",Font.PLAIN,14));
		JTextField bname_2Field = new JTextField();
		bname_2Field.setPreferredSize(addDimension);
		panel_2_2.add(bname_2);	
		panel_2_2.add(bname_2Field);
		
		JPanel panel_2_3 = new JPanel();
		JLabel tips_2 = new JLabel("提示信息");
		tips_2.setForeground(Color.red);
		tips_2.setFont(new Font("宋体",Font.PLAIN,14));
		panel_2_3.add(tips_2);
		
		JPanel panel_2_4 = new JPanel();
		JButton button_1_2 = new JButton("确认删除");
		JButton button_2_2 = new JButton("取消");
		panel_2_4.add(button_1_2);
		panel_2_4.add(button_2_2);
		
		JPanel panel_2_left = new JPanel(new GridLayout(5,1,0,0));
		JPanel panel_2_right = new JPanel(new GridLayout(2,1,0,0));
		
		panel_2_left.add(panel_2_1);
		panel_2_left.add(panel_2_2);
		panel_2_left.add(panel_2_3);
		panel_2_left.add(panel_2_4);
		
//		panel_2_right.add(panel_2_2);
//		panel_2_right.add(panel_2_3);
//		panel_2.add(panel_2_left,BorderLayout.WEST);
//		panel_2.add(panel_2_right,BorderLayout.EAST);
		panel_2.add(panel_2_left);
		/*
		 * 
		 */
		//添加显示 借阅信息的面板
				String user_id = Login_Demo3.text_name.getText();//user_id
				String user_identity = Login_Demo3.identityString;//用户 身份
				
				if(user_identity.equals("Admin")) {
					JPanel tableJPanel = new JPanel();
					JScrollPane scrollPane_1_1 = new JScrollPane();//滚动条
					scrollPane_1_1.setBounds(0, 10,249,685 );
					tableJPanel.add(scrollPane_1_1);
					
					Object[] headrObjects = new Object[] {"序号","bISBN","aid","添加时间","删除时间"};
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
					
					findResult = Work_Model.Service.get_B_A(user_id);//最终的数据集合
					
					Integer length = findResult.size();
					System.out.println("findResult的大小为："+ length);
					if(findResult.isEmpty()) {
						System.out.println("没有检索到符合条件的图书，请您重新输入！");
						JOptionPane.showMessageDialog(null, "没有检索到符合条件的图书，请您重新输入！");
					}else {	
						//对收到的数据进行7段的处理
						Vector<String> tempStrings = new Vector<>();
						for(int i = 0; i < length; i++) {
							if(i % 5 == 0 && i != 0) {
								tempStrings.clear();
							}
							tempStrings.add(findResult.get(i));
							if(tempStrings.size() == 5) {
								//添加到 Jpanel 面板上面
								model.addRow(new Object[] {tempStrings.get(0),tempStrings.get(1),tempStrings.get(2),tempStrings.get(3),tempStrings.get(4)});
								System.out.println("测试 "+tempStrings.get(0)+":"+tempStrings);
							}
						}
					}
					panel_3.add(tableJPanel);
				}
		/*
		 * 
		 */
		
		tabbedPane.addTab("添加图书", panel_1);
		tabbedPane.addTab("删除图书", panel_2);
		tabbedPane.addTab("管理记录", panel_3);
		this.add(tabbedPane);
		button_1.addActionListener(new ActionListener() {    //添加图书——确认添加
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bISBNString = bISBNField.getText();
				String bnameString = bnameField.getText();
				String bauthorString = bauthorField.getText();
				String bhouseString = bhouseField.getText();
//				int bleave = Work_Model.Service.find_Books(bISBNString);
				String bleaveString = bleaveField.getText();
				
				String btimeString = btimeField.getText();
				String bISBNString2 = Work_Model.Service.find_bISBN(bISBNString);
				if(bISBNString2.equals("")) {
					if(bISBNString.equals("") || bnameString.equals("") || bauthorString.equals("") || bhouseString.equals("") || bleaveString.equals("")) {
						tips.setText("输入信息不完整，请输入完整信息");
						System.out.println("错误：输入信息不完整，请输入完整信息");
					}else {
						Integer bleave = Integer.parseInt(bleaveString);
						Work_Model.Service.update_books(bISBNString, bnameString, bauthorString, bhouseString, bleave,btimeString);
						tips.setText("添加成功");
						//将 添加的相关信息 导入B_A中 bISBN,Aid,addtime,cuttime;
						SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = new Date(System.currentTimeMillis());
						String addtimeString = formattime.format(date);//添加时间
						String user_id = Login_Demo3.text_name.getText();//user_id
						Work_Model.Service.updateB_A(bISBNString, user_id, addtimeString);
						
						bISBNField.setText("");
						bnameField.setText("");
						bauthorField.setText("");
						bhouseField.setText("");
						btimeField.setText("");
						bleaveField.setText("");
						
					}
				}
				else {
					tips.setText("bISBN 已存在，请重新输入");
					System.out.println("错误：bISBN 已存在，请重新输入");
				}
			}
		});
		button_2.addActionListener(new ActionListener() {	//添加图书——取消
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tips.setText("操作已取消");
				bISBNField.setText("");
				bnameField.setText("");
				bauthorField.setText("");
				bhouseField.setText("");
				btimeField.setText("");
				bleaveField.setText("");
			}
		});
		button_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bISBN_2_String = bISBN_2Field.getText();
				String bname_2_String = bname_2Field.getText();
				String ifinString = Work_Model.Service.find_bISBN(bISBN_2_String);
				String bname_2_String2 = Work_Model.Service.find_bname(bISBN_2_String);
				System.out.println("bname_2_String2"+bname_2_String2);
				if(bISBN_2_String.equals("") || bname_2_String.equals("")) {
					tips_2.setText("输入信息不完整，请输入完整信息");
				}
				else if(ifinString.equals("")) {//表示 bISBN 正确
					tips_2.setText("输入bISBN 错误，请重新输入");
					bISBN_2Field.setText("");
					bname_2Field.setText("");
					System.out.println("输入bISBN 错误，请重新输入");
				}else if(!bname_2_String.equals(bname_2_String2)) {
					tips_2.setText("输入bname 错误，请重新输入");
					System.out.println("输入bname 错误，请重新输入");
					bname_2Field.setText("");
				}
				else {
					Work_Model.Service.delete_books(bISBN_2_String,bname_2_String);
					//添加删除信息到 B_A中
					SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = new Date(System.currentTimeMillis());
					String endtimeString = formattime.format(date);//添加时间
					String user_id = Login_Demo3.text_name.getText();//user_id
					Work_Model.Service.updateB_A2(bISBN_2_String, user_id, endtimeString);
					bISBN_2Field.setText("");
					bname_2Field.setText("");
					tips_2.setText("删除成功");
					System.out.println("删除成功");
				}
					 
				
			}
		});
		button_2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tips_2.setText("操作已取消");
				bISBN_2Field.setText("");
				bname_2Field.setText("");
			}
		});
		
	}
	public static void main(String[] args) {
		//方便 查看的frame
		JFrame  frame = new JFrame("图书管理 测试 Frame");
		frame.setSize(800,600);
		frame.add(new BookM_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
