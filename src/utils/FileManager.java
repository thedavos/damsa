package utils;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonSyntaxException;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.RepositoryImage;
import utils.BackblazeApi.UploadFile;

public class FileManager {
	
	public void saveImage() throws IOException, JsonSyntaxException, NoSuchAlgorithmException {
		JFileChooser fc = new JFileChooser();
		RepositoryImage ri = new RepositoryImage();
		
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    "Image files", ImageIO.getReaderFileSuffixes());

		fc.setFileFilter(imageFilter);
		fc.showOpenDialog(null);
		
		File file = fc.getSelectedFile();
		
		String fileName = file.getName();
		String mimeType = getMimeType(file);
		byte[] fileData = IOUtils.toByteArray(new FileInputStream(file));
		System.out.println(fileName);
		System.out.println(mimeType);
		System.out.println(fileData);
		UploadFile uf = ri.uploadFile(fileName, mimeType, fileData);
		
		System.out.println(uf.getFileName());
		
		
		
		
	}
	
	private String getMimeType(File file) throws IOException {
		String mimeType = Files.probeContentType(new File(file.getPath()).toPath());
		return mimeType;
	}
}
