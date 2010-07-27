package com.jwmsolutions.timeCheck.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampTimeEntry extends BaseObject {
	private Integer id;
	private Integer projectId;
	private Integer personId;
	private String date;
	private String hours;
	private String description;
	private Integer todoItemId;

	public BasecampTimeEntry() {
		super();
	}
	public BasecampTimeEntry(Integer id, Integer projectId, Integer personId,
			String date, String hours, String description, Integer todoItemId) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.personId = personId;
		this.date = date;
		this.hours = hours;
		this.description = description;
		this.todoItemId = todoItemId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTodoItemId() {
		return todoItemId;
	}
	public void setTodoItemId(Integer todoItemId) {
		this.todoItemId = todoItemId;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampTimeEntry)) {
			return false;
		}
		BasecampTimeEntry rhs = (BasecampTimeEntry) object;
		return new EqualsBuilder().append(this.id, rhs.id).append(
				this.description, rhs.description)
				.append(this.hours, rhs.hours).append(this.personId,
						rhs.personId).append(this.datePatterns,
						rhs.datePatterns).append(this.projectId, rhs.projectId)
				.append(this.date, rhs.date).append(this.todoItemId,
						rhs.todoItemId).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-2069257413, -1201705141).append(this.id)
				.append(this.description).append(this.hours).append(
						this.personId).append(this.datePatterns).append(
						this.projectId).append(this.date).append(
						this.todoItemId).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("date", this.date).append(
				"personId", this.personId).append("description",
				this.description).append("todoItemId", this.todoItemId).append(
				"hours", this.hours).append("projectId", this.projectId)
				.append("id", this.id).toString();
	}
}
