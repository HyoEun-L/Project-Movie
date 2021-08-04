import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Waiting2 extends JFrame{	//��ȸ
	public Waiting2() {
		
		this.setTitle("��� ȭ��");
		this.setBounds(600, 250, 800, 500);
		this.setResizable(false);
		
		// ������ �̹��� ����
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ����г�
		JPanel back = new JPanel();	
		
		// ��ư ����- ȸ��, ��ȸ��
		Font font = new Font("���� ���", Font.BOLD, 40);
		
		JButton member = new JButton();
		member.setText("ȸ��");
		member.setFont(font);
		member.setForeground(Color.white);
		member.setBounds(70, 120, 300, 200);
		member.setBackground(new Color(33, 150, 83));
		
		JButton Nmem = new JButton();
		Nmem.setText("��ȸ��");
		Nmem.setFont(font);
		Nmem.setForeground(Color.white);
		Nmem.setBounds(420, 120, 300, 200);
		Nmem.setBackground(new Color(33, 150, 83));
		
		// ��ư Ŭ�� �׼�
		// ȸ�� - �α��� �������� �̵�
		member.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();		// ��ư Ŭ�� �� Ŭ���� ��ȯ
				setVisible(false);	// ���� â ������ �ʰ�
			}
		});
				
		
		// ��ȸ�� - ���� �������� �̵�
		Nmem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new Waiting();		// ��ư Ŭ�� �� Ŭ���� ��ȯ
				setVisible(false);	// ���� â ������ �ʰ�
			}
		});
		
			
		this.add(member);
		this.add(Nmem);
		this.add(back);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
