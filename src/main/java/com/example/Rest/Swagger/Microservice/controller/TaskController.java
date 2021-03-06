package com.example.Rest.Swagger.Microservice.controller;

import com.example.Rest.Swagger.Microservice.model.dto.TaskDTO;
import com.example.Rest.Swagger.Microservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @RequestMapping(method = RequestMethod.GET)
  public List<TaskDTO> findAll() {
    return taskService.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public TaskDTO create(@Valid @RequestBody TaskDTO dto) {
    return taskService.create(dto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public TaskDTO getById(@PathVariable Integer id) {
    return taskService.findById(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public TaskDTO update(@PathVariable Integer id, @RequestBody TaskDTO dto) {
    System.out.println(dto);
    return taskService.update(id, dto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Integer id) {
    taskService.delete(id);
  }
}
