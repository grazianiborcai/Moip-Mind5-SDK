package moip.sdk.api;

public class MoipAccount {

	private String id;
	private Customer person;
	private Boolean transparentAccount;
	private Email email;
	private String createdAt;
	private Links _links;
	private String login;
	private String type;
	private String fullname;

	public String getId() {
		return id;
	}

	public MoipAccount setId(String id) {
		this.id = id;
		
		return this;
	}

	public Customer getPerson() {
		return person;
	}

	public MoipAccount setPerson(Customer person) {
		this.person = person;
		
		return this;
	}

	public Boolean getTransparentAccount() {
		return transparentAccount;
	}

	public MoipAccount setTransparentAccount(Boolean transparentAccount) {
		this.transparentAccount = transparentAccount;
		
		return this;
	}

	public Email getEmail() {
		return email;
	}

	public MoipAccount setEmail(Email email) {
		this.email = email;
		
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public MoipAccount setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		
		return this;
	}

	public Links get_links() {
		return _links;
	}

	public MoipAccount set_links(Links _links) {
		this._links = _links;
		
		return this;
	}

	public String getLogin() {
		return login;
	}

	public MoipAccount setLogin(String login) {
		this.login = login;
		
		return this;
	}

	public String getType() {
		return type;
	}

	public MoipAccount setType(String type) {
		this.type = type;
		
		return this;
	}

	public String getFullname() {
		return fullname;
	}

	public MoipAccount setFullname(String fullname) {
		this.fullname = fullname;
		
		return this;
	}

}
