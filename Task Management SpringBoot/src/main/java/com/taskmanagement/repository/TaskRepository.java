package com.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taskmanagement.entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
