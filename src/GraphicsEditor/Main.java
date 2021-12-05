package GraphicsEditor;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;

public class Main {
	public static Frame frame = new Frame();
	public static MenuBar menuBar = new MenuBar();
	public static CanvasPanel canvas = new CanvasPanel();
	
	public static void main(String[] args) {
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		GroupLayout menuBarLayout = new GroupLayout(menuBar);
		
		MenuPanel menuPanel = new MenuPanel();
		menuPanel.setLayout(null);
		frame.getContentPane().add(menuPanel);
		
		menuBar.setMenu(menuPanel);
	
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		canvas.setLayout(null);
		
		frame.repaint();
	}	
}