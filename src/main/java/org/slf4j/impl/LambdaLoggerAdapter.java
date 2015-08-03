package org.slf4j.impl;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.slf4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class LambdaLoggerAdapter extends MarkerIgnoringBase implements Logger, Serializable {

	private final LambdaLogLevel level;
	private final LambdaLogger logger;

	/**
	 * @param level
	 * @param logger
	 */
	LambdaLoggerAdapter(LambdaLogLevel level, LambdaLogger logger) {
		this.level = level;
		name = this.getClass().getSimpleName();
		this.logger = logger;
	}

	/**
	 * @return isTraceCapable
	 */
	public boolean isTraceEnabled() {
		return level.equals(LambdaLogLevel.TRACE);
	}

	/**
	 * @param msg
	 */
	public void trace(String msg) {
		if (isTraceEnabled()) {
			log(LambdaLogLevel.TRACE, msg);
		}
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void trace(String format, Object arg) {
		if (isTraceEnabled()) {
			log(LambdaLogLevel.TRACE, format, arg);
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void trace(String format, Object arg1, Object arg2) {
		if (isTraceEnabled()) {
			log(LambdaLogLevel.TRACE, format, arg1, arg2);
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void trace(String format, Object[] argArray) {
		if (isTraceEnabled()) {
			log(LambdaLogLevel.TRACE, format, argArray);
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void trace(String msg, Throwable ex) {
		if (isTraceEnabled()) {
			log(LambdaLogLevel.TRACE, msg, ex);
		}
	}

	/**
	 * @return isDebugEnabled
	 */
	public boolean isDebugEnabled() {
		return Arrays.asList(LambdaLogLevel.TRACE, LambdaLogLevel.DEBUG).contains(level);
	}

	/**
	 * @param msg
	 */
	public void debug(String msg) {
		if (isDebugEnabled()) {
			log(LambdaLogLevel.DEBUG, msg);
		}
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void debug(String format, Object arg) {
		if (isDebugEnabled()) {
			log(LambdaLogLevel.DEBUG, format, arg);
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void debug(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			log(LambdaLogLevel.DEBUG, format, arg1, arg2);
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void debug(String format, Object[] argArray) {
		if (isDebugEnabled()) {
			log(LambdaLogLevel.DEBUG, format, argArray);
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void debug(String msg, Throwable ex) {
		if (isDebugEnabled()) {
			log(LambdaLogLevel.DEBUG, msg, ex);
		}
	}

	/**
	 * Is this logger instance enabled for the INFO level?
	 *
	 * @return True if this Logger is enabled for the INFO level, false otherwise.
	 */
	public boolean isInfoEnabled() {
		return Arrays.asList(
				LambdaLogLevel.TRACE,
				LambdaLogLevel.DEBUG,
				LambdaLogLevel.INFO
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void info(String msg) {
		if (isInfoEnabled()) {
			log(LambdaLogLevel.INFO, msg);
		}
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void info(String format, Object arg) {
		if (isInfoEnabled()) {
			log(LambdaLogLevel.INFO, format, arg);
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void info(String format, Object arg1, Object arg2) {
		if (isInfoEnabled()) {
			log(LambdaLogLevel.INFO, format, arg1, arg2);
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void info(String format, Object[] argArray) {
		if (isInfoEnabled()) {
			log(LambdaLogLevel.INFO, format, argArray);
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void info(String msg, Throwable ex) {
		if (isInfoEnabled()) {
			log(LambdaLogLevel.INFO, msg, ex);
		}
	}

	/**
	 * Is this logger instance enabled for the WARN level?
	 *
	 * @return True if this Logger is enabled for the WARN level, false otherwise.
	 */
	public boolean isWarnEnabled() {
		return Arrays.asList(
				LambdaLogLevel.TRACE,
				LambdaLogLevel.DEBUG,
				LambdaLogLevel.INFO,
				LambdaLogLevel.WARN
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void warn(String msg) {
		if (isWarnEnabled()) {
			log(LambdaLogLevel.WARN, msg);
		}
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void warn(String format, Object arg) {
		if (isWarnEnabled()) {
			log(LambdaLogLevel.WARN, format, arg);
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void warn(String format, Object arg1, Object arg2) {
		if (isWarnEnabled()) {
			log(LambdaLogLevel.WARN, format, arg1, arg2);
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void warn(String format, Object[] argArray) {
		if (isWarnEnabled()) {
			log(LambdaLogLevel.WARN, format, argArray);
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void warn(String msg, Throwable ex) {
		if (isWarnEnabled()) {
			log(LambdaLogLevel.WARN, msg, ex);
		}
	}

	/**
	 * Is this logger instance enabled for level ERROR?
	 *
	 * @return True if this Logger is enabled for level ERROR, false otherwise.
	 */
	public boolean isErrorEnabled() {
		return Arrays.asList(
				LambdaLogLevel.TRACE,
				LambdaLogLevel.DEBUG,
				LambdaLogLevel.INFO,
				LambdaLogLevel.WARN,
				LambdaLogLevel.ERROR
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void error(String msg) {
		if (isErrorEnabled()) {
			log(LambdaLogLevel.ERROR, msg);
		}
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void error(String format, Object arg) {
		if (isErrorEnabled()) {
			log(LambdaLogLevel.ERROR, format, arg);
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void error(String format, Object arg1, Object arg2) {
		if (isErrorEnabled()) {
			log(LambdaLogLevel.ERROR, format, arg1, arg2);
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void error(String format, Object[] argArray) {
		if (isErrorEnabled()) {
			log(LambdaLogLevel.ERROR, format, argArray);
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void error(String msg, Throwable ex) {
		if (isErrorEnabled()) {
			log(LambdaLogLevel.ERROR, msg, ex);
		}
	}

	/**
	 * @param level
	 * @param msg
	 */
	private void log(LambdaLogLevel level, String msg) {
		log(level, msg, null, null);
	}

	/**
	 * @param level
	 * @param msg
	 * @param ex
	 */
	private void log(LambdaLogLevel level, String msg, Throwable ex) {
		log(level, msg, null, ex);
	}

	/**
	 * @param level
	 * @param format
	 * @param arg
	 */
	private void log(LambdaLogLevel level, String format, Object arg) {
		log(level, format, new Object[]{arg});
	}

	/**
	 * @param level
	 * @param format
	 * @param arg1
	 * @param arg2
	 */
	private void log(LambdaLogLevel level, String format, Object arg1, Object arg2) {
		log(level, format, new Object[]{arg1, arg2});
	}

	/**
	 * @param level
	 * @param format
	 * @param argArray
	 */
	private void log(LambdaLogLevel level, String format, Object[] argArray) {
		log(level, format, argArray, null);
	}

	/**
	 * @param level
	 * @param format
	 * @param argArray
	 * @param ex
	 */
	private void log(
			      LambdaLogLevel level,
					String format,
					Object[] argArray,
					Throwable ex) {
		String entry = level + ": ";

		if (argArray != null && argArray.length > 0) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			entry += formattingTuple.getMessage();
		} else {
			entry += format;
		}

		if (ex != null) {
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			entry += "\nWith exception: " + ex.getMessage() + "\nStack trace:\n" + sw;
		}

		logger.log(entry);
	}

}
