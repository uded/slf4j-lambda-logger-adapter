package com.amazonaws.services.lambda.runtime;

import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
public class Slf4jLambdaLogger extends MarkerIgnoringBase implements LocationAwareLogger, Serializable {

	private final Slf4jLambdaLogLevel level;

	/**
	 *
	 * @param level
	 */
	Slf4jLambdaLogger(Slf4jLambdaLogLevel level) {
		this.level = level;
		name = this.getClass().getSimpleName();
	}

	/**
	 * @return isTraceCapable
	 */
	public boolean isTraceEnabled() {
		return level.equals(Slf4jLambdaLogLevel.TRACE);
	}

	/**
	 * @param msg
	 */
	public void trace(String msg) {
		if (!isTraceEnabled()) {
			return;
		}

		System.out.println(msg);
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void trace(String format, Object arg) {
		if (isTraceEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void trace(String format, Object arg1, Object arg2) {
		if (isTraceEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void trace(String format, Object[] argArray) {
		if (isTraceEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void trace(String msg, Throwable ex) {
		if (isTraceEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(msg, ex);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @return isDebugEnabled
	 */
	public boolean isDebugEnabled() {
		return Arrays.asList(Slf4jLambdaLogLevel.TRACE, Slf4jLambdaLogLevel.DEBUG).contains(level);
	}

	/**
	 * @param msg
	 */
	public void debug(String msg) {
		if (!isDebugEnabled()) {
			return;
		}

		System.out.println(msg);
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void debug(String format, Object arg) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void debug(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void debug(String format, Object[] argArray) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void debug(String msg, Throwable ex) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(msg, ex);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * Is this logger instance enabled for the INFO level?
	 *
	 * @return True if this Logger is enabled for the INFO level, false otherwise.
	 */
	public boolean isInfoEnabled() {
		return Arrays.asList(
				Slf4jLambdaLogLevel.TRACE,
				Slf4jLambdaLogLevel.DEBUG,
				Slf4jLambdaLogLevel.INFO
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void info(String msg) {
		if (!isDebugEnabled()) {
			return;
		}

		System.out.println(msg);
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void info(String format, Object arg) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void info(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void info(String format, Object[] argArray) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void info(String msg, Throwable ex) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(msg, ex);
			System.out.println(formattingTuple.getMessage());
		}
	}

	/**
	 * Is this logger instance enabled for the WARN level?
	 *
	 * @return True if this Logger is enabled for the WARN level, false otherwise.
	 */
	public boolean isWarnEnabled() {
		return Arrays.asList(
				Slf4jLambdaLogLevel.TRACE,
				Slf4jLambdaLogLevel.DEBUG,
				Slf4jLambdaLogLevel.INFO,
				Slf4jLambdaLogLevel.WARN
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void warn(String msg) {
		if (!isDebugEnabled()) {
			return;
		}

		System.err.println(msg);
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void warn(String format, Object arg) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void warn(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void warn(String format, Object[] argArray) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void warn(String msg, Throwable ex) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(msg, ex);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * Is this logger instance enabled for level ERROR?
	 *
	 * @return True if this Logger is enabled for level ERROR, false otherwise.
	 */
	public boolean isErrorEnabled() {
		return Arrays.asList(
				Slf4jLambdaLogLevel.TRACE,
				Slf4jLambdaLogLevel.DEBUG,
				Slf4jLambdaLogLevel.INFO,
				Slf4jLambdaLogLevel.WARN,
				Slf4jLambdaLogLevel.ERROR
		).contains(level);
	}

	/**
	 * @param msg
	 */
	public void error(String msg) {
		if (!isDebugEnabled()) {
			return;
		}

		System.err.println(msg);
	}

	/**
	 * @param format
	 * @param arg
	 */
	public void error(String format, Object arg) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public void error(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param format   the format string
	 * @param argArray an array of arguments
	 */
	public void error(String format, Object[] argArray) {
		if (isDebugEnabled()) {
			FormattingTuple formattingTuple = MessageFormatter.format(format, argArray);
			System.err.println(formattingTuple.getMessage());
		}
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public void error(String msg, Throwable ex) {
		if (isDebugEnabled()) {
			System.err.println(msg);
		}
	}

	/**
	 * @param marker
	 * @param callerFQCN
	 * @param level
	 * @param msg
	 * @param argArray
	 * @param ex
	 */
	public void log(Marker marker,
					String callerFQCN,
					int level,
					String msg,
					Object[] argArray,
					Throwable ex) {
		System.out.println(msg);
	}
}
