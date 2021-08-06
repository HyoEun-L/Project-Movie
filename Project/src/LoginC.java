import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginC extends JPanel{
	private MainFrame mf;
	private JPanel LoginC;
	private JButton login, join;
	private JTextField idT, pwT;
	
	public LoginC(MainFrame mf) {
		this.mf = mf;
		this.LoginC = this;

		LoginC = new JPanel();
		setLayout(null);
		setBackground(Color.white);	

		Font font = new Font("���� ���", Font.BOLD, 25);
		Font font2 = new Font("���� ���", Font.PLAIN, 20);

		// ��
		JLabel idL = new JLabel();
		idL.setBounds(170, 130, 60, 50);
		idL.setText("ID");
		idL.setFont(font);
		idL.setForeground(new Color(33, 150, 83));

		JLabel pwL = new JLabel();
		pwL.setBounds(170, 210, 60, 50);
		pwL.setText("PW");
		pwL.setFont(font);
		pwL.setForeground(new Color(33, 150, 83));

		// �ؽ�Ʈ �ʵ�
		idT = new JTextField(10);
		idT.setBounds(245, 140, 200, 30);
		idT.setFont(font2);

		pwT = new JPasswordField(10);
		pwT.setBounds(245, 220, 200, 30);
		pwT.setFont(font2);

		login = new JButton();
		login.setBounds(480, 130, 140, 50);
		login.setText("�α���");
		login.setFont(font);
		login.setForeground(Color.white);
		login.setBackground(new Color(33, 150, 83));
		
		join = new JButton();
		join.setBounds(480, 210, 140, 50);
		join.setText("ȸ������");
		join.setFont(font);
		join.setForeground(Color.white);
		join.setBackground(new Color(33, 150, 83));

		add(idL);
		add(idT);
		add(pwL);
		add(pwT);
		add(login);
		add(join);

		login.addActionListener(new userFile());		// �α��� ��ư ������ �α��� ���� or ����
		join.addActionListener(new ActionListener() {   // ȸ������ ������ ���� â����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinC(mf);
				setVisible(false);
			}
		});
		
		mf.add(this);
	}

	private class userFile implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try (DataInputStream din = new DataInputStream(new FileInputStream("user.txt"))) {
				String id = din.readUTF();
				String pw = din.readUTF();

				if (id.equals(idT.getText()) && pw.equals(pwT.getText())) {
					new Date(mf);
					setVisible(false);
					
				} else if (!id.equals(idT.getText())) {
					JOptionPane.showMessageDialog(null, "�������� �ʴ� ȸ���Դϴ�.", " ", JOptionPane.ERROR_MESSAGE);
				} else if (!pw.equals(pwT.getText())) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", " ", JOptionPane.ERROR_MESSAGE);
				}
	
				
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "�������� �ʴ� ȸ���Դϴ�.", " ", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
