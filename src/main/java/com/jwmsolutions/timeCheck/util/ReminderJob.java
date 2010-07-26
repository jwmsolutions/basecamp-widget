package com.jwmsolutions.timeCheck.util;


import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_COMPLETED_ITEM_TAG;

import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.model.BasecampTodoItem;

public class ReminderJob implements Job {
	private static final Logger log = Logger.getLogger(ReminderJob.class.getName());

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.log(Level.INFO, "Informacion al usuario - " + new Date());

		StringBuffer message = new StringBuffer("Do you have some uncompleted To-do items: ");
		int size = message.toString().length();
		Iterator<Entry<String, BasecampTodoItem>> it = CoreObject.getTodoMap().entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, BasecampTodoItem> e = it.next();
			if(!StringUtils.containsIgnoreCase(e.getKey(), CoreObject.getConfig().getString(CONFIG_COMPLETED_ITEM_TAG))) {
				message.append("\n" + e.getValue().getId() + ": " + e.getKey());
			}
		}
		if(message.toString().length() > size) {
			String title = "Reminder...";
			int messageType = JOptionPane.WARNING_MESSAGE;
			CoreObject.getTodoForm().setVisible(true);
			JOptionPane.showMessageDialog(CoreObject.getTodoForm(), message.toString(), title, messageType);
		}
	}
}
