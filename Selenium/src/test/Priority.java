package test;

import org.testng.annotations.Test;

public class Priority {
  @Test(priority=2)
  public void car() {
	  
	  System.out.println("car is running");
  }
  @Test(priority=1)
  public void bike()
  {
	  System.out.println("bike is running");
  }
  @Test(priority=3)
  public void train()
  {
	  System.out.println("train is running");
  }
}
