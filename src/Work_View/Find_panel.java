package Work_View;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;
import java.text.Normalizer;
import java.util.List;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.PlainDocument;

public class Find_panel extends JPanel{	
	public Find_panel() {
		showpanel();
	}

	public void showpanel() {//一定要仔细，很多错误都是 不仔细造成的！！！
		
		FlowLayout flowLayout = new FlowLayout();
		BorderLayout borderLayout = new BorderLayout();
		
		//设置面板背景——失败
		
		//搜索面板
		JPanel findJPanel = new JPanel();
		findJPanel.setLayout(borderLayout);
		
		//************
		
		JPanel inputJPanel = new JPanel();
		inputJPanel.setLayout(flowLayout);
		JTextField nameField = new JTextField();
		Dimension dimension = new Dimension(400,30);
		nameField.setPreferredSize(dimension);
		
		JButton button = new JButton("查询");
		button.setFont(new Font("宋体",Font.BOLD,12));
		
		inputJPanel.add(nameField);
		inputJPanel.add(button);
		//搜索面板-查询方式
		JPanel methodJPanel = new JPanel();
		JPanel methodJPanel_2 = new JPanel();
		
		JLabel label1 = new JLabel("查询方式：");
		label1.setFont(new Font("宋体", Font.BOLD, 12));
		methodJPanel_2.add(label1);
		
		JRadioButton jRadioButton1 = new JRadioButton("ISBN");
		jRadioButton1.setFont(new Font("宋体", Font.BOLD, 12));
		jRadioButton1.setSelected(true);
		methodJPanel_2.add(jRadioButton1);
		
		JRadioButton jRadioButton2 = new JRadioButton("书名");
		jRadioButton2.setFont(new Font("宋体", Font.BOLD, 12));
		methodJPanel_2.add(jRadioButton2);
		
		JRadioButton jRadioButton3 = new JRadioButton("全部");
		jRadioButton3.setFont(new Font("宋体", Font.BOLD, 12));
		methodJPanel_2.add(jRadioButton3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioButton2);
		buttonGroup.add(jRadioButton3);
		methodJPanel.add(methodJPanel_2);

		JLabel endJLabel = new JLabel("查询结果：");
		JLabel notes = new JLabel();
		JPanel endnotes = new JPanel();
		endnotes.add(endJLabel);
		endnotes.add(notes);
		notes.setFont(new Font("宋体",Font.BOLD,14));
		
		notes.setForeground(Color.red);
		endJLabel.setFont(new Font("宋体",Font.PLAIN,14));
		
		findJPanel.add(endnotes,BorderLayout.SOUTH);
		findJPanel.add(inputJPanel,BorderLayout.NORTH);
		findJPanel.add(methodJPanel,BorderLayout.CENTER);
		
		
		this.add(findJPanel);
		//显示结果面板
		JPanel endJPanel = new JPanel();//显示查询结果 面板	
		JPanel tableJPanel = new JPanel();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();//滚动条
		scrollPane_1_1.setBounds(0, 148, 685, 249);
		tableJPanel.add(scrollPane_1_1);
		
		Object[] headrObjects = new Object[] {"序号","ISBN","书名","作者","出版社","库存量","出版时间"};
		Object[][] numObjects = {};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(headrObjects);
		//方法一：
		JTable table_1 = new JTable();
		table_1.setModel(model);
		table_1.setPreferredScrollableViewportSize(new Dimension(600,300));
//		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//将自适应关闭
		scrollPane_1_1.setViewportView(table_1);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		/*方法二：JList list = new JList();//此方法——效果不是太好
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("宋体",Font.BOLD,15));
		scrollPane_1_1.getViewport().setView(list);*/
		//方法三：
		//给"查询"button 添加事件
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> findResult = new Vector<>();
				model.getDataVector().clear();
			
//				JList list = new JList();
//				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				list.setFont(new Font("宋体",Font.BOLD,15));				
				String textinputString = nameField.getText().trim();
				nameField.setText("");
				//查询方式的选择
				int isselect = 0;
				if(jRadioButton1.isSelected()) {
					isselect = 1;
				}else if (jRadioButton2.isSelected()) {
					isselect = 2;
				}else if(jRadioButton3.isSelected()) {
					isselect = 3;
				}
				System.out.println("选择结果为：" + isselect);
				//关键字的选择
				if(textinputString.equals("") && isselect != 3) {
					notes.setText("查询输入为空，请重新输入");
					System.out.println("查询输入为空，请重新输入");
				}
				else {
					System.out.println(textinputString);
					findResult = Work_Model.Service.getBooks(textinputString,isselect);//最终的数据集合
					Integer length = findResult.size();
					System.out.println("findResult的大小为："+ length);
					if(findResult.isEmpty()) {
						notes.setText("没有检索到符合条件的图书，请您重新输入！");
						System.out.println("没有检索到符合条件的图书，请您重新输入！");
						JOptionPane.showMessageDialog(null, "没有检索到符合条件的图书，请您重新输入！");
					}else {
						notes.setText("正常");
//						list.setListData(findResult);//此方法——效果不是太好
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
						//显示最终的结果
//						System.out.println("Find_panel:"+findResult);//在 终端输出结果，方便查看效果
					}	
				}
			}
		});
		endJPanel.add(tableJPanel);
		this.add(endJPanel);
	}	
	public static void main(String[] args) {//主函数 只是为了方便编辑是查看效果
		JFrame frame = new JFrame("信息查询 测试 Frame");
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new Find_panel());
		frame.setSize(800,500);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);;
		frame.setVisible(true);
	}
}
