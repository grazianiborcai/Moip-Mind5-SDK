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

	public final static String MULTI_PATH_1 = "multiorders/";
	public final static String MULTI_PATH_2 = "/multipayments";
	public final static String SINGLE_PATH_1 = "orders/";
	public final static String SINGLE_PATH_2 = "/payments";

	private static String path;
	private static String type;

	private String id;
	private String status;
	private Amount amount;
	private List<Payment> payments;
	private int installmentCount;
	private FundingInstrument fundingInstrument;

	public Payment(String type, String orderId) {
		this.type = type;
		if (type == MULTI) {
			path = MULTI_PATH_1 + orderId + MULTI_PATH_2;
		} else if (type == SINGLE) {
			path = SINGLE_PATH_1 + orderId + SINGLE_PATH_2;
		}
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

	public int getInstallmentCount() {
		return installmentCount;
	}

	public void setInstallmentCount(int installmentCount) {
		this.installmentCount = installmentCount;
	}

	public FundingInstrument getFundingInstrument() {
		return fundingInstrument;
	}

	public void setFundingInstrument(FundingInstrument fundingInstrument) {
		this.fundingInstrument = fundingInstrument;
		fundingInstrument.setMethod(CREDIT_CARD);
	}

	public Payment create(APIContext apiContext) {
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
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		if (type.equals(MULTI))
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
		else if (type.equals(SINGLE))
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
		String payLoad = new Gson().toJsonTree(this).toString();

		return configureAndExecute(apiContext, HttpMethod.POST, path, payLoad, Payment.class);
	}
}
