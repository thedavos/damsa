package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager {
	public static File openFileSystem(int type) {
		FileNameExtensionFilter filter = null;
		
		// Si type es uno, solo filtra a las extensiones de imágenes
		if (type == 1) {
			filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
		} else if (type == 2) {
		// Si type es e, filtra al resto excepto a las imágenes
			filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text", "csv", "pdf");
		} else {
			filter = null;
		}
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.showOpenDialog(null);
		
		File fileSelected = fileChooser.getSelectedFile();
		
		return fileSelected;
	}
	/*
	 * @path -> ruta de la imagen en el sistema operativo
	 * @width -> ancho de la imagen
	 * @height -> altura de la imagen
	 * @returns -> retorna un objeto ImageIcon redimensionado, 
	 * si no se ingresa valores, toma por default 180 en ancho y altura
	 */
	public static ImageIcon ResizeImageIcon(String path, int width, int height) {
		ImageIcon icon = new ImageIcon(path);
		Image imageResized = icon.getImage().getScaledInstance(
				width != 0 ? width : 180, 
				height != 0 ? height : 180,
				Image.SCALE_DEFAULT);
		ImageIcon iconResized = new ImageIcon(imageResized);
		
		return iconResized;
	}
	
	public static ImageIcon ResizeImageIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image imageResized = icon.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
		ImageIcon iconResized = new ImageIcon(imageResized);
		
		return iconResized;
	}
	
	public static ImageIcon ResizeImageIcon(ImageIcon icon) {
		Image imageResized = icon.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
		ImageIcon iconResized = new ImageIcon(imageResized);
		
		return iconResized;
	}
	
	public static ImageIcon ResizeImageIcon(ImageIcon icon, int width, int height) {
		Image imageResized = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon iconResized = new ImageIcon(imageResized);
		
		return iconResized;
	}
	
	public static ImageIcon ConvertURLToIcon(String urlRepo) {
		Image image;
		ImageIcon iconFromRepo = null;
		try {
			if (urlRepo != null && !urlRepo.equals("")) {
				URL url = new URL(urlRepo);
				image = ImageIO.read(url);
				iconFromRepo = new ImageIcon(image);
				
				return iconFromRepo;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return iconFromRepo;
	}
}
