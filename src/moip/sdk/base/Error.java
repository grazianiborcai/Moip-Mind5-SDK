package moip.sdk.base;

public class Error {

	private String code;
	private String path;
	private String description;

	public String getCode() {
		return code;
	}

	public Error setCode(String code) {
		this.code = code;

		return this;
	}

	public String getPath() {
		return path;
	}

	public Error setPath(String path) {
		this.path = path;

		return this;
	}

	public String getDescription() {
		return description;
	}

	public Error setDescription(String description) {
		this.description = description;

		return this;
	}

}
