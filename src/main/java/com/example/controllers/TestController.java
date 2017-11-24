package com.example.controllers;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj)
			throws JSONException, IOException, Exception {

		final String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String CHANNEL_ACCESS_TOKEN = "1TKsNlco33lClObPI0+n75Ugr7t2saKcGuNpVrfy4+QtqtU8DFmCNAMXzsrPZX4lmlzCRzHDAV96CAJL+uPnub66R292Qzw85ZZb6ryfLLXaxTCjCwhfuEltPWyKkhRjdFeEeSTbh9AqFAHF58CinAdB04t89/1O/w1cDnyilFU=";

		

		Map<String, Object> json = new HashMap<String, Object>();

		JSONObject jsonResult = new JSONObject(obj);

		System.out.println("******************JSON RESULT!!!!!!! :    " + jsonResult);

		JSONObject rsl = jsonResult.getJSONObject("originalRequest");
		JSONObject data = rsl.getJSONObject("data");
		JSONObject source = data.getJSONObject("source");
		JSONObject message = data.getJSONObject("message");
		String userId = source.getString("userId");
		String customerMessage = message.getString("text");
		String timestamp = jsonResult.getString("timestamp");
		String language = jsonResult.getString("lang");
		JSONObject result = jsonResult.getJSONObject("result");
		JSONObject metadata = result.getJSONObject("metadata");
		String intentName = metadata.getString("intentName");
		JSONObject parameters = result.getJSONObject("parameters");
		JSONObject fulfillment = result.getJSONObject("fulfillment");
		String speech = fulfillment.getString("speech");

		System.out.println("********************CUSTOMER MESSAGE : " + customerMessage);
		System.out.println("********************LANGUAGE : " + language);
		System.out.println("*******************INTENT NAME : " + intentName);
		System.out.println("********************CUSTOMER MESSAGE : " + customerMessage);
		return json;
	}
}
