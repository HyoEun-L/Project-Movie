
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JPanel{	
	private MainFrame mf;
	private JPanel Main, imgPanel;
	private JButton reservation, check;

	
	public Main(MainFrame mf) {
		this.mf = mf;
		this.Main = this;
		
				
		// ��� �г�
		Main = new JPanel();
		setLayout(null);
		setBackground(Color.white);		

		
		// ��ư ���� - ����, ��ȸ 
		Font font = new Font("���� ���", Font.BOLD, 40);
				
		reservation = new JButton("����");
		reservation.setFont(font);
		reservation.setForeground(Color.white);
		reservation.setBackground(new Color(33, 150, 83));
		reservation.setBounds(0, 0, 380, 200);

		
		check = new JButton("��ȸ");
		check.setFont(font);
		check.setForeground(Color.white);
		check.setBackground(new Color(33, 150, 83));
		check.setBounds(385, 0, 410, 200);
		
		
		// �̹��� ��
		imgPanel = new JPanel();
		imgPanel.setBackground(Color.white);
		imgPanel.setBounds(45, 180, 700, 260 );
		Image img = new ImageIcon("movie.png").getImage().getScaledInstance(300, 250, 0);
		JLabel imgLabel = new JLabel(new ImageIcon(img));
		imgPanel.add(imgLabel);
		
		
		// ��ư Ŭ�� �׼� - ȸ��, ��ȸ�� ���� �������� �̵�
		// ���� 
		reservation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WaitingR(mf);
				setVisible(false);				
			}
		});
		
		
		// ��ȸ
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WaitingC(mf);		// ��ư Ŭ�� �� Ŭ���� ��ȯ
				setVisible(false);	// ���� â ������ �ʰ�
			}
		});
		
	
		add(reservation);
		add(check);
		add(imgPanel);		
	
		
		mf.add(this);
	}

}


