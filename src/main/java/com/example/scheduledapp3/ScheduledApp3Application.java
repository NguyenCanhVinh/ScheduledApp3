package com.example.scheduledapp3;

import com.example.scheduledapp3.entity.ScheduledTaskEntity;
import com.example.scheduledapp3.quartzJob.BootJob;
import com.example.scheduledapp3.service.ScheduleService;
import com.example.scheduledapp3.service.ScheduledTaskService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ScheduledApp3Application implements CommandLineRunner {

	@Autowired
	private ScheduleService scheduleService;

	public static void main(String[] args) {
        SpringApplication.run(ScheduledApp3Application.class, args);

    }

	@Override
	public void run(String... args) throws Exception {
		scheduleService.scheduleJobs();
	}
}
