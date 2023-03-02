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
		//��Frame
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳�
		
		/*
		 *���� 
		 */
		BorderLayout b1BorderLayout = new BorderLayout();
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,10,10);
		GridLayout g1GridLayout = new GridLayout(5,1,0,0);
 		frame.setSize(700,400);
		
		//��¼����
		JPanel getinJPanel = new JPanel();
		getinJPanel.setLayout(g1GridLayout);
		
		JPanel p1JPanel = new JPanel();
		JLabel helloJLabel = new JLabel("��ӭʹ��ͼ������ϼ���ϵͳ");
		helloJLabel.setFont(new Font("����",Font.PLAIN,25));
		p1JPanel.add(helloJLabel);
		
		
		//�˺�
		JPanel p2JPanel = new JPanel();
		p2JPanel.setLayout(f1);//���沿��
		//ʵ���� JLabel ��ǩ����
		JLabel labname = new JLabel("�˺ţ�");
		labname.setFont(new Font("����",Font.PLAIN,14));
		p2JPanel.add(labname);
		//ʵ����JTextField��ǩ����
		text_name = new JTextField();
		Dimension dim1 = new Dimension(300,30);//���ó��������������������𽥵Ĵ�С
		text_name.setPreferredSize(dim1);//����text_name �Ĵ�С
		//��text_name �ɱ༭�ı� ��ӵ�������
		p2JPanel.add(text_name);
		
		//����
		JPanel p3JPanel = new JPanel();
		JLabel labpass = new JLabel("���룺");
		labpass.setFont(new Font("����",Font.PLAIN,14));
		//��labpass��ӵ�������
		p3JPanel.add(labpass);
		//ʵ����JPassWordField
		JPasswordField text_passField = new JPasswordField();
		text_passField.setEchoChar('*');//������ʾ ��ʽ��*��
		//���ô�С
		text_passField.setPreferredSize(dim1);
		p3JPanel.add(text_passField);
		
		//ʵ���� JButton���
		JPanel p4JPanel = new JPanel();
		JButton button1 = new JButton("��¼");
		Dimension dim2 = new Dimension(100,30);
		button1.setFont(new Font("����",Font.PLAIN,14));
		button1.setSize(dim2);//���ð����Ĵ�С
		JButton button2 = new JButton("ע��");
		button2.setFont(new Font("����",Font.PLAIN,14));
		button2.setSize(dim2);
				
		p4JPanel.add(button1);
		p4JPanel.add(button2);	
		
		//��¼���ģ��
		JPanel identityJPanel_1 = new JPanel();
		JLabel label1 = new JLabel("��¼��ݣ�");
		label1.setFont(new Font("����", Font.BOLD, 12));
		identityJPanel_1.add(label1);
				
		JRadioButton jRadioButton1 = new JRadioButton("ѧ��");
		jRadioButton1.setFont(new Font("����", Font.BOLD, 12));
		jRadioButton1.setSelected(true);
		identityJPanel_1.add(jRadioButton1);
				
		JRadioButton jRadioButton2 = new JRadioButton("����Ա");
		jRadioButton2.setFont(new Font("����", Font.BOLD, 12));
		identityJPanel_1.add(jRadioButton2);
		
		JPanel identityJPanel_2 = new JPanel(new BorderLayout());
		//ģ����
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioButton2);
		identityJPanel_2.add(identityJPanel_1,BorderLayout.NORTH);
		//�����ʾ��Ϣ
		JPanel tipJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel tipJLabel = new JLabel();
		tipJLabel.setForeground(Color.red);
		tipJLabel.setFont(new Font("����",Font.PLAIN,13));
		tipJLabel.setText("��ʾ��Ϣ");
		tipJPanel.add(tipJLabel);
		identityJPanel_2.add(tipJPanel,BorderLayout.CENTER);
		//��ӵ�getinJPanel��
		getinJPanel.add(p1JPanel);
		getinJPanel.add(p2JPanel);
		getinJPanel.add(p3JPanel);
		getinJPanel.add(identityJPanel_2);
//		getinJPanel.add(tipJPanel);
		getinJPanel.add(p4JPanel);
		
		//ͼƬչʾ����
		JPanel tupianJPanel = new JPanel();
		JLabel picJLabel = new JLabel(new ImageIcon("image/temp2.jpg"));
		tupianJPanel.add(picJLabel);
		picJLabel.setBounds(0, 150, 700, 500);
		
		
