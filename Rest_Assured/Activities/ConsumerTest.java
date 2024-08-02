package pact;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(pactConsumerTestExt.class)
public class ConsumerTest {
	public static void main(String[] args) {
		// Create Map for the headers
		Map<String, String> headers = new HashMap<String, String>();
		// Set resource URI
		String createUser = "/api/users";
		@Pact(provider = "UserProvider", consumer = "UserConsumer")
		public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException { 
		    ...
		    DslPart bodySentCreateUser = new PactDslJsonBody()
		    .numberType("id", 1)
		    .stringType("firstName", "string")
		    .stringType("lastName", "string")
		    .stringType("email", "string");
		    DslPart bodyReceivedCreateUser = new PactDslJsonBody()
		    	    .numberType("id", 1)
		    	    .stringType("firstName", "string")
		    	    .stringType("lastName", "string")
		    	    .stringType("email", "string");
		    return builder.given("A request to create a user")
		    	    .uponReceiving("A request to create a user")
		    	        .path(createUser)
		    	        .method("POST")
		    	        .headers(headers)
		    	        .body(bodySentCreateUser)
		    	    .willRespondWith()
		    	        .status(201)
		    	        .body(bodyReceivedCreateUser)
		    	    .toPact();
		}

	}
}
	
	
