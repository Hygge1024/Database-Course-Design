package Demo;

import javax.swing.JOptionPane;
//测试javax.swing.JOptionPane 中提供的常用有模式对话框（标准对话框）
public class J_DialogMode {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "您好！");
		JOptionPane.showConfirmDialog(null, "您现在还好吗？");
		JOptionPane.showInputDialog(null, "您现在还好吗？");
		String [] s = {"好","不好"};
		JOptionPane.showInputDialog(null, "您现在还好吗？", "输入",JOptionPane.QUESTION_MESSAGE,null,s,s[0]);
		
 	}
}
