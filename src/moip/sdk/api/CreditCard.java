package moip.sdk.api;

public class CreditCard {
	private String id;
	private String hash;
	private Customer holder;

	public String getId() {
		return id;
	}

	public CreditCard setId(String id) {
		this.id = id;
		
		return this;
	}

	public String getHash() {
		return hash;
	}

	public CreditCard setHash(String hash) {
		this.hash = hash;
		
		return this;
	}

	public Customer getHolder() {
		return holder;
	}

	public CreditCard setHolder(Customer holder) {
		this.holder = holder;
		
		return this;
	}

}
