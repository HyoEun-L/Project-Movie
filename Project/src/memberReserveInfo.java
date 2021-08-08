

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class memberReserveInfo extends JPanel {
	

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
	
	private JLabel relabel1;
	private JLabel relabel2;
	private JLabel relabel3;
	private JLabel relabel4;
	private JLabel relabel5;
	private JLabel relabel6;
	private JLabel relabel7;

	private String[] str; 
	private JLabel[] labelbt;
	
	
	public memberReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.memberReserveInfo= this;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		Font hfont = new Font("�������", Font.BOLD, 30);
		Font tfont = new Font("�������", Font.BOLD, 15);
		Font font = new Font("�������", Font.BOLD, 13);
		
		JLabel label = new JLabel("ȸ�� ���� ����", JLabel.CENTER);
		label.setFont(hfont);
		label.setBounds(190, 8, 400, 50);
		this.add(label);
		
		JButton backbt = new JButton("��  ��");
		backbt.setBounds(60, 10, 80, 40);
		backbt.setFont(font);
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
		checkbt.setFont(tfont);
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
		
		list1.setBounds(20, 80, 100, 20);  // ����
		list2.setBounds(100, 80, 100, 20); // ��¥
		list3.setBounds(240, 80, 100, 20); // ��ȭ
		list4.setBounds(354, 80, 100, 20); // �ð�
		list5.setBounds(455, 80, 100, 20); // �¼�
		list6.setBounds(553, 80, 100, 20); // ����
		list7.setBounds(650, 80, 100, 20); // �����ȣ
		
		list1.setFont(font);
		list2.setFont(font);
		list3.setFont(font);
		list4.setFont(font);
		list5.setFont(font);
		list6.setFont(font);
		list7.setFont(font);
		
		this.add(list1);
		this.add(list2);
		this.add(list3);
		this.add(list4);
		this.add(list5);
		this.add(list6);
		this.add(list7);
		
		relabel1 = new JLabel("", JLabel.CENTER);
		relabel2 = new JLabel("", JLabel.CENTER);
		relabel3 = new JLabel("", JLabel.CENTER);
		relabel4 = new JLabel("", JLabel.CENTER);
		relabel5 = new JLabel("", JLabel.CENTER);
		relabel6 = new JLabel("", JLabel.CENTER);
		relabel7 = new JLabel("", JLabel.CENTER);			
		relabel1.setFont(font);
		relabel2.setFont(font);
		relabel3.setFont(font);
		relabel4.setFont(font);
		relabel5.setFont(font);
		relabel6.setFont(font);
		relabel7.setFont(font);
		
		this.add(relabel1);
		this.add(relabel2);
		this.add(relabel3);
		this.add(relabel4);
		this.add(relabel5);
		this.add(relabel6);
		this.add(relabel7);
		
		// ��ȸ ��ư Ŭ���� ��ȸ�� ���� ���
		checkbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkbt.setEnabled(false);
				try (BufferedReader br = new BufferedReader(new FileReader("movie.txt"))) {
					
					String line = "";
					while((line = br.readLine()) != null) {
						
						str = line.split(",");
						for(int i= 0; i < str.length/6; i++) {
							mif.add(new MovieInfo(str[i*6], str[(i*6)+1], str[(i*6)+2], str[(i*6)+3], str[(i*6)+4], str[(i*6)+5]));
						}		
						resultinfo();
					}
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Filenot", " ", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// ���������ӿ� �߰�
		mf.add(this);
	}
	
	public void resultinfo() {
		// ���� ȭ�� ��¿�
		try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
			
			String line = "";
			while((line = br.readLine()) != null) {	
				
				String[] str = line.split(",");	
				for(int i= 0; i < str.length/4; i++) {
					uif.add(new UserInfo(str[i*4], str[(i*4)+1], str[(i*4)+2], str[(i*4)+3], str[(i*4)+4]));
				}			
				for(int i = 0; i < uif.size(); i++) {
					if(uif.get(i).getuNumber().contains(mif.get(i).getmNumber())) {
						relabel1.setText((i+1)+"");
						relabel1.setBounds(20, 130+(i*40), 100, 20);
						relabel2.setText(mif.get(i).getmDate());
						relabel2.setBounds(103, 130+(i*40), 100, 20);
						relabel3.setText(mif.get(i).getmTitle());
						relabel3.setBounds(193, 130+(i*40), 200, 20);
						relabel4.setText(mif.get(i).getmTime());
						relabel4.setBounds(355, 130+(i*40), 100, 20);
						relabel5.setText(mif.get(i).getmSeat());
						relabel5.setBounds(455, 130+(i*40), 100, 20);
						relabel6.setText(mif.get(i).getmLocation());
						relabel6.setBounds(555, 130+(i*40), 100, 20);
						relabel7.setText(mif.get(i).getmNumber());
						relabel7.setBounds(650, 130+(i*40), 100, 20);
					} else {
						JOptionPane.showMessageDialog(null, "����� ������ �����ϴ�.", "File Not", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}	
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Filenot", " ", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
	
	
