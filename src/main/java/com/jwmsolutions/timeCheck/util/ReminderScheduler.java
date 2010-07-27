package com.jwmsolutions.timeCheck.util;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import com.jwmsolutions.timeCheck.CoreObject;
/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class ReminderScheduler {
	public Scheduler getNewSchedulerInstance() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		return scheduler;
	}

	public void startScheduler() {
		try {
			Scheduler scheduler = getNewSchedulerInstance();

			JobDetail jobDetail = new JobDetail("Reminder Job", "DEFAULT", ReminderJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("QRTZ_FAILED_JOB_ORIG_TRIGGER_NAME", "QRTZ_FAILED_JOB_ORIG_TRIGGER_GROUP");

			simpleTrigger.setStartTime(getStartTime());
//			simpleTrigger.setStartTime(new Date());
			Long repeatInterval = CoreObject.getConfig().getLong(Constants.QUARTZ_REMINDER_REPEAT_INTERVAL);
			if(repeatInterval.longValue() > Constants.QUARTZ_MAX_REPEAT_INTERVAL_TIME) {
				repeatInterval = Constants.QUARTZ_MAX_REPEAT_INTERVAL_TIME;
			}
			simpleTrigger.setRepeatInterval(repeatInterval);
			simpleTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);

			scheduler.scheduleJob(jobDetail, simpleTrigger);

			scheduler.start();
		} catch (SchedulerException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
	}

	private Date getStartTime() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR_OF_DAY, CoreObject.getConfig().getInt(Constants.QUARTZ_REMINDER_START_TIME));
		return c.getTime();
	}
}
