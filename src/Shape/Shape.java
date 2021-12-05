package Shape;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	public int x, y, w, h;		// x,y 시작좌표    w,h Shape크기 
	public int div;			// 1 = Rect   2 = Circle
	public boolean fill;		// true = Fill , false = not Fill
	public Color color;		// color RGB
	
	public Shape(int div, int x, int y, int w, int h, boolean fill, Color color) {
		this.div = div;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fill = fill;
		this.color = color;
	}
	
	public boolean isIn(int tx, int ty) {
		if(x < tx && x+w > tx && y < ty && y+h > ty) {
			return true;
		}
		return false;
	}
	
	public abstract void paint(Graphics g);
	
}