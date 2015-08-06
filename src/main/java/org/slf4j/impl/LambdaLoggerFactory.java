package org.slf4j.impl;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
		final LambdaLogLevel logLevel = loadFromClassPath();
		return new LambdaLoggerAdapter(logLevel, threadLocal.get());
	}

	private static LambdaLogLevel loadFromClassPath() {
		LambdaLogLevel logLevel = LambdaLogLevel.INFO;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(
					  LambdaLoggerFactory.class.getClassLoader().getResourceAsStream("lambda-logger.xml"));
			final NodeList nodes = document.getElementsByTagName("level");
			final Element element = (Element)nodes.item(0);
			final String level = element.getTextContent();
			logLevel = LambdaLogLevel.valueOf(level.toUpperCase());
		} catch (Exception ex) {}

		return logLevel;
	}

}
