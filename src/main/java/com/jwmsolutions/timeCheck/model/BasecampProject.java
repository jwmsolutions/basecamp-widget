package com.jwmsolutions.timeCheck.model;

import static com.jwmsolutions.timeCheck.CoreObject.getGlobalProperties;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.jwmsolutions.timeCheck.util.Constants;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BasecampProject extends BaseObject {
	private Integer id;
	private String name;
	private String createdOn;
	private String status;
	private String lastChangedOn;
	private BasecampCompany company;
	/*
	 * if user is administrator
	 */
	private String announcement;
	private Integer startPage;
	private Boolean showWriteboards;
	private Boolean showAnnouncement;

	public BasecampProject() {
		super();
	}
	public BasecampProject(Integer id, String name, String createdOn,
			String status, String lastChangedOn, BasecampCompany company,
			String announcement, Integer startPage, Boolean showWriteboards,
			Boolean showAnnouncement) {
		super();
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.status = status;
		this.lastChangedOn = lastChangedOn;
		this.company = company;
		this.announcement = announcement;
		this.startPage = startPage;
		this.showWriteboards = showWriteboards;
		this.showAnnouncement = showAnnouncement;
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
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastChangedOn() {
		return lastChangedOn;
	}
	public void setLastChangedOn(String lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}
	public BasecampCompany getCompany() {
		return company;
	}
	public void setCompany(BasecampCompany company) {
		this.company = company;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Boolean getShowWriteboards() {
		return showWriteboards;
	}
	public void setShowWriteboards(Boolean showWriteboards) {
		this.showWriteboards = showWriteboards;
	}
	public Boolean getShowAnnouncement() {
		return showAnnouncement;
	}
	public void setShowAnnouncement(Boolean showAnnouncement) {
		this.showAnnouncement = showAnnouncement;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampProject)) {
			return false;
		}
		BasecampProject rhs = (BasecampProject) object;
		return new EqualsBuilder().append(this.createdOn, rhs.createdOn)
				.append(this.id, rhs.id).append(this.announcement,
						rhs.announcement).append(this.status, rhs.status)
				.append(this.company, rhs.company).append(this.name, rhs.name)
				.append(this.datePatterns, rhs.datePatterns).append(
						this.showAnnouncement, rhs.showAnnouncement).append(
						this.showWriteboards, rhs.showWriteboards).append(
						this.startPage, rhs.startPage).append(
						this.lastChangedOn, rhs.lastChangedOn).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1003739465, 533627693)
				.append(this.createdOn).append(this.id).append(
						this.announcement).append(this.status).append(
						this.company).append(this.name).append(
						this.datePatterns).append(this.showAnnouncement)
				.append(this.showWriteboards).append(this.startPage).append(
						this.lastChangedOn).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("status", this.status).append(
				"startPage", this.startPage).append("company", this.company)
				.append("announcement", this.announcement).append(
						"lastChangedOn", this.lastChangedOn).append("name",
						this.name).append("showAnnouncement",
						this.showAnnouncement).append("showWriteboards",
						this.showWriteboards).append("createdOn",
						this.createdOn).append("id", this.id).toString();
	}
}
