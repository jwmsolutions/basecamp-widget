package com.jwmsolutions.timeCheck.model;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.time.DateUtils;

import com.jwmsolutions.timeCheck.util.Constants;

import static com.jwmsolutions.timeCheck.CoreObject.*;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 * Clase para mapear las respuestas de la API de Basecamp para elementos ACCOUNT
 * por lo tanto, todas las propiedades deben tener un nombre exactamente igual
 * al nombre del elemento correspondiente en la respuesta XML, por ejemplo:
 * para el elemento
 * <account-holder-id ...>val</account-holder-id>
 * la propiedad será "accountHolderId"
 */
public class BasecampAccount extends BaseObject {
	private Integer id;
	private String name;
	private Integer accountHolderId;
	private Boolean emailNotificationEnabled;
	private Boolean timeTrackingEnabled;
	private String updatedAt;
	private String createdAt;
	private Integer primaryCompanyId;
	private Boolean sslEnabled;

	public BasecampAccount() {
		super();
	}

	public BasecampAccount(Integer id, String name, Integer accountHolderId,
			Boolean emailNotificationEnabled, Boolean timeTrackingEnabled,
			String updatedAt, String createdAt, Integer primaryCompanyId,
			Boolean sslEnabled) {
		super();
		this.id = id;
		this.name = name;
		this.accountHolderId = accountHolderId;
		this.emailNotificationEnabled = emailNotificationEnabled;
		this.timeTrackingEnabled = timeTrackingEnabled;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.primaryCompanyId = primaryCompanyId;
		this.sslEnabled = sslEnabled;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(Integer accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public Boolean getEmailNotificationEnabled() {
		return emailNotificationEnabled;
	}
	public void setEmailNotificationEnabled(Boolean emailNotificationEnabled) {
		this.emailNotificationEnabled = emailNotificationEnabled;
	}
	public Boolean getTimeTrackingEnabled() {
		return timeTrackingEnabled;
	}
	public void setTimeTrackingEnabled(Boolean timeTrackingEnabled) {
		this.timeTrackingEnabled = timeTrackingEnabled;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getPrimaryCompanyId() {
		return primaryCompanyId;
	}
	public void setPrimaryCompanyId(Integer primaryCompanyId) {
		this.primaryCompanyId = primaryCompanyId;
	}
	public Boolean getSslEnabled() {
		return sslEnabled;
	}
	public void setSslEnabled(Boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampAccount)) {
			return false;
		}
		BasecampAccount rhs = (BasecampAccount) object;
		return new EqualsBuilder().append(this.updatedAt, rhs.updatedAt)
				.append(this.id, rhs.id)
				.append(this.sslEnabled, rhs.sslEnabled).append(
						this.timeTrackingEnabled, rhs.timeTrackingEnabled)
				.append(this.primaryCompanyId, rhs.primaryCompanyId).append(
						this.createdAt, rhs.createdAt).append(this.name,
						rhs.name).append(this.accountHolderId,
						rhs.accountHolderId).append(this.datePatterns,
						rhs.datePatterns).append(this.emailNotificationEnabled,
						rhs.emailNotificationEnabled).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-195381951, -412652979).append(
				this.updatedAt).append(this.id).append(this.sslEnabled).append(
				this.timeTrackingEnabled).append(this.primaryCompanyId).append(
				this.createdAt).append(this.name).append(this.accountHolderId)
				.append(this.datePatterns)
				.append(this.emailNotificationEnabled).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("timeTrackingEnabled",
				this.timeTrackingEnabled).append("emailNotificationEnabled",
				this.emailNotificationEnabled).append("accountHolderId",
				this.accountHolderId).append("name", this.name).append(
				"primaryCompanyId", this.primaryCompanyId).append("sslEnabled",
				this.sslEnabled).append("createdAt", this.createdAt).append(
				"updatedAt", this.updatedAt).append("id", this.id).toString();
	}
}
