package org.slf4j.impl;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class LambdaLoggerFactory implements ILoggerFactory {

	private static ThreadLocal<LambdaLogger> threadLocal = new ThreadLocal<LambdaLogger>();

	public static void setLogger(LambdaLogger lambdaLogger) {
		threadLocal.set(lambdaLogger);
	}

	public static void clearLogger() {
		threadLocal.set(null);
	}

	public Logger getLogger(String className) {
		final LambdaLogLevel logLevel = LambdaLogLevel.INFO;
		return new LambdaLoggerAdapter(logLevel, threadLocal.get());
	}

}
