package moip.sdk.api;

public class Item {

	private String product;
	private Integer price;
	private String detail;
	private Integer quantity;

	public String getProduct() {
		return product;
	}

	public Item setProduct(String product) {
		this.product = product;

		return this;
	}

	public Integer getPrice() {
		return price;
	}

	public Item setPrice(Integer price) {
		this.price = price;

		return this;
	}

	public String getDetail() {
		return detail;
	}

	public Item setDetail(String detail) {
		this.detail = detail;

		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Item setQuantity(Integer quantity) {
		this.quantity = quantity;

		return this;
	}

}
