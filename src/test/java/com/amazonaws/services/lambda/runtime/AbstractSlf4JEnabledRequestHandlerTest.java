package com.amazonaws.services.lambda.runtime;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jeremyw on 8/2/15.
 */
public class AbstractSlf4JEnabledRequestHandlerTest extends AbstractSlf4jEnabledRequestHandler<TestRequest, TestResponse> {

	@Test
	public void testHandleRequest() {
		final TestRequest testRequest = new TestRequest();
		testRequest.setMessage("Hello");
		TestResponse testResponse = handleRequest(testRequest, getContext());
		assertEquals("Messages did not match", "Hello", testResponse.getMessage());
	}

	@Override
	protected TestResponse handle(TestRequest testRequest, Context context) {
		final Logger logger = LoggerFactory.getLogger(AbstractSlf4JEnabledRequestHandlerTest.class);
		logger.info("Logging message - " + testRequest.getMessage());
		return new TestResponse(testRequest.getMessage());
	}

	/**
	 * @return context
	 */
	private Context getContext() {
		return new Context() {
			public String getAwsRequestId() {
				return null;
			}

			public String getLogGroupName() {
				return null;
			}

			public String getLogStreamName() {
				return null;
			}

			public String getFunctionName() {
				return null;
			}

			public CognitoIdentity getIdentity() {
				return null;
			}

			public ClientContext getClientContext() {
				return null;
			}

			public int getRemainingTimeInMillis() {
				return 0;
			}

			public int getMemoryLimitInMB() {
				return 0;
			}

			public LambdaLogger getLogger() {
				return new LambdaLogger() {
					public void log(String s) {
						System.out.println(s);
					}
				};
			}
		};
	}

}
