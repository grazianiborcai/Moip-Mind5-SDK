package moip.sdk.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

import moip.sdk.base.APIContext;
import moip.sdk.base.HttpMethod;
import moip.sdk.base.HttpsBase;

public class Order extends HttpsBase {

	public final static String MULTI_PATH = "multiorders";
	public final static String SINGLE_PATH = "orders";

	private String type;

	private String id;
	private String ownId;
	private String status;
	private String createdAt;
	private String updatedAt;
	private Amount amount;
	private List<Order> orders;
	private List<Item> items;
	private Customer customer;
	private List<Payment> payment;
	private List<Event> events;
	private List<Receiver> receivers;
	private Links _links;
	private Summary summary;
	private List<moip.sdk.base.Error> errors;

	public Order() {

	}

	public Order(String type) {
		this.type = type;
	}

	public Order(String type, String id) {
		this.type = type;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Order setId(String id) {
		this.id = id;

		return this;
	}

	public String getOwnId() {
		return ownId;
	}

	public Order setOwnId(String ownId) {
		this.ownId = ownId;

		return this;
	}

	public String getStatus() {
		return status;
	}

	public Order setStatus(String status) {
		this.status = status;

		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Order setCreatedAt(String createdAt) {
		this.createdAt = createdAt;

		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Order setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;

		return this;
	}

	public Amount getAmount() {
		return amount;
	}

	public Order setAmount(Amount amount) {
		this.amount = amount;

		return this;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Order setOrders(List<Order> orders) {
		this.orders = orders;

		return this;
	}

	public List<Item> getItems() {
		return items;
	}

	public Order setItems(List<Item> items) {
		this.items = items;

		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Order setCustomer(Customer customer) {
		this.customer = customer;

		return this;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public Order setPayment(List<Payment> payment) {
		this.payment = payment;

		return this;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Order setEvents(List<Event> events) {
		this.events = events;

		return this;
	}

	public List<Receiver> getReceivers() {
		return receivers;
	}

	public Order setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;

		return this;
	}

	public Links get_links() {
		return _links;
	}

	public Order set_links(Links _links) {
		this._links = _links;

		return this;
	}

	public Summary getSummary() {
		return summary;
	}

	public Order setSummary(Summary summary) {
		this.summary = summary;

		return this;
	}

	public List<moip.sdk.base.Error> getErrors() {
		return errors;
	}

	public Order setErrors(List<moip.sdk.base.Error> errors) {
		this.errors = errors;

		return this;
	}

	public Order addOrder(Order order) {
		if (getOrders() == null)
			setOrders(new ArrayList<Order>());

		getOrders().add(order.setCustomer(getCustomer()));

		return this;
	}

	public Order addItem(Item item) {
		if (getItems() == null)
			setItems(new ArrayList<Item>());

		getItems().add(item);

		return this;
	}

	public Order addReceiver(Receiver receiver) {
		if (getReceivers() == null)
			setReceivers(new ArrayList<Receiver>());

		getReceivers().add(receiver);

		return this;
	}

	public Order create(APIContext apiContext) throws ClientProtocolException, IOException {
		checkApiContext(apiContext);
		apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
		String pathPost = null;
		if (type.equals(APIContext.MULTI)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
			pathPost = MULTI_PATH;
		} else if (type.equals(APIContext.SINGLE)) {
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
			pathPost = SINGLE_PATH;
		}
		String payLoad = new Gson().toJsonTree(this).toString();

		return configureAndExecute(apiContext, HttpMethod.POST, pathPost, payLoad, Order.class);
	}

	public Order get(APIContext apiContext) throws ClientProtocolException, IOException {

		return get(apiContext, id);
	}

	public Order getAll(APIContext apiContext) throws ClientProtocolException, IOException {
		if (type.equals(APIContext.SINGLE)) {
			checkApiContext(apiContext);
			apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
			apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());

			return configureAndExecute(apiContext, HttpMethod.GET, SINGLE_PATH, null, Order.class);
		} else
			return null;

	}

	private Order get(APIContext apiContext, String orderId) throws ClientProtocolException, IOException {
		if (orderId != null) {
			checkApiContext(apiContext);
			apiContext.getHTTPHeaders().put(HTTP_CONTENT_TYPE_HEADER, HTTP_CONTENT_TYPE_JSON);
			String pathGet = null;
			if (type.equals(APIContext.MULTI)) {
				apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getoAuthToken());
				pathGet = MULTI_PATH + "/" + orderId;
			} else if (type.equals(APIContext.SINGLE)) {
				apiContext.getHTTPHeaders().put(AUTHORIZATION_HEADER, apiContext.getAccessToken());
				pathGet = SINGLE_PATH + "/" + orderId;
			}

			return configureAndExecute(apiContext, HttpMethod.GET, pathGet, null, Order.class);
		} else
			return null;

	}

}
