package moip.sdk.api;

public class TaxDocument {
	private String type;
	private String number;

	public String getType() {
		return type;
	}

	public TaxDocument setType(String type) {
		this.type = type;
		
		return this;
	}

	public String getNumber() {
		return number;
	}

	public TaxDocument setNumber(String number) {
		this.number = number;
		
		return this;
	}
}
