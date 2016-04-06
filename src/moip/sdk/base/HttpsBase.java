package moip.sdk.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpsBase {
	public final static String SANDBOX = "https://sandbox.moip.com.br/v2/";
	public final static String PRODUCTION = "https://api.moip.com.br/v2/";

	public static final String HTTP_CONTENT_TYPE_HEADER = "Content-Type";
	public static final String HTTP_CONTENT_TYPE_JSON = "application/json";
	public static final String AUTHORIZATION_HEADER = "Authorization";

	public <T> T configureAndExecute(APIContext apiContext, HttpMethod httpMethod, String resourcePath, String payLoad,
			Class<T> clazz) throws ClientProtocolException, IOException {

		String path = null;
		String mode = apiContext.getConfigurationMap().get("mode");
		if (mode.equals("sandbox")) {
			path = SANDBOX + resourcePath;
		} else if (mode.equals("production")) {
			path = PRODUCTION + resourcePath;
		}

		CloseableHttpClient httpClient = HttpClients.createDefault();

		CloseableHttpResponse httpResponse;
		StringBuffer response = new StringBuffer();
		if (httpMethod.equals(HttpMethod.GET)) {
			HttpGet httpGet = new HttpGet(path);
			for (Map.Entry<String, String> entry : apiContext.getHeadersMap().entrySet()) {
				httpGet.addHeader(entry.getKey(), entry.getValue());
			}
			httpResponse = httpClient.execute(httpGet);
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			httpClient.close();

		} else if (httpMethod.equals(HttpMethod.POST)) {
			HttpPost httpPost = new HttpPost(path);
			for (Map.Entry<String, String> entry : apiContext.getHeadersMap().entrySet()) {
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
			StringEntity se = new StringEntity(payLoad);
			httpPost.setEntity(se);
			httpResponse = httpClient.execute(httpPost);
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			httpClient.close();

		}

		JsonObject object = new JsonParser().parse(response.toString()).getAsJsonObject();

		return new Gson().fromJson(object, clazz);
	}

	public void checkApiContext(APIContext apiContext) {
		if (apiContext == null) {
			throw new IllegalArgumentException("APIContext cannot be null");
		}
		if (apiContext.getAccessToken() == null || apiContext.getAccessToken().trim().length() <= 0) {
			throw new IllegalArgumentException("AccessToken cannot be null or empty");
		}
		if (apiContext.getoAuthToken() == null || apiContext.getoAuthToken().trim().length() <= 0) {
			throw new IllegalArgumentException("OAuthToken() cannot be null or empty");
		}
		if (apiContext.getHTTPHeaders() == null) {
			apiContext.setHTTPHeaders(new ConcurrentHashMap<String, String>());
		}
	}

}
