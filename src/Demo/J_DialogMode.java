package Demo;

import javax.swing.JOptionPane;
//����javax.swing.JOptionPane ���ṩ�ĳ�����ģʽ�Ի��򣨱�׼�Ի���
public class J_DialogMode {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "���ã�");
		JOptionPane.showConfirmDialog(null, "�����ڻ�����");
		JOptionPane.showInputDialog(null, "�����ڻ�����");
		String [] s = {"��","����"};
		JOptionPane.showInputDialog(null, "�����ڻ�����", "����",JOptionPane.QUESTION_MESSAGE,null,s,s[0]);
		
 	}
}
