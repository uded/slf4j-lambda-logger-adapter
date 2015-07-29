package com.amazonaws.services.lambda.runtime;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class Slf4jLambdaLoggerFactory implements ILoggerFactory {

	public Logger getLogger(String level) {
		Slf4jLambdaLogLevel logLevel = Slf4jLambdaLogLevel.valueOf(level);
		return new Slf4jLambdaLogger(logLevel);
	}
}
