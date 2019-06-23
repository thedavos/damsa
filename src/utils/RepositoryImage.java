package utils;

import java.io.*;
import java.util.Base64;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RepositoryImage {
	private String applicationKeyId = "002792ce63312bb0000000002";
	private String applicationKey = "K002rnwo3o8z8P29Os8HMnaqrPwymsg";
	
	private void get_upload_url() {
		String json = authorize_account();
		
		String apiUrl = ""; // Provided by b2_authorize_account
		String accountAuthorizationToken = ""; // Provided by b2_authorize_account
		String bucketId = "47f9a28cce86e36361a20b1b"; // The ID of the bucket you want to upload your file to
		HttpURLConnection connection = null;
		String postParams = "{\"bucketId\":\"" + bucketId + "\"}";
		byte postData[] = postParams.getBytes(StandardCharsets.UTF_8);
		try {
		    URL url = new URL(apiUrl + "/b2api/v2/b2_get_upload_url");
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Authorization", accountAuthorizationToken);
		    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    connection.setRequestProperty("charset", "utf-8");
		    connection.setRequestProperty("Content-Length", Integer.toString(postData.length));
		    connection.setDoOutput(true);
		    DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
		    writer.write(postData);
		    String jsonResponse = InputStreamReader(connection.getInputStream());
		    System.out.println(jsonResponse);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
	}
	
	public void upload_file() {
		String uploadUrl = ""; // Provided by b2_get_upload_url
		String uploadAuthorizationToken = ""; // Provided by b2_get_upload_url
		String fileName = ""; // The name of the file you are uploading
		String contentType = ""; // The content type of the file
		String sha1 = ""; // SHA1 of the file you are uploading
		byte[] fileData = null;
		HttpURLConnection connection = null;
		String json = null;
		try {
		    URL url = new URL(uploadUrl);
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Authorization", uploadAuthorizationToken);
		    connection.setRequestProperty("Content-Type", contentType);
		    connection.setRequestProperty("X-Bz-File-Name", fileName);
		    connection.setRequestProperty("X-Bz-Content-Sha1", sha1);
		    connection.setDoOutput(true);
		    DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
		    writer.write(fileData);
		    String jsonResponse = InputStreamReader(connection.getInputStream());
		    System.out.println(jsonResponse);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
	}
	
	public String authorize_account() {
		HttpURLConnection connection = null;
		String headerForAuthorizeAccount = "Basic " + Base64.getEncoder().encodeToString((applicationKeyId + ":" + applicationKey).getBytes());
		String jsonResponse = null;
		
		try {
		    URL url = new URL("https://api.backblazeb2.com/b2api/v2/b2_authorize_account");
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Authorization", headerForAuthorizeAccount);
		    InputStream in = new BufferedInputStream(connection.getInputStream());    
		    jsonResponse = InputStreamReader(in);
		    return jsonResponse;
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
		return jsonResponse;
	}

	private String InputStreamReader(InputStream in) throws IOException {
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
