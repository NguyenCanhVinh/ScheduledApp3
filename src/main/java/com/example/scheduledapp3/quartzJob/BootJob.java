package com.example.scheduledapp3.quartzJob;

import com.example.scheduledapp3.entity.ScheduledTaskEntity;
import com.example.scheduledapp3.repository.ScheduledTaskRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class BootJob implements Job {

    @Autowired
    private ScheduledTaskRepository repo;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = df.format(date);

        // Lấy thông tin về nội dung của job
        String message = context.getJobDetail().getJobDataMap().getString("message");

        // Thực hiện các tác vụ cần thực hiện khi job được chạy
        System.out.println("Thông Báo:" + dateString +"  "+  message);


//        List<ScheduledTaskEntity> cronSchedules = repo.findAll();
//        for (ScheduledTaskEntity cronSchedule : cronSchedules) {
//            String cronExpression = cronSchedule.getCronExpression();
//            CronTrigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity("trigger-" + cronSchedule.getId())
//                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
//                    .build();
//            Date nextFireTime = trigger.getNextFireTime();
//            if (nextFireTime != null && nextFireTime.before(new Date())) {
//                System.out.println("Nội dung: " + cronSchedule.getTask());
//            }
//        }

    }
}

