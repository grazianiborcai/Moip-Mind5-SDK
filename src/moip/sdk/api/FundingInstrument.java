package moip.sdk.api;

public class FundingInstrument {
	private String method;
	private CreditCard creditCard;

	public String getMethod() {
		return method;
	}

	public FundingInstrument setMethod(String method) {
		this.method = method;
		
		return this;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public FundingInstrument setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
		
		return this;
	}
}
