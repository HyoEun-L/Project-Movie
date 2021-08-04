
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Join extends JFrame{
	private JTextField idT;
	private JTextField pwT;
	private JTextField nameT;
	private JTextField telT;
	
	public Join() {
		this.setTitle("ȸ������");
		this.setBounds(600, 250, 800, 500);
		
		// ������ �̹��� ����
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JPanel bigPanel = new JPanel();
		
		// �г� ����
		JPanel panel = new JPanel();
		
		// ��Ʈ
		Font font1 = new Font("���� ���", Font.BOLD, 23);
		Font font2 = new Font("���� ���", Font.PLAIN, 20);
		
		// id
		JLabel idL = new JLabel();
		//idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setText("                   ID");
		idL.setFont(font1);
		idL.setForeground(new Color(33, 150, 83));
		
		idT = new JTextField(10);
		idT.setFont(font2);	
		
		// pw
		JLabel pwL = new JLabel();
		pwL.setText("         Password");
		pwL.setFont(font1);
		pwL.setForeground(new Color(33, 150, 83));
		
		pwT = new JPasswordField(10);
		pwT.setFont(font2);	
		
		// name
		JLabel nameL = new JLabel();
		nameL.setText("              Name");
		nameL.setFont(font1);
		nameL.setForeground(new Color(33, 150, 83));
		
		nameT = new JTextField(10);
		nameT.setFont(font2);		
		
		// tel
		JLabel telL = new JLabel();
		telL.setText("                 Tel");
		telL.setFont(font1);
		telL.setForeground(new Color(33, 150, 83));
		
		telT = new JTextField(10);
		telT.setFont(font2);	
		
		JLabel tab = new JLabel();
		tab.setText("* * * * * * * * * * *");
		tab.setFont(font1);
		tab.setForeground(new Color(33, 150, 83));
		
		// ��ư		
		JButton join = new JButton();
		join.setText("ȸ������");
		join.setFont(font1);
		join.setForeground(Color.white);
		join.setBackground(new Color(33, 150, 83));
	
		
		// ��ư �׼� - ȸ�� ���� �����ϰ� ���� �������� �̵�
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(idT.getText().isEmpty() || pwT.getText().isEmpty() || nameT.getText().isEmpty() || telT.getText().isEmpty()) { 
					return;
				} else {
					fileSave();
					new Login();
				}
				setVisible(false);
			}
		});
		
				
		// �гο� �ø���
		panel.add(idL);
		panel.add(idT);
		panel.add(pwL);
		panel.add(pwT);
		panel.add(nameL);
		panel.add(nameT);
		panel.add(telL);
		panel.add(telT);
		panel.add(tab);
		panel.add(join);
				
		panel.setPreferredSize(new Dimension(200, 400));
		bigPanel.add(panel);

	
		// �����ӿ� �ø���
		this.add(bigPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	// ȸ�� ���� ���� ����
	public void fileSave() {
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
			dout.writeUTF(idT.getText());
			dout.writeUTF(pwT.getText());
			dout.writeUTF(nameT.getText());
			dout.writeUTF(telT.getText());		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Join();
	}
	
}
