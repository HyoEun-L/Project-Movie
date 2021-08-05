
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReserveInfo extends JPanel {  // ��ȸ�� ���ų��� ��ȸ, ���Ź�ȣ �Է� ����.

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

		// ������ư
		JButton backBt = new JButton("��  ��");
		backBt.setBounds(350, 380, 90, 40);
		backBt.setBackground(Color.white);
		backBt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backBt);
		// ������ư Ŭ���� ����ȭ�� ������??
		backBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ȭ������
				// new Main(mf);
				new MainFrame();
				setVisible(false);
			}
		});
		

		// ��ȸ���� �ö� �г�
		JPanel jj = new JPanel();
		this.add(jj);
		// jj.setSize(50, 50);
		jj.setBounds(0, 100, 800, 260);

		JLabel info1 = new JLabel("����", JLabel.CENTER);
		info1.setBounds(50, 70, 50, 20);
		JLabel info2 = new JLabel("�����ȣ", JLabel.CENTER);
		info2.setBounds(130, 70, 100, 20);
		JLabel info3 = new JLabel("��ȭ", JLabel.CENTER);
		info3.setBounds(280, 70, 100, 20);
		JLabel info4 = new JLabel("�ð�", JLabel.CENTER);
		info4.setBounds(460, 70, 100, 20);
		JLabel info5 = new JLabel("�¼�", JLabel.CENTER);
		info5.setBounds(630, 70, 100, 20);

		this.add(info1);
		this.add(info2);
		this.add(info3);
		this.add(info4);
		this.add(info5);
		mf.add(this);
		
		

		// ���������ӿ� �г� �߰�
		mf.add(this);

	}

}
