package moip.sdk.api;

public class Amount {
	private Integer total;
	private Integer fees;
	private Integer refunds; 
	private Integer liquid;
	private Integer otherReceivers;
	private Integer fixed;
	private String currency;
	private SubTotals subtotals;
	

	public Integer getTotal() {
		return total;
	}

	public Amount setTotal(Integer total) {
		this.total = total;
		
		return this;
	}

	public Integer getFees() {
		return fees;
	}

	public Amount setFees(Integer fees) {
		this.fees = fees;
		
		return this;
	}

	public Integer getRefunds() {
		return refunds;
	}

	public Amount setRefunds(Integer refunds) {
		this.refunds = refunds;
		
		return this;
	}

	public Integer getLiquid() {
		return liquid;
	}

	public Amount setLiquid(Integer liquid) {
		this.liquid = liquid;
		
		return this;
	}

	public Integer getOtherReceivers() {
		return otherReceivers;
	}

	public Amount setOtherReceivers(Integer otherReceivers) {
		this.otherReceivers = otherReceivers;
		
		return this;
	}

	public Integer getFixed() {
		return fixed;
	}

	public Amount setFixed(Integer fixed) {
		this.fixed = fixed;
		
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public Amount setCurrency(String currency) {
		this.currency = currency;
		
		return this;
	}

	public SubTotals getSubtotals() {
		return subtotals;
	}

	public Amount setSubtotals(SubTotals subtotals) {
		this.subtotals = subtotals;
		
		return this;
	}
	
}