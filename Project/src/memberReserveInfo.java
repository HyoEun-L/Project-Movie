

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



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
			
		JButton checkbt = new JButton("Ȯ ��");
		checkbt.setBounds(350, 380, 90, 40);
		checkbt.setFont(checkbt.getFont().deriveFont(15.0f));
		checkbt.setForeground(Color.white);
		checkbt.setBackground(new Color(33, 150, 83));
		checkbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(checkbt);
		
		// Ȯ�ι�ư Ŭ���� ����ȭ�� ������??
		//checkbt.addActionListener(new myAction()); 
		
		// �ϴ� Ȯ�� ��ư Ŭ���� ��ȸ�� ���� ��� => ��ȸ�Ǹ� ��ȸ��ư �߰�����
		checkbt.addActionListener(new Myevent());
		
		JPanel reList = new JPanel();
		reList.setBounds(0, 100, 800, 260);
		this.add(reList);
		
		JLabel list1 = new JLabel();
		list1.setText("����");
		JLabel list2 = new JLabel();
		list2.setText("��¥");
		JLabel list3 = new JLabel();
		list3.setText("��ȭ");
		JLabel list4 = new JLabel();
		list4.setText("�ð�");
		JLabel list5 = new JLabel();
		list5.setText("�¼�");
		JLabel list6 = new JLabel();
		list6.setText("�����ȣ");
		
		list1.setBounds(60, 70, 100, 20);
		list2.setBounds(150, 70, 100, 20);
		list3.setBounds(290, 70, 100, 20);
		list4.setBounds(420, 70, 100, 20);
		list5.setBounds(540, 70, 100, 20);
		list6.setBounds(650, 70, 100, 20);
		
		this.add(list1);
		this.add(list2);
		this.add(list3);
		this.add(list4);
		this.add(list5);
		this.add(list6);
		
		for(int i = 0; i < uif.size(); i++) {
		  // �Էµ� ���̵� ����� ���̶� ������ Ȯ�� ��
    	  if(uif.get(i).getUserID().equals(idT.getText())) {   
    		   for(int j=0; j <= i; j++) {
    			   int count = 1;
    			   // ����
    			   JLabel relabel1 = new JLabel(count++ +"");
    			   relabel1.setBounds(60, (70 + (j*30)), 100, 20);
    			   reList.add(relabel1);
    			   // ��¥
    			   JLabel relabel2 = new JLabel(uif.get(i).getmDate());
    			   relabel2.setBounds(150, (70 + (j*30)), 100, 20);
    			   reList.add(relabel2);
    			   // ����
    			   JLabel relabel3 = new JLabel(uif.get(i).getmTitle());
    			   relabel3.setBounds(290, (70 + (j*30)), 100, 20);
    			   reList.add(relabel3);
    			   // �ð�
    			   JLabel relabel4 = new JLabel(uif.get(i).getmTime());
    			   relabel4.setBounds(420, (70 + (j*30)), 100, 20);
    			   reList.add(relabel4);
    			   // �¼�
    			   JLabel relabel5 = new JLabel(uif.get(i).getmSeat());
    			   relabel5.setBounds(540, (70 + (j*30)), 100, 20);
    			   reList.add(relabel5);
    			   // �����ȣ
    			   JLabel relabel6 = new JLabel(uif.get(i).getmNumber());
    			   relabel6.setBounds(650, (70 + (j*30)), 100, 20);
    			   reList.add(relabel6);
    		   }
    	  	}
		}
		
		
		// ���������ӿ� �߰�
		mf.add(this);
	}
	
	

	class Myevent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
	
			try(DataInputStream dis = new DataInputStream(new FileInputStream("user.txt"))){
				
				while(true) {
					String userID = dis.readUTF();
					String userPW = dis.readUTF();
					String userName = dis.readUTF();
					String userPhone = dis.readUTF();
					String mDate = dis.readUTF();
					String mTitle = dis.readUTF();
					String mTime = dis.readUTF();
					String mSeat = dis.readUTF();
					String mNumber = dis.readUTF();
					
					
					uif.add(new UserInfo(userID, userPW, userName, userPhone, mDate, mTitle, mTime, mSeat, mNumber));
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				//JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�Ǿ����ϴ�.", " ", JOptionPane.ERROR_MESSAGE);
			} catch (EOFException e) {
				// ��� �� ������ ����....
				e.printStackTrace();
			//	JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�Ǿ����ϴ�.", " ", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

  
