package converters;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.embed.swing.SwingFXUtils;

/**
	 * Created by anisz
	 */

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import model.Category;
import model.CategoryFx;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PictureConverter {

	/**
	 * Developed by anisz
	 */
	
	public static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
		WritableImage image = new WritableImage(width, height);
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(raw);
			BufferedImage read = ImageIO.read(bis);
			image = SwingFXUtils.toFXImage(read, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return image;
	}

	
	public static byte[] convertToByteArray(Image picture) {
		BufferedImage bImage = SwingFXUtils.fromFXImage(picture, null);
		ByteArrayOutputStream s = new ByteArrayOutputStream();
		byte[] res = null;
		try {
			ImageIO.write(bImage, "png", s);
			res = s.toByteArray();
			s.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
