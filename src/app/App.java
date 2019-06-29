package app;

import clases.Admin;
import models.AdminModel;

import clases.Cliente;
import models.ClientModel;

import clases.Empresa;
import models.EnterpriseModel;

import java.io.File;
import java.util.ArrayList;

import com.backblaze.b2.client.B2ClientConfig;
import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.contentSources.B2FileContentSource;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.client.structures.B2DownloadByIdRequest;
import com.backblaze.b2.client.structures.B2DownloadByNameRequest;
import com.backblaze.b2.client.structures.B2FileVersion;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import com.backblaze.b2.client.structures.B2UploadListener;
import com.backblaze.b2.client.webApiHttpClient.B2StorageHttpClientBuilder;

import utils.RepositoryImage;

public class App {
	public static void main(String[] args) throws Exception {
		String appKeyId="002792ce63312bb0000000002";
		String appKey="K002rnwo3o8z8P29Os8HMnaqrPwymsg";
		String USER_AGENT="damsa";
		
		final B2UploadListener uploadListener = (progress) -> {
            final double percent = (100. * (progress.getBytesSoFar() / (double) progress.getLength()));
        };
        
//        final B2FileVersion file1;
//		final File fileOnDisk = new File("src/app/App.java");
//		final String fileName = "users/file.txt";
//		final B2ContentSource source = B2FileContentSource.build(fileOnDisk);
		final B2ClientConfig config = B2ClientConfig.builder(appKeyId, appKey, USER_AGENT).build();
		final B2StorageClient client = B2StorageHttpClientBuilder.builder(config).build();
//		
		B2Bucket bucket = client.buckets().get(0);
//		
//		B2UploadFileRequest request = B2UploadFileRequest
//                .builder(bucket.getBucketId(), fileName, B2ContentTypes.B2_AUTO, source)
//                .setListener(uploadListener)
//                .build();
        
		
//		file1 = client.uploadSmallFile(request);
		String content = client.getDownloadByNameUrl(bucket.getBucketName(), "users/file.txt");
		System.out.println(content);

	}
}