package com.jwmsolutions.timeCheck.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampPerson extends BaseObject {
	private Integer id;
	private String userName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampPerson)) {
			return false;
		}
		BasecampPerson rhs = (BasecampPerson) object;
		return new EqualsBuilder().append(this.id, rhs.id).append(
				this.userName, rhs.userName).append(this.datePatterns,
				rhs.datePatterns).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-152358101, 668187973).append(this.id)
				.append(this.userName).append(this.datePatterns).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("userName", this.userName)
				.append("id", this.id).toString();
	}
}
