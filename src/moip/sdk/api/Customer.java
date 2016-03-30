package moip.sdk.api;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String id;
	private String ownId;

	private String lastName;
	private Address address;
	private String name;

	private String fullname;
	private String email;
	private String birthDate;
	private TaxDocument taxDocument;
	private Phone phone;
	private List<FundingInstrument> fundingInstruments;
	private String createdAt;

	public String getId() {
		return id;
	}

	public Customer setId(String id) {
		this.id = id;

		return this;
	}

	public String getOwnId() {
		return ownId;
	}

	public Customer setOwnId(String ownId) {
		this.ownId = ownId;

		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = lastName;

		return this;
	}

	public Address getAddress() {
		return address;
	}

	public Customer setAddress(Address address) {
		this.address = address;

		return this;
	}

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;

		return this;
	}

	public String getFullname() {
		return fullname;
	}

	public Customer setFullname(String fullname) {
		this.fullname = fullname;

		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;

		return this;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Customer setBirthDate(String birthDate) {
		this.birthDate = birthDate;

		return this;
	}

	public TaxDocument getTaxDocument() {
		return taxDocument;
	}

	public Customer setTaxDocument(TaxDocument taxDocument) {
		this.taxDocument = taxDocument;

		return this;
	}

	public Phone getPhone() {
		return phone;
	}

	public Customer setPhone(Phone phone) {
		this.phone = phone;

		return this;
	}

	public List<FundingInstrument> getFundingInstruments() {
		return fundingInstruments;
	}

	public Customer setFundingInstruments(List<FundingInstrument> fundingInstruments) {
		this.fundingInstruments = fundingInstruments;

		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Customer setCreatedAt(String createdAt) {
		this.createdAt = createdAt;

		return this;
	}
	
	public Customer addFunding(FundingInstrument fundingInstrument) {
		if (getFundingInstruments() == null)
			setFundingInstruments(new ArrayList<FundingInstrument>());

		getFundingInstruments().add(fundingInstrument);

		return this;
	}

}