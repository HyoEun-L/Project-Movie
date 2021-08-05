package Reservation.location;

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

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BeforeSelectLocation extends JFrame{
	
	JPanel pnlocation; 
	JButton previous;    // �������� ��ư (����ȭ��)
 	JButton next;		 // �������� ��ư (��ȭ ����)
 	Icon btn3 = new ImageIcon("icon/search.png");
 	Font font = new Font("HY�߰��", Font.PLAIN, 24);    
 	Font fontip = new Font("�������", Font.PLAIN, 20);
 	Font fontth = new Font("�������", Font.BOLD, 20);
 	Font fontbtn = new Font("�������", Font.BOLD, 17);
 	JTextField input;
 	JButton search;
 	
 	
	public BeforeSelectLocation() {
		this.setSize(800, 500);
		
		pnlocation = new JPanel();
		pnlocation.setLayout(null);
		pnlocation.setBackground(Color.white);
		
		
		//Ÿ��Ʋ   
		JLabel title = new JLabel("��  ��  ��  ��");
		title.setFont(font);
		title.setBounds(320, 30, 150, 30);
		pnlocation.add(title);

		
		// ����� �Է� �ޱ�
	
		input = new JTextField(30);
		input.setBounds(160, 90, 410, 55);
		input.setFont(fontip);
		input.setForeground(new Color(33, 150, 83));
		
		search = new JButton(btn3);
		search.setBounds(565, 90, 50, 50);
		search.setBorderPainted(false);
		search.setFocusPainted(false);
		search.setContentAreaFilled(false);
		
		pnlocation.add(input);
		pnlocation.add(search);
		
		
		// ��ȭ ����
		
	
		RoundedButton th1 = new RoundedButton("��  ��");
		th1.setFont(fontth);
		th1.setBounds(110,190,100,50);
		RoundedButton th2 = new RoundedButton("��  ��");
		th2.setFont(fontth);
		th2.setBounds(260, 190, 100, 50);
		RoundedButton th3 = new RoundedButton("��  ��");
		th3.setFont(fontth);
		th3.setBounds(410, 190, 100, 50);
		RoundedButton th4 = new RoundedButton("��  ��");
		th4.setFont(fontth);
		th4.setBounds(560, 190, 100, 50);
		RoundedButton th5 = new RoundedButton("��  ��");
		th5.setFont(fontth);
		th5.setBounds(110, 270, 100, 50);
		RoundedButton th6 = new RoundedButton("�б���");
		th6.setFont(fontth);
		th6.setBounds(260, 270, 100, 50);
		RoundedButton th7 = new RoundedButton("��  ��");
		th7.setFont(fontth);
		th7.setBounds(410, 270, 100, 50);
		RoundedButton th8 = new RoundedButton("û  ��");
		th8.setFont(fontth);
		th8.setBounds(560, 270, 100, 50);
		
		pnlocation.add(th1);
		pnlocation.add(th2);
		pnlocation.add(th3);
		pnlocation.add(th4);
		pnlocation.add(th5);
		pnlocation.add(th6);
		pnlocation.add(th7);
		pnlocation.add(th8);
	
		
		
		// ����, ���� ��ư
		RoundedButtonw previous = new RoundedButtonw("��  ��");
		previous.setFont(fontbtn);
		previous.setBounds(20, 380, 90, 40);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setContentAreaFilled(false);
		
		RoundedButton next = new RoundedButton("�� ��");
		next.setFont(fontbtn);
		next.setBounds(670, 380, 90, 40);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		
		pnlocation.add(previous);
		pnlocation.add(next);
		
		
		
		// **** ��ư Ŭ�� �̺�Ʈ ó�� ****
		// 1. �˻� ��ư Ŭ�� : ����ڰ� �˻��� ������ ǥ�õ� 
		//                �������� �ʴ� ���� ���� �� �ٽ� �Է� 
		search.addMouseListener(new MouseAdapter() {
			String[]str = {"����", "����", "����", "�Ｚ", "�Ż�", "�б���", "����", "û��"};
			
			@Override
			public void mousePressed(MouseEvent e) {
					
					for(int i = 0; i < str.length; i++) {
						
						if(input.getText().contains(str[0]))
							th1.doClick(2000);
						else if(input.getText().contains(str[1]))
							th2.doClick(2000);
						else if(input.getText().contains(str[2]))
							th3.doClick(2000);
						else if(input.getText().contains(str[3]))
							th4.doClick(2000);
						else if(input.getText().contains(str[4]))
							th5.doClick(2000);
						else if(input.getText().contains(str[5]))
							th6.doClick(2000);
						else if(input.getText().contains(str[6]))
							th7.doClick(2000);
						else if(input.getText().contains(str[7]))
							th8.doClick(2000);
						else{
							input.setText("�������� �ʴ� �����Դϴ� �ٽ� �Է��ϼ���.");						
						}
					}
			}
			
		});
		
		
		// 2. ���� ���� -> ����ȭ��
		
		
		
		
		
		// 3. ������ư
		
		
		
		
		
		this.add(pnlocation);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	// ��ư �ձ۰� ó�� - �ʷ� ��ư
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(33, 150, 83); //���� ����
	         Color o=new Color(255,255,255); //���ڻ� ����
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	
	// ��ư �ձ۰� ó�� - ȸ����ư
	public class RoundedButtonw extends JButton {
	      public RoundedButtonw() { super(); decorate(); } 
	      public RoundedButtonw(String text) { super(text); decorate(); } 
	      public RoundedButtonw(Action action) { super(action); decorate(); } 
	      public RoundedButtonw(Icon icon) { super(icon); decorate(); } 
	      public RoundedButtonw(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(234, 234, 234); //���� ����
	         Color o=new Color(33,150,83); //���ڻ� ����
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.lightGray); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }


}
