package com.example.Rest.Swagger.Microservice.exception;

public class TaskNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Could not find searched Task";
  }
}
