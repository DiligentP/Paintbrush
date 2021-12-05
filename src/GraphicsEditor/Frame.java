package GraphicsEditor;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		
		// ������ ������ �� Ÿ��Ʋ ����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image Icon = kit.getImage("./Image/Canvas.PNG");
		setIconImage(Icon);
		setTitle("Graphics Editor");

		// ������â�� ���ϴ� ũ�⿡�� �������� �ʰ� (true,false)
		setResizable(false);

		// �������� ���̰� ���� (true,false)
		setVisible(true);

		// �������� ũ�⸦ ����
		setPreferredSize(new Dimension(1000, 1000 / 12 * 7));
		setSize(1000, 1000 / 12 * 7);

		// ���α׷�â�� �׻� ������� ����
		setLocationRelativeTo(null);

		// ���α׷��� ���� �ڵ����� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
