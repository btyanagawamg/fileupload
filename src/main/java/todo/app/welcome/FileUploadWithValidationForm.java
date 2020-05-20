package todo.app.welcome;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadWithValidationForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@UploadFileRequired
	@UploadFileMaxSize
	private MultipartFile file;

    @NotNull
    @Size(min = 0, max = 100)
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
