package moip.sdk.api;

public class Email {

	private Boolean confirmed;
	private String address;

	public Boolean getConfirmed() {
		return confirmed;
	}

	public Email setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
		
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Email setAddress(String address) {
		this.address = address;
		
		return this;
	}

}
