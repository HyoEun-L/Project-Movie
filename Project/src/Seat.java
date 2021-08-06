

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat extends JPanel {
	private MainFrame mf;
	JPanel Seat;
	JButton previous;    // �������� ��ư (��ȭ����)
 	JButton next;		 // �������� ��ư (����)
 	JComboBox clist;	 // �����ο� 
 	int count;			 // ���� �ο� �о�� ����
 	JLabel seat;
 	
 	
 	
	public Seat(MainFrame mf) {
		this.mf = mf;
		this.Seat = this;
		setLayout(null);		
		setBackground(Color.white);
		
		Font font = new Font("HY�߰��", Font.PLAIN, 24);
		Font fontbtn = new Font("�������", Font.BOLD, 17);
		Font fontcnt = new Font("HY�߰��", Font.PLAIN, 18);
		Font fontclist = new Font("�������", Font.PLAIN, 15);
		Font fonts = new Font("HY�߰��", Font.PLAIN, 13);
		
		// Ÿ��Ʋ
		JLabel title = new JLabel("�� �� �� ��");
		title.setFont(font);
		title.setBounds(320, 10, 150, 30);
		this.add(title);
		
		
		
		// �����ο� - �޺��ڽ�
		JLabel cnt = new JLabel("���� �ο�");
		cnt.setFont(fontcnt);
		cnt.setBounds(520, 50, 100, 30);
		this.add(cnt);
		
		JLabel notice = new JLabel("*�ִ� 4�� ���� ����");
		notice.setFont(new Font("�������", Font.ITALIC, 13));
		notice.setForeground(Color.red.darker());
		notice.setBounds(530, 35, 140, 15);
		this.add(notice);
		
		String[] person = {"0", "1", "2", "3", "4"};
		clist = new JComboBox(person);
		clist.setSelectedIndex(0);     // ó�� ���� �Ǿ� ���� �ο� �� 
		clist.setBounds(610, 51, 50, 25);
		clist.setForeground(new Color(33, 150, 83));
		clist.setFont(fontclist);
		this.add(clist);
		
		
		// *** ��ư Ŭ�� �̺�Ʈ ó��  : �����ο� �ѹ� �����ϸ� ���� �Ұ�
		
		clist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clist.setEnabled(false);
				JComboBox person = (JComboBox) e.getSource();
				count = Integer.parseInt((String) person.getSelectedItem());
			}
			
		});
		
		
		
		// �¼� ���� - ��ũ��
		JLabel screen = new JLabel(new ImageIcon("icon/screen.PNG"));
		screen.setBounds(160, 100, 440, 25);
		this.add(screen);
		
		seat = new JLabel("");
		seat.setFont(fonts);
		seat.setBounds(300, 380, 80, 40);
		
		
		// �¼� ���� - �¼�
	
		JButton s1= new JButton("1");
		s1.setForeground(new Color(33, 150, 83));
		s1.setBackground(new Color(246, 246, 246));
		s1.setBounds(100, 150, 50, 50);
		s1.setFont(fonts);
		s1.setBorderPainted(false);
		s1.setFocusPainted(false);
		this.add(s1);
		
		JButton s2= new JButton("2");
		s2.setForeground(new Color(33, 150, 83));
		s2.setBackground(new Color(246, 246, 246));
		s2.setBounds(155, 150, 50, 50);
		s2.setFont(fonts);
		s2.setBorderPainted(false);
		s2.setFocusPainted(false);
		this.add(s2);
		
		JButton s3= new JButton("3");
		s3.setForeground(new Color(33, 150, 83));
		s3.setBackground(new Color(246, 246, 246));
		s3.setBounds(210, 150, 50, 50);
		s3.setFont(fonts);
		s3.setBorderPainted(false);
		s3.setFocusPainted(false);
		this.add(s3);
		
		JButton s4= new JButton("4");
		s4.setForeground(new Color(33, 150, 83));
		s4.setBackground(new Color(246, 246, 246));
		s4.setBounds(265, 150, 50, 50);
		s4.setFont(fonts);
		s4.setBorderPainted(false);
		s4.setFocusPainted(false);
		this.add(s4);
		
		JButton s5= new JButton("5");
		s5.setForeground(new Color(33, 150, 83));
		s5.setBackground(new Color(246, 246, 246));
		s5.setBounds(320, 150, 50, 50);
		s5.setFont(fonts);
		s5.setBorderPainted(false);
		s5.setFocusPainted(false);
		this.add(s5);
		
		JButton s6= new JButton("6");
		s6.setForeground(new Color(33, 150, 83));
		s6.setBackground(new Color(246, 246, 246));
		s6.setBounds(375, 150, 50, 50);
		s6.setFont(fonts);
		s6.setBorderPainted(false);
		s6.setFocusPainted(false);
		this.add(s6);
		
		JButton s7= new JButton("7");
		s7.setForeground(new Color(33, 150, 83));
		s7.setBackground(new Color(246, 246, 246));
		s7.setBounds(430, 150, 50, 50);
		s7.setFont(fonts);
		s7.setBorderPainted(false);
		s7.setFocusPainted(false);
		this.add(s7);
		
		JButton s8= new JButton("8");
		s8.setForeground(new Color(33, 150, 83));
		s8.setBackground(new Color(246, 246, 246));
		s8.setBounds(485, 150, 50, 50);
		s8.setFont(fonts);
		s8.setBorderPainted(false);
		s8.setFocusPainted(false);
		this.add(s8);
		
		JButton s9= new JButton("9");
		s9.setForeground(new Color(33, 150, 83));
		s9.setBackground(new Color(246, 246, 246));
		s9.setBounds(540, 150, 50, 50);
		s9.setFont(fonts);
		s9.setBorderPainted(false);
		s9.setFocusPainted(false);
		this.add(s9);
		
		JButton s10= new JButton("10");
		s10.setForeground(new Color(33, 150, 83));
		s10.setBackground(new Color(246, 246, 246));
		s10.setBounds(595, 150, 50, 50);
		s10.setFont(fonts);
		s10.setBorderPainted(false);
		s10.setFocusPainted(false);
		this.add(s10);
		
		JButton s11= new JButton("11");
		s11.setForeground(new Color(33, 150, 83));
		s11.setBackground(new Color(246, 246, 246));
		s11.setBounds(100, 205, 50, 50);
		s11.setFont(fonts);
		s11.setBorderPainted(false);
		s11.setFocusPainted(false);
		this.add(s11);
		
		JButton s12= new JButton("12");
		s12.setForeground(new Color(33, 150, 83));
		s12.setBackground(new Color(246, 246, 246));
		s12.setBounds(155, 205, 50, 50);
		s12.setFont(fonts);
		s12.setBorderPainted(false);
		s12.setFocusPainted(false);
		this.add(s12);
		
		JButton s13= new JButton("13");
		s13.setForeground(new Color(33, 150, 83));
		s13.setBackground(new Color(246, 246, 246));
		s13.setBounds(210, 205, 50, 50);
		s13.setFont(fonts);
		s13.setBorderPainted(false);
		s13.setFocusPainted(false);
		this.add(s13);
		
		JButton s14= new JButton("14");
		s14.setForeground(new Color(33, 150, 83));
		s14.setBackground(new Color(246, 246, 246));
		s14.setBounds(265, 205, 50, 50);
		s14.setFont(fonts);
		s14.setBorderPainted(false);
		s14.setFocusPainted(false);
		this.add(s14);
		
		JButton s15= new JButton("15");
		s15.setForeground(new Color(33, 150, 83));
		s15.setBackground(new Color(246, 246, 246));
		s15.setBounds(320, 205, 50, 50);
		s15.setFont(fonts);
		s15.setBorderPainted(false);
		s15.setFocusPainted(false);
		this.add(s15);
		
		JButton s16= new JButton("16");
		s16.setForeground(new Color(33, 150, 83));
		s16.setBackground(new Color(246, 246, 246));
		s16.setBounds(375, 205, 50, 50);
		s16.setFont(fonts);
		s16.setBorderPainted(false);
		s16.setFocusPainted(false);
		this.add(s16);
		
		JButton s17= new JButton("17");
		s17.setForeground(new Color(33, 150, 83));
		s17.setBackground(new Color(246, 246, 246));
		s17.setBounds(430, 205, 50, 50);
		s17.setFont(fonts);
		s17.setBorderPainted(false);
		s17.setFocusPainted(false);
		this.add(s17);
		
		JButton s18= new JButton("18");
		s18.setForeground(new Color(33, 150, 83));
		s18.setBackground(new Color(246, 246, 246));
		s18.setBounds(485, 205, 50, 50);
		s18.setFont(fonts);
		s18.setBorderPainted(false);
		s18.setFocusPainted(false);
		this.add(s18);
		
		JButton s19= new JButton("19");
		s19.setForeground(new Color(33, 150, 83));
		s19.setBackground(new Color(246, 246, 246));
		s19.setBounds(540, 205, 50, 50);
		s19.setFont(fonts);
		s19.setBorderPainted(false);
		s19.setFocusPainted(false);
		this.add(s19);
		
		JButton s20= new JButton("20");
		s20.setForeground(new Color(33, 150, 83));
		s20.setBackground(new Color(246, 246, 246));
		s20.setBounds(595, 205, 50, 50);
		s20.setFont(fonts);
		s20.setBorderPainted(false);
		s20.setFocusPainted(false);
		this.add(s20);
		
		JButton s21= new JButton("21");
		s21.setForeground(new Color(33, 150, 83));
		s21.setBackground(new Color(246, 246, 246));
		s21.setBounds(100, 260, 50, 50);
		s21.setFont(fonts);
		s21.setBorderPainted(false);
		s21.setFocusPainted(false);
		this.add(s21);
		
		JButton s22= new JButton("22");
		s22.setForeground(new Color(33, 150, 83));
		s22.setBackground(new Color(246, 246, 246));
		s22.setBounds(155, 260, 50, 50);
		s22.setFont(fonts);
		s22.setBorderPainted(false);
		s22.setFocusPainted(false);
		this.add(s22);
		
		JButton s23= new JButton("23");
		s23.setForeground(new Color(33, 150, 83));
		s23.setBackground(new Color(246, 246, 246));
		s23.setBounds(210, 260, 50, 50);
		s23.setFont(fonts);
		s23.setBorderPainted(false);
		s23.setFocusPainted(false);
		this.add(s23);
		
		JButton s24= new JButton("24");
		s24.setForeground(new Color(33, 150, 83));
		s24.setBackground(new Color(246, 246, 246));
		s24.setBounds(265, 260, 50, 50);
		s24.setFont(fonts);
		s24.setBorderPainted(false);
		s24.setFocusPainted(false);
		this.add(s24);
		
		JButton s25= new JButton("25");
		s25.setForeground(new Color(33, 150, 83));
		s25.setBackground(new Color(246, 246, 246));
		s25.setBounds(320, 260, 50, 50);
		s25.setFont(fonts);
		s25.setBorderPainted(false);
		s25.setFocusPainted(false);
		this.add(s25);
		
		JButton s26= new JButton("26");
		s26.setForeground(new Color(33, 150, 83));
		s26.setBackground(new Color(246, 246, 246));
		s26.setBounds(375, 260, 50, 50);
		s26.setFont(fonts);
		s26.setBorderPainted(false);
		s26.setFocusPainted(false);
		this.add(s26);
		
		JButton s27= new JButton("27");
		s27.setForeground(new Color(33, 150, 83));
		s27.setBackground(new Color(246, 246, 246));
		s27.setBounds(430, 260, 50, 50);
		s27.setFont(fonts);
		s27.setBorderPainted(false);
		s27.setFocusPainted(false);
		this.add(s27);
		
		JButton s28= new JButton("28");
		s28.setForeground(new Color(33, 150, 83));
		s28.setBackground(new Color(246, 246, 246));
		s28.setBounds(485, 260, 50, 50);
		s28.setFont(fonts);
		s28.setBorderPainted(false);
		s28.setFocusPainted(false);
		this.add(s28);
		
		JButton s29= new JButton("29");
		s29.setForeground(new Color(33, 150, 83));
		s29.setBackground(new Color(246, 246, 246));
		s29.setBounds(540, 260, 50, 50);
		s29.setFont(fonts);
		s29.setBorderPainted(false);
		s29.setFocusPainted(false);
		this.add(s29);
		
		JButton s30= new JButton("30");
		s30.setForeground(new Color(33, 150, 83));
		s30.setBackground(new Color(246, 246, 246));
		s30.setBounds(595, 260, 50, 50);
		s30.setFont(fonts);
		s30.setBorderPainted(false);
		s30.setFocusPainted(false);
		this.add(s30);
		
		JButton s31= new JButton("31");
		s31.setForeground(new Color(33, 150, 83));
		s31.setBackground(new Color(246, 246, 246));
		s31.setBounds(100, 315, 50, 50);
		s31.setFont(fonts);
		s31.setBorderPainted(false);
		s31.setFocusPainted(false);
		this.add(s31);
		
		JButton s32= new JButton("32");
		s32.setForeground(new Color(33, 150, 83));
		s32.setBackground(new Color(246, 246, 246));
		s32.setBounds(155, 315, 50, 50);
		s32.setFont(fonts);
		s32.setBorderPainted(false);
		s32.setFocusPainted(false);
		this.add(s32);
		
		JButton s33= new JButton("33");
		s33.setForeground(new Color(33, 150, 83));
		s33.setBackground(new Color(246, 246, 246));
		s33.setBounds(210, 315, 50, 50);
		s33.setFont(fonts);
		s33.setBorderPainted(false);
		s33.setFocusPainted(false);
		this.add(s33);
		
		JButton s34= new JButton("34");
		s34.setForeground(new Color(33, 150, 83));
		s34.setBackground(new Color(246, 246, 246));
		s34.setBounds(265, 315, 50, 50);
		s34.setFont(fonts);
		s34.setBorderPainted(false);
		s34.setFocusPainted(false);
		this.add(s34);
		
		JButton s35= new JButton("35");
		s35.setForeground(new Color(33, 150, 83));
		s35.setBackground(new Color(246, 246, 246));
		s35.setBounds(320, 315, 50, 50);
		s35.setFont(fonts);
		s35.setBorderPainted(false);
		s35.setFocusPainted(false);
		this.add(s35);
		
		JButton s36= new JButton("36");
		s36.setForeground(new Color(33, 150, 83));
		s36.setBackground(new Color(246, 246, 246));
		s36.setBounds(375, 315, 50, 50);
		s36.setFont(fonts);
		s36.setBorderPainted(false);
		s36.setFocusPainted(false);
		this.add(s36);
		
		JButton s37= new JButton("37");
		s37.setForeground(new Color(33, 150, 83));
		s37.setBackground(new Color(246, 246, 246));
		s37.setBounds(430, 315, 50, 50);
		s37.setFont(fonts);
		s37.setBorderPainted(false);
		s37.setFocusPainted(false);
		this.add(s37);
		
		JButton s38= new JButton("38");
		s38.setForeground(new Color(33, 150, 83));
		s38.setBackground(new Color(246, 246, 246));
		s38.setBounds(485, 315, 50, 50);
		s38.setFont(fonts);
		s38.setBorderPainted(false);
		s38.setFocusPainted(false);
		this.add(s38);
		
		JButton s39= new JButton("39");
		s39.setForeground(new Color(33, 150, 83));
		s39.setBackground(new Color(246, 246, 246));
		s39.setBounds(540, 315, 50, 50);
		s39.setFont(fonts);
		s39.setBorderPainted(false);
		s39.setFocusPainted(false);
		this.add(s39);
		
		JButton s40= new JButton("40");
		s40.setForeground(new Color(33, 150, 83));
		s40.setBackground(new Color(246, 246, 246));
		s40.setBounds(595, 315, 50, 50);
		s40.setFont(fonts);
		s40.setBorderPainted(false);
		s40.setFocusPainted(false);
		this.add(s40);
		
		
		
		int clickcount = 1;
		
		// *** �¼� ��ư �̺�Ʈ ó�� : ���� �� �ڸ� üũ
		s1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s1.setForeground(new Color(246, 246, 246));
				s1.setBackground(new Color( 33, 150, 83));
				seat.setText("1 �� �¼�");

				}
		});		

		s2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s2.setForeground(new Color(246, 246, 246));
				s2.setBackground(new Color( 33, 150, 83));
				seat.setText("2 �� �¼�");
			}
		});
		s3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s3.setForeground(new Color(246, 246, 246));
				s3.setBackground(new Color( 33, 150, 83));
				seat.setText("3 �� �¼�");
			}
		});
		s4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s4.setForeground(new Color(246, 246, 246));
				s4.setBackground(new Color( 33, 150, 83));
				seat.setText("4 �� �¼�");
			}
		});
		s5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s5.setForeground(new Color(246, 246, 246));
				s5.setBackground(new Color( 33, 150, 83));
				seat.setText("5 �� �¼�");
			}
		});
		s6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s6.setForeground(new Color(246, 246, 246));
				s6.setBackground(new Color( 33, 150, 83));
				seat.setText("6 �� �¼�");
			}
		});
		s7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s7.setForeground(new Color(246, 246, 246));
				s7.setBackground(new Color( 33, 150, 83));
				seat.setText("7 �� �¼�");
			}
		});
		s8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s8.setForeground(new Color(246, 246, 246));
				s8.setBackground(new Color( 33, 150, 83));
				seat.setText("8 �� �¼�");
			}
		});
		s9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s9.setForeground(new Color(246, 246, 246));
				s9.setBackground(new Color( 33, 150, 83));
				seat.setText("9 �� �¼�");
			}
		});
		s10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s10.setForeground(new Color(246, 246, 246));
				s10.setBackground(new Color( 33, 150, 83));
				seat.setText("10 �� �¼�");
			}
		});
		s11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s11.setForeground(new Color(246, 246, 246));
				s11.setBackground(new Color( 33, 150, 83));
				seat.setText("11 �� �¼�");
			}
		});
		s12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s12.setForeground(new Color(246, 246, 246));
				s12.setBackground(new Color( 33, 150, 83));
				seat.setText("12 �� �¼�");
			}
		});
		s13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s13.setForeground(new Color(246, 246, 246));
				s13.setBackground(new Color( 33, 150, 83));
				seat.setText("13 �� �¼�");
			}
		});
		s14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s14.setForeground(new Color(246, 246, 246));
				s14.setBackground(new Color( 33, 150, 83));
				seat.setText("14 �� �¼�");
			}
		});
		s15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s15.setForeground(new Color(246, 246, 246));
				s15.setBackground(new Color( 33, 150, 83));
				seat.setText("15 �� �¼�");
			}
		});
		s16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s16.setForeground(new Color(246, 246, 246));
				s16.setBackground(new Color( 33, 150, 83));
				seat.setText("16 �� �¼�");
			}
		});
		s17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s17.setForeground(new Color(246, 246, 246));
				s17.setBackground(new Color( 33, 150, 83));
				seat.setText("17 �� �¼�");
			}
		});
		s18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s18.setForeground(new Color(246, 246, 246));
				s18.setBackground(new Color( 33, 150, 83));
				seat.setText("18 �� �¼�");
			}
		});
		s19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s19.setForeground(new Color(246, 246, 246));
				s19.setBackground(new Color( 33, 150, 83));
				seat.setText("19 �� �¼�");
			}
		});
		s20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s20.setForeground(new Color(246, 246, 246));
				s20.setBackground(new Color( 33, 150, 83));
				seat.setText("20 �� �¼�");
			}
		});
		s21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s21.setForeground(new Color(246, 246, 246));
				s21.setBackground(new Color( 33, 150, 83));
				seat.setText("21 �� �¼�");
			}
		});
		s22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s21.setForeground(new Color(246, 246, 246));
				s21.setBackground(new Color( 33, 150, 83));
				seat.setText("22 �� �¼�");
			}
		});
		s23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s23.setForeground(new Color(246, 246, 246));
				s23.setBackground(new Color( 33, 150, 83));
				seat.setText("23 �� �¼�");
			}
		});
		s24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s24.setForeground(new Color(246, 246, 246));
				s24.setBackground(new Color( 33, 150, 83));
				seat.setText("24 �� �¼�");
			}
		});
		s25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s25.setForeground(new Color(246, 246, 246));
				s25.setBackground(new Color( 33, 150, 83));
				seat.setText("25 �� �¼�");
			}
		});
		s26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s26.setForeground(new Color(246, 246, 246));
				s26.setBackground(new Color( 33, 150, 83));
				seat.setText("26 �� �¼�");
			}
		});
		s27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s27.setForeground(new Color(246, 246, 246));
				s27.setBackground(new Color( 33, 150, 83));
				seat.setText("27 �� �¼�");
			}
		});
		s28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s28.setForeground(new Color(246, 246, 246));
				s28.setBackground(new Color( 33, 150, 83));
				seat.setText("28 �� �¼�");
			}
		});
		s29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s29.setForeground(new Color(246, 246, 246));
				s29.setBackground(new Color( 33, 150, 83));
				seat.setText("29 �� �¼�");
			}
		});
		s30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s30.setForeground(new Color(246, 246, 246));
				s30.setBackground(new Color( 33, 150, 83));
				seat.setText("30 �� �¼�");
			}
		});
		s31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s31.setForeground(new Color(246, 246, 246));
				s31.setBackground(new Color( 33, 150, 83));
				seat.setText("31 �� �¼�");
			}
		});
		s32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s31.setForeground(new Color(246, 246, 246));
				s31.setBackground(new Color( 33, 150, 83));
				seat.setText("32 �� �¼�");
			}
		});
		s33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s33.setForeground(new Color(246, 246, 246));
				s33.setBackground(new Color( 33, 150, 83));
				seat.setText("33 �� �¼�");
			}
		});
		s34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s34.setForeground(new Color(246, 246, 246));
				s34.setBackground(new Color( 33, 150, 83));
				seat.setText("34 �� �¼�");
			}
		});
		s35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s35.setForeground(new Color(246, 246, 246));
				s35.setBackground(new Color( 33, 150, 83));
				seat.setText("35 �� �¼�");
			}
		});
		s36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s36.setForeground(new Color(246, 246, 246));
				s36.setBackground(new Color( 33, 150, 83));
				seat.setText("36 �� �¼�");
			}
		});
		s37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s37.setForeground(new Color(246, 246, 246));
				s37.setBackground(new Color( 33, 150, 83));
				seat.setText("37 �� �¼�");
			}
		});
		s38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s38.setForeground(new Color(246, 246, 246));
				s38.setBackground(new Color( 33, 150, 83));
				seat.setText("38 �� �¼�");
			}
		});
		s39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s39.setForeground(new Color(246, 246, 246));
				s39.setBackground(new Color( 33, 150, 83));
				seat.setText("39 �� �¼�");
			}
		});
		s40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				s40.setForeground(new Color(246, 246, 246));
				s40.setBackground(new Color( 33, 150, 83));
				seat.setText("40 �� �¼�");
			}
		});
		
		
	
		
		// ����, ���� ��ư 
		JButton previous = new JButton("��  ��");
		previous.setFont(fontbtn);
		previous.setBounds(20, 380, 90, 40);
		previous.setForeground(new Color( 234, 234, 234 ));
		previous.setBackground(new Color( 33, 150, 83));
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		this.add(previous);
		
		JButton next = new JButton("�� ��");
		next.setFont(fontbtn);
		next.setBounds(670, 380, 90, 40);
		next.setForeground(new Color(234, 234, 234 ));
		next.setBackground(new Color( 33, 150, 83));
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		this.add(next);
		
		
		// *** ��ư Ŭ�� �̺�Ʈ ó�� ***
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				previous.setForeground(new Color(33, 150, 83));
				previous.setBackground(new Color(246, 246, 246 ));
				// ��ȭ ��ȸ ȭ��
			}
		});
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				next.setForeground(new Color(33, 150, 83));
				next.setBackground(new Color(246, 246, 246 ));
				// ���� ȭ��
				// new memberReserveInfo(mf);
				setVisible(false);
				
			}
		});
		
		
		mf.add(this);
	}


	// �¼� ���� ���� ���Ͽ� ����   
	public void fileSave() {
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
			dout.writeUTF(seat.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
