package moip.sdk.api;

public class Receiver {

	private MoipAccount moipAccount;
	private String type;
	private Amount amount;

	public MoipAccount getMoipAccount() {
		return moipAccount;
	}

	public Receiver setMoipAccount(MoipAccount moipAccount) {
		this.moipAccount = moipAccount;
		
		return this;
	}

	public String getType() {
		return type;
	}

	public Receiver setType(String type) {
		this.type = type;
		
		return this;
	}

	public Amount getAmount() {
		return amount;
	}

	public Receiver setAmount(Amount amount) {
		this.amount = amount;
		
		return this;
	}

}
