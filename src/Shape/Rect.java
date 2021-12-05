package Shape;

import static GraphicsEditor.FileEdit.bufImage;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {
	
	public Rect(int div, int x, int y, int w, int h, boolean fill, Color color) {
		super(div,x, y, w, h,fill,color);
	}
	
	public void paint(Graphics g) {
		if (fill == true) {
			g.setColor(color);
			g.fillRect(x, y, w, h);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, w, h);
		}else if (fill == false){
			g.setColor(color);
			g.drawRect(x, y, w, h);
		}
	}
}
