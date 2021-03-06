package com.example.Rest.Swagger.Microservice.service;


import com.example.Rest.Swagger.Microservice.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {

  List<TaskDTO> findAll();

  TaskDTO create(TaskDTO task);

  TaskDTO update(Integer id, TaskDTO task);

  void delete(Integer id);

  TaskDTO findById(Integer id);

  boolean checkIfTableIsEmpty();

  TaskDTO findLast();

}
