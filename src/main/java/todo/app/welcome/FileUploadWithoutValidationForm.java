package todo.app.welcome;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadWithoutValidationForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private MultipartFile file;

    private String description;

    public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
