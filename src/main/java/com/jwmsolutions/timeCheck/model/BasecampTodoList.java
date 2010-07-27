package com.jwmsolutions.timeCheck.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampTodoList extends BaseObject {
	private Integer id;
	private String name;
	private String description;
	private Integer projectId;
	private Integer milestoneId;
	private Integer position;
	private Integer completedCount;
	private Integer uncompletedCount;

	/*
	 * if user can see private lists
	 */
	private Boolean _private;
	/*
	 * if the account supports time tracking
	 */
	private Boolean tracked;
	/*
	 * if todo-items are included in the response
	 */
	BasecampTodoItems todoItems;

	public BasecampTodoList() {
		super();
	}
	public BasecampTodoList(Integer id, String name, String description,
			Integer projectId, Integer milestoneId, Integer position,
			Integer completedCount, Integer uncompletedCount, Boolean private1,
			Boolean tracked, BasecampTodoItems todoItems) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.projectId = projectId;
		this.milestoneId = milestoneId;
		this.position = position;
		this.completedCount = completedCount;
		this.uncompletedCount = uncompletedCount;
		_private = private1;
		this.tracked = tracked;
		this.todoItems = todoItems;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(Integer milestoneId) {
		this.milestoneId = milestoneId;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getCompletedCount() {
		return completedCount;
	}
	public void setCompletedCount(Integer completedCount) {
		this.completedCount = completedCount;
	}
	public Integer getUncompletedCount() {
		return uncompletedCount;
	}
	public void setUncompletedCount(Integer uncompletedCount) {
		this.uncompletedCount = uncompletedCount;
	}
	public Boolean get_private() {
		return _private;
	}
	public void set_private(Boolean private1) {
		_private = private1;
	}
	public Boolean getTracked() {
		return tracked;
	}
	public void setTracked(Boolean tracked) {
		this.tracked = tracked;
	}
	public BasecampTodoItems getTodoItems() {
		return todoItems;
	}
	public void setTodoItems(BasecampTodoItems todoItems) {
		this.todoItems = todoItems;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampTodoList)) {
			return false;
		}
		BasecampTodoList rhs = (BasecampTodoList) object;
		return new EqualsBuilder().append(this.position, rhs.position).append(
				this.id, rhs.id)
				.append(this.completedCount, rhs.completedCount).append(
						this._private, rhs._private).append(this.description,
						rhs.description).append(this.name, rhs.name).append(
						this.tracked, rhs.tracked).append(this.datePatterns,
						rhs.datePatterns).append(this.projectId, rhs.projectId)
				.append(this.todoItems, rhs.todoItems).append(
						this.uncompletedCount, rhs.uncompletedCount).append(
						this.milestoneId, rhs.milestoneId).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1964349729, 49822203).append(this.position)
				.append(this.id).append(this.completedCount).append(
						this._private).append(this.description).append(
						this.name).append(this.tracked).append(
						this.datePatterns).append(this.projectId).append(
						this.todoItems).append(this.uncompletedCount).append(
						this.milestoneId).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("todoItems", this.todoItems)
				.append("description", this.description).append("tracked",
						this.tracked).append("name", this.name).append(
						"completedCount", this.completedCount).append(
						"milestoneId", this.milestoneId).append("_private",
						this._private).append("uncompletedCount",
						this.uncompletedCount)
				.append("position", this.position).append("projectId",
						this.projectId).append("id", this.id).toString();
	}
}
