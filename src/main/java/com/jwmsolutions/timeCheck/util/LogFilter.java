package com.jwmsolutions.timeCheck.util;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 * Clase usada para realizar el filtro de los logs
 */
public class LogFilter extends Filter {

	/**
	 * @see org.apache.log4j.spi.Filter#decide(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	public int decide(LoggingEvent event) {
		if (StringUtils.equals(event.getLoggerName(), Constants.LOG_GLOBAL_NAME)) {
			return NEUTRAL;
		}
		return DENY;
	}

	public static Logger getLoggerInstance() {
		return Logger.getLogger(Constants.LOG_GLOBAL_NAME);
	}
}
