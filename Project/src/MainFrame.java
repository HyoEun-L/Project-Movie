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
		
		// ���� ������
		new Main(this);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
