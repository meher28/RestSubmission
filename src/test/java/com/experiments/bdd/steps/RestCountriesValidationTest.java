package com.experiments.bdd.steps;

import java.util.Map;

import org.json.simple.JSONObject;

import com.experiments.bdd.rest.JsonRequester;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class RestCountriesValidationTest {

	private Map<String, JSONObject> countriesMap;
	private JSONObject _country;
	private JsonRequester jr;

	@Given("^user make a get request to \"(.*?)\"$")
	public void user_make_a_get_request_to(String requestURL) throws Throwable {
		jr = new JsonRequester(requestURL);
	}

	@When("^users selects \"(.*?)\"$")
	public void users_selects(String country) throws Throwable {
		_country = jr.getCountryInfo(country);
	}

	@Then("^the requested \"(.*?)\" and \"(.*?)\" is returned$")
	public void the_requested_and_is_returned(String country, String capital) throws Throwable {
		Assert.assertEquals(capital, _country.get("capital"));
	}
}
