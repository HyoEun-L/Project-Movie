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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel /*implements Serializable*/ {

	private MainFrame mf;
	private JPanel ReserveInfo;
	private JLabel infoTitle;
	JTextField text;
	JLabel re;
	int i;

	// MovieInfo
	private List<MovieInfo> mif = new ArrayList<>();
	
	private JPanel reList; // ���� ��µ� �г�
	/*
	 * 	
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

	public ReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.ReserveInfo= this;

		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		System.out.println(mif.size());
		
		// �� �гο� ����
		JLabel label = new JLabel("���� ��ȣ �Է� : ");
		label.setBounds(15, 15, 200, 50);
		label.setFont(label.getFont().deriveFont(15.0f));
		this.add(label);
 
		// �ؽ�Ʈ �ʵ� ���� �� �гο� ����
		JTextField text = new JTextField(15);
		text.setBounds(132, 22, 150, 30);
		this.add(text);
		
		JLabel re = new JLabel(" "); // ���� ���Ź�ȣ Ʋ�� �� ���� ���� "��ȣ�� �ٽ� Ȯ�����ֽʽÿ�."��.
		re.setBounds(380, 15, 300, 50);
		re.setFont(label.getFont().deriveFont(15.0f));
		re.setForeground(Color.GREEN);
		this.add(re);
	 
		
		JButton backbt = new JButton("��  ��");
		backbt.setBounds(670, 10, 80, 40);
		backbt.setBackground(Color.white);
		backbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backbt);
		// ������ư Ŭ���� ���� ������
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
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
			// �ؽ�Ʈ ���ڷ� �ٽ� ��Ŀ�� ��������
			text.requestFocus();
						
			minfo(); // ��������
					
			int index = -1; //for���� 0���� ���� ������ index�� 0���� �����ϸ� ���� ã�� ���� �迭�� ��� ���� ���� �ʾƵ� ��µ� �� �ֱ� ����.
			for(int i = 0; i < mif.size(); i++) {   //mif��� ��ü�迭 ��ü ũ�⸸ŭ ���Ƽ�
				if(text.equals(mif.get(i).getmNumber()/*���Ź�ȣ*/){  //�̹� ������ִ� ���Ź�ȣ�� ����ڿ��� �Է¹��� text�� ��ġ�ϴ��� ���� Ȯ�� 
					index = i;
				}
			}
			if(index > -1) { //��ġ ���� �־ �ε����� ���� ���ߴٸ�, ��ġ�� i��° ���� ��� ������ JLabel�� �ְ� ��ġ�����Ͽ� �����ش�.(���Ź�ȣ�� �ߺ����� �����Ƿ� �迭��� �� ��)
				int count = 1;
				   // ����
				   JLabel relabel1 = new JLabel(count++ +"", JLabel.CENTER);
				   relabel1.setBounds(30, (20 + (30)), 100, 20);
				   reList.add(relabel1);
				   // ��¥
				   JLabel relabel2 = new JLabel(mif.get(i).getmDate1(), JLabel.CENTER);
				   relabel2.setBounds(100, (20 + (30)), 100, 20);
				   reList.add(relabel2);
				   // ����
				   JLabel relabel3 = new JLabel(mif.get(i).getmTitle(), JLabel.CENTER);
				   relabel3.setBounds(240, (20 + (30)), 200, 20);
				   reList.add(relabel3);
				   // �ð�
				   JLabel relabel4 = new JLabel(mif.get(i).getmTime(), JLabel.CENTER);
				   relabel4.setBounds(380, (20 + (30)), 100, 20);
				   reList.add(relabel4);
				   // �¼�
				   JLabel relabel5 = new JLabel(mif.get(i).getmSeat(), JLabel.CENTER);
				   relabel5.setBounds(480, (20 + (30)), 100, 20);
				   reList.add(relabel5);
				   // ����
				   JLabel relabel6 = new JLabel(mif.get(i).getmLocation(), JLabel.CENTER);
				   relabel6.setBounds(590, (20 + (30)), 100, 20);
				   reList.add(relabel6);
				   // �����ȣ
				   JLabel relabel7 = new JLabel(mif.get(i).getmNumber, JLabel.CENTER);
				   relabel7.setBounds(640, (20 + (30)), 100, 20);
				   reList.add(relabel7);			
				  
			}else { // �ߺ��Ǵ� ���� ���� ���
				re.setText("��ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�."); // false�� �� ��ȣ�� �ٽ� Ȯ���ش޶�� �� ���					
			}
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
				//String mNumber = dis.readUTF(); //���Ź�ȣ
				
				mif.add(new MovieInfo(mDate, mLocation, mTitle, mTime, mSeat, mNumber));			
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

  
