package com.example.Rest.Swagger.Microservice.service;

import com.example.Rest.Swagger.Microservice.exception.TaskNotFoundException;
import com.example.Rest.Swagger.Microservice.model.Task;
import com.example.Rest.Swagger.Microservice.model.User;
import com.example.Rest.Swagger.Microservice.model.dto.TaskDTO;
import com.example.Rest.Swagger.Microservice.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository repository;
  private ModelMapper modelMapper = new ModelMapper();

  public List<TaskDTO> findAll() {
    return repository.findAll().stream()
        .map(task -> modelMapper.map(task, TaskDTO.class))
        .collect(Collectors.toList());
  }

  @Transactional
  public TaskDTO create(TaskDTO task) {
    Task newTask = modelMapper.map(task, Task.class);
    return modelMapper.map(repository.saveAndFlush(newTask), TaskDTO.class);
  }

  @Transactional
  public TaskDTO update(Integer id, TaskDTO task) {
    Task entity = getOneSafe(id);
    entity.setDescription(task.getDescription());
    entity.setCompleted(task.isCompleted());
    entity.setCompletionPercentage(task.getCompletionPercentage());
    if (task.getUser() != null) {
      entity.setUser(modelMapper.map(task.getUser(), User.class));
    } else {
      entity.setUser(null);
    }
    return modelMapper.map(entity, TaskDTO.class);
  }

  @Transactional
  public void delete(Integer id) {
    Task task = getOneSafe(id);
    repository.delete(task);
  }

  @Transactional
  public TaskDTO findById(Integer id) {
    return modelMapper
        .map(repository.findById(id).orElseThrow(TaskNotFoundException::new), TaskDTO.class);
  }

  public boolean checkIfTableIsEmpty() {
    Task task = repository.findFirstByOrderByIdAsc();
    return task == null;
  }

  @Override
  public TaskDTO findLast() {
    return modelMapper.map(repository.findFirstByOrderByIdDesc(), TaskDTO.class);
  }

  private Task getOneSafe(Integer id) {
    if (repository.existsById(id)) {
      return repository.getOne(id);
    } else {
      throw new TaskNotFoundException();
    }
  }
}
