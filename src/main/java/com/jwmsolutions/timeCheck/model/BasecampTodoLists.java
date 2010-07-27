package com.jwmsolutions.timeCheck.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampTodoLists  extends BaseObject {
	TodoListArrayList todoList = new TodoListArrayList();

	public TodoListArrayList getTodoLists() {
		return todoList;
	}
	public void setTodoLists(TodoListArrayList todoList) {
		this.todoList = todoList;
	}

	public void addTodoList(BasecampTodoList obj) {
		this.todoList.add(obj);
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampTodoLists)) {
			return false;
		}
		BasecampTodoLists rhs = (BasecampTodoLists) object;
		return new EqualsBuilder().append(this.todoList, rhs.todoList)
				.append(this.datePatterns, rhs.datePatterns).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1246008087, -1357355633).append(
				this.todoList).append(this.datePatterns).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("todoLists", this.todoList)
				.toString();
	}
}
