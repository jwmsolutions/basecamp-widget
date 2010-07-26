package com.jwmsolutions.timeCheck.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampTodoItems extends BaseObject {
	TodoItemsArrayList todoItem = new TodoItemsArrayList();

	public TodoItemsArrayList getTodoItems() {
		return todoItem;
	}
	public void setTodoItems(TodoItemsArrayList todoItems) {
		this.todoItem = todoItems;
	}

	public void addTodoItem(BasecampTodoItem o) {
		this.todoItem.add(o);
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampTodoItems)) {
			return false;
		}
		BasecampTodoItems rhs = (BasecampTodoItems) object;
		return new EqualsBuilder().append(this.datePatterns, rhs.datePatterns)
				.append(this.todoItem, rhs.todoItem).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(210678975, 706302559).append(
				this.datePatterns).append(this.todoItem).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("todoItems",
				this.getTodoItems()).toString();
	}
}
