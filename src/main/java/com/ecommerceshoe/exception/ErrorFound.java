package com.ecommerceshoe.exception;

public class ErrorFound extends Exception {
  @Override
  public String getMessage()
  {
	return "insufficient balance";
}
  static final String MESSAGE="Email and Password Invalid";
  public String getMessage2()
  {
	return MESSAGE;
}
}
