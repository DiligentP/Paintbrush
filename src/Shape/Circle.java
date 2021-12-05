package Shape;

import static GraphicsEditor.FileEdit.bufImage;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(int div, int x, int y, int w, int h, boolean fill, Color color) {
		super(div,x, y, w, h,fill,color);
	}
	
	public void paint(Graphics g) {
		if (fill == true) {
			g.setColor(color);
			g.fillOval(x, y, w, h);
			g.setColor(Color.BLACK);
			g.drawOval(x, y, w, h);
		}else if(fill == false){
			g.setColor(color);
			g.drawOval(x, y, w, h);
		}
	}
}
