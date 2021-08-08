import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MainFrame extends JFrame{

	public MainFrame() {
		super("Movie");
		this.setBounds(600, 250, 800, 500);
		this.setResizable(false);	
		
		// ������ �̹���
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(new foodPanel2(this));
	      this.remove(new foodPanel2(this));
	      this.add(new foodPanel3(this));
	      this.remove(new foodPanel3(this));
	      this.revalidate();
	      this.repaint();
		
		
		// ���� ������
		new Main(this);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
