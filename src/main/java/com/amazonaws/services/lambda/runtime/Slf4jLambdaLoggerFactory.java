package com.amazonaws.services.lambda.runtime;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class Slf4jLambdaLoggerFactory implements ILoggerFactory {

	public Logger getLogger(String className) {
		Slf4jLambdaLogLevel logLevel = Slf4jLambdaLogLevel.INFO;
		return new Slf4jLambdaLogger(logLevel);
	}
}
