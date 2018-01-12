package com.experiments.bdd.steps;

import com.experiments.bdd.rest.JsonRequester;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class RequestMetaDataTest {

	private JsonRequester jr;

	@Given("^user makes a get request to countriesURL \"(.*?)\"$")
	public void user_makes_a_get_request_to_countriesURL(String requestURL) throws Throwable {
		jr = new JsonRequester(requestURL);
	}

	@Then("^the request status should be (\\d+) and request content type should be \"(.*?)\"$")
	public void the_request_status_should_be_and_request_content_type_should_be(int responseStatusCode,
			String contentType) throws Throwable {
		Assert.assertEquals(responseStatusCode, jr.getResponseStatusCode());
		Assert.assertEquals(contentType, jr.getresponseContentType());
	}

}
