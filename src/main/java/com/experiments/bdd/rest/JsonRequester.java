package com.experiments.bdd.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Json requester class for making rest requests using http client
 * 
 * @author meherm01
 *
 */
public class JsonRequester {
	private Map<String, JSONObject> countriesMap;
	private JSONObject _country = null;
	private HttpResponse httpResponse;
	private HttpEntity entity;
	private String responseString;
	private JSONParser parser;
	private Object obj;
	private JSONArray array;

	public JsonRequester(String requestUrl) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet("https://restcountries.eu/rest/v1/all");
			request.addHeader("accept", "application/json");
			httpResponse = httpClient.execute(request);
			entity = httpResponse.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			parser = new JSONParser();
			obj = parser.parse(responseString);
			array = (JSONArray) obj;
			Set<JSONObject> jsonObjs = new HashSet();

			for (int i = 0; i < array.size(); i++) {
				jsonObjs.add((JSONObject) array.get(i));
			}
			countriesMap = new HashMap<>();
			for (JSONObject object : jsonObjs) {
				String name = (String) object.get("name");
				countriesMap.put(name, object);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method return County info in the form of JSON object
	 * 
	 * @param country
	 * @return JSON country object
	 */
	public JSONObject getCountryInfo(String country) {
		_country = countriesMap.get(country);
		return _country;
	}

	/**
	 * This method returns the status of the http response
	 * 
	 * @return statuscode
	 */
	public int getResponseStatusCode() {
		return httpResponse.getStatusLine().getStatusCode();
	}

	/**
	 * This method returns the content type of the response
	 * 
	 * @return content type
	 */
	public String getresponseContentType() {
		Header contentType = entity.getContentType();
		return contentType.getValue();
	}

}
