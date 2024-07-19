package com.Andromeda.RestAssuredTests;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.Sagitarrius.samples.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleTest {

	@Test
	public void TestMethod001()
	{	
		RestAssured.baseURI = Constants.URI;
		int statusCode = RestAssured.given()
									.contentType(ContentType.JSON)
									.body(Constants.SAMPLE_BODY_POSITIVE_RESPONSE).post()
									.getStatusCode();
		assert(statusCode == Constants.SUCCESS_STATUS_CODE);
	}
	
	@Test
	public void TestMethod002()
	{
		RestAssured.baseURI = Constants.URI;
		
		int statusCode = RestAssured.given().contentType(ContentType.JSON)
											.body(Constants.SAMPLE_BODY_NEGATIVE_RESPONSE).post()
											.getStatusCode();
		
		assert(statusCode == Constants.FAILURE_STATUS_CODE);
	}
	
	
}
