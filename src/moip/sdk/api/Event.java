package moip.sdk.api;

public class Event {

	private String type;
	private String createdAt;
	private String description;

	public String getType() {
		return type;
	}

	public Event setType(String type) {
		this.type = type;
		
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Event setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Event setDescription(String description) {
		this.description = description;
		
		return this;
	}

}
