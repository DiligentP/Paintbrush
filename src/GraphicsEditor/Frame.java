package GraphicsEditor;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		
		// 프레임 아이콘 및 타이틀 설정
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image Icon = kit.getImage("./Image/Canvas.PNG");
		setIconImage(Icon);
		setTitle("Graphics Editor");

		// 프레임창이 원하는 크기에서 움직이지 않게 (true,false)
		setResizable(false);

		// 프레임을 보이게 설정 (true,false)
		setVisible(true);

		// 프레임의 크기를 설정
		setPreferredSize(new Dimension(1000, 1000 / 12 * 7));
		setSize(1000, 1000 / 12 * 7);

		// 프로그램창을 항상 가운데에서 실행
		setLocationRelativeTo(null);

		// 프로그램을 끄면 자동으로 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
