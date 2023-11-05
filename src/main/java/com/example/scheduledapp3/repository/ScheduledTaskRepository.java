package com.example.scheduledapp3.repository;

import com.example.scheduledapp3.entity.ScheduledTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledTaskRepository extends JpaRepository<ScheduledTaskEntity, Long> {

}
