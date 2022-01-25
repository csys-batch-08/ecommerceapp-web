package com.ecommerceshoe.exception;

public class ErrorFound extends Exception {
  @Override
  public String getMessage()
  {
	return "insufficient balance";
}
  public String getMessage2()
  {
	return "Email and Password Invalid";
}
}
