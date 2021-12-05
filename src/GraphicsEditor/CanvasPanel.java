package GraphicsEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;

import Shape.Shape;
import Shape.Rect;
import Shape.Circle;

import static GraphicsEditor.FileEdit.bufImage;
import static GraphicsEditor.FileEdit.loadImage;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {

	static Vector<Shape> shape = new Vector<Shape>(); // CREATE Vector
	private int x, y, w, h;
	private int X, Y, W, H;
	private boolean shadowFlag = false;
	private boolean moveFlag = false;
	
	public static boolean copyFlag = false;
	public static boolean loadFlag = false;
	public static int K;
	public static int mouseX = 0, mouseY = 0;
	public static int tempX = 0, tempY = 0;

	public static Color color = null;

	public CanvasPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(85, 5, 890, 490);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// Draw paint
	public void paint(Graphics g) {
		super.paint(g);
		// 불러온 이미지 그리기
		if (loadFlag == true) {
			g.drawImage(loadImage, 0, 0, null);
			repaint();
		}
		// Shape 그림자 그리기
		if (shadowFlag == true) {
			update(g);
		}
		// Shape 그리기
		for (int i = 0; i < shape.size(); i++) {
			Shape s = shape.elementAt(i);
			s.paint(g);
		}
		// Shape 그림 저장
		for (int i = 0; i < shape.size(); i++) {
			g = bufImage.getGraphics();
			Shape s = shape.elementAt(i);
			s.paint(g);
		}
		
	}

	public void update(Graphics g) {
		ShpCrdClc(x, y, w, h);
		switch (MenuPanel.button) {
		case 1:
			g.drawRect(X, Y, W, H);
			break;
		case 2:
			g.drawOval(X, Y, W, H);

			break;
		case 3:
			break;
		}
	}

	public void addShape() {
		ShpCrdClc(x, y, w, h);
		switch (MenuPanel.button) {
		case 1:
			shape.add(new Rect(1, X, Y, W, H, false, Color.BLACK));
			break;
		case 2:
			shape.add(new Circle(2, X, Y, W, H, false, Color.BLACK));
			break;
		}
		repaint();
	}

	public void shapeClear() {
		shape.clear();
		MenuPanel.getIconChange(copyFlag);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (MenuPanel.button == 1 || MenuPanel.button == 2) {
			x = e.getX();
			y = e.getY();
		} else if (MenuPanel.button == 3) {
			mouseX = e.getX();
			mouseY = e.getY();
			K = ShapeChk();
		} else if (MenuPanel.button == 4) {
			mouseX = e.getX();
			mouseY = e.getY();
			K = ShapeChk();
			copyFlag = true;
			if (K > -1 && copyFlag == true) {
				System.out.println("복사 플레그  ON" + " " +copyFlag);
				MenuPanel.getIconChange(copyFlag);
				System.out.println("COPY");
			}
		} else if (MenuPanel.button == 5) {
			Paste(e);
			System.out.println("PASTE");
		} else if (MenuPanel.button == 6) {
			mouseX = e.getX();
			mouseY = e.getY();
			fillColor(color);
			repaint();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (MenuPanel.button == 1 || MenuPanel.button == 2) {
			w = e.getX();
			h = e.getY();
			shadowFlag = false;
			addShape(); // 도형 추가
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (MenuPanel.button == 1 || MenuPanel.button == 2) {
			w = e.getX();
			h = e.getY();
			shadowFlag = true;
			repaint();
		} else if (MenuPanel.button == 3) {
			shapeMove(e);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	// Shape 4분면 계산하는 함수
	public void ShpCrdClc(int x, int y, int w, int h) {
		X = 0;
		Y = 0;
		W = 0;
		H = 0;

		if (x > w) {
			this.X = w;
			this.W = x - w;
		} else {
			this.X = x;
			this.W = w - x;
		}
		if (y > h) {
			this.Y = h;
			this.H = y - h;
		} else {
			this.Y = y;
			this.H = h - y;
		}
	}

	public void shapeMove(MouseEvent e) {
		int dx = e.getX(), dy = e.getY();

		x = dx - mouseX;
		y = dy - mouseY;

		if (K > -1) {
			shape.elementAt(K).x = tempX + x;
			shape.elementAt(K).y = tempY + y;
			repaint();
		}
	}

	public static void ckVect() {
		System.out.println("백터의 개수 : " + shape.size());
		for (int i = 0; i < shape.size(); i++) {
			Shape s = shape.elementAt(i);
			System.out.println(i + ": " + "X=" + s.x + " " + "Y=" + s.y + " " + "W=" + (s.w + s.x) + " " + "H="
					+ (s.h + s.y) + "\t 도형:" + s.div + " 채워짐:" + s.fill + " 색깔:" + s.color);
		}
		System.out.println("현재 색깔: " + color);
	}

	public static int ShapeChk() {
		int K = -1;

		for (int i = 0; i < shape.size(); i++) {
			if (shape.elementAt(i).isIn(mouseX, mouseY)) {
				K = i;
				tempX = shape.elementAt(K).x;
				tempY = shape.elementAt(K).y;
			}
		}

		if (K > -1) {
			Shape s = shape.elementAt(K);
			System.out.println("[ 선택된 Shape ]");
			System.out.println(K + ": " + "X=" + s.x + " " + "Y=" + s.y + " " + "W=" + (s.w + s.x) + " " + "H="
					+ (s.h + s.y) + "\t 도형:" + s.div + " 채워짐:" + s.fill + " 색깔:" + s.color);
		} else {
			System.out.println("[ 선택된 Shape가 없습니다. ]");
		}

		return K;
	}

	public void fillColor(Color color) {
		int K = ShapeChk();
		if (K >= 0) {
			Shape s = shape.elementAt(K);
			s.fill = true;
			s.color = color;
			System.out.println("[ 색 채워짐 !!! ]");
			System.out.println(K + ": " + "X=" + s.x + " " + "Y=" + s.y + " " + "W=" + (s.w + s.x) + " " + "H="
					+ (s.h + s.y) + "\t 도형:" + s.div + " 채워짐:" + s.fill + " 색깔:" + s.color);
		} else {
			System.out.println("[ Shape를 찾지 못했습니다. ]");
		}
	}

	public void Paste(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		int W, H;
		W = shape.elementAt(K).w;
		H = shape.elementAt(K).h;

		Shape s = shape.elementAt(K);

		if (s.div == 1) {
			shape.add(new Rect(s.div, mouseX - (W / 2), mouseY - (H / 2), W, H, s.fill, s.color));
		} else if (s.div == 2) {
			shape.add(new Circle(s.div, mouseX - (W / 2), mouseY - (H / 2), W, H, s.fill, s.color));
		}
		repaint();
	}

}
