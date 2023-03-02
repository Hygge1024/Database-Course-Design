package Work_View;
import java.awt.BorderLayout;
import java.awt.Color;
//ͼ�����
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
		JPanel panel_1 = new JPanel();//���ͼ��
		JPanel panel_2 = new JPanel();//ɾ��ͼ��
		JPanel panel_3 = new JPanel();//�����¼
		Dimension dimension = new Dimension(700, 500);
		//panel_1
		Dimension addDimension = new Dimension(200,30);
		
		JPanel panel_1_1 = new JPanel();
		JLabel bISBN = new JLabel("bISBN��");
		bISBN.setFont(new Font("����",Font.PLAIN,14));
		JTextField bISBNField = new JTextField();
		bISBNField.setPreferredSize(addDimension);
		panel_1_1.add(bISBN);	
		panel_1_1.add(bISBNField);	
		
		JPanel panel_1_2 = new JPanel();
		JLabel bname = new JLabel("bname��");
		bname.setFont(new Font("����",Font.PLAIN,14));
		JTextField bnameField = new JTextField();
		bnameField.setPreferredSize(addDimension);
		panel_1_2.add(bname);	
		panel_1_2.add(bnameField);	
		
		JPanel panel_1_3 = new JPanel();
		JLabel bauthor = new JLabel("bauthor��");
		bauthor.setFont(new Font("����",Font.PLAIN,14));
		JTextField bauthorField = new JTextField();
		bauthorField.setPreferredSize(addDimension);
		panel_1_3.add(bauthor);	
		panel_1_3.add(bauthorField);	
		
		JPanel panel_1_4 = new JPanel();
		JLabel bhouse = new JLabel("bhouse��");
		bhouse.setFont(new Font("����",Font.PLAIN,14));
		JTextField bhouseField = new JTextField();
		bhouseField.setPreferredSize(addDimension);
		panel_1_4.add(bhouse);	
		panel_1_4.add(bhouseField);
		
		JPanel panel_1_5 = new JPanel();//����ʣ���� �����ݲ���ʱ����� ��С
		JLabel btime = new JLabel("btime��");
		btime.setFont(new Font("����",Font.PLAIN,14));
		JTextField btimeField = new JTextField();
