package Class;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Constant {
	public final String LINK_PATH_IMAGE =  "Image\\"; 
	
	public final int PORT = 1099 ;
	public final String HOST = "192.168.1.149" ; //"rmi://192.168.1.149/register"
	public boolean checkChatPublic(String idUser) {
		if(idUser.equals("111publicChat")) 
			return true;
		return false ; 
	}
	// set icon cho button
	public void addIconButton(String path_image, JButton btn, int width, int height) {
		  try {
				
				BufferedImage bufferImage = ImageIO.read(new File(path_image));
				Icon icon1 = new ImageIcon(bufferImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
				btn.setIcon(icon1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      
	}
}
