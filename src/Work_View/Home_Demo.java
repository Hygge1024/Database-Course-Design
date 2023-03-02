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
		JFrame frame = new JFrame("ͼ������ϼ���ϵͳv1.0 by ���2102����");
		frame.setSize(800,600);
		frame.setFont(new Font("����",Font.PLAIN,14));
		
		//���һ�����ܿ�
		JPanel workJPanel = new JPanel();
		workJPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		workJPanel.setBorder(BorderFactory.createTitledBorder("����"));
		workJPanel.setLayout(new BoxLayout(workJPanel, BoxLayout.X_AXIS));
		
		JButton button1 = new JButton("��Ϣ��ѯ");
		JButton button2 = new JButton("���Ĺ���");
		JButton button3 = new JButton("ͼ�����");
		JButton button4 = new JButton("�˺Ź���");
		JButton button5 = new JButton("�˳�ϵͳ");
		
		workJPanel.add(button1);
		workJPanel.add(button2);
		workJPanel.add(button3);
		workJPanel.add(button4);
		workJPanel.add(button5);
		
		//���������ݿ�
		JPanel contentJPanel = new JPanel();
		contentJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		contentJPanel.setBorder(BorderFactory.createTitledBorder("ϵͳģ�����"));
		CardLayout cardLayout = new CardLayout();
		contentJPanel.setLayout(cardLayout);//contentJPanel ����Ϊ ��Ƭ����
		
		Find_panel find_panel = new Find_panel();
		contentJPanel.add("��Ϣ��ѯ",find_panel);
		
		Borrow_panel borrow_panel = new Borrow_panel();
		contentJPanel.add("���Ĺ���",borrow_panel);
		
		BookM_panel bookM_panel = new BookM_panel();
		contentJPanel.add("ͼ�����",bookM_panel);
		
		Account_panel account_panel = new Account_panel();
		contentJPanel.add("�˺Ź���",account_panel);
		
		//�������ʱ��ģ��
		JPanel noteJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		JLabel timeJLabel = new JLabel(formattime.format(date));
		noteJPanel.add(timeJLabel);
		
		//����¼�
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String actionCommand = e.getActionCommand();
				switch (actionCommand) {
				case "��Ϣ��ѯ":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "���Ĺ���":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "ͼ�����":
					cardLayout.show(contentJPanel, actionCommand);
					break;
				case "�˺Ź���":
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
				frame.setEnabled(false);//����ҳ����Ϊ���ɱ༭
				// TODO Auto-generated method stub
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
				
				//Ϊ�˳�ϵͳ b1 �� b2 ����¼�
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						disposeFrame.dispose();
						Work_Model.Service.quit();
						frame.dispose();
						System.exit(0);//���׹رճ��򡪡�����������������
					}
				});
				b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame.setEnabled(true);//����ҳ����Ϊ�ɱ༭
						disposeFrame.dispose();
					}
				});
				disposeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				disposeFrame.setLocationRelativeTo(null);//������ʾ
				disposeFrame.setVisible(true);;
			}
		});
		String user_identity = Login_Demo3.identityString;//�û� ���
		//��� identity == "Admin" "���Ĺ���"����Ϊ���ɱ༭
		if(user_identity.equals("Admin")) {
			button2.setEnabled(false);
		}
		//��� identity == "Readers" "ͼ�����"����Ϊ���ɱ༭
		if(user_identity.equals("Readers")) {
			button3.setEnabled(false);
		}
		//��Ӱ��һ������frame��
		frame.add(workJPanel,BorderLayout.NORTH);
		frame.add(contentJPanel,BorderLayout.CENTER);
		frame.add(noteJPanel,BorderLayout.SOUTH);
		
		frame.setLocationRelativeTo(null);//��ʾ����Ļ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
