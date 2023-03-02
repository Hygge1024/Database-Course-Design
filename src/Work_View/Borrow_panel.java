package Work_View;
import java.awt.Button;
import java.awt.Color;
//���Ĺ���
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
		JPanel panel_1 = new JPanel();//����
		JPanel panel_2 = new JPanel();//����
		JPanel panel_3 = new JPanel();//�����¼
		Dimension dimension = new Dimension(700, 500);
		Dimension broDimension = new Dimension(200,30);
		//��ʼװ�� panel_1 ���� ����
		/*
		 * 1.��������ӵ� B_R ����
		 * 2.��Books���н�bleave-1 
		 */
		JPanel panel_1_sum = new JPanel();
		panel_1_sum.setLayout(new GridLayout(4,1,0,0));
		JPanel panel_1_1 = new JPanel();
		JLabel bISBN_1 = new JLabel("bISBN��");
		bISBN_1.setFont(new Font("����",Font.PLAIN,14));
		JTextField bISBN_1Field = new JTextField();
		bISBN_1Field.setPreferredSize(broDimension);
		panel_1_1.add(bISBN_1);	
		panel_1_1.add(bISBN_1Field);	
		
		JPanel panel_1_2 = new JPanel();
		JLabel bname_1 = new JLabel("bname��");
		bname_1.setFont(new Font("����",Font.PLAIN,14));
		JTextField bname_1Field = new JTextField();
		bname_1Field.setPreferredSize(broDimension);
		panel_1_2.add(bname_1);	
		panel_1_2.add(bname_1Field);
		
		JPanel panel_1_3 = new JPanel();
		JLabel tip_1 = new JLabel("��ʾ��Ϣ");
		tip_1.setForeground(Color.red);
		tip_1.setFont(new Font("����",Font.PLAIN,14));
		panel_1_3.add(tip_1);
		
		JPanel panel_1_4 = new JPanel();
		JButton button_1_1 = new JButton("ȷ�Ͻ���");
		JButton button_1_2 = new JButton("ȡ��");
		panel_1_4.add(button_1_1);
		panel_1_4.add(button_1_2);
		
		panel_1_sum.add(panel_1_1);
		panel_1_sum.add(panel_1_2);
		panel_1_sum.add(panel_1_3);
		panel_1_sum.add(panel_1_4);
		panel_1.add(panel_1_sum);
		//����1����¼�
		button_1_1.addActionListener(new ActionListener() {//����
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_id = Login_Demo3.text_name.getText();//�û� id
				String user_identity = Login_Demo3.identityString;//�û� ���
				System.out.println("��ȡuser_name ����");
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
				int bleaveInt = Work_Model.Service.find_Books(bISBNString);//ʣ������
				String ifinString = Work_Model.Service.find_bISBN(bISBNString);//�ж� bISBN �Ƿ����
				String bnameString2 = Work_Model.Service.find_bname(bISBNString);
				System.out.println("bnameString2"+bnameString2);
				if(bISBNString.equals("") || bnameString.equals("")) {
					tip_1.setText("������Ϣ��������������������Ϣ");
					System.out.println("������Ϣ��������������������Ϣ");
				}
				else if(ifinString.equals("")) {
					tip_1.setText("���� bISBN ��������������");
					System.out.println("���� bISBN ��������������");
				}
				else if(!bnameString.equals(bnameString2)) {
					tip_1.setText("����bname ��������������");
					System.out.println("����bname ��������������");
					bname_1Field.setText("");
				}
				else if(bleaveInt <= 0) {
					tip_1.setText("�������㣬��֪ͨ����Ա��ʱ����");
					System.out.println("�������㣬��֪ͨ����Ա��ʱ����");
				}
				else {
					
					bleaveInt--;
					Work_Model.Service.update_numbers(bISBNString, bleaveInt);
					Work_Model.Service.update_jie(bISBNString, user_id, bnameString, user_name, startTimeString,user_identity);
					tip_1.setText("���ĳɹ�");
					bname_1Field.setText("");
					bISBN_1Field.setText("");
				}
				
				
			}
		});
		
		button_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_1.setText("������ȡ��");
				bname_1Field.setText("");
				bISBN_1Field.setText("");
				
			}
		});
		
		//��ʼװ�� panel_2 ���� ����
		/*
		 * 1.�����ݴ� B_R ����ɾ��
		 * 2.��Books���н�bleave +1 
		 */
		JPanel panel_2_sum = new JPanel();
		panel_2_sum.setLayout(new GridLayout(4,1,0,0));
		JPanel panel_2_1 = new JPanel();
		JLabel bISBN_2 = new JLabel("bISBN��");
		bISBN_2.setFont(new Font("����",Font.PLAIN,14));
		JTextField bISBN_2Field = new JTextField();
		bISBN_2Field.setPreferredSize(broDimension);
		panel_2_1.add(bISBN_2);	
		panel_2_1.add(bISBN_2Field);
		
		JPanel panel_2_2 = new JPanel();
		JLabel bname_2 = new JLabel("bname��");
		bname_2.setFont(new Font("����",Font.PLAIN,14));
		JTextField bname_2Field = new JTextField();
		bname_2Field.setPreferredSize(broDimension);
		panel_2_2.add(bname_2);	
		panel_2_2.add(bname_2Field);
		
		JPanel panel_2_3 = new JPanel();
		JLabel tip_2 = new JLabel("��ʾ��Ϣ");
		tip_2.setForeground(Color.red);
		tip_2.setFont(new Font("����",Font.PLAIN,14));
		panel_2_3.add(tip_2);
		
		JPanel panel_2_4 = new JPanel();
		JButton button_2_1 = new JButton("ȷ�ϻ���");
		JButton button_2_2 = new JButton("ȡ��");
		panel_2_4.add(button_2_1);
		panel_2_4.add(button_2_2);
		
		panel_2_sum.add(panel_2_1);
		panel_2_sum.add(panel_2_2);
		panel_2_sum.add(panel_2_3);
		panel_2_sum.add(panel_2_4);
		panel_2.add(panel_2_sum);
		
		//����2����¼�
		button_2_1.addActionListener(new ActionListener() {//����
			/*
			 * 1.ֻ��Ҫ�� �����¼���潫endtime ����ȥ�Ϳ�����
			 * 2.Books�� bleave ������һ
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user_id = Login_Demo3.text_name.getText();//�û� id
				String user_identity = Login_Demo3.identityString;//�û� ���
				
				String bISBNString = bISBN_2Field.getText();// bISBN
				String bnameString = bname_2Field.getText();// bname
				
				String ifinString = Work_Model.Service.find_bISBN(bISBNString);//�ж� bISBN �Ƿ����
				String bnameString2 = Work_Model.Service.find_bname(bISBNString);//�ж� ����bname�Ƿ���ȷ
				System.out.println("bnameString2"+bnameString2);
				
				SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
				String endTimeString = formattime.format(date);
				int bleaveInt = Work_Model.Service.find_Books(bISBNString);//ʣ������
				if(bISBNString.equals("") || bnameString.equals("")) {
					tip_2.setText("������Ϣ��������������������Ϣ");
					System.out.println("������Ϣ��������������������Ϣ");
				}
				else if(ifinString.equals("")) {
					tip_2.setText("���� bISBN ��������������");
					System.out.println("���� bISBN ��������������");
					bname_2Field.setText("");
					bISBN_2Field.setText("");
				}
				else if(!bnameString.equals(bnameString2)) {
					tip_2.setText("����bname ��������������");
					System.out.println("����bname ��������������");
					bname_2Field.setText("");
				}else {
					bleaveInt++;
					Work_Model.Service.update_numbers(bISBNString,bleaveInt);
					Work_Model.Service.update_endtime(endTimeString, bISBNString, user_id, user_identity);
					tip_2.setText("����ɹ�");
					System.out.println("����ɹ�");
					bname_2Field.setText("");
					bISBN_2Field.setText("");
				}
			}
		});
		button_2_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_2.setText("������ȡ��");
				bname_2Field.setText("");
				bISBN_2Field.setText("");
				
			}
		});
		//��ʼװ�� panel_3 ������¼ ����
		/*
		 * 1.��B_R���ҳ� rid �� aid ���ڸ��û��ļ�¼����ʾ����
		 */
		
		//�����ʾ ������Ϣ�����
		String user_id = Login_Demo3.text_name.getText();//user_id
		String user_identity = Login_Demo3.identityString;//�û� ���
		
		if(user_identity.equals("Readers")) {
			JPanel tableJPanel = new JPanel();
			JScrollPane scrollPane_1_1 = new JScrollPane();//������
	//		scrollPane_1_1.setBounds(0, 148, 685, 249);
			scrollPane_1_1.setBounds(0, 10,249,685 );
			tableJPanel.add(scrollPane_1_1);
//			scrollPane_1_1.setHorizontalScrollBarPolicy(                
//	                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//			scrollPane_1_1.setVerticalScrollBarPolicy(                
//	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//	
			
			Object[] headrObjects = new Object[] {"���","bISBN","����id","����","�û���","����ʱ��","�黹ʱ��"};
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
			
			findResult = Work_Model.Service.get_B_R(user_id);//���յ����ݼ���
			
			Integer length = findResult.size();
			System.out.println("findResult�Ĵ�СΪ��"+ length);
			if(findResult.isEmpty()) {
				System.out.println("û�м���������������ͼ�飬�����������룡");
				JOptionPane.showMessageDialog(null, "û�м���������������ͼ�飬�����������룡");
			}else {	
				//���յ������ݽ���7�εĴ���
				Vector<String> tempStrings = new Vector<>();
				for(int i = 0; i < length; i++) {
					if(i % 7 == 0 && i != 0) {
						tempStrings.clear();
					}
					tempStrings.add(findResult.get(i));
					if(tempStrings.size() == 7) {
						//��ӵ� Jpanel �������
						model.addRow(new Object[] {tempStrings.get(0),tempStrings.get(1),tempStrings.get(2),tempStrings.get(3),tempStrings.get(4),tempStrings.get(5),tempStrings.get(6)});
						System.out.println("���� "+tempStrings.get(0)+":"+tempStrings);
					}
				}
			}
			panel_3.add(tableJPanel);
		}
		//�������
		tabbedPane.addTab("����", panel_1);
		tabbedPane.addTab("����", panel_2);
		tabbedPane.add("���ļ�¼",panel_3);//��������¼��������ʱ��
		
		
		this.add(tabbedPane);
	}
	public static void main(String[] args) {
		//���� �鿴��frame
		JFrame  frame = new JFrame("���Ĺ��� ���� Frame");
		frame.setSize(800,600);
		frame.add(new Borrow_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