//		btimeField.addFocusListener(new JTextFieldHintListener(btimeField, "��ʾ����"));
		btimeField.setPreferredSize(addDimension);
		panel_1_5.add(btime);	
		panel_1_5.add(btimeField);
		
		JPanel panel_1_6 = new JPanel();
		JLabel tips = new JLabel("��ʾ��Ϣ");
		tips.setForeground(Color.red);
		tips.setFont(new Font("����",Font.PLAIN,14));
		panel_1_6.add(tips);
		
		JPanel panel_1_7 = new JPanel();
		JButton button_1 = new JButton("ȷ�����");
		JButton button_2 = new JButton("ȡ��");
		panel_1_7.add(button_1);
		panel_1_7.add(button_2);
		
		JPanel panel_1_8 = new JPanel();
		JLabel bleaveJLabel = new JLabel("�鼮������");
		bleaveJLabel.setFont(new Font("����",Font.PLAIN,14));
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
		JLabel bISBN_2 = new JLabel("bISBN��");
		bISBN_2.setFont(new Font("����",Font.PLAIN,14));
		JTextField bISBN_2Field = new JTextField();
		bISBN_2Field.setPreferredSize(addDimension);
		panel_2_1.add(bISBN_2);	
		panel_2_1.add(bISBN_2Field);	
		
		JPanel panel_2_2 = new JPanel();
		JLabel bname_2 = new JLabel("bname��");
		bname_2.setFont(new Font("����",Font.PLAIN,14));
		JTextField bname_2Field = new JTextField();
		bname_2Field.setPreferredSize(addDimension);
		panel_2_2.add(bname_2);	
		panel_2_2.add(bname_2Field);
		
		JPanel panel_2_3 = new JPanel();
		JLabel tips_2 = new JLabel("��ʾ��Ϣ");
		tips_2.setForeground(Color.red);
		tips_2.setFont(new Font("����",Font.PLAIN,14));
		panel_2_3.add(tips_2);
		
		JPanel panel_2_4 = new JPanel();
		JButton button_1_2 = new JButton("ȷ��ɾ��");
		JButton button_2_2 = new JButton("ȡ��");
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
		//�����ʾ ������Ϣ�����
				String user_id = Login_Demo3.text_name.getText();//user_id
				String user_identity = Login_Demo3.identityString;//�û� ���
				
				if(user_identity.equals("Admin")) {
					JPanel tableJPanel = new JPanel();
					JScrollPane scrollPane_1_1 = new JScrollPane();//������
					scrollPane_1_1.setBounds(0, 10,249,685 );
					tableJPanel.add(scrollPane_1_1);
					
					Object[] headrObjects = new Object[] {"���","bISBN","aid","���ʱ��","ɾ��ʱ��"};
					Object[][] numObjects = {};
					
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(headrObjects);
					//�������
					
					JTable table_1 = new JTable();
					table_1.setModel(model);
					table_1.setPreferredScrollableViewportSize(new Dimension(600,300));
					scrollPane_1_1.setViewportView(table_1);
					scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				
					Vector<String> findResult = new Vector<>();
					
					findResult = Work_Model.Service.get_B_A(user_id);//���յ����ݼ���
					
					Integer length = findResult.size();
					System.out.println("findResult�Ĵ�СΪ��"+ length);
					if(findResult.isEmpty()) {
						System.out.println("û�м���������������ͼ�飬�����������룡");
						JOptionPane.showMessageDialog(null, "û�м���������������ͼ�飬�����������룡");
					}else {	
						//���յ������ݽ���7�εĴ���
						Vector<String> tempStrings = new Vector<>();
						for(int i = 0; i < length; i++) {
							if(i % 5 == 0 && i != 0) {
								tempStrings.clear();
							}
							tempStrings.add(findResult.get(i));
							if(tempStrings.size() == 5) {
								//��ӵ� Jpanel �������
								model.addRow(new Object[] {tempStrings.get(0),tempStrings.get(1),tempStrings.get(2),tempStrings.get(3),tempStrings.get(4)});
								System.out.println("���� "+tempStrings.get(0)+":"+tempStrings);
							}
						}
					}
					panel_3.add(tableJPanel);
				}
		/*
		 * 
		 */
		
		tabbedPane.addTab("���ͼ��", panel_1);
		tabbedPane.addTab("ɾ��ͼ��", panel_2);
		tabbedPane.addTab("�����¼", panel_3);
		this.add(tabbedPane);
		button_1.addActionListener(new ActionListener() {    //���ͼ�顪��ȷ�����
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
						tips.setText("������Ϣ��������������������Ϣ");
						System.out.println("����������Ϣ��������������������Ϣ");
					}else {
						Integer bleave = Integer.parseInt(bleaveString);
						Work_Model.Service.update_books(bISBNString, bnameString, bauthorString, bhouseString, bleave,btimeString);
						tips.setText("��ӳɹ�");
						//�� ��ӵ������Ϣ ����B_A�� bISBN,Aid,addtime,cuttime;
						SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = new Date(System.currentTimeMillis());
						String addtimeString = formattime.format(date);//���ʱ��
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
					tips.setText("bISBN �Ѵ��ڣ�����������");
					System.out.println("����bISBN �Ѵ��ڣ�����������");
				}
			}
		});
		button_2.addActionListener(new ActionListener() {	//���ͼ�顪��ȡ��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tips.setText("������ȡ��");
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
					tips_2.setText("������Ϣ��������������������Ϣ");
				}
				else if(ifinString.equals("")) {//��ʾ bISBN ��ȷ
					tips_2.setText("����bISBN ��������������");
					bISBN_2Field.setText("");
					bname_2Field.setText("");
					System.out.println("����bISBN ��������������");
				}else if(!bname_2_String.equals(bname_2_String2)) {
					tips_2.setText("����bname ��������������");
					System.out.println("����bname ��������������");
					bname_2Field.setText("");
				}
				else {
					Work_Model.Service.delete_books(bISBN_2_String,bname_2_String);
					//���ɾ����Ϣ�� B_A��
					SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = new Date(System.currentTimeMillis());
					String endtimeString = formattime.format(date);//���ʱ��
					String user_id = Login_Demo3.text_name.getText();//user_id
					Work_Model.Service.updateB_A2(bISBN_2_String, user_id, endtimeString);
					bISBN_2Field.setText("");
					bname_2Field.setText("");
					tips_2.setText("ɾ���ɹ�");
					System.out.println("ɾ���ɹ�");
				}
					 
				
			}
		});
		button_2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tips_2.setText("������ȡ��");
				bISBN_2Field.setText("");
				bname_2Field.setText("");
			}
		});
		
	}
	public static void main(String[] args) {
		//���� �鿴��frame
		JFrame  frame = new JFrame("ͼ����� ���� Frame");
		frame.setSize(800,600);
		frame.add(new BookM_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
