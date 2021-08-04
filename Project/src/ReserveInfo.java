import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReserveInfo extends JPanel {

	private MainFrame mf;
	private JPanel ReserveInfo;

	public ReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.ReserveInfo = this;
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		
		
		Font font = new Font("���� ���", Font.BOLD, 15);
		
		// �� �гο� ����
		JLabel lb = new JLabel("���� ��ȣ �Է� : ");
		lb.setBounds(15, 18, 200, 50);
		lb.setFont(font);
		this.add(lb);
		// �ؽ�Ʈ �ʵ� ���� �� �гο� ����
		JTextField text = new JTextField(15);
		text.setBounds(130, 28, 150, 30);
		this.add(text);

		// ��ư ����
		JButton btn = new JButton("Ȯ��");
		btn.setFont(font);
		btn.setBounds(280, 28, 80, 30);
		btn.setForeground(Color.white);
		btn.setBackground(new Color(33, 150, 83));
		
		this.add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �ؽ�Ʈ ���ڷ� �ٽ� ��Ŀ�� ��������
				text.requestFocus();

				// ***������ȸ ���� �ҷ����� �ڵ� �ۼ�

			}
		});


		// ����ȭ������ ���ư��� ��ư ����
		JButton btn1 = new JButton("���� ȭ��");
		btn1.setFont(font);
		btn1.setBounds(680, 32, 100, 30);
		btn1.setForeground(Color.white);
		btn1.setBackground(new Color(33, 150, 83));

		this.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();   
				setVisible(false); 

			}

		});

		// ���������ӿ� �г� �߰�
		mf.add(this);

	}

}
