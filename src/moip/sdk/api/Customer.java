package moip.sdk.api;

public class Customer {
	private String fullname;
	private String birthdate;
	private TaxDocument taxDocument;
	private Phone phone;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public TaxDocument getTaxDocument() {
		return taxDocument;
	}

	public void setTaxDocument(TaxDocument taxDocument) {
		this.taxDocument = taxDocument;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}