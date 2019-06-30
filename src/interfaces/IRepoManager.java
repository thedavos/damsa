package interfaces;

import java.io.File;

import com.backblaze.b2.client.structures.B2FileVersion;

import utils.RepoManager;

public interface IRepoManager {
	default B2FileVersion saveFile(File file) {
		return RepoManager.saveFile(file);
	}
	
	default String getDownload(String folder, String filename) {
		return RepoManager.getDownload(folder, filename);
	}
	
	default B2FileVersion updateFile(File file, String oldFilename) {
		return RepoManager.updateFile(file, oldFilename);
	}
}
