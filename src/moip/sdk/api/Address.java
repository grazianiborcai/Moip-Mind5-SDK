package moip.sdk.api;

public class Address {

	private String zipCode;
	private String street;
	private String state;
	private String streetNumber;
	private String district;
	private String country;
	private String city;

	public String getZipCode() {
		return zipCode;
	}

	public Address setZipCode(String zipCode) {
		this.zipCode = zipCode;

		return this;
	}

	public String getStreet() {
		return street;
	}

	public Address setStreet(String street) {
		this.street = street;

		return this;
	}

	public String getState() {
		return state;
	}

	public Address setState(String state) {
		this.state = state;

		return this;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public Address setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;

		return this;
	}

	public String getDistrict() {
		return district;
	}

	public Address setDistrict(String district) {
		this.district = district;

		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(String country) {
		this.country = country;

		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;

		return this;
	}

}
