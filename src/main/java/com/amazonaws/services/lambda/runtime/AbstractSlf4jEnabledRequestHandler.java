package com.amazonaws.services.lambda.runtime;

import org.slf4j.impl.LambdaLoggerFactory;

/**
 * Created by jeremyw on 8/2/15.
 */
public abstract class AbstractSlf4jEnabledRequestHandler<I, O> implements RequestHandler<I, O> {

	/**
	 * @param input
	 * @param context
	 * @return
	 */
	public O handleRequest(I input, Context context) {
		LambdaLoggerFactory.setLogger(context.getLogger());

		final O output = handle(input, context);

		LambdaLoggerFactory.clearLogger();

		return output;
	}

	/**
	 * @param input
	 * @param context
	 * @return
	 */
	protected abstract O handle(I input, Context context);

}
