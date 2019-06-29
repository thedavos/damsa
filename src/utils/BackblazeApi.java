package utils;

public class BackblazeApi {
	
	public static class Auth {
		private String apiUrl;
		private String authorizationToken;
		private String accountId;
		private String downloadUrl;
		
		public String getApiUrl() {
			return apiUrl;
		}
		public void setApiUrl(String apiUrl) {
			this.apiUrl = apiUrl;
		}
		public String getAuthorizationToken() {
			return authorizationToken;
		}
		public void setAuthorizationToken(String authorizationToken) {
			this.authorizationToken = authorizationToken;
		}
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getDownloadUrl() {
			return downloadUrl;
		}
		public void setDownloadUrl(String downloadUrl) {
			this.downloadUrl = downloadUrl;
		}
	}
	
	public static class UploadUrl {
		private String authorizationToken;
		private String bucketId;
		private String uploadUrl;
		
		public String getAuthorizationToken() {
			return authorizationToken;
		}
		public void setAuthorizationToken(String authorizationToken) {
			this.authorizationToken = authorizationToken;
		}
		public String getBucketId() {
			return bucketId;
		}
		public void setBucketId(String bucketId) {
			this.bucketId = bucketId;
		}
		public String getUploadUrl() {
			return uploadUrl;
		}
		public void setUploadUrl(String uploadUrl) {
			this.uploadUrl = uploadUrl;
		}
	}
	
	public static class UploadFile {
		private String fileId;
		private String fileName;
		private String contentSha1;
		private String contentType;
		private String accountId;
		private String bucketId;
		
		public String getFileId() {
			return fileId;
		}
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getContentSha1() {
			return contentSha1;
		}
		public void setContentSha1(String contentSha1) {
			this.contentSha1 = contentSha1;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getBucketId() {
			return bucketId;
		}
		public void setBucketId(String bucketId) {
			this.bucketId = bucketId;
		}
	}
}