//��ʼ���� �¼��ˣ���������������
		//��"��¼"��ť����¼�
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(text_name.getText());//�鿴 �˺�
				//�˺ţ�text_name ���룺text_passField
				//��Ҫ 1������˺��Ƿ���� 2�������Ƿ��Ӧ��ȷ
				Integer index = 0;
				if(jRadioButton1.isSelected()) {
					identityString = "Readers";
					index = 1;//ѧ��
				}else if(jRadioButton2.isSelected()){
					identityString = "Admin";
					index = 2;//����Ա
				}
				if(text_name.getText().equals("")) {
					tipJLabel.setText("�˺�Ϊ�գ������������˺�");
					text_name.setText("");
					text_passField.setText("");
					System.out.println("Login_Demo3:�˺�Ϊ��");
				}else {
					String endpassword = Work_Model.Service.login(text_name, index);//���ݿ��е�����
					String yuanpassword = new String(text_passField.getPassword());//�����������ȡ
					System.out.println("Login_Demo3 | text_passField = "+yuanpassword);
					System.out.println("Login_Demo3 | endpassword = " + endpassword);
					if(endpassword.equals("null")) {
						tipJLabel.setText("�û��������ڣ�����������");
						text_name.setText("");
						text_passField.setText("");
						System.out.println("Login_Demo3:�û���������");
					}
					else if(yuanpassword.equals(endpassword)) {
						Home_Demo home_Page = new Home_Demo();
						tipJLabel.setText("��¼�ɹ�");
						frame.dispose();
						home_Page.show();
						System.out.println("Login_Demo3 | ��¼�ɹ�������");
					}
					else {
						tipJLabel.setText("�����������������");
						text_name.setText("");
						text_passField.setText("");
						System.out.println("Login_Demo3:�������");
					}
				}
			}
		});
		//��"ע��"��ť����¼�(���ڻ��� ѧ��ע��)
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				frame.setEnabled(false);//��ʱ��������
				JFrame rejisterJFrame = new JFrame("Rejister");
				rejisterJFrame.setSize(800,300);
				rejisterJFrame.setLayout(new GridLayout(1,2,0,0));
