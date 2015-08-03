package com.amazonaws.services.lambda.runtime;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jeremyw on 8/2/15.
 */
public class AbstractSlf4JEnabledRequestStreamHandlerTest extends AbstractSlf4jEnabledRequestStreamHandler {

	@Test
	public void testHandleRequest() throws IOException {
		final ByteArrayInputStream input = new ByteArrayInputStream("Hello".getBytes());
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		handleRequest(input, output, getContext());
		assertEquals("Messages did not match", "Hello", new String(output.toByteArray()));
	}

	@Override
	protected void handle(InputStream input, OutputStream output, Context context) throws IOException {
		final Logger logger = LoggerFactory.getLogger(AbstractSlf4JEnabledRequestHandlerTest.class);
		final Scanner scanner = new Scanner(input).useDelimiter("\\A");
		final String message = scanner.hasNext() ? scanner.next() : "";
		input.close();
		logger.info("Logging message - " + message);
		output.write(message.getBytes());
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
