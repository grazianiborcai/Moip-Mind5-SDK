package moip.sdk.api;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

import moip.sdk.base.APIContext;
import moip.sdk.base.HttpMethod;
import moip.sdk.base.HttpsBase;

public class Payment extends HttpsBase {
	public final static String CREDIT_CARD = "CREDIT_CARD";

	public final static String MULTI_PATH_1 = "multiorders";
	public final static String MULTI_PATH_2 = "multipayments";
	public final static String SINGLE_PATH_1 = "orders";
	public final static String SINGLE_PATH_2 = "payments";

	// private static String pathPost;
	private String type;

	private String id;
	private String status;
	private Boolean delayCapture;
	private Amount amount;
	private List<Payment> payments;
	private Integer installmentCount;
	private FundingInstrument fundingInstrument;
	private List<Fee> fees;
	private List<Event> events;
	private Links _links;
	private String createdAt;
	private String updatedAt;
	private List<moip.sdk.base.Error> errors;
	private String ERROR;

	public Payment(String type, String id) {
		this.type = type;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Payment setId(String id) {
		this.id = id;

		return this;
	}

	public String getStatus() {
		return status;
	}

	public Payment setStatus(String status) {
		this.status = status;

		return this;
	}

	public Boolean getDelayCapture() {
		return delayCapture;
	}

	public Payment setDelayCapture(Boolean delayCapture) {
		this.delayCapture = delayCapture;

		return this;
	}

	public Amount getAmount() {
		return amount;
	}

	public Payment setAmount(Amount amount) {
		this.amount = amount;

		return this;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public Payment setPayments(List<Payment> payments) {
		this.payments = payments;

		return this;
	}

	public Integer getInstallmentCount() {
		return installmentCount;
	}

	public Payment setInstallmentCount(Integer installmentCount) {
		this.installmentCount = installmentCount;

		return this;
	}

	public FundingInstrument getFundingInstrument() {
		return fundingInstrument;
	}

	public Payment setFundingInstrument(FundingInstrument fundingInstrument) {
		this.fundingInstrument = fundingInstrument;
		fundingInstrument.setMethod(CREDIT_CARD);

		return this;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public Payment setFees(List<Fee> fees) {
		this.fees = fees;

		return this;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Payment setEvents(List<Event> events) {
		this.events = events;

		return this;
	}

	public Links get_links() {
		return _links;
	}

	public Payment set_links(Links _links) {
		this._links = _links;

		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Payment setCreatedAt(String createdAt) {
		this.createdAt = createdAt;

		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Payment setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;

		return this;
	}

	public List<moip.sdk.base.Error> getErrors() {
		return errors;
	}

	public Payment setErrors(List<moip.sdk.base.Error> errors) {
		this.errors = errors;

		return this;
	}

	public String getERROR() {
		return ERROR;
	}

	public Payment setERROR(String eRROR) {
		ERROR = eRROR;
		
		return this;
	}

	public Payment create(APIContext apiContext) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		String pathPost = null;
		if (type.equals(APIContext.MULTI)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
			pathPost = MULTI_PATH_1 + "/" + id + "/" + MULTI_PATH_2;
		} else if (type.equals(APIContext.SINGLE)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathPost = SINGLE_PATH_1 + "/" + id + "/" + SINGLE_PATH_2;
		}
		String payLoad = new Gson().toJsonTree(this).toString();

		return configureAndExecute(apiContext, HttpMethod.POST, pathPost, payLoad, Payment.class);
	}

	public Payment createAndAuthorized(APIContext apiContext) throws ClientProtocolException, IOException {

		Payment paymentCreated = create(apiContext);

		if (paymentCreated.getId() != null) {
			int wait = 4;
			for (int i = 0; i < wait; i++) {
				if (!paymentCreated.getStatus().equals("AUTHORIZED")) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					paymentCreated = get(apiContext, paymentCreated.getId());
				} else
					i = wait;
			}
		}

		return paymentCreated;

	}

	public Payment get(APIContext apiContext) throws ClientProtocolException, IOException {

		return get(apiContext, id);
	}

	private Payment get(APIContext apiContext, String paymentId) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		String pathGet = null;
		if (type.equals(APIContext.MULTI)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
			pathGet = MULTI_PATH_2 + "/" + paymentId;
		} else if (type.equals(APIContext.SINGLE)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathGet = SINGLE_PATH_2 + "/" + paymentId;
		}

		return configureAndExecute(apiContext, HttpMethod.GET, pathGet, null, Payment.class);
	}

}