//				rejisterJFrame.setResizable(false);//���ɵ�����С
				/*��Ҫע�����Ϣ�У�
				 *  rid��rname��rpassword��rsex��remail��rdepartment��
				 *  registertime��violation_status��sumbooks
				 *  ���� rid ������button1��Work_Model.Service.login(text_name, index);
				 *  ���ж� �û����Ƿ��Ѿ�������
				 */ 
				//1����ҳ��
				JPanel rejister_1 = new JPanel();//�����Ϣ(�˺ţ�����1������2����ʾ��Ϣ��ע��
				
				GridLayout g2GridLayout = new GridLayout(6,1,0,0);
				rejister_1.setLayout(g2GridLayout);
				Dimension rejister_1Dimension = new Dimension(200,30);
					//�˺�
				JPanel rejister_1_1 = new JPanel();
				JLabel nameJLabel = new JLabel("�û��˺ţ�");
				nameJLabel.setFont(new Font("����",Font.PLAIN,14));
				JTextField text_id = new JTextField();
				text_id.setPreferredSize(rejister_1Dimension);
				rejister_1_1.add(nameJLabel);
				rejister_1_1.add(text_id);
				
				JPanel rejister_1_2 = new JPanel();
				JLabel password_1_JLabel = new JLabel("�û����룺");
				password_1_JLabel.setFont(new Font("����",Font.PLAIN,14));
				JPasswordField password_1 = new JPasswordField();
				password_1.setPreferredSize(rejister_1Dimension);
				rejister_1_2.add(password_1_JLabel);
				rejister_1_2.add(password_1);
				
				JPanel rejister_1_3 = new JPanel();
				JLabel password_2_JLabel = new JLabel("ȷ�����룺");
				password_2_JLabel.setFont(new Font("����",Font.PLAIN,14));
				JPasswordField password_2 = new JPasswordField();
				password_2.setPreferredSize(rejister_1Dimension);
				rejister_1_3.add(password_2_JLabel);
				rejister_1_3.add(password_2);
				
				JPanel rejister_1_6 = new JPanel();
				JLabel text_name2Label = new JLabel("�û��ǳƣ�");
				text_name2Label.setFont(new Font("����",Font.PLAIN,14));
				JTextField text_name2 = new JTextField();
				text_name2.setPreferredSize(rejister_1Dimension);
				rejister_1_6.add(text_name2Label);
				rejister_1_6.add(text_name2);
				
				JPanel rejister_1_4 = new JPanel();
				JLabel tip2JLabel = new JLabel("��ʾ��Ϣ");
				tip2JLabel.setForeground(Color.red);
				tip2JLabel.setFont(new Font("����",Font.PLAIN,13));
				rejister_1_4.add(tip2JLabel);
				
				JPanel rejister_1_5 = new JPanel();
				JButton rejisterButton_1 = new JButton("ȷ��ע��");
				rejister_1_5.add(rejisterButton_1);
				
				rejister_1.add(rejister_1_1);
				rejister_1.add(rejister_1_2);
				rejister_1.add(rejister_1_3);
				rejister_1.add(rejister_1_6);//�����Ű�
				rejister_1.add(rejister_1_4);
				rejister_1.add(rejister_1_5);
				
				
				
				//2����ҳ�桪����
				JPanel rejister_2 = new JPanel();//�ұ���Ϣ(�Ա��ʼ������ţ�ע��ʱ�䣬ȡ��
				rejister_2.setLayout(g2GridLayout);
				//�Ա�-
				JPanel rejister_2_1 = new JPanel();
				JLabel sexJLabel = new JLabel("�Ա�");
				sexJLabel.setFont(new Font("����",Font.PLAIN,14));
				JComboBox<String> c1 = new JComboBox<String>();
				c1.setSize(rejister_1Dimension);
				c1.addItem("��");
				c1.addItem("Ů");
				//getSelectedItem() ���ڻ�ȡ��ǰѡ�е�������
				rejister_2_1.add(sexJLabel);
				rejister_2_1.add(c1);

	
				//�ʼ�
				JPanel rejister_2_2 = new JPanel();
				JLabel emailJLabel = new JLabel("email�� ");
				emailJLabel.setFont(new Font("����",Font.PLAIN,14));
				JTextField text_email = new JTextField();
				text_email.setPreferredSize(rejister_1Dimension);
				rejister_2_2.add(emailJLabel);
				rejister_2_2.add(text_email);
				
				//����
				JPanel rejister_2_3 = new JPanel();
				JLabel departJLabel = new JLabel("���ţ�  ");
				departJLabel.setFont(new Font("����",Font.PLAIN,14));
				JTextField text_depart = new JTextField();
				text_depart.setPreferredSize(rejister_1Dimension);
				rejister_2_3.add(departJLabel);
				rejister_2_3.add(text_depart);
				
				//ע��ʱ��
				JPanel rejister_2_4 = new JPanel();
				JLabel timeJLabel = new JLabel("ע��ʱ��");
				timeJLabel.setFont(new Font("����",Font.PLAIN,14));
				JTextField text_time = new JTextField();
				text_time.setPreferredSize(rejister_1Dimension);
				//����ʱ��
				SimpleDateFormat formatiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
