package moip.sdk.base;

import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

public class APIContext extends BaseAPIContext {
	
	public final static String MULTI = "MULTI";
	public final static String SINGLE = "SINGLE";

	private String accessToken;

	private String oAuthToken;

	public APIContext(String user, String passwork, String oAuthToken) {
		super();
		if (user == null || user.length() <= 0 || passwork == null || passwork.length() <= 0 || oAuthToken == null
				|| oAuthToken.length() <= 0) {
			throw new IllegalArgumentException("User, password or oAuthToken cannot be null");
		}
		String login = user + ":" + passwork;
		this.accessToken ="Basic " + Base64.getEncoder().encodeToString(login.getBytes()).replace("\n", "");
		this.oAuthToken = oAuthToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getoAuthToken() {
		return oAuthToken;
	}

	public ConcurrentHashMap<String, String> getHeadersMap() {
		return super.getHTTPHeaders();
	}

	public void setHeadersMap(ConcurrentHashMap<String, String> headersMap) {
		super.setHTTPHeaders(headersMap);
	}

}