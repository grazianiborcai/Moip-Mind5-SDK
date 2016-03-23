package moip.sdk.base;

import java.util.concurrent.ConcurrentHashMap;

public class BaseAPIContext {
	
	private ConcurrentHashMap<String, String> HTTPHeaders;
	
	private ConcurrentHashMap<String, String> configurationMap;
	
	public BaseAPIContext() {
		
	}

	/**
	 * @return the hTTPHeaders
	 */
	public ConcurrentHashMap<String, String> getHTTPHeaders() {
		return HTTPHeaders;
	}

	/**
	 * @param httpHeaders the httpHeaders to set
	 */
	public void setHTTPHeaders(ConcurrentHashMap<String, String> httpHeaders) {
		HTTPHeaders = httpHeaders;
	}

	/**
	 * @return the configurationMap
	 */
	public ConcurrentHashMap<String, String> getConfigurationMap() {
		return configurationMap;
	}

	/**
	 * @param configurationMap the configurationMap to set
	 */
	public void setConfigurationMap(ConcurrentHashMap<String, String> configurationMap) {
		this.configurationMap = configurationMap;
	}
	
}
