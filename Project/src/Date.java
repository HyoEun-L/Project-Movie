
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Date extends JPanel implements ActionListener {
	private MainFrame mf;
	JPanel pnmonth; // Ÿ��Ʋ, �޷�, ��ư �г�
	JLabel month_value;
	JButton[] date_value = new JButton[49];
	JButton left;   // ���� ��ư
	JButton right;  // ������ ��ư
	JButton previous;    // �������� ��ư (����ȭ��)
 	JButton next;		 // �������� ��ư (���� ����)
	calendar calendar = new calendar();
	String dd;
	
	public Date(MainFrame mf) {
		this.mf = mf;
		this.pnmonth = this;
		setLayout(null);
		setBackground(Color.white);
		
		
		
		// ��Ʈ
		Font monthfont = new Font("HY�߰��", Font.PLAIN, 22);    // Ÿ��Ʋ 
		Font dayfont = new Font("�������", Font.BOLD, 18);  		// ���� 
		Font datefont = new Font("�������", Font.PLAIN, 16);		// �� 
		Font btnfont = new Font("�������", Font.BOLD, 13);		// ��ư
		
		
		// Ÿ��Ʋ
		left = new JButton(new ImageIcon("icon/left.png"));  // �������� �ѱ�� ��ư
		left.setBounds(250, 40, 60, 60);
		left.setBorderPainted(false);      // ��ư ��輱 ����
		left.setFocusPainted(false);       // ��ư ������ ǥ�� ����
		left.setContentAreaFilled(false);  // ��ư ���� ��� ����
		pnmonth.add(left); 
		left.addActionListener(this);      // ���� �� ��ư Ŭ��
		
		month_value = new JLabel(); // �޷� �� ǥ��
		month_value.setBounds(330, 40, 180, 60);
		month_value.setFont(monthfont);
		month_value.setText(calendar.getCalText());
		pnmonth.add(month_value);
		
		right = new JButton(new ImageIcon("icon/right.png"));  // ���������� �ѱ�� ��ư
		right.setBounds(470, 40, 60, 60);
		right.setBorderPainted(false);     
		right.setFocusPainted(false);       
		right.setContentAreaFilled(false);  
		pnmonth.add(right);
		right.addActionListener(this);      // ���� �� ��ư Ŭ��
		
		
		
		 // ���� ���� ��ư
		previous = new JButton("��  ��");
		previous.setFont(btnfont);
		previous.setBounds(20, 20, 100, 35);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setForeground(new Color(246, 246, 246));
		previous.setBackground(new Color( 33, 150, 83));
		pnmonth.add(previous);
	
		
		next = new JButton("��  ��");
		next.setFont(btnfont);
		next.setBounds(660, 20, 100, 35);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setBackground(new Color(246, 246, 246));
		next.setForeground(new Color( 33, 150, 83));
		pnmonth.add(next);
		
		
		
		// *** ��ư Ŭ�� �̺�Ʈ ó�� ***
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �α���ȭ��
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȭ ��ȸ ȭ��
			}
		});
		
		
		
		
		
		// Ķ���� (����, ��)
		JPanel pndate = new JPanel();    // ����,��
		pndate.setBackground(Color.white);
		pndate.setLayout(new GridLayout(0,7,5,5));  // ���� �׸��� ���̾ƿ����� ����
		String dd = "";
		
		for(int i =0; i < date_value.length; i++) { 
			String[] d= {"  ��  ", "  ��  ", "  ȭ  ", "  ��  ", "  ��  ", "  ��  ", "  ��  "};
		
			
			date_value[i] = new JButton();
			date_value[i].setFont(datefont);
			date_value[i].setBorderPainted(false);
			date_value[i].setContentAreaFilled(false);
			date_value[i].setFocusPainted(false);
			
			
			if(i < 7) {
				date_value[i].setText(d[i]);
				date_value[i].setFont(dayfont);
				date_value[i].setForeground(Color.green.darker().darker());
			}
		
			pndate.add(date_value[i]);
			dd = date_value[i].getText(); 
		}
		
		
		// Ķ���� ��¥ ���� �̺�Ʈ ó��
		date_value[7].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[7].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "1��";
					System.out.println(dd);
			}
		});
		
		date_value[8].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[8].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "2��";
					System.out.println(dd);
			}
		});
		date_value[9].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[9].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "3��";
					System.out.println(dd);
			}
		});
		date_value[10].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[10].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "4��";
					System.out.println(dd);
			}
		});
		date_value[11].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[11].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "5��";
					System.out.println(dd);
			}
		});
		date_value[12].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[12].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "6��";
					System.out.println(dd);
			}
		});
		date_value[13].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[13].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "7��";
					System.out.println(dd);
			}
		});
		date_value[14].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[14].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "8��";
					System.out.println(dd);
			}
		});
		date_value[15].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[15].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "9��";
					System.out.println(dd);
			}
		});
		
		date_value[16].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[16].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "10��";
					System.out.println(dd);
			}
		});
		date_value[17].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[17].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "11��";
					System.out.println(dd);
			}
		});
		date_value[18].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[18].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "12��";
					System.out.println(dd);
			}
		});date_value[19].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[19].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "13��";
					System.out.println(dd);
			}
		});
		date_value[20].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[20].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "14��";
					System.out.println(dd);
			}
		});
		date_value[21].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[21].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "15��";
					System.out.println(dd);
			}
		});
		date_value[22].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[22].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "16��";
					System.out.println(dd);
			}
		});
		date_value[23].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[23].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "17��";
					System.out.println(dd);
			}
		});
		date_value[24].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[24].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "18��";
					System.out.println(dd);
			}
		});
		date_value[25].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[25].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "19��";
					System.out.println(dd);
			}
		});
		date_value[26].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[26].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "20��";
					System.out.println(dd);
			}
		});
		date_value[27].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[27].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "21��";
					System.out.println(dd);
			}
		});date_value[28].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[28].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "22��";
					System.out.println(dd);
			}
		});
		date_value[29].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[29].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "23��";
					System.out.println(dd);
			}
		});
		date_value[30].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[30].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "24��";
					System.out.println(dd);
			}
		});
		date_value[31].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[31].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "25��";
					System.out.println(dd);
			}
		});
		date_value[32].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[32].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "26��";
					System.out.println(dd);
			}
		});
		date_value[33].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[33].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "27��";
					System.out.println(dd);
			}
		});
		date_value[34].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[34].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "28��";
					System.out.println(dd);
			}
		});
		date_value[35].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[35].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "29��";
					System.out.println(dd);
			}
		});
		date_value[36].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "30��";
					System.out.println(dd);
			}
		});
		
		date_value[37].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "31��";
					System.out.println(dd);	
			}
		});
		
		calendar.setButton(date_value);
		calendar.calSet();
		
		
		
		
		this.add(pnmonth);
		this.add(pndate, "South");
		this.setVisible(true);
		
		mf.add(this);
	}
	
	// ��¥ ���� ���� ���� ���Ͽ� ����   
		public void fileSave() {
			try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
				dout.writeUTF(dd);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == left) {  // ������
			calendar.allInit(-1);
			month_value.setText(calendar.getCalText());
		} else if(e.getSource() == right) {  // ������
			calendar.allInit(1);
			month_value.setText(calendar.getCalText());
		}
		
	}
	
	
	private class calendar {
		Calendar calendar;
		int year;
		int month;
		JButton[] btn;
		
		public calendar() {
			calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
		}
		
		public void setButton(JButton[] btn) {
			this.btn = btn;
		}
		
		
		// ��� ����
		public void calInput(int gap) {
			month += gap;
			if(month <= 0) { // 1������ ���� ��ư ������ �� ���� �⵵��
				month = 12;
				year--;
			} else if (month >= 13) { // 12������ ���� ��ư ������ �� ���� �⵵��
				month = 1;
				year++;
			}
		}
		
		public String getCalText() {  // �󺧿� ����� ����
			String str = year + "�� " + month + "��";
			return str;
		}

		public void calSet() {
			calendar.set(year, month-1, 1);
			int firstday = calendar.get(Calendar.DAY_OF_WEEK)-1;
			for(int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
				btn[6 + firstday + i].setText(String.valueOf(i));
			}
		}
		
		
		// �޷��� ���ο� ����� �׸���
		public void allInit(int gap) {
			// ��ư�� ��¥ �����
			for(int i = 7; i < btn.length; i++) {
				btn[i].setText("");
			}
			// ��� ����
			calInput(gap);
			calSet();
		}
		
		
	}
	
}
