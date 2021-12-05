package GraphicsEditor;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;


public class FileEdit extends JFrame{
	public static BufferedImage bufImage = new BufferedImage(900, 490, BufferedImage.TYPE_INT_ARGB);
	public static BufferedImage loadImage;

	public static void FileSave() {
		JFrame f = new JFrame();

		FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);
		dialog.setVisible(true);

		String path = dialog.getDirectory() + dialog.getFile();
		System.out.println(path);

		try {
			ImageIO.write(bufImage, "PNG", new File(path + ".png"));
			System.out.println(bufImage);
		} catch (IOException e) {
			System.out.println("저장 오류");
		}
	}

	public static boolean FileLoad() {
		JFrame f = null;
		try {
			FileDialog dialog = new FileDialog(f, "불러오기", FileDialog.LOAD);

			dialog.setVisible(true);
			

			String path = dialog.getDirectory() + dialog.getFile();

			if (dialog.getFile() != null) {
				loadImage = ImageIO.read( new File (path));
				CanvasPanel.loadFlag = true;
				System.out.println("불러오기 성공" + dialog.getFile());
				return true;
			}
		} catch (IOException e) {
			System.out.println("불러오기 실패");	
		}
		return false;
	}
}
