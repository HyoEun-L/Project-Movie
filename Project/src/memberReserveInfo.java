

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class memberReserveInfo extends JPanel /*implements Serializable*/ {
	

	private MainFrame mf;
	private JPanel memberReserveInfo;
	private JLabel infoTitle;

	// �Էµ� ��
	private JTextField idT;
	private JTextField pwT;
	private JTextField nameT;
	private JTextField telT;
	// UserInfo
	private List<UserInfo> uif = new ArrayList<>();
	private List<MovieInfo> mif = new ArrayList<>();
	
	private JPanel reList; // ���� ��µ� �г�
	/*
	private String userID;
	private String userPW;
	private String userName;
	private String userPhone;
	private String mDate;
	private String mTitle;
	private String mTime;
	private String mSeat;
	private String mNumber;
	*/
	
	public memberReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.memberReserveInfo= this;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel label = new JLabel();
		label.setText("ȸ�� ���� ����");
		label.setFont(label.getFont().deriveFont(30.0f));  // �۾�ũ��
		label.setBounds(290, 8, 400, 50);
		this.add(label);
		
		JButton backbt = new JButton("��  ��");
		backbt.setBounds(60, 10, 80, 40);
		backbt.setBackground(Color.white);
		backbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backbt);
		// ������ư Ŭ���� ���� ������
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main(mf);
				setVisible(false);
			}
		});
			
		JButton checkbt = new JButton("�� ȸ");
		checkbt.setBounds(350, 380, 90, 40);
		checkbt.setFont(checkbt.getFont().deriveFont(15.0f));
		checkbt.setForeground(Color.white);
		checkbt.setBackground(new Color(33, 150, 83));
		checkbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(checkbt);
		
		
		JLabel list1 = new JLabel("����", JLabel.CENTER);
		JLabel list2 = new JLabel("��¥", JLabel.CENTER);
		JLabel list3 = new JLabel("��ȭ",JLabel.CENTER);
		JLabel list4 = new JLabel("�ð�", JLabel.CENTER);
		JLabel list5 = new JLabel("�¼�", JLabel.CENTER);
		JLabel list6 = new JLabel("����", JLabel.CENTER);
		JLabel list7 = new JLabel("�����ȣ", JLabel.CENTER);
		
		
		list1.setBounds(30, 70, 100, 20); // ����
		list2.setBounds(100, 70, 100, 20); // ��¥
		list3.setBounds(240, 70, 100, 20); // ��ȭ
		list4.setBounds(380, 70, 100, 20); // �ð�
		list5.setBounds(480, 70, 100, 20); // �¼�
		list6.setBounds(590, 70, 100, 20); // ����
		list7.setBounds(640, 70, 100, 20); // �����ȣ
		
		this.add(list1);
		this.add(list2);
		this.add(list3);
		this.add(list4);
		this.add(list5);
		this.add(list6);
		this.add(list7);
		
		// ��ȸ ��ư Ŭ���� ��ȸ�� ���� ���
		checkbt.addActionListener(new Myevent());
		reList = new JPanel();
		reList.setBounds(0, 100, 800, 260);
		reList.setLayout(null);
		this.add(reList);
		
		// ���������ӿ� �߰�
		mf.add(this);
	}



	class Myevent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			uinfo(); // ȸ������
			minfo(); // ��������
			
			int count = 1;
			for(int i = 0; i < uif.size(); i++) {
			   // ����
			   JLabel relabel1 = new JLabel(count++ +"", JLabel.CENTER);
			   relabel1.setBounds(30, (20 + (i*30)), 100, 20);
			   reList.add(relabel1);
			   // ��¥
			   JLabel relabel2 = new JLabel(mif.get(i).getmDate1(), JLabel.CENTER);
			   relabel2.setBounds(100, (20 + (i*30)), 100, 20);
			   reList.add(relabel2);
			   // ����
			   JLabel relabel3 = new JLabel(mif.get(i).getmTitle(), JLabel.CENTER);
			   relabel3.setBounds(240, (20 + (i*30)), 200, 20);
			   reList.add(relabel3);
			   // �ð�
			   JLabel relabel4 = new JLabel(mif.get(i).getmTime(), JLabel.CENTER);
			   relabel4.setBounds(380, (20 + (i*30)), 100, 20);
			   reList.add(relabel4);
			   // �¼�
			   JLabel relabel5 = new JLabel(mif.get(i).getmSeat(), JLabel.CENTER);
			   relabel5.setBounds(480, (20 + (i*30)), 100, 20);
			   reList.add(relabel5);
			   // ����
			   JLabel relabel6 = new JLabel(mif.get(i).getmLocation(), JLabel.CENTER);
			   relabel6.setBounds(590, (20 + (i*30)), 100, 20);
			   reList.add(relabel6);
			   // �����ȣ
			   JLabel relabel7 = new JLabel("12345", JLabel.CENTER);
			   relabel7.setBounds(640, (20 + (i*30)), 100, 20);
			   reList.add(relabel7);
			}	
		}
	}
	
	
	// ���� �����о����
	public void uinfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("user.txt"))){
			
			while(true) {
				String userID = dis.readUTF();
				String userPW = dis.readUTF();
				String userName = dis.readUTF();
				String userPhone = dis.readUTF();
				//String renumber = dis.readUTF();  //�����ȣ => ���߿� ���ర���� Ȯ��
				
				uif.add(new UserInfo(userID, userPW, userName, userPhone)); // ���� ���о�ͼ� eofec���
			}
				
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�Ǿ����ϴ�.", "", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void minfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("movie.txt"))){
			
			while(true) {
				
				String mDate = dis.readUTF(); // ��¥ �ϳ��� ��ħ
				String mLocation = dis.readUTF();
				String mTitle = dis.readUTF();
				String mTime = dis.readUTF();
				String mSeat = dis.readUTF();
				//String mNumber = dis.readUTF(); //�����ȣ
				
				mif.add(new MovieInfo(mDate, mLocation, mTitle, mTime, mSeat));
				
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			//JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�Ǿ����ϴ�.", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

  
