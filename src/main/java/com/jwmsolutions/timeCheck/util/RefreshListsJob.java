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

public class RefreshListsJob implements Job {
	private static final Logger log = Logger.getLogger(RefreshListsJob.class.getName());

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.log(Level.INFO, "Refreshing combos job execution START - " + new Date());

		CoreObject.getTodoForm().refreshCombos();
	}
}
