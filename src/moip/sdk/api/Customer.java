package moip.sdk.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

import moip.sdk.base.APIContext;
import moip.sdk.base.HttpMethod;
import moip.sdk.base.HttpsBase;

public class Customer extends HttpsBase {

	public final static String PATH = "customers";

	private String id;
	private String ownId;

	private String lastName;
	private Address address;
	private String name;

	private String fullname;
	private String email;
	private String birthDate;
	private String birthdate;
	private TaxDocument taxDocument;
	private Phone phone;
	private List<FundingInstrument> fundingInstruments;
	private String createdAt;
	private List<moip.sdk.base.Error> errors;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id) {
		this.id = id;
	}

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
		this.birthdate = birthDate;

		return this;
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	public Customer setBirthdate(String birthdate) {
		this.birthdate = birthdate;
		this.birthDate = birthdate;

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
	
	public List<moip.sdk.base.Error> getErrors() {
		return errors;
	}

	public Customer setErrors(List<moip.sdk.base.Error> errors) {
		this.errors = errors;

		return this;
	}

	public Customer addFunding(FundingInstrument fundingInstrument) {
		if (getFundingInstruments() == null)
			setFundingInstruments(new ArrayList<FundingInstrument>());

		getFundingInstruments().add(fundingInstrument);

		return this;
	}

	public Customer create(APIContext apiContext) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());

		String payLoad = new Gson().toJsonTree(this).toString();

		return configureAndExecute(apiContext, HttpMethod.POST, PATH, payLoad, Customer.class);
	}

	public Customer get(APIContext apiContext) throws ClientProtocolException, IOException {

		return get(apiContext, id);
	}

	private Customer get(APIContext apiContext, String customerId) throws ClientProtocolException, IOException {
		if (customerId != null) {
			checkApiContext(apiContext);
			apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
			String pathGet = null;
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathGet = PATH + "/" + customerId;

			return configureAndExecute(apiContext, HttpMethod.GET, pathGet, null, Customer.class);
		} else
			return null;

	}

}