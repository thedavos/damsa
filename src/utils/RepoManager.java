package utils;

import java.io.File;

import com.backblaze.b2.client.B2ClientConfig;
import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.contentSources.B2FileContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.client.structures.B2FileVersion;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import com.backblaze.b2.client.webApiHttpClient.B2StorageHttpClientBuilder;

public class RepoManager {
	
	private static String appKeyId="002792ce63312bb0000000002";
	private static String appKey="K002rnwo3o8z8P29Os8HMnaqrPwymsg";
	private static String USER_AGENT="damsa";
	
	private static B2StorageClient getClient() {
		B2StorageClient client = null;
		final B2ClientConfig config = B2ClientConfig.builder(appKeyId, appKey, USER_AGENT).build();
		client = B2StorageHttpClientBuilder.builder(config).build();
		
		return client;
	}
	
	@SuppressWarnings("finally")
	private static B2Bucket getDamsaBucket() {
		B2Bucket bucket = null;
		try {
			bucket = getClient().buckets().get(0);
		} catch (B2Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return bucket;
		}
	}
	
	public static B2FileVersion saveFile(File file) {
		B2FileVersion fileVersion = null;
		
		final B2ContentSource source = B2FileContentSource.build(file);
		
		B2UploadFileRequest request = B2UploadFileRequest.builder(
				getDamsaBucket().getBucketId(), 
				file.getName(), 
				B2ContentTypes.B2_AUTO	, 
				source).build();
		
		try {
			fileVersion = getClient().uploadSmallFile(request);
		} catch (B2Exception e) {
			e.printStackTrace();
		}
		
		return fileVersion;
	}
	
	public static String getDownload() {
		String downloadUrl = null;
		
		return downloadUrl;
	}
	
	public static void updateFile() {
		
	}
}
