package GraphicsEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static GraphicsEditor.Main.canvas;
import static GraphicsEditor.FileEdit.bufImage;


public class MenuBar extends JMenuBar {
	
	JMenu NewMenu_1 = new JMenu(" File ");
	JMenuItem NewMenuItem_1 = new JMenuItem("New");
	JMenuItem NewMenuItem_2 = new JMenuItem("Save");
	JMenuItem NewMenuItem_3 = new JMenuItem("Load");
	JMenuItem NewMenuItem_4 = new JMenuItem("Exit");
	JMenu NewMenu_2 = new JMenu(" Home ");
	JMenu NewMenu_3 = new JMenu(" Edit ");
	JMenu NewMenu_4 = new JMenu(" Help ");
	
	private MenuPanel menuPanle;
	
	public MenuBar() {
		
		setMenuBar();
	}
	
	public void setMenu(MenuPanel menu) {
		this.menuPanle = menu;
	}
		
	public void setMenuBar() {
		
		NewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bufImage = new BufferedImage(900, 490, BufferedImage.TYPE_INT_ARGB);
				canvas.shapeClear();
				CanvasPanel.loadFlag = false;
			}
		});
		
		NewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileEdit.FileSave();
			}
		});
		
		NewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean i = FileEdit.FileLoad();
				if (i == true) {
					canvas.shapeClear();
					canvas.repaint();
				}
			}
		});

		NewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		NewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenuPanel.menu = "Home";
				menuPanle.menuRepaint();
				Main.frame.repaint();
			}
		});
		
		NewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenuPanel.menu = "Edit";
				menuPanle.menuRepaint();
				Main.frame.repaint();
			}
		});
		
		NewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CanvasPanel.ckVect();
			}
		});

		NewMenu_1.add(NewMenuItem_1);
		NewMenu_1.add(NewMenuItem_2);
		NewMenu_1.add(NewMenuItem_3);
		NewMenu_1.add(NewMenuItem_4);
		
		add(NewMenu_1);
		add(NewMenu_2);
		add(NewMenu_3);
		add(NewMenu_4);
	}
}
