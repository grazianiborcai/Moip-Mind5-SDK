package moip.sdk.api;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import moip.sdk.base.APIContext;
import moip.sdk.base.HttpMethod;
import moip.sdk.base.HttpsBase;

public class Payment extends HttpsBase {
	public final static String CREDIT_CARD = "CREDIT_CARD";
	public final static String MULTI = "MULTI";
	public final static String SINGLE = "SINGLE";

	public final static String MULTI_PATH_1 = "multiorders";
	public final static String MULTI_PATH_2 = "multipayments";
	public final static String SINGLE_PATH_1 = "orders";
	public final static String SINGLE_PATH_2 = "payments";

	// private static String pathPost;
	private String type;

	private String id;
	private String status;
	private Amount amount;
	private List<Payment> payments;
	private Integer installmentCount;
	private FundingInstrument fundingInstrument;
	private List<moip.sdk.base.Error> errors;

	public Payment(String type, String id) {
		this.type = type;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Integer getInstallmentCount() {
		return installmentCount;
	}

	public void setInstallmentCount(Integer installmentCount) {
		this.installmentCount = installmentCount;
	}

	public FundingInstrument getFundingInstrument() {
		return fundingInstrument;
	}

	public void setFundingInstrument(FundingInstrument fundingInstrument) {
		this.fundingInstrument = fundingInstrument;
		fundingInstrument.setMethod(CREDIT_CARD);
	}

	public List<moip.sdk.base.Error> getErrors() {
		return errors;
	}

	public void setErrors(List<moip.sdk.base.Error> errors) {
		this.errors = errors;
	}

	public Payment create(APIContext apiContext) {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		String pathPost = null;
		if (type.equals(MULTI)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
			pathPost = MULTI_PATH_1 + "/" + id + "/" + MULTI_PATH_2;
		} else if (type.equals(SINGLE)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathPost = SINGLE_PATH_1 + "/" + id + "/" + SINGLE_PATH_2;
		}
		String payLoad = new Gson().toJsonTree(this).toString();

		return configureAndExecute(apiContext, HttpMethod.POST, pathPost, payLoad, Payment.class);
	}

	public Payment createAndAuthorized(APIContext apiContext) {

		Payment paymentCreated = create(apiContext);

		if (paymentCreated.getErrors() == null)
			for (int i = 0; i < 5; i++) {
				if (!paymentCreated.getStatus().equals("AUTHORIZED"))
					paymentCreated = get(apiContext, paymentCreated.getId());
				else
					i = 5;
			}

		return paymentCreated;

	}

	public Payment get(APIContext apiContext) {

		return get(apiContext, id);
	}

	private Payment get(APIContext apiContext, String paymentId) {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		String pathGet = null;
		if (type.equals(MULTI)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
			pathGet = MULTI_PATH_2 + "/" + paymentId;
		} else if (type.equals(SINGLE)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathGet = SINGLE_PATH_2 + "/" + paymentId;
		}

		return configureAndExecute(apiContext, HttpMethod.GET, pathGet, null, Payment.class);
	}

	private void checkApiContext(APIContext apiContext) {
		if (apiContext == null) {
			throw new IllegalArgumentException("APIContext cannot be null");
		}
		if (apiContext.getAccessToken() == null || apiContext.getAccessToken().trim().length() <= 0) {
			throw new IllegalArgumentException("AccessToken cannot be null or empty");
		}
		if (apiContext.getoAuthToken() == null || apiContext.getoAuthToken().trim().length() <= 0) {
			throw new IllegalArgumentException("OAuthToken() cannot be null or empty");
		}
		if (apiContext.getHTTPHeaders() == null) {
			apiContext.setHTTPHeaders(new ConcurrentHashMap<String, String>());
		}
	}

}
