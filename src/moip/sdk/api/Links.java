package moip.sdk.api;

public class Links {
	private Link order;
	private Link self;
	private Link next;
	private Link previous;

	public Link getOrder() {
		return order;
	}

	public Links setOrder(Link order) {
		this.order = order;
		
		return this;
	}

	public Link getSelf() {
		return self;
	}

	public Links setSelf(Link self) {
		this.self = self;
		
		return this;
	}

	public Link getNext() {
		return next;
	}

	public Links setNext(Link next) {
		this.next = next;
		
		return this;
	}

	public Link getPrevious() {
		return previous;
	}

	public Links setPrevious(Link previous) {
		this.previous = previous;
		
		return this;
	}

}

class Link {

	private String href;
	private String title;

	public String getHref() {
		return href;
	}

	public Link setHref(String href) {
		this.href = href;
		
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Link setTitle(String title) {
		this.title = title;
		
		return this;
	}

}
