package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class StaticLoggerBinder {

	public static String REQUESTED_API_VERSION = "1.7";
	private static final String LOGGER_FACTORY_CLASS_STR = LambdaLoggerFactory.class.getName();
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
	private final ILoggerFactory loggerFactory;

	/**
	 * @return singleton
	 */
	public static StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	/**
	 * Private constructor
	 */
	private StaticLoggerBinder() {
		loggerFactory = new LambdaLoggerFactory();
	}

	/**
	 * @return loggerFactory
	 */
	public ILoggerFactory getLoggerFactory() {
		return loggerFactory;
	}

	/**
	 * @return loggerFactoryClassStr
	 */
	public String getLoggerFactoryClassStr() {
		return LOGGER_FACTORY_CLASS_STR;
	}
}
