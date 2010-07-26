package com.jwmsolutions.timeCheck.model;

import java.util.ArrayList;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class TodoListArrayList extends ArrayList<BasecampTodoList> {
	public void addTodoList(BasecampTodoList o) {
		this.add(o);
	}
}
