package Utils;

import java.io.*;
import java.util.Base64;
import java.net.HttpURLConnection;
import java.net.URL;

public class RepositoryImage {
	private String applicationKeyId = "002792ce63312bb0000000002";
	private String applicationKey = "K002rnwo3o8z8P29Os8HMnaqrPwymsg";
	
	public void authorize_account() {
		HttpURLConnection connection = null;
		String headerForAuthorizeAccount = "Basic " + Base64.getEncoder().encodeToString((applicationKeyId + ":" + applicationKey).getBytes());
		
		try {
		    URL url = new URL("https://api.backblazeb2.com/b2api/v2/b2_authorize_account");
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Authorization", headerForAuthorizeAccount);
		    InputStream in = new BufferedInputStream(connection.getInputStream());    
		    String jsonResponse = myInputStreamReader(in);
		    System.out.println(jsonResponse);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
		
	}
	
	public String myInputStreamReader(InputStream in) throws IOException {
	    InputStreamReader reader = new InputStreamReader(in);
	    StringBuilder sb = new StringBuilder();
	    int c = reader.read();
	    while (c != -1) {
	        sb.append((char)c);
	        c = reader.read();
	    }
	    reader.close();
	    return sb.toString();
	}
}