//				System.out.println(date);
				text_time.setText(formatiem.format(date));
				text_time.setEditable(false);
				rejister_2_4.add(timeJLabel);
				rejister_2_4.add(text_time);
				
				//��ť
				JPanel rejister_2_5 = new JPanel();
				JButton rejisterButton_2 = new JButton("ȡ��ע��");
				rejister_2_5.add(rejisterButton_2);

				
				//��ݵ�¼
				JPanel rejister_2_6 = new JPanel();
				JLabel label12 = new JLabel("  ��¼��ݣ�");
				label1.setFont(new Font("����", Font.BOLD, 12));
				rejister_2_6.add(label12);
						
				JRadioButton jRadioButton12 = new JRadioButton("ѧ��");
				jRadioButton12.setFont(new Font("����", Font.BOLD, 12));
				jRadioButton12.setSelected(true);
				rejister_2_6.add(jRadioButton12);
						
				JRadioButton jRadioButton22 = new JRadioButton("����Ա");
				jRadioButton22.setFont(new Font("����", Font.BOLD, 12));
				rejister_2_6.add(jRadioButton22);
				//��jRadioButton12-22 ��Ӽ����¼�
				jRadioButton22.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						text_depart.setText("��������");
						text_depart.setFont(new Font("����",Font.PLAIN,14));
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
				rejister_2.add(rejister_2_1);//�����Ű�
				rejister_2.add(rejister_2_6);
				rejister_2.add(rejister_2_5);
				//frame����������
				rejisterJFrame.add(rejister_1);
				rejisterJFrame.add(rejister_2);
				rejisterJFrame.setLocationRelativeTo(null);//������ʾ	
				rejisterJFrame.setVisible(true);
				//����¼�
				/*
				 *"ȷ��ע��"��ť��1.�� �˺� �����ݿ��еģ�ѧ��/����Ա���˺ŶԱȣ��ж��Ƿ��Ѵ���
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
						//��� ���
						System.out.println("�û��˺�:"+text_id_String+"���û�����1:"+password_1_String+"�û�����2:"
								+password_2_String+"��email:"+email_String+"������:"+depart_String+"��ʱ��:"+time_String
								+"���û����ͣ�"+identityString+"���Ա�"+sex_String);
						int endid = Work_Model.Service.insert_id(text_id_String,identityString);//˳��ɷ���392��
						if(password_1_String.equals(password_2_String)){
							System.out.println("�������� ���"); 
							if(endid == 0) {
								System.out.println("����id ��ȷ");
								//��ʼ�� ��Ϣ���뵽 ���ݿ���
								if(text_id_String.equals("") || password_1_String.equals("") || password_2_String.equals("") || email_String.equals("") |
										 time_String.equals("") || identityString.equals("") || sex_String.equals("") || text_name_String.equals(""))
								{
									tip2JLabel.setText("��������д������Ϣ");
									System.out.println("��������д������Ϣ");
								}else {
									//ִ�в�����亯��
									Work_Model.Service.insert_xinxi(text_id_String,text_name_String,password_2_String,sex_String, email_String, depart_String, time_String,identityString);
									rejisterJFrame.dispose();
								}
							}
							else {
							System.out.println("����id �Ѵ���");
							//��ʾ��Ϣ��������������id�Ѵ��ڣ������´������id��
							tip2JLabel.setText("��������id�Ѵ��ڣ������´������id");
							text_id.setText("");
							password_1.setText("");
							password_2.setText("");
							text_email.setText("");
							text_depart.setText("");
							jRadioButton12.setSelected(true);
							}
						}else {
							System.out.println("�����������");
							//��ʾ��Ϣ��������������id�Ѵ��ڣ������´������id��
							tip2JLabel.setText("����������������´�������˺�");
							text_id.setText("");
							password_1.setText("");
							password_2.setText("");
							text_email.setText("");
							text_depart.setText("");
							jRadioButton12.setSelected(true);
						}
					}
				});
				//"ȡ��"��ť
				rejisterButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						rejisterJFrame.setEnabled(false);//����ҳ����Ϊ���ɱ༭
						JFrame disposeFrame = new JFrame();
						disposeFrame.setSize(400,200);
						
						JPanel  p1 = new JPanel();
						p1.setLayout(new BorderLayout());
						
						JPanel p3 = new JPanel();
						p3.setSize(400, 100);
						JLabel l1 = new JLabel("��ȷ��Ҫ�˳���");
						l1.setFont(new Font("����",Font.BOLD,16));
						p3.add(l1);
						
						JPanel p2 = new JPanel();
						p2.setSize(400, 100);
						JButton b1 = new JButton("ȷ��");
						JButton b2 = new JButton("ȡ��");
						p2.add(b1);
						p2.add(b2);
						p1.add(p3,BorderLayout.NORTH);
						p1.add(p2,BorderLayout.SOUTH);
						disposeFrame.add(p1);
						b1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								rejisterJFrame.setEnabled(true);//����ҳ����Ϊ�ɱ༭
								rejisterJFrame.dispose();//��ע�ᴦ����ر�
								disposeFrame.dispose();
							}
						});
						b2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								rejisterJFrame.setEnabled(true);//����ҳ����Ϊ�ɱ༭
								disposeFrame.dispose();
							}
						});
						disposeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						disposeFrame.setLocationRelativeTo(null);//������ʾ
						disposeFrame.setVisible(true);;
					}
				});
			}
		});		
		//��ӵ�frame��
		frame.add(getinJPanel,BorderLayout.EAST);
		frame.add(tupianJPanel,BorderLayout.WEST);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);//������ʾ
		frame.setVisible(true);
	}
}
/*
 * ���洦����ˣ��ڽ��button1��button2��ť�¼�
 */
