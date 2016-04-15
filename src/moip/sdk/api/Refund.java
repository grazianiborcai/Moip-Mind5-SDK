package moip.sdk.api;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

import moip.sdk.base.APIContext;
import moip.sdk.base.HttpMethod;
import moip.sdk.base.HttpsBase;

public class Refund extends HttpsBase {
	public final static String CREDIT_CARD = "CREDIT_CARD";

	public final static String SINGLE_PATH_1 = "orders";
	public final static String SINGLE_PATH_2 = "refunds";

	private String id;
	private String status;
	private Amount amount;
	private String type;
	private FundingInstrument refundingInstrument;
	private List<Event> events;
	private Links _links;
	private String createdAt;
	private List<moip.sdk.base.Error> errors;

	public Refund(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Refund setId(String id) {
		this.id = id;

		return this;
	}

	public String getStatus() {
		return status;
	}

	public Refund setStatus(String status) {
		this.status = status;

		return this;
	}

	public Amount getAmount() {
		return amount;
	}

	public Refund setAmount(Amount amount) {
		this.amount = amount;

		return this;
	}

	public String getType() {
		return type;
	}

	public Refund setType(String type) {
		this.type = type;

		return this;
	}

	public FundingInstrument getRefundingInstrument() {
		return refundingInstrument;
	}

	public Refund setRefundingInstrument(FundingInstrument refundingInstrument) {
		this.refundingInstrument = refundingInstrument;

		return this;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Refund setEvents(List<Event> events) {
		this.events = events;

		return this;
	}

	public Links get_links() {
		return _links;
	}

	public Refund set_links(Links _links) {
		this._links = _links;

		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Refund setCreatedAt(String createdAt) {
		this.createdAt = createdAt;

		return this;
	}

	public List<moip.sdk.base.Error> getErrors() {
		return errors;
	}

	public Refund setErrors(List<moip.sdk.base.Error> errors) {
		this.errors = errors;

		return this;
	}

	public Refund create(APIContext apiContext) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
		String pathPost = SINGLE_PATH_1 + "/" + id + "/" + SINGLE_PATH_2;
		String payLoad = "{}";

		return configureAndExecute(apiContext, HttpMethod.POST, pathPost, payLoad, Refund.class);
	}

	public Refund get(APIContext apiContext) throws ClientProtocolException, IOException {

		return get(apiContext, id);
	}

	private Refund get(APIContext apiContext, String refundId) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
		String pathGet = SINGLE_PATH_2 + "/" + refundId;

		return configureAndExecute(apiContext, HttpMethod.GET, pathGet, null, Refund.class);
	}

}
