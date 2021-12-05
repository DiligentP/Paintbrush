package GraphicsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener{
	
	public static String menu = "Home";
	public static int button = 0;
	final int x = 10, y = 130, w = 20, h = 20;
	
	// Home 이미지 파일 설정  
	ImageIcon image_Rect = new ImageIcon("./Image/Rect.PNG");
	ImageIcon image_Circle = new ImageIcon("./Image/Circle.PNG");
	ImageIcon image_Select = new ImageIcon("./Image/Select.PNG");
	static ImageIcon image_Copy = new ImageIcon("./Image/Copy.PNG");
	static ImageIcon image_Copy_s = new ImageIcon("./Image/Copy_s.PNG");
	ImageIcon image_Paste = new ImageIcon("./Image/Paste.PNG");

	JButton Button_1 = new JButton(image_Rect);
	JButton Button_2 = new JButton(image_Circle);
	JButton Button_3 = new JButton(image_Select);
	public static JButton Button_4 = new JButton(image_Copy);
	JButton Button_5 = new JButton(image_Paste);

	// Edit
	static ImageIcon image_Paint = new ImageIcon("./Image/Paint.PNG");

	static JButton PaintButton = new JButton(image_Paint);
	static JButton coooseButton = new JButton();

	static JButton bleakButton = new JButton();
	static JButton grayButton = new JButton();
	static JButton darkgraynButton = new JButton();
	static JButton whiteButton = new JButton();
	static JButton blueButton = new JButton();
	static JButton redButton = new JButton();
	static JButton yellowButton = new JButton();
	static JButton greenButton = new JButton();
	static JButton orangeButton = new JButton();
	static JButton pinkButton = new JButton();

	public MenuPanel() {
		setLayout(null);
		setBounds(0, 0, 74, 527);
		setVisible(true);
		
		setHomeMenu();
	}
	
	public void setHomeMenu() {
		// Menu_Panel
		add(Button_1);
		add(Button_2);
		add(Button_3);
		add(Button_4);
		add(Button_5);

		Button_1.setBounds(10, 10, 50, 50);
		Button_2.setBounds(10, 70, 50, 50);
		Button_3.setBounds(10, 130, 50, 50);
		Button_4.setBounds(10, 200, 50, 50);
		Button_5.setBounds(10, 260, 50, 50);
		
		Button_1.addActionListener(this);
		Button_2.addActionListener(this);
		Button_3.addActionListener(this);
		Button_4.addActionListener(this);
		Button_5.addActionListener(this);
	}
	
	public void setEditMenu() {
		add(PaintButton);
		PaintButton.setBounds(10, 10, 50, 50);

		// Menu_Panel_Color_option
		coooseButton.setBackground(Color.BLACK);
		add(coooseButton);
		coooseButton.setBounds(10, 70, 50, 50);

		bleakButton.setBackground(Color.BLACK);
		add(bleakButton);
		bleakButton.setBounds(x, y, w, h);

		whiteButton.setBackground(Color.WHITE);
		add(whiteButton);
		whiteButton.setBounds(x + 25, y, w, h);

		darkgraynButton.setBackground(Color.DARK_GRAY);
		add(darkgraynButton);
		darkgraynButton.setBounds(x, y + 30, w, h);

		grayButton.setBackground(Color.GRAY);
		add(grayButton);
		grayButton.setBounds(x + 25, y + 30, w, h);

		blueButton.setBackground(Color.BLUE);
		add(blueButton);
		blueButton.setBounds(x, y + (30 * 2), w, h);

		redButton.setBackground(Color.RED);
		add(redButton);
		redButton.setBounds(x + 25, y + (30 * 2), w, h);

		yellowButton.setBackground(Color.YELLOW);
		add(yellowButton);
		yellowButton.setBounds(x, y + (30 * 3), w, h);

		greenButton.setBackground(Color.GREEN);
		add(greenButton);
		greenButton.setBounds(x + 25, y + (30 * 3), w, h);

		orangeButton.setBackground(Color.ORANGE);
		add(orangeButton);
		orangeButton.setBounds(x, y + (30 * 4), w, h);

		pinkButton.setBackground(Color.PINK);
		add(pinkButton);
		pinkButton.setBounds(x + 25, y + (30 * 4), w, h);

		PaintButton.addActionListener(this);
		bleakButton.addActionListener(this);
		whiteButton.addActionListener(this);
		darkgraynButton.addActionListener(this);
		grayButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		yellowButton.addActionListener(this);
		greenButton.addActionListener(this);
		orangeButton.addActionListener(this);
		pinkButton.addActionListener(this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Home
		if(e.getSource().equals(Button_1)) {
			MenuPanel.button = 1;
		} else if(e.getSource().equals(Button_2)) {
			MenuPanel.button = 2;
		} else if(e.getSource().equals(Button_3)) {
			MenuPanel.button = 3;
		} else if(e.getSource().equals(Button_4)) {
			MenuPanel.button = 4;
		} else if(e.getSource().equals(Button_5)) {
			MenuPanel.button = 5;
		}
		
		// Edit
		if (e.getSource().equals(PaintButton)) {
			MenuPanel.button = 6;
		} else if (e.getSource().equals(bleakButton)) {
			coooseButton.setBackground(Color.BLACK);
			CanvasPanel.color = Color.BLACK;
			
		} else if (e.getSource().equals(whiteButton)) {
			coooseButton.setBackground(Color.WHITE);
			CanvasPanel.color = Color.WHITE;
			
		} else if (e.getSource().equals(darkgraynButton)) {
			coooseButton.setBackground(Color.DARK_GRAY);
			CanvasPanel.color = Color.DARK_GRAY;
			
		} else if (e.getSource().equals(grayButton)) {
			coooseButton.setBackground(Color.GRAY);
			CanvasPanel.color = Color.GRAY;
			
		} else if (e.getSource().equals(blueButton)) {
			coooseButton.setBackground(Color.BLUE);
			CanvasPanel.color = Color.BLUE;
			
		} else if (e.getSource().equals(redButton)) {
			coooseButton.setBackground(Color.RED);
			CanvasPanel.color = Color.RED;
			
		} else if (e.getSource().equals(yellowButton)) {
			coooseButton.setBackground(Color.YELLOW);
			CanvasPanel.color = Color.YELLOW;
			
		} else if (e.getSource().equals(greenButton)) {
			coooseButton.setBackground(Color.GREEN);
			CanvasPanel.color = Color.GREEN;
			
		} else if (e.getSource().equals(orangeButton)) {
			coooseButton.setBackground(Color.ORANGE);
			CanvasPanel.color = Color.ORANGE;
			
		} else if (e.getSource().equals(pinkButton)) {
			coooseButton.setBackground(Color.PINK);
			CanvasPanel.color = Color.PINK;		
		}
	}
	public static void getIconChange(boolean Flag) {
		CanvasPanel.copyFlag = !CanvasPanel.copyFlag;
		if (Flag == true) {
			Button_4.setIcon(image_Copy_s);
		}else if (Flag == false) {
			Button_4.setIcon(image_Copy);
		}
	}
	
	public void menuRepaint() {
		removeAll();
		if (menu == "Home") {
			setHomeMenu();
		}
		else if (menu == "Edit") {
			setEditMenu();
		}
	}
}
