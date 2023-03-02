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

	public void showpanel() {//һ��Ҫ��ϸ���ܶ������ ����ϸ��ɵģ�����
		
		FlowLayout flowLayout = new FlowLayout();
		BorderLayout borderLayout = new BorderLayout();
		
		//������屳������ʧ��
		
		//�������
		JPanel findJPanel = new JPanel();
		findJPanel.setLayout(borderLayout);
		
		//************
		
		JPanel inputJPanel = new JPanel();
		inputJPanel.setLayout(flowLayout);
		JTextField nameField = new JTextField();
		Dimension dimension = new Dimension(400,30);
		nameField.setPreferredSize(dimension);
		
		JButton button = new JButton("��ѯ");
		button.setFont(new Font("����",Font.BOLD,12));
		
		inputJPanel.add(nameField);
		inputJPanel.add(button);
		//�������-��ѯ��ʽ
		JPanel methodJPanel = new JPanel();
		JPanel methodJPanel_2 = new JPanel();
		
		JLabel label1 = new JLabel("��ѯ��ʽ��");
		label1.setFont(new Font("����", Font.BOLD, 12));
		methodJPanel_2.add(label1);
		
		JRadioButton jRadioButton1 = new JRadioButton("ISBN");
		jRadioButton1.setFont(new Font("����", Font.BOLD, 12));
		jRadioButton1.setSelected(true);
		methodJPanel_2.add(jRadioButton1);
		
		JRadioButton jRadioButton2 = new JRadioButton("����");
		jRadioButton2.setFont(new Font("����", Font.BOLD, 12));
		methodJPanel_2.add(jRadioButton2);
		
		JRadioButton jRadioButton3 = new JRadioButton("ȫ��");
		jRadioButton3.setFont(new Font("����", Font.BOLD, 12));
		methodJPanel_2.add(jRadioButton3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioButton2);
		buttonGroup.add(jRadioButton3);
		methodJPanel.add(methodJPanel_2);

		JLabel endJLabel = new JLabel("��ѯ�����");
		JLabel notes = new JLabel();
		JPanel endnotes = new JPanel();
		endnotes.add(endJLabel);
		endnotes.add(notes);
		notes.setFont(new Font("����",Font.BOLD,14));
		
		notes.setForeground(Color.red);
		endJLabel.setFont(new Font("����",Font.PLAIN,14));
		
		findJPanel.add(endnotes,BorderLayout.SOUTH);
		findJPanel.add(inputJPanel,BorderLayout.NORTH);
		findJPanel.add(methodJPanel,BorderLayout.CENTER);
		
		
		this.add(findJPanel);
		//��ʾ������
		JPanel endJPanel = new JPanel();//��ʾ��ѯ��� ���	
		JPanel tableJPanel = new JPanel();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();//������
		scrollPane_1_1.setBounds(0, 148, 685, 249);
		tableJPanel.add(scrollPane_1_1);
		
		Object[] headrObjects = new Object[] {"���","ISBN","����","����","������","�����","����ʱ��"};
		Object[][] numObjects = {};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(headrObjects);
		//����һ��
		JTable table_1 = new JTable();
		table_1.setModel(model);
		table_1.setPreferredScrollableViewportSize(new Dimension(600,300));
//		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//������Ӧ�ر�
		scrollPane_1_1.setViewportView(table_1);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		/*��������JList list = new JList();//�˷�������Ч������̫��
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("����",Font.BOLD,15));
		scrollPane_1_1.getViewport().setView(list);*/
		//��������
		//��"��ѯ"button ����¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> findResult = new Vector<>();
				model.getDataVector().clear();
			
//				JList list = new JList();
//				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				list.setFont(new Font("����",Font.BOLD,15));				
				String textinputString = nameField.getText().trim();
				nameField.setText("");
				//��ѯ��ʽ��ѡ��
				int isselect = 0;
				if(jRadioButton1.isSelected()) {
					isselect = 1;
				}else if (jRadioButton2.isSelected()) {
					isselect = 2;
				}else if(jRadioButton3.isSelected()) {
					isselect = 3;
				}
				System.out.println("ѡ����Ϊ��" + isselect);
				//�ؼ��ֵ�ѡ��
				if(textinputString.equals("") && isselect != 3) {
					notes.setText("��ѯ����Ϊ�գ�����������");
					System.out.println("��ѯ����Ϊ�գ�����������");
				}
				else {
					System.out.println(textinputString);
					findResult = Work_Model.Service.getBooks(textinputString,isselect);//���յ����ݼ���
					Integer length = findResult.size();
					System.out.println("findResult�Ĵ�СΪ��"+ length);
					if(findResult.isEmpty()) {
						notes.setText("û�м���������������ͼ�飬�����������룡");
						System.out.println("û�м���������������ͼ�飬�����������룡");
						JOptionPane.showMessageDialog(null, "û�м���������������ͼ�飬�����������룡");
					}else {
						notes.setText("����");
//						list.setListData(findResult);//�˷�������Ч������̫��
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
						//��ʾ���յĽ��
//						System.out.println("Find_panel:"+findResult);//�� �ն�������������鿴Ч��
					}	
				}
			}
		});
		endJPanel.add(tableJPanel);
		this.add(endJPanel);
	}	
	public static void main(String[] args) {//������ ֻ��Ϊ�˷���༭�ǲ鿴Ч��
		JFrame frame = new JFrame("��Ϣ��ѯ ���� Frame");
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new Find_panel());
		frame.setSize(800,500);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);;
		frame.setVisible(true);
	}
}
