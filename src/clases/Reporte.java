package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import interfaces.IRepoManager;
import static db.Config.*;

/**
 * Clase que permite generar reportes a tráves de archivos 
 * en formato .csv o .txt y los guarda en un repositorio remoto
 * de backblaze
 * <p>
 * Utilizando el método {@code makeReport}}
 * 
 * @author David Vargas
 */
public class Reporte implements IRepoManager {
	private String codUser;
	private String nameFile;
	private String content;
	private String extension;
	private String imageUrl;
	private Date created;
	final private String tmpPath = "src/temp/";
	final private String folder = "reports";
	
	public Reporte(ResultSet rs) {
		try {
			this.codUser = rs.getString(CodigoUsuario);
			this.nameFile = rs.getString(ReporteName);
			this.extension = rs.getString(ReporteEXT);
			this.imageUrl = rs.getString(ReporteURL);
			this.created = (Date) rs.getDate(Created);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public Reporte() {
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFolder() {
		return folder;
	}
	
	public String getTemporalPath() {
		return tmpPath;
	}
	
	public String getCodUser() {
		return codUser;
	}
	
	public void setCodUser(String codUser) {
		this.codUser=codUser;
	}
	
	public String getNameFile() {
		return nameFile;
	}
	
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void makeReport() {
		if ( (getNameFile() != null) && (getContent() != null) ) {
			try {
				
				File file = new File(getTemporalPath() + getNameFile() + "." + getExtension());
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(getContent());
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		} else {
			System.out.println("Ingresa los datos del archivo");
		}
	}
	
	public File getTemporalFile() {
		return new File(getTemporalPath() + getNameFile() + "." + getExtension());
	}
	
	public void saveFileOnRepo() {
		makeReport();
		File file = getTemporalFile();
		String path = getFolder() + "/";
		saveFile(file, path);
		file.delete();
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String readDownloadURL() {
		String text = "";
		
		String downloadURL = getDownload(getFolder(), getNameFile() + "." + getExtension());
		
		try {
			
			URL url = new URL(downloadURL);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                text += line;
            }
            in.close();
            
            return text;
            
		} catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
		
		return text;
	}
}
