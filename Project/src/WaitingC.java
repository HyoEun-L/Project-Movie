import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitingC extends JPanel{	//��ȸ
	private MainFrame mf;
	private JPanel WaitingC;
	
	public WaitingC(MainFrame mf) {
		this.mf = mf;
		this.WaitingC = this;
		
		// �г�
		WaitingC = new JPanel();
		setLayout(null);
		setBackground(Color.white);	

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
		// ȸ�� - ��ȸ �α��� �������� �̵�
		member.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginC(mf);		// ��ư Ŭ�� �� Ŭ���� ��ȯ
				setVisible(false);	// ���� â ������ �ʰ�
			}
		});
				
		
		// ��ȸ�� - ��ȸ �������� �̵�
		Nmem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new Waiting();		// ��ư Ŭ�� �� Ŭ���� ��ȯ
				setVisible(false);	// ���� â ������ �ʰ�
			}
		});
		
			
		add(member);
		add(Nmem);
		add(back);
		
		mf.add(this);
	}
}
