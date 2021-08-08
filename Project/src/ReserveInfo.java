import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel /*implements Serializable*/ {

   private MainFrame mf;
   private JPanel ReserveInfo;

   private JLabel relabel1;
   private JLabel relabel2;
   private JLabel relabel3;
   private JLabel relabel4;
   private JLabel relabel5;
   private JLabel relabel6;
   private JLabel relabel7;
   
   // MovieInfo
   private List<MovieInfo> mif = new ArrayList<>();
   
   JTextField text;
   JLabel re;
   int i;

   public ReserveInfo(MainFrame mf) {
      this.mf = mf;
      this.ReserveInfo= this;
      
      this.setLayout(null);
      this.setBackground(Color.white);
      
      Font tfont = new Font("�������", Font.BOLD, 15);
      Font font = new Font("�������", Font.BOLD, 13);
      
      
      // �� �гο� ����
      JLabel label = new JLabel("���� ��ȣ �Է� : ");
      label.setBounds(15, 15, 200, 50);
      label.setFont(tfont);
      this.add(label);
 
      // �ؽ�Ʈ �ʵ� ���� �� �гο� ����
      text = new JTextField(15);
      text.setBounds(132, 22, 150, 30);
      this.add(text);
      
      JLabel re = new JLabel(" "); // ���� ���Ź�ȣ Ʋ�� �� ���� ���� "��ȣ�� �ٽ� Ȯ�����ֽʽÿ�."��.
      re.setBounds(290, 15, 300, 50);
      re.setFont(tfont);
      re.setForeground(Color.red);
      this.add(re);
    
      JButton backbt = new JButton("��  ��");
      backbt.setBounds(670, 10, 80, 40);
      backbt.setFont(font);
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
      
      list1.setBounds(30, 70, 100, 20); // ����
      list2.setBounds(120, 70, 100, 20); // ��¥
      list3.setBounds(250, 70, 100, 20); // ��ȭ
      list4.setBounds(380, 70, 100, 20); // �ð�
      list5.setBounds(470, 70, 100, 20); // �¼�
      list6.setBounds(557, 70, 100, 20); // ����
      list7.setBounds(640, 70, 100, 20); // �����ȣ
      
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
            // �ؽ�Ʈ ���ڷ� �ٽ� ��Ŀ�� ��������
            text.requestFocus();
            
            try (BufferedReader br = new BufferedReader(new FileReader("movie.txt"))) {
               
               String line = "";
               while((line = br.readLine()) != null) {
                  
                  String[] str = line.split(",");
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
      int index = -1; //for���� 0���� ���� ������ index�� 0���� �����ϸ� ���� ã�� ���� �迭�� ��� ���� ���� �ʾƵ� ��µ� �� �ֱ� ����.
      for(int i = 0; i < mif.size(); i++) {   //mif��� ��ü�迭 ��ü ũ�⸸ŭ ���Ƽ�
    	     	  
         if(text.getText().equals(mif.get(i).getmNumber())){  //�̹� ������ִ� ���Ź�ȣ�� ����ڿ��� �Է¹��� text�� ��ġ�ϴ��� ���� Ȯ�� 
        	index = i;
        	
         }
      }
      if(index > -1) { //��ġ ���� �־ �ε����� ���� ���ߴٸ�, ��ġ�� i��° ���� ��� ������ JLabel�� �ְ� ��ġ�����Ͽ� �����ش�.(���Ź�ȣ�� �ߺ����� �����Ƿ� �迭��� �� ��)
            // ����
            relabel1.setText("1");
            relabel1.setBounds(30, 100, 100, 20);
            // ��¥
            relabel2.setText(mif.get(i).getmDate());
            relabel2.setBounds(120, 100, 100, 20);
            // ����
            relabel3.setText(mif.get(i).getmTitle());
            relabel3.setBounds(210, 100, 200, 20);
            // �ð�
            relabel4.setText(mif.get(i).getmTime());
            relabel4.setBounds(380, 100, 100, 20);
            // �¼�
            relabel5.setText(mif.get(i).getmSeat());
            relabel5.setBounds(470, 100, 100, 20);
            // ����
            relabel6.setText(mif.get(i).getmLocation());
            relabel6.setBounds(560, 100, 100, 20);
            // �����ȣ
            relabel7.setText(mif.get(i).getmNumber());
            relabel7.setBounds(640, 100, 100, 20);
      }else { // �ߺ��Ǵ� ���� ���� ���
         re.setText("��ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�."); // false�� �� ��ȣ�� �ٽ� Ȯ���ش޶�� �� ���               
      }   
   }
}



  
