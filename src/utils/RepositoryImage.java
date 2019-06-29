package utils;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import utils.BackblazeApi.*;
import utils.Encryption;

public class RepositoryImage {
	private String applicationKeyId = "002792ce63312bb0000000002";
	private String applicationKey = "K002rnwo3o8z8P29Os8HMnaqrPwymsg";

	private String get_upload_url() {
		Auth auth = new Gson().fromJson(authorize_account(), Auth.class);
		
		String apiUrl = auth.getApiUrl(); // Provided by b2_authorize_account
		String accountAuthorizationToken = auth.getAuthorizationToken(); // Provided by b2_authorize_account
		String bucketId = "47f9a28cce86e36361a20b1b"; // The ID of the bucket you want to upload your file to
		HttpURLConnection connection = null;
		String postParams = "{\"bucketId\":\"" + bucketId + "\"}";
		String jsonResponse = null;
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
		    jsonResponse = InputStreamReader(connection.getInputStream());
		    return jsonResponse;
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
		
		return jsonResponse;
	}
	
	private String upload_file(String fileName, String contentType, byte[] fileData) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		UploadUrl bbUrl= new Gson().fromJson(get_upload_url(), UploadUrl.class);
		
		String uploadUrl = bbUrl.getUploadUrl(); // Provided by b2_get_upload_url
		String uploadAuthorizationToken = bbUrl.getAuthorizationToken(); // Provided by b2_get_upload_url
		String sha1 = Encryption.SHA1(fileName); // SHA1 of the file you are uploading
		HttpURLConnection connection = null;
		String jsonResponse = null;
		System.out.println(uploadUrl);
		try {
		    URL url = new URL(uploadUrl);
		    connection = (HttpURLConnection)url.openConnection();
		    System.out.println(connection);
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Authorization", uploadAuthorizationToken);
		    connection.setRequestProperty("Content-Type", contentType);
		    connection.setRequestProperty("X-Bz-File-Name", fileName);
		    connection.setRequestProperty("X-Bz-Content-Sha1", sha1);
		    connection.setDoOutput(true);
		    DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
		    writer.write(fileData);
		    return jsonResponse = InputStreamReader(connection.getInputStream());
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
		
		return jsonResponse;
	}
	
	public UploadFile uploadFile(String fileName, String contentType, byte[] fileData) throws JsonSyntaxException, NoSuchAlgorithmException, UnsupportedEncodingException {
		UploadFile file = new Gson().fromJson(upload_file(fileName, contentType, fileData), UploadFile.class);
		return file;
	}
	
	private String authorize_account() {
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
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    connection.disconnect();
		}
		return jsonResponse;
		
	}

	public String InputStreamReader(InputStream in) throws IOException {
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
