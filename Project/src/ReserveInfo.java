
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel { // ��ȸ�� ���ų��� ��ȸ, ���Ź�ȣ �Է� ����.

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
		
		JLabel re = new JLabel(" "); // ���� ���Ź�ȣ Ʋ�� �� ���� ���� ��.
		re.setBounds(380, 15, 300, 50);
		re.setFont(font);
		re.setForeground(Color.GREEN);
		this.add(re);

		
		// ��ư Ŭ�� �� ���� ���� �ҷ���.
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ؽ�Ʈ ���ڷ� �ٽ� ��Ŀ�� ��������
				text.requestFocus();

		
				// if���� ����Ͽ� true�� �� �������� ���� �ҷ�����, ���ǹ��� text�� ���Ź�ȣ(ŸŬ�������� �̹� ���� �� 5�ڸ� ����)��Ī ���� Ȯ��
				if (text.equals(text/*���� movieŬ������ ���Ź�ȣ ������ ������ ��.*/)) {
					try(DataInputStream dis = new DataInputStream(new FileInputStream("movie.txt"))){				
						while(true) {
							String nonuserNumber = dis.readUTF();  //��ȸ�� ����5�ڸ� ���Ź�ȣ ���� nonuserNumber�� �켱 ������. ���� Ȯ�� ������ ����.
							String mDate = dis.readUTF();
							String mLocation = dis.readUTF();
							String mTitle = dis.readUTF();
							String mTime = dis.readUTF();
							String mSeat = dis.readUTF();
							String mNumber = dis.readUTF();				
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}			
				// ����� �Է� �� ��ȣ �ٽ� Ȯ���ش޶�� �� ȭ�鿡�� �����.						
			    re.setText(" "); 
			    
			   
				} else {
					re.setText("��ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�."); // false�� �� ��ȣ�� �ٽ� Ȯ���ش޶�� �� ���	
				}
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

