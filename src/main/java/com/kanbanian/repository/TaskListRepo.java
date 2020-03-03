package com.kanbanian.repository;

import com.kanbanian.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface TaskListRepo extends JpaRepository<TaskList, Id> {
}
