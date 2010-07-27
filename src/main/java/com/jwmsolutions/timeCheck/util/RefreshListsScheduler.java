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
public class RefreshListsScheduler {
	public Scheduler getNewSchedulerInstance() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		return scheduler;
	}

	public void startScheduler() {
		try {
			Scheduler scheduler = getNewSchedulerInstance();

			JobDetail jobDetail = new JobDetail("Refresh Lists Job", "REFRESH", RefreshListsJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("QRTZ_REFRESH_TRIGGER_NAME", "QRTZ_REFRESH_TRIGGER_GROUP");

			simpleTrigger.setStartTime(getStartTime());
//			simpleTrigger.setStartTime(new Date());
			Long repeatInterval = CoreObject.getConfig().getLong(Constants.QUARTZ_REFRESH_REPEAT_INTERVAL);
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
		c.add(Calendar.HOUR_OF_DAY, CoreObject.getConfig().getInt(Constants.QUARTZ_REFRESH_START_TIME));
		return c.getTime();
	}
}
