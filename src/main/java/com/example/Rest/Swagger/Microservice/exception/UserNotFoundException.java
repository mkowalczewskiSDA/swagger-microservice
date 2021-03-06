package com.example.Rest.Swagger.Microservice.exception;

public class UserNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Could not find searched User";
  }

}
