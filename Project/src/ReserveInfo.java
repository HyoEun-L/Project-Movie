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

public class ReserveInfo extends JFrame {

	public ReserveInfo() {

		// ������ ��ġ�� ũ�� �� ���� ���� (x, y, width, height)
		this.setBounds(600, 250, 800, 500);

		// ������ ��ܿ� �̸� ����
		this.setTitle("��ȭ ���� ���� ��ȸ");
		
		// ������ �̹��� ����
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// �г� ����
		JPanel panel = new JPanel();
		
		Font font = new Font("���� ���", Font.BOLD, 15);
		
		// �� �гο� ����
		JLabel lb = new JLabel("���� ��ȣ �Է� : ");
		lb.setFont(font);
		panel.add(lb);
		// �ؽ�Ʈ �ʵ� ���� �� �гο� ����
		JTextField text = new JTextField(15);
		panel.add(text);

		// ��ư ����
		JButton btn = new JButton("Ȯ��");
		btn.setFont(font);
		btn.setForeground(Color.white);
		btn.setBackground(new Color(33, 150, 83));
		
		panel.add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �ؽ�Ʈ ���ڷ� �ٽ� ��Ŀ�� ��������
				text.requestFocus();
				
				// ***������ȸ ���� �ҷ����� �ڵ� �ۼ�
				
				

			}
		});

		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}



}
