package com.optimagrowth.license.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class ServiceConfig{

  @Value("${example.property}")
  private String exampleProperty;
    
  @Value("${redis.server}")
  private String redisServer="";

  @Value("${redis.port}")
  private String redisPort="";

  public String getExampleProperty() {return exampleProperty;}
  public String getRedisServer() {return redisServer;}
  public String getRedisPort() {return redisPort;}

  public void setExampleProperty(String exampleProperty) {this.exampleProperty = exampleProperty;}
  public void setRedisServer(String redisServer) {this.redisServer = redisServer;}
  public void setRedisPort(String redisPort) {this.redisPort = redisPort;}
  
}