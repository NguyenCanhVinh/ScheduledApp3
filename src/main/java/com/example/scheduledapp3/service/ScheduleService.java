package com.example.scheduledapp3.service;

import com.example.scheduledapp3.entity.ScheduledTaskEntity;
import com.example.scheduledapp3.quartzJob.BootJob;
import com.example.scheduledapp3.repository.ScheduledTaskRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduledTaskRepository repo;

    @Autowired
    private Scheduler scheduler;

    private ScheduledTaskEntity scheduledTaskEntity;


    public void scheduleJobs() throws SchedulerException {
        List<ScheduledTaskEntity> cronSchedules = repo.findAll();
        for (ScheduledTaskEntity cronSchedule : cronSchedules) {
            // String cronExpression = cronSchedule.getCronExpression();

            JobDetail jobDetail = JobBuilder.newJob(BootJob.class)
                    .withIdentity("job_" + cronSchedule.getId())
                    .usingJobData("message", cronSchedule.getTask())
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger_" + cronSchedule.getId())
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronSchedule.getCronExpression()))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        }
    }
}

