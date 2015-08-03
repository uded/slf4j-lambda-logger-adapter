package org.slf4j.impl;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.Test;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class LambdaLoggerAdapterTest {

	@Test
	public void testLoggingAdapter() {
		LambdaLoggerFactory.setLogger(getLogger());
		final LambdaLoggerFactory factory = new LambdaLoggerFactory();
		final Logger logger = factory.getLogger(null);

		logger.trace("Test TRACE");
		logger.trace("Test TRACE with arg {}", new Object());
		logger.trace("Test TRACE with exception", new Exception("Exception"));

		logger.info("Test INFO");
		logger.info("Test INFO with arg {}", new Object());
		logger.info("Test INFO with exception", new Exception("Exception"));

		logger.error("Test ERROR");
		logger.error("Test ERROR with arg {}", new Object());
		logger.error("Test ERROR with exception", new Exception("Exception"));
	}

	/**
	 * @return
	 */
	private LambdaLogger getLogger() {
		return new LambdaLogger() {
			public void log(String s) {
				System.out.println(s);
			}
		};
	}

}
