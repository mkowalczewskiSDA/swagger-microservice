package com.example.Rest.Swagger.Microservice.repository;

import com.example.Rest.Swagger.Microservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  Task findFirstByOrderByIdAsc();

  Task findFirstByOrderByIdDesc();

}
