package com.amazonaws.services.lambda.runtime;

import org.slf4j.impl.LambdaLoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jeremyw on 8/2/15.
 */
public abstract class AbstractSlf4jEnabledRequestStreamHandler implements RequestStreamHandler {

	/**
	 * @param input
	 * @param output
	 * @param context
	 * @throws IOException
	 */
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		LambdaLoggerFactory.setLogger(context.getLogger());

		handle(input, output, context);

		LambdaLoggerFactory.clearLogger();
	}

	/**
	 * @param input
	 * @param output
	 * @param context
	 * @throws IOException
	 */
	protected abstract void handle(InputStream input, OutputStream output, Context context) throws IOException;

}
