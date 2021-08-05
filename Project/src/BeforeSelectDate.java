package Reservation.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforeSelectDate extends JFrame implements ActionListener {
	JPanel pnmonth; // ���� �� �г�
	JPanel pndate;  // ���� �� �г�
	JPanel pnbtn;   // ����, ���� ��ư �� �г�
	JLabel month_value;
	JButton[] date_value = new JButton[49];
	Font font;      // Ÿ��Ʋ �۾�
	Font monthfont;
	Font dayfont;   // ���� �۾�
	Font datefont;  // �� �۾�
	JButton left;   // ���� ��ư
	JButton right;  // ������ ��ư
	JButton previous;    // �������� ��ư (����ȭ��)
 	JButton next;		 // �������� ��ư (���� ����)
 	Icon btn1 = new ImageIcon("icon/after.png");
 	Icon btn2 = new ImageIcon("icon/before.png");
	
	calendar calendar = new calendar();

	public BeforeSelectDate() {
		
		super("��ȭƼ�� ����");
		this.setSize(800, 600);
		pnbtn = new JPanel();
		
		pnbtn.setBackground(Color.white);
		
		pnmonth = new JPanel();  // ��
		pnmonth.setBackground(Color.white);
		
		pndate = new JPanel();    // ����,��
		pndate.setBackground(Color.white);
		pndate.setLayout(new GridLayout(0,7,5,5));  // ���� �׸��� ���̾ƿ����� ����
		
		font = new Font("����ü", Font.BOLD, 21);     // Ÿ��Ʋ ��Ʈ ����
		monthfont = new Font("����ü", Font.BOLD, 21);     // Ÿ��Ʋ ��Ʈ ����
		dayfont = new Font("����ü", Font.BOLD, 18);  // ���� ��Ʈ ����
		datefont = new Font("Arial", Font.PLAIN, 16); // �� ��Ʈ ����
		
		
		left = new JButton(new ImageIcon("icon/left.png"));  // �������� �ѱ�� ��ư
		left.setPreferredSize(new Dimension(100,100));
		left.setBorderPainted(false); // ��ư ��輱 ����
		left.setFocusPainted(false); // ��ư ������ ǥ�� ����
		left.setContentAreaFilled(false);  // ��ư ���� ��� ����
		pnmonth.add(left); 
		left.addActionListener(this); // ���� �� ��ư Ŭ��
		
		month_value = new JLabel(); // �޷� �� ǥ��
		month_value.setFont(monthfont);
		month_value.setText(calendar.getCalText());
		pnmonth.add(month_value);
		
		right = new JButton(new ImageIcon("icon/right.png"));  // ���������� �ѱ�� ��ư
		right.setPreferredSize(new Dimension(100,100));
		right.setBorderPainted(false); // ��ư ��輱 ����
		right.setFocusPainted(false); // ��ư ������ ǥ�� ����
		right.setContentAreaFilled(false);  // ��ư ���� ��� ����
		pnmonth.add(right);
		right.addActionListener(this); // ���� �� ��ư Ŭ��
		
		
		for(int i =0; i < date_value.length; i++) { // �޷� ���� , ��
			String[] d= {"  ��  ", "  ��  ", "  ȭ  ", "  ��  ", "  ��  ", "  ��  ", "  ��  "};
		
			
			date_value[i] = new JButton();
			date_value[i].setFont(datefont);
			date_value[i].setBorderPainted(false);
			date_value[i].setContentAreaFilled(false);
			//date_value[i].addActionListener(this);  this ���� �͸�Ŭ������ �ؼ� this ��� �ֱ�
			date_value[i].setFocusPainted(false);
			
			
			if(i < 7) {
				date_value[i].setText(d[i]);
				date_value[i].setFont(dayfont);
				date_value[i].setForeground(Color.green.darker().darker());
			}
		
			pndate.add(date_value[i]);
			
			
		}
		
		
		date_value[7].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[7].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		
		date_value[8].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[8].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[9].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[9].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[10].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[10].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[11].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[11].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[12].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[12].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[13].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[13].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[14].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[14].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[15].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[15].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		
		date_value[16].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[16].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[17].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[17].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[18].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[18].setIcon(new ImageIcon("icon/circle.png"));
			}
		});date_value[19].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[19].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[20].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[20].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[21].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[21].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[22].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[22].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[23].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[23].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[24].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[24].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[25].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[25].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[26].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[26].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[27].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[27].setIcon(new ImageIcon("icon/circle.png"));
			}
		});date_value[28].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[28].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[29].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[29].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[30].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[30].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[31].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[31].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[32].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[32].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[33].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[33].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[34].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[34].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[35].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[35].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		date_value[36].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		
		date_value[37].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
			}
		});
		
		
		
		
		calendar.setButton(date_value);
		calendar.calSet();
		
		
		
		
		// ���� ���� ��ư
		previous = new JButton(btn2);
		previous.setPreferredSize(new Dimension(350, 80));
		previous.addActionListener(this);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setContentAreaFilled(false);
		pnbtn.add(previous);
	
		
		next = new JButton(btn1);
		next.setPreferredSize(new Dimension(350, 80));
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		next.addActionListener(this);
		pnbtn.add(next);
		
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
		
		this.add(pnmonth,"North");
		this.add(pndate, "Center");
		this.add(pnbtn, "South");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
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
