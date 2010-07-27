package com.jwmsolutions.timeCheck.model;

import static com.jwmsolutions.timeCheck.CoreObject.getGlobalProperties;

import com.jwmsolutions.timeCheck.util.Constants;
import com.jwmsolutions.timeCheck.util.LogFilter;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public abstract class BaseObject implements Comparable {
	protected static final org.apache.log4j.Logger log = LogFilter.getLoggerInstance();
	String[] datePatterns = {
			getGlobalProperties().getProperty(Constants.DATE_FORMAT_DATE),
			getGlobalProperties().getProperty(Constants.DATE_FORMAT_DATETIME)
	};

	public BaseObject() {
		super();
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public abstract boolean equals(Object object);

	/**
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public abstract int hashCode();

	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(Object object) {
		BaseObject myClass = (BaseObject) object;
		return new CompareToBuilder().append(this.datePatterns,
				myClass.datePatterns).toComparison();
	}
}
