package com.jwmsolutions.timeCheck.model;

import static com.jwmsolutions.timeCheck.CoreObject.getGlobalProperties;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.jwmsolutions.timeCheck.util.Constants;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampTodoItem extends BaseObject {
	private Integer id;
	private Integer todoListId;
	private String content;
	private Integer position;
	private String createdOn;
	private Integer creatorId;
	private Boolean completed;
	private Integer commentsCount;
	/*
	 * if the item has a responsible party
	 */
	private String responsiblePartyType;
	private Integer responsiblePartyId;
	/*
	 * if the item has been completed
	 */
	private String completedOn;
	private Integer completerId;

	public BasecampTodoItem() {
		super();
	}
	public BasecampTodoItem(Integer id, Integer todoListId, String content,
			Integer position, String createdOn, Integer creatorId,
			Boolean completed, Integer commentsCount,
			String responsiblePartyType, Integer responsiblePartyId,
			String completedOn, Integer completerId) {
		super();
		this.id = id;
		this.todoListId = todoListId;
		this.content = content;
		this.position = position;
		this.createdOn = createdOn;
		this.creatorId = creatorId;
		this.completed = completed;
		this.commentsCount = commentsCount;
		this.responsiblePartyType = responsiblePartyType;
		this.responsiblePartyId = responsiblePartyId;
		this.completedOn = completedOn;
		this.completerId = completerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTodoListId() {
		return todoListId;
	}
	public void setTodoListId(Integer todoListId) {
		this.todoListId = todoListId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Integer getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}
	public String getResponsiblePartyType() {
		return responsiblePartyType;
	}
	public void setResponsiblePartyType(String responsiblePartyType) {
		this.responsiblePartyType = responsiblePartyType;
	}
	public Integer getResponsiblePartyId() {
		return responsiblePartyId;
	}
	public void setResponsiblePartyId(Integer responsiblePartyId) {
		this.responsiblePartyId = responsiblePartyId;
	}
	public String getCompletedOn() {
		return completedOn;
	}
	public void setCompletedOn(String completedOn) {
		this.completedOn = completedOn;
	}
	public Integer getCompleterId() {
		return completerId;
	}
	public void setCompleterId(Integer completerId) {
		this.completerId = completerId;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampTodoItem)) {
			return false;
		}
		BasecampTodoItem rhs = (BasecampTodoItem) object;
		return new EqualsBuilder().append(this.position, rhs.position).append(
				this.completedOn, rhs.completedOn).append(
				this.responsiblePartyType, rhs.responsiblePartyType).append(
				this.creatorId, rhs.creatorId).append(this.commentsCount,
				rhs.commentsCount).append(this.datePatterns, rhs.datePatterns)
				.append(this.id, rhs.id).append(this.content, rhs.content)
				.append(this.createdOn, rhs.createdOn).append(this.todoListId,
						rhs.todoListId).append(this.responsiblePartyId,
						rhs.responsiblePartyId).append(this.completerId,
						rhs.completerId).append(this.completed, rhs.completed)
				.isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-364989633, 2097536063)
				.append(this.position).append(this.completedOn).append(
						this.responsiblePartyType).append(this.creatorId)
				.append(this.commentsCount).append(this.datePatterns).append(
						this.id).append(this.content).append(this.createdOn)
				.append(this.todoListId).append(this.responsiblePartyId)
				.append(this.completerId).append(this.completed).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("content", this.content)
				.append("completedOn", this.completedOn).append("todoListId",
						this.todoListId).append("position", this.position)
				.append("commentsCount", this.commentsCount).append(
						"createdOn", this.createdOn).append("completed",
						this.completed).append("responsiblePartyId",
						this.responsiblePartyId).append("responsiblePartyType",
						this.responsiblePartyType).append("creatorId",
						this.creatorId).append("completerId", this.completerId)
				.append("id", this.id).toString();
	}
}
