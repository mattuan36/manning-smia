package com.optimagrowth.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component @Getter
public class ServiceConfig{

  @Value("${example.property}")
  private String exampleProperty;
  
  @Value("${signing.key}")
  private String jwtSigningKey="";
  
  @Value("${redis.server}")
  private String redisServer="";

  @Value("${redis.port}")
  private String redisPort="";

  public String getExampleProperty() {return exampleProperty;}
  public String getJwtSigningKey() {return jwtSigningKey;}
  public String getRedisServer() {return redisServer;}
  public String getRedisPort() {return redisPort;}
  public void setExampleProperty(String exampleProperty) {this.exampleProperty = exampleProperty;}
  public void setJwtSigningKey(String jwtSigningKey) {this.jwtSigningKey = jwtSigningKey;}
  public void setRedisServer(String redisServer) {this.redisServer = redisServer;}
  public void setRedisPort(String redisPort) {this.redisPort = redisPort;}
  
}