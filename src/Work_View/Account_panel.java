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
		//panel_1�����û�����
		/*
		 * ���� �û�id�� ��ʶ�û������Ϣ rid��ѧ���� ���� aid������Ա��
		 */
		String user_id = Login_Demo3.text_name.getText();//�û� id
		String user_identity = Login_Demo3.identityString;//�û� ���
		System.out.println("�û����Ϊ��"+user_identity);
		System.out.println("�û� idΪ��"+user_id);//��ȡ�� ��ǰ��¼��user_id
		
		tabbedPane.addTab("�û�����", panel_1);
		tabbedPane.addTab("�޸�����", panel_2);
		
		String user_name = "";
		String user_sex = "";
		String user_email = "";
		String user_depart = "";
		String user_time = "";
		
		//��panel_1 �û����� �������ʾ����
		JLabel label_1 = new JLabel("δ֪");
		JLabel label_2 = new JLabel("δ֪");
		JLabel label_3 = new JLabel("δ֪");
		JLabel label_4 = new JLabel("δ֪");
		JLabel label_5 = new JLabel("δ֪");
		JLabel label_6 = new JLabel("δ֪");
		JLabel label_7 = new JLabel("δ֪");
		
		
		if(user_identity.equals("Readers")) {//ѧ������
			Vector<String> find_Users_Result = new Vector<>();
			find_Users_Result = Work_Model.Service.getUsers(user_id, user_identity);
			if(find_Users_Result.isEmpty()) {
				System.out.println("����Account_panel.java ������");
			}else {
				user_name = find_Users_Result.get(0).equals("null")?"δ֪":find_Users_Result.get(0);
				user_sex = find_Users_Result.get(1).equals("null")?"δ֪":find_Users_Result.get(1);
				user_email = find_Users_Result.get(2).equals("null")?"δ֪":find_Users_Result.get(2);
				user_depart = find_Users_Result.get(3).equals("null")?"δ֪":find_Users_Result.get(3);
				user_time = find_Users_Result.get(4).equals("null")?"δ֪":find_Users_Result.get(4);
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
		if(user_identity.equals("Admin")) {//����Ա����
			Vector<String> find_Users_Result = new Vector<>();
			find_Users_Result = Work_Model.Service.getUsers(user_id, user_identity);
			if(find_Users_Result.isEmpty()) {
				System.out.println("����Account_panel.java ������");
			}else {
				user_name = find_Users_Result.get(0).equals("null")?"δ֪":find_Users_Result.get(0);
				user_sex = find_Users_Result.get(1).equals("null")?"δ֪":find_Users_Result.get(1);
				user_email = find_Users_Result.get(2).equals("null")?"δ֪":find_Users_Result.get(2);
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
		//��Ҫ��ʾ�Ĳ��֡����Ű���ʾ����id,name,sex identity,email,time,depart
		Dimension finDimension = new Dimension(200,30);
		if(user_identity.equals("Readers")) {
			//panel_1 ����
			JPanel panel_1_1 = new JPanel();
			JLabel user_idJLabel = new JLabel("�û�id ��");
			user_idJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_idField = new JTextField();
			user_idField.setPreferredSize(finDimension);
			user_idField.setText(user_id);
			user_idField.setEnabled(false);
			panel_1_1.add(user_idJLabel);
			panel_1_1.add(user_idField);
			
			JPanel panel_1_2 = new JPanel();
			JLabel user_nameJLabel = new JLabel("�û��ǳƣ�");
			user_nameJLabel.setFont(new Font("����",Font.PLAIN,14));
			user_nameField = new JTextField();
			user_nameField.setPreferredSize(finDimension);
			user_nameField.setText(user_name);
			user_nameField.setEnabled(false);
			panel_1_2.add(user_nameJLabel);
			panel_1_2.add(user_nameField);
			
			JPanel panel_1_3 = new JPanel();
			JLabel user_sexJLabel = new JLabel("�û��Ա�");
			user_sexJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_sexField = new JTextField();
			user_sexField.setPreferredSize(finDimension);
			user_sexField.setText(user_sex);
			user_sexField.setEnabled(false);
			panel_1_3.add(user_sexJLabel);
			panel_1_3.add(user_sexField);
			
			JPanel panel_1_4 = new JPanel();
			JLabel user_identityJLabel = new JLabel("�û���ݣ�");
			user_identityJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_identityField = new JTextField();
			user_identityField.setPreferredSize(finDimension);
			user_identityField.setText(user_identity);
			user_identityField.setEnabled(false);
			panel_1_4.add(user_identityJLabel);
			panel_1_4.add(user_identityField);
			
			JPanel panel_1_5 = new JPanel();
			JLabel user_emailJLabel = new JLabel("�û����䣺");
			user_emailJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_emailField = new JTextField();
			user_emailField.setPreferredSize(finDimension);
			user_emailField.setText(user_email);
			user_emailField.setEnabled(false);
			panel_1_5.add(user_emailJLabel);
			panel_1_5.add(user_emailField);
			
			JPanel panel_1_6 = new JPanel();
			JLabel user_timeJLabel = new JLabel("ע��ʱ�䣺");
			user_timeJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_timeField = new JTextField();
			user_timeField.setPreferredSize(finDimension);
			user_timeField.setText(user_time);
			user_timeField.setEnabled(false);
			panel_1_6.add(user_timeJLabel);
			panel_1_6.add(user_timeField);
			
			JPanel panel_1_7 = new JPanel();
			JLabel user_departJLabel = new JLabel("�û�ѧԺ��");
			user_departJLabel.setFont(new Font("����",Font.PLAIN,14));
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
			JLabel user_idJLabel = new JLabel("�û�id ��");
			user_idJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_idField = new JTextField();
			user_idField.setPreferredSize(finDimension);
			user_idField.setText(user_id);
			user_idField.setEnabled(false);
			panel_1_1.add(user_idJLabel);
			panel_1_1.add(user_idField);
			
			JPanel panel_1_2 = new JPanel();
			JLabel user_nameJLabel = new JLabel("�û��ǳƣ�");
			user_nameJLabel.setFont(new Font("����",Font.PLAIN,14));
			user_nameField = new JTextField();
			user_nameField.setPreferredSize(finDimension);
			user_nameField.setText(user_name);
			user_nameField.setEnabled(false);
			panel_1_2.add(user_nameJLabel);
			panel_1_2.add(user_nameField);
			
			JPanel panel_1_3 = new JPanel();
			JLabel user_sexJLabel = new JLabel("�û��Ա�");
			user_sexJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_sexField = new JTextField();
			user_sexField.setPreferredSize(finDimension);
			user_sexField.setText(user_sex);
			user_sexField.setEnabled(false);
			panel_1_3.add(user_sexJLabel);
			panel_1_3.add(user_sexField);
			
			JPanel panel_1_4 = new JPanel();
			JLabel user_identityJLabel = new JLabel("�û���ݣ�");
			user_identityJLabel.setFont(new Font("����",Font.PLAIN,14));
			JTextField user_identityField = new JTextField();
			user_identityField.setPreferredSize(finDimension);
			user_identityField.setText(user_identity);
			user_identityField.setEnabled(false);
			panel_1_4.add(user_identityJLabel);
			panel_1_4.add(user_identityField);
			
			JPanel panel_1_5 = new JPanel();
			JLabel user_emailJLabel = new JLabel("�û����䣺");
			user_emailJLabel.setFont(new Font("����",Font.PLAIN,14));
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
		//�ڶ����֡���panel_2 �޸�����
		/*
		 * ԭ���룺
		 * �޸����룺
		 * �ٴ����룺
		 * ȷ�ϣ��ύ�����ݿ��У�/ȡ���������
		 */
		JPanel panel_2_1 = new JPanel();
		JLabel password_1 = new JLabel("ԭʼ���룺");
		password_1.setFont(new Font("����",Font.PLAIN,14));
		JPasswordField password_1Field = new JPasswordField();
		password_1Field.setPreferredSize(finDimension);
		panel_2_1.add(password_1);	
		panel_2_1.add(password_1Field);	
		
		JPanel panel_2_2 = new JPanel();
		JLabel password_2 = new JLabel("�޸����룺");
		password_2.setFont(new Font("����",Font.PLAIN,14));
		JPasswordField password_2Field = new JPasswordField();
		password_2Field.setPreferredSize(finDimension);
		panel_2_2.add(password_2);	
		panel_2_2.add(password_2Field);	
		
		JPanel panel_2_3 = new JPanel();
		JLabel password_3 = new JLabel("�޸����룺");
		password_2.setFont(new Font("����",Font.PLAIN,14));
		JPasswordField password_3Field = new JPasswordField();
		password_3Field.setPreferredSize(finDimension);
		panel_2_3.add(password_3);	
		panel_2_3.add(password_3Field);	
		
		JPanel panel_2_4 = new JPanel();
		JButton button_1 = new JButton("ȷ���޸�");
		JButton button_2 = new JButton("ȡ��");
		panel_2_4.add(button_1);
		panel_2_4.add(button_2);
		
		JPanel panel_2_5 = new JPanel();
		JLabel tips = new JLabel("��ʾ��Ϣ");
		tips.setForeground(Color.red);
		tips.setFont(new Font("����",Font.PLAIN,14));
		panel_2_5.add(tips);
		
		panel_2.add(panel_2_1);
		panel_2.add(panel_2_2);
		panel_2.add(panel_2_3);
		panel_2.add(panel_2_5);
		panel_2.add(panel_2_4);
		//����¼���
		button_1.addActionListener(new ActionListener() {//ȷ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String p_w_1String = new String(password_1Field.getPassword());
				String p_w_2String = new String(password_2Field.getPassword());
				String p_w_3String = new String(password_3Field.getPassword());
				String oldp_wString = Work_Model.Service.find_password(user_id,user_identity);
				if(!oldp_wString.equals(p_w_1String)) {
					tips.setText("ԭʼ�����������������");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}
				else if(!p_w_2String.equals(p_w_3String)) {
					tips.setText("����������������������");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}else {
					tips.setText("�޸�����ɹ�");
					Work_Model.Service.update_password(user_id, p_w_3String, user_identity);
					System.out.println("�޸�����ɹ�");
					password_1Field.setText("");
					password_2Field.setText("");
					password_3Field.setText("");
				}
			}
		});
		
		button_2.addActionListener(new ActionListener() {//ȡ��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				password_1Field.setText("");
				password_2Field.setText("");
				password_3Field.setText("");
				tips.setText("������ȡ��");
			}
		});
		this.add(tabbedPane);
	}
	public static void main(String[] args) {
		JFrame  frame = new JFrame("�˺Ź��� ���� Frame");
		frame.setSize(900,400);;
		frame.add(new Account_panel());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
