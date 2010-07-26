package com.jwmsolutions.timeCheck.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampCompany extends BaseObject {
	private Integer id;
	private String name;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String webAddress;
	private String phoneNumberOffice;
	private String phoneNumberFax;
	private String timeZoneId;
	private Boolean canSeePrivate;
	/*
	 * for non-client companies
	 */
	private String urlName;


	public BasecampCompany() {
		super();
	}
	public BasecampCompany(Integer id, String name, String addressOne,
			String addressTwo, String city, String state, String zip,
			String country, String webAddress, String phoneNumberOffice,
			String phoneNumberFax, String timeZoneId, Boolean canSeePrivate,
			String urlName) {
		super();
		this.id = id;
		this.name = name;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.webAddress = webAddress;
		this.phoneNumberOffice = phoneNumberOffice;
		this.phoneNumberFax = phoneNumberFax;
		this.timeZoneId = timeZoneId;
		this.canSeePrivate = canSeePrivate;
		this.urlName = urlName;
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
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public String getPhoneNumberOffice() {
		return phoneNumberOffice;
	}
	public void setPhoneNumberOffice(String phoneNumberOffice) {
		this.phoneNumberOffice = phoneNumberOffice;
	}
	public String getPhoneNumberFax() {
		return phoneNumberFax;
	}
	public void setPhoneNumberFax(String phoneNumberFax) {
		this.phoneNumberFax = phoneNumberFax;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	public Boolean getCanSeePrivate() {
		return canSeePrivate;
	}
	public void setCanSeePrivate(Boolean canSeePrivate) {
		this.canSeePrivate = canSeePrivate;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampCompany)) {
			return false;
		}
		BasecampCompany rhs = (BasecampCompany) object;
		return new EqualsBuilder().append(this.zip, rhs.zip).append(
				this.addressOne, rhs.addressOne).append(this.phoneNumberFax,
				rhs.phoneNumberFax).append(this.webAddress, rhs.webAddress)
				.append(this.state, rhs.state)
				.append(this.urlName, rhs.urlName).append(this.datePatterns,
						rhs.datePatterns).append(this.city, rhs.city).append(
						this.country, rhs.country).append(this.id, rhs.id)
				.append(this.addressTwo, rhs.addressTwo).append(this.name,
						rhs.name).append(this.phoneNumberOffice,
						rhs.phoneNumberOffice).append(this.canSeePrivate,
						rhs.canSeePrivate).append(this.timeZoneId,
						rhs.timeZoneId).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(2013031867, -1974204523).append(this.zip)
				.append(this.addressOne).append(this.phoneNumberFax).append(
						this.webAddress).append(this.state)
				.append(this.urlName).append(this.datePatterns).append(
						this.city).append(this.country).append(this.id).append(
						this.addressTwo).append(this.name).append(
						this.phoneNumberOffice).append(this.canSeePrivate)
				.append(this.timeZoneId).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("state", this.state).append(
				"webAddress", this.webAddress).append("urlName", this.urlName)
				.append("timeZoneId", this.timeZoneId).append("addressOne",
						this.addressOne).append("phoneNumberOffice",
						this.phoneNumberOffice).append("phoneNumberFax",
						this.phoneNumberFax).append("zip", this.zip).append(
						"addressTwo", this.addressTwo)
				.append("name", this.name).append("country", this.country)
				.append("canSeePrivate", this.canSeePrivate).append("city",
						this.city).append("id", this.id).toString();
	}
}
